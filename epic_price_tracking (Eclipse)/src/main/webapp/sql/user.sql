CREATE DATABASE bookstore;


use  bookstore;

Create TABLE tb_user(
    id INT AUTO_INCREMENT,
    username VARCHAR(15) NOT NULL,
    password VARCHAR(215) NOT NULL,
	email VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

Create TABLE tb_game(
	id INT AUTO_INCREMENT,
	name VARCHAR(15) NOT NULL,
	thumbnail VARCHAR(512),
	price FLOAT,
	PRIMARY KEY (id)
);
	