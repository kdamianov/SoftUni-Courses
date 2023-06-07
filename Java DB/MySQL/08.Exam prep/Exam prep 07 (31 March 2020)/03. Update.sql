UPDATE addresses AS a 
SET 
    country = (CASE
        WHEN country LIKE 'B%' THEN 'Blocked'
        WHEN country LIKE 'T%' THEN 'Test'
        WHEN country LIKE 'P%' THEN 'In Progress'
    END)
WHERE
    LEFT(country, 1) IN ('B' , 'T', 'P');
