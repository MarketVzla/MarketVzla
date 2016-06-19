/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author migue
 */
public class RolPermiso {
    private  String rp_codigo,rp_nick,rp_contraseña,rp_pregunta_secreta,
                   rp_respuesta_secreta;
    private  int rp_fk_rol,rp_fk_permiso,
                   rp_fk_empleado,rp_fk_juridico,rp_fk_natural;


   public  ArrayList<Permiso> permisos ;

    /*public  void getPermisos() {
         for (int i = 0; i <  permisos  .size(); i++) {
           
            if(! permisos .isEmpty()){
                
                   System.out.println("Permisos "+permisos.get(i).getNombrePermiso());
               

                
            }else {System.out.println("Lista Vacia get LugarFK");}
        }
    }*/

    public ArrayList<Permiso> getPermisos() {
        return permisos;
    }
    
     

    public void setPermisos(String nick,String pass) {
        
        permisos = new ArrayList<Permiso>();
        Permiso emp;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
                sql = "select per_codigo,per_nombre,per_descripcion " +
"from usuario,rol,permiso,rol_per " +
"where usu_nick = '"+nick+"' and  \"usu_contraseña\" = '"+pass+"' and rp_fk_usuario = usu_nick and rp_fk_rol = rol_codigo and  per_codigo = rp_fk_permiso " +
"order by per_nombre ;"; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                           emp= new  Permiso();
                        emp.setCondigoPermiso(rs.getString("per_codigo"));
                        emp.setNombrePermiso(rs.getString("per_nombre"));
                        emp.setDescripcionPermiso(rs.getString("per_descripcion"));
                        
                 
                          permisos  .add(emp);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        
    }
    
    
    
    
    public  void mostrarSession(){
        System.out.println(this.getRp_codigo());
        System.out.println(this.getRp_nick());
        System.out.println(this.getRp_contraseña());
        System.out.println(this.getRp_pregunta_secreta());
        System.out.println(this.getRp_respuesta_secreta());
        System.out.println(this.getRp_fk_rol());
        System.out.println(this.getRp_fk_permiso());
        System.out.println(this.getRp_fk_empleado());
        System.out.println(this.getRp_fk_juridico());
        System.out.println(this.getRp_fk_natural());
    
    }

    /**
     * @return the rp_codigo
     */
    public String getRp_codigo() {
        return rp_codigo;
    }

    /**
     * @param aRp_codigo the rp_codigo to set
     */
    public void setRp_codigo(String aRp_codigo) {
        rp_codigo = aRp_codigo;
    }

    /**
     * @return the rp_nick
     */
    public  String getRp_nick() {
        return rp_nick;
    }

    /**
     * @param aRp_nick the rp_nick to set
     */
    public  void setRp_nick(String aRp_nick) {
        rp_nick = aRp_nick;
    }

    /**
     * @return the rp_contraseña
     */
    public  String getRp_contraseña() {
        return rp_contraseña;
    }

    /**
     * @param aRp_contraseña the rp_contraseña to set
     */
    public void setRp_contraseña(String aRp_contraseña) {
        rp_contraseña = aRp_contraseña;
    }

    /**
     * @return the rp_pregunta_secreta
     */
    public  String getRp_pregunta_secreta() {
        return rp_pregunta_secreta;
    }

    /**
     * @param aRp_pregunta_secreta the rp_pregunta_secreta to set
     */
    public  void setRp_pregunta_secreta(String aRp_pregunta_secreta) {
        rp_pregunta_secreta = aRp_pregunta_secreta;
    }

    /**
     * @return the rp_respuesta_secreta
     */
    public  String getRp_respuesta_secreta() {
        return rp_respuesta_secreta;
    }

    /**
     * @param aRp_respuesta_secreta the rp_respuesta_secreta to set
     */
    public  void setRp_respuesta_secreta(String aRp_respuesta_secreta) {
        rp_respuesta_secreta = aRp_respuesta_secreta;
    }

    /**
     * @return the rp_fk_rol
     */
    public  int getRp_fk_rol() {
        return rp_fk_rol;
    }

    /**
     * @param aRp_fk_rol the rp_fk_rol to set
     */
    public  void setRp_fk_rol(int aRp_fk_rol) {
        rp_fk_rol = aRp_fk_rol;
    }

    /**
     * @return the rp_fk_permiso
     */
    public  int getRp_fk_permiso() {
        return rp_fk_permiso;
    }

    /**
     * @param aRp_fk_permiso the rp_fk_permiso to set
     */
    public  void setRp_fk_permiso(int aRp_fk_permiso) {
        rp_fk_permiso = aRp_fk_permiso;
    }

    /**
     * @return the rp_fk_empleado
     */
    public  int getRp_fk_empleado() {
        return rp_fk_empleado;
    }

    /**
     * @param aRp_fk_empleado the rp_fk_empleado to set
     */
    public  void setRp_fk_empleado(int aRp_fk_empleado) {
        rp_fk_empleado = aRp_fk_empleado;
    }

    /**
     * @return the rp_fk_juridico
     */
    public  int getRp_fk_juridico() {
        return rp_fk_juridico;
    }

    /**
     * @param aRp_fk_juridico the rp_fk_juridico to set
     */
    public void setRp_fk_juridico(int aRp_fk_juridico) {
        rp_fk_juridico = aRp_fk_juridico;
    }

    /**
     * @return the rp_fk_natural
     */
    public  int getRp_fk_natural() {
        return rp_fk_natural;
    }

    /**
     * @param aRp_fk_natural the rp_fk_natural to set
     */
    public void setRp_fk_natural(int aRp_fk_natural) {
        rp_fk_natural = aRp_fk_natural;
    }
    

}
