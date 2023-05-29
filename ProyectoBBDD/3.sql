delimiter //
 create function empleadosDespedidos()
	returns int
    begin
    declare total int;
    set total=1;
    insert into antiguosempleados(dni,fechaBaja) select dni,fechaBaja from empleados where fechaBaja is not null;
    return total;
    end;
//
delimiter //
create procedure empleadosDespedidos ()
	begin
        insert into antiguosempleados(dni,fechaBaja) select dni,fechaBaja from empleados where fechaBaja is not null;
	end;
//
drop procedure empleadosDespedidos;
