package com.wyl.guava.base;

import com.google.common.base.Preconditions;

/**
 * Created by wangyunlong on 17/4/13.
 */
public class TestPreconditions {

    public static void main(String[] args) {
        String value1  = "value1";
        System.out.println(Preconditions.checkNotNull(value1));
        Preconditions.checkArgument(args != null);
        int i = 5;
        Preconditions.checkState(i > 0);
        Preconditions.checkElementIndex(0, 10);
        Preconditions.checkElementIndex(-1, 10);
    }
}
