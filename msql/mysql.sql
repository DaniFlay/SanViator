DROP DATabase if exists alquilerVehiculos;
CREATE DATABASE if not exists alquilerVehiculos;
use alquilerVehiculos;
create table if not exists Cliente(dni varchar(9), 
nombre varchar(20), apellidos varchar(50),
domicilio varchar(200), nTarjeta integer(15),
primary key(dni));
create table if not exists Oficina(codigoOficina integer,
direccion varchar(200),telefono integer, localidad varchar(30),
provincia varchar(30), primary key(codigoOficina));
create table if not exists Marca(idMarca varchar(20), pais varchar(20),
tipoMarca varchar(30), primary key(idMarca));
create table if not exists Vehiculo(idVehiculo varchar(20), idMarca varchar(20),
modelo varchar(80), tipoCombustible varchar(15), plazas integer,
primary key(idVehiculo), foreign key(idMarca) references Marca(idMarca));
create table if not exists Alquiler(idAlquiler integer, fecha date,
nDias integer, kmInicio integer, kmFinal integer, oficinaInicio integer,
oficinaFinal integer, idVehiculo varchar(20), dniCliente varchar(20),
primary key(idAlquiler), foreign key(oficinaInicio) references Oficina(codigoOficina),
foreign key(oficinaFinal) references Oficina(codigoOficina), 
foreign key(idVehiculo) references Vehiculo(idVehiculo),
foreign key(dniCliente) references Cliente(dni));