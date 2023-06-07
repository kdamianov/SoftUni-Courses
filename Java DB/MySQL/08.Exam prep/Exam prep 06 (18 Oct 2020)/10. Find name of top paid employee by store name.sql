DELIMITER $$
create function udf_top_paid_employee_by_store(store_name VARCHAR(50))
returns varchar (100)
deterministic
BEGIN
return 
	concat_ws(' ', (select concat_ws(' ', e.first_name, concat(e.middle_name,'.'), e.last_name) from employees as e
		join stores as s on s.id = e.store_id
		where s.name = store_name
		order by e.salary desc limit 1),
        'works in store for', 
        (select (year('2020-10-18') - year(e.hire_date)) from employees as e
		join stores as s on s.id = e.store_id
		where s.name = store_name
		order by e.salary desc limit 1), 
        'years');
END$$

DELIMITER ;
SELECT UDF_TOP_PAID_EMPLOYEE_BY_STORE('Stronghold') AS 'full_info';