SELECT 
    CONCAT_WS(' ', u.id, u.username) AS 'id_username',
    u.email AS ' email'
FROM
    users AS u
        LEFT JOIN
    users_photos AS up ON up.user_id = u.id
WHERE
    u.id = up.photo_id
ORDER BY u.id;