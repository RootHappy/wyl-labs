package com.wyl.annotation.processor;

import com.google.auto.service.AutoService;
import com.wyl.annotation.MealFactoryAnnotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangyunlong on 17/4/21.
 */
@AutoService(Processor.class)
public class MealFactoryAnnotationProcessor extends AbstractProcessor {

    private Types typeUtils;
    private Elements elementUtils;
    private Filer filter;
    private Messager messager;
    private Map<String, FactoryGroupedClasses> factoryClasses = new LinkedHashMap<>();

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        typeUtils = processingEnv.getTypeUtils();
        elementUtils = processingEnv.getElementUtils();
        filter = processingEnv.getFiler();
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(MealFactoryAnnotation.class)) {
            if (annotatedElement.getKind() != ElementKind.CLASS) {
                error(annotatedElement, "Only classes can be annotated with @%s", MealFactoryAnnotation.class.getSimpleName());
                return true;
            }
            TypeElement typeElement = (TypeElement) annotatedElement;
            try {
                FactoryAnnotatedClass annotatedClass = new FactoryAnnotatedClass(typeElement);
                if (!isValidClass(annotatedClass)) {
                    return true;
                }

                FactoryGroupedClasses factoryClass = factoryClasses.get(annotatedClass.getQualifiedFactoryGroupName());
                if (factoryClass == null) {
                    String qualifiedGroupName = annotatedClass.getQualifiedFactoryGroupName();
                    factoryClass = new FactoryGroupedClasses(qualifiedGroupName);
                    factoryClasses.put(qualifiedGroupName, factoryClass);
                }
                factoryClass.add(annotatedClass);
            } catch (IllegalArgumentException e) {
                error(typeElement, e.getMessage());
                return true;
            } catch (IdAlreadyUsedException e) {
                FactoryAnnotatedClass existing =  e.getExisting();
                error(annotatedElement, "Conflict: The class %s is annotated with @%s with id ='%s' but %s already uses the same id",
                        typeElement.getQualifiedName().toString(), MealFactoryAnnotation.class.getSimpleName(),
                        existing.getTypeElement().getQualifiedName().toString());
                return true;
            }
        }

        try {
            for (FactoryGroupedClasses factoryClass : factoryClasses.values()) {
                factoryClass.generateCode(elementUtils, filter);
            }
            factoryClasses.clear();
        } catch (IOException e) {
            error(null, e.getMessage());
        }

        return true;
    }

    private boolean isValidClass(FactoryAnnotatedClass item) {
        TypeElement classElement = item.getTypeElement();
        if (!classElement.getModifiers().contains(Modifier.PUBLIC)) {
            error(classElement, "The class %s is not public.", classElement.getQualifiedName().toString());
            return false;
        }
        if (classElement.getModifiers().contains(Modifier.ABSTRACT)) {
            error(classElement, "The class %s is abstract.You can't annotate abstract classes with @%s",
                    classElement.getQualifiedName().toString(), MealFactoryAnnotation.class.getSimpleName());
            return false;
        }

        TypeElement supperClassElement = elementUtils.getTypeElement(item.getQualifiedFactoryGroupName());
        if (supperClassElement.getKind() == ElementKind.INTERFACE) {
            if (!classElement.getInterfaces().contains(supperClassElement.asType())) {
                error(classElement, "The class %s annotated with %s must implement the interface %s",
                        classElement.getQualifiedName().toString(), MealFactoryAnnotation.class.getSimpleName(),
                        item.getQualifiedFactoryGroupName());
                return false;
            }
        } else {
            TypeElement currentElement = classElement;
            while (true) {
                TypeMirror supperClassType = currentElement.getSuperclass();
                if (supperClassType.getKind() == TypeKind.NONE) {
                    error(classElement, "The class %s annotated with %s must inherit from %s",
                            classElement.getQualifiedName().toString(), MealFactoryAnnotation.class.getSimpleName(),
                            item.getQualifiedFactoryGroupName());
                    return false;
                }

                if (supperClassType.toString().equals(item.getQualifiedFactoryGroupName())) {
                    break;
                }
                currentElement = (TypeElement) typeUtils.asElement(supperClassType);
            }
        }

        for (Element enclosed : classElement.getEnclosedElements()) {
            if (enclosed.getKind() == ElementKind.CONSTRUCTOR) {
                ExecutableElement constructorElement = (ExecutableElement) enclosed;
                if (constructorElement.getParameters().size() == 0
                        && constructorElement.getModifiers().contains(Modifier.PUBLIC)) {
                    return true;
                }
            }
        }
        error(classElement, "The class %s must provide an public empty default constructor",
                classElement.getQualifiedName().toString());
        return false;
    }


    private void error(Element element, String msg, Object... args) {
        messager.printMessage(Diagnostic.Kind.ERROR, String.format(msg, args), element);
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(MealFactoryAnnotation.class.getCanonicalName());
        return annotations;
    }
}
