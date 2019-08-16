package com.ttmall.dao;

import com.ttmall.pojo.ProductPromo;

public interface ProductPromoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductPromo record);

    int insertSelective(ProductPromo record);

    ProductPromo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductPromo record);

    int updateByPrimaryKey(ProductPromo record);
}