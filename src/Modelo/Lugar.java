/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class Lugar {
    
    
  public static ArrayList<String> ConsultarEstados(int pais)
    {
        ArrayList<String> tiendas= new ArrayList();
        try {
            
            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());
            
            String sql;
            sql = "select lug_codigo,lug_nombre from lugar where lug_tipo='estado' and lug_fk_lugar="+pais; //Consulta
            ResultSet rs =PrincipalModel.getStm().executeQuery(sql);
            while (rs.next()){
                tiendas.add(rs.getString(1));
                tiendas.add(rs.getString(2));
            }
            return tiendas;
        } catch (SQLException ex) {
            Logger.getLogger(Lugar.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
       
    }
   /**
     * Consultar municipio de un estado
     * @param estado
     * @return ArrayList<String> 
     */
    public static ArrayList<String> ConsultarMunicipios(int estado)
    {
        
        ArrayList<String> tiendas= new ArrayList();
        
        try {
            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());
            
            String sql;
            sql = "select lug_codigo, lug_nombre from lugar where lug_tipo='municipio' and lug_fk_lugar="+estado; //Consulta
            ResultSet rs =PrincipalModel.getStm().executeQuery(sql);
            
            
            
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
    
    /**
     * Consultar parroquias de un municipio
     * @param municipio
     * @return ArrayList<String>
     */
    public static ArrayList<String> ConsultarParroquias(int municipio)
    {
        
         ArrayList<String> tiendas= new ArrayList();
        
        try {
            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());
            
            String sql;
            sql = "select lug_codigo, lug_nombre from lugar where lug_tipo='parroquia' and lug_fk_lugar="+municipio; //Consulta
            ResultSet rs =PrincipalModel.getStm().executeQuery(sql);
            
            
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
    
    /**
     * Devuelve el nombre de la parroquia y el codigo del municipio
     * @param parroquia
     * @return ArrayLis<String>
     */
    public static ArrayList<String> ConsultarParroquia(int parroquia)
    {
        ArrayList<String> tiendas= new ArrayList();
        
        try {
            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());
            
            String sql;
            sql = "select P.lug_nombre, (select M.lug_codigo from lugar M where M.lug_codigo=P.lug_fk_lugar) from lugar P where P.lug_codigo="+parroquia; //Consulta
            ResultSet rs =PrincipalModel.getStm().executeQuery(sql);
            
          
            
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
    
    /**
     * Devuelve el nombre del municipio y el estado
     * @param municipio
     * @return ArrayLis<String>
     */
    public static ArrayList<String> ConsultarMunicipio(int municipio)
    {
        ArrayList<String> tiendas= new ArrayList();
        
        try {
            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());
            
            String sql;
            sql = "select P.lug_nombre, (select M.lug_nombre from lugar M where M.lug_codigo=P.lug_fk_lugar) from lugar P where P.lug_codigo="+municipio; //Consulta
            ResultSet rs =PrincipalModel.getStm().executeQuery(sql);
            
          

            
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
