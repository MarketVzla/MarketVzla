/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
                sql = "SELECT * FROM permiso WHERE per_nombre LIKE '%"+per_nombre+"%';"; //Consulta
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
                sql = "SELECT * FROM rol WHERE rol_nombre LIKE '%"+rol_nombre+"%' ;"; //Consulta
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
    public String insertarDatosEmp_Ben(String cedula,String ben_cod){
        String value="";
        try {
             Calendar c = Calendar.getInstance();
                
                   String dia = Integer.toString(c.get(Calendar.DATE));
                   int   mes = c.get(Calendar.MONTH)+1;
                   String  annio = Integer.toString(c.get(Calendar.YEAR));
                   
                   String fechaActual = annio+"-"+mes+"-"+dia;
                   
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "INSERT INTO emp_ben (eb_fecha,eb_fk_empleado,eb_fk_beneficio) "+
            " VALUES ('"+fechaActual +"','"+cedula+"','"+ben_cod+"');"; //Consulta
                            
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
    public String insertarDatosEmpleadoHorario(String hor_dia,String hor_horainicio, String hot_horafin){
        String value="";
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "INSERT INTO horario (hor_dia,hor_horainicio,hot_horafin) "+
            " VALUES ('"+hor_dia+"','"+hor_horainicio+"','"+hot_horafin+"');"; //Consulta
                            
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
    public String insertarDatoseEmp_hor(String cedula,String hor_cod){
        String value="";
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "INSERT INTO emp_hor (eh_fk_empleado,eh_fk_horario) "+
            " VALUES ('"+cedula+"','"+hor_cod+"');"; //Consulta
                            
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
                    horario.setDiaHorario(rs.getString("hor_dia"));
                   horario.setHorarioInicial(rs.getString("hor_horainicio")); 
                   horario.setHorarioFinal(rs.getString("hot_horafin"));
                           listaHorario.add(horario);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaHorario;
    }
    
    public ArrayList <EmpleadoHorario> listEmpleadoHorarioXFechaInicio(String dia){
        ArrayList listaHorario = new ArrayList();
        EmpleadoHorario horario;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
               sql = "SELECT * FROM horario WHERE hor_dia = '"+dia+"'  ;"; //Consulta
               ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                           horario= new EmpleadoHorario();
                   horario.setCodigoHorario(rs.getString("hor_codigo"));  
                    horario.setDiaHorario(rs.getString("hor_dia"));
                   horario.setHorarioInicial(rs.getString("hor_horainicio")); 
                  horario.setHorarioFinal(rs.getString("hot_horafin"));                     
                           listaHorario.add(horario);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaHorario;
    }
    public int actualizarDatosEmpleadoHorario(String hor_dia,String hor_horainicio, String hor_horafin,int hor_codigo){
        int value=0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;/*hor_dia,hor_horainicio,hot_horafin*/
                            sql = "UPDATE horario " +
                   "SET hor_dia = '"+hor_dia+"', hor_horainicio='"+hor_horainicio+"' , hot_horafin ='"+hor_horafin+"' WHERE hor_codigo= '"+hor_codigo+"' ;"; //Consulta
                            
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
     
     //Sistem de Control de Entradas
    
     public ArrayList <emp_hor> listEmpleadoEmp_horXCedula(String cedula){
        ArrayList listaEmp_hor = new ArrayList();
        emp_hor horario;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
               sql = "SELECT * FROM emp_hor  WHERE eh_fk_empleado  = '"+cedula+"'  ;"; //Consulta
               ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                           horario= new emp_hor ();
                    horario.setEh_codigo(rs.getString("eh_codigo"));  
                    horario.setEh_fk_horario(rs.getString("eh_fk_horario"));
                   horario.setEh_fk_empleado(rs.getString("eh_fk_empleado")); 
                                     
                           listaEmp_hor.add(horario);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaEmp_hor;
    }
     
     public String insertarDatosEmpleadoCheck(String che_fk_emp_hor,String hor_horainicio, String hot_horafin){
        String value="";
        try {
             String check ="\"check\""; 
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "INSERT INTO "+check+" (che_fk_emp_hor,che_horaentrada,che_horasalida) "+
            " VALUES ('"+che_fk_emp_hor+"','"+hor_horainicio+"','"+hot_horafin+"');"; //Consulta
                            
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
       public ArrayList <Check> listEmpleadoCheck(String cedula){
        ArrayList  listaCheck= new ArrayList();
       Check check;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
                sql = "select emp_ci, emp_primernombre || ' , ' || emp_primerapellido as nombre_apellido,che_codigo, che_horaentrada,che_horasalida \n" +
                        "from \"check\",emp_hor,empleado "
                        + "where  emp_ci = '"+cedula+"' and eh_fk_empleado='"+cedula+"'  and che_fk_emp_hor=eh_codigo; "; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                        check = new  Check();
                        check.setChekcod(rs.getString("che_codigo"));
                        check.setEmp_ci(rs.getString("emp_ci"));
                        check.setNombre_apellido(rs.getString("nombre_apellido"));
                        check.setChe_horaentrada(rs.getString("che_horaentrada"));
                        check.setChe_horasalida(rs.getString("che_horasalida"));
                      
                           listaCheck.add( check);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaCheck ;
    }
        public int actualizarDatosEmpleadoCheck(String hor_horainicio, String hor_horafin,int hor_codigo){
        int value=0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;/*hor_dia,hor_horainicio,hot_horafin*/
                            sql = "UPDATE \"check\" " +
                   "SET che_horaentrada = '"+hor_horainicio+"', che_horasalida='"+hor_horafin+"'  WHERE che_codigo = '"+hor_codigo+"' ;"; //Consulta
                            
            value=PrincipalModel.getStm().executeUpdate(sql);
            
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            
        } catch (Exception e) {
        }
        
        return value;
    }
       public int eliminarDatosCheck (String hor_codigo){
        int value=0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
            
            String sql;
            sql = "DELETE FROM \"check\" " +
                   " WHERE che_codigo= '"+hor_codigo+"' ;"; //Consulta
                    PrincipalModel.getStm().executeUpdate(sql);
           
               
                       

            value=PrincipalModel.getStm().executeUpdate(sql);
            
              
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            
        } catch (Exception e) {
        }
        
        return value;
       }
     //Departamentos

        public ArrayList <Tienda> listEmpleadoTiendas(){
        ArrayList  listaTienda = new ArrayList();
       Tienda tienda;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
                sql = "select dep_codigo,dep_nombre, dep_descripcion,tie_nombre from tienda,departamento" +
" where dep_fk_tienda= tie_codigo " +
" order by dep_fk_tienda ;"; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                        tienda = new  Tienda();
                        tienda.setCodigo(rs.getString("dep_codigo"));
                        tienda.setNombreDepartamento(rs.getString("dep_nombre"));
                        tienda.setDescripcion(rs.getString("dep_descripcion"));
                        tienda.setNombreTeinda(rs.getString("tie_nombre"));
                    
                        
                    
                           listaTienda .add(tienda);      
                  
                   } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaTienda ;
    }
    
   public ArrayList <Tienda> listEmpleadoTiendaXNOmbre(String nombre){
        ArrayList  listaTienda = new ArrayList();
       Tienda tienda;
          try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
                sql = "select dep_codigo,dep_nombre, dep_descripcion,tie_nombre  from tienda,departamento " +
"where dep_fk_tienda = tie_codigo and tie_nombre  LIKE '"+nombre+"%' " +
";"; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                        tienda = new  Tienda();
                        tienda.setCodigo(rs.getString("dep_codigo"));
                        tienda.setNombreDepartamento(rs.getString("dep_nombre"));
                        tienda.setDescripcion(rs.getString("dep_descripcion"));
                        tienda.setNombreTeinda(rs.getString("tie_nombre"));
                    
                        
                    
                           listaTienda .add(tienda);      
                  
                   } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaTienda ;
    }
    
     //EMPLEADOS
     public int insertEmpleados(String cedulaEmpleado,String primerNOmbreEmpleado,String segundoNombreEmpleado,
             String primerApellidoEmpleado, String segundoApellidoEmpleado,
             String salarioEmpleado,
                String fechaNacimientoEmpleado,String telefono,
                /*Teinda*/ String fk_tienda ,
             /* Rol_PER*/  String usurarioRolPer,
                String contrasenaRolPer,
                String preguntaSecretaRolPer,
                String respuestaSecretaRolPer,
                String rol,
                String permiso
              /*  String beneficio,
                String horario*/){
         int value=0;
         
         try {
               PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "INSERT INTO empleado (emp_ci,emp_primernombre,"
                                    + "emp_segundonombre, emp_primerapellido,"
                                    + "emp_segundoapellido,emp_salario,"
                                    + "emp_fechanacimiento) "+
            " VALUES ('"+cedulaEmpleado+"','"+primerNOmbreEmpleado+"',"
                                    + " '"+segundoNombreEmpleado+"','"+primerApellidoEmpleado+"'"
                                    + ", '"+segundoApellidoEmpleado+"',"
                                    + " "+salarioEmpleado+" ,"
                                    + " '"+fechaNacimientoEmpleado+"' );"; //Consulta
                            
            int registroExitoso =PrincipalModel.getStm().executeUpdate(sql);
            
            if(registroExitoso >0 ){
                System.out.println("Inserted records into the table EMPLEADO...");
               PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql01;
                            sql = "INSERT INTO telefono (tel_descripcion,tel_numero,"
                                    + "tel_fk_empleado) "+
            " VALUES ('Telefono personal','"+telefono+"',"
                                    + " '"+cedulaEmpleado+"' );"; //Consulta
                            
            PrincipalModel.getStm().executeUpdate(sql);
            



                //ROL_PER 
                PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sqlRol_Per;
                            sqlRol_Per = "INSERT INTO usuario( usu_nick, usu_contraseña,usu_preguntasecreta, usu_respuestasecreta ,"+ 
            "usu_fk_empleado) "+
                    " VALUES ('"+usurarioRolPer+"','"+contrasenaRolPer+"',"
                                    + " '"+preguntaSecretaRolPer+"','"+respuestaSecretaRolPer+"'"
                                    + ", '"+cedulaEmpleado+"'"
                                    + "  );"; //Consulta
                            
                int registroExitosoRolper =PrincipalModel.getStm().executeUpdate(sqlRol_Per);
                
               
                
                  System.out.println("Inserted records into the table ROL_PER..");
               /* //Horario
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
                }*/
              
              //Tienda
              Calendar c = Calendar.getInstance();
                
                   String dia = Integer.toString(c.get(Calendar.DATE));
                   int   mes = c.get(Calendar.MONTH)+1;
                   String  annio = Integer.toString(c.get(Calendar.YEAR));
                   
                   String fechaActual = annio+"-"+mes+"-"+dia;
                PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sqlTienda;
                            sqlTienda = "INSERT INTO dep_emp(de_fechaincorporacion,de_fk_departamento ,de_fk_empleado) "+
                    " VALUES ('"+fechaActual+"',"+fk_tienda+",'"+cedulaEmpleado+"');"; //Consulta
                            
                int registroExitosoTeinda=PrincipalModel.getStm().executeUpdate(sqlTienda);
                System.out.println("Inserted records into the table TEMP_EMP..");
                 
                if(registroExitosoTeinda>0 && registroExitosoRolper>0){
                    PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String Rol_Per;
                            Rol_Per = "INSERT INTO rol_per( rp_fk_rol, rp_fk_permiso,rp_fk_usuario) "+
                    " VALUES ("+rol+","+permiso+","
                                    + " '"+usurarioRolPer+"');"; //Consulta
                           
                int registroRolper =PrincipalModel.getStm().executeUpdate(Rol_Per);
                    if(registroRolper >0){


                      System.out.println("Inserted records into the table ROL_PER..");
                        value=1;
                    }
                }
              
            }
            
            PrincipalModel.getStm().close();
             
             
         } catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
         }
         
       
         return value;         
     }
     //CUANDO LE DA A la TABLA DE TIENDAS EN EMPLEADOS
 public ArrayList <Empleados> ListarEmpleadosPorTienda(String fk_tienda){
        ArrayList  listaEmpleado = new ArrayList();
       Empleados emp;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());
/*WHERE emp_ci = (select te_fk_empleado  from tie_emp where te_fk_tienda = "+fk_tienda+")*/
            String sql;
               /* sql = "SELECT emp_ci,emp_primernombre,emp_primerapellido,emp_salario,emp_fechanacimiento,"
                        + "te_fechaincorporacion,te_fk_tienda,"
                        + "tie_nombre"
                        + "  FROM empleado, tie_emp,tienda  WHERE te_fk_tienda = "+fk_tienda+" and te_fk_empleado = emp_ci and tie_codigo = te_fk_tienda ;"; //Consulta
               */sql = "select de_fechaincorporacion,dep_nombre ,emp_ci,emp_primernombre,emp_primerapellido,emp_salario,emp_fechanacimiento" +
" from empleado,dep_emp,departamento" +
" where de_fk_departamento="+fk_tienda+" and dep_codigo="+fk_tienda+" and de_fk_empleado = emp_ci ;";
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                        emp= new  Empleados();
                        emp.setCedulaEmpleado(rs.getString("emp_ci"));
                        emp.setPrimerNombreEmpleado(rs.getString("emp_primernombre"));
                        emp.setPrimerApellidoEmpleado(rs.getString("emp_primerapellido"));
                        emp.setSalarioEMpleado(rs.getString("emp_salario"));
                       emp.setFechaNacimientoEMpleado(rs.getString("emp_fechanacimiento"));
                       emp.setFechaIngreso(rs.getString("de_fechaincorporacion"));
                       emp.setTienda(rs.getString("dep_nombre"));
                       
                       listaEmpleado.add(emp);
                   }
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaEmpleado;
  }
 public ArrayList <Empleados> ListarEmpleados(String cedula){
          ArrayList  listaEmpleado = new ArrayList();
       Empleados emp;
           /* try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());
/*WHERE emp_ci = (select te_fk_empleado  from tie_emp where te_fk_tienda = "+fk_tienda+")*/
            /*String sql;
                /*sql = "SELECT emp_ci,emp_primernombre,emp_primerapellido,emp_salario,emp_fechanacimiento,"
                        + "te_fechaincorporacion,te_fk_tienda,"
                        + "tie_nombre"
                        + "  FROM empleado, tie_emp,tienda  WHERE te_fk_empleado LIKE '"+cedula+"%' and te_fk_empleado = emp_ci and tie_codigo = te_fk_tienda ;"; //Consulta
               /* sql = "SELECT *"
                        + "  FROM empleado;";*/
              /*  sql="";
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                        emp= new  Empleados();
                        emp.setCedulaEmpleado(rs.getString("emp_ci"));
                        emp.setPrimerNombreEmpleado(rs.getString("emp_primernombre"));
                        emp.setPrimerApellidoEmpleado(rs.getString("emp_primerapellido"));
                        emp.setSalarioEMpleado(rs.getString("emp_salario"));
                       emp.setFechaNacimientoEMpleado(rs.getString("emp_fechanacimiento"));
                       emp.setFechaIngreso(rs.getString("te_fechaincorporacion"));
                       emp.setTienda(rs.getString("tie_nombre"));
                       //System.out.println(emp.getTienda());
                       listaEmpleado.add(emp);
                   }
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }*/
              try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());
/*WHERE emp_ci = (select te_fk_empleado  from tie_emp where te_fk_tienda = "+fk_tienda+")*/
            String sql;
               /* sql = "SELECT emp_ci,emp_primernombre,emp_primerapellido,emp_salario,emp_fechanacimiento,"
                        + "te_fechaincorporacion,te_fk_tienda,"
                        + "tie_nombre"
                        + "  FROM empleado, tie_emp,tienda  WHERE te_fk_tienda = "+fk_tienda+" and te_fk_empleado = emp_ci and tie_codigo = te_fk_tienda ;"; //Consulta
               */sql = "select de_fechaincorporacion,dep_nombre ,emp_ci,emp_primernombre,emp_primerapellido,emp_salario,emp_fechanacimiento " +
"from empleado,dep_emp,departamento " +
"where de_fk_departamento=dep_codigo and de_fk_empleado = emp_ci and emp_ci LIKE '"+cedula+"%';";
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                        emp= new  Empleados();
                        emp.setCedulaEmpleado(rs.getString("emp_ci"));
                        emp.setPrimerNombreEmpleado(rs.getString("emp_primernombre"));
                        emp.setPrimerApellidoEmpleado(rs.getString("emp_primerapellido"));
                        emp.setSalarioEMpleado(rs.getString("emp_salario"));
                       emp.setFechaNacimientoEMpleado(rs.getString("emp_fechanacimiento"));
                       emp.setFechaIngreso(rs.getString("de_fechaincorporacion"));
                       emp.setTienda(rs.getString("dep_nombre"));
                       
                       listaEmpleado.add(emp);
                   }
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaEmpleado;
    }
 
        public int actualizarEmpleado(String cedula,
                String primerNombre,
                String primerApellido,
                String segundoNOmbre,
                String segundoApellido,
                String salario,
               String telefono,
                String fechaNacimiento,
                String usuario,
                String pass,
                String pregunta,
                String respuesta,
             int tienda,int rol,int permiso){
        int value =0;
            
            
            try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;/*hor_dia,hor_horainicio,hot_horafin*/
                            sql = "UPDATE empleado" +
"   SET emp_ci= '"+cedula+"', emp_primernombre='"+primerNombre+"', "
 + "emp_segundonombre= '"+segundoNOmbre+"', emp_primerapellido= '"+primerApellido+"', " +
"       emp_segundoapellido= '"+segundoApellido+"', "
 + "emp_salario= "+salario+", emp_fechanacimiento= '"+fechaNacimiento+"' " +
" WHERE emp_ci= '"+cedula+"' ;"; //Consulta
                            
           value= PrincipalModel.getStm().executeUpdate(sql);
           
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql01;
                            sql01 = "UPDATE telefono" +
"   SET  tel_numero= '"+telefono+"' "+
" WHERE tel_fk_empleado= '"+cedula+"' ;"; //Consulta
                            
            PrincipalModel.getStm().executeUpdate(sql01);
           
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql1;
                            sql1 = "UPDATE usuario" +
"   SET  usu_contraseña= '"+pass+"', "
  + "usu_preguntasecreta= '"+pregunta+"', usu_respuestasecreta= '"+respuesta+"' " +
" WHERE usu_fk_empleado = '"+cedula+"' ;"; //Consulta
                            
            PrincipalModel.getStm().executeUpdate(sql1);
            if(tienda != -1){
                PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql2;/*hor_dia,hor_horainicio,hot_horafin*/
                            sql2 = "UPDATE dep_emp " +
                   "SET de_fk_departamento = "+tienda+"  WHERE de_fk_empleado = '"+cedula+"' ;"; //Consulta
                            
            PrincipalModel.getStm().executeUpdate(sql2);
            }
           /* if(!rol.equals("-1")){
                PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql3;/*hor_dia,hor_horainicio,hot_horafin*/
                           /* sql3 = "UPDATE empleado " +
                   "SET emp_salario = '"+salarioEmpleado+"', emp_diasvacaciones  ='"+salarioEmpleado+"'  WHERE emp_ci = '"+cedulaEmpleado+"' ;"; //Consulta
                            
            PrincipalModel.getStm().executeUpdate(sql3);
            }
                if(!permiso.equals("-1")){
                    PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql4;/*hor_dia,hor_horainicio,hot_horafin*/
                     /*       sql4 = "UPDATE empleado " +
                   "SET emp_salario = '"+salarioEmpleado+"', emp_diasvacaciones  ='"+salarioEmpleado+"'  WHERE emp_ci = '"+cedulaEmpleado+"' ;"; //Consulta
                            
            value=PrincipalModel.getStm().executeUpdate(sql4);
                }*/
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            
        } catch (Exception e) {
        }
        return value;
        }
       public int eliminarDatosEmpleado (String cedula){
        int value=0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
            
            String sql;
            sql = "DELETE FROM dep_emp " +
                   " WHERE de_fk_empleado = '"+cedula+"' ;"; //Consulta
                    PrincipalModel.getStm().executeUpdate(sql);
           
               
                            sql = "DELETE FROM emp_hor " +
                   " WHERE eh_fk_empleado = '"+cedula+"' ;"; //Consulta

            PrincipalModel.getStm().executeUpdate(sql);
            
              sql = "DELETE FROM emp_ben " +
                   " WHERE eb_fk_beneficio = '"+cedula+"' ;"; //Consulta

             PrincipalModel.getStm().executeUpdate(sql);
            
              PrincipalModel.getStm().executeUpdate(sql);
            
              sql = "DELETE FROM vacaciones " +
                   " WHERE vac_fk_empleado = '"+cedula+"' ;"; //Consulta

             PrincipalModel.getStm().executeUpdate(sql);
            
            sql = "DELETE FROM rol_per " +
                   " WHERE rp_fk_usuario  = (SELECT usu_nick FROM usuario where usu_fk_empleado = '"+cedula+"') ;"; //Consulta

            PrincipalModel.getStm().executeUpdate(sql);
            
            sql = "DELETE FROM usuario " +
                   " WHERE usu_fk_empleado  = '"+cedula+"' ;"; //Consulta

            PrincipalModel.getStm().executeUpdate(sql);
            
            sql = "DELETE FROM telefono " +
                   " WHERE tel_fk_empleado  = '"+cedula+"' ;"; //Consulta

            value=PrincipalModel.getStm().executeUpdate(sql);
            
            PrincipalModel.getStm().executeUpdate(sql);
            
            sql = "DELETE FROM empleado " +
                   " WHERE emp_ci  = '"+cedula+"' ;"; //Consulta

            value=PrincipalModel.getStm().executeUpdate(sql);
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            
        } catch (Exception e) {
        }
        
        return value;
    }

    
    public void setUpdateEmpleado(String cedula, JTextField cedula1,JTextField primerNombre,
    JTextField segundoNOmbre,JTextField primerApellido,JTextField segundoApellido,JTextField salario,
    JTextField telefono,JDateChooser fechaNacimiento
            ,JTextField usuario,JTextField pass,JTextField pregunta,JTextField respuesta){
        
         try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());
/*WHERE emp_ci = (select te_fk_empleado  from tie_emp where te_fk_tienda = "+fk_tienda+")*/
            String sql;
                sql = "select emp_ci,emp_primernombre,emp_segundonombre,emp_primerapellido," +
"emp_segundoapellido,emp_salario, tel_numero ,emp_fechanacimiento,usu_nick,usu_contraseña,"
                        + "usu_preguntasecreta,usu_respuestasecreta" +
" from empleado,usuario,telefono where tel_fk_empleado='"+cedula+"' and emp_ci= '"+cedula+"' and  usu_fk_empleado = '"+cedula+"';"; //Consulta
               /* sql = "SELECT *"
                        + "  FROM empleado;";*/
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                        cedula1.setText(rs.getString("emp_ci"));
                        primerNombre.setText(rs.getString("emp_primernombre"));
                        segundoNOmbre.setText(rs.getString("emp_segundonombre"));
                        primerApellido.setText(rs.getString("emp_primerapellido"));
                        segundoApellido.setText(rs.getString("emp_segundoapellido"));
                        salario.setText(rs.getString("emp_salario"));
                      telefono.setText(rs.getString("tel_numero"));
                        String dateValue = rs.getString("emp_fechanacimiento");
                        
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateValue);
                        fechaNacimiento.setDate(date);
                        
                        usuario.setText(rs.getString("usu_nick"));
                        pass.setText(rs.getString("usu_contraseña"));
                        pregunta.setText(rs.getString("usu_preguntasecreta"));
                        respuesta.setText(rs.getString("usu_respuestasecreta"));
                   }
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
       
    }
       
       
//VACACIONES
       public int insertVacaionesEmpleados(String vac_fechainicio ,String vac_fechafin,String vac_fk_empleado){
       int value =0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "INSERT INTO vacaciones (vac_fechainicio ,vac_fechafin,vac_fk_empleado) "+
            " VALUES ('"+vac_fechainicio +"','"+vac_fechafin+"','"+vac_fk_empleado+"');"; //Consulta
                            
            value =PrincipalModel.getStm().executeUpdate(sql);
            
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
           value =0;
        } catch (Exception e) {
        }
       
       return value;
       
       }
       public int deleteVacaionesEmpleados(String cedula){
       int value =0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
            String sql;
            sql = "DELETE FROM vacaciones " +
                   " WHERE vac_fk_empleado = '"+cedula+"' ;"; //Consulta
              
                
                            
            value =PrincipalModel.getStm().executeUpdate(sql);
            
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
           value =0;
        } catch (Exception e) {
        }
       
       return value;
       
       }
       public int actualizarVacaionesEmpleados(String vac_fechainicio ,String vac_fechafin,String vac_fk_empleado){
       int value =0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
            String sql;
            sql = "UPDATE vacaciones " +
                   "SET vac_fechainicio  = '"+vac_fechainicio+"', vac_fechafin  ='"+vac_fechafin+"'  WHERE vac_fk_empleado = '"+vac_fk_empleado+"' ;"; //Consulta
          
                            
            value =PrincipalModel.getStm().executeUpdate(sql);
            
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
           
        } catch (Exception e) {
        }
       
       return value;
       
       }
       
       
       
    
       

    
    public ArrayList <Empleados> listVacacionesXCedula(String cedula){
        ArrayList listaEmpleado = new ArrayList();
        Empleados emp;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
                sql = "select vac_fechainicio ,  vac_fechafin,emp_ci,emp_primernombre,emp_primerapellido " +
" from empleado,vacaciones " +
" where vac_fk_empleado=emp_ci and emp_ci like '"+cedula+"%';"; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                           emp= new  Empleados();
                        emp.setCedulaEmpleado(rs.getString("emp_ci"));
                        emp.setPrimerNombreEmpleado(rs.getString("emp_primernombre"));
                        emp.setPrimerApellidoEmpleado(rs.getString("emp_primerapellido"));
                   emp.setFechaVacacionInicial(rs.getString("vac_fechainicio"));
                   emp.setFechaVacacionFinal(rs.getString("vac_fechafin"));  
                           listaEmpleado .add(emp);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaEmpleado;
    }

    //Clientes Juridicos y Natural
    public ArrayList <Tienda2> listTiendasXNOmbre(String nombre){
        ArrayList listaTeinda = new ArrayList();
        Tienda2 emp;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
                sql = "select  tie_codigo, tie_nombre" +
" from tienda " +
" where  tie_nombre like '"+nombre+"%';"; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                           emp= new  Tienda2();
                        emp.setTie_codigo(rs.getString("tie_codigo"));
                        emp.setTie_nombre(rs.getString("tie_nombre"));
                         
                           listaTeinda  .add(emp);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaTeinda ;
    }
    
    
    public int insertJuridico(String jur_rif ,String jur_denominacioncomercial,String jur_razonsocial,
     String jur_paginaweb, String jur_capitaldisponible, String cli_fk_tienda, String cli_fk_lugar_fisica,
             String jur_fk_lugar_fiscal,
             /*USUARIO*/
             String usu_nick,String usu_contraseña,String usu_preguntasecreta,String usu_respuestasecreta,
             
             /*Correo*/
             String mail,
            /*Telefono*/
             String descrip,String numero){
       int value =0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "INSERT INTO juridico "
              + "( jur_rif, jur_denominacioncomercial, jur_razonsocial, " +
"            jur_paginaweb, jur_capitaldisponible, cli_fk_tienda, cli_fk_lugar_fisica, " +
"            jur_fk_lugar_fiscal) "+
            " VALUES ('"+jur_rif +"','"+jur_denominacioncomercial+"','"+jur_razonsocial+"','"+jur_paginaweb+"',"
                                    + "'"+jur_capitaldisponible+"','"+cli_fk_tienda+"',"
                                    + "'"+cli_fk_lugar_fisica+"','"+jur_fk_lugar_fiscal+"');"; //Consulta
                            
            int x =PrincipalModel.getStm().executeUpdate(sql);
            if(x ==1){
                PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql1;
                            sql1 = "INSERT INTO correo "
              + "(cor_direccion ,cor_fk_juridico )"+
            " VALUES ('"+mail +"',(select cli_codigo from juridico where jur_rif='"+jur_rif+"'));"; //Consulta
                      PrincipalModel.getStm().executeUpdate(sql1);
                
                PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql2;
                            sql2 = "INSERT INTO usuario "
              + "(usu_nick  ,usu_contraseña,usu_preguntasecreta ,usu_respuestasecreta,usu_fk_juridico  )"+
            " VALUES ('"+usu_nick +"','"+usu_contraseña+"','"+usu_preguntasecreta+"' ,"
             + " '"+usu_respuestasecreta+"',"
              + " (select cli_codigo from juridico where jur_rif='"+jur_rif+"'));"; //Consulta
                   PrincipalModel.getStm().executeUpdate(sql2);
              
                   String   sql3 = "INSERT INTO telefono "
              + "(tel_descripcion  ,tel_numero,tel_fk_juridico    )"+
            " VALUES ('"+descrip +"','"+numero+"',"
              + " (select cli_codigo from juridico where jur_rif='"+jur_rif+"'));"; //Consulta
                  value=    PrincipalModel.getStm().executeUpdate(sql3);
                      
                      
            }
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
           value =0;
        } catch (Exception e) {
        }
        return value;
     }
     public int insertNatural(String nat_cedula ,String nat_rif ,String nat_primernombre,
     String nat_segundonombre, String nat_primerapellido , String nat_segundoapellido
             , String cli_fk_tienda ,
             String cli_fk_lugar ,
     /*USUARIO*/
             String usu_nick,String usu_contraseña,String usu_preguntasecreta,String usu_respuestasecreta,
             
             /*Correo*/
             String mail,
             /*Telefono*/
             String descrip,String numero){
       int value =0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "INSERT INTO \"natural\" "
              + "(nat_cedula ,nat_rif,nat_primernombre,nat_segundonombre,nat_primerapellido "
                                    + ",nat_segundoapellido ,cli_fk_tienda,cli_fk_lugar) "+
            " VALUES ('"+nat_cedula +"','"+nat_rif+"','"+nat_primernombre+"','"+nat_segundonombre+"',"
                                    + "'"+nat_primerapellido+"','"+nat_segundoapellido+"',"
                                    + "'"+cli_fk_tienda+"','"+cli_fk_lugar+"');"; //Consulta
                            
            int x =PrincipalModel.getStm().executeUpdate(sql);
            if(x ==1){
                
                PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql1;
                            sql1 = "INSERT INTO correo "
              + "(cor_direccion ,cor_fk_natural) "+
            " VALUES ('"+mail +"',(select cli_codigo from \"natural\" where nat_cedula='"+nat_cedula+"'));"; //Consulta
                      PrincipalModel.getStm().executeUpdate(sql1);
                
                PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql2;
                            sql2 = "INSERT INTO usuario "
              + "(usu_nick  ,usu_contraseña,usu_preguntasecreta ,usu_respuestasecreta,usu_fk_natural   )"+
            " VALUES ('"+usu_nick +"','"+usu_contraseña+"','"+usu_preguntasecreta+"' ,"
             + " '"+usu_respuestasecreta+"',"
              + " (select cli_codigo from \"natural\" where nat_cedula='"+nat_cedula+"'));"; //Consulta
                    PrincipalModel.getStm().executeUpdate(sql2);
                
                    PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
                    String sql3;
                            sql3 = "INSERT INTO telefono "
              + "(tel_descripcion  ,tel_numero,tel_fk_natural    )"+
            " VALUES ('"+descrip +"','"+numero+"',"
              + " (select cli_codigo from \"natural\" where nat_cedula='"+nat_cedula+"'));"; //Consulta
                  value=    PrincipalModel.getStm().executeUpdate(sql3);
                      
            
            }
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
           value =0;
        } catch (Exception e) {
        }
        return value;
     }
       public ArrayList <Juridico> listJuridicoXRIF(String rif){
        ArrayList listaEmpleado = new ArrayList();
        Juridico emp;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
                sql = "select cli_codigo,jur_rif ,jur_denominacioncomercial || ' , ' || jur_razonsocial as d_y_n, "
                        + "jur_paginaweb  ,jur_capitaldisponible " +
"from juridico " +
"where jur_rif like '"+rif+"%' ;"; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                           emp= new  Juridico();
                        emp.setCli_codigo(rs.getString("cli_codigo"));
                        emp.setDenominacion_razon(rs.getString("d_y_n"));
                        emp.setJur_rif(rs.getString("jur_rif"));
                   emp.setPagina(rs.getString("jur_paginaweb"));
                   emp.setJur_capitaldisponible(rs.getString("jur_capitaldisponible"));  
                           listaEmpleado .add(emp);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaEmpleado;
    }
       public ArrayList <Natural> listNaturalXCedula(String cedula){
        ArrayList listaEmpleado = new ArrayList();
        Natural emp;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
                sql = "select cli_codigo,nat_cedula ,nat_rif,nat_primernombre || ' , ' ||nat_primerapellido as nombre_apelldio " +
"from \"natural\" " +
"where nat_cedula  like '"+cedula+"%' "; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                           emp= new  Natural();
                        emp.setCli_codigo(rs.getString("cli_codigo"));
                        emp.setNat_cedula(rs.getString("nat_cedula"));
                        emp.setNat_rif(rs.getString("nat_rif"));
                   emp.setNombre_apelldio(rs.getString("nombre_apelldio"));
                   
                           listaEmpleado .add(emp);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaEmpleado;
    }
       public int deleteJuridicos(String rif){
       int value =0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
            String sql;
            sql = "DELETE FROM juridico " +
                   " WHERE  jur_rif = '"+rif+"' ;"; //Consulta
              
                
                            
            value =PrincipalModel.getStm().executeUpdate(sql);
            
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
           value =0;
        } catch (Exception e) {
        }
       
       return value;
       }
       public int deleteNaturales(String cedula){
       int value =0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
            String sql;
            sql = "DELETE FROM \"natural\" " +
                   " WHERE nat_cedula = '"+cedula+"' ;"; //Consulta
              
                
                            
            value =PrincipalModel.getStm().executeUpdate(sql);
            
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
           value =0;
        } catch (Exception e) {
        }
       
       return value;
       }
               public int actualizarJuridico(String jur_rif ,String jur_denominacioncomercial,String jur_razonsocial,
     String jur_paginaweb, String jur_capitaldisponible, String cli_fk_lugar_fisica,
             String jur_fk_lugar_fiscal,
             /*USUARIO*/
             String usu_contraseña,String usu_preguntasecreta,String usu_respuestasecreta,
             
             /*Correo*/
             String mail,
            /*Telefono*/
             String numero){
        int value =0;
            
            
            try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;/*hor_dia,hor_horainicio,hot_horafin*/
                            sql = "UPDATE juridico" +
"   SET jur_denominacioncomercial='"+jur_denominacioncomercial+"', "
 + "jur_razonsocial= '"+jur_razonsocial+"', jur_paginaweb= '"+jur_paginaweb+"', " +
"       jur_capitaldisponible= '"+jur_capitaldisponible+"' "
 + " WHERE jur_rif= '"+jur_rif+"' ;"; //Consulta
                            
           value= PrincipalModel.getStm().executeUpdate(sql);
           
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql01;
                            sql01 = "UPDATE telefono" +
"   SET  tel_numero= '"+numero+"' "+
" WHERE tel_fk_juridico= (select cli_codigo from juridico where jur_rif='"+jur_rif+"') ;"; //Consulta
                            
            PrincipalModel.getStm().executeUpdate(sql01);
           
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql1;
                            sql1 = "UPDATE usuario" +
"   SET  usu_contraseña= '"+usu_contraseña+"', "
  + "usu_preguntasecreta= '"+usu_preguntasecreta+"', usu_respuestasecreta= '"+usu_respuestasecreta+"' " +
" WHERE usu_fk_juridico = (select cli_codigo from juridico where jur_rif='"+jur_rif+"') ;"; //Consulta
                            
            PrincipalModel.getStm().executeUpdate(sql1);
           
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql2;
                            sql2 = "UPDATE correo" +
"   SET  cor_direccion= '"+mail+"'" +
" WHERE cor_fk_juridico = (select cli_codigo from juridico where jur_rif='"+jur_rif+"') ;"; //Consulta
                            
            PrincipalModel.getStm().executeUpdate(sql2);
           
            
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            
        } catch (Exception e) {
        }
        return value;
        }
       public void setUpdateJuridico(int cod, JTextField textRegistroCLienteJuridicoDenominacionComercial,
               JTextField textRegistroCLienteJuridicoRazonSocial,
    JTextField textRegistroCLienteJuridicoRif,JTextField textRegistroCLienteJuridicoTelefono,
    JTextField textRegistroCLienteJuridicoWeb,JTextField textRegistroCLienteJuridicoEmail,
    JTextField textRegistroCLienteJuridicoCapitalDisponible,JTextField textRegistroCLienteJuridicoUsuario
            ,JTextField textRegistroCLienteJuridicoPass,JTextField textRegistroCLienteJuridicoPreguntaSecreta
               ,JTextField textRegistroCLienteJuridicoRespuestaSecreta)
       {
        
         try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());
/*WHERE emp_ci = (select te_fk_empleado  from tie_emp where te_fk_tienda = "+fk_tienda+")*/
            String sql;
                sql = "select jur_denominacioncomercial ,jur_razonsocial,jur_rif ,tel_numero," +
"jur_paginaweb ,cor_direccion, jur_capitaldisponible ,usu_nick ,usu_contraseña,"
                        + "usu_preguntasecreta,usu_respuestasecreta" +
" from juridico,usuario,telefono,correo where tel_fk_juridico="+cod+" and cli_codigo = "+cod+" and  "
                        + "cor_fk_juridico = "+cod+" and usu_fk_juridico="+cod+";"; //Consulta
               /* sql = "SELECT *"
                        + "  FROM empleado;";*/
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                        textRegistroCLienteJuridicoDenominacionComercial.setText(rs.getString("jur_denominacioncomercial"));
                        textRegistroCLienteJuridicoRazonSocial.setText(rs.getString("jur_razonsocial"));
                        textRegistroCLienteJuridicoRif.setText(rs.getString("jur_rif"));
                        textRegistroCLienteJuridicoTelefono.setText(rs.getString("tel_numero"));
                        textRegistroCLienteJuridicoWeb.setText(rs.getString("jur_paginaweb"));
                         textRegistroCLienteJuridicoEmail.setText(rs.getString("cor_direccion"));
                      textRegistroCLienteJuridicoCapitalDisponible.setText(rs.getString("jur_capitaldisponible"));
                        textRegistroCLienteJuridicoUsuario.setText(rs.getString("usu_nick"));
                        
                        
                        
                        textRegistroCLienteJuridicoPass.setText(rs.getString("usu_contraseña"));
                        textRegistroCLienteJuridicoPreguntaSecreta.setText(rs.getString("usu_preguntasecreta"));
                        textRegistroCLienteJuridicoRespuestaSecreta.setText(rs.getString("usu_respuestasecreta"));
                        
                   }
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
       
    }
 public int actualizarNatural(String nat_cedula ,
             String cli_fk_lugar ,
     /*USUARIO*/
             String usu_contraseña,String usu_preguntasecreta,String usu_respuestasecreta,
             
             /*Correo*/
             String mail,
             /*Telefono*/
             String numero){
        int value =0;
            
            
            try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
             /*  String sql;/*hor_dia,hor_horainicio,hot_horafin*/
                    /*        sql = "UPDATE natural " +
"   SET jur_denominacioncomercial='"+jur_denominacioncomercial+"', "
 + "jur_razonsocial= '"+jur_razonsocial+"', jur_paginaweb= '"+jur_paginaweb+"', " +
"       jur_capitaldisponible= '"+jur_capitaldisponible+"' "
 + " WHERE jur_rif= '"+jur_rif+"' ;"; //Consulta
                            
           value= PrincipalModel.getStm().executeUpdate(sql);
           */
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql01;
                            sql01 = "UPDATE telefono" +
"   SET  tel_numero= '"+numero+"' "+
" WHERE tel_fk_natural = (select cli_codigo from \"natural\" where nat_cedula='"+nat_cedula+"') ;"; //Consulta
                            
            PrincipalModel.getStm().executeUpdate(sql01);
           
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql1;
                            sql1 = "UPDATE usuario" +
"   SET  usu_contraseña= '"+usu_contraseña+"', "
  + "usu_preguntasecreta= '"+usu_preguntasecreta+"', usu_respuestasecreta= '"+usu_respuestasecreta+"' " +
" WHERE usu_fk_natural= (select cli_codigo from \"natural\" where nat_cedula='"+nat_cedula+"') ;"; //Consulta
                            
            PrincipalModel.getStm().executeUpdate(sql1);
           
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql2;
                            sql2 = "UPDATE correo" +
"   SET  cor_direccion= '"+mail+"'" +
" WHERE cor_fk_natural = (select cli_codigo from \"natural\" where nat_cedula='"+nat_cedula+"') ;"; //Consulta
                            
           value= PrincipalModel.getStm().executeUpdate(sql2);
           
            
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            
        } catch (Exception e) {
        }
        return value;
        }
       public void setUpdateNatural(int cod, JTextField textRegistroCLienteNaturalNombre,
               JTextField textRegistroCLienteNaturalSegundoNombre,
    JTextField textRegistroCLienteNaturalApellido,JTextField textRegistroCLienteNaturalSegundoApellido,
    JTextField textRegistroCLienteNaturalTelefono,JTextField textRegistroCLienteNaturalCedula,
    JTextField textRegistroCLienteNaturalRif,JTextField textRegistroCLienteNaturalEmail
            ,JTextField textRegistroCLienteNaturalUser,JTextField textRegistroCLienteNaturalPass
               ,JTextField textRegistroCLienteNaturalPreguntaSecreta,JTextField textRegistroCLienteNaturalRespuestaSecreta)
       {
        
         try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());
/*WHERE emp_ci = (select te_fk_empleado  from tie_emp where te_fk_tienda = "+fk_tienda+")*/
            String sql;
                sql = "select nat_primernombre ,nat_segundonombre,nat_primerapellido,nat_segundoapellido," +
" tel_numero, nat_cedula,nat_rif,cor_direccion,usu_nick ,usu_contraseña,"
                        + "usu_preguntasecreta,usu_respuestasecreta" +
" from \"natural\",usuario,telefono,correo where tel_fk_natural="+cod+" and cli_codigo = "+cod+" and  "
                        + "cor_fk_natural = "+cod+" and usu_fk_natural ="+cod+";"; //Consulta
               /* sql = "SELECT *"
                        + "  FROM empleado;";*/
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                        textRegistroCLienteNaturalNombre.setText(rs.getString("nat_primernombre"));
                        textRegistroCLienteNaturalSegundoNombre.setText(rs.getString("nat_segundonombre"));
                        textRegistroCLienteNaturalApellido.setText(rs.getString("nat_primerapellido"));
                        textRegistroCLienteNaturalSegundoApellido.setText(rs.getString("nat_segundoapellido"));
                        textRegistroCLienteNaturalTelefono.setText(rs.getString("tel_numero"));
                          textRegistroCLienteNaturalCedula.setText(rs.getString("nat_cedula"));
                      textRegistroCLienteNaturalRif.setText(rs.getString("nat_rif"));
                        textRegistroCLienteNaturalEmail.setText(rs.getString("cor_direccion"));
                        textRegistroCLienteNaturalUser.setText(rs.getString("usu_nick"));
                        textRegistroCLienteNaturalPass.setText(rs.getString("usu_contraseña"));
                        textRegistroCLienteNaturalPreguntaSecreta.setText(rs.getString("usu_preguntasecreta"));
                        textRegistroCLienteNaturalRespuestaSecreta.setText(rs.getString("usu_respuestasecreta"));
                        
                        
                       
                   }
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
       
    }
       public int insertPersonaContacto(String per_ci ,String per_nombre ,String per_apellido,
     String per_fk_juridico,
     /*Telefono*/ String descrip,String numero){
       int value =0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql;
                            sql = "INSERT INTO personacontacto "
              + "(per_ci ,per_nombre,per_apellido,per_fk_juridico) "+
            " VALUES ("+per_ci +",'"+per_nombre+"','"+per_apellido+"',"+per_fk_juridico+");"; //Consulta
                            
            int x =PrincipalModel.getStm().executeUpdate(sql);
            if(x==1){
                PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
                    String sql3;
                            sql3 = "INSERT INTO telefono "
              + "(tel_descripcion  ,tel_numero, tel_fk_personacontacto    )"+
            " VALUES ('"+descrip +"','"+numero+"', '"+per_ci+"');"; //Consulta
                  value=    PrincipalModel.getStm().executeUpdate(sql3);
                      
            }
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
           value =0;
        } catch (Exception e) {
        }
        return value;
     }
       public ArrayList <PersonaContacto> listPersonaContactoXCedula(String per_fk_juridico){
        ArrayList listaEmpleado = new ArrayList();
        PersonaContacto emp;
            try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());

            String sql;
                sql = "SELECT per_ci, per_nombre, per_apellido,tel_numero " +
"  FROM personacontacto,telefono " +
"where per_fk_juridico = (Select cli_codigo from juridico where jur_rif = '"+per_fk_juridico+"') and  tel_fk_personacontacto=per_ci ;"; //Consulta
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                           emp= new  PersonaContacto();
                        emp.setCdeula(rs.getString("per_ci"));
                        emp.setNombre(rs.getString("per_nombre"));
                        emp.setApellido(rs.getString("per_apellido"));
                        emp.setTelefono(rs.getString("tel_numero"));
                 
                           listaEmpleado .add(emp);      
                    } 
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
        return listaEmpleado;
    }
       public int deletePErsonaContaco(String cedula){
       int value =0;
        try {
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
            String sql;
            sql = "DELETE FROM personacontacto " +
                   " WHERE per_ci = '"+cedula+"' ;"; //Consulta
              
                
                            
            value =PrincipalModel.getStm().executeUpdate(sql);
            
           
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
           value =0;
        } catch (Exception e) {
        }
        return value;
        }
       
       public int actualizarNPersonaContaco(String numero,
     int per_ci ){
        int value =0;
            
            
            try {
         
            PrincipalModel.setStm(
                PrincipalModel.getCon().createStatement());
               String sql01;
                            sql01 = "UPDATE telefono" +
"   SET  tel_numero = "+numero+" "+
" WHERE tel_fk_personacontacto = "+per_ci+" ;"; //Consulta
                            
              
           value= PrincipalModel.getStm().executeUpdate(sql01);
           
            
            
            PrincipalModel.getStm().close();
             
             
             
        }catch(SQLException ex){ 
          JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("He aqui el eror: "+ex.toString());
            
        } catch (Exception e) {
        }
        return value;
        }
       public void setUpdatePersonaContacto(int per_ci, JTextField textRegistroCLienteJuridicoPersonaContactoNombre1,
               JTextField textRegistroCLienteJuridicoPersonaContactoApellido1,
    JTextField textRegistroCLienteJuridicoPersonaContactoCedula1,JTextField textRegistroCLienteJuridicoPersonaContacoTelefono1)
       {
        
         try {

            PrincipalModel.setStm(
                    PrincipalModel.getCon().createStatement());
/*WHERE emp_ci = (select te_fk_empleado  from tie_emp where te_fk_tienda = "+fk_tienda+")*/
            String sql;
                sql = "select per_ci ,per_nombre,per_apellido,tel_numero "+
" from personacontacto,telefono"
  + " where tel_fk_personacontacto="+per_ci+" and per_ci = "+per_ci+" ;"; //Consulta
               /* sql = "SELECT *"
                        + "  FROM empleado;";*/
             ResultSet rs =PrincipalModel.getStm().executeQuery(sql);     
                   while (rs.next()) {   
                        textRegistroCLienteJuridicoPersonaContactoNombre1.setText(rs.getString("per_nombre"));
                        textRegistroCLienteJuridicoPersonaContactoApellido1.setText(rs.getString("per_apellido"));
                        textRegistroCLienteJuridicoPersonaContactoCedula1.setText(rs.getString("per_ci"));
                        textRegistroCLienteJuridicoPersonaContacoTelefono1.setText(rs.getString("tel_numero"));   
                   }
            
            rs.close();
            PrincipalModel.getStm().close();
       
        } catch (Exception e) {
        }
       
    }
}
