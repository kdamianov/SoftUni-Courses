DELIMITER $$
CREATE PROCEDURE  udp_update_product_price (address_name VARCHAR (50))
BEGIN
DECLARE increasement INT;
	if address_name LIKE '0%' then set increasement = 100;
	else set increasement = 200;
	end if;
    
    UPDATE products as p set p.price = p.price + increasement
    WHERE p.id in (
				select ps.product_id from addresses as a
                join stores as s on s.address_id = a.id
                join products_stores as ps on ps.store_id = s.id
                where a.name = address_name
                );
END$$

DELIMITER ;
CALL udp_update_product_price('1 Cody Pass');
SELECT name, price FROM products WHERE id = 17;

