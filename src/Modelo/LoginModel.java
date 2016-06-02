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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class LoginModel {



  
   
    public static void  ValidarLogin (String nick,String pass){ //Busca por nick y pass
     
        try {
        PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
       
        String sql;
            sql = "SELECT * FROM rol_per where rp_nick = '"+nick+"' and rp_contraseña='"+pass+"';"; //Consulta
         ResultSet rs =PrincipalModel.getStm().executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            
 
                
                   while (rs.next()) {   
                            System.out.println("entra");
                    String rp_codigo = rs.getString("rp_codigo");
                     String rp_nick = rs.getString("rp_nick");
                     String rp_contraseña = rs.getString("rp_contraseña");
                     String rp_preguntasecreta = rs.getString("rp_preguntasecreta");
                     String rp_respuestasecreta = rs.getString("rp_respuestasecreta");
                     int rp_fk_rol= rs.getInt("rp_fk_rol");
                     int rp_fk_permiso = rs.getInt("rp_fk_permiso");
                    int rp_fk_empleado= (rs.getInt("rp_fk_empleado"));
                     int rp_fk_juridico= (rs.getInt("rp_fk_juridico"));
                     int rp_fk_natural= ((rs.getInt("rp_fk_natural")));

                           

                                             
                         
                       
                           
                           
                       RolPermiso.iniciarRolPermiso(rp_codigo, rp_nick, rp_contraseña, rp_preguntasecreta,
                                    rp_respuestasecreta, rp_fk_rol, rp_fk_permiso,
                                    rp_fk_empleado, rp_fk_juridico, rp_fk_natural);
                       
                                           
                      
                            
                        
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
