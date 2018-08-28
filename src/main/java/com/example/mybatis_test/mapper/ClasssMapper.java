package com.example.mybatis_test.mapper;

import com.example.mybatis_test.entity.Classs;

import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author xtl1889
 * @create 2018-07-05 22:35
 **/
public interface ClasssMapper {

    public Classs getClasssById1(int id);
    public List<Map> getClasssById2(int id);
    public List<Classs> getClasssByLeverAndCode(Map map);

    public void insertClass(Classs classs);

    public void updateClass(Classs classs);

    public void deleteClass(Integer id);
}
