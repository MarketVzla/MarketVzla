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
 * Funciones de ALmacen
 * @author Leonardo
 */
public class ControladorAlmacen {
    
    /**
     * Registrar Almacen
     * @param nombre
     * @param descripcion
     * @param tienda
     * @return true si lo hizo y false si no
     */
    public static boolean RegistrarAlmacen (String nombre, String descripcion, String tienda)
    {
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("insert into almacen (alm_codigo,alm_nombre,alm_descripcion,alm_fk_tienda) values (nextval('almacen_alm_codigo_seq'::regclass),'"+nombre+"','"+descripcion+"',"+"(select tie_codigo from tienda where tie_nombre='"+tienda+"'))");
            
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
     * Eliminar Almacen
     * @param nombre
     * @param tienda
     * @return true si lo hizo y false si no
     */
    public static boolean EliminarAlmacen (String nombre, String tienda){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("delete from almacen where alm_codigo=(select alm_codigo from almacen where alm_nombre='"+nombre+"' and  alm_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"'))");
            
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
     * Actualizar Datos del Almacen
     * @param nombre
     * @param descripcion
     * @param tienda
     * @return 
     */
    public static boolean ActualizarAlmacen (String nombre,String nombreNuevo,String descripcion, String tienda){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("update almacen set alm_nombre='"+nombreNuevo+"', alm_descripcion='"+descripcion+"' where alm_nombre='"+nombre+"' and alm_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"')");
            
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
     * Consultar datos de almacen, el formato es:
     * [alm_nombre,alm_descripcion]
     * @param tienda
     * @return ArrayList<String> con la informacion del almacen
     */
    public static ArrayList<String> ConsultarAlmacen (String nombre, String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select alm_nombre, alm_descripcion from almacen where alm_nombre='"+nombre+"' and alm_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"')");
            
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
    
    public static ArrayList<String> BuscarAlmacenes (String nombre,String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select alm_nombre, alm_descripcion from almacen where alm_nombre like '"+nombre+"%' and alm_fk_tienda=(select tie_codigo from tienda where tie_nombre like '"+tienda+"')");
            
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
    
    public static ArrayList<String> ArregloAlmacenes (String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select alm_nombre from almacen where alm_fk_tienda=(select tie_codigo from tienda where tie_nombre like '"+tienda+"')");
            
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
