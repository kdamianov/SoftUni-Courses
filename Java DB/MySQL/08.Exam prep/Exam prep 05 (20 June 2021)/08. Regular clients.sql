SELECT 
    cl.full_name AS 'full_name',
    COUNT(co.car_id) AS 'count_of_cars',
    SUM(co.bill) AS 'total_sum'
FROM
    clients AS cl
        JOIN
    courses AS co ON co.client_id = cl.id
WHERE
    SUBSTRING(cl.full_name, 2, 1) = 'a'
GROUP BY full_name
HAVING count_of_cars NOT IN (1)
ORDER BY full_name;
