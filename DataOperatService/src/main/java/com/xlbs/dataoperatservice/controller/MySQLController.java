package com.xlbs.dataoperatservice.controller;

import com.xlbs.dataoperatservice.entity.SaveObj;
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
        SaveObj saveObj = new SaveObj(sql);
        Integer affectCount = mySQLService.saveSql(saveObj);
        Long[] result = new Long[affectCount];
        for(int i=0; i<affectCount;i++){
            result[i] = saveObj.getId()+i;
        }
        return result;
    }

    /**
     * 修改
     * @param sql SQL语句
     * @return
     */
    @RequestMapping(value = "/updateSql", method={RequestMethod.GET, RequestMethod.POST})
    public boolean updateSql(String sql){
        Integer  affectCount = mySQLService.updateSql(sql);
        if(affectCount<=0){
            return false;
        }
        return true;
    }

    /**
     * 删除
     * @param sql SQL语句
     * @return
     */
    @RequestMapping(value = "/deleteSql", method={RequestMethod.GET, RequestMethod.POST})
    public boolean deleteSql(String sql){
        Integer  affectCount = mySQLService.deleteSql(sql);
        if(affectCount<=0){
            return false;
        }
        return true;
    }

    /**
     * 执行
     * @param sql SQL语句
     * @return
     */
    @RequestMapping(value = "/executeSql", method={RequestMethod.GET, RequestMethod.POST})
    public boolean executeSql(String sql){
        return mySQLService.executeSql(sql);
    }


    /**
     * 事务控制
     * @return
     */
    @RequestMapping(value = "/executeTrans", method={RequestMethod.GET, RequestMethod.POST})
    public List<Map> executeTrans(){
        return mySQLService.executeTrans();
    }

}
