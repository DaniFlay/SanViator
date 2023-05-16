a)create or replace view apartado_2a as
select nombre,apellidos,dni from cliente;
b)create or replace view apartado_2b as
select * from alquiler where ndias>3;
c)create or replace view apartado_2c as
select alquiler.*, nombre,apellidos from alquiler join cliente on dni=dnicliente;
d)create or replace view apartado_2d as
select count(*) as nAlquileres, cliente.* from alquiler join cliente on dni=dnicliente group by dni;
e)create or replace view apartado_2e as
select * from alquiler where year(fecha)=2020 and ndias>10 and (kmfinal-kminicio)>100;
f)create or replace view apartado_2f as
select concat(nombre,' ',apellidos)as nombreApellidos, domicilio from cliente;