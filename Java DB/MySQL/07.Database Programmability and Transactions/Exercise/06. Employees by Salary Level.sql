--Използваме предходната функция! 
DELIMITER $$

CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level varchar(10))
BEGIN
	Select e.first_name, e.last_name 
    from 
    employees as e
	where ufn_get_salary_level(e.salary) = salary_level
    order by e.first_name desc, e.last_name desc;
END$$

CALL usp_get_employees_by_salary_level('High')$$