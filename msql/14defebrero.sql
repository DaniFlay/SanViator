-- apartado a: 
select codigo_oficina, ciudad from oficina;
-- apartado b: 
select count(*) from empleado;
-- apartado c:
select count(*), pais from cliente group by pais;
-- apartado d:
select avg(total) from pago where year(fecha_pago)="2006";
-- apartado e:
select count(*), estado from pedido group by estado order by count(*) ;
-- apartado f:
select max(precio_venta) as precioMaximo, min(precio_venta) as precioMinimo from producto;
-- apartado g: 
select nombre_cliente from cliente where limite_credito=(select max(limite_credito) from cliente);
-- apartado h: 
select nombre, apellido1, puesto from empleado where codigo_empleado not in(select codigo_empleado_rep_ventas from cliente);
-- apartado i: 
select cliente.*, empleado.nombre,empleado.apellido1 from cliente inner join empleado on codigo_empleado_rep_ventas=codigo_empleado; 
-- apartado j: 
select cliente.nombre_cliente, empleado.nombre, empleado.apellido1 from cliente inner join empleado on codigo_empleado_rep_ventas=codigo_empleado where codigo_cliente not in(select codigo_cliente from pago);
-- apartado k: 
select tabla.*,producto.nombre from producto,(select *, total-(total*18/100) as totalConIva from(select codigo_producto,codigo_pedido, cantidad*precio_unidad as total, cantidad from detalle_pedido as tabla where cantidad*precio_unidad>3000) as tabla) as tabla where producto.codigo_producto=tabla.codigo_producto;
-- apartado l: 
select linea_direccion1,linea_direccion2,codigo_oficina from oficina where codigo_oficina in(select codigo_oficina from empleado where codigo_empleado in(select codigo_empleado_rep_ventas from cliente where ciudad="Fuenlabrada"));
-- apartado m:
select count(*) from pedido where codigo_cliente in(select codigo_cliente from cliente as tabla where codigo_cliente=(select codigo_cliente from pedido where codigo_pedido in(select codigo_pedido from (select sum(cantidad*precio_unidad)as total,codigo_pedido from detalle_pedido as tabla group by codigo_pedido ) as tabla where total= (select max(total) from(select sum(cantidad*precio_unidad)as total from detalle_pedido as tabla group by codigo_pedido )as tabla))));


