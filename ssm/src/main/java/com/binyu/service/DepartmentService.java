package com.binyu.service;

import com.binyu.bean.Department;
import com.binyu.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: ssm
 * @BelongsPackage: com.binyu.service
 * @Author: Dong Binyu
 * @CreateTime: 2020-04-14 16:18
 * @Description:
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;


    public List<Department> getDepts() {
    List<Department> list=departmentMapper.selectByExample ( null );
    return list;
    }
}
