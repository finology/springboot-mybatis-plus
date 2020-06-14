package gy.finolo.springbootmybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import gy.finolo.springbootmybatisplus.entity.User;
import gy.finolo.springbootmybatisplus.model.AddUserRequest;
import gy.finolo.springbootmybatisplus.model.ListUserRequest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

public interface UserService extends IService<User> {

    List<User> list(@Valid ListUserRequest request);

    Boolean add(AddUserRequest request);

}
