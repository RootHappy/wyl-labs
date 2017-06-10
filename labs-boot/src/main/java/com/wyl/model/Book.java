package com.wyl.model;

/**
 * Created by wangyunlong on 17/5/26.
 */
public class Book {
    private String name;
    private float price;
    private boolean available;

    public Book(String name, float price, boolean flag) {
        this.name = name;
        this.price = price;
        this.available = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
