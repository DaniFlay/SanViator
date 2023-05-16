DROP database if exists vuelos;
create database if not exists vuelos;
use vuelos;
CREATE TABLE if not exists aeropuerto( nombre varchar(50), abreviatura varchar(5),
pais varchar(55), ciudad varchar(55), terminales int, capacidadViajeros int, hangares int,
primary key(abreviatura));
CREATE TABLE if not exists avion( matricula varchar(6), marca varchar(80), modelo varchar(80), numeroTripulantesMinimo int,
numeroTripulantesMaximo int, capacidadViajeros int, capacidadBodegalquilera int, 
primary key(matricula));
CREATE TABLE if not exists persona( dni varchar(9), nombre varchar(50), apellidos varchar(90),
telefono varchar(9), edad int, primary key(dni));
CREATE TABLE if not exists pasajero( dni varchar(9), socio boolean, asistencia boolean, puntosViajero int, 
primary key(dni), foreign key(dni) references persona(dni));
CREATE TABLE if not exists tripulante(dni varchar(9), categoriaProfesional varchar(150), tipoContrato varchar(150),
primary key(dni), foreign key(dni) references persona(dni));
CREATE TABLE if not exists vuelo(avion varchar(6), 
origen varchar(5), destino varchar(5), fechaPrevistaSalida date, 
horaPrevistaSalida time, fechaRealSalida date, 
horaRealSalida time, pasajeros int, tripulantes int, 
cargaBodega int, primary key(avion, origen, destino, fechaPrevistaSalida, horaPrevistaSalida),
foreign key(origen) references aeropuerto(abreviatura),
foreign key(destino) references aeropuerto(abreviatura), 
foreign key(avion) references avion(matricula));
CREATE TABLE if not exists billete( dniAsociado varchar(9), avion varchar(6), origen varchar(5), destino varchar(5),
fechaPrevistaSalida date, horaPrevistaSalida time, fila int, asiento char(1), precioOriginal double, 
descuento double, precioFinal double, primary key(dniAsociado, avion, origen, destino, fechaPrevistaSalida, horaPrevistaSalida),
foreign key(dniAsociado) references pasajero(dni), foreign key(avion, origen, destino, fechaPrevistaSalida, horaPrevistaSalida) references
vuelo(avion, origen, destino, fechaPrevistaSalida, horaPrevistaSalida));
