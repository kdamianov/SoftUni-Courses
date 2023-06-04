DELIMITER $$
CREATE PROCEDURE udp_reduce_price(category_name VARCHAR(50))
BEGIN
	UPDATE products as p
	join reviews as r on r.id = p.review_id
	join categories as c on c.id = p.category_id
	SET p.price = p.price * 0.7
	where c.name = category_name and r.rating < 4;
END$$

