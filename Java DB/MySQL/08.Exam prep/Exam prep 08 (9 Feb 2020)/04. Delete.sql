DELETE p FROM players AS p
        LEFT JOIN
    players_coaches AS pc ON pc.player_id = p.id 
WHERE
    p.age >= 45