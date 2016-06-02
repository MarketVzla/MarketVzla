/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author migue
 */
public class ExpresionesRegulares {
    
    private static boolean value;
    
   
    
    public static boolean validarCorreo(String correo){
        Pattern pat = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$");
     Matcher mat = pat.matcher(correo);
     
        if (mat.matches()) {
         
          value=true;
        } else value =false;
    
    return value;
    }
    public static boolean validarWeb(String web){
        Pattern pat = Pattern.compile("^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\?=.-]*)*\\/?$");
     Matcher mat = pat.matcher(web);
        if (mat.matches()) {
         
          value=true;
        } else value =false;
    
    return value;
    }
    
    public static  boolean validarNombre(String nombre){
        Pattern pat = Pattern.compile("[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?(( |\\-)[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?)*");
     Matcher mat = pat.matcher(nombre);
        if (mat.matches()) {
            
          value=true;
        } else  { value =false;}
    
    return value;
    }
    
     public static boolean validarTelefono(String nombre){
       //^[0-9]{2,3}-? ?[0-9]{6,7}$
         Pattern pat = Pattern.compile("^\\+?\\d{1,3}?[- .]?\\(?(?:\\d{2,3})\\)?[- .]?\\d\\d\\d[- .]?\\d\\d\\d\\d$");
     Matcher mat = pat.matcher(nombre);
        if (mat.matches()) {
            
          value=true;
        } else value =false;
    
    return value;
    }
     
          public static boolean validarRIF(String nombre){
        Pattern pat = Pattern.compile("^[JN]{1}[-][1-9][^\\.][1-9]$");
     Matcher mat = pat.matcher(nombre);
        if (mat.matches()) {
            System.out.println("El RIF si lo valida");
          value=true;
        } else value =false;
    
    return value;
    }
        public static boolean validarNumero(String nombre){
        Pattern pat = Pattern.compile("^(?:\\+|-)?\\d+$");
     Matcher mat = pat.matcher(nombre);
        if (mat.matches()) {
            
          value=true;
        } else value =false;
    
    return value;
    }
             public static boolean validarCedula(String nombre){
        Pattern pat = Pattern.compile("^([VEJG]\\d{7,8})$");
     Matcher mat = pat.matcher(nombre);
        if (mat.matches()) {
            
          value=true;
        } else value =false;
    
    return value;
    }
             
             //ValidaFecha
             

   public static boolean verificarFecha(JDateChooser dchCalendario){
        Date dat=new Date();//Instancia la fecha del sistema
        if(dchCalendario.getDate().getTime()<=dat.getTime()){//Compara si la fecha seleccionada es mayor o igual a la fecha actual
            return true;
        }
        return false;
    }

 
}
