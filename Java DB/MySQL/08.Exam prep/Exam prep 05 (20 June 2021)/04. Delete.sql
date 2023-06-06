DELETE cl FROM clients AS cl
        LEFT JOIN
    courses AS co ON co.client_id = cl.id 
WHERE
    co.client_id IS NULL
    AND CHAR_LENGTH(cl.full_name) > 3;