SELECT 
    t.name AS 'team_name',
    a.name AS 'address_name',
    CHAR_LENGTH(a.name) AS 'count_of_characters'
FROM
    teams AS t
        LEFT JOIN
    offices AS o ON o.id = t.office_id
        LEFT JOIN
    addresses AS a ON a.id = o.address_id
WHERE
    website IS NOT NULL
ORDER BY team_name , address_name;