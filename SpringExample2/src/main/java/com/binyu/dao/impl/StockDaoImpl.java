package com.binyu.dao.impl;

import com.binyu.dao.StockDao;
import com.binyu.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("stockDao")
public class StockDaoImpl  implements StockDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    public void save(Stock stock){
        hibernateTemplate.save(stock);
    }

    public void update(Stock stock){
        hibernateTemplate.update(stock);
    }

    public void delete(Stock stock){
        hibernateTemplate.delete(stock);
    }

    public Stock findByStockCode(String stockCode){
        List list = hibernateTemplate.find(
                "from Stock where stockCode=?",stockCode
        );
        List from_stock_where_stockCode = hibernateTemplate.find("from Stock where stockCode=?", stockCode);
        return (Stock)list.get(0);
    }
}
