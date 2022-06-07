DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
CREATE USER IF NOT EXISTS 'biblioteca'@'localhost' IDENTIFIED BY 'biblioteca2022';
GRANT ALL ON biblioteca.* TO 'biblioteca'@'localhost';

drop table if EXISTS editoriales;
CREATE TABLE editoriales(
    codigo varchar(20) NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    direccion VARCHAR(20) NOT NULL,
    PRIMARY KEY(codigo)
) ENGINE=InnoDB;

drop table if exists libros;
CREATE TABLE libros(
    isbn varchar(20) NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    autor VARCHAR(20) NOT NULL,
    precio decimal(8,2) NOT NULL,
    codigoEditorial varchar(20) NOT NULL,
    PRIMARY KEY(isbn),
    FOREIGN KEY (codigoEditorial) REFERENCES editorial(codigo)
) ENGINE=InnoDB;



/*Procedimiento insertarLibro*/
DELIMITER $$
CREATE DEFINER=biblioteca@localhost PROCEDURE 
insertarLibro(isbn varchar(20), nombre VARCHAR(20), autor varchar(20),
precio decimal(8,2), codigoEditorial INT)
BEGIN
    INSERT INTO libro
    VALUES (isbn, nombre, autor, precio, codigoEditorial);
END$$
DELIMITER ;

/*Procedimiento insertarEditorial*/
DELIMITER $$
CREATE DEFINER=biblioteca@localhost PROCEDURE 
insertarEditorial(codigo int, nombre varchar(20), direccion varchar(20))
BEGIN
    INSERT INTO editorial
    VALUES (codigo,nombre,direccion);
END$$
DELIMITER ;
