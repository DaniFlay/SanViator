delimiter //
create trigger nuevoJugador before insert on jugador
for each row
begin
	if new.edad is null then 
    set new.edad =18;
    end if;
end;
//

create trigger nuevoJugadorV2 after insert on jugador
for each row 
begin
	if new.edad is null then 
    update jugador
    set edad=19 where idJugador = new.idJugador and idEquipo = new.idEquipo;
    end if;
end;
//
