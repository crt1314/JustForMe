package com.chrt;

import com.chrt.pojo.User;
import com.chrt.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
        redisTemplate.opsForValue().set("name", "小白");
    }

    @Test
    public void test2() {
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Autowired
    private UserService userService;

    @Test
    public void test3() {
        User user = userService.findById(1);
        redisTemplate.opsForValue().set("user", user);
    }

    @Test
    public void test4() {
        User user = (User) redisTemplate.opsForValue().get("user");
        System.out.println(user);
    }

    @Test
    public void test5() {
        redisTemplate.opsForSet().add("mySet", 1, 2, 3, 4);
    }

    @Test
    public void test6() {
        Set<Object> mySet = redisTemplate.opsForSet().members("mySet");
        System.out.println(mySet);
    }
}
