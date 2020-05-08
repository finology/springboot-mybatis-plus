package gy.finolo.springbootmybatisplus.controller;

import gy.finolo.springbootmybatisplus.model.CallbackRequest;
import gy.finolo.springbootmybatisplus.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Simon
 * @date: 2020-05-08 21:50
 */
@RestController
@RequestMapping("/callback")
@Slf4j
public class CallbackEventController {

    @PostMapping("/test")
    public CallbackRequest handleEvent(@RequestBody CallbackRequest request) {
        log.info(request.toString());
        log.info(JsonUtils.toJson(request));
        return request;
    }
}
