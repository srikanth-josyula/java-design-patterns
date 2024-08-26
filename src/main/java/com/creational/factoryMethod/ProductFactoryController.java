package com.creational.factoryMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.creational.factoryMethod.factory.ProductFactory;
import com.creational.factoryMethod.factory.impl.ConcreteProductFactory;
import com.creational.factoryMethod.products.Product;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductFactoryController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/factory-method/create/product")
    public ResponseEntity<String> createProduct(@RequestParam String type) {
        ProductFactory factory = new ConcreteProductFactory();
        Product product;
        Map<String, Object> response = new HashMap<>();

        try {
            product = factory.createProduct(type);
            String className = product.getClass().getSimpleName();
            String hashCode = Integer.toHexString(product.hashCode());

            response.put("type", type);
            response.put("className", className);
            response.put("hashCode", hashCode);

            return ResponseEntity.ok(convertMapToJson(response));
        } catch (IllegalArgumentException e) {
            response.put("type", type);
            response.put("className", "Unknown");
            response.put("hashCode", "Unknown");
            return ResponseEntity.ok(convertMapToJson(response));
        }
    }

    private String convertMapToJson(Map<String, Object> map) {
        try {
            return objectMapper.writeValueAsString(map);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}"; // Return empty JSON in case of an error
        }
    }
}
