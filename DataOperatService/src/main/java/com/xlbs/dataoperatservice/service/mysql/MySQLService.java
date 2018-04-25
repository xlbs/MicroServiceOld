package com.xlbs.dataoperatservice.service.mysql;

import com.xlbs.dataoperatservice.commutils.JSONException;
import com.xlbs.dataoperatservice.commutils.JSONUtils;
import com.xlbs.dataoperatservice.entity.SaveObj;
import com.xlbs.dataoperatservice.mapper.mysql.MySQLMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
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
     * @param sql SQL语句
     * @return
     */
    public Long[] saveSql(String sql){
        SaveObj saveObj = new SaveObj(sql);
        Integer affectCount = mySQLMapper.saveSql(saveObj);
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
    public boolean updateSql(String sql){
        Integer  affectCount = mySQLMapper.updateSql(sql);
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
    public boolean deleteSql(String sql){
        Integer  affectCount = mySQLMapper.deleteSql(sql);
        if(affectCount<=0){
            return false;
        }
        return true;
    }

    /**
     * 批量保存
     * @param tabName 表名
     * @param fieldName 字段名 JSON字符串(Map<String,Object>)
     * @param datelist 数据列表 JSON字符串(List<Map<String,Object>>)
     * @return
     */
    public Long[] batchSaveSql(String tabName, String fieldName, String datelist){
        try {
            StringBuffer sb = new StringBuffer();
            Map<String,Object> field = JSONUtils.deserialize(fieldName, new JSONUtils.ObjectToken<Map<String,Object>>(){});
            List<Map<String,Object>> list = JSONUtils.deserialize(datelist, new JSONUtils.ObjectToken<List<Map<String,Object>> >(){});
            String sql = "";
            for (String str : field.keySet()){
                sql += str + ",";
            }
            sql = sql.substring(0,sql.length()-1);
            if(sql!=""){
                sb.append(" INSERT INTO "+tabName +" ("+sql+") VALUES ");
            }
            for (Map<String,Object> map : list){
                sql = "";
                for (String str : field.keySet()){
                    if(field.get(str) instanceof String){
                        sql += "'"+map.get(str)+"'" + ",";
                    }else if(field.get(str) instanceof  Integer){
                        sql += Integer.valueOf(map.get(str)+"") + ",";
                    }else if(field.get(str) instanceof  Long){
                        sql += Long.valueOf(map.get(str)+"") + ",";
                    }else if(field.get(str) instanceof  Double){
                        sql += Double.valueOf(map.get(str)+"") + ",";
                    }else{
                        sql += "'"+map.get(str)+"'" + ",";
                    }
                }
                sql = sql.substring(0,sql.length()-1);
                sb.append(" ("+sql+"),");
            }
            String sbSql = sb.toString();
            sbSql = sbSql.substring(0,sbSql.length()-1);
            System.out.println(sbSql);
            SaveObj saveObj = new SaveObj(sbSql);
            Integer affectCount = mySQLMapper.saveSql(saveObj);
            Long[] result = new Long[affectCount];
            for(int i=0; i<affectCount;i++){
                result[i] = saveObj.getId()+i;
            }
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Transactional
    public boolean executeTrans(String sqlList){
        try {
            List<String> list = JSONUtils.deserialize(sqlList, new JSONUtils.ObjectToken<List<String>>(){});
            for (String sql : list){
                sql = sql.trim();
                String head = sql.substring(0,6);
                if("SELECT".equals(head)||"select".equals(head)){
                    mySQLMapper.querySql(sql);
                }else if("UPDATE".equals(head)||"update".equals(head)){
                    mySQLMapper.updateSql(sql);
                }else if("INSERT".equals(head)||"insert".equals(head)){
                    SaveObj saveObj = new SaveObj(sql);
                    mySQLMapper.saveSql(saveObj);
                }else if("DELETE".equals(head)||"delete".equals(head)){
                    mySQLMapper.deleteSql(sql);
                }
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }











}
