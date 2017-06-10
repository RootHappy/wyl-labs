package com.wyl.refactor.one.price;

import com.wyl.refactor.one.Movie;

/**
 * Created by wangyunlong on 17/4/7.
 */
public class ChildrensPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}
