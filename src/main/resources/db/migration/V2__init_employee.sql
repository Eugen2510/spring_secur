CREATE TABLE IF NOT EXISTS employee
(
    employee_id IDENTITY PRIMARY KEY,
    employee_name VARCHAR(100) NOT NULL,
    salary INT DEFAULT NULL
    );