package com.xlbs.dataoperatservice.controller;

import com.xlbs.dataoperatservice.service.mysql.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MySQLController {

    @Autowired
    private MySQLService mySQLService;

    @RequestMapping(value = "/querySql", method={RequestMethod.GET, RequestMethod.POST})
    public List<Map> querySql(String sql){
        return mySQLService.querySql(sql);
    }

}
