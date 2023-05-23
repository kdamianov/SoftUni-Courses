SELECT 
    first_name, last_name, department_id
FROM
    employees AS current_employee -- текущ служител 
WHERE
    salary > (SELECT 
            AVG(salary)
        FROM
            employees AS other_employee -- средната заплата за останалите в отдела 
        WHERE
            current_employee.department_id = other_employee.department_id) -- условие да са 
ORDER BY department_id , employee_id
LIMIT 10;