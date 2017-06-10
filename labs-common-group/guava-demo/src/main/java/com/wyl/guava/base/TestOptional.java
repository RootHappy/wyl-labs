package com.wyl.guava.base;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * Created by wangyunlong on 17/4/13.
 */
public class TestOptional {

    public static void main(String[] args) {
//        1. java.util.Optional
        Optional<Integer> value = Optional.of(100);
        if (value.isPresent()) {
            System.out.println("java.util.Optional: " + value.get());
        }

        OptionalInt iValue = OptionalInt.of(1);
        if (iValue.isPresent()) {
            System.out.println("java.util.OptionalInteger: " + iValue.getAsInt());
        }

//        2. com.google.common.base.Optional
        com.google.common.base.Optional<Integer> gValue = com.google.common.base.Optional.of(1000);
        if (gValue.isPresent()) {
            System.out.println("com.google.common.base.Optional: " + gValue.get());
        }
    }
}
