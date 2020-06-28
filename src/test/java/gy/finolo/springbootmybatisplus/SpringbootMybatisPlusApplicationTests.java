package gy.finolo.springbootmybatisplus;

import gy.finolo.springbootmybatisplus.dao.UserMapper;
import gy.finolo.springbootmybatisplus.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@Slf4j
class SpringbootMybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testSelect() {


        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void inertOne() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        User user = User.builder().username("Simon").age(28).build();
        userMapper.insert(user);
    }

    @Test
    void selectById() {
        User user = userMapper.selectById(1249356039398084610L);
        log.info(user.toString());
        System.out.println(user);
    }

    @Test
    void selectByIds() {
//        List<Long> list = Arrays.asList(1247075853092757506L, 1247078551494045697L);
        ArrayList<Long> list = new ArrayList<>();
        list.add(1247075853092757506L);
        List<User> users = userMapper.selectBatchIds(list);

        System.out.println(users);
    }


}
