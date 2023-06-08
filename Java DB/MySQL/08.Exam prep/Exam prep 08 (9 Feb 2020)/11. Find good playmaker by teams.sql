DELIMITER $$
CREATE PROCEDURE udp_find_playmaker (min_dribble_points INT, team_name VARCHAR(45))
BEGIN
select concat_ws(' ', p.first_name, p.last_name) as 'full_name', p.age as 'age', p.salary as 'salary', sd.dribbling as 'dribbling', sd.speed as 'speed', t.name as 'team_name'  from players as p
join skills_data as sd on sd.id = p.skills_data_id
join teams as t on t.id = p.team_id
where sd.dribbling > min_dribble_points and t.name = team_name
order by sd.speed desc
limit 1;

END$$

DELIMITER ;

CALL udp_find_playmaker (20, 'Skyble');