package com.creational.objectpooling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.creational.objectpooling.model.Product;
import com.creational.objectpooling.pool.ProductPool;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ProductPoolController {

    private final ProductPool productPool = new ProductPool();
 
    @GetMapping("/object-pool/acquire/product")
    public ResponseEntity<String> acquireProduct(@RequestParam String category, @RequestParam String type) {
        Map<String, Object> response = new HashMap<>();
        
        Product product = productPool.acquireProduct(category, type);
        response.put("category", product.getCategory());
        response.put("type", product.getType());
        response.put("hashCode", Integer.toHexString(product.hashCode()));
        response.put("availableCount", productPool.getAvailableCount());
        response.put("inUseCount", productPool.getInUseCount());

        System.out.println("Product acquired: " + product + " with hashCode: " + Integer.toHexString(product.hashCode()));

        return ResponseEntity.ok(convertMapToJson(response));
    }

    @GetMapping("/object-pool/release/product")
    public ResponseEntity<String> releaseProduct(@RequestParam String category, @RequestParam String type) {
        Map<String, Object> response = new HashMap<>();
        
        // Assuming we acquire and release the same product for simplicity
        Product product = productPool.acquireProduct(category, type);
        productPool.releaseProduct(product);

        response.put("message", "Product released back to pool");
        response.put("hashCode", Integer.toHexString(product.hashCode()));
        response.put("availableCount", productPool.getAvailableCount());
        response.put("inUseCount", productPool.getInUseCount());

        System.out.println("Product released: " + product + " with hashCode: " + Integer.toHexString(product.hashCode()));

        return ResponseEntity.ok(convertMapToJson(response));
    }

    private String convertMapToJson(Map<String, Object> map) {
        try {
            return new ObjectMapper().writeValueAsString(map);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}"; // Return empty JSON in case of an error
        }
    }
}
