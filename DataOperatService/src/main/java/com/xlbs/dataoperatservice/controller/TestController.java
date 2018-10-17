package com.xlbs.dataoperatservice.controller;

import com.xlbs.dataoperatservice.service.mysql.MySQLTestService;
import com.xlbs.dataoperatservice.service.sqlservice.SQLServiceTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private MySQLTestService mySQLTestService;

//    @Autowired
//    private SQLServiceTestService sqlServiceTestService;

    @RequestMapping(value = "/helloworld")
    @ResponseBody
    public String helloworld(){
        return "hello world";
    }

    @RequestMapping(value = "/mysql")
    @ResponseBody
    public List<Map<String, Object>> mySqlData(){
        return mySQLTestService.getMySQLData();
    }

//    @RequestMapping(value = "/sqlservice")
//    @ResponseBody
//    public List<Map<String, Object>> sqlServiceData(){
//        return sqlServiceTestService.getSQLServiceData();
//    }


}
