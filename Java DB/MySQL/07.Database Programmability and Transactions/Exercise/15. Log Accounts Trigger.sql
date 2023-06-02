CREATE TABLE logs (
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT NOT NULL,
    old_sum DECIMAL(19 , 4 ),
    new_sum DECIMAL(19 , 4 ),
    CONSTRAINT fk_logs_accounts FOREIGN KEY (account_id)
        REFERENCES accounts (id)
);

DELIMITER $$
CREATE TRIGGER tr_balance_update
	AFTER UPDATE
	ON accounts
	FOR EACH ROW
BEGIN
	IF OLD.balance <> NEW.balance
		THEN 
			INSERT INTO logs (account_id, old_sum, new_sum)
			VALUES (OLD.id, OLD.balance, NEW.balance);
    END IF;
END$$




