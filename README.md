# Full-Stack CRUD Application – User Registration System

## 1. Project Description

This project is a User Registration System. It allows users to register, view, update and delete user information.

The application uses Spring Boot for the backend, HTML, CSS and JavaScript for the frontend, and PostgreSQL to store user information.

## 2. Technologies Used

- Java 17
- Spring Boot
- Maven
- PostgreSQL
- HTML
- CSS
- JavaScript
- Postman
- IntelliJ IDEA

## 3. Installation Instructions

1. Install Java 17 or later.
2. Install IntelliJ IDEA.
3. Install PostgreSQL.
4. Clone the project from GitHub.
5. Open the project in IntelliJ IDEA.
6. Create a database called `vanilla_form_db`.
7. Set up your database username and password in `application.properties`.

## 4. How to Run the Application

1. Open the project in IntelliJ IDEA.
2. Make sure PostgreSQL is running.
3. Check the database connection.
4. Run the main Spring Boot application.
5. Open your browser and visit:

`http://localhost:8080`

## 5. API Endpoint Documentation

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/users` | Register a new user |
| GET | `/api/users` | Retrieve all users |
| GET | `/api/users/{id}` | Retrieve one user |
| PUT | `/api/users/{id}` | Update a user |
| DELETE | `/api/users/{id}` | Delete a user |

## 6. Database

The application uses PostgreSQL to store user information.

The users table contains an ID, name and email.

## 7. Testing

Postman can be used to test the POST, GET, PUT and DELETE operations.