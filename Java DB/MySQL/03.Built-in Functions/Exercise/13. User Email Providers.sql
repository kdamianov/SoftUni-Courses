SELECT 
    user_name,
    SUBSTRING(email, LOCATE('@', email) + 1) AS 'email provider'
FROM
    users
ORDER BY `email provider` , user_name;

SELECT 
    user_name,
    SUBSTRING_INDEX(email, '@', -1) AS `email provider` -- дава всичко до '@' отдясно наляво, тк е отрицателна стойност 
FROM
    users
ORDER BY `email provider` , user_name;

SELECT 
    user_name,
    REGEX_REPLACE(email, '.*@', '') AS `email provider`
FROM
    users
ORDER BY `email provider` , user_name;