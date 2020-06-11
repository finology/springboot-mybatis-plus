package gy.finolo.springbootmybatisplus;

import gy.finolo.springbootmybatisplus.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:
 * @author: Simon
 * @date: 2020-05-21 14:33
 */

@SpringBootTest
@EnableAutoConfiguration(exclude = {RabbitAutoConfiguration.class})
public class ControllerTests {

    @Autowired
    private UserController userController;

    @Test
    void testController() {
        System.out.println(userController);
    }
}
