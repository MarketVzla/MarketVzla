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
 *import Modelo.Etiquetas;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class ControladorProveedor {
 
    
    
    public static boolean RegistrarProveedor (String rif, String razonSocial,String denominacionComercial,String paginaWeb,int lugarFisico,int lugarFiscal,String marca)
    {
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
                System.out.println("hola ;d");
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
                
            s = connection.createStatement();
            int z = s.executeUpdate("insert into proveedor (pro_rif,pro_razonsocial,pro_denominacioncomercial,pro_paginaweb,pro_fk_lugar_fisica,pro_fk_lugar_fiscal,pro_fk_marca) values ('"+rif+"','"+razonSocial+"','"+denominacionComercial+"','"+paginaWeb+"',"+lugarFisico+","+lugarFiscal+",(select mar_codigo from marca where mar_nombre='"+marca+"'))");
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
    public static boolean EliminarProveedor (String rif){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("delete from proveedor where pro_rif='"+rif+"'");
            
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
    public static boolean ActualizarProveedor (String rif, String razonSocial,String denominacionComercial,String paginaWeb,int lugarFisico,int lugarFiscal){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            System.out.println("hola");
            
            int z = s.executeUpdate("update proveedor set pro_razonsocial='"+razonSocial+"', pro_denominacioncomercial='"+denominacionComercial+"', pro_paginaweb='"+paginaWeb+"', pro_fk_lugar_fisica="+lugarFisico+",pro_fk_lugar_fiscal="+lugarFiscal+" where pro_rif='"+rif+"' ");
            
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
    public static ArrayList<String> ConsultarProveedor (String rif){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select pro_rif, pro_razonsocial,pro_denominacioncomercial, pro_paginaweb,pro_fk_lugar_fisica, pro_fk_lugar_fiscal, pro_fk_marca from proveedor where pro_rif='"+rif+"'");
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
                tiendas.add(rs.getString(2));
                tiendas.add(rs.getString(3));
                tiendas.add(rs.getString(4));
                tiendas.add(rs.getString(5));
                tiendas.add(rs.getString(6));
                tiendas.add(rs.getString(7));
            }
            return tiendas;
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
    
    public static ArrayList<String> BuscarProveedor (String rif){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select pro_rif, pro_razonsocial, pro_denominacioncomercial, pro_paginaweb,pro_fk_lugar_fisica, pro_fk_lugar_fiscal, pro_fk_marca from proveedor where pro_rif like '"+rif+"%' limit 10");
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
                tiendas.add(rs.getString(2));
                tiendas.add(rs.getString(3));
                tiendas.add(rs.getString(4));
                tiendas.add(rs.getString(5));
                tiendas.add(rs.getString(6));
                tiendas.add(rs.getString(7));
              for(int i = 0; i < tiendas.size(); i++) {   
   System.out.println(tiendas.get(i));
     }  
            
            }
            return tiendas;
         
          
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
    
    public static ArrayList<String> ArregloProveedores (){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select pro_razonsocial from proveedor  ");
            
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
    
