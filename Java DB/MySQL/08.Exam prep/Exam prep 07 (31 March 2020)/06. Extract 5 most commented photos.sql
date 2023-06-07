SELECT 
    p.id AS 'id',
    p.date AS 'date_and_time',
    p.description AS 'description',
    COUNT(c.photo_id) AS 'commentsCount'
FROM
    photos AS p
        LEFT JOIN
    comments AS c ON c.photo_id = p.id
GROUP BY p.id
ORDER BY commentsCount DESC , id
LIMIT 5;