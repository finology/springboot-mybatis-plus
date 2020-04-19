package gy.finolo.springbootmybatisplus.rabbitmq;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import gy.finolo.springbootmybatisplus.entity.Order;
import gy.finolo.springbootmybatisplus.producer.OrderSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private OrderSender orderSender;

    @Test
    void testSend() {

        IdentifierGenerator generator = new DefaultIdentifierGenerator();
        Number number = generator.nextId(Order.class);

        Order order = Order.builder()
                .id(System.currentTimeMillis())
                .name("My Order")
                .messageId(number.toString()).build();

        orderSender.send(order);
    }
}
