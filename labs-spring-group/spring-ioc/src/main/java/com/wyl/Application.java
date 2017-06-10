package com.wyl;

import com.wyl.config.Config;
import com.wyl.rest.MessageRestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by wangyunlong on 17/3/3.
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        MessageRestController bean = context.getBean(MessageRestController.class);
        bean.execute();
    }
}
