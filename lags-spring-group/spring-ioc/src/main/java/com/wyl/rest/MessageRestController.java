package com.wyl.rest;

import com.wyl.services.MessageService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by wangyunlong on 17/3/4.
 */
@Component
public class MessageRestController {
    @Resource
    private MessageService messageService;

    public void execute() {
        System.out.println(messageService.getMessage());
    }
}
