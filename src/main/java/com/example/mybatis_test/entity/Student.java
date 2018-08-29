package com.example.mybatis_test.entity;

/**
 * ${DESCRIPTION}
 *
 * @author xtl1889
 * @create 2018-06-05 20:59
 **/
public class Student {

    private Integer id;

    private String code;

    private String name;

    private String sex;


    private Classs classs;


    public Student() {
    }

    public Student(Integer id, String code, String name, String sex) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.sex = sex;
    }

    public Student(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Classs getClasss() {
        return classs;
    }

    public void setClasss(Classs classs) {
        this.classs = classs;
    }

    @Override
    public String toString() {
        return "id="+id+
                ",code="+code+
                ",name="+name+
                ",sex="+sex;
    }
}
