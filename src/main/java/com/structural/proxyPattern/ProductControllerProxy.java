package com.structural.proxyPattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.structural.proxyPattern.proxy.ProductProxy;
import com.structural.proxyPattern.service.Product;

@RestController
public class ProductControllerProxy {

    @GetMapping("/proxy/produce")
    public String produceProduct(@RequestParam String type) {
        try {
            Product productProxy = new ProductProxy(type);
            productProxy.produce();
            return "Product produced successfully with proxy!";
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }
}
