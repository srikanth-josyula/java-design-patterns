package com.creational.singletonMethod.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.creational.singletonMethod.model.ProductItem;
import com.creational.singletonMethod.singleton.EagerSingletonProductDBEntry;

@Service
public class ProductServiceSingleton {

    public String addProduct(String productType) {
    	
    	//Classic Singleton
    	//ClassicProductDBEntry productDBEntry = ClassicProductDBEntry.getInstance();
        
        //Eager Singleton
        EagerSingletonProductDBEntry productDBEntry = EagerSingletonProductDBEntry.getInstance();
        
        //Static Block Singleton
    	//StaticBlockSingletonProductDBEntry productDBEntry = StaticBlockSingletonProductDBEntry.INSTANCE;
        
        
        ProductItem product = new ProductItem(productType);
        Map<String, String> productEntry = productDBEntry.putProduct(product);
        
        // Return a response including the hashcode and the product ID added
        return "ProductDBEntry HashCode: " + productDBEntry.hashCode() +
               ", Product Added: ID = " + product.getId() + ", Name = " + product.getName();
    }
}
