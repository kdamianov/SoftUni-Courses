SELECT 
    pr.name AS 'product_name',
    pr.price AS 'price',
    pr.best_before AS 'best_before',
    + CONCAT(LEFT(pr.description, 10), '...') AS 'short_description',
    pic.url AS 'url'
FROM
    products AS pr
        JOIN
    pictures AS pic ON pic.id = pr.picture_id
WHERE
    CHAR_LENGTH(pr.`description`) > 100
        AND YEAR(pic.added_on) < 2019
        AND pr.price > 20
ORDER BY pr.price DESC;