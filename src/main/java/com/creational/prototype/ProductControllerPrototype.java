package com.creational.prototype;


import com.creational.prototype.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductControllerPrototype {

    // Sample default product
    @SuppressWarnings("serial")
	private Product defaultProduct = new Product(
            "electronics",
            "laptop",
            "Laptop Model X",
            999.99,
            new HashMap<String, String>() {{
                put("RAM", "16GB");
                put("Storage", "512GB SSD");
            }}
    );

    @GetMapping("/clone/shallow")
    public List<Map<String, Object>> shallowCloneProduct(@RequestParam(value = "ram") String ram,
                                                          @RequestParam(value = "storage") String storage) throws CloneNotSupportedException {

        // Create a shallow copy of the default product
        Product clonedProduct = defaultProduct.clone();

        clonedProduct.setConfiguration("RAM", ram);
        clonedProduct.setConfiguration("Storage", storage);

        Map<String, Object> originalProductMap = createProductResponseMap("original", defaultProduct);
        Map<String, Object> clonedProductMap = createProductResponseMap("cloned", clonedProduct);

        return Arrays.asList(originalProductMap, clonedProductMap);
    }

    @GetMapping("/clone/deep")
    public List<Map<String, Object>> deepCloneProduct(@RequestParam String ram, @RequestParam String storage) {

        Product clonedProduct = defaultProduct.deepClone();

        // Modify the cloned product's configuration
        clonedProduct.setConfiguration("RAM", ram);
        clonedProduct.setConfiguration("Storage", storage);

        // Create response maps for original and cloned products
        Map<String, Object> originalProductMap = createProductResponseMap("original", defaultProduct);
        Map<String, Object> clonedProductMap = createProductResponseMap("cloned", clonedProduct);

        // Return both the original and cloned product in a list
        return Arrays.asList(originalProductMap, clonedProductMap);
    }

    private Map<String, Object> createProductResponseMap(String origin, Product product) {
        Map<String, Object> productMap = new HashMap<>();
        productMap.put("origin", origin);
        productMap.put("category", product.getCategory());
        productMap.put("type", product.getType());
        productMap.put("name", product.getName());
        productMap.put("price", product.getPrice());
        productMap.put("configuration", product.getConfiguration());
        productMap.put("hashCode", product.hashCode());

        return productMap;
    }
}
