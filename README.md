# 🛒 Ecommerce Product Service

## 🧩 Problem Statement
Modern e-commerce platforms often struggle with **fragmented product management** — every service (orders, catalog, search) handles product data differently.  
This leads to:
- Inconsistent product information across systems  
- Code duplication in multiple services  
- Difficulty in scaling or maintaining product-related logic  

### 🎯 Our Solution
The **Ecommerce Product Service** is a dedicated **microservice** built with **Spring Boot**, designed to act as a **single source of truth** for all product data.  
It provides REST APIs to perform secure and consistent product CRUD operations and can be integrated seamlessly with other services like Inventory, Order, and Payment.

---

## 🌟 Key Features
- 🧠 **Centralized Product Management** — One service for all product data  
- ⚙️ **Clean REST APIs** — Create, Read, Update, Delete products easily  
- 🧩 **Layered Architecture** — Controller, Service, Repository separation  
- 🔗 **Spring Data JPA + Hibernate** — Auto table creation and persistence  
- 🧱 **Scalable & Modular** — Ready to plug into microservice ecosystem  

---

## 🛠️ Technology Stack

| Category | Technology | Purpose |
|-----------|-------------|----------|
| Language | **Java 23** | Core backend development |
| Framework | **Spring Boot 3.5** | REST API and dependency management |
| ORM | **Spring Data JPA / Hibernate** | Database interaction and mapping |
| Database | **MySQL** | Product data storage |
| Build Tool | **Maven** | Build and dependency management |
| API Testing | **Postman** | API testing and verification |

---

## 📐 Architecture & Design
The service follows a **3-layered architecture** for better modularity:

1. **Controller Layer** – Exposes REST endpoints for clients  
2. **Service Layer** – Implements business logic and validations  
3. **Repository Layer** – Handles database operations via JPA  

This ensures the service follows the **Single Responsibility** and **Open/Closed Principles**, making it easily extensible.

---

## 🚀 Getting Started

### 🔧 Prerequisites
- Java 23 (or above)
- Maven
- MySQL (running locally or remotely)

### 🧩 Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/pujerisantosh/Ecommerce_product_service.git
   cd Ecommerce_product_service
Update configuration
Edit src/main/resources/application.properties:

properties
Copy code
spring.application.name=ecommerce-product-service

spring.datasource.url=jdbc:mysql://localhost:3306/ecommerceproductservice
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Run the application

bash
Copy code
mvn spring-boot:run
The application will start at:
👉 http://localhost:8080

📈 API Endpoints (Examples)
Method	Endpoint	Description
GET	/api/products	Get all products
GET	/api/products/{id}	Get product by ID
POST	/api/products	Create new product
PUT	/api/products/{id}	Update existing product
DELETE	/api/products/{id}	Delete a product

📫 Sample Request Body:

json
Copy code
{
  "name": "Apple iPhone 15",
  "description": "128GB, Black",
  "price": 79999,
  "category": "Smartphones"
}
🔮 Future Enhancements
✅ Pagination, filtering, and sorting

🧾 Redis caching for faster product retrieval

🪝 Webhook/event-driven updates using Kafka

📦 Integration with Inventory, Order, and Payment services

🧠 Role-based security using Spring Security and JWT

👨‍💻 Author
Santosh Pujeri
Backend Developer | Spring Boot & Microservices
📧 pujersantosh.backend@gmail.com
🔗 LinkedIn
