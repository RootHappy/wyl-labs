package com.wyl.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangyunlong on 17/4/10.
 */
public class TestCache {

    public static void main(String[] args) {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .removalListener(new MyRemoveListener<String, String>())
                .build();
        try {
            System.out.println(cache.get("key", new MyCacheLoader()));
            Thread.sleep(6000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(cache.getIfPresent("key"));
    }
}
