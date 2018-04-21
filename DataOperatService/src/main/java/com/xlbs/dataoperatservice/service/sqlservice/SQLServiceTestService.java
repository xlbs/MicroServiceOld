package com.xlbs.dataoperatservice.service.sqlservice;

import com.xlbs.dataoperatservice.mapper.sqlservice.SQLServiceTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SQLServiceTestService {

    @Autowired
    private SQLServiceTestMapper sqlServiceTestMapper;


    public List<Map<String, Object>> getSQLServiceData(){
        return sqlServiceTestMapper.getSQLServiceData();
    }



}
