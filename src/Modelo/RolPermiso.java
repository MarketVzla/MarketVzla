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
public class RolPermiso {
    private static String rp_codigo,rp_nick,rp_contraseña,rp_pregunta_secreta,
                   rp_respuesta_secreta;
    private static int rp_fk_rol,rp_fk_permiso,
                   rp_fk_empleado,rp_fk_juridico,rp_fk_natural;


   

    public static void iniciarRolPermiso(String rp_codigo, String rp_nick, 
            String rp_contraseña, String rp_pregunta_secreta, String rp_respuesta_secreta, int rp_fk_rol,
            int  rp_fk_permiso, int  rp_fk_empleado,int rp_fk_juridico,int rp_fk_natural) {
        RolPermiso.setRp_codigo(rp_codigo);
        RolPermiso.setRp_nick(rp_nick);
        RolPermiso.setRp_contraseña(rp_contraseña);
        RolPermiso.setRp_pregunta_secreta(rp_pregunta_secreta);
        RolPermiso.setRp_respuesta_secreta(rp_respuesta_secreta);
        RolPermiso.setRp_fk_rol(rp_fk_rol);
        RolPermiso.setRp_fk_permiso(rp_fk_permiso);
        RolPermiso.setRp_fk_empleado(rp_fk_empleado);
        RolPermiso.setRp_fk_juridico(rp_fk_juridico);
        RolPermiso.setRp_fk_natural(rp_fk_natural);
    }
    
    
    
    
    public static void mostrarSession(){
        System.out.println(RolPermiso.getRp_codigo());
        System.out.println(RolPermiso.getRp_nick());
        System.out.println(RolPermiso.getRp_contraseña());
        System.out.println(RolPermiso.getRp_pregunta_secreta());
        System.out.println(RolPermiso.getRp_respuesta_secreta());
        System.out.println(RolPermiso.getRp_fk_rol());
        System.out.println(RolPermiso.getRp_fk_permiso());
        System.out.println(RolPermiso.getRp_fk_empleado());
        System.out.println(RolPermiso.getRp_fk_juridico());
        System.out.println(RolPermiso.getRp_fk_natural());
    
    }

    /**
     * @return the rp_codigo
     */
    public static String getRp_codigo() {
        return rp_codigo;
    }

    /**
     * @param aRp_codigo the rp_codigo to set
     */
    public static void setRp_codigo(String aRp_codigo) {
        rp_codigo = aRp_codigo;
    }

    /**
     * @return the rp_nick
     */
    public static String getRp_nick() {
        return rp_nick;
    }

    /**
     * @param aRp_nick the rp_nick to set
     */
    public static void setRp_nick(String aRp_nick) {
        rp_nick = aRp_nick;
    }

    /**
     * @return the rp_contraseña
     */
    public static String getRp_contraseña() {
        return rp_contraseña;
    }

    /**
     * @param aRp_contraseña the rp_contraseña to set
     */
    public static void setRp_contraseña(String aRp_contraseña) {
        rp_contraseña = aRp_contraseña;
    }

    /**
     * @return the rp_pregunta_secreta
     */
    public static String getRp_pregunta_secreta() {
        return rp_pregunta_secreta;
    }

    /**
     * @param aRp_pregunta_secreta the rp_pregunta_secreta to set
     */
    public static void setRp_pregunta_secreta(String aRp_pregunta_secreta) {
        rp_pregunta_secreta = aRp_pregunta_secreta;
    }

    /**
     * @return the rp_respuesta_secreta
     */
    public static String getRp_respuesta_secreta() {
        return rp_respuesta_secreta;
    }

    /**
     * @param aRp_respuesta_secreta the rp_respuesta_secreta to set
     */
    public static void setRp_respuesta_secreta(String aRp_respuesta_secreta) {
        rp_respuesta_secreta = aRp_respuesta_secreta;
    }

    /**
     * @return the rp_fk_rol
     */
    public static int getRp_fk_rol() {
        return rp_fk_rol;
    }

    /**
     * @param aRp_fk_rol the rp_fk_rol to set
     */
    public static void setRp_fk_rol(int aRp_fk_rol) {
        rp_fk_rol = aRp_fk_rol;
    }

    /**
     * @return the rp_fk_permiso
     */
    public static int getRp_fk_permiso() {
        return rp_fk_permiso;
    }

    /**
     * @param aRp_fk_permiso the rp_fk_permiso to set
     */
    public static void setRp_fk_permiso(int aRp_fk_permiso) {
        rp_fk_permiso = aRp_fk_permiso;
    }

    /**
     * @return the rp_fk_empleado
     */
    public static int getRp_fk_empleado() {
        return rp_fk_empleado;
    }

    /**
     * @param aRp_fk_empleado the rp_fk_empleado to set
     */
    public static void setRp_fk_empleado(int aRp_fk_empleado) {
        rp_fk_empleado = aRp_fk_empleado;
    }

    /**
     * @return the rp_fk_juridico
     */
    public static int getRp_fk_juridico() {
        return rp_fk_juridico;
    }

    /**
     * @param aRp_fk_juridico the rp_fk_juridico to set
     */
    public static void setRp_fk_juridico(int aRp_fk_juridico) {
        rp_fk_juridico = aRp_fk_juridico;
    }

    /**
     * @return the rp_fk_natural
     */
    public static int getRp_fk_natural() {
        return rp_fk_natural;
    }

    /**
     * @param aRp_fk_natural the rp_fk_natural to set
     */
    public static void setRp_fk_natural(int aRp_fk_natural) {
        rp_fk_natural = aRp_fk_natural;
    }
    

}
