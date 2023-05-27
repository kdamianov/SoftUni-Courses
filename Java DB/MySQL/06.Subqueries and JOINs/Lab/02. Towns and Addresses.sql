SELECT 
    towns.town_id, `name` AS town_name, address_text
FROM
    towns
        JOIN
    addresses ON towns.town_id = addresses.town_id
WHERE
    towns.name IN ('San Francisco' , 'Sofia', 'Carnation')
ORDER BY town_id , address_id;