delimiter //
create trigger notaBoletin
before insert
on nota
for each row
begin
update notasBoletin
set valor= (new.valor*0.5) where new.dniAlumno=dniAlumno;
end;
//
drop trigger notaBoletin;


