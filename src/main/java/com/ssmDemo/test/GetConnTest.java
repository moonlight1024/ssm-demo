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

		// Ԥ�ȼ��������ļ� jdbc.properties����������Ϣ��װ�� Properties ������ 
		Properties pro = new Properties(); 
		//ClassLoader ֻ�ܼ�����·���µ���Դ�ļ� //���������·���£�ֻ��ʹ�� FileInputStream
		 pro.load(ClassLoader.getSystemClassLoader().getResourceAsStream("dbconfig.properties"));
		// //1��������ע������
		 Class.forName(pro.getProperty("jdbcDriver"));
		 //2����ȡ���ݿ����� //
//		 Connection conn = DriverManager.getConnection(pro.getProperty("jdbcUrl"), pro);
		 Connection conn = DriverManager.getConnection(pro.getProperty("jdbcUrl"), 
				 pro.getProperty("jdbcUser"),
				 pro.getProperty("jdbcPwd"));
		 System.out.println(conn);
	}

}
