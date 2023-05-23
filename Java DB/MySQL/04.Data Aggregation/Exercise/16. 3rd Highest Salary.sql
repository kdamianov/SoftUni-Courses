SELECT 
    department_id,
    (SELECT DISTINCT
            `salary`
        FROM
            `employees` AS e
        WHERE
            e.department_id = `employees`.department_id -- текущото ID да съвпада с първоначлано избраното ID
        ORDER BY `salary` DESC
        LIMIT 2 , 1) AS `third_highest_salary`
FROM
    employees
GROUP BY department_id
HAVING `third_highest_salary` IS NOT NULL
ORDER BY department_id;