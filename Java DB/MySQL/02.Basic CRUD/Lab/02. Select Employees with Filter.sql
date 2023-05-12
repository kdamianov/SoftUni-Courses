USE hotel;
SELECT `id` AS ID,
concat(`first_name`, ' ', `last_name`) AS 'Full name',
		`job_title` AS 'Job title',
        `salary` AS 'Salary'
        FROM employees
        WHERE salary > 1000
        ORDER by id;