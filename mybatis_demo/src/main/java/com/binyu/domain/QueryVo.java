package com.binyu.domain;

import java.util.List;

/**
 * @BelongsProject: mybatis_demo
 * @BelongsPackage: com.binyu.dao
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-10 16:03
 * @Description:
 */
public class QueryVo {
    private User user;
    private List<Integer> ids;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
