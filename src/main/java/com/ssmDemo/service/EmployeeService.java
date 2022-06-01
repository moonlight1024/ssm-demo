package com.ssmDemo.service;

import com.ssmDemo.bean.Employee;
import com.ssmDemo.bean.EmployeeExample;
import com.ssmDemo.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询所有员工信息
     *
     * @return
     */
    public List<Employee> getAllEmployees() {
        return employeeMapper.selectByExampleWithDept(null);
    }

    /**
     * 批量删除员工
     *
     * @param del_ids 员工编号的集合
     */
    public void deleteBatch(List<Integer> del_ids) {
//        创建qbc实例，实现条件sql
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andDIdIn(del_ids);
        employeeMapper.deleteByExample(example);
    }

    /**
     * 根据id删除单个员工
     *
     * @param id
     */
    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新员工信息
     *
     * @param employee
     */
    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    /**
     * 获取员工信息
     *
     * @param id 员工id
     * @return 员工对象
     */
    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    /**
     * 用户名是否合法（数据库中是否含有相同姓名）
     *
     * @param empName
     * @return
     */
    public boolean checkUser(String empName) {
//        设置条件
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
//        返回查询结果
        long count = employeeMapper.countByExample(example);
        return count == 0;
    }

    /**
     * 保存员工
     *
     * @param employee
     */
    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
    }
}
