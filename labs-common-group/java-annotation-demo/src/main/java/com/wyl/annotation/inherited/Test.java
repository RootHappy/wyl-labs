package com.wyl.annotation.inherited;

/**
 * Created by wangyunlong on 17/4/20.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(new ClassA().getClass().getAnnotation(InheritedAnnotationType.class));
        System.out.println(new ClassB().getClass().getAnnotation(InheritedAnnotationType.class));
        System.out.println(new ClassC().getClass().getAnnotation(InheritedAnnotationType.class));
        System.out.println("_________________________________");
        System.out.println(new ClassA().getClass().getAnnotation(UninheritedAnnotationType.class));
        System.out.println(new ClassB().getClass().getAnnotation(UninheritedAnnotationType.class));
        System.out.println(new ClassC().getClass().getAnnotation(UninheritedAnnotationType.class));
    }
}
