package gy.finolo.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gy.finolo.springbootmybatisplus.dao.UserMapper;
import gy.finolo.springbootmybatisplus.entity.User;
import gy.finolo.springbootmybatisplus.model.AddUserRequest;
import gy.finolo.springbootmybatisplus.model.ListUserRequest;
import gy.finolo.springbootmybatisplus.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Validated
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    @Validated(ListUserRequest.ValidGroup2.class)
    public List<User> list(@Valid ListUserRequest request) {

        if (request == null) {
            throw new RuntimeException("List user request is null");
        }

        return super.list(Wrappers.<User>lambdaQuery().eq(User::getUsername, request.getName()));
    }

    @Override
    @Transactional
    public Boolean add(AddUserRequest request) {
        // 业务逻辑
        if (request == null) {
            // TODO: exception handle
            throw new RuntimeException("Add user request is null");
        }

        User user = User.builder()
                .username(request.getName())
                .age(request.getAge())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        boolean res = super.save(user);
//        int i = 1 / 0;
        return res;
    }

}
