package com.flamingo.sell.utils;

import java.util.Random;

/**
 * 生成随机数的工具
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     * synchronized关键字是为了适应多线程的场景
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();

        //生成6位随机数
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
