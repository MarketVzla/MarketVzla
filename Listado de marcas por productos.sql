select mar_nombre, pro_razonsocial
from marca, producto, ejemplar,proveedor,despacho
where pro_rif=des_fk_proveedor and des_codigo=eje_fk_despacho and eje_fk_producto=pro_codigo and pro_fk_marca=mar_codigo
group by mar_nombre, pro_razonsocial
order by pro_razonsocial, mar_nombre