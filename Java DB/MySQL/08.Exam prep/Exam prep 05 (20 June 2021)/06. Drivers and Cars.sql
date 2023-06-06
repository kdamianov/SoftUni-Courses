SELECT 
    d.first_name AS 'first_name',
    d.last_name AS 'last_name',
    c.make AS 'make',
    c.model AS 'model',
    c.mileage AS 'mileage'
FROM
    drivers AS d
        JOIN
    cars_drivers AS cd ON cd.driver_id = d.id
        JOIN
    cars AS c ON c.id = cd.car_id
WHERE
    c.mileage IS NOT NULL
ORDER BY c.mileage DESC , d.first_name;