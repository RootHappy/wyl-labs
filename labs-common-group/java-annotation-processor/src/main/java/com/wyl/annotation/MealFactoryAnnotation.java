package com.wyl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wangyunlong on 17/4/23.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface MealFactoryAnnotation {

    Class type();

    String id();
}
