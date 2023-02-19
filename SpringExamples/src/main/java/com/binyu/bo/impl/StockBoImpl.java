package com.binyu.bo.impl;

import com.binyu.bo.StockBo;
import com.binyu.dao.StockDao;
import com.binyu.model.Stock;

public class StockBoImpl implements StockBo {

    StockDao stockDao;

    public void setStockDao(StockDao stockDao) {
        this.stockDao = stockDao;
    }

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
