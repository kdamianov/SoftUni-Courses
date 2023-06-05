DELIMITER $$
create function udf_game_info_by_name (game_name VARCHAR (20)) 
returns text
deterministic
begin
return concat('The ', game_name, ' is developed by a ', (select t.name from teams as t join games as g on g.team_id = t.id where g.name = game_name), 
' in an office with an address ',
(select a.name from games as g 
join teams as t on t.id = g.team_id
join offices as o on o.id = t.office_id
join addresses as a on a.id = o.address_id
where g.name = game_name));

end$$
DELIMITER ;
SELECT udf_game_info_by_name('Bitwolf') AS info;
