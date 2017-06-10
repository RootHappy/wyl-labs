package com.wyl.annotation.repeatable;

/**
 * Created by wangyunlong on 17/4/20.
 */
@Schedules({
        @Schedule("1"),
        @Schedule("2")
})
public class TestRepeatable {


    public static void main(String[] args) {

    }

    @Schedule("3")
    @Schedule("4")
    public void A() {

    }
}
