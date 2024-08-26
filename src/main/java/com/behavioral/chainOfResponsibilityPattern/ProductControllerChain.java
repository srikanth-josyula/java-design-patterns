package com.behavioral.chainOfResponsibilityPattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.behavioral.chainOfResponsibilityPattern.handler.concrete.ElectronicProductHandler;
import com.behavioral.chainOfResponsibilityPattern.handler.concrete.GroceryProductHandler;
import com.behavioral.chainOfResponsibilityPattern.service.ProductHandler;


@RestController
public class ProductControllerChain {

    private final ProductHandler chain;

    public ProductControllerChain() {
        // Setting up the chain
        ProductHandler electronicHandler = new ElectronicProductHandler();
        ProductHandler groceryHandler = new GroceryProductHandler();
        
        // Configure chain: electronicHandler -> groceryHandler
        electronicHandler.setNextHandler(groceryHandler);

        // Set the chain in the controller
        this.chain = electronicHandler;
    }

    @GetMapping("/chain/produce")
    public String produceProduct(@RequestParam String type, @RequestParam(required = false) String features) {
        try {
            chain.handleRequest(type, features != null ? features : "none");
            return "Product processed successfully!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}