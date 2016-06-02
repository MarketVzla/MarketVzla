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
public class ControladorProducto {
 
    
    
    public static boolean RegistrarProducto (String nombre, String descripcion,String rubro,String almacen,String tienda, String marca)
    {
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            
            
int z = s.executeUpdate("insert into producto (pro_nombre,pro_descripcion,pro_fk_rubro,pro_fk_marca) values ('"+nombre+"','"+descripcion+"',(select rub_codigo FROM rubro where rub_nombre='"+rubro+"' and rub_fk_almacen=(select alm_codigo from almacen where alm_nombre= '"+almacen+"'and alm_fk_tienda=(SELECT tie_codigo FROM tienda where tie_nombre = '"+tienda+"'))),(select mar_codigo from marca where mar_nombre='"+marca+"'))");           // int z = s.executeUpdate("insert into tienda (tie_codigo,tie_nombre,tie_fecha,tie_valorpuntos,tie_fk_lugar) values (nextval('tienda_tie_codigo_seq'::regclass),'"+nombre+"','"+fecha+"',"+valorNro+","+lugar+")");
            
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
    public static boolean EliminarProducto (String nombre, String rubro,String almacen, String tienda ){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
//RETORNA TODOS LOS PRODUCTOS DE UNA TIENDA EN ESPECIFICO
           // int a=s.executeUpdate("select pro_nombre, pro_codigo  from producto where pro_fk_rubro in (select rub_codigo from rubro where rub_fk_almacen in (select alm_codigo from almacen where alm_fk_tienda = (select tie_codigo from tienda where tie_nombre='"+tienda+"')))"); 
//SE ELIMINA EL ELEMENTO POR ID
//LA IDEA ES CREAR UN COMBOBOX EN LA APLICACION Y QUE EL USUARIO AL PICKEAR LA TIENDA APAREZCA EN UN RECUADRO LOS PRODUCTOS 
//REGISTRADOS EN ESA TIENDA. LUEGO EL USUARIO DEBERA SELECCIONAR EL PRODUCTO QUE QUIERA ELIMINAR
//CUANDO SELECCIONE EL PRODUCTO QUE QUIERE ELIMINAR SE LE PASA EL ID DE ESE PRODUCTO AL DELETE

            int z = s.executeUpdate("delete from producto where pro_nombre='"+nombre+"' and pro_fk_rubro=(select rub_codigo from rubro where rub_nombre='"+rubro+"' and rub_fk_almacen=(select alm_codigo from almacen where alm_nombre='"+almacen+"' and alm_fk_tienda=(select tie_codigro from tienda where tie_nombre='"+tienda+"'))))");
            
            
            
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
    public static boolean ActualizarProducto (String nombre,String nombrenuevo, String descripcion,String tienda, String almacen, String rubro){
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
        //    int z = s.executeUpdate("insert into producto (pro_nombre,pro_descripcion,pro_fk_rubro,pro_fk_marca) values ('"+nombre+"','"+descripcion+"',(select rub_codigo FROM rubro where rub_nombre='"+rubro+"' and rub_fk_almacen=(select alm_codigo from almacen where alm_nombre= '"+almacen+"'and alm_fk_tienda=(SELECT tie_codigo FROM tienda where tie_nombre = '"+tienda+"'))),(select mar_codigo from marca where mar_nombre='"+marca+"'))");           // int z = s.executeUpdate("insert into tienda (tie_codigo,tie_nombre,tie_fecha,tie_valorpuntos,tie_fk_lugar) values (nextval('tienda_tie_codigo_seq'::regclass),'"+nombre+"','"+fecha+"',"+valorNro+","+lugar+")");

            int z = s.executeUpdate("update producto set pro_nombre='"+nombrenuevo+"', pro_descripcion='"+descripcion+"' where pro_nombre='"+nombre+"' and pro_fk_rubro=(select rub_codigo from rubro where rub_nombre='"+rubro+"' and rub_fk_almacen=(select alm_codigo from almacen where alm_nombre='"+almacen+"' and alm_fk_tienda=(select tie_codigro from tienda where tie_nombre='"+tienda+"'))))");
            
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
    public static ArrayList<String> ConsultarProducto (String nombre, String almacen, String rubro, String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select pro_codigo, pro_nombre, pro_descripcion where pro_nombre='"+nombre+"' and pro_fk_rubro=(select rub_codigo from rubro where rub_nombre='"+rubro+"' and rub_fk_almacen=(select alm_codigo from almacen where alm_nombre='"+almacen+"' and alm_fk_tienda=(select tie_codigro from tienda where tie_nombre='"+tienda+"'))))");
            
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
    
    public static ArrayList<String> BuscarProducto (String nombre, String rubro, String almacen, String tienda){
        ArrayList<String> tiendas= new ArrayList();
        java.sql.Connection connection = null;
        ResultSet rs = null;
        Statement s = null;
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            rs = s.executeQuery("select pro_codigo, pro_nombre, pro_descripcion from producto where pro_nombre='"+nombre+"' and pro_fk_rubro=(select rub_codigo from rubro where rub_nombre='"+rubro+"' and rub_fk_almacen=(select alm_codigo from almacen where alm_nombre='"+almacen+"' and alm_fk_tienda=(select tie_codigro from tienda where tie_nombre='"+tienda+"'))) limit 10");
            
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
