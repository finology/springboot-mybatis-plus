package gy.finolo.springbootmybatisplus.controller;

import gy.finolo.springbootmybatisplus.entity.User;
import gy.finolo.springbootmybatisplus.model.AddUserRequest;
import gy.finolo.springbootmybatisplus.model.ListUserRequest;
import gy.finolo.springbootmybatisplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据条件查询 Users 列表
     */
    @GetMapping("")
    public List<User> list(ListUserRequest request) {
        log.info("query...");
        return userService.list(request);
    }

    /**
     * TODO: 增加 BaseResponse
     * 在 Controller 层封装 BaseResponse.success(user), 如果有异常在 Service 就抛出了, 不需要在 Controller 层处理
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public User getUser(@PathVariable @Min(1) Long id) {
        return userService.getById(id);
    }

    @PostMapping("")
    public void addUser(@RequestBody AddUserRequest request) {
        userService.add(request);
    }


}
