package gy.finolo.springbootmybatisplus;

import gy.finolo.springbootmybatisplus.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapperTests {

    @Test
    void testModel() {

        Address location = new Address().withLocation("location");
        System.out.println(location);
    }
}
