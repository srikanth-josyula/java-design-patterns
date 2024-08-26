package com.creational.objectpooling.pool;


import java.util.LinkedList;
import java.util.Queue;

import com.creational.objectpooling.model.ProductItem;

public class ProductItemPool {

    private final Queue<ProductItem> availableItems = new LinkedList<>();
    private final int maxPoolSize;

    // Constructor to set the maximum pool size
    public ProductItemPool(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    // Method to get a ProductItem from the pool
    public synchronized ProductItem acquireProductItem() {
        if (availableItems.isEmpty()) {
            // If pool is empty and max size is not reached, create a new object
            if (availableItems.size() < maxPoolSize) {
                return new ProductItem("Default Name", 0.0); // Default initialization
            } else {
                // Wait if pool is at max size
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return availableItems.poll();
    }

    // Method to return a ProductItem back to the pool
    public synchronized void releaseProductItem(ProductItem item) {
        if (availableItems.size() < maxPoolSize) {
            item.setName("Default Name");
            item.setPrice(0.0);
            availableItems.offer(item);
            notify();
        }
    }
    
    public synchronized int getCurrentPoolSize() {
        return availableItems.size();
    }
}

