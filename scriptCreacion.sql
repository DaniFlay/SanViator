drop database colegiosanviator;
create database if not exists colegioSanViator;
use colegioSanViator;
create table if not exists ciclo(
abreviaturaCiclo varchar(3) primary key,
nombreCiclo varchar(50));
create table if not exists profesor(
dniProfesor varchar(9) primary key,
nombreProfesor varchar(40),
apellidosProfesor varchar(70)
);
create table if not exists alumno(
dniAlumno varchar(9) primary key,
nombreAlumno varchar(40),
apellidosAlumno varchar(70),
edadAlumno int
);
create table if not exists modulo(
ciclo varchar(3),
abreviaturaModulo varchar(3),
nombreModulo varchar(50),
curso int,
horasSemana int,
dniProfesor varchar(9),
primary key(ciclo,abreviaturaModulo,curso),
foreign key(ciclo) references ciclo(abreviaturaCiclo),
foreign key(dniProfesor) references profesor(dniProfesor)
);
create table if not exists matricula(
dniAlumno varchar(9) ,
ciclo varchar(3) ,
modulo varchar(3) ,
curso int,
primary key(dniAlumno, ciclo,modulo,curso),
foreign key (dniAlumno) references alumno (dniAlumno),
foreign key (ciclo,modulo,curso) references modulo (ciclo,abreviaturaModulo,curso)
);
create table if not exists nota(
dniAlumno varchar(9) ,
ciclo varchar(3), 
modulo varchar(3) ,
valor double, 
curso int,
evaluacion int ,
tipoNota varchar(20) ,
valorTextual varchar(30),
primary key(dniAlumno,ciclo,modulo,evaluacion,tipoNota),
foreign key (dniAlumno) references alumno(dniAlumno),
foreign key (ciclo,modulo,curso) references modulo (ciclo,abreviaturaModulo,curso)
);
create table if not exists notasBoletin(
dniAlumno varchar(9) ,
ciclo varchar(3) ,
modulo varchar(3) ,
valor int,
evaluacion int,
valorTextual varchar(30),
primary key(dniAlumno,ciclo,modulo,evaluacion),
foreign key(dniAlumno) references alumno (dniAlumno),
foreign key (ciclo,modulo) references modulo (ciclo,abreviaturaModulo));
create table if not exists notaFinal(
dniAlumno varchar(9) ,
ciclo varchar(3) ,
modulo varchar(3) ,
valor int, 
valorTextual varchar (30),
primary key(dniAlumno,ciclo,modulo),
foreign key (dniAlumno) references alumno(dniAlumno),
foreign key (ciclo,modulo) references modulo (ciclo,abreviaturaModulo));
create table if not exists horasProfesor(
dniProfesor varchar(9) primary key,
horas int
);
