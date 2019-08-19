package com.ttmall.pojo;

import java.util.Date;

public class ProductStock {
    private Integer id;

    private Integer stock;

    private Integer productId;

    private Date createTime;

    private Date updateTime;

    public ProductStock(Integer id, Integer stock, Integer productId, Date createTime, Date updateTime) {
        this.id = id;
        this.stock = stock;
        this.productId = productId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ProductStock() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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