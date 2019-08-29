package com.ttmall.controller;

import com.ttmall.common.ServerResponse;
import com.ttmall.service.IProductService;
import com.ttmall.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired

    @GetMapping(value = "/getproductinfo")
    @ResponseBody
    public ServerResponse<ProductVo> getProductInfo(@RequestParam(name = "id")Integer id){
        ProductVo productVo = iProductService.getProductById(id);
        if (productVo == null){
            return ServerResponse.createBySuccess(productVo,"亲，这件商品已经下架哦");
        }else {
            return ServerResponse.createBySuccess(productVo);
        }

    }
}
