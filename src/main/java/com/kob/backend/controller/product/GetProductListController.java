package com.kob.backend.controller.product;

import com.kob.backend.pojo.Product;
import com.kob.backend.service.user.author.GetAuthorListService;
import com.kob.backend.service.user.product.GetProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetProductListController {
    @Autowired
    private GetProductListService getProductListService;

    @GetMapping("/product/getlist/")
    public List<Product> getList() {
        return getProductListService.getList();
    }
}