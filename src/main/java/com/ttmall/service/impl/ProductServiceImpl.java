package com.ttmall.service.impl;

import com.ttmall.dao.ProductMapper;
import com.ttmall.pojo.Product;
import com.ttmall.service.IProductService;
import com.ttmall.vo.ProductVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public ProductVo getProductById(Integer id) {
        Product product = productMapper.selectByPrimaryKey(id);

        return productToProductVo(product);
    }
    private ProductVo productToProductVo(Product product){
        if (product==null){
            return null;
        }
        ProductVo productVo = new ProductVo();
        BeanUtils.copyProperties(product,productVo);
        return productVo;
    }
}
