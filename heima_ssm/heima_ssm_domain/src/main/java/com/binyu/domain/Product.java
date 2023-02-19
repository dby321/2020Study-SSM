package com.binyu.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @BelongsProject: heima_ssm
 * @BelongsPackage: com.binyu.domain
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-31 10:42
 * @Description:
 */
public class Product {
    private Integer id;
    private String productNum;
    private String productName;
    private String cityName;
    private Date departureTime;
    private String departureTimeStr;
    private Double productPrice;
    private String productDesc;
    private Integer productStatus;
    private String productStatusStr;

    public String getDepartureTimeStr() {
        DateFormat dateFormat=new SimpleDateFormat ( "yyyy-MM-dd hh:mm:ss" );
        this.departureTimeStr= dateFormat.format ( getDepartureTime () );
        return this.departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) throws ParseException {
        DateFormat dateFormat=new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );
        Date date = dateFormat.parse ( departureTimeStr );
        this.departureTime=date;
        this.departureTimeStr=departureTimeStr;
    }

    public String getProductStatusStr() {
        if(getProductStatus ()==1){
            this.productStatusStr="开启";
            return this.productStatusStr;
        }else if (getProductStatus ()==0){
            this.productStatusStr="关闭";
            return this.productStatusStr;
        }else{
            return "状态未知";
        }
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(Date departureTime) {

        this.departureTime = departureTime;
        DateFormat dateFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        String departureTimeStr = dateFormat.format ( departureTime );
        this.departureTimeStr=departureTimeStr;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }
}
