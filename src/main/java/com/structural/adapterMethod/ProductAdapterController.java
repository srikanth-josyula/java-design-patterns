package com.structural.adapterMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.structural.adapterMethod.adapter.ElectronicProductAdapter;
import com.structural.adapterMethod.adapter.GroceryProductAdapter;
import com.structural.adapterMethod.service.ProductService;

@RestController
@RequestMapping("/adapter/products")
public class ProductAdapterController {
	
	 private final ProductService electronicProductService;
	    private final ProductService groceryProductService;

	    @Autowired
	    public ProductAdapterController(ElectronicProductAdapter electronicProductService,
	                             GroceryProductAdapter groceryProductService) {
	        this.electronicProductService = electronicProductService;
	        this.groceryProductService = groceryProductService;
	    }

	    @PostMapping("/add")
	    public ResponseEntity<String> addProduct(@RequestParam String type, @RequestParam String name) {
	        if ("electronic".equalsIgnoreCase(type)) {
	            electronicProductService.addProduct(name);
	            return ResponseEntity.ok("Electronic product added successfully.");
	        } else if ("grocery".equalsIgnoreCase(type)) {
	            groceryProductService.addProduct(name);
	            return ResponseEntity.ok("Grocery product added successfully.");
	        } else {
	            return ResponseEntity.badRequest().body("Invalid product type.");
	        }
	    }

	    @GetMapping("/get")
	    public ResponseEntity<String> getProduct(@RequestParam String type, @RequestParam String id) {
	        String productDetails;
	        if ("electronic".equalsIgnoreCase(type)) {
	            productDetails = electronicProductService.getProduct(id);
	        } else if ("grocery".equalsIgnoreCase(type)) {
	            productDetails = groceryProductService.getProduct(id);
	        } else {
	            return ResponseEntity.badRequest().body("Invalid product type.");
	        }
	        return ResponseEntity.ok(productDetails);
	    }
}
