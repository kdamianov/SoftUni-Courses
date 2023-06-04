INSERT into actors (first_name, last_name , birthdate ,height ,awards ,country_id  )
select reverse(first_name), reverse(last_name), DATE_SUB(birthdate,INTERVAL 2 DAY), (height + 10), country_id, 3 from actors
where id <= 10;