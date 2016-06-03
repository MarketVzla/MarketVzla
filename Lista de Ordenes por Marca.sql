select count(des_codigo) as nroOrdenes, mar_nombre
from marca, despacho, producto,ejemplar
where eje_fk_despacho=des_codigo and eje_fk_producto=pro_codigo and pro_fk_marca=mar_codigo
group by mar_nombre
