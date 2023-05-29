delimiter //
create trigger empleadosDespedidos
after update on empleados
for each row
begin 
	if new.fechaBaja is not null then
		insert into antiguosEmpleados values (old.dni,new.fechaBaja);
	end if;
end;
//
