/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class LoginModel {

 public static ArrayList<RolPermiso> usuarios = new ArrayList<RolPermiso>();

    
   
    public static void  Login (){ //Busca por nick y pass
     RolPermiso user ;
        try {
        PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
       
        String sql;
            sql = "SELECT * FROM usuario;"; //Consulta
         ResultSet rs =PrincipalModel.getStm().executeQuery(sql);
           

            
 
                
                   while (rs.next()) {   
                            
                    
                     String rp_nick = rs.getString("usu_nick");
                     String rp_contraseña = rs.getString("usu_contraseña");
                    /* String rp_preguntasecreta = rs.getString("rp_preguntasecreta");
                     String rp_respuestasecreta = rs.getString("rp_respuestasecreta");
                     int rp_fk_rol= rs.getInt("rp_fk_rol");
                     int rp_fk_permiso = rs.getInt("rp_fk_permiso");
                    int rp_fk_empleado= (rs.getInt("rp_fk_empleado"));
                     int rp_fk_juridico= (rs.getInt("rp_fk_juridico"));
                     int rp_fk_natural= ((rs.getInt("rp_fk_natural")));*/

                           user = new RolPermiso();

                                           
                         
                                               user.setRp_nick(rp_nick);
                                           user.setRp_contraseña(rp_contraseña);
                       
                       usuarios.add(user);
                       
                                           
                      
                            
                        
                    } 
           
            
            rs.close();
            PrincipalModel.getStm().close();
            /*catch(NullPointerException ex1){ 
            JOptionPane.showMessageDialog(null, ex1.getMessage());
                }*/
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Error"+ex.toString());
        }catch(Exception e){
            //Handle errors for Class.forName
             System.out.println("Error"+e.toString());
            e.printStackTrace();
        }
        
        
    }
    
    public static  int validarLog(String nick,String pass){
        int value =0;
        for (int i = 0; i <  usuarios .size(); i++) {
           
            if(! usuarios.isEmpty()){
                
                     if( usuarios.get(i).getRp_nick().equals(nick) && 
                             usuarios.get(i).getRp_contraseña().equals(pass)){
                        value=1;
                     }
               

                
            }else {System.out.println("Lista Vacia get LugarFK");}
        }
        
        return value;
    }
    
    
    public static void SalirLogin(){
        try {
            PrincipalModel.getCon().close();
            System.out.println("Se cierra Conecion con la base de datos: "
            +PrincipalModel.getNombrebd());
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
    
    
}
