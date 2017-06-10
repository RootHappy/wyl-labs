package com.wyl.annotation.Processor;

import com.wyl.annotation.MealFactoryAnnotation;

/**
 * Created by wangyunlong on 17/4/23.
 */
@MealFactoryAnnotation(
        id = "Tiramisu",
        type = Meal.class
)
public class Tiramisu implements Meal {
    @Override
    public float getPrice() {
        return 4.5f;
    }
}
