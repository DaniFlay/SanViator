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
insert into notaFinal values (new.dnialumno,new.ciclo,new.modulo,null,null);
end;
//
create trigger calculoNotaFinal
after insert
on notasBoletin
for each row 
begin
declare evaluaciones int;
declare nota int;
declare curso int;
select curso into curso from modulo where new.modulo= abreviaturamodulo and ciclo=new.ciclo;
set evaluaciones= contarEvaluaciones(new.dnialumno,new.ciclo,new.modulo);
if(evaluaciones=4) then
select valor into nota from notasboletin where new.dnialumno=dnialumno and evaluacion=4 and ciclo=new.ciclo and modulo=new.modulo;
update notafinal set valor=nota where dnialumno=new.dnialumno and ciclo=new.ciclo and modulo=new.modulo;
call valorTextual(2);
elseif(evaluaciones=3) then
select (sum(valor)/3) into nota from notasboletin where dnialumno=new.dnialumno and ciclo=new.ciclo and modulo=new.modulo;
update notafinal set valor=nota where dnialumno=new.dnialumno and ciclo=new.ciclo and modulo=new.modulo;
call valorTextual(2);
end if;
if(curso=2) then
select (sum(valor)/2) into nota from notasboletin where dnialumno=new.dnialumno and ciclo=new.ciclo and modulo=new.modulo;
update notafinal set valor=nota where dnialumno=new.dnialumno and ciclo=new.ciclo and modulo=new.modulo;
call valorTextual(2);
end if;
end;
// 




