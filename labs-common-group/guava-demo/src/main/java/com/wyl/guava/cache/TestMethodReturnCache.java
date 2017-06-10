package com.wyl.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangyunlong on 17/4/10.
 */
public class TestMethodReturnCache {

    private static final int DEFAULT_EXPIRE_TIME = 5;
    private static LoadingCache<String, String> cache;

    public TestMethodReturnCache() {
        cache = CacheBuilder.newBuilder().expireAfterWrite(DEFAULT_EXPIRE_TIME, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return generateValue(key);
            }
        });
    }


    public static void main(String[] args) {
        TestMethodReturnCache test = new TestMethodReturnCache();

        for (int i = 0; i < 10; i++) {
            System.out.println(test.getValue("key" + i));
        }

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(test.getValue("key" + i));
        }

    }

    public String getValue(String key) {
        try {
            return cache.get(key);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String generateValue(String key) {
        System.out.println("load... key " + key);
        return key + "-" + key.hashCode();
    }


}
