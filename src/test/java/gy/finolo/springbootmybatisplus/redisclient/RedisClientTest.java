package gy.finolo.springbootmybatisplus.redisclient;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.params.Params;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RedisClientTest {

    private Jedis jedis;

    @BeforeAll
    void setup() {
        jedis = new Jedis("localhost");
        // 权限认证
//        jedis.auth("");
    }

    /**
     * string类型
     */
    @Test
    void testString() {
        // 添加一个kv
        jedis.set("name", "finology");
        System.out.println(jedis.get("name"));

        // 拼接
        jedis.append("name", " website");
        System.out.println(jedis.get("name"));

        // 删除
        jedis.del("name");
        System.out.println(jedis.get("name") == null);

        // 设置多个kv
        jedis.mset("name", "finology", "age", "18");
        Long res = jedis.incr("age");
        System.out.println(res);
        System.out.println(jedis.get("name") + " - " + jedis.get("age"));
    }

    @Test
    void testMap() {

        Map<String, String> map = new HashMap<>();
        map.put("name", "finology");
        map.put("age", "18");
        jedis.hmset("user", map);

        List<String> strings = jedis.hmget("user", "name", "age");
        System.out.println(strings);

        System.out.println(jedis.hget("user", "name"));
        Map<String, String> userMap = jedis.hgetAll("user");
        System.out.println(userMap.get("name"));

        System.out.println(jedis.hlen("user"));
        Set<String> user = jedis.hkeys("user");
        List<String> user1 = jedis.hvals("user");

    }

    @Test
    void testList() {

        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework", 0, -1));
        // 存放数据
        jedis.lpush("java framework", "spring");
        jedis.lpush("java framework", "struts");
        jedis.lpush("java framework", "hibernate");
        jedis.rpush("java framework", "Rpush");
        System.out.println(jedis.lrange("java framework", 0, -1));
        jedis.lrange("java framework", 0, -1);
    }

    @Test
    void testSet() {
        String set = jedis.set("test", "A");

        jedis.sadd("users", "A");
        jedis.sadd("users", "B");
        Long srem = jedis.srem("users", "C");
        System.out.println(srem);
        Set<String> users = jedis.smembers("users");
        System.out.println(users);

    }

    @Test
    void testPartKey() {

/*        jedis.set("user:1", "A");
        jedis.set("user:2", "B");*/
        ScanParams scanParams = new ScanParams();
        scanParams.match("user:*").count(Integer.MAX_VALUE);
        ScanResult<String> scan = jedis.scan("0", scanParams);
        String cursor = scan.getCursor();
        List<String> result = scan.getResult();
//        System.out.println("cursor: " + cursor);
        System.out.println(result);

    }

}
