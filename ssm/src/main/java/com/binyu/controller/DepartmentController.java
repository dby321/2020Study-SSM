package com.binyu.controller;

import com.binyu.bean.Department;
import com.binyu.utils.Msg;
import com.binyu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Department> list=departmentService.getDepts();
        return Msg.success ().add ( "depts",list );
    }

}
