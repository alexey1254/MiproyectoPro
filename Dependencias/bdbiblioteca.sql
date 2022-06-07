DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
CREATE USER IF NOT EXISTS 'biblioteca'@'localhost' IDENTIFIED BY 'biblioteca2022';
GRANT ALL ON biblioteca.* TO 'biblioteca'@'localhost';


DROP TABLE IF EXISTS libros;
 create table libros(
  isbn int unsigned auto_increment,
  titulo varchar(40) not null,
  autor varchar(30) not null default 'Desconocido',
  codigoEditorial tinyint unsigned not null,
  cantidad smallint unsigned default 0,
  primary key (isbn)
 )ENGINE= InnoDB;

DROP TABLE IF EXISTS editoriales;
 create table editoriales(
  codigo tinyint unsigned auto_increment,
  nombre varchar(20) not null,
  direccion varchar(30) not null,
  primary key(codigo)
 )ENGINE= InnoDB;


insert into editoriales (nombre,direccion) values('Paidos','Colon 190');
insert into editoriales (nombre,direccion) values('Emece','Rivadavia 765');
insert into editoriales (nombre,direccion) values('Planeta','General Paz 245'); 
insert into editoriales (nombre,direccion) values('Sudamericana','9 de Julio 1008');

insert into libros (titulo, autor,codigoeditorial,cantidad) values
('Alicia en el pais de las maravillas','Lewis Carol',3,20),
('Harry potter y el misterio de azkaban','J.K Rowling',1,10),
('Harry Potter y el caliz de fuego', 'J.K Rowling',1,10);


/*Procedimiento insertarLibro*/
DELIMITER $$
CREATE DEFINER=biblioteca@localhost PROCEDURE 
insertarLibro(
    isbn varchar(20), 
    nombre VARCHAR(20), 
    autor varchar(20),
    precio decimal(8,2), 
    codigoEditorial INT
)
BEGIN
    INSERT INTO libros
    VALUES (isbn, nombre, autor, precio, codigoEditorial);
END$$
DELIMITER ;

/*Procedimiento insertarEditorial*/
DELIMITER $$
CREATE DEFINER=biblioteca@localhost PROCEDURE 
insertarEditorial(
    codigo int, 
    nombre varchar(20), 
    direccion varchar(20)
)
BEGIN
    INSERT INTO editoriales
    VALUES (codigo,nombre,direccion);
END$$
DELIMITER ;
