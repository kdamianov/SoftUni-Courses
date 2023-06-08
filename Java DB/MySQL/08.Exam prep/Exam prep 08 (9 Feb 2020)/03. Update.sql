UPDATE coaches AS c
        LEFT JOIN
    players_coaches AS pc ON pc.coach_id = c.id 
SET 
    c.coach_level = c.coach_level + 1
WHERE
    pc.player_id >= 1
        AND c.first_name LIKE 'A%'
