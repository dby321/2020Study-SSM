package com.binyu.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: heima_ssm
 * @BelongsPackage: com.binyu.domain
 * @Author: Dong Binyu
 * @CreateTime: 2020-09-07 17:16
 * @Description:
 */
public class Orders {
    private Integer id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private Integer orderStatus;
    private String orderStatusStr;
    private Integer peopleCount;
    private String orderDesc;
    private Integer payType;
    private String payTypeStr;
    private Integer productId;
    private Integer memberId;
    private Member member;
    private Product product;
    private List<Traveller> travellers;

    public String getPayTypeStr() {
       if(this.payType==0){
           this.payTypeStr="支付宝";
       }else if(this.payType==2){
           this.payTypeStr="其他";
       }
       return this.payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }



    public String getOrderStatusStr() {
        if(this.orderStatus==0){
            this.orderStatusStr="未支付";
        }else if (this.orderStatus==1){
            this.orderStatusStr="已支付";
        }
        return this.orderStatusStr;

    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getOrderTimeStr() {
        if(orderTime!=null){
            DateFormat dateFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );
            this.orderTimeStr = dateFormat.format ( this.orderTime );
            return this.orderTimeStr;
        }else{
            return null;
        }
    }

    public void setOrderTimeStr(String orderTimeStr) {

        this.orderTimeStr = orderTimeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", orderDesc='" + orderDesc + '\'' +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", productId=" + productId +
                ", memberId=" + memberId +
                ", member=" + member +
                ", product=" + product +
                ", travellers=" + travellers +
                '}';
    }
}
