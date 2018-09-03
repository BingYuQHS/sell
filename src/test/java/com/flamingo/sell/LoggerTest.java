package com.flamingo.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 日志测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    @Test
    public void test1() {
        String name = "qinhs";
        int age = 21;
        log.debug("debug...");
        log.info("info...");
        log.info("name: {}, age: {}",name,age);
        log.error("error...");
    }
}
