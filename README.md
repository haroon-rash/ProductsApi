# 🛒 Reactive Products API

A high-performance, non-blocking **RESTful Product Management API** built with **Spring WebFlux**, **R2DBC**, and **Postgres**. Fully reactive using Project Reactor to deliver scalable and responsive backend services.

---

## 🚀 Tech Stack

| Layer        | Tech                     |
|--------------|--------------------------|
| Language     | Java 21                  |
| Framework    | Spring Boot 3.5, WebFlux |
| Database     | MySQL 8.x                |
| ORM Layer    | R2DBC (Reactive SQL)     |
| Build Tool   | Maven                    |
| Others       | Lombok, UUID, DevTools   |

---

## 📦 Features

- ✅ Fully reactive, non-blocking architecture  
- ✅ CRUD operations for `Product` entity  
- ✅ UUID as primary key  
- ✅ R2DBC with MySQL (Reactive Relational DB)  
- ✅ Validation and error handling  
- ✅ Clean and layered project structure  

---

## 🧩 Product Entity Structure

```java
@Id
private UUID id;
@NonNull private String name;
@NonNull private String description;
@NonNull private int quantity;
@NonNull private double price;

```

---

## 📂 Project Structure

```
├── com.org.productsapi
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entities
│  
```

---

## ⚙️ application.properties

```properties
# App Name and Port
spring.application.name=ProductsApi
server.port=8081

# R2DBC PostgreSQL connection
spring.r2dbc.url=r2dbc:postgresql://localhost:5432/products
spring.r2dbc.username=root
spring.r2dbc.password=root@1234

# JDBC URL for schema initialization (if needed)
spring.datasource.url=jdbc:postgresql://localhost:5432/products
spring.datasource.username=root
spring.datasource.password=root@1234
spring.datasource.driver-class-name=org.postgresql.Driver

# Optional: Disable automatic SQL init if you create tables manually
spring.sql.init.mode=never

# Logging for debugging
logging.level.org.springframework.r2dbc=DEBUG


---

## 🛠️ SQL Table (Manual Creation)

> Since R2DBC does not support auto schema creation, run this SQL manually:

```sql
CREATE TABLE products (
    id CHAR(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL,
    categories VARCHAR(255) NOT NULL
);
```

---


---

## ▶️ How to Run

1. ✅ Ensure Postgress is running and create the `productsdb` database
2. ✅ Run the SQL table creation script
3. ✅ Update `application.properties` with correct DB credentials
4. ✅ Run the Spring Boot app:
```bash
./mvnw spring-boot:run
```

---

## ❤️ Contributing

Pull requests are welcome. Please make sure your code is well-tested and follows reactive best practices.

---

 
