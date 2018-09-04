package com.example.mybatis_test.service;

import com.example.mybatis_test.entity.Classs;
import com.example.mybatis_test.mapper.ClasssMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author xtl1889
 * @create 2018-07-05 23:07
 **/
@Service
public class ClasssService {

    @Autowired
    ClasssMapper classsMapper;

    //缓存查找到的对象  默认情况下redis对象的序列化使用的是jdk序列化 要求对象实现Serializable接口
    @Cacheable(value = "cla",key = "#id")
    public Classs getClasssById1(Integer id){
        System.out.println("id--------------"+id);
        return classsMapper.getClasssById1(id);
    }

    public List<Map> getClasssById2(int id){
        return classsMapper.getClasssById2(id);
    }

    public List<Classs> getClasssByLeverAndCode(Map map){
        return classsMapper.getClasssByLeverAndCode(map);
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertClass(Classs classs){
         classsMapper.insertClass(classs);
    }


    public void updateClass(Classs classs){
        classsMapper.updateClass(classs);
    }

    public void deleteClass(Integer id){
        classsMapper.deleteClass(id);
    }
}
