DROP DATABASE IF EXISTS book;

CREATE DATABASE book;

USE book;

CREATE TABLE `user` (
	`id` int AUTO_INCREMENT PRIMARY KEY,
	`username` varchar(20) NOT NULL UNIQUE,
	`password` varchar(32) NOT NULL,
	`email` varchar(100)
);

INSERT INTO `user`(`username`,`password`,`email`) VALUES ('admin','admin','admin@itutry.com');


SELECT * FROM `user`;
