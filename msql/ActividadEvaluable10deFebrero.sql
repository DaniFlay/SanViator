-- Apartado a: 
select * from jugador where alturaCM between 200 and 210;
-- Apartado b:
select count(*),idEquipo from jugador group by idEquipo;
-- apartado c:
select count(*), localidad from equipo group by localidad;
-- apartado d:
select * from jugador where idEquipo in (select idEquipo from equipo where localidad="Valladolid");
-- apartado e:
select avg(valoracion) as media ,idJ from datosjugadorpartido group by idJ having media>100;
-- apartado f:
select * from partido where puntosLocal=(select max(puntosLocal) from partido);
-- apartado g:
select * from partido where (puntosLocal-puntosVisitante) =(select max(puntosLocal-puntosVisitante) from partido);
-- apartado h:
select * from jugador order by edad desc;
-- apartado i: 
select * from jugador order by alturaCM desc limit 5;
-- apartado j:
select * from equipo where nombre like "%S.A.D.";