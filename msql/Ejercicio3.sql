a)select alquiler.*,idmarca from alquiler natural join vehiculo order by idmarca;
b)select * from alquiler natural join vehiculo join cliente on dni=dnicliente;
c)select * from cliente left outer join alquiler on dni=dnicliente;
d)select alquiler.*,t1 as telefonoOficinaInciio,t2 as telefonoOficinaFinal from alquiler join (select telefono as t1, codigooficina as cInicio from oficina where codigooficina in(select oficinainicio from alquiler)) as tabla1 on tabla1.cInicio=oficinainicio join (select telefono as t2, codigooficina as cFinal from oficina where codigooficina in(select oficinafinal from alquiler))as tabla2 on tabla2.cFinal=oficinafinal;
e)select * from marca natural join vehiculo;
select vehiculo.*,valoracionusuarios,pais,tipomarca from marca join vehiculo on vehiculo.idmarca=marca.idmarca;