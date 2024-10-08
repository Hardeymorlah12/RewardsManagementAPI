# RewardsManagementAPI

Overview

This project implements a cashback rewards system that allows customers to earn cashback on transactions. The system consists of the following components:

- Customer: Represents a customer who can earn cashback rewards.
- Transaction: Represents a financial transaction that earns cashback rewards.
- CashbackHistory: Stores the cashback rewards earned by each customer.
- CustomerRewards: Stores the total cashback rewards and current balance for each customer.

Features

- Earn cashback rewards on transactions
- View cashback history
- View customer rewards balance

Usage

1. Create a new transaction for a customer
2. The system calculates the cashback rewards earned
3. The cashback rewards are stored in the CashbackHistory and CustomerRewards tables

Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Spring Security

Setup

1. Clone the repository
2. Run the application using Spring Boot
3. Use the provided APIs to register, login, create transactions and view cashback history and rewards balance
   

API Endpoints
- POST  http://localhost:8086/api/v1/customers/register - register as a user/customer
- POST  http://localhost:8086/api/v1/customers/login - login after successful registration
- POST  http://localhost:8086/api/v1/transactions/post_transaction - Create a new transaction
- GET   http://localhost:8086/api/v1/rewards/balance/1   (PathVariable was used here)- View customer rewards balance
- GET   http://localhost:8086/api/v1/rewards/history?customerId=1  (RequestParam was used here)- View cashback history

  Response for Register endpoint: 
{
    "id": 1,
    "name": "Saheed Adewale",
    "username": "hardeymorlah12@gmail.com",
    "password": "$2a$10$4HJ.XUnxHpiRllg3i1z2pOHUn0xjnYkA/JTyi7hyZAbDYJ/dlDu/e",
    "phoneNumber": "08145032997"
}

 Response for login endpoint:
 {
    "user": {
        "id": 1,
        "name": "Saheed Adewale",
        "username": "hardeymorlah12@gmail.com",
        "password": "$2a$10$4HJ.XUnxHpiRllg3i1z2pOHUn0xjnYkA/JTyi7hyZAbDYJ/dlDu/e",
        "phoneNumber": "08145032997"
    },
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXJkZXltb3JsYWgxMkBnbWFpbC5jb20iLCJpYXQiOjE3MjU4MTM4MDEsImV4cCI6MTcyNTgxNzQwMSwiaXNzIjoiQWJiZXkgRnVsbFN0YWNrIENoYWxsZW5nZSBBcHAgMS4wIn0.M97qInoQnf-OBBncsDHCkzTYdJaAf-6nRdkbLutQzl0"
}

Response for Transaction Endpoint:

{
    "id": 1,
    "product": "Sneakers",
    "amount": 3000.0,
    "transactionDate": "2024-02-06T00:00:00.000+00:00",
    "description": "A good looking Sneakers",
    "customer": {
        "id": 1,
        "name": null,
        "username": null,
        "password": null,
        "phoneNumber": null
    }
}

Response for rewards balance:

{
    "id": 1,
    "customer": {
        "id": 1,
        "name": "Saheed Adewale",
        "username": "hardeymorlah12@gmail.com",
        "password": "$2a$10$4HJ.XUnxHpiRllg3i1z2pOHUn0xjnYkA/JTyi7hyZAbDYJ/dlDu/e",
        "phoneNumber": "08145032997"
    },
    "totalCashback": 150.0,
    "currentBalance": 150.0
}
Response for Cashback history: 

[
    {
        "id": 1,
        "transaction": {
            "id": 1,
            "product": "Sneakers",
            "amount": 3000.0,
            "transactionDate": "2024-02-06T00:00:00.000+00:00",
            "description": "A good looking Sneakers",
            "customer": {
                "id": 1,
                "name": "Saheed Adewale",
                "username": "hardeymorlah12@gmail.com",
                "password": "$2a$10$4HJ.XUnxHpiRllg3i1z2pOHUn0xjnYkA/JTyi7hyZAbDYJ/dlDu/e",
                "phoneNumber": "08145032997"
            },
            
        "transactionDate": "2024-02-06T00:00:00.000+00:00",
        "amountEarned": 150.0,
        "description": "A good looking Sneakers"
    }
]
