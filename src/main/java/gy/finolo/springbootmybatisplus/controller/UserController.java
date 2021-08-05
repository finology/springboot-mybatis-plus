package gy.finolo.springbootmybatisplus.controller;

import gy.finolo.springbootmybatisplus.entity.User;
import gy.finolo.springbootmybatisplus.model.vo.logMessage.ReportLogMessageRequest;
import gy.finolo.springbootmybatisplus.model.vo.user.AddUserRequest;
import gy.finolo.springbootmybatisplus.common.Response;
import gy.finolo.springbootmybatisplus.model.vo.user.UserListRequest;
import gy.finolo.springbootmybatisplus.model.vo.user.UserVo;
import gy.finolo.springbootmybatisplus.service.LogMessageService;
import gy.finolo.springbootmybatisplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    private LogMessageService logMessageService;

    /**
     * 根据条件查询 Users 列表
     */
    @GetMapping("")
    public Response<List<UserVo>> list(UserListRequest request) {
        log.info("query...");
        List<UserVo> userVos = userService.list(request);
        return Response.success(userVos);
    }

    /**
     * TODO: 增加 Response
     * 在 Controller 层封装 Response.success(user), 如果有异常在 Service 就抛出了, 不需要在 Controller 层处理
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public Response<UserVo> getUser(@PathVariable @Min(1) Long id) {

        User user = userService.getById(id);

        // TODO: 这部分是否应该放入Service层
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return Response.success(userVo);
    }

    @PostMapping("")
    public void addUser(@RequestBody AddUserRequest request) {
        userService.add(request);
    }


}
