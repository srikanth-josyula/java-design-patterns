package com.structural.flyweightPattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.structural.flyweightPattern.factory.ProductContext;

@RestController
public class ProductControllerFlyweight {

    private final ProductContext productContext = new ProductContext();

    @GetMapping("/flyweight/produce")
    public String produceProduct(@RequestParam String type, @RequestParam(required = false) String features) {
        try {
            productContext.produceProduct(type, features != null ? features : "none");
            return "Product produced successfully with the specified features!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}