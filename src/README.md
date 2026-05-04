# Game Patterns

A simple Java text-based adventure game built to demonstrate core software architecture concepts and design patterns.

---

## Design Patterns Used

### Strategy Pattern
Defines a family of interchangeable behaviors for player actions.

- Implemented via `ActionStrategy`
- Concrete strategies:
    - `SearchStrategy`
    - `MoveStrategy`
    - `TakeAssetStrategy`
    - `UseItemStrategy`

**Benefit:**  
New actions can be added without modifying existing game logic.

---

### Singleton Pattern
Ensures only one instance of a class exists and provides a global access point.

- Implemented by `GameManager`

**Benefit:**  
Maintains a single shared game state across the entire application.

---

### Factory Method Pattern
Encapsulates object creation logic.

- Implemented by `AssetFactory`
- Creates: `Key`, `Coin`, `Lantern`

**Benefit:**  
Centralizes creation logic and removes direct dependency on concrete classes.

---

### Observer Pattern
Defines a one-to-many relationship where objects are notified of state changes.

- `GameEventListener` (interface)
- `ConsoleNotifier`, `AchievementTracker` (observers)
- `GameManager` (subject)

**Benefit:**  
Decouples event handling from core game logic.

---

### JUnit
Unit testing framework used to validate functionality.

**Tests include:**
- Factory creation (`AssetFactoryTest`)
- Player inventory (`PlayerTest`)
- Room navigation (`RoomTest`)
- Singleton behavior (`GameManagerTest`)
- Win condition (`UseItemStrategyTest`)

---

## Core Principles Used

### GRASP (General Responsibility Assignment Software Patterns)

- **Controller:**  
  `GameManager` acts as the central coordinator for game state and events.

- **Low Coupling / High Cohesion:**  
  Classes are focused and loosely connected (e.g., strategies handle actions, factory handles creation).

---

### Encapsulation

Encapsulation is achieved by:

- Keeping fields `private`
- Exposing behavior through public methods
- Controlling access to internal state

**Examples:**
- `Player` manages inventory internally
- `Room` controls assets and exits
- `GameManager` controls global state

---

### SOLID Principles

#### S — Single Responsibility Principle
Each class has one responsibility:
- `Player` → player data
- `Room` → room structure
- `AssetFactory` → object creation
- `Game` → game loop
- `GameSetup` → game initialization

---

#### O — Open/Closed Principle
Classes are open for extension but closed for modification.

**Example:**  
New actions can be added by implementing `ActionStrategy` without modifying existing code.

---

#### L — Liskov Substitution Principle
Subtypes can replace their base types without breaking behavior.

**Example:**  
Any `ActionStrategy` implementation can be used interchangeably in the game loop.

---

#### I — Interface Segregation Principle
Interfaces are kept small and focused.

**Example:**  
`ActionStrategy` only defines one method: `execute(Player)`.

---

#### D — Dependency Inversion Principle
High-level modules depend on abstractions, not concrete implementations.

**Example:**
- `Game` and `ActionService` depend on `ActionStrategy`
- Strategies implement the abstraction

---

## Architecture Overview

- `Main` → entry point (minimal, delegates setup)
- `GameSetup` → initializes rooms, player, and game state
- `Game` → handles input and game loop
- `GameManager` → shared state (Singleton)
- `ActionService` → executes actions via abstraction (DIP)
- `AssetFactory` → creates assets
- Strategies → handle player behavior
- Observers → handle event notifications

---

## Summary

This project demonstrates:

- Clean separation of concerns
- Use of multiple design patterns together
- Strong adherence to SOLID and encapsulation principles
- Flexible and extensible architecture

---

## TLDR
