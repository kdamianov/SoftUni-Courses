CREATE TABLE teachers (
    teacher_id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    manager_id INT,
    CONSTRAINT fk_teachers_teachers FOREIGN KEY (manager_id)
        REFERENCES teachers (teacher_id)
);

ALTER TABLE teachers AUTO_INCREMENT = 101;

INSERT INTO teachers (name)
VALUES ('John'), 
		('Maya'), 
		('Silvia'), 
		('Ted'), 
		('Mark'), 
		('Greta');
        
UPDATE teachers
SET manager_id = 106 where teacher_id = 102;
UPDATE teachers
SET manager_id = 106 where teacher_id = 103;
UPDATE teachers
SET manager_id = 105 where teacher_id = 104;
UPDATE teachers
SET manager_id = 101 where teacher_id = 105;
UPDATE teachers
SET manager_id = 101 where teacher_id = 106;




