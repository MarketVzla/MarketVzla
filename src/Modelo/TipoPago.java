/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author migue
 */
public class TipoPago {
    String codigo,deb_nrotarjeta ,
  deb_cuenta ,
  cre_nrotarjeta,
  cre_tipotarjeta ,
  cre_fechaexp ;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDeb_nrotarjeta() {
        return deb_nrotarjeta;
    }

    public void setDeb_nrotarjeta(String deb_nrotarjeta) {
        this.deb_nrotarjeta = deb_nrotarjeta;
    }

    public String getDeb_cuenta() {
        return deb_cuenta;
    }

    public void setDeb_cuenta(String deb_cuenta) {
        this.deb_cuenta = deb_cuenta;
    }

    public String getCre_nrotarjeta() {
        return cre_nrotarjeta;
    }

    public void setCre_nrotarjeta(String cre_nrotarjeta) {
        this.cre_nrotarjeta = cre_nrotarjeta;
    }

    public String getCre_tipotarjeta() {
        return cre_tipotarjeta;
    }

    public void setCre_tipotarjeta(String cre_tipotarjeta) {
        this.cre_tipotarjeta = cre_tipotarjeta;
    }

    public String getCre_fechaexp() {
        return cre_fechaexp;
    }

    public void setCre_fechaexp(String cre_fechaexp) {
        this.cre_fechaexp = cre_fechaexp;
    }
    
    
    
}
