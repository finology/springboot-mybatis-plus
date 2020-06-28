package gy.finolo.springbootmybatisplus;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @description:
 * @author: Simon
 * @date: 2020-06-26 20:33
 */
@SpringBootTest
public class BCryptTests {

    @Test
    void testBCrypt() {

        String hashpw1 = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(hashpw1);

        String hashpw2 = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(hashpw2);

        boolean checkpw1 = BCrypt.checkpw("123", hashpw1);
        System.out.println(checkpw1);

        boolean checkpw2 = BCrypt.checkpw("123", hashpw2);
        System.out.println(checkpw1);
    }
}
