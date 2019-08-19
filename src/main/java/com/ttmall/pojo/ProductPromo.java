package com.ttmall.pojo;

import java.util.Date;

public class ProductPromo {
    private Integer id;

    private Integer productId;

    private Double promoItemPrice;

    private Integer activityId;

    private Date createTime;

    private Date updateTime;

    public ProductPromo(Integer id, Integer productId, Double promoItemPrice, Integer activityId, Date createTime, Date updateTime) {
        this.id = id;
        this.productId = productId;
        this.promoItemPrice = promoItemPrice;
        this.activityId = activityId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ProductPromo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getPromoItemPrice() {
        return promoItemPrice;
    }

    public void setPromoItemPrice(Double promoItemPrice) {
        this.promoItemPrice = promoItemPrice;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}