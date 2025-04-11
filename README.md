
# API REST de Usuarios

Este proyecto es una API REST construida con **Spring Boot 3.4.4**, que permite realizar operaciones CRUD sobre una entidad `User`. Utiliza **Spring Web**, **Spring Data JPA** y una base de datos **MySQL**.

---

## 📦 Características

- Listar todos los usuarios
- Obtener un usuario por su ID
- Crear un nuevo usuario
- Actualizar un usuario existente
- Eliminar un usuario

---

## 🚀 Requisitos

Antes de empezar, asegúrate de tener instalado:

- Java 21+
- Maven 3.9+
- MySQL 8+
- IDE recomendado: IntelliJ IDEA o VS Code

---

## ⚙️ Configuración del entorno

1. **Clonar el repositorio:**

```bash
git clone https://github.com/jorgevidovic/api-rest-spring
cd api-rest-spring
```

2. **Crear archivo `.env` y definir las variables de entorno:**

Ejemplo en `application.properties`:

```properties
spring.application.name=${APP_NAME}
server.port=${SERVER_PORT:8080}

# JPA / Hibernate
spring.jpa.database=MYSQL
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=${JPA_HBM_STRATEGY:update}
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.open-in-view=false

# MySQL
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASS}
```
---

## ▶️ Ejecución del proyecto

```bash
./mvnw spring-boot:run
```

O bien, si usas IntelliJ:

- Abre el proyecto
- Ejecuta la clase `ApiRestApplication` desde el panel lateral

---

## 🧪 Ejecución de pruebas

Este proyecto incluye pruebas unitarias y de integración para el controlador.

```bash
./mvnw test
```

---

## 📂 Estructura del proyecto

```
src/
├── main/
│   ├── java/com/vsprojects/api_rest/
│   │   ├── controllers/
│   │   ├── models/
│   │   ├── repositories/
│   │   ├── services/
│   │   └── ApiRestApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/vsprojects/api_rest/
        └── UserControllerTest.java
```

---

## 🔗 Recursos

- [Guía oficial de Spring Boot](https://spring.io/projects/spring-boot)
- [Documentación de Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Guía: Acceso a datos con MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

---

## 🛠️ Notas de desarrollo

- Se recomienda usar perfiles de entorno (`application-dev.properties`, `application-prod.properties`) para separar configuraciones.
- Puedes usar [Spring DevTools](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.devtools) para recarga automática durante el desarrollo.

---

## 🧾 Licencia

Este proyecto se distribuye bajo licencia MIT.
