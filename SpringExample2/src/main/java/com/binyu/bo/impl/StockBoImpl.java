package com.binyu.bo.impl;

import com.binyu.bo.StockBo;
import com.binyu.dao.StockDao;
import com.binyu.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stockBo")
public class StockBoImpl implements StockBo {
    @Autowired
    StockDao stockDao;


    public void save(Stock stock){
        stockDao.save(stock);
    }

    public void update(Stock stock){
        stockDao.update(stock);
    }

    public void delete(Stock stock){
        stockDao.delete(stock);
    }

    public Stock findByStockCode(String stockCode){
        return stockDao.findByStockCode(stockCode);
    }
}
