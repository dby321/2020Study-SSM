package com.binyu.service;

import com.binyu.domain.Orders;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @BelongsProject: heima_ssm
 * @BelongsPackage: com.binyu.service
 * @Author: Dong Binyu
 * @CreateTime: 2020-09-07 17:31
 * @Description:
 */
public interface OrdersService {
    List<Orders> findAll();
    PageInfo findAll(int page, int size);

    Orders findById(String id);
}
