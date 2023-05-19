SELECT 
    category_id,
    ROUND(AVG(price), 2) AS 'Average price',
    MIN(price) AS 'Cheapest product',
    MAX(price) AS 'Most Expensive Product'
FROM
    products
GROUP BY category_id;