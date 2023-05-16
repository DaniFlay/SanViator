insert into ciclo (nombreCiclo, numeroCursos, abreviatura) values
('Desarrollo de aplicaciones multiplataforma',2,'DAM'),
('Educacion infantil',2,'EI'),
('Prótesis dentales',2,'PD');
insert into alumno (dni, nombre,apellidos, edad,telefono ) values
('12345678G','Miguel','Rojo',22,'111111111'),
('12345678D','Miguel','Rojo',22,'111111111'),
('12345678F','Miguel','Rojo',22,'111111111');
insert into profesor (dni, nombre,apellidos, especialidad ) values
('12345678B','Miguel','Rojo','Informática'),
('12345678A','Pepe','Rodríguez','Dentaduras'),
('12345678C','Josefina','Roldan','Alimentación Infantil');
insert into matricula (dni, nombreCiclo,curso, anyo ) values
('12345678G','Desarrollo de aplicaciones multiplataforma',1,2020),
('12345678D','Educacion infantil',1,2021),
('12345678F','Prótesis dentales',2,2022);
insert into modulo (nombreCiclo,nombreModulo, dniProfesor ) values
('Desarrollo de aplicaciones multiplataforma','Bases de datos','12345678B'),
('Educacion infantil','Juego','12345678C'),
('Prótesis dentales','Moldes','12345678A');
insert into nota(dni, nombreCiclo,nombreModulo,evaluacion, anyo, valorNota ) values
('12345678G','Desarrollo de aplicaciones multiplataforma','Bases de datos',1,2020,6.5),
('12345678G','Desarrollo de aplicaciones multiplataforma','Bases de datos',2,2020,8.0),
('12345678G','Desarrollo de aplicaciones multiplataforma','Bases de datos',3,2020,9.5),
('12345678D','Educacion infantil','Juego',1,2021,7.0),
('12345678D','Educacion infantil','Juego',2,2021,7.5),
('12345678D','Educacion infantil','Juego',3,2021,4.0),
('12345678F','Prótesis dentales','Moldes',1,2022,10.0),
('12345678F','Prótesis dentales','Moldes',2,2022,10.0),
('12345678F','Prótesis dentales','Moldes',3,2022,10.0);