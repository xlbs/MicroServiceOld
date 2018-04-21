package com.xlbs.dataoperatservice.service.mysql;

import com.xlbs.dataoperatservice.mapper.mysql.MySQLMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MySQLService {

    @Autowired
    private MySQLMapper mySQLMapper;

    public List<Map> querySql(String sql){
        return mySQLMapper.querySql(sql);
    }




}
