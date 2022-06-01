package com.ssmDemo.dao;

import com.ssmDemo.bean.Department;
import com.ssmDemo.bean.DepartmentExample;
import com.ssmDemo.bean.Employee;
import com.ssmDemo.bean.EmployeeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


public interface EmployeeMapper {
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer empId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    //根据条件查询员工信息（包含部门）
    List<Employee> selectByExampleWithDept(EmployeeExample example);
    //根据主键查询员工信息（包含部门）
    Employee selectByPrimaryKeyWithDept(Integer deptId);
}