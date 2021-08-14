package gy.finolo.springbootmybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import gy.finolo.springbootmybatisplus.entity.User;
import gy.finolo.springbootmybatisplus.model.vo.user.AddUserRequest;
import gy.finolo.springbootmybatisplus.model.vo.user.UserListRequest;
import gy.finolo.springbootmybatisplus.model.vo.user.UserVo;

import javax.validation.Valid;
import java.util.List;

public interface UserService extends IService<User> {

    List<UserVo> list(@Valid UserListRequest request);

    Boolean add(@Valid AddUserRequest request);

}
