package com.ttmall.service.impl;

import com.ttmall.dao.CategoryMapper;
import com.ttmall.pojo.Category;
import com.ttmall.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> getAllCategory() {

        return categoryMapper.selectAllCategory();

    }
}
