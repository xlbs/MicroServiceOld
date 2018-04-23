package com.xlbs.dataoperatservice.service.mysql;

import com.xlbs.dataoperatservice.entity.SaveObj;
import com.xlbs.dataoperatservice.mapper.mysql.MySQLMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MySQLService {

    @Autowired
    private MySQLMapper mySQLMapper;

    /**
     * 查询
     * @param sql SQL语句
     * @return
     */
    public List<Map> querySql(String sql){
        return mySQLMapper.querySql(sql);
    }

    /**
     * 保存
     * @param obj 对象
     * @return
     */
    public Integer saveSql(SaveObj obj){
        return mySQLMapper.saveSql(obj);
    }

    /**
     * 修改
     * @param sql SQL语句
     * @return
     */
    public Integer updateSql(String sql){
        return mySQLMapper.updateSql(sql);
    }

    /**
     * 删除
     * @param sql SQL语句
     * @return
     */
    public Integer deleteSql(String sql){
        return mySQLMapper.deleteSql(sql);
    }

    /**
     * 执行
     * @param sql SQL语句
     * @return
     */
    public boolean executeSql(String sql){
        return mySQLMapper.executeSql(sql);
    }






}
