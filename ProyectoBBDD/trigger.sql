delimiter //
create function faltas(dni varchar(9), ciclo varchar(3),modulo varchar(3),evaluacion int)
returns int
begin 
declare total int;
select count(*) into total from faltas where faltas.dni=dni and faltas.ciclo=ciclo and faltas.modulo=modulo and faltas.evaluacion=evaluacion;
return total;
end;
//
create procedure valorTextual()
begin 
update notasboletin set valortextual ='INSUFICIENTE' where valor<5;
update notasboletin set valortextual ='SUFICIENTE' where valor=5 or valor=6;
update notasboletin set valortextual ='NOTABLE' where valor=7 or valor=8;
update notasboletin set valortextual ='SOBRESALIENTE' where valor=9;
update notasboletin set valortextual ='MATRICULA DE HONOR' where valor=10;
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
call valorTextual();
else
set nota=(select sum(valor)/count(valor) from nota where new.dniAlumno=dniAlumno and tiponota='examen' and new.modulo=modulo and new.ciclo=ciclo and new.evaluacion=evaluacion);
update notasBoletin
set valor= nota where new.dniAlumno=dniAlumno and new.modulo=modulo and new.ciclo=ciclo and new.evaluacion=evaluacion;
call valorTextual();
end if;
end;
//





