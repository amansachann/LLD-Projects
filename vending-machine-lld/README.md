# Vending Machine (LLD)

## Problem Statement
Design and implement a Vending Machine system that allows users to select products, insert coins/notes, dispense products, and return change. The system should manage inventory, handle payments, and use the State design pattern for its operations.
---
### Flow:
1. Machine is in idle state
2. User selects the product(s) and qty
3. Machine checks if the product(s) (qty) is available
4. Machine displays the total amount
4. User puts the money
5. Machine checks the money is more than equal to the total amount
    - Yes -> process the transaction and move to next step
    - No -> Ask user for more money (remaining amount) if user doesn't pay refund the user amount and exit
6. Process the payment
   - Payment successful - Show payment success and proceed
   - Payment failed - provide reason and refund then exit
8. Dispense the product and ask user to collect the product
9. Provide the change
10. Go back to the idle state
---
### Machine States
IDLE --> READY --> DISPENSE --> RETURN CHANGE

---
### Requirements:
- Product Management - manage catalog of  products -> price, qty
- Inventory Management - manage and track all the products stock
- Payment Handling - handle transactions, coins & notes, return change
- State Management - State Design Pattern -- manages its operational states
- User Interaction - select product, insert coin/notes, receive change
- Extensible - Add new product, payment methods, or states
---
### Actors:
**Primary:**
1. Vending Machine - orchestrator 
2. User - select product, insert money, collect product, collect change

**Secondary:**
1. Inventory Manager - tracks the product quantity, validates availabilty
2. Product Manager - hold list of products, provide details
3. Payment Processor - verify the payment, calculate the change, process transaction/refund
4. State Manager - Handles the machine states
5. Change Dispenser - dispense the change -> update the available cash in machine 
---
### Core Entities:
- Vending Machine
- Product
- Inventory
- Coin/Note
- VendingMachineState(I) 
- Concrete implementations of VendingMachineState: Idle, Ready, Dispense, ReturnChange
---
### Design Patterns:
1. State Pattern - manage the vending machine states
2. Singleton Pattern - VendingMachine should be singleton
3. Strategy Pattern - Support different Payment Strategies - card, upi, cash (extensibility)
4. Factory Pattern - To Create Product objects

---
## Entity Details

### Coin (enum)
**Fields:**
- double value;
**Methods:**
- getValue()

### Product
**Fields:**
- string name
- double price
**Methods:**
- getters and setters

### Inventory
**Fields:**
- Map<Product, int> productQty
**Methods:**
- getter and setter
- addProduct(Product)
- removeProduct(Product)
- reduceQty(Product)
- isAvailable(Product)

### Vending Machine
**Fields:**
- Inventory inventory
- VendingMachineState currentState
- Product selectedProduct
- double totalPayment
**Methods:**
- addProduct(Product, qty)
- selectProduct(Product)
- insertCoin(coin)
- dispenseProduct()
- returnChange()
- setState(VendingMachineState)
- getInstance()  --- singleton