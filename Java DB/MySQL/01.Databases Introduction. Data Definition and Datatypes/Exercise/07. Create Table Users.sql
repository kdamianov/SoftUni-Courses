use minions;

CREATE TABLE users (
    id INT AUTO_INCREMENT,
    username VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(26) NOT NULL,
    profile_picture BLOB,
    last_login_time TIME,
    is_deleted BOOLEAN,
    PRIMARY KEY (id)
);

INSERT INTO users (username, password) VALUES 
('user1', 'test'),
('user2', 'test'),
('user3', 'test'),
('user4', 'test'),
('user5', 'test');

select * from users;


       
