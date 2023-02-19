package com.binyu.dao;

import com.binyu.domain.Product;

import java.util.List;

/**
 * @BelongsProject: heima_ssm
 * @BelongsPackage: com.binyu.dao
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-31 10:48
 * @Description:
 */
public interface ProductDao {
    public List<Product> findAll();
    public void saveProduct(Product product);
    public Product findById(Integer id);
}
