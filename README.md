<p align="right">
  <a href="README.md">🇬🇧 English</a> |
  <a href="README_ES.md">🇪🇸 Español</a>
</p>

---

<p align="center">
  <h1 align="center">🚗 VexorMotors Dealership API</h1>
  <p align="center">
    Enterprise backend built as a <strong>Modular Monolith</strong> for vehicle dealership management.
  </p>

  <p align="center">
    <img src="https://img.shields.io/badge/Java-21-red">
    <img src="https://img.shields.io/badge/Spring%20Boot-3.x-green">
    <img src="https://img.shields.io/badge/Architecture-Modular%20Monolith-blue">
    <img src="https://img.shields.io/badge/Build-Gradle-orange">
    </p>

---

## Overview

**VexorMotors Dealership API** is an enterprise backend system designed to manage dealership operations such as vehicle inventory, sales, authentication, and search.

The project follows a **Modular Monolith architecture**, evolving from an initial microservices approach into a more pragmatic, maintainable, and scalable solution without unnecessary operational overhead.

---

## Architectural Approach

### Modular Monolith (Gradle Multi-Project)

- Single deployable application
- Clear module boundaries enforced by Gradle
- In-memory communication between domains
- No internal REST or message brokers
- Strong separation of concerns
- Easy local development and deployment

This approach combines the **clarity of microservices** with the **simplicity of a monolith**.

---

## Project Structure

```text
vexorMotors
├── apps/                    # Application entry points
│   ├── customer-API         # Public-facing API (BFF)
│   └── employee-API         # Internal / employee API
│
├── modules/                 # Business domains (pure logic)
│   ├── auth
│   ├── inventory
│   ├── sales
│   ├── chat
│   └── search
│
├── shared/                  # Shared contracts & infrastructure
│   ├── kernel
│   ├── persistence-base
│   └── common-infra
│
└── docker/                  # Local infrastructure (PostgreSQL, pgAdmin)
```
---

## Responsibilities

### apps/*
```text
    - REST Controllers
    - Security configuration
    - Request validation
    - API orchetation
    - Spring Boot bootStrap (@SpringBootApplication)
```
### modules/*
```text
    - Business logic
    - Domain entities
    - Repositories
    - Domain services
    - Business rules
```

### shared/*
```text
    - Shared contracts (DTOs, events)
    - Base persistence configuration
    - Common infrastructure utilities
    - Zero business logic
```
---

## Database Strategy
```text
    - Single PostgreSQL instance
    - Logical instance
    - No cross-modulejoins
    - Strong data ownership discipline
```
---

## Technologies

- Java 21
- Spring Boot 4
- Spring WebMVC
- Spring Data JPA
- Spring Security
- Flyway
- Spring Boot Actuator
- Lombok
- Gradle
- JUnit 5

---

## Local Development

### Requirements

 - Java 21+
 - Gradle
 - Docker & Docker Compose

### Start infrastructure
docker compose up -d

### Run application

```bash
./gradlew :apps:customer-API:bootRun
```

```bash
./gradlew :apps:employee-API:bootRun
```

---

<p align="center">
   <strong>Ángel Fernández Blanco</strong>
   <br>
   <br>
   <a href="https://github.com/dev-angelcodes">
     <img src="https://img.shields.io/badge/GitHub-dev--angelcodes-black?logo=github">
   </a>
   <a href="https://www.linkedin.com/in/angel-fernandez-blanco-514951296/">
     <img src="https://img.shields.io/badge/LinkedIn-Angel%20Fernández%20Blanco-blue?logo=linkedin">
   </a>
</p>
