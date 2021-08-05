package gy.finolo.springbootmybatisplus.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @description: Kafka消费者
 * @author: Simon
 * @date: 2021-08-05 10:46
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = KafkaProducer.TOPIC, groupId = "group1")
    public void listen(String message) {
        System.out.println("recv: " + message);
    }
}
