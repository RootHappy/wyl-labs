package com.wyl.annotation.Processor;

import com.wyl.annotation.MealFactoryAnnotation;

/**
 * Created by wangyunlong on 17/4/23.
 */
@MealFactoryAnnotation(
        id = "Calzone",
        type = Meal.class
)
public class CalzonePizza implements Meal {
    @Override
    public float getPrice() {
        return 8.5f;
    }
}
