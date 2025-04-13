DROP TABLE IF EXISTS offer;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS car;
DROP TYPE IF EXISTS city;


CREATE TYPE city AS ENUM ('SOFIA', 'PLOVDIV', 'VARNA', 'BURGAS', 'OTHER');

-- Създаване на таблица Car
CREATE TABLE cars (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      brand VARCHAR(100) NOT NULL,
                      model VARCHAR(100) NOT NULL,
                      daily_price DECIMAL(10, 2) NOT NULL,
                      location VARCHAR(20) CHECK (location IN ('SOFIA', 'PLOVDIV', 'VARNA', 'BURGAS', 'OTHER')),
                      deleted BOOLEAN NOT NULL DEFAULT FALSE
);


CREATE TABLE clients (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         address VARCHAR(255),
                         phone VARCHAR(20),
                         age INTEGER,
                         location VARCHAR(20) CHECK (location IN ('SOFIA', 'PLOVDIV', 'VARNA', 'BURGAS', 'OTHER'))
);


CREATE TABLE offers (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        has_accidents BOOLEAN NOT NULL DEFAULT FALSE,
                        car_id INTEGER NOT NULL,
                        client_id INTEGER NOT NULL,
                        days INTEGER NOT NULL,
                        price DECIMAL(10, 2) NOT NULL,
                        status VARCHAR(50) NOT NULL,
                        deleted BOOLEAN NOT NULL DEFAULT FALSE,
                        FOREIGN KEY (car_id) REFERENCES cars(id),
                        FOREIGN KEY (client_id) REFERENCES clients(id)
);