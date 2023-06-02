CREATE TABLE logs (
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT NOT NULL,
    old_sum DECIMAL(19 , 4 ),
    new_sum DECIMAL(19 , 4 ),
    CONSTRAINT fk_logs_accounts FOREIGN KEY (account_id)
        REFERENCES accounts (id)
);

DELIMITER $$
CREATE TRIGGER trigger_balance_update
	AFTER UPDATE
	ON accounts
	FOR EACH ROW
BEGIN
	IF OLD.balance <> NEW.balance
		THEN  INSERT INTO logs (account_id, old_sum, new_sum)
		VALUEs (OLD.id, OLD.balance, NEW.balance);
        end if;
END$$

DELIMITER ;
CREATE TABLE notification_emails (
    id INT PRIMARY KEY AUTO_INCREMENT,
    recipient INT NOT NULL,
    subject VARCHAR(100) NOT NULL,
    body TEXT NOT NULL
);

DELIMITER $$
CREATE TRIGGER tr_notification_email_creation
AFTER INSERT
ON `logs`
FOR EACH ROW
BEGIN
	INSERT INTO notification_emails (recipient, subject, body)
    VALUES (NEW.account_id, CONCAT('Balance change for account: ', NEW.account_id), 
    CONCAT_WS(' ', 'On', 
    DATE_FORMAT(NOW(), '%b %d %y at %r'), 
    'your balance was changed from', 
    NEW.old_sum, 
    'to', 
    NEW.new_sum, '.'));
    
END$$