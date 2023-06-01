DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(argument VARCHAR(50))
BEGIN
	SELECT 
		t.name
	FROM
		towns AS t
	WHERE
		-- LOCATE(argument, t.name) = 1 -- Трябва да върне само на първата позиция 
        t.name LIKE CONCAT('argument', '%')
	ORDER BY t.name;
END$$