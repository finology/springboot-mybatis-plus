package gy.finolo.springbootmybatisplus;

import gy.finolo.springbootmybatisplus.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration(exclude = {RabbitAutoConfiguration.class})
class MapperTests {

    @Test
    void testModel() {

        Address location = new Address().withLocation("location");
        System.out.println(location);
    }
}
