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
public class Rol {
    private String condigoRol,nombreRol,descripcionRol;
    
    public Rol(){
    }

    /**
     * @return the condigoRol
     */
    public String getCondigoRol() {
        return condigoRol;
    }

    /**
     * @param condigoRol the condigoRol to set
     */
    public void setCondigoRol(String condigoRol) {
        this.condigoRol = condigoRol;
    }

    /**
     * @return the nombreRol
     */
    public String getNombreRol() {
        return nombreRol;
    }

    /**
     * @param nombreRol the nombreRol to set
     */
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    /**
     * @return the descripcionRol
     */
    public String getDescripcionRol() {
        return descripcionRol;
    }

    /**
     * @param descripcionRol the descripcionRol to set
     */
    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }
    
    public void rolToString(){
        System.out.println("Codigo Rol: "+this.getCondigoRol());
        System.out.println("NOmbre Rol: "+this.getNombreRol());
        System.out.println("Descripcion Rol: "+this.getDescripcionRol());
    }
    
}
