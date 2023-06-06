DELIMITER $$
CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20)) 
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (
		SELECT count(co.client_id) from clients as cl
		LEFT JOIN courses AS co ON co.client_id = cl.id
		WHERE cl.phone_number = phone_num
		);
	END$$

DELIMITER ;
SELECT udf_courses_by_client ('(704) 2502909') AS `count`;

