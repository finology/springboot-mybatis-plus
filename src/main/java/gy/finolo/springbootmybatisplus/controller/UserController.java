package gy.finolo.springbootmybatisplus.controller;

import gy.finolo.springbootmybatisplus.entity.User;
import gy.finolo.springbootmybatisplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> list() {
        log.info("list...");
        return userService.list();
    }
}
