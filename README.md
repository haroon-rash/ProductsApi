# 🛒 Reactive Products API

A high-performance, non-blocking **RESTful Product Management API** built with **Spring WebFlux**, **R2DBC**, and **MySQL**. Fully reactive using Project Reactor to deliver scalable and responsive backend services.

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
@NonNull private String categories;
```

---

## 📂 Project Structure

```
├── com.org.productsapi
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entities
│   └── config
```

---

## ⚙️ application.properties

```properties
# Server Port
server.port=8080

# R2DBC Configuration
spring.r2dbc.url=r2dbc:mysql://localhost:3306/productsdb
spring.r2dbc.username=root
spring.r2dbc.password=your_password

# Disable Spring SQL Init since we’re not using schema.sql
spring.sql.init.mode=never

# Optional: Show SQL queries in logs
spring.r2dbc.properties.logging=true
```

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

## 📬 API Endpoints

| Method | Endpoint           | Description        |
|--------|--------------------|--------------------|
| GET    | `/products`        | List all products  |
| GET    | `/products/{id}`   | Get a product      |
| POST   | `/products`        | Create new product |
| PUT    | `/products/{id}`   | Update product     |
| DELETE | `/products/{id}`   | Delete product     |

---

## ▶️ How to Run

1. ✅ Ensure MySQL is running and create the `productsdb` database
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

 
