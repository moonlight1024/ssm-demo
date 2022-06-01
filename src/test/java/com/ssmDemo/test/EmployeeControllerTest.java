package com.ssmDemo.test;

import com.ssmDemo.bean.Department;
import com.ssmDemo.bean.Employee;
import com.ssmDemo.dao.DepartmentMapper;
import com.ssmDemo.dao.EmployeeMapper;
import com.ssmDemo.service.EmployeeService;
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
public class EmployeeControllerTest {
    @Autowired
    EmployeeService service;

    @Autowired
    EmployeeMapper mapper;


    public void getEmp() {

    }

    @Test
    public void getEmps() {
        Employee emp = service.getEmp(10);
        System.out.println(emp);
        System.out.println(service.getAllEmployees());
    }
}