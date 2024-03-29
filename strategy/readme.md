### Why use the Strategy Pattern

- When you want to use different variants of an algorithm within an object and be able to switch from one algorithm to another during runtime.
- When you have a lot of similar classes that only differ in the way they execute some behavior.
- To isolate the business logic of a class from the implementation details of algorithms that may not be as important in the context of that logic.
- When your class has a massive conditional statement that switches between different variants of the same algorithm.

#### Promise
The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. 
Strategy lets the algorithm vary independently of clients that use it.

#### Pros

- You can swap algorithms used inside an object at runtime
- You can isolate the implementation details of an algorithm from the code that uses it
- You can replace inheritance with composition
- Open/Closed Principle. You can introduce new strategies without having to change the context

#### Cons

- In case of only a couple of algorithms that rarely change, there’s no real reason to overcomplicate the program with new classes and interfaces that come along with the pattern.
- Clients must be aware of the differences between strategies to be able to select a proper one.
- A lot of modern programming languages have functional type support that lets you implement different versions of an algorithm inside a set of anonymous functions. Then you could use these functions exactly as you’d have used the strategy objects, but without bloating your code with extra classes and interfaces.

## Adventure Game

An action adventure game with *Kings*, *Queens* and *Knights*! (who knows what else...)

### Define character abstract class

All `Character` can `fight()` and `walk()`. We will override `display()` on each implementation in order to draw each character.

```mermaid
classDiagram
    Character <|-- King
    Character <|-- Queen
    Character <|-- Knight
    Character: +fight()
    Character: +walk()
    Character: +display()*
    class King{
        +display()
    }
    class Queen{
        +display()
    }
    class Knight{
        +display()
    }
```

### Characters shall climb

Try with inheritance add `climb()` method in Character

### But Dwarfs should not climb

Override `climb()` in *Dwarfs* so they will not climb?

**But** *Trolls* cannot climb either or fight with a Sword...

**AND** a Dwarfs can only fight with their Axe...

**AND** ... 

### Embrace Change!
> Identify the aspects of your application that vary and separate them

We know that `fight()` and `climb()` vary between **Characters**:

| Character         | `fight()`      | `climb()` |
|-------------------|----------------|-----------|
| King/Knight/Queen | SwordAttack    | HandClimb |
| Dwarf             | AxeAttack      | ClimbNot  |
| Troll             | BareHandAttack | ClimbNot  |

Pullout `fight()` and `climb()` from `Character` as they vary between characters

### Implement AttackMethod and ClimbBehaviour

`AttackMethod#attack()`

```mermaid
classDiagram
    AttackMethod <|.. SwordAttack
    AttackMethod <|.. AxeAttack
    AttackMethod <|.. BareHandAttack
    class AttackMethod
    <<interface>> AttackMethod
    AttackMethod: +attack()
    class SwordAttack{
        +attack()
    }
    class AxeAttack{
        +attack()
    }
    class BareHandAttack{
        +attack()
    }
```

`ClimbBehaviour#climb()`

```mermaid
classDiagram
    ClimbBehaviour <|.. HandClimb
    ClimbBehaviour <|.. ClimbNot
    class ClimbBehaviour
    <<interface>> ClimbBehaviour
    ClimbBehaviour: +climb()
    class HandClimb{
        +climb()
    }
    class ClimbNot{
        +climb()
    }
```


### Integrate attack method and climb behaviour in Character

1. Add `AttackMethod` and `ClimbBehaviour` instance variables in Character
2. Change `fight()` and `climb()` so that delegates to the corresponding instances above
3. Integrate attack methods and climb behaviours to all the `Character` implementations


```mermaid
classDiagram
    class Character {
    <<Abstract>>
        #attackMethod
        #climbBehaviour
        +fight()
        +climb()
        +walk()
        +display()* 
        +setClimbBehaviour()
    }
    Character <|-- King
    King: display()
    Character <|-- Queen
    Queen: display()
    Character <|-- Knight
    Knight: display()
    Character <|-- Dwarf
    Dwarf: display()
    Character <|-- Troll
    Troll: display()
```