package com.wyl.config;

import com.wyl.services.MessageService;
import com.wyl.services.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by wangyunlong on 17/3/4.
 */
@Configurable
@ComponentScan(basePackages = {"com.wyl"})
public class Config {
    @Bean
    MessageService newMessageService() {
        return new MessageServiceImpl();
    }
}
