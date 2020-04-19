package gy.finolo.springbootmybatisplus.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RetryTasker {

    @Scheduled(initialDelay = 3000, fixedDelayString = "${config.fixDelay}")
    public void reSend() {
        System.out.println("here");
    }
}
