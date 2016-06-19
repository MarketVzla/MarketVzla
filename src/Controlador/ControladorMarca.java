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
 *
 * @author Leonardo
 */
public class ControladorMarca {
 
    
    
    public static boolean RegistrarMarca (String mar_nombre, String mar_descripcion, boolean interna)
    {
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("insert into marca (mar_nombre,mar_descripcion,mar_interna) values ('"+mar_nombre+"','"+mar_descripcion+"',"+interna+") )");

            
          //  int z = s.executeUpdate("insert into proveedor (pro_rif,pro_razonsocial,pro_denominacioncomercial,pro_paginaweb,pro_fk_lugar_fisica,pro_fk_lugar_fiscal,pro_fk_marca) values ('"+rif+"','"+razonSocial+"','"+denominacionComercial+"','"+paginaWeb+"',"+lugarFisico+","+lugarFiscal+","+marca+")");
           // int z = s.executeUpdate("insert into tienda (tie_codigo,tie_nombre,tie_fecha,tie_valorpuntos,tie_fk_lugar) values (nextval('tienda_tie_codigo_seq'::regclass),'"+nombre+"','"+fecha+"',"+valorNro+","+lugar+")");
            
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
    public static boolean EliminarMarca (String nombre){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("delete from marca where mar_nombre='"+nombre+"'");
            
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
    public static boolean ActualizarMarca (String nombre,String nombrenuevo,String descripcion, boolean estado){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("update marca set mar_nombre='"+nombrenuevo+"', mar_descripcion='"+descripcion+"', mar_estado='"+estado+"' where mar_nombre='"+nombre+"'");
            
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
    public static ArrayList<String> ConsultarMarca (String marca){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select mar_nombre, mar_descripcion, mar_interna from marca where mar_nombre ='"+marca+"'");
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
                tiendas.add(rs.getString(2));
                tiendas.add(rs.getString(3));
            }
            return tiendas;
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
    
    public static ArrayList<String> BuscarMarca (String marca){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select mar_nombre, mar_descripcion, mar_interna from marca where mar_nombre like '"+marca+"%' limit 10");
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
                tiendas.add(rs.getString(2));
                tiendas.add(rs.getString(3));
            }
            return tiendas;
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
    
}
