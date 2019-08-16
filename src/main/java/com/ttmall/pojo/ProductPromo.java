package com.ttmall.pojo;

public class ProductPromo {
    private Integer id;

    private Integer productId;

    private Double promoItemPrice;

    private Integer activityId;

    public ProductPromo(Integer id, Integer productId, Double promoItemPrice, Integer activityId) {
        this.id = id;
        this.productId = productId;
        this.promoItemPrice = promoItemPrice;
        this.activityId = activityId;
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
}