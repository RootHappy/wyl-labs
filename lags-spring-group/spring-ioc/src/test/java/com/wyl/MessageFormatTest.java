package com.wyl;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangyunlong on 17/3/6.
 */
public class MessageFormatTest {

    public static void main(String[] args) {
//        MessageFormat format = new MessageFormat("wang {0} long", Locale.ENGLISH);
//
//        String format1 = format.format(new Object[]{"yun"});
//
//        System.out.printf(format1);

        System.out.println(System.currentTimeMillis());
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));

    }

}
