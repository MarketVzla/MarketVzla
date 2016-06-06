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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Leonardo
 */
public class ControladorCompra {
     private static SimpleDateFormat simpleDateFormat;
    public static boolean RealizarCompraReservando (String tienda, String cliente, String monto){
        
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
            
            int z = s.executeUpdate("insert into compra (com_fechaaprobado,com_estado, com_monto, com_tienda, com_fk_dep_emp,com_fk_natural) values ('"+calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+"','Reservado',"+monto+",true,(select distinct de_codigo from dep_emp,departamento,compra where de_fk_departamento=dep_codigo and dep_nombre='Ventas' and dep_fk_tienda=(select tie_codigo from tienda where  tie_nombre='"+tienda+"')),(select cli_codigo from \"natural\",usuario where usu_fk_natural=cli_codigo and usu_nick='"+cliente+"'))");
            
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
    
    public static boolean RealizarCompra (String tienda, String cliente, String monto){
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
            
            int z = s.executeUpdate("insert into compra (com_fechaaprobado,com_estado, com_monto, com_tienda, com_fk_dep_emp,com_fk_natural) values ('"+calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+"','Pagado',"+monto+",true,(select distinct de_codigo from dep_emp,departamento,compra where de_fk_departamento=dep_codigo and dep_nombre='Ventas' and dep_fk_tienda=(select tie_codigo from tienda where  tie_nombre='"+tienda+"')),(select cli_codigo from \"natural\",usuario where usu_fk_natural=cli_codigo and usu_nick='"+cliente+"'))");
            
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
    
    public static boolean GenerarPuntos (String cliente,String cantidad){
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
            
            int z = s.executeUpdate("insert into canje (can_cantidad,can_valor,can_fk_natural) values ("+cantidad+",(select distinct tie_valorpuntos from tienda, \"natural\" where tie_codigo=cli_fk_tienda and cli_codigo="+cliente+"),"+cliente+")");
            
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
    
    public static boolean ReservarEjemplares (String ejemplar, String compra){
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
            
            int z = s.executeUpdate("update ejemplar set eje_fk_compra="+compra+" where eje_codigo="+ejemplar);
            
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
    
    public static ArrayList<String> ObtenerEjemplares (String producto, String cantidad, String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select eje_codigo from ejemplar where eje_fk_compra is null and eje_fk_presupuesto is null and eje_fk_producto in (select pro_codigo from producto where pro_nombre='"+producto+"') and eje_fk_zona in (select zon_codigo from zona where zon_fk_pasillo in(select pas_codigo from pasillo where pas_fk_tienda in(select tie_codigo from tienda where tie_nombre='"+tienda+"'))) limit "+cantidad);
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
            }
            return tiendas;
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
    
    public static ArrayList<String> ObtenerCodigoCompra (){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select max(com_codigo) from compra");
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
            }
            return tiendas;
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
    
    public static ArrayList<String> ConsultarProductosDisponibles (String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select pro_nombre,count(eje_fk_producto),eje_precio from producto, ejemplar where eje_fk_producto=pro_codigo and eje_fk_zona in (select zon_codigo from zona where zon_fk_pasillo in (select pas_codigo from pasillo where pas_fk_tienda=(select tie_codigo from tienda where tie_nombre= '"+tienda+"'))) and eje_fk_compra is null and eje_fk_presupuesto is null group by pro_nombre,eje_precio having count(eje_fk_producto)>=100 order by pro_nombre;");
            
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
    
    public static ArrayList<String> ConsultarDatosClienteNatural (String cedula){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select (nat_primernombre||' '||nat_primerapellido)as nombre, usu_nick, (cli_fk_tienda||'-'||cli_codigo)as nrocarnet from \"natural\", usuario where cli_codigo=usu_fk_natural and nat_cedula='"+cedula+"';");
            
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
