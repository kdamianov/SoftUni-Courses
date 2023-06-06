SELECT 
    ca.id AS 'id',
    ca.make AS 'make',
    ca.mileage AS 'mileage',
    COUNT(co.id) AS 'count_of_courses',
    ROUND(AVG(co.bill), 2) AS 'avg_bill'
FROM
    cars AS ca
        LEFT JOIN
    courses AS co ON co.car_id = ca.id
GROUP BY ca.id
HAVING count_of_courses NOT IN (2)
ORDER BY count_of_courses DESC , id;
