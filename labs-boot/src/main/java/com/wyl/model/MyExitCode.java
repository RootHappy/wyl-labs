package com.wyl.model;

import org.springframework.boot.ExitCodeGenerator;

/**
 * Created by wangyunlong on 17/5/26.
 */
public class MyExitCode implements ExitCodeGenerator {
    @Override
    public int getExitCode() {
        return 100;
    }
}
