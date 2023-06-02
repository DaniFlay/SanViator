delimiter //
create trigger horasProfesor
after insert
on profesor
for each row
begin
insert into horasprofesor values(new.dniprofesor, null);
end;
//

create function calcularHoras(dni varchar(9))
returns int
begin 
declare horas int;
select sum(horasSemana) into horas from modulo where dniProfesor=dni;
return horas;
end;
//

create trigger insercionModulo
before insert 
on modulo
for each row 
begin
declare horas int;
set horas= calcularHoras(new.dniProfesor);
if(horas+new.horasSemana>25) then
set new.dniprofesor= null;
end if;
end;
//

create function faltas(dni varchar(9), ciclo varchar(3),modulo varchar(3),evaluacion int)
returns int
begin 
declare total int;
select count(*) into total from faltas where faltas.dni=dni and faltas.ciclo=ciclo and faltas.modulo=modulo and faltas.evaluacion=evaluacion;
return total;
end;
//

create procedure valorTextual(num int)
begin 
if(num=1) then
update notasboletin set valortextual ='INSUFICIENTE' where valor<5;
update notasboletin set valortextual ='SUFICIENTE' where valor=5 or valor=6;
update notasboletin set valortextual ='NOTABLE' where valor=7 or valor=8;
update notasboletin set valortextual ='SOBRESALIENTE' where valor=9;
update notasboletin set valortextual ='MATRICULA DE HONOR' where valor=10;
else 
update notafinal set valortextual ='INSUFICIENTE' where valor<5;
update notafinal set valortextual ='SUFICIENTE' where valor=5 or valor=6;
update notafinal set valortextual ='NOTABLE' where valor=7 or valor=8;
update notafinal set valortextual ='SOBRESALIENTE' where valor=9;
update notafinal set valortextual ='MATRICULA DE HONOR' where valor=10;
end if;
end;
//

create trigger notaBoletin
after insert
on nota
for each row
begin
declare nota int;
declare faltas int;
set faltas= faltas(new.dniAlumno, new.ciclo,new.modulo,new.evaluacion);
if(faltas<10) then
set nota=(select sum(0.5*valor)/count(valor) from nota where new.dniAlumno=dniAlumno and tiponota='examen' and new.modulo=modulo and new.ciclo=ciclo and new.evaluacion=evaluacion) + (select sum(valor*0.5)/count(valor) from nota where dnialumno=new.dniAlumno and tiponota='practica' and new.modulo=modulo and new.ciclo=ciclo and new.evaluacion=evaluacion);
update notasBoletin
set valor= nota where new.dniAlumno=dniAlumno and new.modulo=modulo and new.ciclo=ciclo and new.evaluacion=evaluacion;
call valorTextual(1);
else
set nota=(select sum(valor)/count(valor) from nota where new.dniAlumno=dniAlumno and tiponota='examen' and new.modulo=modulo and new.ciclo=ciclo and new.evaluacion=evaluacion);
update notasBoletin
set valor= nota where new.dniAlumno=dniAlumno and new.modulo=modulo and new.ciclo=ciclo and new.evaluacion=evaluacion;
call valorTextual(1);
end if;
if(new.evaluacion=4) then
insert into notasboletin
values (new.dnialumno,new.ciclo,new.modulo,new.valor,new.evaluacion,null);
call valortextual(1);
end if;
end;
//

create trigger notaBoletin2
before update 
on faltas
for each row
begin
declare nota int;
declare faltas int;
set faltas=faltas(new.dni,new.ciclo,new.modulo,new.evaluacion);
if(faltas+new.numfaltas>10) then
set nota=(select sum(valor)/count(valor) from nota where new.dni=dniAlumno and tiponota='examen' and new.modulo=modulo and new.ciclo=ciclo and new.evaluacion=evaluacion);
update notasboletin
set valor= nota where new.dni=dniAlumno and new.modulo=modulo and new.ciclo=ciclo and new.evaluacion=evaluacion;
call valortextual(1);
end if;
end;
//

create function contarEvaluaciones(dni varchar(9),ciclo varchar(3),modulo varchar(3))
returns int
begin
declare evaluaciones int;
select count(*) into evaluaciones from notasboletin where dnialumno=dni and notasboletin.modulo=modulo and notasboletin.ciclo=ciclo;
return evaluaciones;
end;
//

create trigger notaFinal
before insert 
on matricula
for each row 
begin
if(new.modulo!='PFG' and new.modulo!='PE') then
insert into notaFinal values (new.dnialumno,new.ciclo,new.modulo,null,null);
end if;
end;
//

create trigger insertarNotaFinal
after insert
on notasBoletin
for each row 
begin
declare evaluaciones int;
declare nota int;
set evaluaciones= contarEvaluaciones(new.dnialumno,new.ciclo,new.modulo);
if(evaluaciones=4) then
select valor into nota from notasboletin where new.dnialumno=dnialumno and evaluacion=4 and ciclo=new.ciclo and modulo=new.modulo;
update notafinal set valor=nota where dnialumno=new.dnialumno and ciclo=new.ciclo and modulo=new.modulo;
call valorTextual(2);
elseif(evaluaciones=3) then
update notafinal set valor=(select avg(valor) from notasboletin where dnialumno=new.dnialumno and ciclo=new.ciclo and modulo=new.modulo) where dnialumno=new.dnialumno and ciclo=new.ciclo and modulo=new.modulo;
call valorTextual(2);
else
update notafinal set valor=(select avg(valor) from notasboletin where dnialumno=new.dnialumno and ciclo=new.ciclo and modulo=new.modulo) where dnialumno=new.dnialumno and ciclo=new.ciclo and modulo=new.modulo;
call generarProyectoPracticas(new.dnialumno, new.ciclo);
call valorTextual(2);
end if;
call alumnosEgresados(new.dnialumno);
end;
// 

create procedure generarProyectoPracticas(dni varchar(9),ciclo varchar(3))
begin
declare asignaturas int;
declare aprobados int;
declare notaProyecto int;
declare notaPractica int;
set notaProyecto=floor(rand()*11);
set notaPractica=floor(rand()*11);
select count(*) into asignaturas from notafinal where dnialumno=dni;
select count(*) into aprobados from notafinal where dnialumno=dni and valor>=5;
if(asignaturas=aprobados) then
insert into notasboletin values (dni,modulo,'PFG',notaProyecto,3,null);
insert into notasboletin values (dni,modulo,'PE',notaPractica,3,null);
call valorTextual(1);
if(notaProyecto>5) then
insert into notafinal values (dni,modulo,'PFG',notaProyecto,null);
call valorTextual(2);
else 
set notaProyecto=floor(rand()*11);
insert into notasboletin values (dni,modulo,'PFG',notaProyecto,4,null);
insert into notafinal values (dni,modulo,'PFG',notaProyecto,null);
call valorTextual(1);
call valorTextual(2);
end if;
if(notaPractica>5) then
insert into notafinal values (dni,modulo,'PE',notaProyecto,null);
call valorTextual(2);
else
insert into notasboletin values (dni,modulo,'PE',notaProyecto,4,null);
insert into notasboletin values (dni,modulo,'PE',notaPractica,null);
call valorTextual(1);
call valorTextual(2);
end if;
end if;
end;
//

create procedure alumnosEgresados(dni varchar(9))
begin
declare aprobados int;
declare fecha year;
select count(*) into aprobados from notafinal where dnialumno=dni and modulo='PE' and valor>=5 or dnialumno=dni and modulo='PFG' and valor>=5;
if(aprobados=2) then
select count(*) into aprobados from notasboletin where dnialumno=dni and modulo='PE' and evaluacion=4 and valor>=5 or dnialumno=dni and modulo='PFG' and evaluacion=4 and valor>=5;
select year(fechamatriculacion) into fecha from matricula where dnialumno=dni limit 1;
if(aprobados=0) then
insert into alumnosegresados values (dni,concat(fecha,'-08-31'),concat(fecha,'/',fecha+1));
else
insert into alumnosegresados values (dni,concat(fecha,'-09-01'),concat(fecha+1,'/',fecha+2));
end if;
end if;
end;
//

