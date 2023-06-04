DELIMITER $$
CREATE PROCEDURE udp_award_movie(movie_title VARCHAR(50))
BEGIN
	UPDATE actors as a
		join movies_actors as ma on ma.actor_id = a.id
		join movies as m on m.id = ma.movie_id
	SET a.awards = a.awards + 1
	where  m.title = movie_title;
END$$

call udp_award_movie('Tea For Two');

