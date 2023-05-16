drop database if exists baloncesto2023;

create database baloncesto2023;

use baloncesto2023;

create table equipo(
    idEquipo int,
    nombre char(40),
    localidad char(40),
    pais char(40),
    nombreCorto char(20) unique,
    primary key (idEquipo)
);

create table jugador(
    idJugador int,
    idEquipo int,
    nombre char(40),
    apellidos char(40),
    alturaCM int,
    edad int,
    nacionalidad char(50),
    primary key (idJugador),
    foreign key (idEquipo) references equipo(idEquipo)
);



create table partido(
    idPartido int,
    idEquipoLocal int,
    idEquipoVisitante int,
    puntosLocal int,
    puntosVisitante int,
    primary key (idPartido),
    foreign key (idEquipoLocal) references equipo(idEquipo),
    foreign key (idEquipoVisitante) references equipo(idEquipo)
);

create table datosJugadorPartido(
    idJ int,
    idP int,
    valoracion double,
    puntos int,
    asistencias int,
    rebotes int,
    tapones int,
    titular boolean,
    primary key (idJ,idP),
    foreign key (idJ) references jugador(idJugador),
    foreign key (idP) references partido(idPartido)
);