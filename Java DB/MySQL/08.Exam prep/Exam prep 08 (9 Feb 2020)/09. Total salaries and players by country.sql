SELECT 
    c.name AS 'name',
    COUNT(p.id) AS 'total_count_of_players',
    SUM(p.salary) AS 'total_sum_of_salaries'
FROM
    countries AS c
        LEFT JOIN
    towns AS t ON t.country_id = c.id
        LEFT JOIN
    stadiums AS s ON s.town_id = t.id
        LEFT JOIN
    teams AS te ON te.stadium_id = s.id
        LEFT JOIN
    players AS p ON p.team_id = te.id
GROUP BY c.id
ORDER BY total_count_of_players DESC , `name`