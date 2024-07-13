
# Spring Boot CRUD API with File System Storage

This project demonstrates a simple CRUD (Create, Read, Update, Delete) API implementation using Spring Boot with file system storage for managing student records.

## Features

- **GET `/api/students`**: Retrieves all students.
- **GET `/api/students/{id}`**: Retrieves a student by ID.
- **POST `/api/students`**: Creates a new student.
- **PUT `/api/students/{id}`**: Updates an existing student by ID.
- **DELETE `/api/students/{id}`**: Deletes a student by ID.

## Prerequisites

Ensure you have the following installed:

- Java Development Kit (JDK) 8 or higher
- Maven
- Postman (for API testing)

## Setup

1. **Clone the repository**

   ```bash
   git clone <repository_url>
   cd spring-boot-crud-api
   ```

2. **Run the application**

   ```bash
   mvn spring-boot:run
   ```

   The application will start on port 8081 by default.

3. **Testing the API**

   Use Postman or any REST client to test the API endpoints:

   - Import the provided Postman collection (`spring-boot-file-system-crud.json`) to test CRUD operations.
   - Set the base URL in your environment variables (`base_url=http://localhost:8081/api/students`).

## API Endpoints

- **GET `/api/students`**: Retrieves all students.
- **GET `/api/students/{id}`**: Retrieves a student by ID.
- **POST `/api/students`**: Creates a new student.
- **PUT `/api/students/{id}`**: Updates an existing student by ID.
- **DELETE `/api/students/{id}`**: Deletes a student by ID.

## Technology Stack

- Spring Boot
- Maven
- Jackson (JSON serialization/deserialization)

## File System Storage

Student records are stored as JSON objects in a file (`students.json`) within the project directory.
