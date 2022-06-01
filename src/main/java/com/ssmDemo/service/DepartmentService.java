package com.ssmDemo.service;

import com.ssmDemo.bean.Department;
import com.ssmDemo.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * 查询所有部门
     * @return  部门集合
     */
    public List<Department> getAllDepts() {
        List<Department> departments = departmentMapper.selectByExample(null);
        return departments;
    }
}
