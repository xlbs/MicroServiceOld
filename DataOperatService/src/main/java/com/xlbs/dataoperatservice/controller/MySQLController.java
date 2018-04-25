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

    /**
     * 查询
     * @param sql SQL语句
     * @return
     */
    @RequestMapping(value = "/querySql", method={RequestMethod.GET, RequestMethod.POST})
    public List<Map> querySql(String sql){
        return mySQLService.querySql(sql);
    }

    /**
     * 保存
     * @param sql SQL语句
     * @return
     */
    @RequestMapping(value = "/saveSql", method={RequestMethod.GET, RequestMethod.POST})
    public Long[] saveSql(String sql){
        return mySQLService.saveSql(sql);
    }

    /**
     * 修改
     * @param sql SQL语句
     * @return
     */
    @RequestMapping(value = "/updateSql", method={RequestMethod.GET, RequestMethod.POST})
    public boolean updateSql(String sql){
        return mySQLService.updateSql(sql);
    }

    /**
     * 删除
     * @param sql SQL语句
     * @return
     */
    @RequestMapping(value = "/deleteSql", method={RequestMethod.GET, RequestMethod.POST})
    public boolean deleteSql(String sql){
        return mySQLService.deleteSql(sql);
    }

    /**
     * 批量保存
     * @param tabName 表名
     * @param fieldName 字段名 JSON字符串(Map<String,Object>)
     * @param datelist 数据列表 JSON字符串(List<Map<String,Object>>)
     * @return
     */
    @RequestMapping(value = "/batchSaveSql", method={RequestMethod.GET, RequestMethod.POST})
    public Long[] batchSaveSql(String tabName, String fieldName, String datelist){
        return mySQLService.batchSaveSql(tabName,fieldName,datelist);
    }

    /**
     * 事务控制
     * @param sqlList sql语句集合 JSON字符串(List<String>)
     * @return
     */
    @RequestMapping(value = "/executeTrans", method={RequestMethod.GET, RequestMethod.POST})
    public boolean executeTrans(String sqlList){
        return mySQLService.executeTrans(sqlList);
    }




}
