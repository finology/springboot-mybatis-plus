package gy.finolo.springbootmybatisplus.producer;

import gy.finolo.springbootmybatisplus.entity.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // callback
    final RabbitTemplate.ConfirmCallback confirmCallback = (correlationData, ack, cause) -> {
        String messageIdStr = correlationData.getId();
        System.out.println(messageIdStr);
        if (ack) {
            // db
        } else {
            // exception, queue error
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
