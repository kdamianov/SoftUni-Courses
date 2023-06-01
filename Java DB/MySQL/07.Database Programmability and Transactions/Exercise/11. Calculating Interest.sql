DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(account_id int, interest_rate DECIMAL(19, 4))
BEGIN
	select a.id as 'account_id',
		ah.first_name,
		ah.last_name,
        a.balance as 'current_balance',
        ufn_calculate_future_value(a.balance, interest_rate, 5) as 'balance_in_5_years'
    from accounts as a
    left join account_holders as ah on a.account_holder_id = ah.id
    where a.id = account_id;
END$$

call usp_calculate_future_value_for_account(1, 0.1);