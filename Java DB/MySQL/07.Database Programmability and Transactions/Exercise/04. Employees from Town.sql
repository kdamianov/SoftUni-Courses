DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(50))
BEGIN
	SELECT 
    e.first_name, e.last_name
FROM
    employees as e
    join addresses as a on a.address_id = e.address_id
    join towns as t on t.town_id = a.town_id
    where t.name = town_name
    order by e.first_name, e.last_name, e.employee_id;
END$$

DELIMITER ;
;

CALL usp_get_employees_from_town('Sofia');



 