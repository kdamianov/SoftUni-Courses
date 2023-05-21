SELECT 
    department_id AS 'd_id',
    (SELECT DISTINCT
            `salary`
        FROM
            `employees`
        WHERE
            department_id = `d_id`
        ORDER BY `salary` DESC
        LIMIT 2 , 1) AS `third_highest_salary`
FROM
    employees
GROUP BY d_id
HAVING `third_highest_salary` IS NOT NULL
ORDER BY d_id;