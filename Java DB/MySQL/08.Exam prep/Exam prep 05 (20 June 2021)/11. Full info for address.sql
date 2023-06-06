DELIMITER $$
CREATE PROCEDURE udp_courses_by_address (address_name VARCHAR(100))
BEGIN
SELECT 
    a.name AS 'name',
    cl.full_name AS 'full_name',
    (CASE
        WHEN co.bill <= 20 THEN 'Low'
        WHEN co.bill <= 30 THEN 'Medium'
        ELSE 'High'
    END) AS 'level_of_bill',
    ca.make AS 'make',
    ca.condition AS 'condition',
    cat.name AS 'cat_name'
FROM
    courses AS co
        LEFT JOIN
    addresses AS a ON a.id = co.from_address_id
        LEFT JOIN
    clients AS cl ON cl.id = co.client_id
        LEFT JOIN
    cars AS ca ON ca.id = co.car_id
        LEFT JOIN
    categories AS cat ON cat.id = ca.category_id
WHERE
    a.name = address_name
ORDER BY ca.make , cl.full_name;
END$$

DELIMITER ;
CALL udp_courses_by_address('66 Thompson Drive');