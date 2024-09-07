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
- GET   http://localhost:8086/api/v1/rewards/balance- View cashback history
- GET   http://localhost:8086/api/v1/rewards/history- View customer rewards balance

