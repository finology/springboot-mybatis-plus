package gy.finolo.springbootmybatisplus.consumer;

import com.rabbitmq.client.Channel;
import gy.finolo.springbootmybatisplus.entity.Order;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class OrderReceiver {

    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order-queue", durable = "true"),
            exchange = @Exchange(value = "order-exchange", type = "topic"),
            key = "order.*"
    ))
    public void onOrderMessage(@Payload Order order,
                               @Headers Map<String, Object> headers,
                               Channel channel) throws IOException {

        System.out.println(System.currentTimeMillis());
        System.out.println("收到消息" + order.getName() + order.getId());
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
//        channel.basicAck(deliveryTag, false);

    }

}
