1:
create 
view listado_pago_clientes as 
select concat(cliente.nombre_contacto,' ',cliente.apellido_contacto) 
as nombreApellido, cliente.telefono, cliente.ciudad, cliente.pais, 
pago.fecha_pago,
pago.total, pago.id_transaccion 
from cliente,pago where cliente.codigo_cliente=pago.codigo_cliente;
2:
create view listado_pedidos_clientes as 
select concat(cliente.nombre_contacto,' ',cliente.apellido_contacto) as nombreApellido, cliente.telefono, 
cliente.ciudad, cliente.pais, pedido.codigo_pedido,
pedido.fecha_pedido, pedido.fecha_esperada, pedido.fecha_entrega,
sum(detalle_pedido.cantidad*detalle_pedido.precio_unidad) as total from cliente,pedido,detalle_pedido 
where cliente.codigo_cliente=pedido.codigo_cliente and detalle_pedido.codigo_pedido=pedido.codigo_pedido group by pedido.codigo_pedido;
3:
select distinct nombreApellido from listado_pago_clientes where ciudad='Madrid';
4:
select distinct nombreApellido from listado_pedidos_clientes where fecha_entrega is null;
5:
select count(*) as recuento,nombreApellido from listado_pedidos_clientes group by nombreApellido;
6:
select max(total),min(total),nombreApellido from listado_pedidos_clientes group by nombreApellido;
7:
rename table listado_pagos_clientes to listado_de_pagos;
8:
drop view listado_de_pagos;
drop view listado_pedidos_clientes 