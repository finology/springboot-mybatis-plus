package gy.finolo.springbootmybatisplus.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Simon
 * @date: 2020-06-17 10:21
 */
@Service
public class AsyncServiceHelper {

    @Async
    public AsyncResult<String> asyncTask(int i) {

        if (i == 0) {
//            int j = 1 / 0;
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println("Interrupted: " + i);
//            e.printStackTrace();
        }

        System.out.println("async task exec: " + i);

        return new AsyncResult<>("async with return: " + i);
    }

}
