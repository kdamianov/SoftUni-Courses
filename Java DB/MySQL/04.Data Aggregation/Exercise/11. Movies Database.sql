CREATE TABLE directors (
    id INT AUTO_INCREMENT,
    director_name VARCHAR(50) NOT NULL,
    notes TEXT,
    PRIMARY KEY (id)
);
CREATE TABLE genres (
    id INT AUTO_INCREMENT,
    genre_name VARCHAR(50) NOT NULL,
    notes TEXT,
    PRIMARY KEY (id)
);
CREATE TABLE categories (
    id INT AUTO_INCREMENT,
    category_name VARCHAR(50) NOT NULL,
    notes TEXT,
    PRIMARY KEY (id)
);
CREATE TABLE movies (
    id INT AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    director_id INT,
    copyright_year INT,
    length INT,
    genre_id INT,
    category_id INT,
    rating DOUBLE,
    notes TEXT,
    PRIMARY KEY (id)
);

INSERT INTO directors (director_name) VALUES
('test1'),
('test2'),
('test3'),
('test4'),
('test5');

INSERT INTO genres (genre_name) VALUES
('test1'),
('test2'),
('test3'),
('test4'),
('test5');

INSERT INTO categories (category_name) VALUES
('test1'),
('test2'),
('test3'),
('test4'),
('test5');

INSERT INTO movies (title) VALUES
('test1'),
('test2'),
('test3'),
('test4'),
('test5');








       
