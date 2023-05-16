
CREATE DATABASE if not exists baloncesto;

USE baloncesto;

CREATE TABLE equipo(
	idEquipo int, nombre varchar(40), localidad varchar(20),
    pais varchar(20), nombreCorto varchar (20),
    primary key(idEquipo) );

CREATE TABLE jugador(
	idJugador int, idEquipo int, nombre varchar(30), apellidos varchar(40),
    alturaCM int, edad int, nacionalidad varchar(30),
    primary key(idJugador), foreign key(idEquipo) references equipo(idEquipo) );
    
CREATE TABLE partido(
	idPartido int, idEquipoLocal int, idEquipoVisitante int,
    puntosLocal int, puntosVisitante int,
    primary key(idPartido), foreign key(idEquipoLocal) references equipo(idEquipo),
    foreign key(idEquipoVisitante) references equipo(idEquipo) );
    
CREATE TABLE datosJugadorPartido(
	idP int, idJ int, valoracion int, puntos int, asistencias int,
    rebotes int, tapones int, titular boolean,
    primary key(idP, idJ), foreign key(idP) references partido(idPartido),
    foreign key(idJ) references jugador(idJugador) );