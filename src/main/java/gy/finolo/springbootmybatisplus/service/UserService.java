package gy.finolo.springbootmybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import gy.finolo.springbootmybatisplus.entity.User;
import gy.finolo.springbootmybatisplus.model.AddUserRequest;

public interface UserService extends IService<User> {

    Boolean add(AddUserRequest request);

    User getById(Long id);
}
