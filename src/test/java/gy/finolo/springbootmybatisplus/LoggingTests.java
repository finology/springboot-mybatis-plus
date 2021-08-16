package gy.finolo.springbootmybatisplus;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description: 日志测试
 * @author: Simon
 * @date: 2021-08-14 12:46
 */
@SpringBootTest
@Slf4j
public class LoggingTests {

    @Test
    void testLogging() {
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
    }
}
