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
- GET   http://localhost:8086/api/v1/rewards/balance/1   (PathVariable was used here)- View cashback history
- GET   http://localhost:8086/api/v1/rewards/history?customerId=1  (RequestParam was used here)- View customer rewards balance

  Response for Register endpoint:

  {
    "id": 1,
    "name": "Adewale Saheed Ademola",
    "username": "hardeymorlah12@gmail.com",
    "password": "$2a$10$d/IoBdA0eNXAGo0FKsJrCeBQOQpp.Vg4w9xn6piLThK4fOqqr3bYK",
    "phoneNumber": "08145032997",
    "role": "USER",
    "enabled": true,
    "accountNonExpired": true,
    "credentialsNonExpired": true,
    "authorities": [
        {
            "authority": "USER"
        }
    ],
    "accountNonLocked": true

}

Response for Login Endpoint:

{
    "user": {
        "id": 1,
        "name": "Adewale Saheed Ademola",
        "username": "hardeymorlah12@gmail.com",
        "password": "$2a$10$d/IoBdA0eNXAGo0FKsJrCeBQOQpp.Vg4w9xn6piLThK4fOqqr3bYK",
        "phoneNumber": "08145032997",
        "role": "USER",
        "enabled": true,
        "accountNonExpired": true,
        "credentialsNonExpired": true,
        "authorities": [
            {
                "authority": "USER"
            }
        ],
        "accountNonLocked": true
    },
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYXJkZXltb3JsYWgxMkBnbWFpbC5jb20iLCJpYXQiOjE3MjU3MjY1NTYsImV4cCI6MTcyNTczMDE1NiwiaXNzIjoiQWJiZXkgRnVsbFN0YWNrIENoYWxsZW5nZSBBcHAgMS4wIn0.PhzZnyFb980e0voypwbQlEmbyoj1HSnT1gdLCD_1Hvs"
}

Response for Post_Transaction Endpoint:

{
    "id": 2,
    "product": "Sneakers",
    "amount": 3000.0,
    "transactionDate": "2024-02-06T00:00:00.000+00:00",
    "description": "A good looking Sneakers",
    "customer": {
        "id": 1,
        "name": null,
        "username": null,
        "password": null,
        "phoneNumber": null,
        "role": "USER",
        "enabled": true,
        "accountNonExpired": true,
        "credentialsNonExpired": true,
        "authorities": [
            {
                "authority": "USER"
            }
        ],
        "accountNonLocked": true
    }
}

Response for rewards balance:

{
    "id": 1,
    "customer": {
        "id": 1,
        "name": "Adewale Saheed Ademola",
        "username": "hardeymorlah12@gmail.com",
        "password": "$2a$10$d/IoBdA0eNXAGo0FKsJrCeBQOQpp.Vg4w9xn6piLThK4fOqqr3bYK",
        "phoneNumber": "08145032997",
        "role": "USER",
        "enabled": true,
        "accountNonExpired": true,
        "credentialsNonExpired": true,
        "authorities": [
            {
                "authority": "USER"
            }
        ],
        "accountNonLocked": true
    },
    "totalCashback": 300.0,
    "currentBalance": 300.0
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
                "name": "Adewale Saheed Ademola",
                "username": "hardeymorlah12@gmail.com",
                "password": "$2a$10$d/IoBdA0eNXAGo0FKsJrCeBQOQpp.Vg4w9xn6piLThK4fOqqr3bYK",
                "phoneNumber": "08145032997",
                "role": "USER",
                "enabled": true,
                "accountNonExpired": true,
                "credentialsNonExpired": true,
                "authorities": [
                    {
                        "authority": "USER"
                    }
                ],
                "accountNonLocked": true
            }
        },
        "customer": {
            "id": 1,
            "name": "Adewale Saheed Ademola",
            "username": "hardeymorlah12@gmail.com",
            "password": "$2a$10$d/IoBdA0eNXAGo0FKsJrCeBQOQpp.Vg4w9xn6piLThK4fOqqr3bYK",
            "phoneNumber": "08145032997",
            "role": "USER",
            "enabled": true,
            "accountNonExpired": true,
            "credentialsNonExpired": true,
            "authorities": [
                {
                    "authority": "USER"
                }
            ],
            "accountNonLocked": true
        },
        "transactionDate": "2024-02-06T00:00:00.000+00:00",
        "amountEarned": 150.0,
        "description": "A good looking Sneakers"
    },
    {
        "id": 2,
        "transaction": {
            "id": 2,
            "product": "Sneakers",
            "amount": 3000.0,
            "transactionDate": "2024-02-06T00:00:00.000+00:00",
            "description": "A good looking Sneakers",
            "customer": {
                "id": 1,
                "name": "Adewale Saheed Ademola",
                "username": "hardeymorlah12@gmail.com",
                "password": "$2a$10$d/IoBdA0eNXAGo0FKsJrCeBQOQpp.Vg4w9xn6piLThK4fOqqr3bYK",
                "phoneNumber": "08145032997",
                "role": "USER",
                "enabled": true,
                "accountNonExpired": true,
                "credentialsNonExpired": true,
                "authorities": [
                    {
                        "authority": "USER"
                    }
                ],
                "accountNonLocked": true
            }
        },
        "customer": {
            "id": 1,
            "name": "Adewale Saheed Ademola",
            "username": "hardeymorlah12@gmail.com",
            "password": "$2a$10$d/IoBdA0eNXAGo0FKsJrCeBQOQpp.Vg4w9xn6piLThK4fOqqr3bYK",
            "phoneNumber": "08145032997",
            "role": "USER",
            "enabled": true,
            "accountNonExpired": true,
            "credentialsNonExpired": true,
            "authorities": [
                {
                    "authority": "USER"
                }
            ],
            "accountNonLocked": true
        },
        "transactionDate": "2024-02-06T00:00:00.000+00:00",
        "amountEarned": 150.0,
        "description": "A good looking Sneakers"
    }
]
  
  

