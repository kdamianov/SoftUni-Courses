DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(50,4))
returns varchar (10)
DETERMINISTIC
BEGIN
	DECLARE salary_level varchar(10);
    set salary_level := (
    case
    when salary < 30000 then 'Low'
    when salary <= 50000 then 'Average'
    when salary > 50000 then 'High'
    end);
    return salary_level;
END$$

DELIMITER ;
;

SELECT ufn_get_salary_level(125500.00);



 