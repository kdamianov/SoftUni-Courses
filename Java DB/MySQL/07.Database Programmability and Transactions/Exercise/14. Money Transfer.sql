DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL (19, 4))
BEGIN
IF amount > 0 
	AND (SELECT id FROM accounts WHERE from_account_id = id) IS NOT NULL
	AND (SELECT id FROM accounts WHERE to_account_id = id) IS NOT NULL
	AND (SELECT balance FROM accounts WHERE from_account_id = id) >= amount 
    AND (from_account_id <> to_account_id)
THEN 
	START TRANSACTION;
	UPDATE accounts
	SET balance = balance - amount WHERE id = from_account_id;
	UPDATE accounts
	SET balance = balance + amount WHERE id = to_account_id;
END IF;
END$$