# 🔐 Spring Boot JWT Authentication Service

A secure **JWT-based Authentication & Authorization REST API** built using **Spring Boot**, **Spring Security**, **MySQL**, and **JWT**. The project provides user registration, login, access token generation, and refresh token functionality using stateless authentication.

---

## 🚀 Features

- User Registration (Signup)
- User Login (Authentication)
- JWT Access Token Generation
- Refresh Token Support
- Spring Security Integration
- Password Encryption using BCrypt
- Stateless Authentication
- MySQL Database Integration
- Role-Based Authentication Ready
- RESTful API Architecture

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- JWT (JJWT)
- Lombok
- Maven

---

## 📁 Project Structure

```
src
├── config
│   ├── SecurityConfig
│   └── JwtAuthFilter
├── controller
│   ├── AuthController
│   └── TokenController
├── entities
│   ├── UserInfo
│   ├── RefreshToken
│   └── UserRole
├── repository
├── service
│   ├── JwtService
│   ├── RefreshTokenService
│   └── UserServiceDetailsImpl
├── request
├── response
└── model
```

---

## ⚙️ API Endpoints

### Register User

**POST**

```
/auth/v1/signup
```

Request

```json
{
  "username": "john",
  "password": "password123",
  "email": "john@example.com"
}
```

Response

```json
{
  "accessToken": "<jwt-token>",
  "token": "<refresh-token>"
}
```

---

### Login

**POST**

```
/auth/v1/login
```

Request

```json
{
  "username": "john",
  "password": "password123"
}
```

Response

```json
{
  "accessToken": "<jwt-token>",
  "token": "<refresh-token>"
}
```

---

### Refresh Access Token

**POST**

```
/auth/v1/refreshToken
```

Request

```json
{
  "token": "<refresh-token>"
}
```

Response

```json
{
  "accessToken": "<new-access-token>",
  "token": "<refresh-token>"
}
```

---

## 🔒 Authentication Flow

1. User registers.
2. Password is encrypted using BCrypt.
3. User logs in with valid credentials.
4. Server generates:
   - JWT Access Token
   - Refresh Token
5. Access Token is used to access secured APIs.
6. When the Access Token expires, a new one can be generated using the Refresh Token.

---

## 🗄️ Database

Configure your MySQL credentials inside:

```
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/authdb
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Running the Project

Clone the repository

```bash
git clone https://github.com/SPIDEY777/auth-service.git
```

Move into the project

```bash
cd auth-service
```

Run using Maven

```bash
mvn spring-boot:run
```

Or build

```bash
mvn clean install
```

---

## 📦 Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Security
- Spring Boot Starter Data JPA
- Spring Boot Validation
- MySQL Connector
- JJWT
- Lombok

---

## 🔐 Security Highlights

- BCrypt Password Encoding
- JWT Authentication Filter
- Stateless Session Management
- Refresh Token Mechanism
- AuthenticationManager Integration
- Custom UserDetailsService
- Secure REST APIs

---

## 📈 Future Improvements

- Email Verification
- Forgot Password
- OAuth2 Login (Google/GitHub)
- Docker Support
- Swagger/OpenAPI Documentation
- Redis-based Refresh Token Storage
- Role-Based Authorization (Admin/User)
- Unit & Integration Tests

---

## 👨‍💻 Author

**Kunal Sharma**

Backend Developer | Java | Spring Boot | Spring Security | MySQL

If you found this project useful, consider giving it a ⭐ on GitHub!
