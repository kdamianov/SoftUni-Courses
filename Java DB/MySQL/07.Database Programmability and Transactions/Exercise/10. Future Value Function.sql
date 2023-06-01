DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(init_sum DECIMAL(19, 4), yearly_interest_rate DECIMAL (19,4), years INT)

RETURNS DECIMAL (19, 4)
DETERMINISTIC
BEGIN
RETURN 
	init_sum * POW((1 + yearly_interest_rate), years);
END$$

select ufn_calculate_future_value(1000, 0.5, 5);
