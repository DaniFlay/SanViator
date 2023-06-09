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
nombreModulo varchar(200),
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
fechaMatriculacion date,
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
horas int,
foreign key (dniProfesor) references profesor (dniProfesor) 
);
create table if not exists alumnosEgresados(
dni varchar(9) primary key,
fechaPromocion date,
curso varchar(9),
foreign key (dni) references matricula(dniAlumno)
);


insert into ciclo values ('DAM', 'Desarrollo de Aplicaciones Multiplataforma');
insert into ciclo values ('PD', 'Protesis Dentales');
insert into ciclo values ('EI', 'Educación Infantil');
insert into ciclo values ('MC', 'Mediación Comunicativa');
insert into ciclo values ('IS', 'Integración Social');

insert into modulo values ('DAM','SIN','Sistemas Informáticos',1,6,'99999999Z');
insert into modulo values ('DAM','BD','Bases de Datos',1,6,'99999999Y');
insert into modulo values ('DAM','PRO','Programación',1,8,'99999999X');
insert into modulo values ('DAM','LM','Lenguajes de marcas y sistemas de gestión de información',1,4,'99999999X');
insert into modulo values ('DAM','ED','Entornos de Desarrollo',1,3,'99999999X');
insert into modulo values ('DAM','AD','Acesso a Datos',2,6,'99999999Y');
insert into modulo values ('DAM','DI','Desarrollo de Interfaces',2,6,'99999999Z');
insert into modulo values ('DAM','PM','Programación Multimedia y dispositivos móviles',2,6,'99999999Z');
insert into modulo values ('DAM','PSP','Programación de Servicios y Procesos',2,3,'99999999Y');
insert into modulo values ('DAM','SGE','Sistemas de Gestión Empresarial',2,6,'99999999Y');
insert into modulo values ('DAM','FOL','Formación y Orientación Laboral',1,3,'99999999V');
insert into modulo values ('DAM','EIE','Empresa e Iniciativa Emprendedora',2,3,'99999999V');

insert into modulo values ('PD','LPD','Laboratorio de Prótesis Dentales',1,2,'88888888Z');
insert into modulo values ('PD','DFP','Diseño Funcional de Prótesis',1,3,'88888888Z');
insert into modulo values ('PD','PC','Prótesis Completas',1,6,'88888888Y');
insert into modulo values ('PD','AOF','Aparatos de Ortodoncia y Férulas Oclusales',1,9,'88888888X');
insert into modulo values ('PD','REM','Restauraciones y Estructuras Metálicas en Protesis Fija',2,10,'88888888Z');
insert into modulo values ('PD','PPR','Prótesis Parciales Removibles metálicas, de resina y mixta',1,7,'88888888Y');
insert into modulo values ('PD','RRE','Restauraciones y Recubrimientos Estéticos',2,10,'88888888Z');
insert into modulo values ('PD','PSI','Prótesis Sobre Implantes',2,7,'88888888Z');
insert into modulo values ('PD','FOL','Formación y Orientación Laboral',1,3,'99999999V');
insert into modulo values ('PD','EIE','Empresa e Iniciativa Emprendedora',2,3,'99999999V');

insert into modulo values ('EI','DEI','Didáctica de la Educación Infantil',1,6,'77777777Z');
insert into modulo values ('EI','AUT','Autonomía Personal y Salud Infantil',1,5,'77777777Y');
insert into modulo values ('EI','EYC','Expresión y Comunicación',1,6,'77777777Y');
insert into modulo values ('EI','DCM','Desarrollo Cognitivo y de Motor',1,6,'77777777Z');
insert into modulo values ('EI','DS','Desarrollo Socioafectivo',1,4,'77777777Z');
insert into modulo values ('EI','HS','Habilidades Sociales',2,8,'77777777Y');
insert into modulo values ('EI','INT','Intervención con Familias y Atención a Menores en Riesgo Social',2,8,'77777777Y');
insert into modulo values ('EI','PAU','Primeros Auxilios',2,2,'77777777Y');
insert into modulo values ('EI','JIM','El Juego Infantil y su Metodología',2,9,'77777777Y');
insert into modulo values ('EI','FOL','Formación y Orientación Laboral',1,3,'99999999V');
insert into modulo values ('EI','EIE','Empresa e Iniciativa Emprendedora',2,3,'99999999V');

insert into modulo values ('IS','CIS','Contexto de la Intevención Social',1,5,'66666666Z');
insert into modulo values ('IS','ISL','Inserción Sociolaboral',1,6,'66666666Z');
insert into modulo values ('IS','AUC','Atención a las Unidades de Convivencia',1,6,'66666666Y');
insert into modulo values ('IS','MC','Mediación Comunitaria',2,5,'66666666Z');
insert into modulo values ('IS','AIE','Apoyo a la Intervención Educativa',2,6,'66666666Z');
insert into modulo values ('IS','PAP','Promoción de la Autonomía Personal',1,7,'66666666Z');
insert into modulo values ('IS','SDC','Sistemas Aumentativos y Alternativos de Comunicación',2,6,'66666666Z');
insert into modulo values ('IS','MIS','Metodología de la Intervención Social',1,3,'66666666Z');
insert into modulo values ('IS','PAU','Primeros Auxilios',2,2,'66666666Z');
insert into modulo values ('IS','HS','Habilidades Sociales',2,8,'66666666Z');
insert into modulo values ('IS','FOL','Formación y Orientación Laboral',1,3,'99999999V');
insert into modulo values ('IS','EIE','Empresa e Iniciativa Emprendedora',2,3,'99999999V');

insert into modulo values ('MC','MIS',' Metodología de la integración social de las personas con dificultades de comunicación, lenguaje y habla',1,3,'55555555Z');
insert into modulo values ('MC','SCP','Sensibilizaciñón Social y Participación',1,4,'55555555Z');
insert into modulo values ('MC','ISP','Intervención Socioeducativa con Personas Sordociegas',1,5,'55555555Z');
insert into modulo values ('MC','CMC','Contexto de la mediación comunicativa con personas sordociegas',1,6,'55555555Z');
insert into modulo values ('MC','LS','Lengua de Signos',1,6,'55555555Z');
insert into modulo values ('MC','AAL','Ámbitos de Aplicación de la Lengua de Signos',2,6,'55555555Z');
insert into modulo values ('MC','IPD','Intervención con Personas con Dificultad de Comunicación',1,3,'55555555Z');
insert into modulo values ('MC','TIC','Técnicas de Intervención Comunicativa',2,5,'55555555Z');
insert into modulo values ('MC','SAC','Sistemas Aumentativos y Alternativos de Comunicación',2,6,'55555555Z');
insert into modulo values ('MC','HS','Habilidades Sociales',2,8,'55555555Z');
insert into modulo values ('MC','PAU','Primeros Auxilios',2,2,'55555555Z');
insert into modulo values ('MC','FOL','Formación y Orientación Laboral',1,3,'99999999V');
insert into modulo values ('MC','EIE','Empresa e Iniciativa Emprendedora',2,3,'99999999V');