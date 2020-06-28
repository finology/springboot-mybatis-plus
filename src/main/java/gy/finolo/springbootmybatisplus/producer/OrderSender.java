package gy.finolo.springbootmybatisplus.producer;

import gy.finolo.springbootmybatisplus.entity.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
// 注释掉Profile, 然后在启动类里删除掉对RabbitMQ的排除
@Profile("no_rabbit")
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // callback
    private final RabbitTemplate.ConfirmCallback confirmCallback = (correlationData, ack, cause) -> {
        if (correlationData != null) {
            String messageIdStr = correlationData.getId();
            System.out.println(messageIdStr);
            if (ack) {
                // db
                System.out.println("here");
            } else {
                throw new RuntimeException("queue error");
                // exception, queue error
            }
        }
    };


    public void send(Order order) {
        rabbitTemplate.setConfirmCallback(confirmCallback);

        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(String.valueOf(order.getId()));
        System.out.println("about to send, ts" + System.currentTimeMillis());
        rabbitTemplate.convertAndSend("order-exchange",
                "order.abcd",
                order,
                correlationData);
    }
}
