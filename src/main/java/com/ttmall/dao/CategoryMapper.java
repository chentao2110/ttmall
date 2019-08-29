package com.ttmall.dao;

import com.ttmall.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);
    List<Category> selectAllCategory();

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}