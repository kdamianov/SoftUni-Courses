DELIMITER $$
create procedure udp_update_budget(min_game_rating float)
begin
update games as g
left join games_categories as gc on gc.game_id = g.id
set 
g.budget = g.budget + 100000,
g.release_date = date_add(`release_date`, interval 1 year)
where gc.category_id is null and g.rating > min_game_rating and g.release_date is not null;
end$$

DELIMITER ;
SET SQL_SAFE_UPDATES = 0;
call udp_update_budget(8);