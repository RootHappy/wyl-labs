package com.wyl.guava.cache;

import com.google.common.cache.CacheLoader;

import java.util.concurrent.Callable;

/**
 * Created by wangyunlong on 17/4/10.
 */
public class MyCacheLoader extends CacheLoader<String, String> implements Callable<String> {

    public String load(String key) throws Exception {
        System.out.println("Load... key " + key);
        return generateValue(key);
    }

    private String generateValue(String key) {
        return key + "-" + key.hashCode();
    }

    public String call() throws Exception {
        System.out.println("Load... ");
        return "call-" + "call".hashCode();
    }
}
