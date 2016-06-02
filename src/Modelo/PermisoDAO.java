/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class PermisoDAO {
    //PRIVILEGIOS -PERMISOS 
    public String insertarDatosPermiso(String per_nombre,String per_descripcion){
        String value="";
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "INSERT INTO permiso (per_nombre,per_descripcion) "+
            " VALUES ('"+per_nombre+"','"+per_descripcion+"');"; //Consulta
                            
            int registroExitoso =PrincipalModel.getStm().executeUpdate(sql);
            
            if(registroExitoso >0 ){
                System.out.println("Inserted records into the table...");
                value="Registro Exitoso";
            }
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            value="";
        } catch (Exception e) {
        }
        
        return value;
    }
    
    public ArrayList <Permiso> listPermiso(){
        ArrayList listaPermiso = new ArrayList();
        Permiso permiso;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
                sql = "SELECT * FROM permiso"; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                           permiso = new Permiso();
                    permiso.setCondigoPermiso(rs.getString("per_codigo"));  
                    permiso.setNombrePermiso(rs.getString("per_nombre"));
                    permiso.setDescripcionPermiso(rs.getString("per_descripcion"));                         
                           listaPermiso.add(permiso);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaPermiso;
    }
    
    public ArrayList <Permiso> listPermisoXNOmbre(String per_nombre){
        ArrayList listaPermiso = new ArrayList();
        Permiso permiso;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
                sql = "SELECT * FROM permiso WHERE per_nombre LIKE '"+per_nombre+"%';"; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                           permiso = new Permiso();
                    permiso.setCondigoPermiso(rs.getString("per_codigo"));  
                    permiso.setNombrePermiso(rs.getString("per_nombre"));
                    permiso.setDescripcionPermiso(rs.getString("per_descripcion"));                         
                           listaPermiso.add(permiso);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaPermiso;
    }
    public int actualizarDatosPermiso(String per_nombre,String per_descripcion,int per_codigo){
        int value=0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "UPDATE permiso " +
                   "SET per_nombre = '"+per_nombre+"', per_descripcion='"+per_descripcion+"' WHERE per_codigo= '"+per_codigo+"' "; //Consulta
                            
            value=PrincipalModel.getStm().executeUpdate(sql);
            
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            
        } catch (Exception e) {
        }
        
        return value;
    }
    
     public int eliminarDatosPermiso(String per_nombre){
        int value=0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                             sql = "DELETE FROM rol_per " +
                   "WHERE rp_fk_permiso  = "+per_nombre+" ;"; //Consulta
                            
            PrincipalModel.getStm().executeUpdate(sql);
                            sql = "DELETE FROM permiso " +
                   "WHERE per_codigo  = "+per_nombre+" "; //Consulta
                            
            value=PrincipalModel.getStm().executeUpdate(sql);
            
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            
        } catch (Exception e) {
        }
        
        return value;
    }
     
     //PRIVILEGIOS -ROLES
    public String insertarDatosRol(String rol_nombre,String rol_descripcion){
        String value="";
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "INSERT INTO rol (rol_nombre,rol_descripcion) "+
            " VALUES ('"+rol_nombre+"','"+rol_descripcion+"');"; //Consulta
                            
            int registroExitoso =PrincipalModel.getStm().executeUpdate(sql);
            
            if(registroExitoso >0 ){
                System.out.println("Inserted records into the table...");
                value="Registro Exitoso";
            }
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            value="";
        } catch (Exception e) {
        }
        
        return value;
    }
    
    public ArrayList <Rol> listRol(){
        ArrayList listaRol = new ArrayList();
        Rol rol;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
                sql = "SELECT * FROM rol;"; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                           rol= new Rol();
                    rol.setCondigoRol(rs.getString("rol_codigo"));  
                    rol.setNombreRol(rs.getString("rol_nombre"));
                   rol.setDescripcionRol(rs.getString("rol_descripcion"));                         
                           listaRol.add(rol);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaRol;
    }
    
    public ArrayList <Rol> listRolXNOmbre(String rol_nombre){
        ArrayList listaRol = new ArrayList();
        Rol rol;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
                sql = "SELECT * FROM rol WHERE rol_nombre LIKE '"+rol_nombre+"%' ;"; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                           rol = new Rol();
                    rol.setCondigoRol(rs.getString("rol_codigo"));  
                    rol.setNombreRol(rs.getString("rol_nombre"));
                    rol.setDescripcionRol(rs.getString("rol_descripcion"));                         
                           listaRol.add(rol);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaRol;
    }
    public int actualizarDatosRol(String rol_nombre,String rol_descripcion,int rol_codigo){
        int value=0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "UPDATE rol " +
                   "SET rol_nombre = '"+rol_nombre+"', rol_descripcion='"+rol_descripcion+"' WHERE rol_codigo= '"+rol_codigo+"' ;"; //Consulta
                            
            value=PrincipalModel.getStm().executeUpdate(sql);
            
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            
        } catch (Exception e) {
        }
        
        return value;
    }
    
     public int eliminarDatosRol (String rol_nombre){
        int value=0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                          sql = "DELETE FROM rol_per " +
                   "WHERE rp_fk_rol = "+rol_nombre+" ;"; //Consulta
                            
            PrincipalModel.getStm().executeUpdate(sql);
            
                            sql = "DELETE FROM rol " +
                   "WHERE rol_codigo  = "+rol_nombre+" ;"; //Consulta
                            
            value=PrincipalModel.getStm().executeUpdate(sql);
            
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            
        } catch (Exception e) {
        }
        
        return value;
    }
      //Empleados -BENEFICIOS
    public String insertarDatosEmpleadoBeneficio(String ben_nombre,String ben_descripcion,String ben_porcentaje){
        String value="";
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "INSERT INTO beneficio (ben_nombre,ben_descripcion,ben_porcentaje) "+
            " VALUES ('"+ben_nombre+"','"+ben_descripcion+"','"+ben_porcentaje+"');"; //Consulta
                            
            int registroExitoso =PrincipalModel.getStm().executeUpdate(sql);
            
            if(registroExitoso >0 ){
                System.out.println("Inserted records into the table...");
                value="Registro Exitoso";
            }
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            value="";
        } catch (Exception e) {
        }
        
        return value;
    }
    
    public ArrayList <EmpleadoBeneficio> listEmpleadoBeneficio(){
        ArrayList listaBeneficio = new ArrayList();
        EmpleadoBeneficio beneficio;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
                sql = "SELECT * FROM beneficio;"; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                           beneficio= new EmpleadoBeneficio();
                    beneficio.setCodigoBeneficio(rs.getString("ben_codigo"));  
                    beneficio.setNombreBenefico(rs.getString("ben_nombre"));
                   beneficio.setDescripcionBeneficio(rs.getString("ben_descripcion"));
                   beneficio.setPorcentajeBeneficio(rs.getString("ben_porcentaje"));  
                           listaBeneficio .add(beneficio);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaBeneficio;
    }
    
    public ArrayList <EmpleadoBeneficio> listBeneficioXNOmbre(String ben_nombre){
        ArrayList listaBeneficio = new ArrayList();
        EmpleadoBeneficio beneficio;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
                sql = "SELECT * FROM beneficio WHERE ben_nombre LIKE '%"+ben_nombre+"%' ;"; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                             beneficio= new EmpleadoBeneficio();
                            beneficio.setCodigoBeneficio(rs.getString("ben_codigo"));  
                            beneficio.setNombreBenefico(rs.getString("ben_nombre"));
                            beneficio.setDescripcionBeneficio(rs.getString("ben_descripcion"));
                            beneficio.setPorcentajeBeneficio(rs.getString("ben_porcentaje"));  
                            listaBeneficio .add(beneficio);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaBeneficio;
    }
    public int actualizarDatosEmpleadoBeneficio(String ben_nombre,String ben_descripcion,String ben_porcentaje,int ben_codigo){
        int value=0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "UPDATE beneficio " +
                   "SET ben_nombre = '"+ben_nombre+"', ben_descripcion='"+ben_descripcion+"', ben_porcentaje='"+ben_porcentaje+"' WHERE ben_codigo= '"+ben_codigo+"' ;"; //Consulta
                            
            value=PrincipalModel.getStm().executeUpdate(sql);
            
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            
        } catch (Exception e) {
        }
        
        return value;
    }
    
     public int eliminarDatosEmpleadoBeneficio (String ben_nombre){
        int value=0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
               
                 sql = "DELETE FROM emp_ben " +
                   "WHERE eb_fk_beneficio = "+ben_nombre+" ;"; //Consulta
                            
            PrincipalModel.getStm().executeUpdate(sql);
            
                            sql = "DELETE FROM beneficio " +
                   "WHERE  ben_codigo = "+ben_nombre+" ;"; //Consulta
                            
            value=PrincipalModel.getStm().executeUpdate(sql);
            
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            
        } catch (Exception e) {
        }
        
        return value;
    }
     
         //Empleados - Horarios
    public String insertarDatosEmpleadoHorario(String hor_fechainicio,String hor_fechafin){
        String value="";
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "INSERT INTO horario (hor_fechainicio,hot_fechafin) "+
            " VALUES ('"+hor_fechainicio+"','"+hor_fechafin+"');"; //Consulta
                            
            int registroExitoso =PrincipalModel.getStm().executeUpdate(sql);
            
            if(registroExitoso >0 ){
                System.out.println("Inserted records into the table...");
                value="Registro Exitoso";
            }
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            value="";
        } catch (Exception e) {
        }
        
        return value;
    }
    
    public ArrayList <EmpleadoHorario> listEmpleadoHorario(){
        ArrayList listaHorario = new ArrayList();
        EmpleadoHorario horario;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
                sql = "SELECT * FROM horario;"; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                           horario= new EmpleadoHorario();
                    horario.setCodigoHorario(rs.getString("hor_codigo"));  
                    horario.setFechaInicioHorario(rs.getString("hor_fechainicio"));
                   horario.setFechafinHorario(rs.getString("hot_fechafin"));                         
                           listaHorario.add(horario);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaHorario;
    }
    
    public ArrayList <EmpleadoHorario> listEmpleadoHorarioXFechaInicio(String ano,String mes,String dia){
        ArrayList listaHorario = new ArrayList();
        EmpleadoHorario horario;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
               sql = "SELECT * FROM horario WHERE  (DATEPART(yy, hor_fechainicio ) = "+ano+"\n" +
"OR    DATEPART(mm, hor_fechainicio ) = "+mes+"\n" +
"OR    DATEPART(dd, hor_fechainicio ) = "+dia+") ;"; //Consulta
            
                                           /*WHERE  (DATEPART(yy, hor_codigo ) = 2009
AND    DATEPART(mm, hor_codigo ) = 10
AND    DATEPART(dd, hor_codigo ) = 10)*/
               ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                           horario= new EmpleadoHorario();
                    horario.setCodigoHorario(rs.getString("hor_codigo"));  
                    horario.setFechaInicioHorario(rs.getString("hor_fechainicio"));
                   horario.setFechafinHorario(rs.getString("hot_fechafin"));                         
                           listaHorario.add(horario);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaHorario;
    }
    public int actualizarDatosEmpleadoHorario(String hor_fechainicio,String hor_fechafin,int hor_codigo){
        int value=0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "UPDATE horario " +
                   "SET hor_fechainicio = '"+hor_fechainicio+"', hot_fechafin='"+hor_fechafin+"' WHERE hor_codigo= '"+hor_codigo+"' ;"; //Consulta
                            
            value=PrincipalModel.getStm().executeUpdate(sql);
            
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            
        } catch (Exception e) {
        }
        
        return value;
    }
    
     public int eliminarDatosEmpleadoHorario (String hor_codigo){
        int value=0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
            
            String sql;
            sql = "DELETE FROM emp_hor " +
                   " WHERE eh_fk_horario = '"+hor_codigo+"' ;"; //Consulta
                    PrincipalModel.getStm().executeUpdate(sql);
           
               
                            sql = "DELETE FROM horario " +
                   " WHERE hor_codigo = '"+hor_codigo+"' ;"; //Consulta

            value=PrincipalModel.getStm().executeUpdate(sql);
            
              
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            
        } catch (Exception e) {
        }
        
        return value;
    }
     
     //EMPLEADOS
     public int insertEmpleados(String cedulaEmpleado,String primerNOmbreEmpleado,String segundoNombreEmpleado,
             String primerApellidoEmpleado, String segundoApellidoEmpleado,
             String salarioEmpleado,String diasVacacionesEmpleado,
                String fechaNacimientoEmpleado, 
              /*Rol_PER*/  String usurarioRolPer,
                String contrasenaRolPer,
                String preguntaSecretaRolPer,
                String respuestaSecretaRolPer,
                String rol,
                String permiso,
                String beneficio,
                String horario){
         int value=0;
         
         try {
               PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "INSERT INTO empleado (emp_ci,emp_primernombre,"
                                    + "emp_segundonombre, emp_primerapellido,"
                                    + "emp_segundoapellido,emp_salario,emp_diasvacaciones,"
                                    + "emp_fechanacimiento) "+
            " VALUES ('"+cedulaEmpleado+"','"+primerNOmbreEmpleado+"',"
                                    + " '"+segundoNombreEmpleado+"','"+primerApellidoEmpleado+"'"
                                    + ", '"+segundoApellidoEmpleado+"',"
                                    + " "+salarioEmpleado+","+diasVacacionesEmpleado+" ,"
                                    + " '"+fechaNacimientoEmpleado+"' );"; //Consulta
                            
            int registroExitoso =PrincipalModel.getStm().executeUpdate(sql);
            
            if(registroExitoso >0 ){
                System.out.println("Inserted records into the table EMPLEADO...");
               //ROL_PER 
                PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sqlRol_Per;
                            sqlRol_Per = "INSERT INTO rol_per( rp_nick, rp_contraseña, rp_preguntasecreta, rp_respuestasecreta,"+ 
            "rp_fk_rol, rp_fk_permiso, rp_fk_empleado) "+
                    " VALUES ('"+usurarioRolPer+"','"+contrasenaRolPer+"',"
                                    + " '"+preguntaSecretaRolPer+"','"+respuestaSecretaRolPer+"'"
                                    + ", "+rol+","
                                    + " "+permiso+",'"+cedulaEmpleado+"'"
                                    + "  );"; //Consulta
                            
                int registroExitosoRolper =PrincipalModel.getStm().executeUpdate(sqlRol_Per);
                
               
                
                  System.out.println("Inserted records into the table ROL_PER..");
                //Horario
                PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sqlHorario;
                            sqlHorario = "INSERT INTO emp_hor( eh_fk_horario, eh_fk_empleado) "+
                    " VALUES ("+horario+",'"+cedulaEmpleado+"');"; //Consulta
                            
                int registroExitosoHorario =PrincipalModel.getStm().executeUpdate(sqlHorario);
                System.out.println("Inserted records into the table EMP_HOR..");
                
                 //BENEFICIO
                 Calendar c = Calendar.getInstance();
                
                   String dia = Integer.toString(c.get(Calendar.DATE));
                   int   mes = c.get(Calendar.MONTH)+1;
                   String  annio = Integer.toString(c.get(Calendar.YEAR));
                   
                   String fechaActual = annio+"-"+mes+"-"+dia;
                PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sqlEmpBen;
                            sqlEmpBen = "INSERT INTO emp_ben ( eb_fecha, eb_fk_empleado, eb_fk_beneficio) "+
                    " VALUES ('"+fechaActual+"','"+cedulaEmpleado+"',"+beneficio+");"; //Consulta
                            
                int registroExitosoBeneficio=PrincipalModel.getStm().executeUpdate(sqlEmpBen);
                System.out.println("Inserted records into the table EMP_BEN..");
                 
                if((registroExitosoRolper>0 && registroExitosoHorario>0 && registroExitosoBeneficio>0)){
                    value=1;
                }
            }
            
            PrincipalModel.getStm().close();
             
             
         } catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
         }
         
       
         return value;         
     }
}
