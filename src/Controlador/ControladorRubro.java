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
 * Funciones de la entidad Rubro
 * @author Leonardo
 */
public class ControladorRubro {
    
    /**
     * Registrar rubro
     * @param nombre
     * @param descripcion
     * @param rubro
     * @param almacen
     * @param tienda
     * @return true si lo registro y false si no
     */
    public static boolean RegistrarRubro (String nombre, String descripcion, String rubro, String almacen, String tienda)
    {
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            int z;
            
            z = s.executeUpdate("insert into rubro (rub_codigo,rub_nombre,rub_descripcion,rub_fk_rubro,rub_fk_almacen) values (nextval('rubro_rub_codigo_seq'::regclass),'"+nombre+"','"+descripcion+"',(select rub_codigo from rubro where rub_nombre='"+rubro+"'),(select alm_codigo from almacen where alm_nombre='"+almacen+"' and alm_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"')))");
            
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
     * Eliminar rubro
     * @param nombre
     * @param almacen
     * @param tienda
     * @return true si lo hizo y false si no
     */
    public static boolean EliminarRubro (String nombre,String almacen, String tienda){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("delete from rubro where rub_codigo=(select rub_codigo from rubro where rub_nombre='"+nombre+"' and  rub_fk_almacen=(select alm_codigo from almacen where alm_nombre='"+almacen+"' and  alm_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"')))");
            
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
     * Actualizar datos de un rubro
     * @param nombre
     * @param nombreNuevo
     * @param descripcion
     * @param almacen
     * @param tienda
     * @return true si lo actualizo y false si no lo hizo
     */
    public static boolean ActualizarRubro (String nombre,String nombreNuevo,String descripcion,String almacen, String tienda){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("update rubro set rub_nombre='"+nombreNuevo+"', rub_descripcion='"+descripcion+"' where rub_nombre='"+nombre+"' and rub_fk_almacen=(select alm_codigo from almacen where alm_nombre='"+almacen+"' and alm_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"'))");
            
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
     public static ArrayList<String> ArregloRubro (){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select distinct rub_nombre from rubro");
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
            }
            return tiendas;
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
           
    /**
     * Consultar datos de rubro, el formato es:
     * [rub_nombre,rub_descripcion]
     * @param rubro
     * @param almacen
     * @param tienda
     * @return ArrayList<String> con el rubro seleccionado
     */
    public static ArrayList<String> ConsultarRubro (String rubro, String almacen, String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select rub_nombre, rub_descripcion from rubro where rub_nombre='"+rubro+"' and  rub_fk_almacen=(select alm_codigo from almacen where alm_nombre='"+almacen+"' and alm_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"'))");
            
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
    
    public static ArrayList<String> ConsultarRubros (String almacen, String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select rub_nombre, rub_descripcion from rubro where rub_fk_almacen=(select alm_codigo from almacen where alm_nombre='"+almacen+"' and alm_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"'))");
            
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
    
    public static ArrayList<String> BuscarRubros (String rubro, String almacen, String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select rub_nombre, rub_descripcion from rubro where rub_nombre like '"+rubro+"%' and rub_fk_almacen=(select alm_codigo from almacen where alm_nombre='"+almacen+"' and alm_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"'))");
            
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
