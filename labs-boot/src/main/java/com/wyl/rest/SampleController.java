package com.wyl.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangyunlong on 17/5/25.
 */
@Controller
public class SampleController {

    @RequestMapping("/home")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

}
