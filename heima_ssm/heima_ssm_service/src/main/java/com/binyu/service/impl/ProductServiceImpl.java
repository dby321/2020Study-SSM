package com.binyu.service.impl;

import com.binyu.dao.ProductDao;
import com.binyu.domain.Product;
import com.binyu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @BelongsProject: heima_ssm
 * @BelongsPackage: com.binyu.service.impl
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-31 10:51
 * @Description:
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        System.out.println ("ProductServiceImpl");
        return productDao.findAll ();
    }

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct ( product );
    }
}
