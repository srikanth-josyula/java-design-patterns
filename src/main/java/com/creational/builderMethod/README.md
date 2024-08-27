# Builder Pattern
The Builder pattern is a creational design pattern that allows you to construct complex objects step by step. It separates the construction of a complex object from its representation, so the same construction process can create different representations.

* **Purpose:**  Simplifies the creation of complex objects by providing a clear, step-by-step process, allowing for more readable and maintainable code.
* Structure:
  - Builder: Provides methods to configure the different parts of the product. Typically returns the builder itself (method chaining).
  - Concrete Builder: Implements the Builder interface, providing the actual logic for configuring and creating the product.
  - Product: The complex object being built.
  - Client: Directs the building process using the builder.
  - This Project Use Case

In this example, we'll create a builder pattern for constructing complex Product objects. The Product object requires some mandatory fields (like category and type) and may include optional fields (like name and price).
* Structure:
  - Builder: ProductBuilder
  - Product: Product
  - Client: ProductAbstractFactoryController

## When to Use Builder Pattern

* Creating Complex Objects: Use the Builder pattern when creating a complex object that involves many steps or configurations, especially if the object has many optional fields or variations.
* Immutability: When you want to ensure that the constructed object is immutable, the Builder pattern allows setting all required fields during construction.
* Reusability: The Builder pattern allows reusing the same construction code to create different representations of an object, reducing redundancy.
* Readability: The pattern improves the readability of object creation by clearly showing which fields are being set and their values.

## When Not to Use Builder Pattern

* Simple Objects: If the object you're creating is simple and doesn't involve multiple configurations, the Builder pattern might introduce unnecessary complexity.
* Overhead: For small objects or objects that rarely change, the overhead of implementing a builder might not be justified.
* Direct Instantiation: If an object has only a few fields and they can be set directly via a constructor or setters, the Builder pattern may be overkill.

## Use Cases
* Configuring Complex Objects: The Builder pattern is ideal when an object requires several fields to be set, and some of them are optional or have default values.
* Fluent APIs: The pattern is commonly used in fluent APIs, where methods return the object itself, allowing method chaining.

## Use Cases in Java
* StringBuilder (java.lang.StringBuilder): The StringBuilder class in Java uses a builder pattern to efficiently create and manipulate strings. It allows appending, inserting, or modifying strings without creating new instances every time.
* Java Streams (java.util.stream.Stream): The stream API in Java follows a builder pattern style with method chaining, where you can construct a sequence of operations on data and finally collect the result.
* Lombok's @Builder Annotation: Lombok provides a @Builder annotation that automatically generates a builder for your classes, simplifying the creation of complex objects.
