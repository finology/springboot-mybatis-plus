package gy.finolo.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gy.finolo.springbootmybatisplus.common.ErrorMessageEnum;
import gy.finolo.springbootmybatisplus.dao.UserMapper;
import gy.finolo.springbootmybatisplus.entity.User;
import gy.finolo.springbootmybatisplus.exception.AppException;
import gy.finolo.springbootmybatisplus.model.vo.user.AddUserRequest;
import gy.finolo.springbootmybatisplus.model.vo.user.UserListRequest;
import gy.finolo.springbootmybatisplus.model.vo.user.UserVo;
import gy.finolo.springbootmybatisplus.service.UserService;
import gy.finolo.springbootmybatisplus.utils.CollectionBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Validated
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override

//    public List<User> list(@Valid UserListRequest request) {
    @Validated(UserListRequest.ValidGroup2.class)
    public List<UserVo> list(UserListRequest request) {

//        不需要判断request, 一定不会为null
//        if (request == null) {
//            throw new RuntimeException("List user request is null");
//        }

        List<User> users;

        if (request.getName() == null) {
            users = super.list();
            throw new AppException(ErrorMessageEnum.INTERNAL_ERROR);
        } else {
            users = super.list(Wrappers.<User>lambdaQuery().eq(User::getUsername, request.getName()));
        }

        List<UserVo> userVoList = CollectionBeanUtils.copyListProperties(users, UserVo.class);

        return userVoList;
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
