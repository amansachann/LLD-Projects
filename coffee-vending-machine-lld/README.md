# Coffee Vending Machine (LLD)

## Problem Statement
Design and implement a Coffee Vending Machine system that can serve different types of coffee, manage ingredient inventory, process payments, and handle user interactions such as selecting coffee and refilling ingredients.
---
## Flow
- Idle state
- User selects the coffee
- Check Inventory
- Display Price
- User Makes payment
- Verify payment
- Prepare coffee
- Dispense the coffee
- Back to Idle 

IDLE --> PREPARING --> DISPENSING --> IDLE
---
## Requirements:
- Multiple coffee types - Espresso, Cappuccino, Latte, etc (support multiple coffee recipes)
- Inventory management - track the ingredients, reduce them each time when prepare coffee, refill mechanism
- Payment process - debit card, credit card, upi, coins (return the change)
- Extensible 
---
## Actors:
- User/Customer
- Admin
- CoffeeMachine
- PaymentProcessor

---

## Use Case Diagram
**User/Customer**
- select the drink
- make payment
- collect the drink

**Vending Machine**
- Manages the state flow 
- prepare the coffee
- Dispense the coffee
- Handle the refund

**Admin/Operator**
- Refill Ingredients
- View the inventory

**Payment Processor**
- Verify the payment
- Make Refund - payment fails -> complete amount refund OR refund / return the change

---
# Core Entities
- CoffeeMachine
- MachineState (I) -> IdleState, PreparingState, DispensingState, etc
- CoffeeType - enum --> espresso, latte, etc
- Recipe
- RecipeManager
- InventoryManager
- PaymentProcessor 
- Admin