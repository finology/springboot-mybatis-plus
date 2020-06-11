package gy.finolo.springbootmybatisplus.service.impl;

import gy.finolo.springbootmybatisplus.service.AsyncTaskService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Simon
 * @date: 2020-06-11 17:57
 */
@Service
public class AsyncTaskServiceImpl implements AsyncTaskService {

    @Override
    @Async
    public void executeAsyncTask1() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task1");
    }

    @Override
    @Async
    public void executeAsyncTask2() {
        System.out.println("task2");
    }
}
