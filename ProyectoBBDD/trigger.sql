delimiter //
create trigger notaBoletin
before insert
on nota
for each row
begin
declare examen decimal;
declare practica decimal;
declare dni varchar(9);
select (valor)*0.5 into examen from nota where nota.dniAlumno= new.dniAlumno and tipoNota='examen' ;
select (valor)*0.5 into practica from nota where nota.dniAlumno=new.dniAlumno and tipoNota='practica';
select dniAlumno into dni from nota where dniAlumno=new.dniAlumno;
update notaFinal
set valor= round(examen+practica) where dniAlumno=dni;
end;
//