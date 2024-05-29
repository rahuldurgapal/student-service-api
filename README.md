# Student Service API

The Student Service API is a Spring Boot-based RESTful API designed to determine student eligibility for scholarships based on their marks. It reads and processes student details from CSV files and allows updating of the eligibility criteria for scholarships.

## Features

- Upload and process CSV files with up to 50,000 records using parallel processing.
- Dynamically update scholarship eligibility criteria.
- Output CSV files with updated eligibility status ("YES"/"NO").
- Fast student eligibility lookup by roll number using in-memory database/cache.
- Comprehensive Swagger documentation for easy interaction and testing.

## Technology Used

- **Spring Boot**: A framework for building standalone, production-grade Spring applications with minimal configuration.
- **Spring Boot Web**: A module for creating web applications using Spring MVC, embedded Tomcat, and other features.
- **Spring Boot JPA**: A module for integrating Spring Data JPA, providing repository support and simplifying database interactions.
- **OpenCSV**: A library for parsing and writing CSV files in Java, making it easy to handle CSV data.
- **MySQL Database**: A widely used open-source relational database management system known for its reliability and performance.

## Insatlation

### Prerequisites

- Java Compiler(11,17,22)

## Insatlation


## Installation and Setup

1. **Clone the Repository:** `git clone <repository-url>`
2. **Navigate to Project Directory:** `cd <project-directory>`
3. **Set Up MySQL Database:**
   - Create a database: `CREATE DATABASE studentservice;`
   - Update `application.properties` with your MySQL credentials.
4. **Build the Project:** `mvn clean install`
5. **Run the Application:** `mvn spring-boot:run`pring-boot:run
    ```   

## Usage 
 Use an API testing tool like Postman to interact with the API endpoints.

# Student Service API

This API decides student eligibility for scholarships based on their marks. Below are the available endpoints.

## Endpoints

### Upload CSV File
- **URL:** `/api/students/upload`
- **Method:** `POST`
- **Description:** Upload a CSV file and kick off the processing.
- **Request:**
  - Content-Type: `multipart/form-data`
  - Parameter: `file` (CSV file to upload)

### Update Eligibility Criteria
- **URL:** `/api/criteria`
- **Method:** `PUT`
- **Description:** Update the dynamic scholarship eligibility criteria.
- **Request:**
  - Content-Type: `application/json`
  - Body: 
    ```json
    {
      "science": 85,
      "maths": 90,
      "english": 75,
      "computer": 95
    }
    ```

### Get Student Eligibility by Roll Number
- **URL:** `/api/students/{rollNumber}`
- **Method:** `GET`
- **Description:** Retrieve the eligibility status of a student by roll number.
- **Response:**
  - `200 OK`: 
    ```json
    {
      "rollNumber": "100101",
      "name": "Vivek Sharma",
      "science": 86,
      "maths": 89,
      "english": 78,
      "computer": 92,
      "eligible": "YES"
    }
    ```
  - `404 Not Found`: 
    ```json
    {
      "message": "Student not found"
    }
    ```

### Get All Students
- **URL:** `/api/students`
- **Method:** `GET`
- **Description:** Retrieve all student records.
- **Response:**
  - `200 OK`: 
    ```json
    [
      {
        "rollNumber": "100101",
        "name": "Vivek Sharma",
        "science": 86,
        "maths": 89,
        "english": 78,
        "computer": 92,
        "eligible": "YES"
      },
      ...
    ]
    ```

## File Structure

```bash
studentservice
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── test
│   │   │           └── studentservice
│   │   │               ├── config
│   │   │               │   └── SwaggerConfig.java
│   │   │               ├── controller
│   │   │               │   └── StudentController.java
│   │   │               ├── model
│   │   │               │   └── Student.java
│   │   │               ├── repository
│   │   │               │   └── StudentRepository.java
│   │   │               ├── service
│   │   │               │   ├── StudentService.java
│   │   │               │   └── InspectCsvSerice.java
│   │   │               └── StudentServiceApplication.java
│   │   ├── resources
│   │   │   ├── application.properties
│   └── test
│       ├── java
│       │   └── com
│       │       └── test
│       │           └── studentservice
│       │               └── StudentServiceApplicationTests.java
├── .gitignore
├── README.md
├── pom.xml
└── mvnw
└── mvnw.cmd

```


    




