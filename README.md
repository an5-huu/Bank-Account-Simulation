## Bank-Account-Simulation
A Java-based banking system implementation using Object-Oriented Programming principles.

## Overview
This system provides basic banking operations with a focus on clean architecture and proper error handling. It implements core banking features including account management, transactions, and transaction history tracking.

## Features
- Account creation with initial balance
- Deposit and withdrawal operations
- Complete transaction history
- Input validation and error handling
- Timestamp tracking for all transactions
- User-friendly command-line interface

## Project Structure
```
bank-account-simulation/
├── src/
│   ├── main/
│   │   └── banking/
│   │       ├── model/
│   │       │   ├── Account.java
│   │       │   └── Transaction.java
│   │       ├── service/
│   │       │   └── Bank.java
│   │       └── BankAccountSystem.java
└── README.md
```

## Requirements
- Java 16 or later

## Installation
-> Clone the repository:
```bash
git clone https://github.com/an5-huu/Bank-Account-Simulation.git
```

## Usage
1. Run the application:
```
java BankAccountSystem
```
2. Follow the interactive menu:
```
Bank Account System
1. Create Account
2. Perform Transaction
3. View Transaction History
4. Exit
```

## Key Components
### 1. Account Class
- Manages individual account state
- Handles deposits and withdrawals
- Maintains transaction history
- Implements proper validation

### 2. Transaction Record
- Immutable data carrier for transactions
- Stores type, amount, balances, and timestamp
- Ensures data integrity

### 3. Bank Service
- Manages multiple accounts
- Coordinates transactions
- Provides account lookup functionality

### 4. BankAccountSystem
- Handles user interaction
- Manages input/output operations
- Coordinates system components

## Error Handling
The system includes comprehensive error handling for:
- Invalid numeric inputs
- Insufficient funds
- Non-existent accounts
- I/O operations
- Invalid menu choices

## Transaction History
Each transaction is recorded with:
- Timestamp
- Transaction type
- Amount
- Before balance
- After balance


## Acknowledgments
This implementation uses Java Records (introduced in Java 16) for clean data representation and follows OOP best practices for maintainable code structure.

