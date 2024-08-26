# Factory Method Pattern
* The Factory Method Pattern defines an interface for creating an object, but allows subclasses to alter the type of objects that will be created. It lets a class defer instantiation to its subclasses, providing a way to delegate the responsibility of creating objects to subclasses.
* **Purpose:** Provides a way to delegate the instantiation logic to subclasses, allowing for more flexible and reusable code.
* Structure:
  - Product: Defines the interface for objects the factory method creates.
  - Concrete Products: Implement the Product interface. These are the specific instances that are created by the factory method.
  - Creator: Declares the factory method, which returns a Product object. The creator may also define a default implementation for the factory method that returns a default Product.
  - Concrete Creators: Override the factory method to return an instance of a Concrete Product.

## This Project Use Case
* In this example, we'll use the Factory Method Pattern to create various types of products (Laptop, Mobile, Pantry, and Produce).
* The factory method will be implemented in a concrete factory class, which will determine the specific product to be created based on the provided type.
* Structure:
  - Product: Product interface
  - Concrete Products: LaptopProduct, MobileProduct, PantryProduct, ProduceProduct
  - Creator: ProductFactory interface
  - Concrete Creator: ConcreteProductFactory
  - Client: ProductFactoryController

## When to use Factory Method Pattern
* When a class can’t anticipate the class of objects it must create: The Factory Method Pattern allows the client code to rely on a method that will be implemented by subclasses, ensuring that the correct product is created.
* When a class wants its subclasses to specify the objects it creates: The pattern delegates the instantiation process to subclasses, promoting loose coupling between the client code and the product creation logic.
* To provide a controlled way to create objects: It offers a controlled mechanism for creating objects, especially useful when the creation process involves complex logic.

## When not to use Factory Method Pattern
* When you have only a single type of product: If your application does not require the creation of multiple types of objects, the Factory Method Pattern may add unnecessary complexity.
* When the overhead of creating multiple classes is too high: For simple scenarios where the creation logic is straightforward, a more direct approach might be preferable.

## Use Cases
- GUI Frameworks: Factory Method Pattern is often used in GUI frameworks to create different types of UI components (e.g., buttons, text fields) without specifying the exact class of the component.
- Document Editors: In a document editor application, the Factory Method can be used to create different types of documents (e.g., text documents, spreadsheets) depending on user choice.

## Use Cases in Java
* Java I/O Library: The Java I/O library uses the Factory Method Pattern in the InputStream and OutputStream classes. Subclasses like FileInputStream and BufferedInputStream implement the creation of specific types of input streams.
* Java Logging Framework: The Logger class in Java's logging framework uses a factory method to provide different logging implementations depending on the configuration.