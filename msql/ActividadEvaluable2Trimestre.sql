create database if not exists webDeAnunciosDeViviendas;
use webDeAnunciosDeViviendas;
create table if not exists inmobiliaria(
idInmobiliaria int, nombreComercial varchar(50), 
categoria varchar(50), nOficinas int, paisSede varchar(50),
primary key(idInmobiliaria));
create table if not exists persona(
dni varchar(9), nombre varchar(50), apellidos varchar(50), 
telefono varchar(9), primary key(dni));
create table if not exists infoLocalidad(
localidad varchar(200), provincia varchar(200), 
nHabitantes int, precioMedioAlquiler double, 
primary key(localidad, provincia));
create table if not exists vivienda( domicilio varchar(200), localidad varchar(50),
provincia varchar(50), cp char(5), metrosConstruidos int, metrosUtiles int, 
ascensor boolean, nHabitaciones int, nBanos int, tipoVentanas varchar(50),
tipoSuelo varchar(50), ultimaReforma date, precioMes int, plazasGaraje int, 
alquilado boolean, metrosTerraza int, trastero boolean, 
primary key(domicilio, localidad, provincia));
create table if not exists oficina( idInmobiliaria int, idOficina int, direccion varchar(200),
cp char(5), localidad varchar(200), provincia varchar(200), primary key(idInmobiliaria, idOficina),
foreign key(idInmobiliaria) references inmobiliaria (idInmobiliaria));
