-- SET SQL_SAFE_UPDATES = 0; -> Ако изпише грешка при ъпдейт!
UPDATE products 
SET 
    quantity_in_stock = quantity_in_stock - 5
WHERE
    quantity_in_stock BETWEEN 60 AND 70;

