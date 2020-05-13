package gy.finolo.springbootmybatisplus.controller;

import gy.finolo.springbootmybatisplus.entity.User;
import gy.finolo.springbootmybatisplus.model.AddUserRequest;
import gy.finolo.springbootmybatisplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("users")
    public List<User> getUsers() {
        return userService.list();
    }

    @GetMapping("users/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping("users")
    public void createUser(@RequestBody AddUserRequest request) {
        userService.add(request);
    }
}
