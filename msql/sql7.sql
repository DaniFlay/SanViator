create database colegioFP;

use colegioFP;

create table ciclo(
	nombreCiclo varchar(50),
	numeroCursos int,
    abreviatura varchar(3),
    primary key (nombreCiclo)
);

create table alumno(
	dni varchar(9),
    nombre varchar(50),
    apellidos varchar(50),
    edad int,
    telefono varchar(9),
    primary key (dni)
);

create table profesor(
	dni varchar(9),
    nombre varchar(50),
    apellidos varchar(50),
    especialidad varchar(50),
    primary key (dni)
);

create table matricula(
	dni varchar(9),
    nombreCiclo varchar(50),
    curso int,
    anyo int,
    primary key (dni, nombreciclo, curso, anyo),
    foreign key (dni) references alumno(dni),
    foreign key (nombreCiclo) references ciclo(nombreCiclo)
);

create table modulo(
	nombreCiclo varchar(50),
    nombreModulo varchar(50),
    dniProfesor varchar(9),
    primary key (nombreCiclo, nombreModulo, dniProfesor),
    foreign key (nombreCiclo) references ciclo(nombreCiclo),
    foreign key (dniProfesor) references profesor(dni)
);

create table nota(
	dni varchar(9),
    nombreCiclo varchar(50),
    nombreModulo varchar(50),
    evaluacion int,
    anyo int,
    valorNota double,
    primary key (dni, nombreCiclo, nombreModulo, evaluacion, anyo),
	foreign key (dni) references alumno(dni),
    foreign key (nombreCiclo,nombreModulo) references modulo(nombreCiclo,nombreModulo)
);
