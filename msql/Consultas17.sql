use alquilervehiculos;
-- Apartado a:
select nombre, apellidos from cliente order by apellidos; 
-- Apartado b:
select * from oficina order by provincia;
-- Apartado c: 
select count(*) from oficina where provincia="Palencia";
-- Apartado d:
select count(*), provincia from oficina group by provincia;
-- Apartado e: 
select avg(nDias) from alquiler;
-- Apartado f: 
select avg(nDias) from alquiler,oficina where provincia="Valladolid" and oficina.codigoOficina=alquiler.oficinaInicio;
-- Apartado g: 
select count(*) from vehiculo where tipoCombustible="diesel";
-- Apartado h:
select count(*) from vehiculo where plazas>4;
-- Apartado i: 
select distinct(modelo) from vehiculo where idMarca=1;
-- Apartado j: 
select * from alquiler where kmFinal-kmInicio=(select max(kmFinal-kmInicio) from alquiler);
-- Apartado k: 
select * from cliente where dni=(select dniCliente from alquiler where kmFinal-kmInicio=(select max(kmFinal-kmInicio) from alquiler));
-- Apartado l:
select count(*), nDias from alquiler group by nDias;
-- Apartado m: 
select count(*),pais from marca group by pais;
-- Apartado n: 
select count(*),localidad from oficina where provincia="Palencia" group by localidad; 
-- Apartado o: 
select * from vehiculo where idVehiculo=(select idVehiculo from(select sum(nDias)as suma,idVehiculo from alquiler group by idVehiculo order by suma desc limit 1)as tabla);
-- Apartado p:
select * from vehiculo where idVehiculo=(select idVehiculo from(select sum(kmFinal)-sum(kmInicio) as recorrido, idVehiculo from alquiler group by idVehiculo order by recorrido desc limit 1)as tabla);
-- Apartado q:
select * from oficina where codigoOficina=(select oficinaInicio from(select count(*) as count, oficinaInicio from alquiler group by oficinaInicio order by count desc limit 1)as tabla);
-- Apartado r:
select * from oficina where codigoOficina=(select oficinaFinal from(select count(*) as count, oficinaFinal from alquiler group by oficinaFinal order by count desc limit 1)as tabla);
-- Apartado s: 
(select * from vehiculo where idVehiculo=(select idVehiculo from(select sum(nDias) suma, idVehiculo from alquiler group by idVehiculo order by suma desc limit 1)as tabla));