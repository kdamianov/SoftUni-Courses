SELECT 
    t.id AS table_id,
    capacity,
    COUNT(oc.client_id) AS 'count_clients', -- the number of people from all orders that are sitting on that table 
    (CASE
        WHEN capacity > COUNT(oc.client_id) THEN 'Free seats'
        WHEN capacity = COUNT(oc.client_id) THEN 'Full'
        ELSE 'Extra seats'
    END) AS 'availability ' -- how many people are sitting and the capacity of the table 
    -- (IF(capacity > COUNT(oc.client_id),
	--         'Free seats',
	--         IF(capacity = COUNT(oc.client_id),
	--             'Full',
	--             'Extra seats'))) AS 'availability ' 
FROM
    `tables` AS t
        JOIN
    orders AS o ON o.table_id = t.id
        JOIN
    orders_clients AS oc ON oc.order_id = o.id
WHERE
    floor = 1
GROUP BY table_id
ORDER BY table_id DESC;