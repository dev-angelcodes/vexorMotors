<p align="right">
  <a href="README.md">🇬🇧 English</a> |
  <a href="README_ES.md">🇪🇸 Español</a>
</p>

---

<p align="center">
  <h1 align="center">🚗 VexorMotors Dealership API</h1>
  <p align="center">
    Backend empresarial para la gestión de concesionarios orientados a importación, exportación y venta de vehículos.
  </p>

  <p align="center">
    <img src="https://img.shields.io/badge/Java-21-red">
    <img src="https://img.shields.io/badge/Spring%20Boot-4-green">
    <img src="https://img.shields.io/badge/Build-Gradle-blue">
    <img src="https://img.shields.io/badge/Database-JPA%2FHibernate-orange">
  </p>

---

## Descripción

**VexorMotors Dealership API** es una API REST diseñada para servir como núcleo backend de un sistema de gestión de concesionarios, permitiendo administrar vehículos, clientes, inventario y operaciones comerciales de forma segura y escalable.

El proyecto está construido sobre **Spring Boot 4 y Java 21**, siguiendo principios de arquitectura limpia, separación de responsabilidades y buenas prácticas de desarrollo.

---

## Objetivos del proyecto

- Centralizar la gestión de vehículos y clientes
- Facilitar operaciones de compra y venta
- Proporcionar una base segura para futuras ampliaciones
- Servir como backend para aplicaciones web o móviles

---

## Funcionalidades principales

- Gestión de vehículos
- Gestión de clientes
- Control de inventario
- Operaciones de compra y venta
- Seguridad y control de acceso
- Migraciones automáticas de base de datos

---

## Arquitectura

Arquitectura por capas:

Controller → Service → Repository → Database


Separación clara entre:

- Controladores (API REST)
- Lógica de negocio
- Acceso a datos
- Modelos y DTOs

---

## Tecnologías

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

## Dependencias principales

- spring-boot-starter-webmvc
- spring-boot-starter-data-jpa
- spring-boot-starter-security
- spring-boot-starter-flyway
- spring-boot-starter-actuator
- lombok

---

## Estructura del proyecto

src
└── main
└── java
└── com.vexor
├── controller
├── service
├── repository
├── model
├── dto
└── config

---

##  Requisitos

- Java 21 o superior
- Gradle
- MySQL o PostgreSQL 

---

<p align="center"> <b>Ángel Fernández Blanco</b><br><br> <a href="https://github.com/dev-angelcodes"> <img src="https://img.shields.io/badge/GitHub-dev--angelcodes-black?logo=github"> </a> <a href="https://www.linkedin.com/in/angel-fernandez-blanco-514951296/"> <img src="https://img.shields.io/badge/LinkedIn-Angel%20Fernández%20Blanco-blue?logo=linkedin"> </a> </p>