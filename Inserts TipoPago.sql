INSERT INTO tipopago (tip_tipo,tip_efectivo) values ('Efectivo',true);
INSERT INTO tipopago (tip_tipo,tra_nrocuenta,tra_banco) values ('Transferencia','123456789','Mercantil');
INSERT INTO tipopago (tip_tipo,che_nrocheque,che_banco,che_cuenta) values ('Cheque','123456789','Mercantil','Corriente');
INSERT INTO tipopago (tip_tipo,deb_nrotarjeta,deb_cuenta) values ('Debito','123456789','Corriente');
INSERT INTO tipopago (tip_tipo,cre_nrotarjeta,cre_tipotarjeta,cre_fechaexp) values ('Credito','123456789','Visa','12/05/2021');
