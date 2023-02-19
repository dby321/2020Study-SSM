package com.binyu.domain;

import java.io.Serializable;

/**
 * @BelongsProject: spring_jdbcTemplate
 * @BelongsPackage: com.binyu.domain
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-16 19:52
 * @Description:
 */
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
