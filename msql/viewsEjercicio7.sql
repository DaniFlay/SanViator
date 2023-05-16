1:
create view listado_jugadores_1 as
select * from jugador where idEquipo=1;
create view listado_jugadores_2 as
select * from jugador where idEquipo=2;
create view listado_jugadores_3 as
select * from jugador where idEquipo=3;
create view listado_jugadores_4 as
select * from jugador where idEquipo=4;
create view listado_jugadores_5 as
select * from jugador where idEquipo=5;
create view listado_jugadores_6 as
select * from jugador where idEquipo=6;
create view listado_jugadores_7 as
select * from jugador where idEquipo=7;
create view listado_jugadores_8 as
select * from jugador where idEquipo=8;
2:
create or replace view listado_mejores_jugadores as
select idJugador, idEquipo, nombre,
apellidos,avg(valoracion)as media from jugador,
datosjugadorpartido where idJugador=idJ
group by idJugador order by media desc limit 10;
3:
create or replace view listado_espanyoles as
select * from jugador where nacionalidad='Espanola';

