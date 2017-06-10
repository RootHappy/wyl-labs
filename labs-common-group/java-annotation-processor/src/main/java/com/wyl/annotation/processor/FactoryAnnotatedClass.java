package com.wyl.annotation.processor;

import com.google.common.base.Strings;
import com.wyl.annotation.MealFactoryAnnotation;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.MirroredTypeException;

/**
 * Created by wangyunlong on 17/4/23.
 */
public class FactoryAnnotatedClass {
    private TypeElement annotatedClassElement;
    private String qualifiedSupperClassName;
    private String simpleTypeName;
    private String id;

    public FactoryAnnotatedClass(TypeElement classElement) throws IllegalArgumentException{
        this.annotatedClassElement = classElement;
        MealFactoryAnnotation annotation = classElement.getAnnotation(MealFactoryAnnotation.class);
        id = annotation.id();
        if (Strings.isNullOrEmpty(id)) {
            throw new IllegalArgumentException(String.format("id() in %s for class %s is null or empty! that's not allowed",
                    MealFactoryAnnotation.class.getSimpleName(), classElement.getQualifiedName().toString()));
        }
        try {
            Class clazz = annotation.type();
            qualifiedSupperClassName = clazz.getCanonicalName();
            simpleTypeName = clazz.getSimpleName();
        } catch (MirroredTypeException mte) {
            DeclaredType classTypeMirror = (DeclaredType) mte.getTypeMirror();
            TypeElement classTypeElement = (TypeElement) classTypeMirror.asElement();
            qualifiedSupperClassName = classTypeElement.getQualifiedName().toString();
            simpleTypeName = classTypeElement.getSimpleName().toString();
        }
    }

    public String getId() {
        return this.id;
    }

    public String getQualifiedFactoryGroupName() {
        return this.qualifiedSupperClassName;
    }

    public String getSimpleFactoryGroupName() {
        return this.simpleTypeName;
    }

    public TypeElement getTypeElement() {
        return this.annotatedClassElement;
    }
}
