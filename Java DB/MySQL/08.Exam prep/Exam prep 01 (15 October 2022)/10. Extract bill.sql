DELIMITER $$
CREATE function udf_client_bill(full_name VARCHAR(50))
RETURNS DECIMAL (19, 2)
DETERMINISTIC
BEGIN 
DECLARE space_index INT;
SET space_index := LOCATE(' ', full_name);
	return (SELECT 
    SUM(p.price) AS 'bill'
FROM
    clients AS c 
    JOIN orders_clients AS oc ON oc.client_id = c.id
	JOIN orders AS o ON o.id = oc.order_id
    JOIN orders_products AS op ON op.order_id = o.id
    JOIN products AS p ON p.id = op.product_id
WHERE c.first_name = SUBSTRING(full_name, 1, space_index - 1) AND 
c.last_name = SUBSTRING(full_name, space_index + 1));
END$$

DELIMITER ;

SELECT 
    c.first_name,
    c.last_name,
    UDF_CLIENT_BILL('Silvio Blyth') AS 'bill'
FROM
    clients c
WHERE
    c.first_name = 'Silvio'
        AND c.last_name = 'Blyth';




