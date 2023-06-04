SELECT 
    m.title AS 'title',
    (CASE
        WHEN mai.rating <= 4 THEN 'poor'
        WHEN mai.rating <= 7 THEN 'good'
        ELSE 'excellent'
    END) AS 'rating',
    (CASE
        WHEN mai.has_subtitles = 1 THEN 'english'
        ELSE '-'
    END) AS 'subtitles',
    mai.budget AS 'budget'
FROM
    movies AS m
        JOIN
    movies_additional_info AS mai ON mai.id = m.movie_info_id
ORDER BY mai.budget DESC;
