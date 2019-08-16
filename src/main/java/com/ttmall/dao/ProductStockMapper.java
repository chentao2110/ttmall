package com.ttmall.dao;

import com.ttmall.pojo.ProductStock;

public interface ProductStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductStock record);

    int insertSelective(ProductStock record);

    ProductStock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductStock record);

    int updateByPrimaryKey(ProductStock record);
}