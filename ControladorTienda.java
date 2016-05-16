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
 * Funciones de la entidad Tienda
 * @author Leonardo
 */
public class ControladorTienda {
    
    /**
     * Registra una tienda en el sistema
     * @param nombre
     * @param fecha
     * @param valorNro
     * @param lugar
     * @return boolean True si lo registro y false si no lo registro
     */
    public static boolean RegistrarTienda (String nombre, String fecha,double valorNro,int lugar)
    {
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("insert into tienda (tie_codigo,tie_nombre,tie_fecha,tie_valorpuntos,tie_fk_lugar) values (nextval('tienda_tie_codigo_seq'::regclass),'"+nombre+"','"+fecha+"',"+valorNro+","+lugar+")");
            
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
     * Eliminar tienda
     * @param nombre
     * @return true si lo hizo y false si no lo hizo
     */
    public static boolean EliminarTienda (String nombre){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("delete from tienda where tie_nombre='"+nombre+"'");
            
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
     * Actualizar datos de una tienda
     * @param nombre
     * @param nombrenuevo
     * @param valorpuntos
     * @param fecha
     * @param lugar
     * @return 
     */
    public static boolean ActualizarTienda (String nombre,String nombrenuevo, double valorpuntos, String fecha, int lugar){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("update tienda set tie_nombre='"+nombrenuevo+"', tie_valorpuntos="+valorpuntos+", tie_fecha='"+fecha+"', tie_fk_lugar="+lugar+" where tie_nombre='"+nombre+"'");
            
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
     * Consultar datos de tienda, el formato es:
     * [tie_codigo, tie_nombre,tie_fecha,tie_valorpuntos,tie_fk_lugar]
     * @param tienda
     * @return ArrayList<String> con los datos de la tienda
     */
    public static ArrayList<String> ConsultarTienda (String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select tie_codigo, tie_nombre,tie_fecha, tie_valorpuntos,tie_fk_lugar from tienda where tie_nombre='"+tienda+"'");
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
                tiendas.add(rs.getString(2));
                tiendas.add(rs.getString(3));
                tiendas.add(rs.getString(4));
                tiendas.add(rs.getString(5));
            }
            return tiendas;
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
    
    public static ArrayList<String> BuscarTiendas (String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select tie_codigo, tie_nombre, tie_fecha, tie_valorpuntos,tie_fk_lugar from tienda where tie_nombre like '"+tienda+"%' limit 10");
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
                tiendas.add(rs.getString(2));
                tiendas.add(rs.getString(3));
                tiendas.add(rs.getString(4));
                tiendas.add(rs.getString(5));
            }
            return tiendas;
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
    
}
