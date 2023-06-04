SELECT 
    c.name, COUNT(m.country_id) AS 'movies_count'
FROM
    countries AS c
        JOIN
    movies AS m ON m.country_id = c.id
GROUP BY m.country_id
HAVING movies_count >= 7
ORDER BY c.name DESC;