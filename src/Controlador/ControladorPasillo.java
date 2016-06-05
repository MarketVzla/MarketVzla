/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Etiquetas;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Funciones de Pasillo
 * @author Leonardo
 */
public class ControladorPasillo {
    
    /**
     * Registar Pasillo
     * @param numero
     * @param descripcion
     * @param tienda
     * @return true si lo hizo y false si no
     */
    public static boolean RegistrarPasillo (int numero, String descripcion, String tienda)
    {
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("insert into pasillo (pas_codigo,pas_numero,pas_descripcion,pas_fk_tienda) values (nextval('pasillo_pas_codigo_seq'::regclass),"+numero+",'"+descripcion+"',"+"(select tie_codigo from tienda where tie_nombre='"+tienda+"'))");
            
            if (z==1){
                System.out.println("Se agrego el registro");
                return true;
            }else{
                System.err.println("Ocurrio un problema");
                return false;
            }
            
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return false;
    }
    
    /**
     * Eliminar Pasillo
     * @param numero
     * @param tienda
     * @return true si lo hizo y false si no
     */
    public static boolean EliminarPasillo (int numero, String tienda){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("delete from pasillo where pas_codigo=(select pas_codigo from pasillo where pas_numero="+numero+" and  pas_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"'))");
            
            if (z==1){
                System.out.println("Se elimino el registro");
                return true;
            }else{
                System.err.println("Ocurrio un problema");
                return false;
            }
            
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return false;
    }
    
    /**
     * Actualizar Datos pasillo
     * @param numero
     * @param descripcion
     * @param tienda
     * @return true si lo hizo y false si no
     */
    public static boolean ActualizarPasillo (int numero,String descripcion, String tienda){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("update pasillo set  pas_descripcion='"+descripcion+"' where pas_numero="+numero+" and  pas_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"')");
            
            if (z==1){
                System.out.println("Se actualizo el registro");
                return true;
            }else{
                System.err.println("Ocurrio un problema");
                return false;
            }
            
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return false;
    }
           
    /**
     * Consultar datos de pasillo, el formato es:
     * [pas_numero,pas_descripcion]
     * @param pasillo
     * @param tienda
     * @return ArrayList<String> con la informacion dle pasillo
     */
    public static ArrayList<String> ConsultarPasillo (String pasillo, String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select pas_numero, pas_descripcion from pasillo where pas_numero="+pasillo+" and pas_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"')");
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
                tiendas.add(rs.getString(2));
            }
            return tiendas;
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
    
    public static ArrayList<String> BuscarPasillos (String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select pas_numero, pas_descripcion from pasillo where pas_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"') order by pas_numero asc");
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
                tiendas.add(rs.getString(2));
            }
            return tiendas;
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
        public static ArrayList<String> ArregloPasillos (String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select pas_numero from pasillo where pas_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"') order by pas_numero asc");
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
            }
            return tiendas;
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
}
