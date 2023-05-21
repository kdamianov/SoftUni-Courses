CREATE TABLE categories (
    id INT AUTO_INCREMENT,
    category VARCHAR(30) NOT NULL,
    daily_rate DOUBLE,
    weekly_rate DOUBLE,
    monthly_rate DOUBLE,
    weekend_rate DOUBLE,
    PRIMARY KEY (id)
); 

INSERT INTO categories (category) 
VALUES
('test1'),
('test2'),
('test3');

CREATE TABLE cars (
    id INT AUTO_INCREMENT,
    plate_number VARCHAR(20),
    make VARCHAR(20) NOT NULL,
    model VARCHAR(20),
    car_year INT,
    category_id INT,
    doors INT,
    picture BLOB,
    car_condition VARCHAR(20),
    available BOOLEAN,
    PRIMARY KEY (id)
); 

INSERT INTO cars (make) 
VALUES
('test1'),
('test2'),
('test3');

CREATE TABLE employees (
    id INT AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40),
    title VARCHAR(20),
    notes TEXT,
    PRIMARY KEY (id)
);

INSERT INTO employees (first_name) 
VALUES
('test1'),
('test2'),
('test3');

CREATE TABLE customers (
    id INT AUTO_INCREMENT,
    driver_licence_number INT,
    full_name VARCHAR(50) NOT NULL,
    address VARCHAR(50),
    city VARCHAR(20),
    zip_code INT,
    notes TEXT,
    PRIMARY KEY (id)
);

INSERT INTO customers (full_name) 
VALUES
('test1'),
('test2'),
('test3');

CREATE TABLE rental_orders (
    id INT AUTO_INCREMENT,
    employee_id INT,
    customer_id INT,
    car_id INT,
    car_condition VARCHAR(50) NOT NULL,
    tank_level VARCHAR(20),
    kilometrage_start INT,
    kilometrage_end INT,
    total_kilometrage INT,
    start_date DATE,
    end_date DATE,
    total_days INT,
    rate_applied DOUBLE,
    tax_rate DOUBLE,
    order_status VARCHAR(20),
    notes TEXT,
    PRIMARY KEY (id)
    
);

INSERT INTO rental_orders (car_condition) 
VALUES
('test1'),
('test2'),
('test3');










       
