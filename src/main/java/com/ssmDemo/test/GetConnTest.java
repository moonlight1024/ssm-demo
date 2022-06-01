package com.ssmDemo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class GetConnTest {

	@Test
	public void testGetConn() throws Exception {

		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ssm_demo?useSSL=false");
		dataSource.setUser("root");
		dataSource.setPassword("123456");
		dataSource.setInitialPoolSize(1);

		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}

	@Test
	public void testGetConnByProperties() throws Exception {

		// 预先加载配置文件 jdbc.properties，把配置信息封装到 Properties 对象中 
		Properties pro = new Properties(); 
		//ClassLoader 只能加载类路径下的资源文件 //如果不是类路径下，只能使用 FileInputStream
		 pro.load(ClassLoader.getSystemClassLoader().getResourceAsStream("dbconfig.properties"));
		// //1、加载与注册驱动
		 Class.forName(pro.getProperty("jdbcDriver"));
		 //2、获取数据库连接 //
//		 Connection conn = DriverManager.getConnection(pro.getProperty("jdbcUrl"), pro);
		 Connection conn = DriverManager.getConnection(pro.getProperty("jdbcUrl"), 
				 pro.getProperty("jdbcUser"),
				 pro.getProperty("jdbcPwd"));
		 System.out.println(conn);
	}

}
