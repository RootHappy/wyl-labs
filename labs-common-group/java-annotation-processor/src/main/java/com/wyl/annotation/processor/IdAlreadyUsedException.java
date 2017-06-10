package com.wyl.annotation.processor;

/**
 * Created by wangyunlong on 17/4/23.
 */
public class IdAlreadyUsedException extends RuntimeException{

    private FactoryAnnotatedClass existing;

    public IdAlreadyUsedException(FactoryAnnotatedClass existing) {
        this.existing = existing;
    }

    public FactoryAnnotatedClass getExisting() {
        return existing;
    }
}
