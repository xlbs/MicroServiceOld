package com.xlbs.dataoperatservice.mapper.mysql;


import com.xlbs.dataoperatservice.entity.SaveObj;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MySQLMapper {

    /**
     * 查询
     * @param sql SQL语句
     * @return
     */
    public List<Map> querySql(@Param(value="sql") String sql);

    /**
     * 保存
     * @param obj 对象
     * @return
     */
    public Integer saveSql(SaveObj obj);

    /**
     * 修改
     * @param sql SQL语句
     * @return
     */
    public Integer updateSql(@Param(value="sql") String sql);

    /**
     * 删除
     * @param sql SQL语句
     * @return
     */
    public Integer deleteSql(@Param(value="sql") String sql);

    /**
     * 执行
     * @param sql SQL语句
     * @return
     */
    public boolean executeSql(@Param(value="sql") String sql);

    /**
     * 批量保存
     * @param sql SQL语句
     * @return
     */
    public Integer[] batchSaveSql(@Param(value="sql") String sql);

    /**
     * 批量修改
     * @param sql SQL语句
     * @return
     */
    public boolean batchUpdateSql(@Param(value="sql") String sql);


    /**
     * 事务控制
     * @return
     */
    public List<Map> executeTrans();

}
