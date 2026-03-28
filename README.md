# 🛒 E-Commerce Backend

A full-featured RESTful E-Commerce Backend built with **Spring Boot**, secured with **JWT Authentication**, and integrated with **email confirmation** via Mailtrap SMTP.

---

## 🚀 Features

- 🔐 **JWT Authentication** — Secure login & registration with token-based auth
- 📧 **Email Confirmation** — Verify user accounts via OTP email (Mailtrap SMTP)
- 🛍️ **Product Management** — Full CRUD operations for products
- 🛒 **Cart & Orders** — Add to cart, place and fetch orders
- 💬 **Comments** — Users can add comments on products
- 🔒 **Spring Security** — Role-based access control with stateless sessions

---

## 🧰 Tech Stack

| Layer | Technology |
|-------|-----------|
| Framework | Spring Boot |
| Security | Spring Security + JWT |
| Database | MySQL |
| Email | JavaMail + Mailtrap SMTP |
| Build Tool | Maven |
| API Testing | Postman |

---

## 📁 Project Structure

```
E-Commerce-Backend/
├── src/main/java/com/E/Commerce/Backend/
│   ├── config/
│   │   ├── SecurityConfig.java
│   │   └── JwtAuthenticationFilter.java
│   ├── Controller/
│   │   ├── AuthController.java
│   │   ├── ProductController.java
│   │   ├── CartController.java
│   │   ├── OrderController.java
│   │   └── CommentController.java
│   ├── Model/
│   │   ├── User.java
│   │   ├── Product.java
│   │   ├── Cart.java
│   │   ├── Order.java
│   │   └── Comment.java
│   ├── Repositories/
│   ├── Service/
│   └── ECommerceBackendApplication.java
└── src/main/resources/
    └── application.properties
```

---

## ⚙️ Setup & Installation

### Prerequisites

- Java 17+
- Maven
- MySQL
- Mailtrap account (for email testing)

### 1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/E-Commerce-Backend.git
cd E-Commerce-Backend
```

### 2. Configure `application.properties`

```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
spring.jpa.hibernate.ddl-auto=update

# Mail (Mailtrap)
spring.mail.host=sandbox.smtp.mailtrap.io
spring.mail.port=587
spring.mail.username=YOUR_MAILTRAP_USERNAME
spring.mail.password=YOUR_MAILTRAP_PASSWORD
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# JWT
jwt.secret=YOUR_JWT_SECRET_KEY
jwt.expiration=86400000
```

### 3. Create the MySQL database

```sql
CREATE DATABASE ecommerce_db;
```

### 4. Run the application

```bash
mvn spring-boot:run
```

The server starts at: `http://localhost:8081`

---

## 📬 API Endpoints

### Auth
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/auth/register` | Register a new user | ❌ |
| POST | `/api/auth/login` | Login and get JWT token | ❌ |
| POST | `/api/auth/confirm-email` | Confirm email with OTP | ❌ |
| POST | `/api/auth/change-password` | Change user password | ✅ |

### Products
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | `/api/products` | Get all products | ❌ |
| GET | `/api/products/{id}` | Get product by ID | ❌ |
| POST | `/api/products` | Add a new product | ✅ |
| PUT | `/api/products/{id}` | Update a product | ✅ |
| DELETE | `/api/products/{id}` | Delete a product | ✅ |

### Cart
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/cart` | Add item to cart | ✅ |
| GET | `/api/cart` | Get cart items | ✅ |

### Orders
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/orders` | Place an order | ✅ |
| GET | `/api/orders` | Fetch all orders | ✅ |

### Comments
| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/comments` | Add a comment | ✅ |

---

## 🔑 Authentication Flow

```
1. Register     →  POST /api/auth/register  →  OTP sent to email
2. Confirm OTP  →  POST /api/auth/confirm-email
3. Login        →  POST /api/auth/login  →  Receive JWT token
4. Use token    →  Add to request header: Authorization: Bearer <token>
```

---

## 📧 Email Confirmation (Mailtrap)

This project uses **Mailtrap Sandbox** for email testing. Emails are not delivered to real inboxes — they are captured in your Mailtrap inbox for testing purposes.

To test:
1. Register a user
2. Check your Mailtrap inbox for the OTP
3. Confirm via `/api/auth/confirm-email`

---

## 🛡️ Security

- Passwords are encrypted using **BCrypt**
- All protected routes require a valid **JWT token** in the `Authorization` header
- Stateless session management (no server-side sessions)

---

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first.

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

> Built with ❤️ using Spring Boot
