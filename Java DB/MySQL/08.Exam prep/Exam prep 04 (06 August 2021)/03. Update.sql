UPDATE employees AS e
        JOIN
    teams AS t ON t.leader_id = e.id 
SET 
    e.salary = e.salary + 1000
WHERE
    e.age <= 40 AND e.salary < 5000;
    
select e.id, concat_ws(' ', e.first_name, e.last_name) as 'full_name', e.age, t.leader_id from employees as e
join teams as t on t.leader_id = e.id
where e.age <= 40 and salary < 5000