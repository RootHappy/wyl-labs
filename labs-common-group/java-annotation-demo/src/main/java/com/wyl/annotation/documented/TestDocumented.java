package com.wyl.annotation.documented;

/**
 * Created by wangyunlong on 17/4/20
 */
public class TestDocumented {

    /**
     * IDEA 生成java文档
     * tools -> generate javaDoc
     *
     * 中文乱码问题，在other command line parameters ：-encoding utf-8 -charset utf-8
     *
     */
    @DocumentedAnnotationType
    public void methodA() {

    }

    @UndocmentedAnnotationType
    public void methodB() {

    }
}
