package gy.finolo.springbootmybatisplus;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import gy.finolo.springbootmybatisplus.entity.User;
import gy.finolo.springbootmybatisplus.model.vo.user.AddUserRequest;
import gy.finolo.springbootmybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ServiceTests {

    @Autowired
    private UserService userService;

    @Test
    void getList() {

        List<User> users = userService.list(Wrappers.<User>lambdaQuery().gt(User::getAge, 25));
        users.forEach(System.out::println);

    }

    @Test
    void addUser() {
        User user = User.builder()
                .username("hello")
                .age(26)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        userService.save(user);
    }

    @Test
    void addUser2() {
        AddUserRequest request = AddUserRequest.builder()
                .name("hello")
                .age(27)
                .build();

        User user = User.builder()
                .username(request.getName())
                .age(request.getAge())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        userService.save(user);
    }
}
