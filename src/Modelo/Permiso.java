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
public class Permiso {
     private String condigoPermiso,nombrePermiso,descripcionPermiso;
     
     public Permiso(){
     }

    /**
     * @return the condigoPermiso
     */
    public String getCondigoPermiso() {
        return condigoPermiso;
    }

    /**
     * @param condigoPermiso the condigoPermiso to set
     */
    public void setCondigoPermiso(String condigoPermiso) {
        this.condigoPermiso = condigoPermiso;
    }

    /**
     * @return the nombrePermiso
     */
    public String getNombrePermiso() {
        return nombrePermiso;
    }

    /**
     * @param nombrePermiso the nombrePermiso to set
     */
    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    /**
     * @return the descripcionPermiso
     */
    public String getDescripcionPermiso() {
        return descripcionPermiso;
    }

    /**
     * @param descripcionPermiso the descripcionPermiso to set
     */
    public void setDescripcionPermiso(String descripcionPermiso) {
        this.descripcionPermiso = descripcionPermiso;
    }
    
     public void permisoToString(){
         System.out.println("Codigo Permiso: "+this.condigoPermiso);
        System.out.println("NOmbre Permiso: "+this.getNombrePermiso());
        System.out.println("Descripcion Permiso: "+this.getDescripcionPermiso());
     }
}
