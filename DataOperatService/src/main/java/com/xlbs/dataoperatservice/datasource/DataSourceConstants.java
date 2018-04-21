package com.xlbs.dataoperatservice.datasource;

public class DataSourceConstants {
	
	//南厂房数据库 north plant
	public final static String MYSQL_SCAN_PACKAGE="com.xlbs.dataoperatservice.mapper.mysql";
	public final static String MYSQL_SCAN_MAPPER="classpath:/mybatis-mapper/mysql/**/*.xml";
	public final static String MYSQL_SESSION_FACTORY="MySQLSessionFactory";
	public final static String MYSQL_DATA_SOURCE="MySQLDataSource";
	public final static String MYSQL_TX_MG="MySQLTransactionManager";

	//北厂房数据库 south plant
	public final static String SQLSERVICE_SCAN_PACKAGE="com.xlbs.dataoperatservice.mapper.sqlservice";
	public final static String SQLSERVICE_SCAN_MAPPER="classpath:/mybatis-mapper/sqlservice/**/*.xml";
	public final static String SQLSERVICE_SESSION_FACTORY="SqlServiceSessionFactory";
	public final static String SQLSERVICE_DATA_SOURCE="SqlServiceDataSource";
	public final static String SQLSERVICE_TX_MG="SqlServiceTransactionManager";

}
