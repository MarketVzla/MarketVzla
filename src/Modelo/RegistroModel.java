/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Controlador.RegistroClienteController;

/**
 *
 * @author migue
 */
public class RegistroModel {
    private static boolean value;
   
    public static int codigoMax (String tabla,String codigoNombre) {
       int cod = 0;
        try{
        PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
       
        String sqlSelect;
            sqlSelect = "SELECT "+codigoNombre+" FROM "+tabla+" WHERE "+codigoNombre+"=( SELECT max("+codigoNombre+") FROM "+tabla+")";//"SELECT * from "+tabla+" ;"; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sqlSelect);
            
             while (rs.next()) {  
                 System.out.println("CODIGO MAX: "+rs.getInt(""+codigoNombre+""));
                 cod = rs.getInt(""+codigoNombre+"");
             }
            cod++;
            rs.close();
            PrincipalModel.getStm().close();
            
      }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
      }
    return cod;
    }
    public static boolean insertJuridico (String cli_correo,int cli_puntos,String jur_rif,String jur_denominacioncomercial, 
            String jur_razonsocial,String jur_paginaweb,String jur_capitaldisponible, 
            int cli_fk_lugar_fisica,int jur_fk_lugar_fiscal,
            String nick,
            String pass,String pregunta,String respuesta){
       
        
        
        int cod= codigoMax ("juridico","cli_codigo");
        
        
        
        try {
            RegistroModel.setValue(true);
            
 
            
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
       
           
             String sqlRol;
                sqlRol = "SELECT * FROM rol_per where rp_nick = '"+nick+"';";
            
                ResultSet rs =PrincipalModel.getStm().executeQuery(sqlRol);
           
                
             
            
           if(rs.next()){
               System.out.println("Usuario Repetido");
               RegistroModel.setValue(false);
           }else{ 
              PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "INSERT INTO juridico(cli_codigo, cli_correo, cli_puntos, jur_rif, jur_denominacioncomercial,"+
            "jur_razonsocial, jur_paginaweb, jur_capitaldisponible, cli_fk_tienda,"+
            "cli_fk_lugar_fisica, jur_fk_lugar_fiscal) "+
            " VALUES ("+cod+","+"'"+cli_correo+"'"+","
                                    + ""+cli_puntos+","+"'"+jur_rif+"'"+","
                                    + ""+"'"+jur_denominacioncomercial+"'"+","
                                    + ""+"'"+jur_razonsocial+"'"+","
                                    + " "+"'"+jur_paginaweb+"'"+","
                                    + ""+"'"+jur_capitaldisponible+"'"+", "
                                    + ""+0+","+cli_fk_lugar_fisica+", "
                                    + ""+jur_fk_lugar_fiscal+");"; //Consulta
             PrincipalModel.getStm().executeUpdate(sql);
             System.out.println("Inserted records into the table...");
             
              
              RegistroModel.setValue(true);
           }
                      
                            
            //int rp_fk_rol,int rp_fk_permiso,int rp_fk_empleado/*,String rp_fk_juridico*/,int rp_fk_natural
            
            
            PrincipalModel.getStm().close();
        
            
          
           
        } catch (SQLException ex) {
           
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            RegistroModel.setValue(false);
        } catch (Exception e) {
        }
         if(RegistroModel.isValue()){
          int rp_fk_rol=0;
            int rp_fk_permiso=0;
            int rp_fk_empleado=-1;
            int rp_fk_natural=-1;
            
        isertRolPer(nick,pass,pregunta,respuesta,rp_fk_rol,rp_fk_permiso,rp_fk_empleado,cod,rp_fk_natural);
       }
       return RegistroModel.isValue();
     }
    
    public static void isertRolPer(String nick,
            String pass,String pregunta,String respuesta,
            int rp_fk_rol,int rp_fk_permiso,int rp_fk_empleado,int rp_fk_juridico,int rp_fk_natural) 
            {
       
       try{
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
       
        String sqlSelect;
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
       
            String sql;
                sql = "INSERT INTO rol_per( rp_nick, rp_contraseña, rp_preguntasecreta, rp_respuestasecreta,"+ 
            "rp_fk_rol, rp_fk_permiso, rp_fk_empleado, rp_fk_juridico, rp_fk_natural)"
                        + " VALUES ( "+"'"+nick+"'"+", "+"'"+pass+"'"+" "+
                        ", "+"'"+pregunta+"'"+","+"'"+respuesta+"'"+","+rp_fk_rol+" "+
                        ", "+rp_fk_permiso+", "+rp_fk_empleado+", "+rp_fk_juridico+", "+rp_fk_natural+");" ;//Consulta
            
           
            
            
            
            PrincipalModel.getStm().executeUpdate(sql);
            System.out.println("Inserted records into the table...");
            PrincipalModel.getStm().close();

            
            } catch (SQLException ex) {



                 JOptionPane.showMessageDialog(null, ex.getMessage());

             } catch (Exception e) {
             }
        }
    
    public static boolean insertNatural(String cli_correo, int cli_puntos,String nat_cedula,String nat_rif, 
            String nat_primernombre,String nat_segundonombre,String nat_primerapellido,
            String nat_segundoapellido,int cli_fk_tienda,int cli_fk_lugar,
            String nick,
            String pass,String pregunta,String respuesta
            ){
      String natural ="\"natural\""; 
        int cod= codigoMax ( " "+natural+" " ,"cli_codigo");
        
       try {
            RegistroModel.setValue(true);
            
 
            
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
       
           
             String sqlRol;
                sqlRol = "SELECT * FROM rol_per where rp_nick = '"+nick+"';";
            
                ResultSet rs =PrincipalModel.getStm().executeQuery(sqlRol);
           
                
             
            
           if(rs.next()){
               System.out.println("Usuario Repetido");
               RegistroModel.setValue(false);
           }else{ 
           
              
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
       
            String sql;
                sql = " INSERT INTO   "+ natural +" (cli_codigo, cli_correo, cli_puntos, nat_cedula, nat_rif, nat_primernombre, \n" +
"       nat_segundonombre, nat_primerapellido, nat_segundoapellido, cli_fk_tienda, \n" +
"       cli_fk_lugar) "
                        + " VALUES ("+cod+",'"+cli_correo+"',"+cli_puntos+",'"+nat_cedula+"','"+nat_rif+"','"+nat_primernombre+"',"+
                       " '"+nat_segundonombre+"', '"+nat_primerapellido+"',"
                       +" '"+nat_segundoapellido+"', "+cli_fk_tienda+","+cli_fk_lugar+") ;"; //Consulta
             
          PrincipalModel.getStm().executeUpdate(sql);
             RegistroModel.setValue(true);
           
           }
            
            PrincipalModel.getStm().close();
              
            
             
        } catch (SQLException ex) {
            RegistroModel.setValue(false);  
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Error en natural: "+ex.getMessage().toString());
        } catch (Exception e) {
        }
              
       if(RegistroModel.isValue()){
          int rp_fk_rol=0;
            int rp_fk_permiso=0;
            int rp_fk_empleado=-1;
            int rp_fk_juridico=-1;
            
        isertRolPer(nick,pass,pregunta,respuesta,rp_fk_rol,rp_fk_permiso,rp_fk_empleado,rp_fk_juridico,cod);
       }
        return RegistroModel.isValue();
    }

    /**
     * @return the value
     */
    public static boolean isValue() {
        return value;
    }

    /**
     * @param aValue the value to set
     */
    public static void setValue(boolean aValue) {
        value = aValue;
    }

   
   

   
}
