use vuelos;
Apartado a: 
SELECT * from aeropuerto;
Apartado b:
SELECT avion, origen, destino from vuelo;
Apartado c: 
SELECT * from tripulante where tipoContrato="por horas";
Apartado d: 
select count(*) from tripulante where tipocontrato="indefinido";
 Apartado e:
select count(*) from tripulante where tipocontrato="temporal";
Apartado f: 
select count(*) from tripulante where tipocontrato="por horas";
Apartado g: 
select avg(all precioFinal) from billete;
Apartado h:
select * from vuelo where pasajeros= (select max(pasajeros) from vuelo);
 Apartado i:
 select max(capacidadViajeros) from avion; 
 Apartado j:
 select min(capacidadViajeros) from avion; 
 Apartado k: 
 select max(capacidadBodega) from avion; 
Apartado l:
 select min(capacidadBodega) from avion; 
Apartado m: 
select * from aeropuerto order by pais asc;
Apartado n: 
 select * from billete order by origen, destino;
 Apartado o: 
select * from pasajero where socio=true;
Apartado p: 
 select * from tripulante where categoriaProfesional="piloto" or categoriaProfesional="copiloto";
Apartado q: 
select * from vuelo where origen="MADR" and destino="VALL";
Apartado r:
 select * from vuelo where origen="MADR" and destino="VALL" or origen="VALL" and destino="MADR"; 
 Apartado s: 
 select * from vuelo where fechaPrevistaSalida=fechaRealSalida and horaPrevistaSalida=horaRealSalida;
 Apartado t:
 select * from vuelo where horaPrevistaSalida<>horaRealSalida;
 Apartado u:
select * from vuelo where fechaPrevistaSalida<>fechaRealSalida;
 Apartado v: 
 select * from vuelo where pasajeros>200;
 Apartado w: 
 select * from pasajero where puntosViajero>500;
 Apartado x:
 select * from billete where descuento = (select max(descuento) from billete);
Apartado y:
select * from billete where precioOriginal-precioFinal>100;
Apartado z: 
select * from avion where capacidadBodega>capacidadViajeros;