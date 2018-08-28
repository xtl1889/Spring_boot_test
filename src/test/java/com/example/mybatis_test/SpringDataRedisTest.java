package com.example.mybatis_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ${DESCRIPTION}
 *
 * @author xtl1889
 * @create 2018-08-21 22:31
 **/
//启动时初始化
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:redisConfig.xml"})
public class SpringDataRedisTest {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Test
    public void stringSetTest(){
        //opsForValue 是对string 操作的类
        /**默认情况下spring-data-redis 采用gdk序列化的方式将key value进行二进制序列化
         * 这样会导致redis数据库中可读性很差  通常需要字符串或者json形式保存对象
         * * */
        redisTemplate.opsForValue().set("b","a");
        String value= (String) redisTemplate.opsForValue().get("b");
        System.out.println("----------"+value);
    }


    @Test
    public void method(){

    }
}
