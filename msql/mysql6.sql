-- Apartado a:
select nombre, apellidos from jugador where nacionalidad = "Francia";
-- Aparatdo b: 
select * from partido where puntosLocal=puntosVisitante;
-- Apartado c:
select idEquipo, localidad from equipo;
-- Apartado d:
select * from partido where idEquipoLocal in (select idEquipo from equipo where pais="Espana");
-- Apartado e:
select * from jugador order by edad;
-- Apartado f:
select count(*),nacionalidad from jugador group by nacionalidad; 
-- Apartado g:
select * from jugador order by idEquipo, apellidos, nombre;
-- Apartado h:
select count(*), idEquipo from jugador group by idEquipo;
-- Apartado i:
select avg(valoracion), idJ from datosjugadorpartido group by idJ;
-- Apartado j: 
select * from jugador where idJugador=(select idJ from (select avg(valoracion)as average,idJ from datosjugadorpartido group by idJ order by average desc limit 1)as tabla);
-- Aparatdo k:
select * from jugador where idJugador=(select idJ from(select avg(puntos) as average, idJ from datosjugadorpartido group by idJ order by average desc limit 1)as tabla);
-- Apartado l: 
select * from jugador where idJugador=(select idJ from(select count(*) as count, idJ as idJ from datosjugadorpartido where titular=1  group by idJ order by count desc limit 1)as tabla);
-- Apartado m:
select * from jugador where idJugador=(select idJ from(select count(*) as count, idJ from datosjugadorpartido where titular=1 group by idJ order by count asc limit 1)as tabla);
-- Apartado n:
(select * from jugador where idJugador=(select idJ from((select average,idJ,count from(select count(*) count,idJ,avg(valoracion) as average from (select * from datosjugadorpartido where titular=1)as tabla group by idJ) as tabla where count>4) order by average desc limit 1) as tabla));


