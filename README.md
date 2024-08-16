# Java Design Patterns Example Project
Design patterns are programming language independent strategies for solving the common object-oriented design problems.
## Project Outline: E-commerce Platform Backend
This project will demonstrate the use of various design patterns within the context of an e-commerce platform. The platform will handle product management, user accounts, order processing, payment handling, and more. </br>
**Technology Stack:** Java, Spring Boot, Hibernate, MySQL, Maven, REST API

## Creational Patterns
Focus on the process of object creation, providing mechanisms to create objects in a manner suitable to the situation.</br>
* **Factory Method Pattern:** Creates objects without specifying the exact class of object that will be created. The Factory Method Pattern delegates the creation of objects to a factory method, allowing subclasses to alter the type of objects that will be created without modifying the client code. 
  - **Use Case:** Creating different types of User objects (e.g., Admin, Customer, Seller) based on user input during registration. A UserFactory class that returns different subclasses of User depending on the provided type. The UserFactory creates different User objects based on the provided user type, with each concrete User class implementing the User interface
* **Abstract Factory Pattern:** Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
  - **Use Case:** Providing a family of related products like ElectronicProductFactory and GroceryProductFactory which produce products such as Phone, Laptop, Produce, Pantry.
Code Implementation: An interface ProductFactory with concrete factories implementing the creation of specific types of products.
* **Singleton Pattern:** Ensures a class has only one instance and provides a global point of access to it.
* **Prototype Pattern:** Creates new objects by copying an existing object (prototype) rather than creating new instances from scratch.
* **Builder Pattern:** Constructs a complex object step by step. Allows for more readable code and construction of different representations.
* **Object Pool Pattern:** Manages a pool of reusable objects. It is used to manage expensive-to-create objects in scenarios where the number of instances in use at any one time is low.

## Structural Patterns
Deal with object composition and relationships, helping to organize and structure systems by connecting different classes and objects.
* **Adapter Pattern:**  Allows incompatible interfaces to work together by converting one interface into another expected by the client.
* **Bridge Pattern:**  Separates an object’s abstraction from its implementation, so they can vary independently.
* **Composite Pattern:**  Composes objects into tree-like structures to represent part-whole hierarchies. Clients treat individual objects and compositions uniformly.
* **Decorator Pattern:**  Dynamically adds responsibilities to objects. Provides an alternative to subclassing for extending functionality.
* **Facade Pattern:**  Provides a simplified interface to a complex subsystem, making it easier to use.
* **Flyweight Pattern:**  Minimizes memory use by sharing as much data as possible with other similar objects.
* **Proxy Pattern:**  Provides a surrogate or placeholder for another object to control access to it.

## Behavioral Patterns
Concerned with communication between objects, defining the interactions and responsibilities between them to manage complex control flows.
* **Chain of Responsibility Pattern:** Passes a request along a chain of handlers, where each handler either handles the request or passes it to the next handler in the chain.
* **Command Pattern:** Encapsulates a request as an object, allowing for parameterization of clients with queues, requests, and operations.
* **Interpreter Pattern:** Defines a grammatical representation for a language and an interpreter to interpret sentences in the language.
* **Iterator Pattern:** Provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
* **Mediator Pattern:** Defines an object that encapsulates how a set of objects interact, promoting loose coupling.
* **Memento Pattern:** Captures and externalizes an object’s internal state so that it can be restored later without violating encapsulation.
* **Observer Pattern:** Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
* **State Pattern:** Allows an object to alter its behavior when its internal state changes, appearing to change its class.
* **Strategy Pattern:** Defines a family of algorithms, encapsulates each one, and makes them interchangeable.
* **Template Method Pattern:** Defines the skeleton of an algorithm in a method, deferring some steps to subclasses.
