package gy.finolo.springbootmybatisplus.redisclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.io.IOException;


/**
 * @description:
 * @author: Simon
 * @date: 2020-08-29 10:14
 */
@SpringBootTest
public class RedisTemplateTest {

    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
    private StringRedisTemplate redisTemplate;

    @Test
    void testString() {
        redisTemplate.opsForValue().set("k", "v");
        String k = redisTemplate.opsForValue().get("k");
        System.out.println(k);
    }

    @Test
    void insertString() {

        redisTemplate.opsForValue().set("prefix:obj:1", "obj1");
        redisTemplate.opsForValue().set("prefix:obj:2", "obj2");
        redisTemplate.opsForValue().set("prefix:obj:3", "obj3");
        redisTemplate.opsForValue().set("prefix:obj:4", "obj4");
    }

    @Test
    void select() {
        System.out.println(redisTemplate.opsForValue().get("prefix:obj:2"));
    }

    @Test
    void test() {
        String pattern = "*";
        long count = 10;
/*        ScanOptions options = ScanOptions.scanOptions().match(pattern).count(count).build();

//        RedisSerializer<String> redisSerializer = (RedisSerializer<String>) redisTemplate.getKeySerializer();
        Cursor<String> cursor = (Cursor<String>) redisTemplate.executeWithStickyConnection(
                redisConnection -> new ConvertingCursor<>(redisConnection.scan(options),
                        redisTemplate.getKeySerializer()::deserialize));
        while (cursor.hasNext()) {
            String next = cursor.next();
            System.out.println(next);
        }*/

        ScanOptions options = ScanOptions.scanOptions().match(pattern).build();
        Cursor<String> cursor = scan(redisTemplate, pattern, 10);

/*        Cursor<String> cursor = (Cursor<String>) redisTemplate.executeWithStickyConnection(redisConnection ->
                new ConvertingCursor<byte[], Object>(redisConnection.scan(options),
                        redisTemplate.getKeySerializer()::deserialize));*/

        while (cursor.hasNext()) {
            String next = cursor.next();
            System.out.println(next);
        }
        try {
            cursor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Cursor<String> scan(RedisTemplate redisTemplate, String pattern, int limit) {
        ScanOptions options = ScanOptions.scanOptions().match(pattern).count(limit).build();
        RedisSerializer<String> redisSerializer = (RedisSerializer<String>) redisTemplate.getKeySerializer();
        return (Cursor) redisTemplate.executeWithStickyConnection(redisConnection -> new ConvertingCursor<>(redisConnection.scan(options), redisSerializer::deserialize));
    }

    @Test
    void test1() {
        String pattern = "prefix:obj:*";
        try (Cursor<byte[]> cursor = redisTemplate.executeWithStickyConnection(
                conn -> conn.scan(ScanOptions.scanOptions().match(pattern).build())
        )) {
            while (cursor.hasNext()) {
                String key = new String(cursor.next());
//                System.out.println(key);
                String val = redisTemplate.opsForValue().get(key);
                System.out.println(key + " ==> " + val);
            }

//            cursor.forEachRemaining(i -> System.out.println(new String(i)));
        } catch (IOException ex) {
            // ...
        }

    }
}
