package com.xlbs.dataoperatservice.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

//@Configuration
//扫描sqlservice mapper接口包名
//@MapperScan(basePackages = DataSourceConstants.SQLSERVICE_SCAN_PACKAGE, sqlSessionFactoryRef = DataSourceConstants.SQLSERVICE_SESSION_FACTORY)
/**
 * 采用阿里druid连接池
 */
public class SQLServiceDataSource {

//    @Value("${sqlservice.datasource.url}")
//    private String dbUrl;
//
//    @Value("${sqlservice.datasource.username}")
//    private String dbUser;
//
//    @Value("${sqlservice.datasource.password}")
//    private String dbPassword;
//
//    @Qualifier(DataSourceConstants.SQLSERVICE_DATA_SOURCE)
//    @Bean(name = DataSourceConstants.SQLSERVICE_DATA_SOURCE)
//    public DataSource initMmsDataSource() {
//    	DruidDataSource dataSource = new DruidDataSource();
//    	dataSource.setUrl(dbUrl);
//        dataSource.setUsername(dbUser);
//        dataSource.setPassword(dbPassword);
//        return dataSource;
//    }
//
//    @Bean(name =DataSourceConstants.SQLSERVICE_TX_MG)
//    public DataSourceTransactionManager initFtpTransactionManager(@Qualifier(DataSourceConstants.SQLSERVICE_DATA_SOURCE) DataSource sqlServiceDataSource) {
//        return new DataSourceTransactionManager(sqlServiceDataSource);
//    }
//
//    @Bean(name = DataSourceConstants.SQLSERVICE_SESSION_FACTORY)
//    public SqlSessionFactory initMmsSessionFactory(@Qualifier(DataSourceConstants.SQLSERVICE_DATA_SOURCE) DataSource sqlServiceDataSource) throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(sqlServiceDataSource);
//        //绑定sqlservice mybatis映射文件路径
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSourceConstants.SQLSERVICE_SCAN_MAPPER));
//        return sessionFactory.getObject();
//    }

}
