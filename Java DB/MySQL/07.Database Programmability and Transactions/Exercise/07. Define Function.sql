DELIMITER $$
CREATE FUNCTION `ufn_is_word_comprised`(set_of_letters varchar(50), word varchar(50))
	RETURNS INT -- 0 -> Ако word не е съставена от set_of_letters
                -- 1 -> Ако word е съставена от set_of_letters
    DETERMINISTIC
BEGIN
	RETURN word REGEXP (CONCAT('^[', set_of_letters, ']+$'));
END$$

SELECT ufn_is_word_comprised('oistmiahf', 'Sofia');