package com.binyu.dao;

import com.binyu.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @BelongsProject: mybatis_annotation
 * @BelongsPackage: PACKAGE_NAME
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-06 17:22
 * @Description:
 */
public interface IUserDao {
    @Select ( "select * from user;" )
    List<User> findAll();
}
