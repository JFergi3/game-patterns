# Game Patterns

A simple Java text-based adventure game built to demonstrate software design principles and patterns.

## What the Program Implements

- GRASP / Encapsulation / SOLID
- Strategy Pattern
- Singleton Pattern
- Factory Method Pattern
- Additional Pattern: Observer Pattern
- JUnit testing

## Current Architecture

- `Main`  
  Application entry point. Starts the game with:
    - `new RunGame().createGame().start();`

- `RunGame`  
  Handles setup:
    - creates rooms and exits
    - creates assets with `AssetFactory`
    - creates the player and starting room
    - registers observers in `GameManager`
    - returns a ready `Game` instance

- `Game`  
  Runs the input loop and command handling (`search`, `take`, `move`, `use`, `quit`).

- `GameManager`  
  Stores shared game state (`Player`, game running flag) and dispatches events to observers.

- `ActionService`  
  Executes actions through the `ActionStrategy` abstraction.

## Design Patterns Used

### Strategy Pattern
Player actions are implemented through the `ActionStrategy` interface with interchangeable strategies:

- `SearchStrategy`
- `MoveStrategy`
- `TakeAssetStrategy`
- `UseItemStrategy`

`Game` selects a strategy based on user input, then `ActionService` executes it.

### Singleton Pattern
`GameManager` is implemented as a singleton (`getInstance()`), ensuring one shared game state object.

### Factory Method Pattern
`AssetFactory` creates assets from a type string:

- `Key`
- `Coin`
- `Lantern`

This centralizes object creation and keeps setup code cleaner.

### Additional Pattern: Observer Pattern
`GameManager` notifies listeners when game events happen.

- `GameEventListener` (observer interface)
- `ConsoleNotifier` and `AchievementTracker` (observers)
- `GameManager` (subject)

This decouples event reactions from core gameplay logic.

## Core Principles Used

### GRASP
- **Controller:** `GameManager` coordinates shared state and notifications.
- **Low Coupling / High Cohesion:** responsibilities are split across focused classes (setup, loop, actions, factory, observers).

### Encapsulation
- Classes keep state private and expose behavior through methods.
- Examples:
    - `Player` manages inventory/current room
    - `Room` manages assets/exits
    - `GameManager` manages global game state

### SOLID

- **S (Single Responsibility):**  
  `Player`, `Room`, `AssetFactory`, `Game`, `RunGame`, and each strategy class each have a clear role.

- **O (Open/Closed):**  
  New actions can be added by implementing `ActionStrategy` without major changes to the game loop.

- **L (Liskov Substitution):**  
  Any `ActionStrategy` implementation can be used wherever `ActionStrategy` is expected.

- **I (Interface Segregation):**  
  `ActionStrategy` and `GameEventListener` are small, focused interfaces.

- **D (Dependency Inversion):**  
  `ActionService` depends on the `ActionStrategy` abstraction, not concrete action classes.

## Testing (JUnit)

Tests are in `src/test/game`:

- `AssetFactoryTest`
- `PlayerTest`
- `RoomTest`
- `GameManagerTest`
- `UseItemStrategyTest`

These cover factory behavior, inventory, room exits, singleton behavior, and win condition logic.
