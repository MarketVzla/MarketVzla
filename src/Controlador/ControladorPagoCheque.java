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
public class ControladorPagoCheque {
    
    
    public static String ObtenerPago (String debito){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select tip_codigo from tipopago where deb_nrotarjeta="+debito);
            
            while (rs.next()){
                return rs.getString(1);
            }
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
    
     public static ArrayList<String> ObtenerDebito (String cliente){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select deb_nrotarjeta from tipopago,cli_tip where ct_fk_tipopago=tip_codigo and ct_fk_natural="+cliente);
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
            }
            return tiendas;
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
    
     public static ArrayList<String> ObtenerCredito (String cliente){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select cre_nrotarjeta from tipopago,cli_tip where ct_fk_tipopago=tip_codigo and ct_fk_natural="+cliente);
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
            }
            return tiendas;
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
     
    public static String ObtenerPagoC (String credito){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select tip_codigo from tipopago where cre_nrotarjeta="+credito);
            
            while (rs.next()){
                return rs.getString(1);
            }
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
    
    public static boolean RegistrarCheque (String nrocheque, String banco, String cuenta){
        
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
            
            int z = s.executeUpdate("insert into tipopago (tip_tipo,che_nrocheque,che_banco,che_cuenta) values ('Cheque','"+nrocheque+"','"+banco+"','"+cuenta+"');");
            
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
    
    public static boolean RegistrarPago (String cliente,String compra,String monto,String tipopago){
        
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
            
            int z = s.executeUpdate("insert into pago (pag_monto, pag_fecha,pag_fk_compra,pag_fk_cli_tip) values ("+monto+",'"+calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+"',"+compra+",(select distinct ct_codigo from cli_tip where ct_fk_tipopago="+tipopago+" and ct_fk_natural="+cliente+"));");
            
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
    
     public static String ObtenerUltimoTipoPago (){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select max(tip_codigo) from tipopago");
            
            while (rs.next()){
                return (rs.getString(1));
            }
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
    
}
