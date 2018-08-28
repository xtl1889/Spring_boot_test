package com.example.mybatis_test.controller;

import com.example.mybatis_test.entity.Classs;
import com.example.mybatis_test.service.ClasssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author xtl1889
 * @create 2018-07-05 23:04
 **/
@RestController
@RequestMapping(value = "okWcInfo")
@Api(value = "/okWcInfo",tags = "OkWcInfo",description = "测试")
public class ClassController {
    @Autowired
    ClasssService classsService;

    @RequestMapping(value = "/getClasssById/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取班级信息")
    public Classs getClasssById(@PathVariable("id") Integer id){
        return classsService.getClasssById1(id);
    }

    @RequestMapping(value = "/getClasssById2/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取班级信息2")
    public List<Map> getClasssById2(@PathVariable("id") Integer id){
        return classsService.getClasssById2(id);
    }

    @RequestMapping(value = "/getClasssByLeverAndCode",method = RequestMethod.GET)
    @ApiOperation(value = "根据年级和年级code获取班级信息")
    public List<Classs> getClasssByLeverAndCode(@RequestParam String level,
                                                @RequestParam String code){
        Map map=new HashMap();
        map.put("level",level);
        map.put("code",code);
        return classsService.getClasssByLeverAndCode(map);
    }

    @RequestMapping(value = "/insertClasss",method = RequestMethod.GET)
    @ApiOperation(value = "插入班级信息")
    public Classs insertClasss(){
        Classs classs=new Classs();
        classs.setClass_name("TestName");
        classs.setClass_code("testCode");
        classs.setClass_level("testLevel");
        classsService.insertClass(classs);
        return classs;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "更新班级信息")
    public Classs update(){
        Classs classs=classsService.getClasssById1(3);
        classs.setClass_name("updateName");
        classs.setClass_level("updateLevel");
        classs.setClass_code("updateCode");
        classsService.updateClass(classs);
        return classs;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ApiOperation(value = "删除班级信息")
    public String deleteClass(Integer id){
        Classs classs=classsService.getClasssById1(id);
        if (classs==null){
            return "classs not found0000";
        }
        classsService.deleteClass(id);
        return "delete success";
    }
}
