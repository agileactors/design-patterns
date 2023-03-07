### Why use the Factory Pattern

- Creating an object directly within the class that needs or should use this object is possible, but very inflexible.
  It binds the class to this object and makes it impossible to change the instantiation independently of the class
- This kind of code is avoided in the factory pattern approach by first defining a separate operation for creating the
  object
  – the factory method. As soon as this is called up, it generates the object instead of the class constructor already
  mentioned.

#### Pros

- Object creation is independent of business logic. If we add another case in the future the main function won’t change.
- Meaningful method name

#### Cons

- High number of required classes
- Adding a method to interface will force all classes to implement it. I of SOLID principles is violated.

#### Used at

- getInstance() method of java.util.Calendar, NumberFormat, and ResourceBundle uses factory method design pattern.
- All the wrapper classes like Integer, Boolean etc, in Java uses this pattern to evaluate the values using valueOf()
  method

### Explaining the app

- The current app is a Spring Boot application that exposes a REST API for a company that transports different kind of
  cargos from a place to another. In the first version, things are simple: we only transport via truck so the
  Transportation
  service instantiates a Truck object to do some actions on the cargo and transport it. In the second version, things
  are
  more complicated as company has expanded, and it uses a Geography service that decides how to transport the cargo.
  Based
  on the response it instantiates different object and then perform the same actions. This second version depicts
  exactly the
  problem that Factory tries to solve. The final third version applies the Factory pattern in the previous messy code.