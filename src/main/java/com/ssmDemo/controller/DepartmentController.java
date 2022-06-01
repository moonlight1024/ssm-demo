package com.ssmDemo.controller;

import com.ssmDemo.bean.Department;
import com.ssmDemo.bean.Msg;
import com.ssmDemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /**
     * 获取所有部门信息
     * @return
     */
    @GetMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Department> departments = departmentService.getAllDepts();
       return Msg.success().add("depts",departments);
    }


}
