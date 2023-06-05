SELECT 
    g.name AS `name`,
    (CASE
        WHEN g.budget < 50000 THEN 'Normal budget'
        ELSE 'Insufficient budget'
    END) AS 'budget_level',
    t.name AS 'team_name',
    a.name AS 'address_name'
FROM
    games AS g
        LEFT JOIN
    teams AS t ON t.id = g.team_id
        LEFT JOIN
    games_categories AS gc ON gc.game_id = g.id
        JOIN
    offices AS o ON o.id = t.office_id
        JOIN
    addresses AS a ON a.id = o.address_id
WHERE
    g.release_date IS NULL
        AND gc.category_id IS NULL
ORDER BY g.name;
 
