# Installation Guide

## Requirements

- Java 17
- Maven 3.8+
- Git
- SceneBuilder (optional, for UI editing)

---

## Clone the repository

```bash
git clone https://github.com/jmesmarrero/Centroplus-connection.git

```

---

## Backend API

### Setup
```bash
cd backend-api
```

### Run
```bash
mvn clean spring-boot:run
```

The API will start at: http://localhost:8080

### API Documentation (Swagger)

The API will start at: http://localhost:8080/swagger-ui/index.html

---

## Mobile App

### Setup
```bash
cd mobile-app
```

### Run
```bash
mvn clean javafx:run
```

---

## Database

The SQLite database is located at:
- backend-api/src/main/resources/centroplus.db
- mobile-app/src/main/resources/centroplus.db

To reset the database run the SQL scripts:
- database/schema.sql
- database/seed.sql

## Project Structure

```text
Centroplus-connection/
├── backend-api/     ← Spring Boot REST API
├── mobile-app/      ← JavaFX Desktop Application
├── database/        ← SQL scripts and diagrams
├── docs/            ← Documentation
└── README.md
```