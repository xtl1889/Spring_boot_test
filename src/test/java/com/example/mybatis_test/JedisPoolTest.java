package com.example.mybatis_test;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * ${DESCRIPTION}
 *
 * @author xtl1889
 * @create 2018-08-16 21:33
 **/
public class JedisPoolTest {

    @Test
    public void jedisPoolTest(){
        GenericObjectPoolConfig config=new GenericObjectPoolConfig();
        config.setMaxTotal(100);//最多允许存在的jedis数量
        config.setMaxIdle(50);//最多允许存在空闲jedis数量
        config.setMinIdle(10);//最少允许存在空闲jedis数量
        config.setTestOnBorrow(false);//借出jedis时 测试有效性 推荐false
        config.setTestOnReturn(false);//归还jedis时 测试有效性
        config.setTestOnCreate(false);//创建时 测试有效性，由于redis核心配置文件中 protected-model(包含机制) 默认 yes
                                        //只允许本地访问redis  如果远程连接 setTestOnCreate(true) 会出现错误
        config.setBlockWhenExhausted(true);//连接池中 如果无可用资源 是否等待
        config.setMaxWaitMillis(3000);//无可以资源时 最长等待时间

        JedisPool jedisPool=new JedisPool("192.168.92.128",7654);
        Jedis jedis=null;

        try {
            jedis=jedisPool.getResource();
            jedis.auth("123456");
            jedis.select(4);
            jedis.mset(new String[]{"1","1","2","2","3","3","4","4"});
            System.out.println(jedis.mget("1","2","3"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis!=null){
                jedis.close();//归还jedis
            }
        }
    }
}
