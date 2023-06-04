SELECT 
    CONCAT_WS(' ', c.first_name, c.last_name) AS 'full_name',
    c.address,
    o.order_datetime AS 'order_date'
FROM
    customers AS c
        LEFT JOIN
    orders AS o ON o.customer_id = c.id
WHERE
    YEAR(o.order_datetime) <= 2018
ORDER BY full_name DESC;