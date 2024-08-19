package com.creational.objectpooling.pool;

import com.creational.objectpooling.model.ProductItem;

import java.util.LinkedList;
import java.util.Queue;

public class ProductItemPool {

    private final Queue<ProductItem> availableItems = new LinkedList<>();
    private final int maxPoolSize;
    private int totalItemsCreated = 0;

    public ProductItemPool(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public synchronized ProductItem acquireProductItem() {
        if (!availableItems.isEmpty()) {
            ProductItem item = availableItems.poll();
            System.out.println("Acquired existing ProductItem from pool: " + item.hashCode());
            return item;
        } else if (totalItemsCreated < maxPoolSize) {
            ProductItem newItem = new ProductItem("Default Name", 0.0);
            totalItemsCreated++;
            System.out.println("Created new ProductItem: " + newItem.hashCode());
            return newItem;
        } else {
            try {
                System.out.println("Pool is empty. Waiting for an item to be released...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return acquireProductItem();
        }
    }

    public synchronized void releaseProductItem(ProductItem item) {
        if (availableItems.size() < maxPoolSize) {
            item.setName("Default Name");
            item.setPrice(0.0);
            availableItems.offer(item);
            System.out.println("Released ProductItem back to pool: " + item.hashCode());
            notifyAll();
        }
    }

    public synchronized int getCurrentPoolSize() {
        return availableItems.size();
    }

    public synchronized int getTotalItemsCreated() {
        return totalItemsCreated;
    }
}
