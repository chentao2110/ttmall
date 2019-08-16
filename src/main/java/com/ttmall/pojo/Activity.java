package com.ttmall.pojo;

import java.util.Date;

public class Activity {
    private Integer id;

    private Integer productId;

    private String description;

    private Date startTime;

    private Date endTime;

    public Activity(Integer id, Integer productId, String description, Date startTime, Date endTime) {
        this.id = id;
        this.productId = productId;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Activity() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}