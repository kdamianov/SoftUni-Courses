DELETE g FROM games AS g
        LEFT JOIN
    games_categories AS gc ON gc.game_id = g.id 
WHERE
    gc.category_id IS NULL
    AND g.release_date IS NULL;