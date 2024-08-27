package com.creational.objectpooling.pool;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.creational.objectpooling.model.Product;

public class ProductPool {
	
    private final Queue<Product> pool = new ConcurrentLinkedQueue<>();
    private final Queue<Product> inUse = new ConcurrentLinkedQueue<>();

    public ProductPool() {
        pool.offer(new Product("electronics", "laptop"));
        pool.offer(new Product("groceries", "apple"));
        pool.offer(new Product("electronics", "mobile"));
    }

    public Product acquireProduct(String category, String type) {
        Product product = pool.poll();  // Retrieves and removes the head of the queue
        if (product == null) {
            // If the pool is empty, create a new Product
            product = new Product(category, type);
            System.out.println("Created new product: " + product);
        } else {
            product.reset(); 
            System.out.println("Acquired product from pool: " + product);
        }
        inUse.offer(product); // Add product to in-use list
        return product;
    }

    public void releaseProduct(Product product) {
        inUse.remove(product);  // Remove from in-use list
        pool.offer(product);    // Adds the product back to the end of the queue
        System.out.println("Released product back to pool: " + product);
    }

    public int getAvailableCount() {
        return pool.size();
    }

    public int getInUseCount() {
        return inUse.size();
    }
}
