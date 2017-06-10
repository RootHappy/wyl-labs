package com.wyl.cache;

import org.springframework.cache.annotation.Cacheable;

/**
 * Created by wangyunlong on 17/4/11.
 */
public class test {

    public static void main(String[] args) {

    }

    @Cacheable
    public String test(String value) {
        return value;
    }
}
