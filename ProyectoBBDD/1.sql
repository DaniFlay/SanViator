create database if not exists empleadosTriggers;
use empleadosTriggers;
create table if not exists empleados(
	dni varchar(9) primary key,
    nombre varchar(50),
    fechaAlta date,
    fechaBaja date);
create table if not exists antiguosEmpleados(
	dni varchar(9) primary key,
    fechaBaja date);
    
insert into empleados (dni,nombre,fechaAlta,fechaBaja)values 
('12345678A','Juan','2020-01-01',null),
('22222222B','Pepe','2021-01-01',null),
('33333333C','Alba','2022-01-01',null);

update empleados set fechaBaja ='2023-01-01' where  dni='12345678A';
delete from antiguosempleados where dni='12345678A';
select * from antiguosempleados;
select empleadosDespedidos();