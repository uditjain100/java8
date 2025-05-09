# Java 8 Feature Exploration Project

This project is a comprehensive exploration of Java 8 and core Java concepts, structured into modular directories to demonstrate various topics such as functional interfaces, lambda expressions, streams, method references, inner classes, enums, encapsulation, inheritance, and more. It includes examples and implementations ranging from basic syntax to advanced programming concepts.

---

## 📁 Project Structure

Each folder in `src/` represents a topic or concept area. Below is an overview:

### 📦 AbstractClass

- Demonstrates abstract classes, inheritance, and abstract inner classes.
- `AbstractInnerClass.java`: Contains examples of nested abstract class usage.

### 📦 DateAndTime

- Introduces overriding techniques and vehicle class examples.
- Focuses on behavior polymorphism with `Car`, `SportsCar`, and method overriding.

### 📦 DoubleBrace

- Showcases double brace initialization and static blocks.

### 📦 Encapsulation

- Demonstrates encapsulation using a `Student` class with private fields and accessors.

### 📦 EnumsDir

- Includes enum examples and how Java 8 allows dynamic behavior in enums.

### 📦 finalDir

- Shows final keyword usage with methods and classes.

### 📦 GC (Garbage Collection)

- Covers finalization techniques, custom finalize methods, and the concept of island of isolation in memory management.

### 📦 Generics

- Demonstrates the use of generics in class and method definitions using `CEO`, `Manager`, and `Employee`.

### 📦 immutableClass

- Shows how to create immutable classes, an essential principle in Java programming.

### 📦 InnerClasses

- Contains anonymous, local, member, static nested, and subclass examples of inner classes.

### 📦 instanceOf

- Provides examples of the `instanceof` operator for type checking.

### 📦 Instances

- Explores object instantiation, class references, and runtime polymorphism.

### 📦 Interfaces

- Demonstrates interface implementation, default and static methods, and includes:
  - Functional Interfaces: `Consumer`, `Supplier`, `Predicate`, `Function`
  - Comparable and Comparator examples
  - Nested interfaces and multiple inheritance with interfaces

### 📦 Lambda

- Covers lambda syntax, variable capturing, threading with lambdas, and reusable functional patterns.

### 📦 MethodReference

- Explains different types of method references:
  - Static
  - Instance
  - Constructor references

### 📦 MultiThreading

- Includes lifecycle of threads, basic thread implementation, and synchronization primitives.

### 📦 OptionalDir

- Demonstrates usage of the `Optional` class to avoid `NullPointerException`.

### 📦 Polymorphism

- Examples of runtime polymorphism and class hierarchies using car types.

### 📦 Relationship

- Shows object relationships like association, aggregation, and inheritance hierarchies.

### 📦 SingletonClass

- Implementation of the Singleton design pattern with Daemon thread examples.

### 📦 StreamsDir

- Core Java 8 feature covering:
  - Stream pipeline
  - Intermediate and terminal operations
  - File-based stream examples

### 📦 Synchronization

- Demonstrates thread safety using synchronization blocks and counters.

### 📦 WrapperClass

- Examples showing Java's wrapper classes for primitive data types.

---

## ✅ Features Demonstrated

- ✅ Abstract Classes and Interfaces
- ✅ Lambda Expressions
- ✅ Method References
- ✅ Functional Interfaces (Consumer, Supplier, Predicate, Function)
- ✅ Streams API
- ✅ Optional Class
- ✅ Double Brace Initialization
- ✅ Final Keywords
- ✅ Singleton Design Pattern
- ✅ Generics
- ✅ Immutable Objects
- ✅ Wrapper Classes
- ✅ Threading and Synchronization
- ✅ Object Relationships and Inheritance

---

## 🛠️ Compilation and Running

To compile the project:

```bash
javac -d bin src/**/*.java
```

To run a specific class, for example:

```bash
java -cp bin Lambda.LambdaDemo
```

Make sure you're using JDK 8 or higher.

---

## 📌 Requirements

- Java JDK 8+
- IDE such as IntelliJ IDEA or Eclipse (optional but recommended)

---

## 📄 Notes

- This project is educational in nature.
- It is created for juniors and for my own revision.
- It can be used as a reference for learning, interviews, or teaching core and modern Java concepts.
- You can modify individual class files for experimentation or further enhancement.

---

## 🤝 Contributions

Contributions and suggestions are welcome. If you'd like to add examples, improve documentation, or refactor code, feel free to fork and open a pull request.

---

## 👨‍💻 Author

- **Udit Jain**  
  M.Tech CSE Student,
  National Institute of Technology, Warangal  
  Roll No: 24CSM1R23  
  Email: jain30udit@gmail.com
