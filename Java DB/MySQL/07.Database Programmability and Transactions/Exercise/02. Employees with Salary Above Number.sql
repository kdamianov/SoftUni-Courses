DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(base_salary DECIMAL(10, 4))
BEGIN
	SELECT 
		e.first_name, e.last_name
	FROM
		employees AS e
	WHERE
		e.salary >= base_salary
	ORDER BY e.first_name asc, e.last_name ASC, e.employee_id ASC;
END$$

DELIMITER ;
;
CALL usp_get_employees_salary_above(45000);



 