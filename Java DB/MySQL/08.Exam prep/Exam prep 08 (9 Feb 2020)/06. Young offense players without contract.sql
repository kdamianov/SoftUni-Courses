SELECT 
    p.id AS 'id',
    CONCAT_WS(' ', p.first_name, p.last_name) AS 'full_name',
    p.age AS 'age',
    p.position AS 'position',
    p.hire_date AS 'hire_date
    '
FROM
    players AS p
        JOIN
    skills_data AS sd ON sd.id = p.skills_data_id
WHERE
    p.age < 23 AND p.position = 'A'
        AND p.hire_date IS NULL
        AND sd.strength > 50
ORDER BY p.salary , age