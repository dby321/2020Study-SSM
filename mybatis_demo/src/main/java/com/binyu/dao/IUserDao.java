package com.binyu.dao;

import com.binyu.domain.QueryVo;
import com.binyu.domain.User;

import java.util.List;

/**
 * @BelongsProject: mybatis_demo
 * @BelongsPackage: PACKAGE_NAME
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-06 17:22
 * @Description:
 */
public interface IUserDao {
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer userId);
    User findById(Integer userId);
    List<User> findByName(String username);
    int findTotal();
    List<User> findUserByVo(QueryVo vo);
    List<User> findUserByCondition(User user);
    List<User> findUserInIds(QueryVo vo);
    List<User> findAllUser();
}
