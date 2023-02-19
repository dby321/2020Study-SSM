package com.binyu.domain;

import java.io.Serializable;

/**
 * @BelongsProject: mybatis_demo
 * @BelongsPackage: com.binyu.domain
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-11 15:00
 * @Description:
 */
public class Account implements Serializable {
    private Integer uid;
    private Integer id;
    private Double money;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "uid=" + uid +
                ", id=" + id +
                ", money=" + money +
                ", user=" + user +
                '}';
    }
}
