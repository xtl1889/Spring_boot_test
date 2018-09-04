package com.example.mybatis_test.entity;

import java.io.Serializable;

/**
 * ${DESCRIPTION}
 *
 * @author xtl1889
 * @create 2018-06-21 21:45
 **/

public class Classs implements Serializable {

    private Integer id;

    private String class_name;

    private String class_code;

    private String class_level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public String getClass_level() {
        return class_level;
    }

    public void setClass_level(String class_level) {
        this.class_level = class_level;
    }
}
