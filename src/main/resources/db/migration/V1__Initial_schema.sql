CREATE TABLE car (
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     brand VARCHAR(50) NOT NULL,
                     model VARCHAR(50) NOT NULL,
                     daily_price DECIMAL(10,2) NOT NULL,
                     location VARCHAR(20) NOT NULL,
                     deleted BOOLEAN DEFAULT FALSE
);

CREATE TABLE offer (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       client_name VARCHAR(100) NOT NULL,
                       client_address VARCHAR(255),
                       client_phone VARCHAR(20),
                       client_age INT,
                       has_accidents BOOLEAN,
                       car_id BIGINT,
                       days INT,
                       price DECIMAL(10,2),
                       status VARCHAR(20),
                       deleted BOOLEAN DEFAULT FALSE,

                       CONSTRAINT fk_offer_car
                           FOREIGN KEY (car_id)
                               REFERENCES car(id)
);
