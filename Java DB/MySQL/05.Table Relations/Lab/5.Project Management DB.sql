CREATE SCHEMA project_management_db;
USE project_management_db;

-- clients
CREATE TABLE clients (
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    client_name VARCHAR(100) NOT NULL
);
-- projects
create table projects (
id int primary KEy auto_increment,
client_id int,
project_lead_id int
);
-- employess
CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    project_id INT
);

ALTER TABLE projects
ADD CONSTRAINT fk_projects_clients
FOREIGN KEY (client_id)
REFERENCES clients(id),
ADD CONSTRAINT fk_projects_employees
FOREIGN KEY (project_lead_id)
REFERENCES employees(id);

ALTER TABLE employees
ADD CONSTRAINT fk_employees_projects
FOREIGN KEY (project_id)
REFERENCES projects(id);
  
 