# 🚀 User Registration and Login System

A **full-stack** application using **Spring Boot** for the backend and **React.js** for the frontend. This project enables users to **register and log in securely**, with data stored in a MySQL database.

## 🌜 Features

👉 User registration with validation  
👉 Login authentication with username and password  
👉 Frontend built with **React.js** and **Bootstrap**  
👉 Backend built with **Spring Boot** and **MySQL**  
👉 RESTful API with secure communication

## 🛠️ Technologies Used

### 📌 Backend:

- **Java 23**
- **Spring Boot 3.4.3**
- **Spring Data JPA**
- **Spring Validation**
- **Lombok**
- **MySQL**
- **Maven**

### 🎨 Frontend:

- **React.js**
- **React Router**
- **Axios**
- **Bootstrap**
- **Vite (for fast development)**

## 📚 Project Structure

```
📁 user-registration-login
 ├── 📁 backend (Spring Boot API)
 │   ├── 📂 Controllers
 │   │   └── UserController.java
 │   ├── 📂 Model
 │   │   ├── User.java
 │   │   ├── LoginRequest.java
 │   │   └── MessageResponse.java
 │   ├── 📂 Repositories
 │   │   └── UserRepository.java
 │   ├── UserRegistrationAndLoginApplication.java
 │   ├── 📄 pom.xml
 │   └── 📄 application.properties
 ├── 📁 frontend (React.js)
 │   ├── 📂 src
 │   │   ├── 📂 components
 │   │   │   ├── Login.js
 │   │   │   ├── Register.js
 │   │   │   ├── Dashboard.js
 │   │   │   ├── Navbar.js
 │   │   │   └── Home.js
 │   │   ├── 📂 services
 │   │   │   └── authService.js
 │   │   └── App.js
 │   ├── 📄 package.json
 │   ├── 📄 vite.config.js
 │   └── 📄 README.md
```

## 🛠️ Backend Installation

1️⃣ Clone the repository

```bash
git clone https://github.com/yourusername/UserRegistrationAndLogin.git
cd UserRegistrationAndLogin/backend
```

2️⃣ Configure MySQL Database in `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

3️⃣ Build and run the backend

```bash
mvn clean install
mvn spring-boot:run
```

## 🎨 Frontend Installation

1️⃣ Navigate to the frontend folder

```bash
cd ../frontend
```

2️⃣ Install dependencies

```bash
npm install
```

3️⃣ Start the React development server

```bash
npm run dev
```

## 📰 API Endpoints

| Method | Endpoint              | Description             |
| ------ | --------------------- | ----------------------- |
| POST   | `/api/users/register` | Register a new user     |
| POST   | `/api/users/login`    | Login a registered user |

## 📝 Example JSON Requests

### ➔ **User Registration**

```json
{
  "username": "john_doe",
  "password": "securePassword123",
  "email": "john.doe@example.com",
  "firstName": "John",
  "lastName": "Doe"
}
```

### ➔ **User Login**

```json
{
  "username": "john_doe",
  "password": "securePassword123"
}
```

## 🎯 Future Enhancements

👉 Password encryption with **BCrypt**  
👉 JWT-based authentication  
👉 Email verification  
👉 UI improvements with Material UI

---

### 🎉 **Contributing**

Contributions are welcome! Fork the repo, create a feature branch, and submit a pull request.

📧 Contact: [gopi.maganti1998@gmail.com](mailto:gopi.maganti1998@gmail.com)  
📌 GitHub: [github.com/krish-log](https://github.com/krish-log)
