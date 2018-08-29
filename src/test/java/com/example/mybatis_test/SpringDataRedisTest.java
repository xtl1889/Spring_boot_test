package com.example.mybatis_test;

import com.example.mybatis_test.entity.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

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


    /**redis存储对象*/
    @Test
    public void saveObjectTest(){
        Student s1=new Student();
        s1.setId(1);
        s1.setName("Teemo");
        s1.setSex("man");
        s1.setCode("110");

        Student s2=new Student();
        s2.setId(2);
        s2.setName("水水水水");
        s2.setSex("man");
        s2.setCode("110");

        redisTemplate.opsForValue().set("student:stu1",s1);
        redisTemplate.opsForValue().set("student:stu2",s2);
    }

    /**redis获取对象*/
    @Test
    public void getObjectTest(){
        Student student1= (Student) redisTemplate.opsForValue().get("student:stu1");
        Student student2= (Student) redisTemplate.opsForValue().get("student:stu2");
        System.out.println("student:stu1----"+student1);
        System.out.println("student:stu1----"+student2);
    }

    /**以map形式存储对象*/
    @Test
    public void saveObjectByMapTest() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Student s=new Student();
        s.setId(3);
        s.setName("Ashe");
        s.setSex("woman");
        s.setCode("789");

        //对象转换为map
        Map map=BeanUtils.describe(s);
        redisTemplate.opsForHash().putAll("student:m1",map);
    }

    /**获取以map 形式保存的对象*/
    @Test
    public void getObjectByMapTest() throws InvocationTargetException, IllegalAccessException {
        Map map=redisTemplate.opsForHash().entries("student:m1");
        Student student=new Student();

        //map转换成已经定义的对象
        BeanUtils.populate(student,map);
        System.out.println("getObjectByMapTest---"+student.toString());
    }

    /**以list形式保存对象*/
    @Test
    public void saveObjectByListTest(){
        for (int i = 0; i < 5; i++) {
            Student student=new Student(i,"code"+i,"name"+i,"sex"+i);
            redisTemplate.opsForList().rightPush("studentList",student);
        }
    }

    /**获取对象list中的内容*/
    @Test
    public void getObjectListTest(){
        List list=redisTemplate.opsForList().range("studentList",1,-1);
        System.out.println(list);
    }

    /**数据库层面的命令 要通过execute接口实现*/
    @Test
    public void flushDbTest(){
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                //清空redis
                redisConnection.flushDb();
                return null;
            }
        });
    }
}
