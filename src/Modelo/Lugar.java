/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class Lugar {
    private String codigo;
    private String nombre;
    private String tipo;
    private String lugar;
    public static ArrayList<Lugar> lugarList= new ArrayList<Lugar>();
    
    public Lugar(){
    }
    public Lugar(String codigo,String nombre,String tipo, String lugar){
        this.codigo= codigo;
        this.nombre=nombre;
        this.tipo=tipo;
        this.lugar=lugar;
    }
    
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public void mostarar(){
        System.out.println("Codigo: "+this.codigo);
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Tipo: "+this.tipo);
        System.out.println("FK: "+this.lugar);
    }
    
    public static Lugar getLugarNombre(String nombreLugar){
        Lugar lug= new Lugar ();
           for (int i = 0; i < lugarList.size(); i++) {
           
            if(!lugarList.isEmpty()){
                if(lugarList.get(i).getNombre().equals(nombreLugar)){
                    return lugarList.get(i);
                }
                
            }else {System.out.println("Lista Vacia getLugarNombre");}
        }//
           return lug ;
    }
    
    
    
    public static void getLugarTipo(String tipoLugar,JComboBox combo){
           for (int i = 0; i < lugarList.size(); i++) {
           
            if(!lugarList.isEmpty()){
                if(lugarList.get(i).getTipo().equals(tipoLugar)){
                    combo.addItem(lugarList.get(i).nombre);
                    
                }
                
            }else {System.out.println("Lista Vacia getLugarTipo");}
        }
    }
    
    public static void getLugarFK(String fkLugar,JComboBox combo){
           for (int i = 0; i < lugarList.size(); i++) {
           
            if(!lugarList.isEmpty()){
                
                     if(lugarList.get(i).getCodigo().equals(fkLugar)){
                    combo.addItem(lugarList.get(i).nombre);
                }
               

                
            }else {System.out.println("Lista Vacia get LugarFK");}
        }
    }
    
    public static String lugarFK(String fkLugar){
        String nombre="";
        for (int i = 0; i < lugarList.size(); i++) {
           
            if(!lugarList.isEmpty()){
                
                     if(lugarList.get(i).getCodigo().equals(fkLugar)){
                        nombre=lugarList.get(i).getNombre();
                }
               

                
            }else {System.out.println("Lista Vacia get LugarFK");}
        }
        return nombre;
    }
    
    public static void llenarLugares(){
        
        try {
            
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
       
        String sql;
            sql = "SELECT * FROM lugar"; //Consulta
         ResultSet rs =PrincipalModel.getStm().executeQuery(sql);
        while (rs.next()) { 
            String lug_codigo = rs.getString("lug_codigo");
                 String lug_nombre = rs.getString("lug_nombre");
                 String lug_tipo = rs.getString("lug_tipo");
                 String lug_fk_lugar = rs.getString("lug_fk_lugar");
                 
                 Lugar lugar = new Lugar (lug_codigo,lug_nombre,lug_tipo,lug_fk_lugar );
                 lugarList.add(lugar);
                 
        }
        
        rs.close();
        PrincipalModel.getStm().close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }catch(Exception e){
            //Handle errors for Class.forName
             System.out.println("Error");
            e.printStackTrace();
        }
    
    }
   
    
    
}
