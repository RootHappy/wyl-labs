package com.wyl.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangyunlong on 17/4/10.
 */
public class TestLoadingCacheMaxSize {

    public static void main(String[] args) {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(5)
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .removalListener(new MyRemoveListener<String, String>())
                .build(new MyCacheLoader());

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(cache.get("key" + i));
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("===========================");

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 9; i > 0; i--) {
            try {
                System.out.println(cache.get("key" + i));
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
