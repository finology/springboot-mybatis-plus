package gy.finolo.springbootmybatisplus.service.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import gy.finolo.springbootmybatisplus.config.async.TaskExecutorConfig;
import gy.finolo.springbootmybatisplus.model.AddUserRequest;
import gy.finolo.springbootmybatisplus.service.AsyncService;
import gy.finolo.springbootmybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @description:
 * @author: Simon
 * @date: 2020-06-17 10:19
 */

@Service
public class AsyncServiceImpl implements AsyncService {

    @Autowired
    private AsyncServiceHelper asyncServiceHelper;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskExecutorConfig config;

    @Autowired
    @Qualifier("getAsyncExecutor")
    private Executor executor;

    @Override
    @Transactional
    public Map<String, Object> asyncWithReturn() {

        // 插入数据
        userService.add(AddUserRequest.builder()
                .age(10)
                .name("HELLO")
                .build());


        long start = System.currentTimeMillis();

//        CompletionService<String> ecs = new ExecutorCompletionService(config.getAsyncExecutor());
        CompletionService<String> ecs = new ExecutorCompletionService(executor);
        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
//            Future<String> future = asyncServiceHelper.asyncTask(i);
//            futures.add(future);
            Task task = new Task(i);
            futures.add(ecs.submit(task));
        }

        List<String> response = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            try {
                response.add(ecs.take().get());
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");

//                    e.printStackTrace();
            } catch (ExecutionException e) {
                System.out.println("ExecutionException: " + e.getMessage());
//                    e.printStackTrace();
                for (Future<String> f : futures) {
                    if (!f.isDone()) {
                        System.out.println("cancel future: " + f);
                        f.cancel(true);
                    }
                }
                throw new RuntimeException(e);
            }
//                throw new RuntimeException("");
        }

        Map<String, Object> map = new HashMap<>();
        String timeCost = "time cost: " + (System.currentTimeMillis() - start);
        map.put("data", response);
        map.put("cost", timeCost);


        return map;
    }

    static class Task implements Callable<String> {

        private int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public String call() throws Exception {

//            if (i == 2) {
//                int j = 1 / 0;
//            }

            try {
                TimeUnit.SECONDS.sleep(3 - i);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + i);
//            e.printStackTrace();
                return null;
            }

            System.out.println("async task exec: " + i);
            return "async with return: " + i;
        }
    }

}
