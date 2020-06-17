package gy.finolo.springbootmybatisplus.controller;

import gy.finolo.springbootmybatisplus.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description:
 * @author: Simon
 * @date: 2020-06-17 10:16
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("async")
    public Map<String, Object> asyncTransaction() {
        return asyncService.asyncWithReturn();
    }
}
