package com.wyl.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by wangyunlong on 17/5/26.
 */
@Component
public class MyRunner implements CommandLineRunner{

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(Arrays.toString(strings));
    }
}
