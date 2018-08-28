package com.example.mybatis_test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * ${DESCRIPTION}
 *
 * @author xtl1889
 * @create 2018-08-16 20:44
 **/
public class JedisTest {
    @Test
    public void jedisTest() throws Exception{
        Jedis jedis=new Jedis("192.168.92.128",7654,1000);
        try {
            jedis.auth("123456");
            jedis.select(1);
            jedis.set("1","a");
            jedis.mset(new String[]{"2","b","3","c","4","d"});
            System.out.println("jedis.get(\"2\")---"+jedis.get("2"));
            System.out.println("jedis.mget(\"2\",\"3\")-----"+jedis.mget("2","3"));
        } catch (Exception e) {
            e.printStackTrace();
            throw  e;
        } finally {
            jedis.close();//关闭jedis
        }
    }


    @Test
    public void jedisHashTest() throws Exception{
        Jedis jedis=new Jedis("192.168.92.128",7654,1000);
        try {
            jedis.auth("123456");
            jedis.select(3);
            jedis.hset("1","name","Teemo");
            jedis.hset("1","age","1");
            jedis.hset("1","money","5300");
            System.out.println("jedis.hget(\"1\",\"name\")---"+jedis.hget("1","name"));
            System.out.println("jedis.hgetAll(\"1\")-----"+jedis.hgetAll("1"));
        } catch (Exception e) {
            e.printStackTrace();
            throw  e;
        } finally {
            jedis.close();
        }
    }
}
