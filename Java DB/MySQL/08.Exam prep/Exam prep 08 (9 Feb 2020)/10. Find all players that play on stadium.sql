DELIMITER $$
CREATE FUNCTION udf_stadium_players_count (stadium_name VARCHAR(30)) 
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(p.first_name)
			FROM stadiums AS s
			LEFT JOIN teams AS t ON t.stadium_id = s.id
			LEFT JOIN players AS p ON p.team_id = t.id
			WHERE
			s.name = stadium_name
			GROUP BY s.id);
END$$

DELIMITER ;

SELECT udf_stadium_players_count ('Jaxworks') as `count`; 