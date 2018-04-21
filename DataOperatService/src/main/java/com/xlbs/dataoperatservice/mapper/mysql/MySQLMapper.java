package com.xlbs.dataoperatservice.mapper.mysql;


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MySQLMapper {

    public List<Map> querySql(@Param(value="sql") String sql);

}
