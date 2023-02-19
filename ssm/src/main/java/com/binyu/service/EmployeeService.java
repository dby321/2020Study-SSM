package com.binyu.service;

import com.binyu.bean.Employee;
import com.binyu.bean.EmployeeExample;
import com.binyu.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: ssm
 * @BelongsPackage: com.binyu.service
 * @Author: Dong Binyu
 * @CreateTime: 2020-04-06 20:22
 * @Description:
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 查询所有员工
     *
     * @return
     */
    public List<Employee> getAll() {
        return employeeMapper.selectByExampleWithDept ( null );
    }

    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective ( employee );
    }

    public Boolean checkUser(String empName) {
//        Example用于添加条件，相当于where后面的部分
        EmployeeExample example = new EmployeeExample ();
        EmployeeExample.Criteria criteria = example.createCriteria ();
        criteria.andEmpNameEqualTo ( empName );
        long count = employeeMapper.countByExample ( example );
        return count == 0;
    }

    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKeyWithDept ( id );
        return employee;
    }

    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective ( employee );
    }

    public void deleteEmpById(Integer id) {
        employeeMapper.deleteByPrimaryKey ( id );
    }

    public void deleteBatch(List<Integer> ids) {
        EmployeeExample example = new EmployeeExample ();
        EmployeeExample.Criteria criteria = example.createCriteria ();
        criteria.andEmpIdIn ( ids );
        employeeMapper.deleteByExample ( example );
    }

}
