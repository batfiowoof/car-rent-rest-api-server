# Car Rent API

RESTful приложение за управление на коли под наем, изградено със Spring Boot.

## 🧾 Описание

Проектът предоставя API за управление на коли, клиенти и оферти за наем на коли. Всеки ресурс поддържа CRUD операции с **soft delete** (логическо изтриване). Данните се съхраняват в **H2 база**, а **Flyway** се използва за управление на миграции.

---

## 🚀 Технологии и зависимости

- **Spring Boot**
- **Spring Data JPA**
- **Lombok**
- **Flyway**
- **H2 Database**

---

## 🌐 API Endpoints

**Base URL:** `http://localhost:8080/api`

### 📁 Cars

`/cars`

- `GET ` – Извлича всички коли  
- `GET /{id}` – Извлича кола по ID  
- `POST` – Създава нова кола  
- `PUT /{id}` – Актуализира кола  
- `DELETE /{id}` – Soft delete на кола  

### 👤 Clients

`/clients`

- `GET` – Извлича всички клиенти  
- `GET /{id}` – Извлича клиент по ID  
- `POST ` – Създава нов клиент  
- `PUT /{id}` – Актуализира клиент  
- `DELETE /{id}` – Soft delete на клиент  

### 🎁 Offers

`/offers`

- `GET /{id}` – Извлича оферта по клиентско ID
- `GET /offer/{id}` - Извлича оферта по ID  
- `POST ` – Създава нова оферта  
- `PUT /{id}` – Актуализира оферта  
- `DELETE /{id}` – Soft delete на оферта  

---

## 📂 Структура на проекта

```
src/
└── main/
    └── java/
        └── com/example/car_rent/
            ├── controllers/        # REST контролери
            ├── entities/           # JPA ентитети
            ├── enums/              # Енуми
            ├── repositories/       # Spring Data JPA репозитории
            ├── services/           # Сървиси с бизнес логика
            └── CarRentApplication  # Главен клас
```

---

## 🛠️ Стартиране на проекта

1. Клонирай хранилището:
    ```bash
    git clone https://github.com/batfiowoof/car-rent-rest-api-server
    ```

2. Стартирайте приложението:
    - Чрез IDE (например IntelliJ) – стартирай `CarRentApplication`
    - Или с Maven:
      ```bash
      mvn spring-boot:run
      ```

3. Достъп до H2 конзолата:
    - `http://localhost:8080/h2-console`
  

## ☁️ Deploy

`https://car-rent-rest-api-server.onrender.com/`

За най-лесно тестване нагласете https://car-rent-rest-api-server.onrender.com/ като environment в Postman и използвайте предоставената колекция от Postman заявки за тест.
