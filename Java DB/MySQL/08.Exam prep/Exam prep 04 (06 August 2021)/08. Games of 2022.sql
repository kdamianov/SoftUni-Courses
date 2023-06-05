SELECT 
    g.name AS 'name',
    release_date,
    CONCAT(LEFT(description, 10), '...') AS 'summary',
    (CASE
        WHEN QUARTER(release_date) = 1 THEN 'Q1'
        WHEN QUARTER(release_date) = 2 THEN 'Q2'
        WHEN QUARTER(release_date) = 3 THEN 'Q3'
        WHEN QUARTER(release_date) = 4 THEN 'Q4'
    END) AS 'quarter',
    t.name AS 'team_name'
FROM
    games AS g
        JOIN
    teams AS t ON t.id = g.team_id
WHERE
    g.name LIKE '%2'
        AND YEAR(release_date) = 2022
        AND MONTH(release_date) % 2 = 0
ORDER BY quarter;