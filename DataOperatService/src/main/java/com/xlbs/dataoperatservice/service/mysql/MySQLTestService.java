package com.xlbs.dataoperatservice.service.mysql;

import com.xlbs.dataoperatservice.mapper.mysql.MySQLTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MySQLTestService {

    @Autowired
    private MySQLTestMapper mySQLTestMapper;


    public List<Map<String, Object>> getMySQLData(){
        return mySQLTestMapper.getMySQLData();
    }







}
