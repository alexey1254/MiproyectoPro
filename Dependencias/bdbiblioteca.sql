DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
CREATE USER IF NOT EXISTS 'biblioteca'@'localhost' IDENTIFIED BY 'biblioteca2022';
GRANT ALL ON biblioteca.* TO 'biblioteca'@'localhost';
