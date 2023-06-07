SELECT 
    st.name AS 'name',
    COUNT(ps.product_id) AS 'product_count',
    ROUND(AVG(p.price), 2) AS 'avg'
FROM
    stores AS st
        LEFT JOIN
    products_stores AS ps ON ps.store_id = st.id
        LEFT JOIN
    products AS p ON p.id = ps.product_id
GROUP BY st.id
ORDER BY product_count DESC , avg DESC , st.id
