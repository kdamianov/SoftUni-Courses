SELECT 
    COUNT(*) as 'Count'
FROM
    products
WHERE
    category_id = 2 AND price > 8;
