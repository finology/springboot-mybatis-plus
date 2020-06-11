package gy.finolo.springbootmybatisplus;

import gy.finolo.springbootmybatisplus.service.AsyncTaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:
 * @author: Simon
 * @date: 2020-06-11 18:01
 */
@SpringBootTest
public class AsyncTaskServiceTests {

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Test
    void executeAsyncTasks() {
        asyncTaskService.executeAsyncTask1();
        asyncTaskService.executeAsyncTask2();
    }
}
