# URL Diagram for Abstract Factory Pattern

## Overview

This diagram illustrates the flow of requests through the Spring Boot application using the Abstract Factory pattern.

## Diagram
+-------------------------------------------+
|               Client Request              |
|   GET /abstract-factory/create/product    |
|   ?category={category}&type={type}        |
+-----------------------+-------------------+
                        |
                        v
+-----------------------+-------------------+
|  ProductAbstractFactoryController         |
|   - Receives request parameters            |
|   - Determines the appropriate factory     |
|   - Creates product using the factory      |
|   - Prepares JSON response with product info|
+-----------------------+-------------------+
                        |
                        v
+-----------------------+-------------------+
|    Abstract Factory (ProductFactory)       |
|   - Defines the method for creating products|
+-----------------------+-------------------+
                        |
                        v
+-----------------------------+    +-----------------------------+
|   ElectronicProductFactory  |    |    GroceryProductFactory    |
|   - Implements ProductFactory|    |    - Implements ProductFactory|
|   - Creates electronic products |  |   - Creates grocery products |
|     e.g., LaptopProduct,     |    |    e.g., ProduceProduct,    |
|     MobileProduct            |    |    PantryProduct            |
+-----------------------------+    +-----------------------------+
            |                               |
            v                               v
+------------------------+      +------------------------+
|    Concrete Products   |      |    Concrete Products   |
|  - LaptopProduct       |      |  - ProduceProduct      |
|  - MobileProduct       |      |  - PantryProduct       |
+------------------------+      +------------------------+
            |                               |
            v                               v
+------------------------+      +------------------------+
|      Product Interface |      |      Product Interface |
|   - Defines methods    |      |   - Defines methods    |
+------------------------+      +------------------------+
            |
            v
+------------------------+
|      Product Response  |
|   - category           |
|   - type               |
|   - className          |
|   - hashCode           |
+------------------------+
            |
            v
+------------------------+
|         Client Response|
|   - JSON Response with |
|     product details    |
+------------------------+

## Description

1. **ProductAbstractFactoryController**: The client sends a GET request to `/abstract-factory/create/product` with parameters `category` and `type`.
   - Determines the appropriate factory (`ElectronicProductFactory` or `GroceryProductFactory`) based on the `category`.
   - Uses the factory to create the specific product based on the `type`.
   - Constructs a `ProductResponse` containing details about the created product.
2. **Abstract Factory (Interface: ProductFactory)**:
3. **Concrete Factories (ElectronicProductFactory and GroceryProductFactory)**:
   - **ElectronicProductFactory**: Creates electronic products like `MobileProduct` or `LaptopProduct`.
   - **GroceryProductFactory**: Creates grocery products like `ProduceProduct` or `PantryProduct`.
4. **Abstract Products (Interface: Product)**:
5. **Concrete Products (LaptopProduct, MobileProduct, ProduceProduct, PantryProduct)**
