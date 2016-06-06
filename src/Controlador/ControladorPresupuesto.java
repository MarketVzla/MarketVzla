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
public class ControladorPresupuesto {
    
    public static boolean RealizarPresupuestoReservando (String tienda, String rif, String monto){
        
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
            
            int z = s.executeUpdate("insert into presupuesto (pre_fecha,pre_estado,pre_monto,pre_fk_dep_emp,pre_fk_juridico) values ('"+calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+"','Reservado',"+monto+",(select distinct de_codigo from dep_emp,departamento,compra where de_fk_departamento=dep_codigo and dep_nombre='Ventas' and dep_fk_tienda=(select tie_codigo from tienda where  tie_nombre='"+tienda+"')),(select cli_codigo from juridico,usuario where usu_fk_juridico=cli_codigo and usu_nick='"+rif+"'))");
            
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
    
    public static boolean RealizarCompraPresupuesto (String codigo, String tienda){
        
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
            
            int z = s.executeUpdate("insert into compra (com_fechaaprobado,com_estado, com_monto, com_tienda, com_fk_dep_emp,com_fk_presupuesto) values ('"+calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH)+"','Pagado',(select pre_monto from presupuesto where pre_codigo="+codigo+"),true,(select distinct de_codigo from dep_emp,departamento,presupuesto where de_fk_departamento=dep_codigo and dep_nombre='Ventas' and dep_fk_tienda=(select tie_codigo from tienda where  tie_nombre='"+tienda+"')),"+codigo+")");
            
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
    
    public static ArrayList<String> ObtenerCodigoPresupuesto (){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select max(pre_codigo) from presupuesto");
            
            while (rs.next()){
                tiendas.add(rs.getString(1));
            }
            return tiendas;
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
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
            
            int z = s.executeUpdate("update ejemplar set eje_fk_presupuesto="+compra+" where eje_codigo="+ejemplar);
            
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
    
    public static ArrayList<String> ConsultarDatosClienteJuridico (String razonsocial){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select jur_razonsocial, usu_nick, (cli_fk_tienda||'-'||cli_codigo)as nrocarnet from juridico, usuario where cli_codigo=usu_fk_juridico and jur_razonsocial='"+razonsocial+"';");         
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
