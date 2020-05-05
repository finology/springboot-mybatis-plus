package gy.finolo.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gy.finolo.springbootmybatisplus.dao.UserMapper;
import gy.finolo.springbootmybatisplus.entity.User;
import gy.finolo.springbootmybatisplus.model.AddUserRequest;
import gy.finolo.springbootmybatisplus.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Boolean add(AddUserRequest request) {
        // 业务逻辑
        if (request == null) {
            // TODO: exception handle
            throw new RuntimeException("xxxx");
        }

        User user = User.builder()
                .name(request.getName())
                .age(request.getAge())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return super.save(user);
    }

    @Override
    public User getById(Long id) {
        if (id == null) {
            throw new RuntimeException("yyyy");
        }
        return super.getById(id);
    }
}
