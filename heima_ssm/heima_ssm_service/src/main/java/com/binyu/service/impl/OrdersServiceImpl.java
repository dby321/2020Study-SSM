package com.binyu.service.impl;

import com.binyu.dao.OrdersDao;
import com.binyu.domain.Orders;
import com.binyu.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @BelongsProject: heima_ssm
 * @BelongsPackage: com.binyu.service.impl
 * @Author: Dong Binyu
 * @CreateTime: 2020-09-07 17:31
 * @Description:
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public List<Orders> findAll() {


        return ordersDao.findAll ();
    }

    @Override
    public PageInfo findAll(int page, int size) {
        PageHelper.startPage ( page,size);
        List<Orders> orders = ordersDao.findAll ();
        PageInfo pageInfo=new PageInfo ( orders );
        return pageInfo;

    }

    @Override
    public Orders findById(String id) {
        return ordersDao.findById(id);
    }
}
