# URL Diagram for Abstract Factory Pattern

## Overview

This diagram illustrates the flow of requests through the Spring Boot application using the Abstract Factory pattern.

## Diagram
+------------------------+ | | | Client Request | | | | GET /abstract-factory/create/product?category={category}&type={type} | | | +-----------+------------+ | | v +-----------+------------+ | | | ProductAbstractFactoryController | | | | 1. Determine Factory based on category | | 2. Create Product based on type | | | +-----------+------------+ | | v +-----------+------------+ +-----------------------------+ | | | | | ElectronicProductFactory | | GroceryProductFactory | | | | | | 1. Creates Electronic Product | 1. Creates Grocery Product | | - MobileProduct | | - ProduceProduct | | - LaptopProduct | | - PantryProduct | | | | | +-----------+------------+ +-----------------------------+ | | | | v v +-----------+------------+ +-----------------------------+ | | | | | Product Interface | | Product Interface | | | | | | - MobileProduct | | - ProduceProduct | | - LaptopProduct | | - PantryProduct | | | | | +-----------+------------+ +-----------------------------+ | | v +-----------+------------+ | | | ProductResponse | | | | JSON Response with: | | - category | | - type | | - className | | - hashCode | | | +------------------------+ | | v +------------------------+ | | | Client Response | | | | JSON Response with: | | - category | | - type | | - className | | - hashCode | | | +------------------------+

## Description

1. **Client Request**: The client sends a GET request to `/abstract-factory/create/product` with parameters `category` and `type`.

2. **ProductAbstractFactoryController**:
   - Determines the appropriate factory (`ElectronicProductFactory` or `GroceryProductFactory`) based on the `category`.
   - Uses the factory to create the specific product based on the `type`.
   - Constructs a `ProductResponse` containing details about the created product.

3. **Concrete Factories**:
   - **ElectronicProductFactory**: Creates electronic products like `MobileProduct` or `LaptopProduct`.
   - **GroceryProductFactory**: Creates grocery products like `ProduceProduct` or `PantryProduct`.

4. **Product Interface**:
   - Defines common methods for products.

5. **ProductResponse**:
   - Constructs a JSON response with `category`, `type`, `className`, and `hashCode`.

6. **Client Response**:
   - The client receives a JSON response with the product details.