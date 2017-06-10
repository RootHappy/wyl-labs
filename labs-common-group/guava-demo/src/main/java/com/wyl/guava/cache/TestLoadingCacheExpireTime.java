package com.wyl.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangyunlong on 17/4/10.
 */
public class TestLoadingCacheExpireTime {

    public static void main(String[] args) {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.SECONDS)
                .removalListener(new MyRemoveListener<String, String>())
                .build(new MyCacheLoader());
        try {
            System.out.println(cache.get("wang"));
            Thread.sleep(1000);
            System.out.println(cache.get("wang"));
            Thread.sleep(6000);
            System.out.println(cache.get("wang"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
