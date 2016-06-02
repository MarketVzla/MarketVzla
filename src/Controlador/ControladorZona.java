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
 * Funciones relacionadas con la entidad Zona
 * @author Leonardo
 */
public class ControladorZona {
    
    /**
     * Registra la Zona en un pasilo
     * @param nombre
     * @param descripcion
     * @param pasillo
     * @param tienda
     * @return true si lo registro y false si no lo hizo
     */
    public static boolean RegistrarZona (String nombre, String descripcion, int pasillo, String tienda)
    {
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("insert into zona (zon_codigo,zon_nombre,zon_descripcion,zon_fk_pasillo) values (nextval('zona_zon_codigo_seq'::regclass),'"+nombre+"','"+descripcion+"',"+"(select pas_codigo from pasillo where pas_numero="+pasillo+" and pas_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"')))");
            
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
     * Eliminar una Zona de un pasillo
     * @param nombre
     * @param pasillo
     * @param tienda
     * @return true si lo hizo y false si no lo hizo
     */
    public static boolean EliminarZona (String nombre, int pasillo, String tienda){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("delete from zona where zon_codigo=(select zon_codigo from zona where zon_nombre='"+nombre+"' and  zon_fk_pasillo=(select pas_codigo from pasillo where pas_numero="+pasillo+" and pas_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"')))");
            
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
     * Actualizar datos de una Zona
     * @param nombre
     * @param descripcion
     * @param pasillo
     * @return true si lo hizo y false si no
     */
    public static boolean ActualizarZona (String nombre, String nombreNuevo,String descripcion, String pasillo, String tienda){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("update zona set zon_nombre='"+nombreNuevo+"', zon_descripcion='"+descripcion+"' where zon_nombre='"+nombre+"' and  zon_fk_pasillo=(select pas_codigo from pasillo where pas_numero="+pasillo+" and pas_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"'))");
            
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
     * Consultar datos de zona, el formato es:
     * [zon_nombre,zon_descripcion]
     * @param pasillo
     * @return ArrayList<String> con todas las zonas de ese pasillo
     */
    public static ArrayList<String> ConsultarZona (String zona, String pasillo, String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select zon_nombre, zon_descripcion from zona where zon_codigo=(select zon_codigo from zona where zon_nombre='"+zona+"') and zon_fk_pasillo=(select pas_codigo from pasillo where pas_numero="+pasillo+" and pas_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"'))");
            
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
    
    
    public static ArrayList<String> BuscarZonas (String zona, String pasillo, String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select zon_nombre, zon_descripcion from zona where zon_nombre like '"+zona+"%' and zon_fk_pasillo=(select pas_codigo from pasillo where pas_numero="+pasillo+" and pas_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"'))");
            
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
}
