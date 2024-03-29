SELECT 
    first_name, last_name
FROM
    employees
WHERE
    SUBSTRING(`first_name`, 1, 2) = 'Sa'
ORDER BY employee_id;

SELECT 
    first_name, last_name
FROM
    employees
WHERE
    first_name LIKE 'Sa%'
ORDER BY employee_id;

SELECT 
    first_name, last_name
FROM
    employees
WHERE
    first_name REGEXP '^sa'
ORDER BY employee_id;

SELECT 
    first_name, last_name
FROM
    employees
WHERE
    left(first_name, 2) LIKE 'Sa'
ORDER BY employee_id;