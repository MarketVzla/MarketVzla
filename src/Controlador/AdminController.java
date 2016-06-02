/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Modelo.PermisoDAO;
import Vista.AdminVista;
import Vista.LoginVista;

/**
 *
 * @author migue
 */
public class AdminController implements ActionListener,KeyListener{

    AdminVista adminView = new AdminVista();
    PermisoDAO modelPermisoDAO = new PermisoDAO();
    LoginVista loginview ;
    
    private int codigo_permiso;

    
    
    
    public AdminController( AdminVista adminView,LoginVista loginview,PermisoDAO modelPermisoDAO){
        this.adminView=adminView;
        this.modelPermisoDAO=modelPermisoDAO;
       this.loginview=loginview;
       // adminView.jTabbedPaneAdmin.remove(adminView.jPanelPrivilegios);
    }
    
    
    /*TABLA PRIVILEGIOS PERMISOS*/
    public  void setTablePermiso(JTable tablaPermiso){
        DefaultTableModel modelTablaPermiso= new DefaultTableModel();
        tablaPermiso.setModel(modelTablaPermiso);
        modelTablaPermiso.addColumn("Codigo");
        modelTablaPermiso.addColumn("Nombre");
        modelTablaPermiso.addColumn("Descripcion");
        
        Object[] columnaPermiso = new Object[3];
        int numeroRegistroPermiso = modelPermisoDAO.listPermiso().size();
        
        for (int i = 0; i < numeroRegistroPermiso; i++) {
           columnaPermiso[0]=  modelPermisoDAO.listPermiso().get(i).getCondigoPermiso();
           columnaPermiso[1]=  modelPermisoDAO.listPermiso().get(i).getNombrePermiso();
           columnaPermiso[2]=  modelPermisoDAO.listPermiso().get(i).getDescripcionPermiso();
           modelTablaPermiso.addRow(columnaPermiso);
        }
        
    }

    
    public void LimpiarElementosPermisos(){
        adminView.btnAdminPermisoActualizar.setEnabled(true);
                  adminView.btnAdminPermisoRegistrar.setEnabled(true);
                  adminView.btnAdminPermisoEliminar.setEnabled(true);
                  adminView.btnAdminPermisoListar.setEnabled(true);
             
                  adminView.jbtnAdminPErmisoActualizarOK.setEnabled(false);
                  
                   adminView.textAdminPermisoBuscar.setEditable(true);
                  adminView.textAdminPermisoNombre.setText("");
                  adminView.textAdminPermisoDescripcion.setText("");
    }
    
    /*TABLA PRIVILEGIOS ROLES*/
    public  void setTableRol(JTable tablaRol){
        DefaultTableModel modelTablaRol= new DefaultTableModel();
        tablaRol.setModel(modelTablaRol);
        modelTablaRol.addColumn("Codigo");
        modelTablaRol.addColumn("Nombre");
        modelTablaRol.addColumn("Descripcion");
        
        Object[] columnarrRol= new Object[3];
        int numeroRegistroPermiso = modelPermisoDAO.listRol().size();
        
        for (int i = 0; i < numeroRegistroPermiso; i++) {
           columnarrRol[0]=  modelPermisoDAO.listRol().get(i).getCondigoRol();
           columnarrRol[1]=  modelPermisoDAO.listRol().get(i).getNombreRol();
           columnarrRol[2]=  modelPermisoDAO.listRol().get(i).getDescripcionRol();
           modelTablaRol.addRow(columnarrRol);
        }
        
    }
    
     public void LimpiarElementosRol(){
        adminView.btnAdminRolActualizar1.setEnabled(true);
                  adminView.btnAdminRolRegistrar1.setEnabled(true);
                  adminView.btnAdminRolEliminar1.setEnabled(true);
                  adminView.btnAdminRolListar1.setEnabled(true);
             
                  adminView.jbtnAdminRolActualizarOK1.setEnabled(false);
                  
                   adminView.textAdminRolBuscar1.setEditable(true);
                  adminView.textAdminRolNombre1.setText("");
                  adminView.textAdminRolDescripcion1.setText("");
    }
    
    /*TABLA EMPLEADOS - BENEFICIOS*/
     
     public  void setTableEmpleadoBeneficio(JTable tablaBeneficio){
        DefaultTableModel modelTablaBeneficio= new DefaultTableModel();
        tablaBeneficio.setModel(modelTablaBeneficio);
         modelTablaBeneficio.addColumn("Codigo");
         modelTablaBeneficio.addColumn("Nombre");
         modelTablaBeneficio.addColumn("Descripcion");
         modelTablaBeneficio.addColumn("Porcentaje %");
        
        Object[] columnaBeneficio= new Object[4];
        int numeroRegistroPermiso = modelPermisoDAO.listEmpleadoBeneficio().size();
        
        for (int i = 0; i < numeroRegistroPermiso; i++) {
           columnaBeneficio[0]= modelPermisoDAO.listEmpleadoBeneficio().get(i).getCodigoBeneficio();
           columnaBeneficio[1]=  modelPermisoDAO.listEmpleadoBeneficio().get(i).getNombreBenefico();
          columnaBeneficio[2]=  modelPermisoDAO.listEmpleadoBeneficio().get(i).getDescripcionBeneficio();
          columnaBeneficio[3]=  modelPermisoDAO.listEmpleadoBeneficio().get(i).getPorcentajeBeneficio();
          modelTablaBeneficio.addRow(columnaBeneficio);
        }
        
    }
    
     public void LimpiarElementosEmpleadoBeneficio(){
        adminView.btnEmpleadosBeneficiosActualizar.setEnabled(true);
                  adminView.btnEmpleadosBeneficiosRegistrar.setEnabled(true);
                  adminView.btnEmpleadosBeneficiosEliminar.setEnabled(true);
                  adminView.btnEmpleadosBeneficiosListar.setEnabled(true);
             
                  adminView.btnEmpleadosBeneficiosActualizarOK.setEnabled(false);
                  
                   adminView.textEmpleadosBeneficiosBuscarNombre.setEditable(true);
                  adminView.textEmpleadosBeneficiosNombre.setText("");
                  adminView.textEmpleadosBeneficiosDescripcion.setText("");
                  adminView.textEmpleadosBeneficiosPorcentaje.setText("");
    }
         /*TABLA EMPLEADOS - Horarios*/
     
     public  void setTableEmpleadoHorario(JTable tablaHorario){
        DefaultTableModel modelTabla= new DefaultTableModel();
        tablaHorario.setModel(modelTabla);
         modelTabla.addColumn("Codigo");
         modelTabla.addColumn("Fecha Inicio");
         modelTabla.addColumn("Fecha Final");
         
        
        Object[] columna= new Object[3];
        int numeroRegistro = modelPermisoDAO.listEmpleadoHorario().size();
        
        for (int i = 0; i < numeroRegistro; i++) {
           columna[0]= modelPermisoDAO.listEmpleadoHorario().get(i).getCodigoHorario();
           columna[1]=  modelPermisoDAO.listEmpleadoHorario().get(i).getFechaInicioHorario();
          columna[2]=  modelPermisoDAO.listEmpleadoHorario().get(i).getFechafinHorario();
          
          modelTabla.addRow(columna);
        }
        
    }
    
     public void LimpiarElementosEmpleadoHorario(){
        adminView.btnAdminEmpleadosHorariosActualizar.setEnabled(true);
                  adminView.btnAdminEmpleadosHorariosRegistrar.setEnabled(true);
                  adminView.btnAdminEmpleadosHorariosEliminar.setEnabled(true);
                  adminView.btnAdminEmpleadosHorariosListar.setEnabled(true);
             
                  adminView.btnAdminEmpleadosHorariosActualizarOK.setEnabled(false);
                  
                   adminView.textAdminEmpleadosHorariosBuscarFecha.setEditable(true);
                  adminView.textAdminEmpleadosHorariosFechaInicio.setDate(null);
                  adminView.textAdminEmpleadosHorariosFechaFin.setDate(null);
                  
    }
     
    
    public void actionPerformed(ActionEvent e) {
         //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()== adminView.jbtnAdminCerrarSession){
            adminView.setVisible(false);
            loginview .MustraLogin();
        }
         
        //PRIVILEGIOS -PERMISOS 
         if(e.getSource() == adminView.btnAdminPermisoRegistrar){
             String nombre = (String)adminView.textAdminPermisoNombre.getText().toUpperCase();
             String descripcion = (String)adminView.textAdminPermisoDescripcion.getText().toUpperCase();
             
             
             String rstaRegistroPermiso = modelPermisoDAO.insertarDatosPermiso(nombre, descripcion);
             if(rstaRegistroPermiso != null){
                     JOptionPane.showMessageDialog(null, rstaRegistroPermiso);
                     setTablePermiso(adminView.tableAdminPermiso);
             }else{JOptionPane.showMessageDialog(null, "No se pudo registrar");}
         }
         if(e.getSource() == adminView.btnAdminPermisoListar){
              
             setTablePermiso(adminView.tableAdminPermiso);
           
         }
         if(e.getSource() == adminView.btnAdminPermisoActualizar){
             int filaActualizarPermiso = adminView.tableAdminPermiso.getSelectedRow();
             int numFilas =  adminView.tableAdminPermiso.getSelectedRowCount();
             if(filaActualizarPermiso >= 0 && numFilas ==1){
                   codigo_permiso =Integer.parseInt((String) adminView.tableAdminPermiso.getValueAt(filaActualizarPermiso, 0));
                  adminView.textAdminPermisoNombre.setText(String.valueOf(adminView.tableAdminPermiso.getValueAt(filaActualizarPermiso, 1)));
                  adminView.textAdminPermisoDescripcion.setText(String.valueOf(adminView.tableAdminPermiso.getValueAt(filaActualizarPermiso, 2)));
                  
                  adminView.btnAdminPermisoActualizar.setEnabled(false);
                  adminView.btnAdminPermisoRegistrar.setEnabled(false);
                  adminView.btnAdminPermisoEliminar.setEnabled(false);
                  adminView.btnAdminPermisoListar.setEnabled(false);
                  adminView.textAdminPermisoBuscar.setEditable(false);
                  adminView.jbtnAdminPErmisoActualizarOK.setEnabled(true);
             }else{
                 JOptionPane.showMessageDialog(null, "Por favor seleccionar una Fila");
             }
         
         
         }
         
         if(e.getSource() == adminView.jbtnAdminPErmisoActualizarOK){
             String nombre = (String)adminView.textAdminPermisoNombre.getText();
             String descripcion = (String)adminView.textAdminPermisoDescripcion.getText();
             
            
             
             int actualizar= modelPermisoDAO.actualizarDatosPermiso(nombre, descripcion,codigo_permiso);
             if(actualizar > 0){
                 JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
                 setTablePermiso(adminView.tableAdminPermiso);
             }else JOptionPane.showMessageDialog(null, "No se ha podido realizar la Actualizacion");
         
             LimpiarElementosPermisos();
         }
         if(e.getSource() == adminView.btnAdminPermisoEliminar){
             int filaInicioPermiso = adminView.tableAdminPermiso.getSelectedRow();
             int numFilas =  adminView.tableAdminPermiso.getSelectedRowCount();
             ArrayList<String> listaNombre = new ArrayList();
             String nombrePermiso="";
             if( filaInicioPermiso  >=0   ){
                 for (int i = 0; i < numFilas ; i++) {
                      nombrePermiso= String.valueOf(adminView.tableAdminPermiso.getValueAt(i+filaInicioPermiso, 0));
                      listaNombre .add(nombrePermiso);
                 }
                 for (int i = 0; i < listaNombre.size() ; i++) {
                     int confirmacionUsuario = JOptionPane.showConfirmDialog(null, "Desea eliminar: "+listaNombre.get(i)+" ?");
                     if(confirmacionUsuario==0){
                         modelPermisoDAO.eliminarDatosPermiso(listaNombre.get(i));
                     }
                 }
                 setTablePermiso(adminView.tableAdminPermiso);
             }else JOptionPane.showMessageDialog(null, "Por favor seleccionar almenos una Fila");
             
         }
         
         
         //PRIVILEGIOS -ROLES
         if(e.getSource() == adminView.btnAdminRolRegistrar1){
             String nombre = (String)adminView.textAdminRolNombre1.getText().toUpperCase();
             String descripcion = (String)adminView.textAdminRolDescripcion1.getText().toUpperCase();
             
             
             String rstaRegistroPermiso = modelPermisoDAO.insertarDatosRol(nombre, descripcion);
             if(rstaRegistroPermiso != null){
                     JOptionPane.showMessageDialog(null, rstaRegistroPermiso);
                     setTableRol(adminView.tableAdminRol);
             }else{JOptionPane.showMessageDialog(null, "No se pudo registrar");}
         }
         if(e.getSource() == adminView.btnAdminRolListar1){
              
             setTableRol(adminView.tableAdminRol);
           
         }
         if(e.getSource() == adminView.btnAdminRolActualizar1){
             int filaActualizarRol = adminView.tableAdminRol.getSelectedRow();
             int numFilas =  adminView.tableAdminRol.getSelectedRowCount();
             if(filaActualizarRol >= 0 && numFilas ==1){
                   codigo_permiso =Integer.parseInt((String) adminView.tableAdminRol.getValueAt(filaActualizarRol, 0));
                  adminView.textAdminRolNombre1.setText(String.valueOf(adminView.tableAdminRol.getValueAt(filaActualizarRol, 1)));
                  adminView.textAdminRolDescripcion1.setText(String.valueOf(adminView.tableAdminRol.getValueAt(filaActualizarRol, 2)));
                  
                  adminView.btnAdminRolActualizar1.setEnabled(false);
                  adminView.btnAdminRolRegistrar1.setEnabled(false);
                  adminView.btnAdminRolEliminar1.setEnabled(false);
                  adminView.btnAdminRolListar1.setEnabled(false);
                  adminView.textAdminRolBuscar1.setEditable(false);
                  adminView.jbtnAdminRolActualizarOK1.setEnabled(true);
             }else{
                 JOptionPane.showMessageDialog(null, "Por favor seleccionar una Fila");
             }
         
         
         }
         
         if(e.getSource() == adminView.jbtnAdminRolActualizarOK1){
             String nombre = (String)adminView.textAdminRolNombre1.getText().toUpperCase();
             String descripcion = (String)adminView.textAdminRolDescripcion1.getText().toUpperCase();
             
            
             
             int actualizar= modelPermisoDAO.actualizarDatosRol(nombre, descripcion,codigo_permiso);
             if(actualizar > 0){
                 JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
                 setTableRol(adminView.tableAdminRol);
             }else JOptionPane.showMessageDialog(null, "No se ha podido realizar la Actualizacion");
         
             LimpiarElementosRol();
         }
         if(e.getSource() == adminView.btnAdminRolEliminar1){
             int filaInicioRol= adminView.tableAdminRol.getSelectedRow();
             int numFilas =  adminView.tableAdminRol.getSelectedRowCount();
             ArrayList<String> listaNombre = new ArrayList();
             String nombreRol="";
             if( filaInicioRol  >=0   ){
                 for (int i = 0; i < numFilas ; i++) {
                      nombreRol= String.valueOf(adminView.tableAdminRol.getValueAt(i+filaInicioRol, 0));
                      listaNombre .add(nombreRol);
                 }
                 for (int i = 0; i < listaNombre .size() ; i++) {
                     int confirmacionUsuario = JOptionPane.showConfirmDialog(null, "Desea eliminar: "+listaNombre.get(i)+" ?");
                     if(confirmacionUsuario==0){
                         modelPermisoDAO.eliminarDatosRol(listaNombre.get(i));
                     }
                 }
                 setTablePermiso(adminView.tableAdminRol);
             }else JOptionPane.showMessageDialog(null, "Por favor seleccionar almenos una Fila");
             
         } 
         //EMPLEADOS - BENEFICIOS
         if(e.getSource() == adminView.btnEmpleadosBeneficiosRegistrar){
             String nombre = (String)adminView.textEmpleadosBeneficiosNombre.getText().toUpperCase();
             String descripcion = (String)adminView.textEmpleadosBeneficiosDescripcion.getText().toUpperCase();
             String porcentaje = (String)adminView.textEmpleadosBeneficiosPorcentaje.getText().toUpperCase();
             
             String rstaRegistroBeneficio = modelPermisoDAO.insertarDatosEmpleadoBeneficio(nombre, descripcion,porcentaje);
             if(rstaRegistroBeneficio!= null){
                     JOptionPane.showMessageDialog(null, rstaRegistroBeneficio);
                     setTableEmpleadoBeneficio(adminView.tablebtnEmpleadosBeneficios);
             }else{JOptionPane.showMessageDialog(null, "No se pudo registrar");}
         }
         if(e.getSource() == adminView.btnEmpleadosBeneficiosListar){
              setTableEmpleadoBeneficio(adminView.tablebtnEmpleadosBeneficios);
             
           
         }
         if(e.getSource() == adminView.btnEmpleadosBeneficiosActualizar){
             int filaActualizarBeneficio = adminView.tablebtnEmpleadosBeneficios.getSelectedRow();
             int numFilas =  adminView.tablebtnEmpleadosBeneficios.getSelectedRowCount();
             if(filaActualizarBeneficio >= 0 && numFilas ==1){
                   codigo_permiso =Integer.parseInt((String) adminView.tablebtnEmpleadosBeneficios.getValueAt(filaActualizarBeneficio, 0));
                  adminView.textEmpleadosBeneficiosNombre.setText(String.valueOf(adminView.tablebtnEmpleadosBeneficios.getValueAt(filaActualizarBeneficio, 1)));
                  adminView.textEmpleadosBeneficiosDescripcion.setText(String.valueOf(adminView.tablebtnEmpleadosBeneficios.getValueAt(filaActualizarBeneficio, 2)));
                  adminView.textEmpleadosBeneficiosPorcentaje.setText(String.valueOf(adminView.tablebtnEmpleadosBeneficios.getValueAt(filaActualizarBeneficio, 3)));
                  
                  adminView.btnEmpleadosBeneficiosActualizar.setEnabled(false);
                  adminView.btnEmpleadosBeneficiosEliminar.setEnabled(false);
                  adminView.btnEmpleadosBeneficiosRegistrar.setEnabled(false);
                  adminView.btnEmpleadosBeneficiosListar.setEnabled(false);
                  adminView.textEmpleadosBeneficiosBuscarNombre.setEditable(false);
                  adminView.btnEmpleadosBeneficiosActualizarOK.setEnabled(true);
             }else{
                 JOptionPane.showMessageDialog(null, "Por favor seleccionar una Fila");
             }
         
         
         }
         
         if(e.getSource() == adminView.btnEmpleadosBeneficiosActualizarOK){
             String nombre = (String)adminView.textEmpleadosBeneficiosNombre.getText().toUpperCase();
             String descripcion = (String)adminView.textEmpleadosBeneficiosDescripcion.getText().toUpperCase();
             String porcentaje = (String)adminView.textEmpleadosBeneficiosPorcentaje.getText().toUpperCase();
            
             
             int actualizar= modelPermisoDAO.actualizarDatosEmpleadoBeneficio(nombre, descripcion,porcentaje,codigo_permiso);
             if(actualizar > 0){
                 JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
                 setTableEmpleadoBeneficio(adminView.tablebtnEmpleadosBeneficios);
             }else JOptionPane.showMessageDialog(null, "No se ha podido realizar la Actualizacion");
         
             LimpiarElementosEmpleadoBeneficio();
         }
         if(e.getSource() == adminView.btnEmpleadosBeneficiosEliminar){
             int filaInicioBeneficio= adminView.tablebtnEmpleadosBeneficios.getSelectedRow();
             int numFilas =  adminView.tablebtnEmpleadosBeneficios.getSelectedRowCount();
             ArrayList<String> listaNombre = new ArrayList();
             String nombreBeneficio="";
             if( filaInicioBeneficio  >=0   ){
                 for (int i = 0; i < numFilas ; i++) {
                      nombreBeneficio= String.valueOf(adminView.tablebtnEmpleadosBeneficios.getValueAt(i+filaInicioBeneficio, 0));
                      listaNombre .add(nombreBeneficio);
                 }
                 for (int i = 0; i < listaNombre .size() ; i++) {
                     int confirmacionUsuario = JOptionPane.showConfirmDialog(null, "Desea eliminar: "+listaNombre.get(i)+" ?");
                     if(confirmacionUsuario==0){
                         modelPermisoDAO.eliminarDatosEmpleadoBeneficio(listaNombre.get(i));
                     }
                 }
                 
             }else JOptionPane.showMessageDialog(null, "Por favor seleccionar almenos una Fila");
             setTableEmpleadoBeneficio(adminView.tablebtnEmpleadosBeneficios);
         }
         
                //EMPLEADOS - HORARIOS
         if(e.getSource() == adminView.btnAdminEmpleadosHorariosRegistrar){
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             String fechaInicio = dateFormat.format(adminView.textAdminEmpleadosHorariosFechaInicio.getDate());
             String fechaFin = dateFormat.format(adminView.textAdminEmpleadosHorariosFechaFin.getDate());
             
            if((fechaInicio.compareTo(fechaFin)) < 0){
             String rstaRegistroHorario = modelPermisoDAO.insertarDatosEmpleadoHorario(fechaInicio,fechaFin);
             if(rstaRegistroHorario!= null){
                     JOptionPane.showMessageDialog(null, rstaRegistroHorario);
                    setTableEmpleadoHorario(adminView.tableAdminEmpleadosHorarios);
             }else{JOptionPane.showMessageDialog(null, "No se pudo registrar");}
            }else{  JOptionPane.showMessageDialog(null, "Fecha Inicio: "+fechaInicio+" es mayor a Fecha Fin : "+fechaFin,"¡ERROR!",JOptionPane.ERROR_MESSAGE);}
         }
         if(e.getSource() == adminView.btnAdminEmpleadosHorariosListar){
              setTableEmpleadoHorario(adminView.tableAdminEmpleadosHorarios);
             
           
         }
         if(e.getSource() == adminView.btnAdminEmpleadosHorariosActualizar){
             int filaActualizar = adminView.tableAdminEmpleadosHorarios.getSelectedRow();
             int numFilas =  adminView.tableAdminEmpleadosHorarios.getSelectedRowCount();
             if(filaActualizar>= 0 && numFilas ==1){
                   codigo_permiso =Integer.parseInt((String) adminView.tableAdminEmpleadosHorarios.getValueAt(filaActualizar, 0));
                  //adminView.textEmpleadosBeneficiosNombre.setText(String.valueOf(adminView.tableAdminEmpleadosHorarios.getValueAt(filaActualizar, 1)));
                 // adminView.textEmpleadosBeneficiosDescripcion.setText(String.valueOf(adminView.tableAdminEmpleadosHorarios.getValueAt(filaActualizar, 2)));
                  
                 adminView.textAdminEmpleadosHorariosFechaInicio.setDate(null);
                  adminView.textAdminEmpleadosHorariosFechaFin.setDate(null);
                  
                  adminView.btnAdminEmpleadosHorariosActualizar.setEnabled(false);
                  adminView.btnAdminEmpleadosHorariosEliminar.setEnabled(false);
                  adminView.btnAdminEmpleadosHorariosRegistrar.setEnabled(false);
                  adminView.btnAdminEmpleadosHorariosListar.setEnabled(false);
                  adminView.textAdminEmpleadosHorariosBuscarFecha.setEditable(false);
                  adminView.btnAdminEmpleadosHorariosActualizarOK.setEnabled(true);
             }else{
                 JOptionPane.showMessageDialog(null, "Por favor seleccionar una Fila");
             }
         
         
         }
         
         if(e.getSource() == adminView.btnAdminEmpleadosHorariosActualizarOK){
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             String fechaInicio = dateFormat.format(adminView.textAdminEmpleadosHorariosFechaInicio.getDate());
             String fechaFin = dateFormat.format(adminView.textAdminEmpleadosHorariosFechaFin.getDate());
             
            if((fechaInicio.compareTo(fechaFin)) < 0){
             int actualizar= modelPermisoDAO.actualizarDatosEmpleadoHorario(fechaInicio,fechaFin ,codigo_permiso);
             if(actualizar > 0){
                 JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
                 setTableEmpleadoHorario(adminView.tableAdminEmpleadosHorarios);
             }else JOptionPane.showMessageDialog(null, "No se ha podido realizar la Actualizacion");
             LimpiarElementosEmpleadoHorario();
            }else{  JOptionPane.showMessageDialog(null, "Fecha Inicio: "+fechaInicio+" es mayor a Fecha Fin : "+fechaFin,"¡ERROR!",JOptionPane.ERROR_MESSAGE);}
         }
         if(e.getSource() == adminView.btnAdminEmpleadosHorariosEliminar){
             int filaInicio= adminView.tableAdminEmpleadosHorarios.getSelectedRow();
             int numFilas =  adminView.tableAdminEmpleadosHorarios.getSelectedRowCount();
             ArrayList<String> listaNombre = new ArrayList();
             String nombreHorario="";
             if( filaInicio  >=0   ){
                 for (int i = 0; i < numFilas ; i++) {
                      nombreHorario= String.valueOf(adminView.tableAdminEmpleadosHorarios.getValueAt(i+filaInicio, 0));
                      listaNombre .add(nombreHorario);
                 }
                 for (int i = 0; i < listaNombre .size() ; i++) {
                     int confirmacionUsuario = JOptionPane.showConfirmDialog(null, "Desea eliminar: "+listaNombre.get(i)+" ?");
                     if(confirmacionUsuario==0){
                         modelPermisoDAO.eliminarDatosEmpleadoHorario(listaNombre.get(i));
                          setTableEmpleadoBeneficio(adminView.tablebtnEmpleadosBeneficios);
                     }
                 }
                 
             }else JOptionPane.showMessageDialog(null, "Por favor seleccionar almenos una Fila");
            
         }
         
         //EMPLEADOS
         if(e.getSource() == adminView.btnAdminEmpleadosListarHorario){
              setTableEmpleadoHorario(adminView.jTableAdminEmpleadosBuscarHorarios);
           
         }
         if(e.getSource() == adminView.btnAdminEmpleadosListarBeneficio){
              setTableEmpleadoBeneficio(adminView.jTableAdminEmpleadosBuscarBeneficio);
           
         }
         if(e.getSource() == adminView.btnAdminEmpleadosListarPermiso){
              setTablePermiso(adminView.jTableAdminEmpleadosBuscarPermisos);
           
         }
         if(e.getSource() == adminView.btnAdminEmpleadosListarROL){
              setTableRol(adminView.jTableAdminEmpleadosBuscarRol);
           
         }
         if(e.getSource() == adminView.btnAdminEmpleadosRegistrar){
             String cedula =(String) adminView.textAdminEmpleadosCedula.getText().toUpperCase();
             String primerNombre = (String)adminView.textAdminEmpleadosPrimerNOmbre.getText().toUpperCase();
             String segundoNombre=(String) adminView.textAdminEmpleadosSegundoNombre.getText().toUpperCase();
             String primerApellido = (String)adminView.textAdminEmpleadosPrimerApellido.getText().toUpperCase();
             String segundoApellido= (String)adminView.textAdminEmpleadosSegundoApellido.getText().toUpperCase();
             String salario= (String)adminView.textAdminEmpleadosSalario.getText().toUpperCase();
             String diasVaciones =(String)adminView.textAdminEmpleadosDiasVacaciones.getText().toUpperCase();
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             String fechaNac = dateFormat.format(adminView.textAdminEmpleadosFechaNacimiento.getDate());
             String usuario = (String)adminView.textAdminEmpleadosUsuario.getText().toUpperCase();
             String pass = (String)adminView.textAdminEmpleadosContrasena.getText().toUpperCase();
             String pregunta = (String)adminView.textAdminEmpleadosPreguntaSecreta.getText().toUpperCase();
             String respuesta = (String)adminView.textAdminEmpleadosRespuestaSecreta.getText().toUpperCase();
             
             int filaActualizarRol = adminView.jTableAdminEmpleadosBuscarRol.getSelectedRow();
             int numFilasRol =  adminView.jTableAdminEmpleadosBuscarRol.getSelectedRowCount();
             
             
             if(filaActualizarRol>= 0 && numFilasRol ==1){
                 int filaActualizarPermiso = adminView.jTableAdminEmpleadosBuscarPermisos.getSelectedRow();
                 int numFilasRolPermiso  =  adminView.jTableAdminEmpleadosBuscarPermisos.getSelectedRowCount();
                 if(filaActualizarPermiso >= 0 && numFilasRolPermiso ==1){
                     int filaActualizarBeneficio =adminView.jTableAdminEmpleadosBuscarBeneficio.getSelectedRow();
                     int numFilasBeneficio = adminView.jTableAdminEmpleadosBuscarBeneficio.getSelectedRowCount();
                     if(filaActualizarBeneficio  >= 0 && numFilasBeneficio ==1){
                         int filaActualizarHorario = adminView.jTableAdminEmpleadosBuscarHorarios.getSelectedRow();
                         int numFilasHorario = adminView.jTableAdminEmpleadosBuscarHorarios.getSelectedRowCount();
                         if(filaActualizarHorario >= 0 && numFilasHorario  ==1){
                             System.out.println("Entro");
                             int respuestaEmpleado = modelPermisoDAO.insertEmpleados(cedula,
                                     primerNombre, segundoNombre, 
                                     primerApellido, segundoApellido, 
                                     salario, diasVaciones, fechaNac, 
                                    /*ROL_PER*/
                                     usuario,
                                     pass,
                                     pregunta, 
                                     respuesta,
                                     /*ROL*/
                                     String.valueOf(adminView.jTableAdminEmpleadosBuscarRol.getValueAt(filaActualizarRol, 0)),
                                     /*PERMISO*/
                                     String.valueOf(adminView.jTableAdminEmpleadosBuscarPermisos.getValueAt(filaActualizarPermiso, 0)), 
                                     /*BENEFICIO*/
                                     String.valueOf(adminView.jTableAdminEmpleadosBuscarBeneficio.getValueAt(filaActualizarBeneficio, 0)),
                                     /*Horario*/
                                     String.valueOf(adminView.jTableAdminEmpleadosBuscarHorarios.getValueAt(filaActualizarHorario, 0)));
                             if(respuestaEmpleado > 0){
                                 JOptionPane.showMessageDialog(null, " Registro Exitoso ");
                             }else JOptionPane.showMessageDialog(null, "Ha Ocurriodo un Error ");
                         }else JOptionPane.showMessageDialog(null, "Por favor seleccionar solo un tipo de Horario");
                         
                     }else JOptionPane.showMessageDialog(null, "Por favor seleccionar solo un tipo de Beneficio");
                     
                 }else JOptionPane.showMessageDialog(null, "Por favor seleccionar solo un tipo de Permiso");
                 
             }else JOptionPane.showMessageDialog(null, "Por favor seleccionar solo un tipo ROL");
         
         }
         
    }

    @Override
    public void keyTyped(KeyEvent e) {
       /*if(e.getSource() == adminView.textAdminPermisoNombre){
           char c = e.getKeyChar();
           //if(c<'0'|| c>'9'){e.consume();} //NUMEROS
           
       }*/
       //PRIVILEGIOS -PERMISOS 
       if(e.getSource() == adminView.textAdminPermisoDescripcion || e.getSource()==adminView.textAdminPermisoNombre){
        char c = e.getKeyChar();    
           if((c<'a'|| c>'z')&&((c<'A'|| c>'Z')&& (c != (char)KeyEvent.VK_SPACE)&& (c != '/'))){e.consume();}       
       }
      //PRIVILEGIOS -Roles
       if(e.getSource() == adminView.textAdminRolNombre1 || e.getSource()==adminView.textAdminRolDescripcion1){
        char c = e.getKeyChar();    
           if((c<'a'|| c>'z')&&((c<'A'|| c>'Z')&& (c != (char)KeyEvent.VK_SPACE)&& (c != '/'))){e.consume();}       
       }
       
       //Empleados - BENEFICIOS
        if(e.getSource() == adminView.textEmpleadosBeneficiosPorcentaje){
           char c = e.getKeyChar();
           if((c<'0'|| c>'9') && (c != '.') && (c != ',')){e.consume();} //NUMEROS
           
       }
       
       if(e.getSource() == adminView.textEmpleadosBeneficiosDescripcion || e.getSource()==adminView.textEmpleadosBeneficiosNombre){
        char c = e.getKeyChar();    
           if((c<'a'|| c>'z')&&((c<'A'|| c>'Z')&& (c != (char)KeyEvent.VK_SPACE)&& (c != '/'))){e.consume();}       
       }
       
       //EMPLEADOS
        if(e.getSource() == adminView.textAdminEmpleadosPrimerNOmbre || e.getSource()==adminView.textAdminEmpleadosPrimerApellido
                || e.getSource()==adminView.textAdminEmpleadosSegundoNombre ||e.getSource()==adminView.textAdminEmpleadosSegundoApellido ||
               e.getSource()==adminView.textAdminEmpleadosRespuestaSecreta){
        char c = e.getKeyChar();    
           if((c<'a'|| c>'z')&&((c<'A'|| c>'Z')&& (c != (char)KeyEvent.VK_SPACE))){e.consume();}       
       }
         if(e.getSource() == adminView.textAdminEmpleadosPreguntaSecreta ){
        char c = e.getKeyChar();    
           if((c<'a'|| c>'z')&&((c<'A'|| c>'Z')&& (c != (char)KeyEvent.VK_SPACE)&& (c != '¿')&& (c != '?'))){e.consume();}       
       }
        if(e.getSource() == adminView.textAdminEmpleadosSalario || e.getSource() == adminView.textAdminEmpleadosCedula){
           char c = e.getKeyChar();
           if((c<'0'|| c>'9') && (c != '.') && (c != ',')){e.consume();} //NUMEROS
           
       }
        if(e.getSource() == adminView.textAdminEmpleadosDiasVacaciones){
           char c = e.getKeyChar();
           if((c<'0'|| c>'9')){e.consume();} //NUMEROS
           
       }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
      
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        //PRIVILEGIOS -PERMISOS 
       if(e.getSource() == adminView.textAdminPermisoBuscar){
           String nombrePermiso= adminView.textAdminPermisoBuscar.getText().toUpperCase();
           buscarPermiso(adminView.tableAdminPermiso,nombrePermiso);
       }
       
       
       //PRIVILEGIOS - ROLES
       
       if(e.getSource() == adminView.textAdminRolBuscar1 ){
            String nombreRol= adminView.textAdminRolBuscar1.getText().toUpperCase();
             buscarRol(adminView.tableAdminRol,nombreRol);
       }
       
       //EMPLEADOS - BENEFICIOS
       
       if(e.getSource() == adminView.textEmpleadosBeneficiosBuscarNombre){
             String nombreBeneficio= adminView.textEmpleadosBeneficiosBuscarNombre.getText().toUpperCase();
            buscarBeneficio(adminView.tablebtnEmpleadosBeneficios,nombreBeneficio);
       }
       
       //EMPLEADOS -HORARIOS
       if(e.getSource() == adminView.textAdminEmpleadosHorariosBuscarFecha){
         
          String fechaInicio = (adminView.textAdminEmpleadosHorariosBuscarFecha.getText());
          buscarHorario(adminView.tableAdminEmpleadosHorarios,fechaInicio);
       }
       
       //Empleados
       if(e.getSource() == adminView.textAdminEmpleadosBuscarNombreRol){
           String nombreListarEmpleadoRol = adminView.textAdminEmpleadosBuscarNombreRol.getText();
            buscarRol(adminView.jTableAdminEmpleadosBuscarRol,nombreListarEmpleadoRol);
       }
       if(e.getSource() == adminView.textAdminEmpleadosBuscarNombrePermiso){
           String nombreListarPermiso = adminView.textAdminEmpleadosBuscarNombrePermiso.getText();
           buscarPermiso(adminView.jTableAdminEmpleadosBuscarPermisos,nombreListarPermiso );
       }
       if(e.getSource() == adminView.textAdminEmpleadosBuscarNombreBeneficio){
           String nombreListarBeneficio = adminView.textAdminEmpleadosBuscarNombreBeneficio.getText();
           buscarBeneficio(adminView.jTableAdminEmpleadosBuscarBeneficio,nombreListarBeneficio);
       }
       if(e.getSource() == adminView.btnAdminEmpleadosListarHorario){
       }
    }

   
    public void buscarPermiso(JTable tablaPermiso,String nombrePermiso){
             
                 DefaultTableModel modelTablaPermiso= new DefaultTableModel();
             tablaPermiso.setModel(modelTablaPermiso);
             modelTablaPermiso.addColumn("Codigo");
             modelTablaPermiso.addColumn("Nombre");
             modelTablaPermiso.addColumn("Descripcion");

             Object[] columnaPermiso = new Object[3];
             int numeroRegistroPermiso = modelPermisoDAO.listPermisoXNOmbre(nombrePermiso).size();

             for (int i = 0; i < numeroRegistroPermiso; i++) {
                columnaPermiso[0]=  modelPermisoDAO.listPermisoXNOmbre(nombrePermiso).get(i).getCondigoPermiso();
                columnaPermiso[1]=  modelPermisoDAO.listPermisoXNOmbre(nombrePermiso).get(i).getNombrePermiso();
                columnaPermiso[2]=  modelPermisoDAO.listPermisoXNOmbre(nombrePermiso).get(i).getDescripcionPermiso();
                modelTablaPermiso.addRow(columnaPermiso);
             }
    }
    public void buscarRol(JTable tablaRol,String nombreRol){
       
                 DefaultTableModel modelTablaRol= new DefaultTableModel();
             tablaRol.setModel(modelTablaRol);
             modelTablaRol.addColumn("Codigo");
             modelTablaRol.addColumn("Nombre");
             modelTablaRol.addColumn("Descripcion");

             Object[] columnaPermiso = new Object[3];
             int numeroRegistroPermiso = modelPermisoDAO.listRolXNOmbre(nombreRol).size();

             for (int i = 0; i < numeroRegistroPermiso; i++) {
                columnaPermiso[0]=  modelPermisoDAO.listRolXNOmbre(nombreRol).get(i).getCondigoRol();
                columnaPermiso[1]=  modelPermisoDAO.listRolXNOmbre(nombreRol).get(i).getNombreRol();
                columnaPermiso[2]=  modelPermisoDAO.listRolXNOmbre(nombreRol).get(i).getDescripcionRol();
                modelTablaRol.addRow(columnaPermiso);
             }
    }
    
    public void buscarBeneficio(JTable tablaBeneficio,String nombreBeneficio){
        DefaultTableModel modelTablaBeneficio= new DefaultTableModel();
            tablaBeneficio.setModel(modelTablaBeneficio);
             modelTablaBeneficio.addColumn("Codigo");
             modelTablaBeneficio.addColumn("Nombre");
             modelTablaBeneficio.addColumn("Descripcion");
             modelTablaBeneficio.addColumn("Porcentaje %");

            Object[] columnaBeneficio= new Object[4];
            int numeroRegistroPermiso = modelPermisoDAO.listBeneficioXNOmbre(nombreBeneficio).size();

            for (int i = 0; i < numeroRegistroPermiso; i++) {
               columnaBeneficio[0]= modelPermisoDAO.listBeneficioXNOmbre(nombreBeneficio).get(i).getCodigoBeneficio();
               columnaBeneficio[1]=  modelPermisoDAO.listBeneficioXNOmbre(nombreBeneficio).get(i).getNombreBenefico();
              columnaBeneficio[2]=  modelPermisoDAO.listBeneficioXNOmbre(nombreBeneficio).get(i).getDescripcionBeneficio();
              columnaBeneficio[3]=  modelPermisoDAO.listBeneficioXNOmbre(nombreBeneficio).get(i).getPorcentajeBeneficio();
              modelTablaBeneficio.addRow(columnaBeneficio);
            }
    }
    public void buscarHorario(JTable tablaHorario,String fechaInicio){
         
        
        DefaultTableModel modelTabla= new DefaultTableModel();
        tablaHorario.setModel(modelTabla);
         modelTabla.addColumn("Codigo");
         modelTabla.addColumn("Fecha Inicio");
         modelTabla.addColumn("Fecha Final");
       
        if(!fechaInicio .isEmpty()){
        /*    String fecha = fechaInicio;
        String[] numerosComoArray = fecha .split("-");
        
            System.out.println(numerosComoArray[0]);
            System.out.println(numerosComoArray[1]);
            System.out.println(numerosComoArray[2]);
            String ano=numerosComoArray[0];
            String mes=numerosComoArray[1];
            String dia=numerosComoArray[2];
            
            Object[] columna= new Object[3];
            int numeroRegistro = modelPermisoDAO.listEmpleadoHorarioXFechaInicio(ano,mes,dia).size();

            for (int i = 0; i < numeroRegistro; i++) {
               columna[0]= modelPermisoDAO.listEmpleadoHorarioXFechaInicio(ano,mes,dia).get(i).getCodigoHorario();
               columna[1]=  modelPermisoDAO.listEmpleadoHorarioXFechaInicio(ano,mes,dia).get(i).getFechaInicioHorario();
              columna[2]=  modelPermisoDAO.listEmpleadoHorarioXFechaInicio(ano,mes,dia).get(i).getFechafinHorario();

              modelTabla.addRow(columna);
            }*/
        }
       
    }
   
    
}
