a)insert into cliente (dni,nombre,apellidos,domicilio,nTarjeta) values ('12345678P','Poliedro','Sanchez Sanchez','Calle de los Politicos n5',85741);
insert into cliente (dni,nombre,apellidos,domicilio,nTarjeta) values ('12345678V','Mariano','Cajoy Cajoy','Calle de los Politicos n23',74123);
b)insert into marca (idMarca,pais,tipoMarca) values (105,'Narnia','nacional'),(102,'Brasil','regional');
c)update cliente set domicilio='Calle Narnia n2' where dni='12345678P';
d)delete marca from marca where idMarca=102;
e)update cliente set apellidos='Rueda Cuadrado' where nombre='Miguel';
f)alter table marca add valoracionUsuarios int after idMarca;
g)alter table cliente modify apellidos varchar(200);
h)drop table alquiler;
