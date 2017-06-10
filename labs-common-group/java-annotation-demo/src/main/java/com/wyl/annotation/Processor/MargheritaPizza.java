package com.wyl.annotation.Processor;

import com.wyl.annotation.MealFactoryAnnotation;

/**
 * Created by wangyunlong on 17/4/23.
 */
@MealFactoryAnnotation(
        id = "Margherita",
        type = Meal.class
)
public class MargheritaPizza implements Meal {
    @Override
    public float getPrice() {
        return 6.0f;
    }
}
