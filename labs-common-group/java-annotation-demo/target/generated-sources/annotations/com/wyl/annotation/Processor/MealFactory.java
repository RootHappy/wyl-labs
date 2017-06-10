package com.wyl.annotation.Processor;


public class MealFactory {

  public Meal create(String id) {
    if (id == null) {
      throw new IllegalArgumentException("id is null");
    }
    if ("Calzone".equals(id)) {
      return new com.wyl.annotation.Processor.CalzonePizza();
    }

    if ("Tiramisu".equals(id)) {
      return new com.wyl.annotation.Processor.Tiramisu();
    }

    if ("Margherita".equals(id)) {
      return new com.wyl.annotation.Processor.MargheritaPizza();
    }

    throw new IllegalArgumentException("Unknown id = " + id);
  }
}
