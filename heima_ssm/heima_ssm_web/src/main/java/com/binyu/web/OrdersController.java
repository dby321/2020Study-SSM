package com.binyu.web;

import com.binyu.domain.Orders;
import com.binyu.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @BelongsProject: heima_ssm
 * @BelongsPackage: com.binyu.web
 * @Author: Dong Binyu
 * @CreateTime: 2020-09-07 17:29
 * @Description:
 */
@CrossOrigin("*")
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;


//    @RequestMapping("/findAll")
//    public @ResponseBody
//    List<Orders> findAll(){
//
//
//        List<Orders> orders= ordersService.findAll ();
//        System.out.println (orders);
//        return orders;
//    }

    @RequestMapping("/findAll")
    public @ResponseBody
    PageInfo findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "4")int size){
        PageInfo pageInfo = ordersService.findAll ( page, size );
        return pageInfo;
    }

    @RequestMapping("/findById")
    public @ResponseBody Orders findById(@RequestParam(name = "id",required = true)String id){
        Orders orders=ordersService.findById(id);
        System.out.println (orders);
        return orders;
    }

}
