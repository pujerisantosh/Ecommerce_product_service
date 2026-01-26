🛒 Ecommerce Product Service

A production-ready Ecommerce Product Microservice built using Java, Spring Boot, Spring Security, JPA, Redis, and REST APIs, following clean architecture and real-world backend design principles.

This service is designed the way product-based companies build backend systems — modular, scalable, testable, and secure.

🎯 What Problem Does This Solve?

In real-world e-commerce platforms, product data must be:

Fast to read

Consistent and reliable

Secure

Easily scalable

Independently deployable

Traditional monolithic systems often fail due to:

Tight coupling

Hard-to-scale product logic

Difficult maintenance

No clear ownership boundaries

✅ Solution Approach

This project implements a dedicated Product Microservice that:

Owns product & category data

Exposes clean REST APIs

Uses proper relational modeling

Supports authentication-ready architecture

Is testable and extensible

🧩 High-Level Architecture
Client / API Consumer
|
v
Product Service (Spring Boot)
- Controllers
- Services
- Security
- Repositories
  |
  v
  Relational DB (MySQL / H2)
  |
  v
  Redis (for caching – configured & ready)

✨ Key Features (Implemented ✅)
📦 Product Management

Create products

Fetch all products

Fetch products by category

Proper DTO-based request/response mapping

🗂️ Category Management

One-to-Many relationship (Category → Products)

Foreign key constraints

Referential integrity enforced at DB level

🔐 Authentication & Authorization (Completed ✅)

User registration

User login

Password encryption using BCrypt

Spring Security configuration

Stateless authentication-ready setup

JWT-based login flow implemented

🔑 Note: Security is implemented the same way modern backend services do — decoupled, stateless, and extensible.

🧠 Clean Architecture

Controller → Service → Repository layering

DTOs to avoid entity exposure

Global exception handling

Validation-ready design

🧪 Testing (Completed ✅)

Unit tests for service layer

Integration tests for repositories

Controller-level integration tests

Test configuration using application-test.yml

🗄️ Database Design

Normalized schema

Soft delete support

Audit fields (created_at, updated_at)

Foreign key constraints

⚡ Redis (Configured & Ready)

Redis template configuration added

Cache-ready architecture for future read optimization

🛠️ Tech Stack
Layer	Technology
Language	Java
Framework	Spring Boot
Security	Spring Security, BCrypt, JWT
ORM	Spring Data JPA / Hibernate
Database	MySQL / H2
Cache	Redis (configured)
Testing	JUnit, Spring Boot Test
Build Tool	Maven
Version Control	Git
IDE	IntelliJ IDEA
🧱 Project Structure
src/main/java/dev/santosh/productservice
├── auth              # Authentication APIs
├── controllers       # REST controllers
├── services          # Business logic
├── repository        # JPA repositories
├── models            # JPA entities
├── dtos              # Request/Response DTOs
├── security          # Security configuration
├── advices           # Global exception handling
├── configs           # Redis & RestTemplate configs
└── ProductServiceApplication.java

📡 Sample APIs
➕ Register User
POST /auth/register

🔐 Login User
POST /auth/login

➕ Create Product
POST /products

📥 Get All Products
GET /products

📂 Get Products by Category
GET /categories/{id}/products

🚀 How to Run Locally
Prerequisites

Java 17+

Maven

MySQL (optional – H2 supported)

Steps
git clone https://github.com/pujerisantosh/Ecommerce_product_service.git
cd Ecommerce_product_service
mvn spring-boot:run


Application runs at:

http://localhost:8080

🧪 Testing
mvn test


Includes:

Unit tests

Integration tests

Repository tests

🔮 Planned Enhancements (Intentionally Pending 🚧)

These are deliberately left out to show roadmap thinking:

🔄 Redis caching for read-heavy APIs

🔍 Advanced search & filtering

📄 Pagination & sorting

🌐 API Gateway integration

🧵 Event-driven communication (Kafka)

📊 Metrics & monitoring

🔐 Role-based authorization (ADMIN / USER)

These features are easy to plug in due to current architecture.

🎯 Why This Project Stands Out

This project demonstrates:

Real-world backend service design

Production-style security configuration

Proper database modeling

Clean architecture principles

Test-driven mindset

Microservice readiness

It reflects how backend systems are designed in product-based companies.

👨‍💻 Author

Santosh Pujeri
Backend / Software Engineer

📧 Email: pujerisantosh.backend@gmail.com
🔗 GitHub: https://github.com/pujerisantosh