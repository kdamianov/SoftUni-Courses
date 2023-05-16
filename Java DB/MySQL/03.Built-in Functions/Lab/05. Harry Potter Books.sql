SELECT 
    title
FROM
    books
WHERE
    title LIKE '%Harry Potter%';
    
SELECT 
    title
FROM
    books
WHERE
    title REGEXP '^Harry Potter';