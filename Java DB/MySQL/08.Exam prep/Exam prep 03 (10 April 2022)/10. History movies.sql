DELIMITER $$
CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50)) 
RETURNS INT
DETERMINISTIC
BEGIN
	return (
    select count(g.name) as 'history_movies' 
    from actors as a
		join movies_actors as ma on ma.actor_id = a.id
		join genres_movies as gm on gm.movie_id = ma.movie_id
		join genres as g on g.id = gm.genre_id
	where concat_ws(' ', a.first_name, a.last_name) = full_name and g.name = 'history'
	group by g.name);
END$$

delimiter ;
SELECT udf_actor_history_movies_count('Stephan Lundberg')  AS 'history_movies';
SELECT udf_actor_history_movies_count('Jared Di Batista')  AS 'history_movies';
SELECT udf_actor_history_movies_count('Lucretia Binks')  AS 'history_movies';