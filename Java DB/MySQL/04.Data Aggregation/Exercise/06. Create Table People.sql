use minions;
CREATE TABLE people (
    id INT AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    picture MEDIUMBLOB,
    height FLOAT,
    weight FLOAT,
    gender CHAR(1) NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT,
    PRIMARY KEY (id)
);

INSERT INTO people (name, gender, birthdate) VALUES 
("Ivan Draganov", "m", "1982-01-02"),
("Gatzo Batzov", "m", "1982-01-03"),
("Vesko Sifonya", "m", "1982-01-04"),
("Ceko Sirenyeto", "m", "1982-01-05"),
("Ceco Kroyfa", "m", "1982-01-05");

select * from people;



