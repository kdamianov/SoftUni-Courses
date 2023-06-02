DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN 
START transaction;
	IF money_amount <= 0 THEN ROLLBACK;
    
	UPDATE accounts
	SET balance = balance + money_amount
	WHERE id = account_id;
    COMMIT;
    END IF;
END$$