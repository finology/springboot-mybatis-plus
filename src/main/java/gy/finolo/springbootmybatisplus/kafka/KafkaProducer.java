package gy.finolo.springbootmybatisplus.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @description: Kafka生产者类
 * @author: Simon
 * @date: 2021-08-05 10:18
 */
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public static final String TOPIC = "quickstart-events";

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message).addCallback(success -> {
            System.out.println("send success: " + success);
        }, fail -> {
            System.out.println("send fail: " + fail);
        });
    }
}
