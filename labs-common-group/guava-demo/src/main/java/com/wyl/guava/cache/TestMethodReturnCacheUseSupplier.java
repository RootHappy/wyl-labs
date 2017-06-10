package com.wyl.guava.cache;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangyunlong on 17/4/10.
 */
public class TestMethodReturnCacheUseSupplier {


    public static void main(String[] args) {
        TestMethodReturnCacheUseSupplier test = new TestMethodReturnCacheUseSupplier();
        System.out.println(test.getValue());
        try {
            Thread.sleep(2000);
            System.out.println(test.getValue());
            Thread.sleep(4000);
            System.out.println(test.getValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private final Supplier<List<String>> cache = Suppliers.memoizeWithExpiration(new Supplier<List<String>>() {
        public List<String> get() {
            return loadFromDB();
        }
    }, 5, TimeUnit.SECONDS);

    public List<String> getValue() {
        return cache.get();
    }

    private List<String> loadFromDB() {
        System.out.println("load from db");
        List<String> dataArrayList = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
        return dataArrayList;
    }
}
