create database marketvenezuela;
create table lugar (
lug_codigo serial,
lug_nombre character varying not null,
lug_tipo character varying not null,
lug_fk_lugar integer,
constraint pk_lugar primary key (lug_codigo),
constraint fk_lugar foreign key (lug_fk_lugar) references lugar(lug_codigo)
);
create table tienda (
tie_codigo serial,
tie_nombre character varying not null unique,
tie_fecha date not null,
tie_valorpuntos numeric(10,2) not null,
tie_fk_lugar integer not null,
constraint pk_tienda primary key (tie_codigo),
constraint fk_lugar foreign key (tie_fk_lugar) references lugar(lug_codigo)
);
create table pasillo (
pas_codigo serial,
pas_numero numeric not null,
pas_descripcion character varying not null,
pas_fk_tienda integer not null,
constraint pk_pasillo primary key (pas_codigo),
constraint fk_tienda foreign key (pas_fk_tienda) references tienda(tie_codigo)
);
create table zona (
zon_codigo serial,
zon_nombre character varying not null,
zon_descripcion character varying not null,
zon_fk_pasillo integer not null,
constraint pk_zona primary key (zon_codigo),
constraint fk_pasillo foreign key (zon_fk_pasillo) references pasillo(pas_codigo)
);
create table almacen (
alm_codigo serial,
alm_nombre character varying not null,
alm_descripcion character varying not null,
alm_fk_tienda integer not null,
constraint pk_almacen primary key (alm_codigo),
constraint fk_tienda foreign key (alm_fk_tienda) references tienda(tie_codigo)
);
create table rubro (
rub_codigo serial,
rub_nombre character varying not null unique,
rub_descripcion character varying not null,
rub_fk_rubro integer,
rub_fk_almacen integer not null,
constraint pk_rubro primary key (rub_codigo),
constraint fk_rubro foreign key (rub_fk_rubro) references rubro(rub_codigo),
constraint fk_almacen foreign key (rub_fk_almacen) references almacen(alm_codigo) 
);
create table despacho (
des_codigo serial,
des_fechaporaprobar date not null,
des_fechaaprobado date,
des_fecharecibido date,
des_estado character varying not null,
des_fk_tienda integer not null,
constraint pk_despacho primary key (des_codigo),
constraint fk_tienda foreign key (des_fk_tienda) references tienda(tie_codigo),
constraint ck_estado check (des_estado in ('Por Aprobar','Aprobado','Recibido','Pagado'))
);
create table empleado (
emp_ci character varying,
emp_primernombre character varying not null,
emp_segundonombre character varying,
emp_primerapellido character varying not null,
emp_segundoapellido character varying,
emp_salario numeric(10,2) not null,
emp_diasvacaciones numeric not null,
emp_fechanacimiento date not null,
constraint pk_empleado primary key (emp_ci)
);
create table tie_emp (
te_codigo serial,
te_fk_tienda integer not null,
te_fk_empleado character varying,
constraint pk_tie_emp primary key (te_codigo),
constraint fk_tienda foreign key (te_fk_tienda) references tienda(tie_codigo),
constraint fk_empleado foreign key (te_fk_empleado) references empleado(emp_ci)
);
create table presupuesto (
pre_codigo serial,
pre_fecha date not null,
pre_fechaentrega date,
pre_estado character varying not null,
pre_fk_tie_emp integer,
constraint pk_presupuesto primary key (pre_codigo),
constraint fk_tie_emp foreign key (pre_fk_tie_emp) references tie_emp(te_codigo),
constraint ck_estado check (pre_estado in ('Pedido','Reservado','Entregado','Pagado'))
);
create table juridico (
cli_codigo numeric,
cli_correo character varying not null unique,
cli_puntos numeric not null,
jur_rif character varying not null unique,
jur_denominacioncomercial character varying not null unique,
jur_razonsocial character varying not null unique,
jur_paginaweb character varying not null unique,
jur_capitaldisponible numeric(20,2) not null,
cli_fk_tienda integer not null,
cli_fk_lugar_fisica integer not null,
jur_fk_lugar_fiscal integer not null,
constraint pk_juridico primary key (cli_codigo),
constraint fk_tienda foreign key (cli_fk_tienda) references tienda(tie_codigo),
constraint fk_lugar_fisica foreign key (cli_fk_lugar_fisica) references lugar(lug_codigo),
constraint fk_lugar_fiscal foreign key (jur_fk_lugar_fiscal) references lugar(lug_codigo)
);
create table "natural" (
cli_codigo numeric,
cli_correo character varying not null unique,
cli_puntos numeric not null,
nat_cedula character varying not null unique,
nat_rif character varying unique,
nat_primernombre character varying not null,
nat_segundonombre character varying,
nat_primerapellido character varying not null,
nat_segundoapellido character varying,
cli_fk_tienda integer not null,
cli_fk_lugar integer not null,
constraint pk_natural primary key (cli_codigo),
constraint fk_tienda foreign key (cli_fk_tienda) references tienda(tie_codigo),
constraint fk_lugar foreign key (cli_fk_lugar) references lugar(lug_codigo)
);
create table compra (
com_codigo serial,
com_fechaaprobado date,
com_fechadespacho date,
com_estado character varying not null,
com_monto numeric(10,2) not null,
com_tienda boolean not null,
com_fk_tie_emp integer not null,
com_fk_juridico numeric,
com_fk_natural numeric,
constraint pk_compra primary key (com_codigo),
constraint fk_tie_emp foreign key (com_fk_tie_emp) references tie_emp(te_codigo),
constraint fk_juridico foreign key (com_fk_juridico) references juridico(cli_codigo),
constraint fk_natural foreign key (com_fk_natural) references "natural"(cli_codigo),
constraint ck_estado check (com_estado in ('Posible Compra','Reservado','Despachado','Pagado'))
);
create table personacontacto (
per_ci numeric,
per_nombre character varying not null,
per_apellido character varying not null,
per_fk_juridico numeric not null,
constraint pk_personacontacto primary key (per_ci),
constraint fk_juridico foreign key (per_fk_juridico) references juridico(cli_codigo)
);
create table marca (
mar_codigo serial,
mar_nombre character varying not null unique,
mar_descripcion character varying not null,
constraint pk_marca primary key (mar_codigo)
);
create table proveedor (
pro_rif character varying,
pro_razonsocial character varying not null unique,
pro_denominacioncomercial character varying not null unique,
pro_paginaweb character varying not null unique,
pro_fk_lugar_fisica integer not null,
pro_fk_lugar_fiscal integer not null,
pro_fk_marca integer,
constraint pk_rif primary key (pro_rif),
constraint fk_lugar_fisica foreign key (pro_fk_lugar_fisica) references lugar(lug_codigo),
constraint fk_lugar_fiscal foreign key (pro_fk_lugar_fiscal) references lugar(lug_codigo)
);
create table correo (
cor_codigo serial,
cor_direccion character varying not null unique,
cor_fk_juridico numeric,
cor_fk_natural numeric,
cor_fk_proveedor character varying,
constraint pk_correo primary key (cor_codigo),
constraint fk_juridico foreign key (cor_fk_juridico) references juridico(cli_codigo),
constraint fk_natural foreign key (cor_fk_natural) references "natural"(cli_codigo),
constraint fk_proveedor foreign key (cor_fk_proveedor) references proveedor(pro_rif)
);
create table telefono(
tel_codigo serial,
tel_descripcion character varying,
tel_numero numeric not null unique,
tel_fk_personacontacto numeric,
tel_fk_juridico numeric,
tel_fk_natural numeric,
tel_fk_proveedor character varying,
tel_fk_empleado character varying,
constraint pk_telefono primary key (tel_codigo),
constraint fk_personacontacto foreign key (tel_fk_personacontacto) references personacontacto(per_ci),
constraint fk_juridico foreign key (tel_fk_juridico) references juridico(cli_codigo),
constraint fk_natural foreign key (tel_fk_natural) references "natural"(cli_codigo),
constraint fk_proveedor foreign key (tel_fk_proveedor) references proveedor(pro_rif),
constraint fk_empleado foreign key (tel_fk_empleado) references empleado(emp_ci)
);
create table producto (
pro_codigo serial,
pro_nombre character varying not null unique,
pro_descripcion character varying not null,
pro_preciounidad numeric(9,2) not null,
pro_cantidad numeric not null,
pro_foto character varying,
pro_cantidadanaquel numeric not null,
pro_fk_rubro integer not null,
pro_fk_zona integer not null,
pro_fk_marca integer,
constraint pk_producto primary key (pro_codigo),
constraint fk_rubro foreign key (pro_fk_rubro) references rubro(rub_codigo),
constraint fk_zona foreign key (pro_fk_zona) references zona(zon_codigo),
constraint fk_marca foreign key (pro_fk_marca) references marca(mar_codigo)
);
create table cli_pro (
cp_codigo serial,
cp_cantidad numeric not null,
cp_precio numeric(9,2) not null,
cp_fk_presupuesto integer,
cp_fk_producto integer,
cp_fk_juridico numeric,
constraint pk_cli_pro primary key (cp_codigo),
constraint fk_presupuesto foreign key (cp_fk_presupuesto) references presupuesto(pre_codigo),
constraint fk_producto foreign key (cp_fk_producto) references producto(pro_codigo),
constraint fk_juridico foreign key (cp_fk_juridico) references juridico(cli_codigo)
);
create table com_pro (
cp_codigo serial,
cp_cantidad numeric not null,
cp_precio numeric(9,2) not null,
cp_fk_compra integer,
cp_fk_producto integer,
cp_fk_juridico numeric,
cp_fk_natural numeric,
constraint pk_com_pro primary key (cp_codigo),
constraint fk_compra foreign key (cp_fk_compra) references compra(com_codigo),
constraint fk_producto foreign key (cp_fk_producto) references producto(pro_codigo),
constraint fk_juridico foreign key (cp_fk_juridico) references juridico(cli_codigo),
constraint fk_natural foreign key (cp_fk_natural) references "natural"(cli_codigo)
);
create table rub_pro (
rp_codigo serial,
rp_fk_rubro integer,
rp_fk_producto integer,
constraint pk_rub_pro primary key (rp_codigo),
constraint fk_rubro foreign key (rp_fk_rubro) references rubro(rub_codigo),
constraint fk_producto foreign key (rp_fk_producto) references producto(pro_codigo)
);
create table oferta (
ofe_codigo serial,
ofe_estado character varying not null,
ofe_fecha date not null,
constraint pk_oferta primary key (ofe_codigo),
constraint ck_estado check (ofe_estado in ('Actual','Vencida'))
);
create table ofe_pro (
op_codigo serial,
op_descuento numeric not null,
op_precioactual numeric not null,
op_fk_oferta integer,
op_fk_producto integer,
constraint pk_ofe_pro primary key (op_codigo),
constraint fk_oferta foreign key (op_fk_oferta) references oferta(ofe_codigo),
constraint fk_producto foreign key (op_fk_producto) references producto(pro_codigo)
);
create table vacaciones (
vac_codigo serial,
vac_fechainicio date not null,
vac_fechafin date,
vac_fk_empleado character varying not null,
constraint pk_vacaciones primary key (vac_codigo),
constraint fk_empleado foreign key (vac_fk_empleado) references empleado(emp_ci)
);
create table beneficio (
ben_codigo serial,
ben_nombre character varying not null unique,
ben_descripcion character varying not null,
ben_porcentaje numeric not null,
constraint pk_beneficio primary key (ben_codigo)
);
create table emp_ben (
eb_codigo serial,
eb_fecha date not null,
eb_fk_empleado character varying,
eb_fk_beneficio integer,
constraint pk_emp_ben primary key (eb_codigo),
constraint fk_empleado foreign key (eb_fk_empleado) references empleado(emp_ci),
constraint fk_beneficio foreign key (eb_fk_beneficio) references beneficio(ben_codigo)
);
create table horario (
hor_codigo serial,
hor_fechainicio date not null,
hot_fechafin date not null,
constraint pk_horario primary key (hor_codigo)
);
create table emp_hor (
eh_codigo serial,
eh_fk_horario integer,
eh_fK_empleado character varying,
constraint pk_emp_hor primary key (eh_codigo),
constraint fk_empleado foreign key (eh_fk_empleado) references empleado(emp_ci),
constraint fk_horario foreign key (eh_fk_horario) references horario(hor_codigo)
);
create table "check" (
che_codigo serial,
che_estado character varying not null,
che_fecha date not null,
che_fk_emp_hor integer,
constraint pk_check primary key (che_codigo),
constraint fk_emp_hor foreign key (che_fk_emp_hor) references emp_hor(eh_codigo)
);
create table permiso (
per_codigo serial,
per_nombre character varying unique,
per_descripcion character varying not null,
constraint pk_permiso primary key (per_codigo)
);
create table rol(
rol_codigo serial,
rol_nombre character varying not null unique,
rol_descripcion character varying not null,
constraint pk_rol primary key (rol_codigo)
);
create table rol_per (
rp_codigo serial,
rp_nick character varying not null unique,
"rp_contraseña" character varying not null,
rp_preguntasecreta character varying,
rp_respuestasecreta character varying,
rp_fk_rol integer not null,
rp_fk_permiso integer not null,
rp_fk_empleado character varying,
rp_fk_juridico numeric,
rp_fk_natural numeric,
constraint pk_rol_per primary key (rp_codigo),
constraint fk_rol foreign key (rp_fk_rol) references rol(rol_codigo),
constraint fk_permiso foreign key (rp_fk_permiso) references permiso(per_codigo),
constraint fk_empleado foreign key (rp_fk_empleado) references empleado(emp_ci),
constraint fk_juridico foreign key (rp_fk_juridico) references juridico(cli_codigo),
constraint fk_natural foreign key (rp_fk_natural) references "natural"(cli_codigo)
);
create table tipopago(
tip_codigo serial,
tip_efectivo numeric(9,2),
tip_puntos numeric,
che_nrocheque character varying,
che_banco character varying,
che_cuenta character varying,
deb_nrotarjeta character varying,
deb_cuenta character varying,
cre_nrotarjeta character varying,
cre_tipotarjeta character varying,
cre_fechaexp date,
tra_nrocuenta character varying,
tra_banco character varying,
constraint pk_tipopago primary key (tip_codigo)
);
create table cli_tip (
ct_codigo serial,
ct_fk_tipopago integer not null,
ct_fk_juridico numeric,
ct_fk_natural numeric,
constraint pk_cli_tip primary key (ct_codigo),
constraint fk_tipopago foreign key (ct_fk_tipopago) references tipopago(tip_codigo),
constraint fk_juridico foreign key (ct_fk_juridico) references juridico(cli_codigo),
constraint fk_natural foreign key (ct_fk_natural) references "natural"(cli_codigo)
);
create table pago(
pag_codigo serial,
pag_monto numeric (9,2) not null,
pag_fecha date not null,
pag_fk_despacho integer,
pag_fk_compra integer,
pag_fk_presupuesto integer,
pag_fk_empleado character varying,
pag_fk_cli_tip integer,
pag_fk_transferencia integer,
constraint pk_pago primary key (pag_codigo),
constraint fk_despacho foreign key (pag_fk_despacho) references despacho(des_codigo),
constraint fk_compra foreign key (pag_fk_compra) references compra(com_codigo),
constraint fk_presupuesto foreign key (pag_fk_presupuesto) references presupuesto(pre_codigo),
constraint fk_empleado foreign key (pag_fk_empleado) references empleado(emp_ci),
constraint fk_cli_tip foreign key (pag_fk_cli_tip) references cli_tip(ct_codigo),
constraint fk_transferencia foreign key (pag_fk_transferencia) references tipopago(tip_codigo)
);
create table pro_pro (
pp_codigo serial,
pp_cantidad numeric not null,
pp_preciouni numeric(9,2) not null,
pp_fk_proveedor character varying not null,
pp_fk_producto integer not null,
pp_fk_despacho integer not null,
constraint pk_pro_pro primary key (pp_codigo),
constraint fk_proveedor foreign key (pp_fk_proveedor) references proveedor(pro_rif),
constraint fk_producto foreign key (pp_fk_producto) references producto(pro_codigo),
constraint fk_despacho foreign key (pp_fk_despacho) references despacho(des_codigo)
);
