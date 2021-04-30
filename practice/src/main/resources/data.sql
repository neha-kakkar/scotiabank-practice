DROP TABLE IF EXISTS MY_TASK;

CREATE TABLE MY_TASK (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  description VARCHAR(250) NOT NULL,
  priority LONG DEFAULT NULL
);

INSERT INTO MY_TASK (id, description, priority) VALUES
  ('1', 'Hello Neha', '1'),
  ('2', 'Hello Sushant', '2'),
  ('3', 'Hello Avni', '3');
