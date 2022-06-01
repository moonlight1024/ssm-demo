package com.ssmDemo.test;

import com.ssmDemo.bean.Department;
import com.ssmDemo.dao.DepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class MapperTest {

	@Autowired
	DepartmentMapper dempM;

	/**
	 * 测试departmentMapper
	 */
	@Test
	public void testMapper() {
//		 获取spring ioc容器
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");
		// 获取指定的mapper对象
		DepartmentMapper dept = ioc.getBean(DepartmentMapper.class);
		// 执行操作
		System.out.println(dept);
		int result = dept.insert(new Department(2, "测试部"));
		System.out.println(result);

	}

	/**
	 * spring注解的方式获取ioc
	 */
	@Test
	public void testMapper1() {
		System.out.println(dempM);
		List<Department> departments = dempM.selectByExample(null);
		System.out.println(departments);

	}

	@Test
	public void testMapper2() {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("spring.xml");
		Department orders = context.getBean("Department", Department.class);
		System.out.println("第四步 获取创建 bean 实例对象");
		System.out.println(orders);
		//手动让 bean 实例销毁
		context.close();
	}

}
