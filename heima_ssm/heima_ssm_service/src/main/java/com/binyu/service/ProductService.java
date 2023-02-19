package com.binyu.service;

import com.binyu.domain.Product;

import java.util.List;

/**
 * @BelongsProject: heima_ssm
 * @BelongsPackage: com.binyu.service
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-31 10:50
 * @Description:
 */
public interface ProductService {
    public List<Product> findAll();
    public void saveProduct(Product product);
}
