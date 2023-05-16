insert into alumno (dni,nombre,apellidos,edad) values ('12345683e','Pepito','Papu',35);
select * from alumno;
set autocommit= 0;
select @@autocommit;
insert into alumno (dni,nombre,apellidos,edad) values ('12345683y','Pepito','Martinez',61);
rollback work;
