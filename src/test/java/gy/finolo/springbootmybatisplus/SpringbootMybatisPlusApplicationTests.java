package gy.finolo.springbootmybatisplus;

import gy.finolo.springbootmybatisplus.dao.UserMapper;
import gy.finolo.springbootmybatisplus.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
class SpringbootMybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSelect() {

        List<User> users = userMapper.selectList(null);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void inertOne() {
        User user = User.builder().name("Simon").age(28).email("test3@abc.com").build();
        userMapper.insert(user);
    }

    @Test
    public void selectById() {
        User user = userMapper.selectById(1247075853092757506L);
        System.out.println(user);
    }

    @Test
    public void selectByIds() {
//        List<Long> list = Arrays.asList(1247075853092757506L, 1247078551494045697L);
        ArrayList<Long> list = new ArrayList<>();
        list.add(1247075853092757506L);
        List<User> users = userMapper.selectBatchIds(list);

        System.out.println(users);
    }

}
