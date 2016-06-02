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
 * @author pedro
 */
public class ControladorDespacho {
    
    public static boolean RegistrarDespacho (String des_fechaporaprobar, String des_fechaaprobado, String des_fecharecibido, String des_estado, String tienda, String rif)
    {
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("insert into despacho (des_fechaporaprobar,des_fechaaprobado,des_fecharecibido,des_estado, des_fk_tienda,des_fk_proveedor) values ('"+des_fechaporaprobar+"','"+des_fechaaprobado+"','"+des_fecharecibido+"','"+des_estado+"',(select tie_codigo form tienda where tie_nombre='"+tienda+"'),'"+rif+"') )");

            
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
    public static boolean EliminarDespacho (int codigo){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("delete from despacho where des_codigo="+codigo+"");
            
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
    public static boolean ActualizarDespacho (int des_codigo,String des_fechaporaprobar,String des_fechaaprobado,String des_fecharecibido,String des_estado,String tienda, String rif){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            int z = s.executeUpdate("update despacho set des_fechaporaprobar='"+des_fechaporaprobar+"', des_fechaaprobado='"+des_fechaaprobado+"', des_fecharecibido='"+des_fecharecibido+"',des_estado='"+des_estado+"', des_fk_tienda=(select tie_codigo from tienda where tie_nombre='"+tienda+"'),'"+rif+"' where des_codigo="+des_codigo+"");
            
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
    public static ArrayList<String> ConsultarDespacho (String marca){
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
    
    public static ArrayList<String> BuscarDespacho (String marca){
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
