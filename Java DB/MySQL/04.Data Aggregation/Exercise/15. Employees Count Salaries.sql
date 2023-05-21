SELECT 
    COUNT(salary)
FROM
    employees
WHERE
    manager_id IS NULL
ORDER BY department_id;