<p align="right">
  <a href="README.md">🇬🇧 English</a> |
  <a href="README_ES.md">🇪🇸 Español</a>
</p>

---

<p align="center">
  <h1 align="center">🚗 VexorMotors Dealership API</h1>
  <p align="center">
    Backend empresarial construido como un <strong>Monolito Modular</strong> para la gestión de concesionarios de vehículos.
  </p>

  <p align="center">
    <img src="https://img.shields.io/badge/Java-21-red">
    <img src="https://img.shields.io/badge/Spring%20Boot-3.x-green">
    <img src="https://img.shields.io/badge/Architecture-Modular%20Monolith-blue">
    <img src="https://img.shields.io/badge/Build-Gradle-orange">
    </p>

---

## Descripción General

**VexorMotors Dealership API** es un sistema backend empresarial diseñado para gestionar operaciones de concesionarios, tales como inventario de vehículos, ventas, autenticación y búsqueda.

El proyecto sigue una **arquitectura de Monolito Modular**, evolucionando desde un enfoque inicial de microservicios hacia una solución más pragmático, mantenible y escalable, sin la sobrecarga operativa innecesaria.

---

## Enfoque Arquitectónico

### Monolito Modular (Multi-Proyecto Gradle)

- Aplicación única desplegable.
- Límites de módulos claros forzados por Gradle.
- Comunicación en memoria entre dominios.
- Sin REST interno ni brokers de mensajería.
- Fuerte separación de responsabilidades.
- Desarrollo y despliegue local sencillos.

Este enfoque combina la **claridad de los microservicios** con la **simplicidad de un monolito**.

---

## Estructura del Proyecto

```text
vexorMotors
├── apps/                    # Puntos de entrada de la aplicación
│   ├── customer-API         # API pública (BFF - Backend for Frontend)
│   └── employee-API         # API interna / empleados
│
├── modules/                 # Dominios de negocio (lógica pura)
│   ├── auth
│   ├── inventory
│   ├── sales
│   ├── chat
│   └── search
│
├── shared/                  # Contratos compartidos e infraestructura
│   ├── kernel
│   ├── persistence-base
│   └── common-infra
│
└── docker/                  # Infraestructura local (PostgreSQL, pgAdmin)
```

---

## Responsabilidades

### apps/*
```text
    - Controladores REST
    - Configuración de seguridad
    - Validación de peticiones
    - Orquestación de API
    - Arranque de Spring Boot (@SpringBootApplication)
```

### modules/*
```text
    - Lógica de negocio
    - Entidades de dominio
    - Repositorios
    - Servicios de dominio
    - Reglas de negocio
```

### shared/*
```text
    - Contratos compartidos (DTOs, eventos)
    - Configuración base de persistencia
    - Utilidades de infraestructura común
    - Cero lógica de negocio
```

---

## Estrategia de Base de Datos
```text
    - Instancia única de PostgreSQL
    - Instancia lógica / Esquemas separados
    - Sin 'joins' entre módulos
    - Fuerte disciplina de propiedad de datos
```

---

## Tecnologías

- Java 21
- Spring Boot 3.x
- Spring WebMVC
- Spring Data JPA
- Spring Security
- Flyway
- Spring Boot Actuator
- Lombok
- Gradle
- JUnit 5

---

## Desarrollo Local

### Requisitos

- Java 21+
- Gradle
- Docker y Docker Compose

### Iniciar infraestructura
```bash
docker compose up -d
```

### Ejecutar aplicación
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