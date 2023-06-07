DELIMITER $$
CREATE FUNCTION udf_users_photos_count(username VARCHAR(30)) 
RETURNS INT
DETERMINISTIC
BEGIN
return (select count(up.photo_id) from users as u
left join users_photos as up on up.user_id = u.id
where u.username = username
group by u.id);
END$$

delimiter ;

SELECT udf_users_photos_count('ssantryd') AS photosCount;
