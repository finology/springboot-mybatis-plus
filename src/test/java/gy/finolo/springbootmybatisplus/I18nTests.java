package gy.finolo.springbootmybatisplus;

import gy.finolo.springbootmybatisplus.handler.MessageSourceHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description: 国际化测试
 * @author: Simon
 * @date: 2020-08-31 10:52
 */
@SpringBootTest
@Slf4j
public class I18nTests {

    @Autowired
    private MessageSourceHandler messageSourceHandler;

    @Test
    void testMessage() {
        log.info(messageSourceHandler.getMessage("hello"));
    }
}
