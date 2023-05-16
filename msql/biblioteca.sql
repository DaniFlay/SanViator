CREATE TABLE if not exists autor(idAutor int, nombre varchar(20), apellidos varchar(30),
nacionalidad varchar(15), pseudonimo boolean, primary key(idAutor));
CREATE TABLE if not exists socio (dni varchar(9), nombre varchar(20), apellidos varchar(30), 
telefono varchar(9), edad int, sancionado date, primary key(dni));
CREATE TABLE IF NOT exists editorial(idEditorial int, nombreComercial varchar(20),
pais varchar(20), anyoFundacion int, primary key(idEditorial));
CREATE TABLE IF NOT exists autorReal( idAutor int, nombreReal varchar(20), apellidosReal varchar(30),
primary key(idAutor), foreign key(idAutor) references autori(idAutor));