# Traffic Signal System (LLD)

## Problem Statement
Design and implement a Traffic Signal System to manage the traffic lights at an intersection. The system should support configurable signal durations for each direction and state, automatic cycling of signals using the State design pattern, and the ability to manually override signals as needed.
---
## Flow
Red --> Green --> Yellow --> Red --> ....

- system starts
- Loads durations
- SignalController initialized with RedState
- Timer starts
- RedState duration ends -> switches to GreenState
- GreenState ends -> YellowState
- Yellow ends -> back to red
- Cycle continues
- Manual override (if any)
- Manual mode -> pauses the cycle
- Admin resumes the auto mode
- Cycle continues
- System can be shut down/restarted

---

## Requirements
- **Multiple Directions:** The intersection supports multiple directions (e.g., NORTH, SOUTH, EAST, WEST).
- **Traffic Light States:** Each direction has a traffic light with states: GREEN, YELLOW, RED.
- **Configurable Durations:** Each direction and state can have its own configurable duration.
- **Automatic Cycling:** The system automatically cycles through the states for each direction in a round-robin fashion.
- **Manual Override:** The system allows manual override to set a specific direction to GREEN at any time.
- **Extensibility:** Easy to add new directions or states if needed.
- **State Pattern:** Use the State design pattern to encapsulate state-specific behavior and transitions.
---
## Actors
Signal System
Admin
Vehicles 
---
## Use Case Diagram
**Signal System**
- Auto Signal Cycle -> manage
- Timer 
- Updates the signal state/lights

**Traffic Admin**
- Manual override -> set custom signal for a particular drxn
- switch back to auto mode
- configure the signal timers
- start / shut down / restart -> system
---
**Vehicles**
- Observe the signal and respond accordingly

---
## Entites
- Direction - enum -> N S E W
- Signal State(I) -> R Y G -> concrete implementations (State Pattern)
- Traffic Light
- Intersection
- TrafficSignalController
---
## Design Pattern
1. State Pattern - auto cycling through different states
2. Strategy Pattern - define multiple signal system strategies - auto, manual
---
