use baloncesto2023;
-- Apartado a:
select nombre, apellidos from jugador where nacionalidad="Peruana";
-- Apartado b: 
select max(valoracion) from datosjugadorpartido;
-- Apartado c:
select * from jugador where idJugador in (select idJ from datosjugadorpartido where valoracion=(select max(valoracion) from datosjugadorpartido));
-- Apartado d:
select count(*),nacionalidad from jugador group by nacionalidad;
-- Apartado e:
select * from jugador where idEquipo=1 order by edad, alturaCM;
-- Apartado f:
select avg(edad) from jugador where idEquipo=2;
-- Apartado g:
select * from jugador where edad>(select avg(edad) from jugador where idEquipo=7) and idEquipo=7;
-- Apartado h:
select * from partido where puntosLocal-puntosVisitante>10;
-- Apartado i: 
select * from partido where puntosLocal-puntosVisitante>10 or puntosVisitante-puntosLocal>10;
-- Apartado j:
select * from datosjugadorpartido where idP in (select idPartido from partido where idEquipoLocal=1 or idEquipoVisitante=1) and idJ=1 and titular=true;
-- Apartado k:
select avg(valoracion) from datosjugadorpartido where idP in(select idPartido from partido where idEquipoLocal=1 or idEquipoVisitante=1) and idJ=1;