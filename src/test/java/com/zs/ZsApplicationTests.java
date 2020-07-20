package com.zs;

import com.li.ZsApplication;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ZsApplication.class)
@RunWith(SpringRunner.class)
class ZsApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void redisTest() {
        stringRedisTemplate.opsForValue().set("name", "gime");
        Assert.assertEquals("gime", stringRedisTemplate.opsForValue().get("name"));
    }

}
