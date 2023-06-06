SELECT 
    a.name AS `name`,
    (CASE
        WHEN HOUR(co.start) BETWEEN 6 AND 20 THEN 'Day'
        ELSE 'Night'
    END) AS 'day_time',
    co.bill as 'bill',
    cl.full_name as 'full_name',
    ca.make as 'make',
    ca.model as 'model',
    cat.name as 'category_name'
FROM
    courses AS co
        JOIN
    addresses AS a ON a.id = co.from_address_id
        JOIN
    cars AS ca ON ca.id = co.car_id
        JOIN
    categories AS cat ON cat.id = ca.category_id
        JOIN
    clients AS cl ON cl.id = co.client_id
ORDER BY co.id;
