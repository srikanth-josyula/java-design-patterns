package com.creational.objectpooling.controller;

import com.creational.objectpooling.model.ProductItem;
import com.creational.objectpooling.pool.ProductItemPool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pool/product")
public class ProductPoolController {

    private final ProductItemPool productItemPool;

    public ProductPoolController() {
        this.productItemPool = new ProductItemPool(10);
    }

    @GetMapping("/acquire")
    public Map<String, Object> acquireProductItem(@RequestParam String name, @RequestParam double price) {
        ProductItem productItem = productItemPool.acquireProductItem();
        productItem.setName(name);
        productItem.setPrice(price);

        // Print hashCode to understand if the same object is being reused
        System.out.println("Acquired ProductItem with hashCode: " + productItem.hashCode());

        Map<String, Object> response = new HashMap<>();
        response.put("productItem", productItem);
        response.put("hashCode", productItem.hashCode());
        response.put("currentPoolSize", productItemPool.getCurrentPoolSize());
        response.put("message", "ProductItem acquired from the pool");

        return response;
    }

    @GetMapping("/release")
    public Map<String, Object> releaseProductItem(@RequestParam String name) {
        ProductItem productItem = productItemPool.acquireProductItem();
        Map<String, Object> response = new HashMap<>();
        
        if (productItem.getName().equals(name)) {
            productItemPool.releaseProductItem(productItem);
            response.put("productItem", productItem);
            response.put("hashCode", productItem.hashCode());
            response.put("currentPoolSize", productItemPool.getCurrentPoolSize());
            response.put("message", "ProductItem released back to the pool");
        } else {
            response.put("message", "ProductItem not found");
        }

        return response;
    }
}

