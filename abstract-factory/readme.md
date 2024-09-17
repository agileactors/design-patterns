### Why use the Abstract Factory Pattern

- Use the Abstract Factory when your code needs to work with various families of related products, but you don’t want it to depend on the concrete classes of those products 
- The Abstract Factory provides you with an interface for creating objects from each class of the product family. As long as your code creates objects via this interface, you don’t have to worry about creating the wrong variant of a product which doesn’t match the products already created by your app.

#### Pros

- You can be sure that the products you’re getting from a factory are compatible with each other. 
- You avoid tight coupling between concrete products and client code.
- Single Responsibility Principle. You can extract the product creation code into one place, making the code easier to support. 
- Open/Closed Principle. You can introduce new variants of products without breaking existing client code.

#### Cons

- The code may become more complicated than it should be, since a lot of new interfaces and classes are introduced along with the pattern.