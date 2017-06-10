package com.wyl.annotation.Processor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by wangyunlong on 17/4/23.
 */
public class PizzaStore {

    private MealFactory factory = new MealFactory();

    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore();
        Meal meal = pizzaStore.order(readConsole());
        System.out.println("Bill: $" + meal.getPrice());
    }

    public Meal order(String mealName) {
        return factory.create(mealName);
    }

    private static String readConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
