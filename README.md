# CentroPlus Connection

**Academic and Sports Center Management Platform**



## About

CentroPlus Connection is a full-stack application designed to manage an academic and sports center. It allows users to browse activities, make reservations, and report incidents — all through a clean mobile interface connected to a robust REST API backend.

Developed by **Jorge Mesa Marrero** as part of the 1st-year DAM intermodular project.



## Technologies

| Layer | Technology |
|---|---|
| Backend API | Java 17 + Spring Boot |
| Mobile App | JavaFX |
| Database | SQLite |
| Testing | JUnit 5 + Mockito |
| Version Control | Git + GitHub |




## Architecture

```text
backend-api (Spring Boot REST)
↓
database (SQLite)

mobile-app (JavaFX)
↓
database (SQLite)
```



## Features

- User registration and management
- Activity listing and detail view
- Seat reservation and cancellation
- Incident reporting
- REST API with full CRUD operations



## Project Structure

```text
Centroplus-connection/
├── backend-api/
├── mobile-app/
├── database/
├── docs/
└── README.md
```





## Getting Started

```bash
git clone https://github.com/jmesmarrero/Centroplus-connection.git
cd Centroplus-connection
```

### Run backend
```bash
cd backend-api
mvn clean spring-boot:run
```

### Run mobile app
```bash
cd mobile-app
mvn clean javafx:run
```



## Author

**Jorge Mesa Marrero**  
1st Year DAM — IES Puerto


