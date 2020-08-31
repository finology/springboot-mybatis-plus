package gy.finolo.springbootmybatisplus.controller;

import gy.finolo.springbootmybatisplus.handler.MessageSourceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 国际化测试
 * @author: Simon
 * @date: 2020-08-31 11:06
 */
@RestController
@RequestMapping("/i18n")
public class I18nController {

    @Autowired
    private MessageSourceHandler messageSourceHandler;

    @GetMapping("/m")
    public String i18nMessage() {
        return messageSourceHandler.getMessage("hello");
    }
}
