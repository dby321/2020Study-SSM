package com.binyu.controller;

import com.binyu.bean.Employee;
import com.binyu.utils.Msg;
import com.binyu.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理员工curd
 *
 * @BelongsProject: ssm
 * @BelongsPackage: com.binyu.controller
 * @Author: Dong Binyu
 * @CreateTime: 2020-04-06 20:18
 * @Description:
 */
@Controller
public class EmployeeContoller {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/checkUser")
    @ResponseBody
    public Msg checkUser(@RequestParam("empName") String empName) {
//        先判断用户名校验是否通过
        String regName = "(^[a-zA-Z0-9_-]{6,16}$)|([\u4E00-\u9FA5]{2,5})";
        if (!empName.matches ( regName )) {
            return Msg.fail ().add ( "va_msg", "用户名校验失败" );
        }
//       数据库重复名校验
        boolean b = employeeService.checkUser ( empName );
        if (b) {
            return Msg.success ();
        } else {
            return Msg.fail ().add ( "va_msg", "用户名不可用" );
        }

    }

    /**
     * @param employee
     * @param result
     * @return
     * @description: @Valid和BindingResult结合使用
     */
    @RequestMapping(value = "/emps", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors ()) {
            Map<String, Object> map = new HashMap<> ();
            List<FieldError> errors = result.getFieldErrors ();
            for (FieldError fieldError : errors
            ) {
                System.out.println ( fieldError.getField () );
                System.out.println ( fieldError.getDefaultMessage () );
                map.put ( fieldError.getField (), fieldError.getDefaultMessage () );
            }
            return Msg.fail ().add ( "errorFields", map );
        } else {
            employeeService.saveEmp ( employee );
            return Msg.success ();
        }
    }

    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {

//        引入PageHelper分页工具
        PageHelper.startPage ( pn, 5 );
        List<Employee> emps = employeeService.getAll ();
//      使用pageinfo包装查询出来的数据
        PageInfo pageInfo = new PageInfo ( emps, 5 );
        model.addAttribute ( "pageInfo", pageInfo );
        return Msg.success ().add ( "pageInfo", pageInfo );
    }

    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg saveEmp(Employee employee) {
        employeeService.updateEmp ( employee );
        return Msg.success ();
    }

    //    单个批量二合一
    @RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteEmp(@PathVariable("ids") String ids) {
        if (ids.contains ( "-" )) {
            List<Integer> del_list=new ArrayList<> (  );
            String[] strings = ids.split ( "-" );
            for (String string:strings
                 ) {
                del_list.add (  Integer.parseInt ( string ));
            }
            employeeService.deleteBatch(del_list);
        } else {
            Integer id = Integer.parseInt ( ids );
            employeeService.deleteEmpById ( id );
        }

        return Msg.success ();
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getEmp ( id );
        return Msg.success ().add ( "emp", employee );
    }
    /**
     * 查询员工数据
     * @return
     */
    /*@RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){

//        引入PageHelper分页工具
        PageHelper.startPage ( pn,5);
        List<Employee> emps=employeeService.getAll();
//      使用pageinfo包装查询出来的数据
        PageInfo pageInfo=new PageInfo ( emps ,5);
        model.addAttribute ( "pageInfo",pageInfo );
        return "list";
    }*/

}
