ALTER TABLE users
DROP PRIMARY KEY,
MODIFY COLUMN username varchar(30) UNIQUE not null,
ADD CONSTRAINT pk_users
    PRIMARY KEY(id);





       
