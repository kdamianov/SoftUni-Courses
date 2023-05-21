CREATE DATABASE soft_uni;
USE soft_uni;
CREATE TABLE towns (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE addresses (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    address_text TEXT NOT NULL,
    town_id INT,
    FOREIGN KEY (town_id)
        REFERENCES towns (id)
);

CREATE TABLE departments (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(40) NOT NULL
);

CREATE TABLE employees (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50),
    last_name VARCHAR(50) NOT NULL,
    job_title VARCHAR(50),
    department_id INT,
    hire_date DATE,
    salary DOUBLE(10,2),
    address_id INT,
    FOREIGN KEY (department_id)
        REFERENCES departments (id),
    FOREIGN KEY (address_id)
        REFERENCES addresses (id)
);