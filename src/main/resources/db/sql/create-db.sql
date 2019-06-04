CREATE TABLE breed (
	id INT PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE person (
   id INT AUTO_INCREMENT PRIMARY KEY,
   first_name VARCHAR(255) NOT NULL,
   last_name VARCHAR(255) NOT NULL
   );

CREATE TABLE pet (
	id INT AUTO_INCREMENT,
	person_id INT NOT NULL,
	name VARCHAR(255) NOT NULL,
	breed_id INT NOT NULL,
	FOREIGN KEY (person_id) REFERENCES person(id),
	FOREIGN KEY (breed_id) REFERENCES breed(id),
	PRIMARY KEY (id, person_id)
);