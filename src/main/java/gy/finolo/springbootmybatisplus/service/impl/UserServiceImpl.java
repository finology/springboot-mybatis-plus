package gy.finolo.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gy.finolo.springbootmybatisplus.dao.UserMapper;
import gy.finolo.springbootmybatisplus.entity.User;
import gy.finolo.springbootmybatisplus.model.vo.user.AddUserRequest;
import gy.finolo.springbootmybatisplus.model.vo.user.UserListRequest;
import gy.finolo.springbootmybatisplus.model.vo.user.UserVo;
import gy.finolo.springbootmybatisplus.service.UserService;
import gy.finolo.springbootmybatisplus.utils.CollectionBeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Service
// ServiceImpl加Validated注解, 如果有分组校验，那在方法上, 如果参数为类类型, 那在接口和实现类的方法参数前面加Valid
@Validated
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override

    @Validated(UserListRequest.ValidGroup2.class)
    public List<UserVo> list(@Valid UserListRequest request) {

//        不需要判断request, 一定不会为null
//        if (request == null) {
//            throw new RuntimeException("List user request is null");
//        }

        List<User> users;

        if (request.getName() == null) {
            users = super.list();
        } else {
            users = super.list(Wrappers.<User>lambdaQuery().eq(User::getUsername, request.getName()));
        }

        List<UserVo> userVoList = CollectionBeanUtils.copyListProperties(users, UserVo.class);

        return userVoList;
    }

    @Override
    @Transactional
    public Boolean add(@Valid AddUserRequest request) {

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
