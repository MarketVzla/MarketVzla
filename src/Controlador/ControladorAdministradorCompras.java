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
import java.util.Calendar;

/**
 *
 * @author Leonardo
 */
public class ControladorAdministradorCompras {
    
    public static boolean EliminarCompra (String compra){
        
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            Calendar calendar = Calendar.getInstance();
            
            int z = s.executeUpdate("delete from compra where com_codigo="+compra);
            
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
    
    public static ArrayList<String> ObtenerClientesYCompras (String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select distinct com_codigo,(extract(day from com_fechadespacho)||'-'||extract(month from com_fechadespacho)||'-'||extract(year from com_fechadespacho))as fecha,com_monto,cliente.nombre from compra, tienda, (select cli_codigo,(nat_primernombre||' '||nat_primerapellido) as nombre from \"natural\", compra where cli_codigo=com_fk_natural) as cliente, dep_emp, departamento where (select tie_codigo from tienda where tie_nombre='"+tienda+"')=dep_fk_tienda and dep_codigo=de_fk_departamento and de_codigo=com_fk_dep_emp and cliente.cli_codigo=com_fk_natural");
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
                tiendas.add(rs.getString(2));
                tiendas.add(rs.getString(3));
                tiendas.add(rs.getString(4));
            }
            return tiendas;
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
    
    public static ArrayList<String> ObtenerCodigoCliente (String [] cliente){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select cli_codigo from \"natural\" where nat_primernombre='"+cliente[0]+"' and nat_primerapellido='"+cliente[1]+"'");
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
            }
            return tiendas;
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
    public static ArrayList<String> ObtenerCompras (String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select distinct com_codigo, com_fechadespacho,com_estado,com_monto,(nat_primernombre||' '||nat_primerapellido)as nombre from compra,dep_emp,departamento,tienda,\"natural\" where com_fk_natural=cli_codigo and com_fk_dep_emp=de_codigo and de_fk_departamento=dep_codigo and dep_nombre='Ventas' and dep_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"')");
            
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
    
    
    
     public static ArrayList<String> ObtenerProductosDeCompra (String compra){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select pro_nombre, count(eje_codigo),eje_precio from producto, ejemplar,compra where com_codigo="+compra+" and eje_fk_compra="+compra+" and eje_fk_producto=pro_codigo group by pro_nombre,eje_precio");
            
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
