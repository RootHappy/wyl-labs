package com.wyl.guava.cache;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/**
 * Created by wangyunlong on 17/4/10.
 */
public class MyRemoveListener<K, V> implements RemovalListener<K, V> {
    public void onRemoval(RemovalNotification<K, V> notification) {
        System.out.println("[Remove Listener] key " + notification.getKey() + "; value " + notification.getValue() + "; cause " + notification.getCause());
    }
}
