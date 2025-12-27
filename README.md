# 🛒 Ecommerce Product Service

A production-grade **Ecommerce Product Service** built using **Java, Spring Boot, and RESTful APIs**.  
This service is responsible for managing **products and categories** in an e-commerce platform and is designed with **scalability, clean architecture, and real-world backend practices** in mind.

---

## 🚩 Problem Statement

In a typical e-commerce system, product-related operations such as:
- Creating products
- Categorizing products
- Fetching product listings
- Managing product metadata

must be **fast, scalable, and reliable**.

Monolithic designs often lead to:
- Tight coupling
- Poor scalability
- Difficult maintenance

### ✅ Solution

This project solves the problem by implementing a **dedicated Product Microservice** that:
- Manages products and categories independently
- Exposes clean REST APIs
- Uses normalized relational database design
- Is ready to scale horizontally

---

## 🧩 High-Level Architecture


Client / Frontend
|
v
Product Service (Spring Boot)
|
v
Relational Database (MySQL / H2)


---

## ✨ Features

- 📦 Product management (create, fetch)
- 🗂️ Category management
- 🔗 One-to-Many relationship between Category and Product
- 🧠 Clean layered architecture
- 🗄️ Relational database with foreign key constraints
- 🕒 Audit fields for tracking creation and updates
- 🧪 Easy to extend with caching (Redis), search, and pagination

---

## 🛠️ Tech Stack

| Layer | Technology |
|-----|------------|
| Language | Java |
| Framework | Spring Boot |
| API Style | REST |
| ORM | Spring Data JPA / Hibernate |
| Database | MySQL / H2 (In-Memory) |
| Build Tool | Maven |
| Version Control | Git |
| IDE | IntelliJ IDEA |

---

## 🗄️ Database Design

### 📂 Category Table
Stores product categories.

| Column | Description |
|-----|-------------|
| `id` | Primary key |
| `title` | Category name |
| `created_at` | Creation timestamp |
| `last_modified_at` | Last update timestamp |
| `deleted` | Soft delete flag |

---

### 📦 Product Table
Stores product details and maps each product to a category.

- Each product belongs to **one category**
- Enforced using a **foreign key constraint**

product.category_id → category.id



### 🔗 Relationship

Category (1) → Product (Many)


### ✅ Design Benefits
- Normalized schema
- Referential integrity
- Soft deletes for safety
- Optimized for read-heavy workloads

---

## 📡 API Endpoints (Sample)

### ➕ Create Product

POST /products


### 📥 Get All Products


GET /products


### 📂 Get Products by Category
GET /categories/{id}/products


---

## 🧱 Project Structure

src/main/java
└── com.example.productservice
├── controller
├── service
├── repository
├── model
└── dto


### Layer Responsibilities
- **Controller** → API layer
- **Service** → Business logic
- **Repository** → Database access
- **Model** → JPA entities
- **DTOs** → Request/Response mapping

---

## 🚀 How to Run Locally

### Prerequisites
- Java 17+
- Maven

### Steps
```bash
git clone https://github.com/pujerisantosh/Ecommerce_product_service.git
cd Ecommerce_product_service
git checkout feature/product-api
mvn spring-boot:run

Application will start at:
http://localhost:8080

🔮 Future Enhancements

🔄 Redis caching for product reads

🔍 Search & filtering

📄 Pagination & sorting

🧪 Unit and integration tests

🔐 Authentication & authorization

🌐 API Gateway integration

🧵 Event-driven updates (Kafka)

🎯 Why This Project Matters

This project demonstrates:

Real-world backend service design

Clean code and layered architecture

Database normalization and relationships

Readiness for microservices ecosystems

It reflects how product-based companies design backend services.

👨‍💻 Author

Santosh Pujeri
Backend / Software Engineer
📧 Email: pujerisantosh.backend@gmail.com

🔗 GitHub: https://github.com/pujerisantosh



