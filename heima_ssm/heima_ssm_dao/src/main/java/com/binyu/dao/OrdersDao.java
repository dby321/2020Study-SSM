package com.binyu.dao;

import com.binyu.domain.Orders;

import java.util.List;

/**
 * @BelongsProject: heima_ssm
 * @BelongsPackage: com.binyu.dao
 * @Author: Dong Binyu
 * @CreateTime: 2020-09-07 17:29
 * @Description:
 */
public interface OrdersDao {
    List<Orders> findAll();

    Orders findById(String id);
}
