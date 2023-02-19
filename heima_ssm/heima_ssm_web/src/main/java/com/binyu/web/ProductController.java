package com.binyu.web;

import com.binyu.domain.Product;
import com.binyu.domain.ResMsg;
import com.binyu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: heima_ssm
 * @BelongsPackage: com.binyu.web
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-31 10:58
 * @Description:
 */
@CrossOrigin("*")
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /*
    * Handler dispatch failed; nested exception is java.lang.AbstractMethodError
    *  <dependency>
            <groupId>com.mchange</groupId>
            <artifactId>c3p0</artifactId>
            <version>0.9.5.2</version>
            <type>jar</type>
            <scope>compile</scope>
        </dependency>
    *
    *  No converter found for return value of type: class java.util.ArrayList
    *  需要配置jackson
    * */

    @RequestMapping("/findAll")
    public @ResponseBody List<Product> findAll(){
        System.out.println ("ProductController");
        List<Product> products = productService.findAll ();
        System.out.println (products);
        return products;
    }
    @RequestMapping(value = "/saveProduct",method = RequestMethod.POST)
    public @ResponseBody
    ResMsg saveProduct(@RequestBody Product product){
        productService.saveProduct ( product );
        ResMsg msg=new ResMsg ();
        msg.setCode ( 200 );
        msg.setMsg ( "保存成功" );
        return msg;
    }

}
