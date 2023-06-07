INSERT into products_stores (product_id, store_id )
SELECT 
    p.id, 1
FROM
    products AS p
        LEFT JOIN
    products_stores AS ps ON ps.product_id = p.id
        LEFT JOIN
    stores AS s ON s.id = ps.store_id
WHERE
    ps.product_id IS NULL;