package com.zzd.redisdemo;

import com.zzd.redisdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisDemoApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("name", "李四");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
    @Test
    void testSaveUser() {
        redisTemplate.opsForValue().set("user:100",new User("zzd",21));
        User o = (User) redisTemplate.opsForValue().get("user:100");
        System.out.println(o);

    }

}
