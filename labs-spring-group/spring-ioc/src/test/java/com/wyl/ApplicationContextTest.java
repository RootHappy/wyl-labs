package com.wyl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by wangyunlong on 17/3/6.
 */
public class ApplicationContextTest {


    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext();


        System.out.println(context.getId());

        System.out.println(context.getApplicationName());

        System.out.println(context.getDisplayName());

        System.out.println(context.getStartupDate());


    }


}
