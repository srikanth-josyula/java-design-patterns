package com.sample.model.products;

public interface ElectronicProducts extends Products {
	void createMobiles(String manufacturer, String modelName);
	void createLaptops();
	
	// Prototype method for cloning
    ElectronicProducts clone();
}
