# Game Patterns

Simple Java text adventure project used to practice design patterns.

## Design Patterns Used

**Strategy Pattern**  
Used for player actions such as searching, moving, taking assets, and using items.

**Singleton Pattern**  
`GameManager` controls shared game state and only allows one instance.

**Factory Method Pattern**  
`AssetFactory` creates assets such as `Key`, `Coin`, and `Lantern`.

**Observer Pattern**  
`GameManager` notifies listeners when events happen, such as collecting an item or winning the game.

**JUnit**  
Tests verify the factory, player inventory, room exits, singleton behavior, and win condition.

## Required Concepts and How They Are Used

### GRASP / Encapsulation / SOLID
- **Encapsulation:** `Player`, `Room`, and `GameManager` keep internal state private and expose behavior through methods.
- **GRASP (Controller):** `GameManager` acts as the central controller for shared game state and event flow.
- **SOLID (Single Responsibility):** each class has one main job (`Player`, `Room`, `AssetFactory`, and each strategy class).
- **SOLID (Open/Closed):** new player actions can be added by creating a new `ActionStrategy` implementation without changing the core loop much.

### The Strategy Pattern
The game uses `ActionStrategy` for player actions.  
Current strategies include:
- `SearchStrategy`
- `MoveStrategy`
- `TakeAssetStrategy`
- `UseItemStrategy`

`Game` chooses the correct strategy based on the user command.

### The Singleton Pattern
`GameManager` uses `getInstance()` so the game has one shared manager instance.

### The Factory Method
`AssetFactory` centralizes creation of assets such as `Key`, `Coin`, and `Lantern`.

### An Additional Pattern (10 points Extra)
The project uses the **Observer Pattern**:
- `GameEventListener` defines the observer interface.
- `ConsoleNotifier` and `AchievementTracker` are observers.
- `GameManager` notifies observers when events occur (item pickup, win event).

### JUnit
JUnit tests in `src/test/game` validate:
- factory behavior (`AssetFactoryTest`)
- inventory behavior (`PlayerTest`)
- room exits (`RoomTest`)
- singleton behavior (`GameManagerTest`)
- win condition (`UseItemStrategyTest`)
