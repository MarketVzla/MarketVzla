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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import Modelo.ExpresionesRegulares;
import Modelo.Lugar;
import static Modelo.Lugar.ConsultarEstados;
import Modelo.PermisoDAO;
import Modelo.emp_hor;
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
    public ArrayList<String> estados;
    public ArrayList<String> municipios;
    public ArrayList<String> parroquias;
    public ArrayList<String> estadosJuridicoFiscal;
    public ArrayList<String> municipiosJuridicoFiscal;
    public ArrayList<String> parroquiasJuridicoFiscal;
    public ArrayList<String> estadosJuridicoFisica;
    public ArrayList<String> municipiosJuridicoFisica;
    public ArrayList<String> parroquiasJuridicoFisica;
    
    
    private int codigo_permiso;
    private String cedula;
    
    
    public void LlenarLugares(){
        adminView.jComboBoxRegistroCLienteNaturalMunicipio.removeAllItems();
            adminView.jComboBoxRegistroCLienteNaturalParroquia.removeAllItems();
            
            adminView.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFiscal.removeAllItems();
             adminView.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFiscal.removeAllItems();
             
            adminView.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFisica.removeAllItems();
            adminView.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFisica.removeAllItems();
            
        estados = Lugar.ConsultarEstados(1);
        int i=1;
        while(i<=estados.size())
        {
            adminView.jComboBoxRegistroCLienteNaturalEstado.addItem(estados.get(i));
            
            i=i+2;
        }
       
        
            int estado=0;
            for(i=0;i<estados.size();i++)
            {
                if(estados.get(i).equals( adminView.jComboBoxRegistroCLienteNaturalEstado.getSelectedItem()))
                {
                    estado=Integer.parseInt(estados.get(i-1));
                    break;
                }
            }
            municipios = Lugar.ConsultarMunicipios(estado);

             i=1;

            while(i<municipios.size())
            { 
               adminView.jComboBoxRegistroCLienteNaturalMunicipio.addItem(municipios.get(i));
                i=i+2;
            }
         
        
        
           
            int parroquia=0;
            for( i=0;i<municipios.size();i++)
            {
                if(municipios.get(i).equals(adminView.jComboBoxRegistroCLienteNaturalMunicipio.getSelectedItem()))
                {
                    parroquia=Integer.parseInt(municipios.get(i-1));
                    break;
                }
            }
            parroquias = Lugar.ConsultarParroquias(parroquia);

            i=1;

            while(i<parroquias.size())
            {
                adminView.jComboBoxRegistroCLienteNaturalParroquia.addItem(parroquias.get(i));
                i=i+2;
            }
       //DIRECCION FISCAL
       estadosJuridicoFiscal = Lugar.ConsultarEstados(1);
         i=1;
        while(i<=estadosJuridicoFiscal.size())
        {
        
            adminView.jComboBoxRegistroCLienteJuridicoEstadoDireccionFiscal.addItem(estadosJuridicoFiscal.get(i));
            i=i+2;
        }
       
        
            estado=0;
            for(i=0;i<estadosJuridicoFiscal.size();i++)
            {
                if(estadosJuridicoFiscal.get(i).equals( adminView.jComboBoxRegistroCLienteJuridicoEstadoDireccionFiscal.getSelectedItem()))
                {
                    estado=Integer.parseInt(estadosJuridicoFiscal.get(i-1));
                    break;
                }
            }
            municipiosJuridicoFiscal = Lugar.ConsultarMunicipios(estado);

             i=1;

            while(i<municipiosJuridicoFiscal.size())
            { 
                adminView.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFiscal.addItem(municipiosJuridicoFiscal.get(i));
                i=i+2;
            }
         
        
        
           
             parroquia=0;
            for( i=0;i<municipiosJuridicoFiscal.size();i++)
            {
                if(municipiosJuridicoFiscal.get(i).equals(adminView.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFiscal.getSelectedItem()))
                {
                    parroquia=Integer.parseInt(municipiosJuridicoFiscal.get(i-1));
                    break;
                }
            }
            parroquiasJuridicoFiscal = Lugar.ConsultarParroquias(parroquia);

            i=1;

            while(i<parroquiasJuridicoFiscal.size())
            {
                adminView.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFiscal.addItem(parroquiasJuridicoFiscal.get(i));
                 i=i+2;
            }
            //DIRECCION Fisica
       estadosJuridicoFisica = Lugar.ConsultarEstados(1);
         i=1;
        while(i<=estadosJuridicoFisica.size())
        {
        
            adminView.jComboBoxRegistroCLienteJuridicoEstadoDireccionFisica.addItem(estadosJuridicoFisica.get(i));
            i=i+2;
        }
       
        
            estado=0;
            for(i=0;i<estadosJuridicoFisica.size();i++)
            {
                if(estadosJuridicoFisica.get(i).equals( adminView.jComboBoxRegistroCLienteJuridicoEstadoDireccionFisica.getSelectedItem()))
                {
                    estado=Integer.parseInt(estadosJuridicoFisica.get(i-1));
                    break;
                }
            }
            municipiosJuridicoFisica = Lugar.ConsultarMunicipios(estado);

             i=1;

            while(i<municipiosJuridicoFisica.size())
            { 
                adminView.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFisica.addItem(municipiosJuridicoFisica.get(i));
                i=i+2;
            }
         
        
        
           
             parroquia=0;
            for( i=0;i<municipiosJuridicoFisica.size();i++)
            {
                if(municipiosJuridicoFisica.get(i).equals(adminView.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFisica.getSelectedItem()))
                {
                    parroquia=Integer.parseInt(municipiosJuridicoFisica.get(i-1));
                    break;
                }
            }
            parroquiasJuridicoFisica = Lugar.ConsultarParroquias(parroquia);

            i=1;

            while(i<parroquiasJuridicoFisica.size())
            {
                adminView.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFisica.addItem(parroquiasJuridicoFisica.get(i));
                 i=i+2;
            }
    
    }
    public AdminController( AdminVista adminView,LoginVista loginview,PermisoDAO modelPermisoDAO){
        this.adminView=adminView;
        this.modelPermisoDAO=modelPermisoDAO;
       this.loginview=loginview;
       // adminView.jTabbedPaneAdmin.remove(adminView.jPanelPrivilegios);
        LlenarLugares();
 
       
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
         modelTabla.addColumn("Dia");
         modelTabla.addColumn("Hora Inicial");
         modelTabla.addColumn("Hora Final");
         
        
        Object[] columna= new Object[4];
        int numeroRegistro = modelPermisoDAO.listEmpleadoHorario().size();
        
        for (int i = 0; i < numeroRegistro; i++) {
           columna[0]= modelPermisoDAO.listEmpleadoHorario().get(i).getCodigoHorario();
           columna[1]=  modelPermisoDAO.listEmpleadoHorario().get(i).getDiaHorario();
          columna[2]=  modelPermisoDAO.listEmpleadoHorario().get(i).getHorarioInicial();
          columna[3]= modelPermisoDAO.listEmpleadoHorario().get(i).getHorarioFinal();
          modelTabla.addRow(columna);
        }
        
    }
    
     public void LimpiarElementosEmpleadoHorario(){
        adminView.btnAdminEmpleadosHorariosActualizar.setEnabled(true);
                  adminView.btnAdminEmpleadosHorariosRegistrar.setEnabled(true);
                  adminView.btnAdminEmpleadosHorariosEliminar.setEnabled(true);
                  adminView.btnAdminEmpleadosHorariosListar.setEnabled(true);
             
                  adminView.btnAdminEmpleadosHorariosActualizarOK.setEnabled(false);
                  
                   adminView.textAdminEmpleadosHorariosBuscarDia.setEditable(true);
                
    }
    //TIENDAS
      public void setEmpleadosTienda(JTable tablaTienda){
        DefaultTableModel modelTabla= new DefaultTableModel();
        tablaTienda.setModel(modelTabla);
         modelTabla.addColumn("Codigo Departamento");
         modelTabla.addColumn("Nombre Departamento");
         modelTabla.addColumn("Descripcion Departamento");
         modelTabla.addColumn("Nombre Tienda");
         //modelTabla.addColumn("Lugar");
         
         Object[] columna= new Object[4];
        int numeroRegistro = modelPermisoDAO.listEmpleadoTiendas().size();
        
        for (int i = 0; i < numeroRegistro; i++) {
           columna[0]= modelPermisoDAO.listEmpleadoTiendas().get(i).getCodigo();
           columna[1]=  modelPermisoDAO.listEmpleadoTiendas().get(i).getNombreDepartamento();
          columna[2]=  modelPermisoDAO.listEmpleadoTiendas().get(i).getDescripcion();
          columna[3]= modelPermisoDAO.listEmpleadoTiendas().get(i).getNombreTeinda();
          //columna[4]= Lugar.lugarFK(modelPermisoDAO.listEmpleadoTiendas().get(i).getTie_lugar());
          
          modelTabla.addRow(columna);
        }
    }
      //EMPLEADOS
      
      public void setEmpleados(JTable tablaEmpleados, String fk_tienda){
        DefaultTableModel modelTabla= new DefaultTableModel();
        tablaEmpleados.setModel(modelTabla);
         modelTabla.addColumn("Cedula");
         modelTabla.addColumn("Nombre");
         modelTabla.addColumn("Apellido");
         modelTabla.addColumn("Salario");
         modelTabla.addColumn("Fecha Nacimiento");
         modelTabla.addColumn("Fecha Ingreso");
         modelTabla.addColumn("Departamendo Actual");
         
         
         
         Object[] columna= new Object[7];
        int numeroRegistro = modelPermisoDAO.ListarEmpleadosPorTienda(fk_tienda).size();
        
        for (int i = 0; i < numeroRegistro; i++) {
           columna[0]= modelPermisoDAO.ListarEmpleadosPorTienda(fk_tienda).get(i).getCedulaEmpleado();
           columna[1]=  modelPermisoDAO.ListarEmpleadosPorTienda(fk_tienda).get(i).getPrimerNombreEmpleado();
          columna[2]=  modelPermisoDAO.ListarEmpleadosPorTienda(fk_tienda).get(i).getPrimerApellidoEmpleado();
          columna[3]= modelPermisoDAO.ListarEmpleadosPorTienda(fk_tienda).get(i).getSalarioEMpleado();
          columna[4]= modelPermisoDAO.ListarEmpleadosPorTienda(fk_tienda).get(i).getFechaNacimientoEMpleado();
          columna[5]= modelPermisoDAO.ListarEmpleadosPorTienda(fk_tienda).get(i).getFechaIngreso();
           columna[6]= modelPermisoDAO.ListarEmpleadosPorTienda(fk_tienda).get(i).getTienda();
          
          modelTabla.addRow(columna);
        }
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
         if(e.getSource() == adminView.btnAdminEmpleadosBeneficiosEmpleadosAgisnar){
             int filaActualizar = adminView.tablebtnEmpleadosBeneficios.getSelectedRow();
             int numFilas =  adminView.tablebtnEmpleadosBeneficios.getSelectedRowCount();
             if(filaActualizar>= 0 && numFilas ==1){
                   int filaActualizar2 = adminView.tableAdminEmpleadosHorariosBuscarEmpleados1.getSelectedRow();
                    int numFilas2 =  adminView.tableAdminEmpleadosHorariosBuscarEmpleados1.getSelectedRowCount();
                    if(filaActualizar2>= 0 && numFilas2 ==1){
                            String respuesta = modelPermisoDAO.insertarDatosEmp_Ben((String) adminView.tableAdminEmpleadosHorariosBuscarEmpleados1.getValueAt(filaActualizar2, 0),
                                    (String) adminView.tablebtnEmpleadosBeneficios.getValueAt(filaActualizar, 0));
                                            
                            if(respuesta != null){
                                 JOptionPane.showMessageDialog(null, "Beneficio Asignado");
                                 
                            }else JOptionPane.showMessageDialog(null, "Error Inesperado, no se pudo concluir con la operacion");
                    }else{
                        JOptionPane.showMessageDialog(null, "Por favor seleccionar un Empleado");
                    }
             }else{
                 JOptionPane.showMessageDialog(null, "Por favor seleccionar un Beneficio");
             }
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
             
            String diaHora = (String)adminView.jComboBoxAdminEmpleadosHorariosDias.getItemAt(adminView.jComboBoxAdminEmpleadosHorariosDias.getSelectedIndex());
            /* Calendar c = Calendar.getInstance();
                   String dia = Integer.toString(c.get(Calendar.DATE));
                   int   mes = c.get(Calendar.MONTH)+1;
                   String  annio = Integer.toString(c.get(Calendar.YEAR));
                   String fechaActualHoraInicio = annio+"-"+mes+"-"+dia;
                   String fechaActualHoraFinal = annio+"-"+mes+"-"+dia;
            */
                String horaInicial =  adminView.SpinnerAdminEmpleadosHorariosHoraInicial.getValue().toString();
                 String horaFinal =adminView.SpinnerAdminEmpleadosHorariosHoraFinal.getValue().toString();
            
                if((horaInicial .compareTo(horaFinal)) < 0){
                       String rstaRegistroHorario = modelPermisoDAO.insertarDatosEmpleadoHorario(diaHora,horaInicial,horaFinal);
             if(rstaRegistroHorario!= null){
                     JOptionPane.showMessageDialog(null, rstaRegistroHorario);
                    setTableEmpleadoHorario(adminView.tableAdminEmpleadosHorarios);
             }else{JOptionPane.showMessageDialog(null, "No se pudo registrar");}
                    
                   }else{  JOptionPane.showMessageDialog(null, "Fecha Inicio: "+horaInicial+" es mayor a Fecha Fin : "+horaFinal,"¡ERROR!",JOptionPane.ERROR_MESSAGE);}
        
             
         }
         if(e.getSource()== adminView.btnAdminEmpleadosHorariosEmpleadosAsignar){
             int filaActualizar = adminView.tableAdminEmpleadosHorarios.getSelectedRow();
             int numFilas =  adminView.tableAdminEmpleadosHorarios.getSelectedRowCount();
             if(filaActualizar>= 0 && numFilas ==1){
                   int filaActualizar2 = adminView.tableAdminEmpleadosHorariosBuscarEmpleados.getSelectedRow();
                    int numFilas2 =  adminView.tableAdminEmpleadosHorariosBuscarEmpleados.getSelectedRowCount();
                    if(filaActualizar2>= 0 && numFilas2 ==1){
                            String respuesta = modelPermisoDAO.insertarDatoseEmp_hor((String) adminView.tableAdminEmpleadosHorariosBuscarEmpleados.getValueAt(filaActualizar2, 0),
                                    (String) adminView.tableAdminEmpleadosHorarios.getValueAt(filaActualizar, 0));
                                            
                            if(respuesta != null){
                                 JOptionPane.showMessageDialog(null, "Horario Asignado");
                                 setTableEmpleadoHorario(adminView.tableAdminEmpleadosHorarios);
                            }else JOptionPane.showMessageDialog(null, "Error Inesperado, no se pudo concluir con la operacion");
                    }else{
                        JOptionPane.showMessageDialog(null, "Por favor seleccionar un Empleado");
                    }
             }else{
                 JOptionPane.showMessageDialog(null, "Por favor seleccionar un Horario");
             }
         }
         
         if(e.getSource() == adminView.btnAdminEmpleadosHorariosListar){
              setTableEmpleadoHorario(adminView.tableAdminEmpleadosHorarios);
             
           
         }
         if(e.getSource() == adminView.btnAdminEmpleadosHorariosActualizar){
             int filaActualizar = adminView.tableAdminEmpleadosHorarios.getSelectedRow();
             int numFilas =  adminView.tableAdminEmpleadosHorarios.getSelectedRowCount();
             if(filaActualizar>= 0 && numFilas ==1){
                   codigo_permiso =Integer.parseInt((String) adminView.tableAdminEmpleadosHorarios.getValueAt(filaActualizar, 0));
                        //adminView.SpinnerAdminEmpleadosHorariosHoraInicial.setValue((String) adminView.tableAdminEmpleadosHorarios.getValueAt(filaActualizar, 2));

                adminView.jComboBoxAdminEmpleadosHorariosDias.setSelectedItem(String.valueOf(adminView.tableAdminEmpleadosHorarios.getValueAt(filaActualizar, 1)));
                
                /*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
             String fechaNac = dateFormat.format(adminView.textAdminEmpleadosFechaNacimiento.getDate());
               */
                String dateTime = (String) adminView.tableAdminEmpleadosHorarios.getValueAt(filaActualizar, 2);
                 String dateTime2 = (String) adminView.tableAdminEmpleadosHorarios.getValueAt(filaActualizar, 3); 
                
                     Date date,date2;
                 try {
                     date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateTime);
                     adminView.SpinnerAdminEmpleadosHorariosHoraInicial.setValue(date);
                     
                     date2 =  new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateTime2);
                     adminView.SpinnerAdminEmpleadosHorariosHoraFinal.setValue(date2);
                 } catch (ParseException ex) {
                     Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                 }
                     
                 
                        
                     
                
                
                  adminView.btnAdminEmpleadosHorariosActualizar.setEnabled(false);
                  adminView.btnAdminEmpleadosHorariosEliminar.setEnabled(false);
                  adminView.btnAdminEmpleadosHorariosRegistrar.setEnabled(false);
                  adminView.btnAdminEmpleadosHorariosListar.setEnabled(false);
                  adminView.textAdminEmpleadosHorariosBuscarDia.setEditable(false);
                  adminView.btnAdminEmpleadosHorariosActualizarOK.setEnabled(true);
             }else{
                 JOptionPane.showMessageDialog(null, "Por favor seleccionar una Fila");
             }
         
         
         }
         
         if(e.getSource() == adminView.btnAdminEmpleadosHorariosActualizarOK){
            String diaHora = (String)adminView.jComboBoxAdminEmpleadosHorariosDias.getItemAt(adminView.jComboBoxAdminEmpleadosHorariosDias.getSelectedIndex());
                 String horaInicial =  adminView.SpinnerAdminEmpleadosHorariosHoraInicial.getValue().toString();
                 String horaFinal =adminView.SpinnerAdminEmpleadosHorariosHoraFinal.getValue().toString();
            
             int actualizar= modelPermisoDAO.actualizarDatosEmpleadoHorario(diaHora ,horaInicial,horaFinal ,codigo_permiso);
             if(actualizar > 0){
                 JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
                 setTableEmpleadoHorario(adminView.tableAdminEmpleadosHorarios);
             }else JOptionPane.showMessageDialog(null, "No se ha podido realizar la Actualizacion");
             LimpiarElementosEmpleadoHorario();
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
         //Sistema de COntrol
          if(e.getSource() == adminView.btnAdminEmpleadosHorariosRegistrar1){
            int filaActualizar = adminView.tableAdminEmpleadosHorariosBuscarEmpleados2.getSelectedRow();
             int numFilas =  adminView.tableAdminEmpleadosHorariosBuscarEmpleados2.getSelectedRowCount();
             if(filaActualizar>= 0 && numFilas ==1){
                   
                 try {
                     cedula =(String) adminView.tableAdminEmpleadosHorariosBuscarEmpleados2.getValueAt(filaActualizar, 0);
                    emp_hor empleado_horario = new emp_hor();
                    String horaInicial =  adminView.SpinnerAdminEmpleadosControlHorariosHoraInicial1.getValue().toString();
                 String horaFinal =adminView.SpinnerAdminEmpleadosHorariosHoraFinal1.getValue().toString();
                 
                   empleado_horario=modelPermisoDAO.listEmpleadoEmp_horXCedula(cedula).get(0);
                   //System.out.println("Cod "+empleado_horario.getEh_codigo()+" Hor: "+empleado_horario.getEh_fk_horario()+" Cedula: "+empleado_horario.getEh_fk_empleado());
                 
                   if((horaInicial .compareTo(horaFinal)) < 0){
                     String rstaRegistroHorario = modelPermisoDAO.insertarDatosEmpleadoCheck(empleado_horario.getEh_codigo(),horaInicial,horaFinal);
                        if(rstaRegistroHorario!= null){
                                 JOptionPane.showMessageDialog(null, rstaRegistroHorario);
                                setTableEmpleadoHorario(adminView.tableAdminEmpleadosHorarios);
                        }else{JOptionPane.showMessageDialog(null, "No se pudo registrar");}
                    
                  }else{  JOptionPane.showMessageDialog(null, "Fecha Inicio: "+horaInicial+" es mayor a Fecha Fin : "+horaFinal,"¡ERROR!",JOptionPane.ERROR_MESSAGE);}
         
                   
                 } catch (IndexOutOfBoundsException e12) {
                     JOptionPane.showMessageDialog(null, "Por favor debe Añadir un horario al Empleado Selccionado");
                 }
                
                
                   
             }else{
                 JOptionPane.showMessageDialog(null, "Por favor seleccionar un Empleado");
             } 
              
          }
          
          if(e.getSource() == adminView.btnAdminEmpleadosHorariosEliminar1){
              int filaInicio= adminView.tableAdminEmpleadosHorarios1.getSelectedRow();
             int numFilas =  adminView.tableAdminEmpleadosHorarios1.getSelectedRowCount();
             ArrayList<String> listaNombre = new ArrayList();
             String nombreHorario="";
             if( filaInicio  >=0   ){
                 for (int i = 0; i < numFilas ; i++) {
                      nombreHorario= String.valueOf(adminView.tableAdminEmpleadosHorarios1.getValueAt(i+filaInicio, 0));
                      listaNombre .add(nombreHorario);
                 }
                 for (int i = 0; i < listaNombre .size() ; i++) {
                     int confirmacionUsuario = JOptionPane.showConfirmDialog(null, "Desea eliminar: "+listaNombre.get(i)+" ?");
                     if(confirmacionUsuario==0){
                         modelPermisoDAO.eliminarDatosCheck(listaNombre.get(i));
                          setTableEmpleadoBeneficio(adminView.tablebtnEmpleadosBeneficios);
                     }
                 }
                 
             }else JOptionPane.showMessageDialog(null, "Por favor seleccionar almenos una Fila");
            
          }
          if(e.getSource() == adminView.btnAdminEmpleadosHorariosActualizar1){
              int filaActualizar = adminView.tableAdminEmpleadosHorarios1.getSelectedRow();
             int numFilas =  adminView.tableAdminEmpleadosHorarios1.getSelectedRowCount();
             if(filaActualizar>= 0 && numFilas ==1){
                   codigo_permiso =Integer.parseInt((String) adminView.tableAdminEmpleadosHorarios1.getValueAt(filaActualizar, 0));
               
                String dateTime = (String) adminView.tableAdminEmpleadosHorarios1.getValueAt(filaActualizar, 3);
                 String dateTime2 = (String) adminView.tableAdminEmpleadosHorarios1.getValueAt(filaActualizar, 4); 
                
                     Date date,date2;
                 try {
                     date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateTime);
                     adminView.SpinnerAdminEmpleadosControlHorariosHoraInicial1.setValue(date);
                     
                     date2 =  new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateTime2);
                     adminView.SpinnerAdminEmpleadosHorariosHoraFinal1.setValue(date2);
                 } catch (ParseException ex) {
                     Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                 }
                     
                 
                        
                     
                
                
                  adminView.btnAdminEmpleadosHorariosActualizar1.setEnabled(false);
                  adminView.btnAdminEmpleadosHorariosEliminar1.setEnabled(false);
                  adminView.btnAdminEmpleadosHorariosRegistrar1.setEnabled(false);
                  //adminView.btnAdminEmpleadosHorariosListar.setEnabled(false);
                  adminView.textAdminEmpleadosHorariosBuscarDia1.setEditable(false);
                  adminView.btnAdminEmpleadosHorariosActualizarOK1.setEnabled(true);
             }else{
                 JOptionPane.showMessageDialog(null, "Por favor seleccionar una Fila");
             }
          }
           if(e.getSource() == adminView.btnAdminEmpleadosHorariosActualizarOK1){
           // String diaHora = (String)adminView.jComboBoxAdminEmpleadosHorariosDias.getItemAt(adminView.jComboBoxAdminEmpleadosHorariosDias.getSelectedIndex());
                 String horaInicial =  adminView.SpinnerAdminEmpleadosControlHorariosHoraInicial1.getValue().toString();
                 String horaFinal =adminView.SpinnerAdminEmpleadosHorariosHoraFinal1.getValue().toString();
            
             int actualizar= modelPermisoDAO.actualizarDatosEmpleadoCheck(horaInicial,horaFinal ,codigo_permiso);
             if(actualizar > 0){
                 JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
                 adminView.btnAdminEmpleadosHorariosActualizar1.setEnabled(true);
                  adminView.btnAdminEmpleadosHorariosEliminar1.setEnabled(true);
                  adminView.btnAdminEmpleadosHorariosRegistrar1.setEnabled(true);
                  //adminView.btnAdminEmpleadosHorariosListar.setEnabled(false);
                  adminView.textAdminEmpleadosHorariosBuscarDia1.setEditable(true);
                  adminView.btnAdminEmpleadosHorariosActualizarOK1.setEnabled(false);
             }else JOptionPane.showMessageDialog(null, "No se ha podido realizar la Actualizacion");
             LimpiarElementosEmpleadoHorario();
         }
         
         //EMPLEADOS
         if(e.getSource() == adminView.btnAdminEmpleadosListarTiendas){
             setEmpleadosTienda(adminView.TableAdminEmpleadosBuscarTiendas);
         }
         if(e.getSource() == adminView.btnAdminEmpleadosRegistrar){
             String cedula =(String) adminView.textAdminEmpleadosCedula.getText().toUpperCase();
             String primerNombre = (String)adminView.textAdminEmpleadosPrimerNOmbre.getText().toUpperCase();
             String segundoNombre=(String) adminView.textAdminEmpleadosSegundoNombre.getText().toUpperCase();
             String primerApellido = (String)adminView.textAdminEmpleadosPrimerApellido.getText().toUpperCase();
             String segundoApellido= (String)adminView.textAdminEmpleadosSegundoApellido.getText().toUpperCase();
           
             String salario= (String)adminView.textAdminEmpleadosSalario.getText().toUpperCase();
            String telefono =(String)adminView.textAdminEmpleadosTelefono.getText().toUpperCase();
             
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             String fechaNac = dateFormat.format(adminView.textAdminEmpleadosFechaNacimiento.getDate());
             
             
             String usuario = (String)adminView.textAdminEmpleadosUsuario.getText().toUpperCase();
             String pass = (String)adminView.textAdminEmpleadosContrasena.getText().toUpperCase();
             String pregunta = (String)adminView.textAdminEmpleadosPreguntaSecreta.getText().toUpperCase();
             String respuesta = (String)adminView.textAdminEmpleadosRespuestaSecreta.getText().toUpperCase();
             if(ExpresionesRegulares.validarTelefono(telefono)){
             int filaActualizarTienda = adminView.TableAdminEmpleadosBuscarTiendas.getSelectedRow();
             int numFilasTienda=  adminView.TableAdminEmpleadosBuscarTiendas.getSelectedRowCount();
              if(filaActualizarTienda >= 0 && numFilasTienda  ==1){
                  int filaActualizarRol = adminView.jTableAdminEmpleadosBuscarRol.getSelectedRow();
                  int numFilasRol =  adminView.jTableAdminEmpleadosBuscarRol.getSelectedRowCount();          
                    if(filaActualizarRol>= 0 && numFilasRol ==1){
                        int filaActualizarPermiso = adminView.jTableAdminEmpleadosBuscarPermisos.getSelectedRow();
                        int numFilasRolPermiso  =  adminView.jTableAdminEmpleadosBuscarPermisos.getSelectedRowCount();
                        if(filaActualizarPermiso >= 0 && numFilasRolPermiso ==1){
                             System.out.println("Entro");
                             int respuestaEmpleado = modelPermisoDAO.insertEmpleados(cedula,
                                     primerNombre, segundoNombre, 
                                     primerApellido, segundoApellido, 
                                     salario/*, diasVaciones*/, fechaNac, telefono,
                                     String.valueOf(adminView.TableAdminEmpleadosBuscarTiendas.getValueAt(filaActualizarTienda, 0)),
                                       /*Usuaruio*/     usuario,pass,pregunta,respuesta,
                                       /*ROl _PER*/
                                       /*ROL*/
                                    String.valueOf(adminView.jTableAdminEmpleadosBuscarRol.getValueAt(filaActualizarRol, 0)),
                                     /*PERMISO*/
                                        String.valueOf(adminView.jTableAdminEmpleadosBuscarPermisos.getValueAt(filaActualizarPermiso, 0)) 
                             );
                              
                             if(respuestaEmpleado > 0){
                                 JOptionPane.showMessageDialog(null, " Registro Exitoso ");
                             }else JOptionPane.showMessageDialog(null, "Ha Ocurriodo un Error ");
                     }else JOptionPane.showMessageDialog(null, "Por favor seleccionar solo un tipo de Permiso");
                    }else JOptionPane.showMessageDialog(null, "Por favor seleccionar solo un tipo ROL");
              }else JOptionPane.showMessageDialog(null, "Por favor seleccionar solo un Departamento");
             }else JOptionPane.showMessageDialog(null, "Telefono Invalido");        
             
         }
         if(e.getSource() == adminView.btnAdminEmpleadosListarEmpleados1){
             int filaActualizarTienda = adminView.TableAdminEmpleadosBuscarTiendas.getSelectedRow();
             int numFilasTienda=  adminView.TableAdminEmpleadosBuscarTiendas.getSelectedRowCount();
              if(filaActualizarTienda >= 0 && numFilasTienda  ==1){
                             System.out.println("Entro");
                             setEmpleados(adminView.TableAdminEmpleadosBuscar1,  String.valueOf(adminView.TableAdminEmpleadosBuscarTiendas.getValueAt(filaActualizarTienda, 0)));
                                    
                              
                            
              }else JOptionPane.showMessageDialog(null, "Por favor seleccionar solo una TIENDA");
         }
         if(e.getSource() == adminView.btnAdminEmpleadosActualizar){
              int filaActualizar = adminView.TableAdminEmpleadosBuscar1.getSelectedRow();
             int numFilas =  adminView.TableAdminEmpleadosBuscar1.getSelectedRowCount();
             if(filaActualizar>= 0 && numFilas ==1){
                   cedula =(String) adminView.TableAdminEmpleadosBuscar1.getValueAt(filaActualizar, 0);
                    
                   modelPermisoDAO.setUpdateEmpleado(cedula,
                           adminView.textAdminEmpleadosCedula, 
                           adminView.textAdminEmpleadosPrimerNOmbre, 
                           adminView.textAdminEmpleadosSegundoNombre, 
                           adminView.textAdminEmpleadosPrimerApellido, 
                           adminView.textAdminEmpleadosSegundoApellido, 
                           adminView.textAdminEmpleadosSalario,
                           adminView.textAdminEmpleadosTelefono,
                          // adminView.textAdminEmpleadosDiasVacaciones, 
                           adminView.textAdminEmpleadosFechaNacimiento, 
                           adminView.textAdminEmpleadosUsuario, 
                           adminView.textAdminEmpleadosContrasena, 
                           adminView.textAdminEmpleadosPreguntaSecreta, 
                           adminView.textAdminEmpleadosRespuestaSecreta);
                   
                   /*adminView.textAdminEmpleadosCedula.setText(cedula);
                     adminView.textAdminEmpleadosPrimerNOmbre.setText((String) adminView.TableAdminEmpleadosBuscar1.getValueAt(filaActualizar, 1));
                      
                       adminView.textAdminEmpleadosPrimerApellido.setText((String)adminView.TableAdminEmpleadosBuscar1.getValueAt(filaActualizar, 2));
            
             adminView.textAdminEmpleadosSalario.setText((String) adminView.TableAdminEmpleadosBuscar1.getValueAt(filaActualizar, 3));
             */
                    
                         adminView.textAdminEmpleadosCedula.setEditable(false);
                         adminView.textAdminEmpleadosPrimerNOmbre.setEditable(false);
                         adminView.textAdminEmpleadosSegundoNombre.setEditable(false);
                         adminView.textAdminEmpleadosPrimerApellido.setEditable(false);
                         adminView.textAdminEmpleadosSegundoApellido.setEditable(false);
                         adminView.textAdminEmpleadosUsuario.setEditable(false);
                        // adminView.textAdminEmpleadosContrasena.setEditable(false);
                        /// adminView.textAdminEmpleadosPreguntaSecreta.setEditable(false);
                        // adminView.textAdminEmpleadosRespuestaSecreta.setEditable(false);
                         
                    adminView.textAdminEmpleadosBuscarCedula2.setEditable(false);
                    adminView.textAdminEmpleadosFechaNacimiento.setEnabled(false);
                    adminView.btnAdminEmpleadosActualizar.setEnabled(false);
                    adminView.btnAdminEmpleadosEliminar.setEnabled(false);
                    adminView.btnAdminEmpleadosRegistrar.setEnabled(false);
                    adminView.btnAdminEmpleadosListarEmpleados1.setEnabled(false);
                    
                    adminView.btnAdminEmpleadosActuaizarOK.setEnabled(true);
            
             }else{
                 JOptionPane.showMessageDialog(null, "Por favor seleccionar una Fila");
             }
         }
         if(e.getSource() == adminView.btnAdminEmpleadosActuaizarOK){
           String cedula =(String) adminView.textAdminEmpleadosCedula.getText().toUpperCase();
             String primerNombre = (String)adminView.textAdminEmpleadosPrimerNOmbre.getText().toUpperCase();
             String segundoNombre=(String) adminView.textAdminEmpleadosSegundoNombre.getText().toUpperCase();
             String primerApellido = (String)adminView.textAdminEmpleadosPrimerApellido.getText().toUpperCase();
             String segundoApellido= (String)adminView.textAdminEmpleadosSegundoApellido.getText().toUpperCase();
             String salario= (String)adminView.textAdminEmpleadosSalario.getText().toUpperCase();
            String telefono =(String)adminView.textAdminEmpleadosTelefono.getText().toUpperCase();
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             String fechaNac = dateFormat.format(adminView.textAdminEmpleadosFechaNacimiento.getDate());
             String usuario = (String)adminView.textAdminEmpleadosUsuario.getText().toUpperCase();
             String pass = (String)adminView.textAdminEmpleadosContrasena.getText().toUpperCase();
             String pregunta = (String)adminView.textAdminEmpleadosPreguntaSecreta.getText().toUpperCase();
             String respuesta = (String)adminView.textAdminEmpleadosRespuestaSecreta.getText().toUpperCase();
             if(ExpresionesRegulares.validarTelefono(telefono)){
             int x=-1,y=-1,z=-1;
             
             
             int filaActualizarTienda = adminView.TableAdminEmpleadosBuscarTiendas.getSelectedRow();
             int numFilasTienda=  adminView.TableAdminEmpleadosBuscarTiendas.getSelectedRowCount();
              if(filaActualizarTienda >= 0 && numFilasTienda  ==1){
                 x=Integer.parseInt((String) adminView.TableAdminEmpleadosBuscarTiendas.getValueAt(filaActualizarTienda, 0));
              }
              
               int filaActualizarRol = adminView.jTableAdminEmpleadosBuscarRol.getSelectedRow();
                  int numFilasRol =  adminView.jTableAdminEmpleadosBuscarRol.getSelectedRowCount();          
                    if(filaActualizarRol>= 0 && numFilasRol ==1){
                       y=Integer.parseInt((String) adminView.jTableAdminEmpleadosBuscarRol.getValueAt(filaActualizarRol , 0));
                    }
                
                    int filaActualizarPermiso = adminView.jTableAdminEmpleadosBuscarPermisos.getSelectedRow();
                    int numFilasRolPermiso  =  adminView.jTableAdminEmpleadosBuscarPermisos.getSelectedRowCount();
                        if(filaActualizarPermiso >= 0 && numFilasRolPermiso ==1){
                            
                             z=Integer.parseInt((String) adminView.jTableAdminEmpleadosBuscarPermisos.getValueAt(filaActualizarPermiso , 0));
                              
                            
                             }
                  int respuestActualizacion= modelPermisoDAO.actualizarEmpleado(
                          cedula
                          , primerNombre
                          , primerApellido
                          , segundoNombre
                          , segundoApellido
                          , salario
                          ,telefono
                         // , diasVaciones
                          , fechaNac
                          , usuario
                          , pass
                          , pregunta
                          , respuesta
                          , x
                          , y
                          , z);    
                     if(respuestActualizacion>0){
                         
                         JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
                         adminView.textAdminEmpleadosCedula.setText("");
                           adminView.textAdminEmpleadosPrimerNOmbre.setText("");
                           adminView.textAdminEmpleadosSegundoNombre.setText("");
                           adminView.textAdminEmpleadosPrimerApellido.setText("");
                           adminView.textAdminEmpleadosSegundoApellido.setText("");
                           adminView.textAdminEmpleadosSalario.setText(""); 
                          // adminView.textAdminEmpleadosDiasVacaciones.setText("");
                           adminView.textAdminEmpleadosFechaNacimiento.setDate(null);
                           adminView.textAdminEmpleadosUsuario.setText("");
                           adminView.textAdminEmpleadosContrasena.setText("");
                           adminView.textAdminEmpleadosPreguntaSecreta.setText("");
                           adminView.textAdminEmpleadosRespuestaSecreta.setText("");
                         adminView.textAdminEmpleadosTelefono.setText("");
                         adminView.textAdminEmpleadosCedula.setEditable(true);
                         adminView.textAdminEmpleadosPrimerNOmbre.setEditable(true);
                         adminView.textAdminEmpleadosSegundoNombre.setEditable(true);
                         adminView.textAdminEmpleadosPrimerApellido.setEditable(true);
                         adminView.textAdminEmpleadosSegundoApellido.setEditable(true);
                         adminView.textAdminEmpleadosUsuario.setEditable(true);
                         adminView.textAdminEmpleadosContrasena.setEditable(true);
                         adminView.textAdminEmpleadosPreguntaSecreta.setEditable(true);
                         adminView.textAdminEmpleadosRespuestaSecreta.setEditable(true);
                         
                    adminView.textAdminEmpleadosBuscarCedula2.setEditable(true);
                    adminView.textAdminEmpleadosFechaNacimiento.setEnabled(true);
                    adminView.btnAdminEmpleadosActualizar.setEnabled(true);
                    adminView.btnAdminEmpleadosEliminar.setEnabled(true);
                    adminView.btnAdminEmpleadosRegistrar.setEnabled(true);
                    adminView.btnAdminEmpleadosListarEmpleados1.setEnabled(true);
                    
                    adminView.btnAdminEmpleadosActuaizarOK.setEnabled(false);
                     }else JOptionPane.showMessageDialog(null, "Ocurrio un Error");
             } else JOptionPane.showMessageDialog(null, "Telefono Incorrecto");
         }
         if(e.getSource() == adminView.btnAdminEmpleadosEliminar){
             int filaInicioBeneficio= adminView.TableAdminEmpleadosBuscar1.getSelectedRow();
             int numFilas =  adminView.TableAdminEmpleadosBuscar1.getSelectedRowCount();
             ArrayList<String> listaNombre = new ArrayList();
             String nombreBeneficio="";
             if( filaInicioBeneficio  >=0   ){
                 for (int i = 0; i < numFilas ; i++) {
                      nombreBeneficio= String.valueOf(adminView.TableAdminEmpleadosBuscar1.getValueAt(i+filaInicioBeneficio, 0));
                      listaNombre .add(nombreBeneficio);
                 }
                 for (int i = 0; i < listaNombre .size() ; i++) {
                     int confirmacionUsuario = JOptionPane.showConfirmDialog(null, "Desea eliminar: "+listaNombre.get(i)+" ?");
                     if(confirmacionUsuario==0){
                         modelPermisoDAO.eliminarDatosEmpleado(listaNombre.get(i));
                     }
                 }
                 
             }else JOptionPane.showMessageDialog(null, "Por favor seleccionar almenos una Fila");
         }
     
         
         if(e.getSource() == adminView.btnAdminEmpleadosListarPermiso){
              setTablePermiso(adminView.jTableAdminEmpleadosBuscarPermisos);
           
         }
         if(e.getSource() == adminView.btnAdminEmpleadosListarROL){
              setTableRol(adminView.jTableAdminEmpleadosBuscarRol);
           
         }
                                     
       
         //Vacciones Empleados
         
         if(e.getSource() == adminView.btnAdminVacacionesRegistrar2){
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             String fechaInicio = dateFormat.format(adminView.textAdminVacacionesFechaInicial.getDate());
             String fechaFin = dateFormat.format(adminView.textAdminVacacionesFechaFinal.getDate());
             
             int filaActualizar = adminView.tableAdminEmpleadosHorariosBuscarEmpleados3.getSelectedRow();
             int numFilas =  adminView.tableAdminEmpleadosHorariosBuscarEmpleados3.getSelectedRowCount();
             
             if(filaActualizar>= 0 && numFilas ==1){
                   if((fechaInicio.compareTo(fechaFin)) < 0){
                       String cedula =(String) adminView.tableAdminEmpleadosHorariosBuscarEmpleados3.getValueAt(filaActualizar, 0);
                    int rstaRegistro = modelPermisoDAO.insertVacaionesEmpleados(fechaInicio,fechaFin,cedula);
                    if(rstaRegistro>0){
                            JOptionPane.showMessageDialog(null, "Registro Exitoso");
                           
                    }else{JOptionPane.showMessageDialog(null, "No se pudo registrar");}
                   }else{  JOptionPane.showMessageDialog(null, "Fecha Inicio: "+fechaInicio+" es mayor a Fecha Fin : "+fechaFin,"¡ERROR!",JOptionPane.ERROR_MESSAGE);}
        
             }else{
                 JOptionPane.showMessageDialog(null, "Por favor seleccionar un Empleado");
             }
            
         }
         
      /*   if(e.getSource() == adminView.btnAdminVacacionesListar2){ 
                 setVacacionesEmpleados(adminView.tableAdminVacacionesuscarTienda/*,cedula*;             
         }*/
         if(e.getSource() == adminView.btnAdminVacacionesActualizar2){
             int filaActualizar = adminView.tableAdminVacacionesuscarTienda.getSelectedRow();
             int numFilas =  adminView.tableAdminVacacionesuscarTienda.getSelectedRowCount();
             if(filaActualizar>= 0 && numFilas ==1){
                  cedula =(String) adminView.tableAdminVacacionesuscarTienda.getValueAt(filaActualizar, 0);
                    
                 String dateTime = (String) adminView.tableAdminVacacionesuscarTienda.getValueAt(filaActualizar, 3);
                 String dateTime2 = (String) adminView.tableAdminVacacionesuscarTienda.getValueAt(filaActualizar, 4); 
                
                 try {
                     Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateTime);
                     adminView.textAdminVacacionesFechaInicial.setDate(date);
                     Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateTime2);
                     adminView.textAdminVacacionesFechaFinal.setDate(date2);
                 } catch (ParseException ex) {
                     Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                 }
                     
                     
                         adminView.textAdminVacacionesEmpleadosBuscarTiendaNombre.setEditable(false);

                         
                    adminView.btnAdminVacacionesActualizar2.setEnabled(false);
                    
                    adminView.btnAdminVacacionesEliminar2.setEnabled(false);
                    adminView.btnAdminVacacionesRegistrar2.setEnabled(false);
                    //adminView.btnAdminVacacionesListar2.setEnabled(false);
                    
                    
                    adminView.btnAdminVacacionesActualizarOK2.setEnabled(true);
            
             }else{
                 JOptionPane.showMessageDialog(null, "Por favor seleccionar una Fila");
             }
             
         }
         
         if(e.getSource() == adminView.btnAdminVacacionesActualizarOK2){
             
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             String fechaInicio = dateFormat.format(adminView.textAdminVacacionesFechaInicial.getDate());
             String fechaFin = dateFormat.format(adminView.textAdminVacacionesFechaFinal.getDate());
             
            
                   if((fechaInicio.compareTo(fechaFin)) < 0){
                       
                    int rstaRegistro = modelPermisoDAO.actualizarVacaionesEmpleados(fechaInicio,fechaFin,cedula);
                    if(rstaRegistro>0){
                            JOptionPane.showMessageDialog(null, "Registro Exitoso");
                           adminView.textAdminVacacionesEmpleadosBuscarTiendaNombre.setEditable(true);

                         
                    adminView.btnAdminVacacionesActualizar2.setEnabled(true);
                    
                    adminView.btnAdminVacacionesEliminar2.setEnabled(true);
                    adminView.btnAdminVacacionesRegistrar2.setEnabled(true);
                   // adminView.btnAdminVacacionesListar2.setEnabled(true);
                    
                    
                    adminView.btnAdminVacacionesActualizarOK2.setEnabled(false);
                    }else{JOptionPane.showMessageDialog(null, "No se pudo registrar");}
                   }else{  JOptionPane.showMessageDialog(null, "Fecha Inicio: "+fechaInicio+" es mayor a Fecha Fin : "+fechaFin,"¡ERROR!",JOptionPane.ERROR_MESSAGE);}
        
         
            
         
         }
         if(e.getSource() == adminView.btnAdminVacacionesEliminar2){
             int filaInicioBeneficio= adminView.tableAdminVacacionesuscarTienda.getSelectedRow();
             int numFilas =  adminView.tableAdminVacacionesuscarTienda.getSelectedRowCount();
             ArrayList<String> listaNombre = new ArrayList();
             String nombreBeneficio="";
             if( filaInicioBeneficio  >=0   ){
                 for (int i = 0; i < numFilas ; i++) {
                      nombreBeneficio= String.valueOf(adminView.tableAdminVacacionesuscarTienda.getValueAt(i+filaInicioBeneficio, 0));
                      listaNombre .add(nombreBeneficio);
                 }
                 for (int i = 0; i < listaNombre .size() ; i++) {
                     int confirmacionUsuario = JOptionPane.showConfirmDialog(null, "Desea eliminar: "+listaNombre.get(i)+" ?");
                     if(confirmacionUsuario==0){
                         modelPermisoDAO.deleteVacaionesEmpleados(listaNombre.get(i));
                     }
                 }
                 
             }else JOptionPane.showMessageDialog(null, "Por favor seleccionar almenos una Fila");
         }
         
         //Clientes Juridicos y Natural
         if(e.getSource() == adminView.btnAdminClientesJuridicosRegistrar){
           String capital =  adminView.textRegistroCLienteJuridicoCapitalDisponible.getText().toUpperCase();
              String  denominacion=        adminView.textRegistroCLienteJuridicoDenominacionComercial.getText().toUpperCase();;
             String    email=       adminView. textRegistroCLienteJuridicoEmail.getText();
             String     pass=      adminView.textRegistroCLienteJuridicoPass.getText().toUpperCase();;
             String     pregunta=       adminView. textRegistroCLienteJuridicoPreguntaSecreta.getText().toUpperCase();;
             String      razon=      adminView.textRegistroCLienteJuridicoRazonSocial.getText().toUpperCase();;
              String       respuesta=    adminView.textRegistroCLienteJuridicoRespuestaSecreta.getText().toUpperCase();;
              String       rif=    adminView.textRegistroCLienteJuridicoRif.getText().toUpperCase();;
              String       user=    adminView.textRegistroCLienteJuridicoUsuario.getText().toUpperCase();;
              String        telefono=   adminView.textRegistroCLienteJuridicoTelefono.getText();
                       
              String      web=     adminView.textRegistroCLienteJuridicoWeb.getText();
              
              int parroquiaFisica=0;
                            for(int i=0;i<parroquiasJuridicoFisica.size();i++)
                            {
                                if(parroquiasJuridicoFisica.get(i).equals( adminView.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFisica.getSelectedItem()))
                                {
                                    parroquiaFisica=Integer.parseInt(parroquiasJuridicoFisica.get(i-1));
                                    break;
                                }
                            }
               int parroquiaFiscal=0;
                            for(int i=0;i<parroquiasJuridicoFiscal.size();i++)
                            {
                                if(parroquiasJuridicoFiscal.get(i).equals( adminView.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFiscal.getSelectedItem()))
                                {
                                    parroquiaFiscal=Integer.parseInt(parroquiasJuridicoFiscal.get(i-1));
                                    break;
                                }
                            }
              if(ExpresionesRegulares.validarCorreo(email)){
                  if(ExpresionesRegulares.validarTelefono(telefono)){
                      if(ExpresionesRegulares.validarWeb(web)){
                              int filaActualizar = adminView.tableAdminJuridicosTiendas1.getSelectedRow();
                            int numFilas =  adminView.tableAdminJuridicosTiendas1.getSelectedRowCount();
                            if(filaActualizar>= 0 && numFilas ==1){
                                    
                                   int rta= modelPermisoDAO.insertJuridico(rif, denominacion,razon,web,capital, (String) adminView.tableAdminJuridicosTiendas1.getValueAt(filaActualizar, 0),
                                   String.valueOf(parroquiaFisica),String.valueOf(parroquiaFiscal)
                                   /*Usuario*/
                                   ,user,pass, pregunta,respuesta,
                                           /*Mail*/
                                           email,
                                           /*Telefono*/
                                          "Oficina Central",telefono );
                                   if(rta >0){ JOptionPane.showMessageDialog(null, "Registro Exitoso");
                                   }else JOptionPane.showMessageDialog(null, "Ocurrio un Error");
                            }else{
                                JOptionPane.showMessageDialog(null, "Por favor seleccionar una Tienda");
                            }
             
                          
                          
                      }else JOptionPane.showMessageDialog(null, "Pagina WEB incorrecta");
                 }else JOptionPane.showMessageDialog(null, "Telefono Incorrecto");
              }else JOptionPane.showMessageDialog(null, "Correo Invalido");
         }
         if(e.getSource() == adminView.btnAdminClientesNaturalRegistro){
          String apellido=   adminView.textRegistroCLienteNaturalApellido.getText().toUpperCase();;
          String cedula = adminView.textRegistroCLienteNaturalCedula.getText().toUpperCase();
          String mail=    adminView.textRegistroCLienteNaturalEmail.getText();
          String nombre=   adminView.textRegistroCLienteNaturalNombre.getText().toUpperCase();
          String pass =    adminView.textRegistroCLienteNaturalPass.getText().toUpperCase();
          String pregunta = adminView.textRegistroCLienteNaturalPreguntaSecreta.getText().toUpperCase();
          String respuesta = adminView.textRegistroCLienteNaturalRespuestaSecreta.getText().toUpperCase();
          String rif=   adminView.textRegistroCLienteNaturalRif.getText().toUpperCase();
          String apellido2= adminView.textRegistroCLienteNaturalSegundoApellido.getText().toUpperCase();
          String nombre2=    adminView.textRegistroCLienteNaturalSegundoNombre.getText().toUpperCase();
          String telefono=   adminView.textRegistroCLienteNaturalTelefono.getText().toUpperCase();
          String user=       adminView.textRegistroCLienteNaturalUser.getText().toUpperCase();
          
          int parroquia=0;
                            for(int i=0;i<parroquias.size();i++)
                            {
                                if(parroquias.get(i).equals( adminView.jComboBoxRegistroCLienteNaturalParroquia.getSelectedItem()))
                                {
                                    parroquia=Integer.parseInt(parroquias.get(i-1));
                                    break;
                                }
                            }
          
          if(ExpresionesRegulares.validarCorreo(mail)){
                 if(ExpresionesRegulares.validarTelefono(telefono)){
                      
                              int filaActualizar = adminView.tableAdminNaturalesTiendas.getSelectedRow();
                            int numFilas =  adminView.tableAdminNaturalesTiendas.getSelectedRowCount();
                            if(filaActualizar>= 0 && numFilas ==1){
                                    
                                   int rta= modelPermisoDAO.insertNatural(cedula ,rif,nombre
                                    ,nombre2,apellido,apellido2, (String) adminView.tableAdminNaturalesTiendas.getValueAt(filaActualizar, 0),
                                   String.valueOf(parroquia)
                                   /*Usuario*/
                                   ,user,pass, pregunta,respuesta,
                                           /*Mail*/
                                           mail,
                                   /*Telefono*/
                                           "Telefono personal",telefono );
                                   if(rta >0){ JOptionPane.showMessageDialog(null, "Registro Exitoso"); System.out.println("asdsadsadasd");
                                   }else JOptionPane.showMessageDialog(null, "Ocurrio un Error");
                            }else{
                                JOptionPane.showMessageDialog(null, "Por favor seleccionar una Tienda");
                            }
             
                          
                          
                      
                 }else JOptionPane.showMessageDialog(null, "Telefono Incorrecto");
              }else JOptionPane.showMessageDialog(null, "Correo Invalido");
         }
         if(e.getSource() == adminView.btnAdminClientesJuridicosEliminar1){
             int filaInicioBeneficio= adminView.tableAdminJuridicosBuscarClientsJuridicos.getSelectedRow();
             int numFilas =  adminView.tableAdminJuridicosBuscarClientsJuridicos.getSelectedRowCount();
             ArrayList<String> listaNombre = new ArrayList();
             String nombreBeneficio="";
             if( filaInicioBeneficio  >=0   ){
                 for (int i = 0; i < numFilas ; i++) {
                      nombreBeneficio= String.valueOf(adminView.tableAdminJuridicosBuscarClientsJuridicos.getValueAt(i+filaInicioBeneficio, 1));
                      listaNombre .add(nombreBeneficio);
                 }
                 for (int i = 0; i < listaNombre .size() ; i++) {
                     int confirmacionUsuario = JOptionPane.showConfirmDialog(null, "Desea eliminar: "+listaNombre.get(i)+" ?");
                     if(confirmacionUsuario==0){
                         modelPermisoDAO.deleteJuridicos(listaNombre.get(i));
                     }
                 }
                 
             }else JOptionPane.showMessageDialog(null, "Por favor seleccionar almenos una Fila");
         }
         if(e.getSource() == adminView.btnAdminClientesNaturalEliminar2){
             int filaInicioBeneficio= adminView.tableAdminNaturalesBuscarCleintesNaturales.getSelectedRow();
             int numFilas =  adminView.tableAdminNaturalesBuscarCleintesNaturales.getSelectedRowCount();
             ArrayList<String> listaNombre = new ArrayList();
             String nombreBeneficio="";
             if( filaInicioBeneficio  >=0   ){
                 for (int i = 0; i < numFilas ; i++) {
                      nombreBeneficio= String.valueOf(adminView.tableAdminNaturalesBuscarCleintesNaturales.getValueAt(i+filaInicioBeneficio, 1));
                      listaNombre .add(nombreBeneficio);
                 }
                 for (int i = 0; i < listaNombre .size() ; i++) {
                     int confirmacionUsuario = JOptionPane.showConfirmDialog(null, "Desea eliminar: "+listaNombre.get(i)+" ?");
                     if(confirmacionUsuario==0){
                         modelPermisoDAO.deleteNaturales(listaNombre.get(i));
                     }
                 }
                 
             }else JOptionPane.showMessageDialog(null, "Por favor seleccionar almenos una Fila");
         }
         if(e.getSource() == adminView.btnAdminClientesJuridicosActualizar1){
             int filaActualizar = adminView.tableAdminJuridicosBuscarClientsJuridicos.getSelectedRow();
             int numFilas =  adminView.tableAdminJuridicosBuscarClientsJuridicos.getSelectedRowCount();
             if(filaActualizar>= 0 && numFilas ==1){
                   codigo_permiso = Integer.parseInt((String) adminView.tableAdminJuridicosBuscarClientsJuridicos.getValueAt(filaActualizar, 0));
                    
                   modelPermisoDAO.setUpdateJuridico(codigo_permiso,
                           adminView.textRegistroCLienteJuridicoDenominacionComercial, 
                           adminView.textRegistroCLienteJuridicoRazonSocial, 
                           adminView.textRegistroCLienteJuridicoRif, 
                           adminView.textRegistroCLienteJuridicoTelefono, 
                           adminView.textRegistroCLienteJuridicoWeb, 
                           adminView.textRegistroCLienteJuridicoEmail,
                           adminView.textRegistroCLienteJuridicoCapitalDisponible,
                          // adminView.textAdminEmpleadosDiasVacaciones, 
                           adminView.textRegistroCLienteJuridicoUsuario, 
                           adminView.textRegistroCLienteJuridicoPass, 
                           adminView.textRegistroCLienteJuridicoPreguntaSecreta, 
                           adminView.textRegistroCLienteJuridicoRespuestaSecreta,
                           adminView.jComboBoxRegistroCLienteJuridicoEstadoDireccionFisica,
                           adminView.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFisica,
                           adminView.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFisica,
                           adminView.jComboBoxRegistroCLienteJuridicoEstadoDireccionFiscal,
                           adminView.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFiscal,
                           adminView.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFiscal
                           );
                   
                   /*adminView.textAdminEmpleadosCedula.setText(cedula);
                     adminView.textAdminEmpleadosPrimerNOmbre.setText((String) adminView.TableAdminEmpleadosBuscar1.getValueAt(filaActualizar, 1));
                      
                       adminView.textAdminEmpleadosPrimerApellido.setText((String)adminView.TableAdminEmpleadosBuscar1.getValueAt(filaActualizar, 2));
            
             adminView.textAdminEmpleadosSalario.setText((String) adminView.TableAdminEmpleadosBuscar1.getValueAt(filaActualizar, 3));
             */
                    
                         adminView.textAdminClientesJuridicosBuscarClintes.setEditable(false);
                         adminView.textRegistroCLienteJuridicoDenominacionComercial.setEditable(false);
                         adminView.textRegistroCLienteJuridicoRazonSocial.setEditable(false);
                         adminView.textRegistroCLienteJuridicoRif.setEditable(false);
                         adminView.textRegistroCLienteJuridicoUsuario.setEditable(false);
                         
                        // adminView.textAdminEmpleadosContrasena.setEditable(false);
                        /// adminView.textAdminEmpleadosPreguntaSecreta.setEditable(false);
                        // adminView.textAdminEmpleadosRespuestaSecreta.setEditable(false);
                         
                    
                    adminView.btnAdminClientesJuridicosRegistrar.setEnabled(false);
                    adminView.btnAdminClientesJuridicosActualizar1.setEnabled(false);
                    adminView.btnAdminClientesJuridicosEliminar1.setEnabled(false);
                  
                    
                    adminView.btnAdminClientesJuridicosActuaizarOK1.setEnabled(true);
            
             }else{
                 JOptionPane.showMessageDialog(null, "Por favor seleccionar una Fila");
             }
         }
         if(e.getSource() == adminView.btnAdminClientesJuridicosActuaizarOK1){
           String capital =  adminView.textRegistroCLienteJuridicoCapitalDisponible.getText().toUpperCase();
              String  denominacion=        adminView.textRegistroCLienteJuridicoDenominacionComercial.getText().toUpperCase();;
             String    email=       adminView. textRegistroCLienteJuridicoEmail.getText();
             String     pass=      adminView.textRegistroCLienteJuridicoPass.getText().toUpperCase();;
             String     pregunta=       adminView. textRegistroCLienteJuridicoPreguntaSecreta.getText().toUpperCase();;
             String      razon=      adminView.textRegistroCLienteJuridicoRazonSocial.getText().toUpperCase();;
              String       respuesta=    adminView.textRegistroCLienteJuridicoRespuestaSecreta.getText().toUpperCase();;
              String       rif=    adminView.textRegistroCLienteJuridicoRif.getText().toUpperCase();;
              String       user=    adminView.textRegistroCLienteJuridicoUsuario.getText().toUpperCase();;
              String        telefono=   adminView.textRegistroCLienteJuridicoTelefono.getText();
                       
              String      web=     adminView.textRegistroCLienteJuridicoWeb.getText();
              
              int parroquiaFisica=0;
                            for(int i=0;i<parroquiasJuridicoFisica.size();i++)
                            {
                                if(parroquiasJuridicoFisica.get(i).equals( adminView.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFisica.getSelectedItem()))
                                {
                                    parroquiaFisica=Integer.parseInt(parroquiasJuridicoFisica.get(i-1));
                                    break;
                                }
                            }
               int parroquiaFiscal=0;
                            for(int i=0;i<parroquiasJuridicoFiscal.size();i++)
                            {
                                if(parroquiasJuridicoFiscal.get(i).equals( adminView.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFiscal.getSelectedItem()))
                                {
                                    parroquiaFiscal=Integer.parseInt(parroquiasJuridicoFiscal.get(i-1));
                                    break;
                                }
                            }
              
              if(ExpresionesRegulares.validarCorreo(email)){
                  if(ExpresionesRegulares.validarTelefono(telefono)){
                      if(ExpresionesRegulares.validarWeb(web)){
                              
                                    
                                   int rta= modelPermisoDAO.actualizarJuridico(rif, denominacion,razon,web,capital,
                                   String.valueOf(parroquiaFisica),String.valueOf(parroquiaFiscal)
                                   /*Usuario*/
                                   ,pass, pregunta,respuesta,
                                           /*Mail*/
                                           email,
                                           /*Telefono*/
                                          telefono );
                                   if(rta >0){ JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
                                            adminView.textAdminClientesJuridicosBuscarClintes.setEditable(true);
                                             adminView.textRegistroCLienteJuridicoDenominacionComercial.setEditable(true);
                                             adminView.textRegistroCLienteJuridicoRazonSocial.setEditable(true);
                                             adminView.textRegistroCLienteJuridicoRif.setEditable(true);
                                             adminView.textRegistroCLienteJuridicoUsuario.setEditable(true);

                                            // adminView.textAdminEmpleadosContrasena.setEditable(false);
                                            /// adminView.textAdminEmpleadosPreguntaSecreta.setEditable(false);
                                            // adminView.textAdminEmpleadosRespuestaSecreta.setEditable(false);


                                        adminView.btnAdminClientesJuridicosRegistrar.setEnabled(true);
                                        adminView.btnAdminClientesJuridicosActualizar1.setEnabled(true);
                                        adminView.btnAdminClientesJuridicosEliminar1.setEnabled(true);


                                        adminView.btnAdminClientesJuridicosActuaizarOK1.setEnabled(false);
                                   }else JOptionPane.showMessageDialog(null, "Ocurrio un Error");
                            
             
                          
                          
                      }else JOptionPane.showMessageDialog(null, "Pagina WEB incorrecta");
                 }else JOptionPane.showMessageDialog(null, "Telefono Incorrecto");
              }else JOptionPane.showMessageDialog(null, "Correo Invalido");
         }
         
         if(e.getSource() == adminView.btnAdminClientesNaturalActualizar2){
              int filaActualizar = adminView.tableAdminNaturalesBuscarCleintesNaturales.getSelectedRow();
             int numFilas =  adminView.tableAdminNaturalesBuscarCleintesNaturales.getSelectedRowCount();
             if(filaActualizar>= 0 && numFilas ==1){
                  codigo_permiso = Integer.parseInt((String) adminView.tableAdminNaturalesBuscarCleintesNaturales.getValueAt(filaActualizar, 0));
                    
                   modelPermisoDAO.setUpdateNatural(codigo_permiso,
                           adminView.textRegistroCLienteNaturalNombre, 
                           adminView.textRegistroCLienteNaturalSegundoNombre, 
                           adminView.textRegistroCLienteNaturalApellido, 
                           adminView.textRegistroCLienteNaturalSegundoApellido, 
                           adminView.textRegistroCLienteNaturalTelefono, 
                           adminView.textRegistroCLienteNaturalCedula,
                           adminView.textRegistroCLienteNaturalRif,
                          // adminView.textAdminEmpleadosDiasVacaciones, 
                           adminView.textRegistroCLienteNaturalEmail, 
                           adminView.textRegistroCLienteNaturalUser, 
                           adminView.textRegistroCLienteNaturalPass, 
                           adminView.textRegistroCLienteNaturalPreguntaSecreta,
                           adminView.textRegistroCLienteNaturalRespuestaSecreta,
                           adminView.jComboBoxRegistroCLienteNaturalEstado,
                           adminView.jComboBoxRegistroCLienteNaturalMunicipio,
                           adminView.jComboBoxRegistroCLienteNaturalParroquia
                           );
                   
                    
                         adminView.textAdminClientesNaturalesBuscarClientes.setEditable(false);
                         adminView.textRegistroCLienteNaturalNombre.setEditable(false);
                         adminView.textRegistroCLienteNaturalSegundoNombre.setEditable(false);
                         adminView.textRegistroCLienteNaturalApellido.setEditable(false);
                         adminView.textRegistroCLienteNaturalSegundoApellido.setEditable(false);
                         
                         adminView.textRegistroCLienteNaturalCedula.setEditable(false);
                        adminView.textRegistroCLienteNaturalRif.setEditable(false);
                         adminView.textRegistroCLienteNaturalUser.setEditable(false);
                         
                    
                    adminView.btnAdminClientesNaturalRegistro.setEnabled(false);
                    adminView.btnAdminClientesNaturalActualizar2.setEnabled(false);
                    adminView.btnAdminClientesNaturalEliminar2.setEnabled(false);
                  
                    
                    adminView.btnAdminClientesNaturalActuaizarOK2.setEnabled(true);
            
             }else{
                 JOptionPane.showMessageDialog(null, "Por favor seleccionar una Fila");
             }
         }
         if(e.getSource() == adminView.btnAdminClientesNaturalActuaizarOK2){
          String apellido=   adminView.textRegistroCLienteNaturalApellido.getText().toUpperCase();;
          String cedula = adminView.textRegistroCLienteNaturalCedula.getText().toUpperCase();
          String mail=    adminView.textRegistroCLienteNaturalEmail.getText();
          String nombre=   adminView.textRegistroCLienteNaturalNombre.getText().toUpperCase();
          String pass =    adminView.textRegistroCLienteNaturalPass.getText().toUpperCase();
          String pregunta = adminView.textRegistroCLienteNaturalPreguntaSecreta.getText().toUpperCase();
          String respuesta = adminView.textRegistroCLienteNaturalRespuestaSecreta.getText().toUpperCase();
          String rif=   adminView.textRegistroCLienteNaturalRif.getText().toUpperCase();
          String apellido2= adminView.textRegistroCLienteNaturalSegundoApellido.getText().toUpperCase();
          String nombre2=    adminView.textRegistroCLienteNaturalSegundoNombre.getText().toUpperCase();
          String telefono=   adminView.textRegistroCLienteNaturalTelefono.getText();
          String user=       adminView.textRegistroCLienteNaturalUser.getText().toUpperCase();
          
           int parroquia=0;
                            for(int i=0;i<parroquias.size();i++)
                            {
                                if(parroquias.get(i).equals( adminView.jComboBoxRegistroCLienteNaturalParroquia.getSelectedItem()))
                                {
                                    parroquia=Integer.parseInt(parroquias.get(i-1));
                                    break;
                                }
                            }
          if(ExpresionesRegulares.validarCorreo(mail)){
                 if(ExpresionesRegulares.validarTelefono(telefono)){
                     
                              
                                    
                                   int rta= modelPermisoDAO.actualizarNatural(cedula , String.valueOf(parroquia)
                                   /*Usuario*/
                                   ,pass, pregunta,respuesta,
                                           /*Mail*/
                                           mail,
                                   /*Telefono*/
                                           telefono );
                                   if(rta >0){ JOptionPane.showMessageDialog(null, "Actualizacion Exitosa  Exitoso");
                                                 adminView.textAdminClientesNaturalesBuscarClientes.setEditable(true);
                                                 adminView.textRegistroCLienteNaturalNombre.setEditable(true);
                                                 adminView.textRegistroCLienteNaturalSegundoNombre.setEditable(true);
                                                 adminView.textRegistroCLienteNaturalApellido.setEditable(true);
                                                 adminView.textRegistroCLienteNaturalSegundoApellido.setEditable(true);

                                                 adminView.textRegistroCLienteNaturalCedula.setEditable(true);
                                                adminView.textRegistroCLienteNaturalRif.setEditable(true);
                                                 adminView.textRegistroCLienteNaturalUser.setEditable(true);


                                            adminView.btnAdminClientesNaturalRegistro.setEnabled(true);
                                            adminView.btnAdminClientesNaturalActualizar2.setEnabled(true);
                                            adminView.btnAdminClientesNaturalEliminar2.setEnabled(true);


                                            adminView.btnAdminClientesNaturalActuaizarOK2.setEnabled(false);
                                   }else JOptionPane.showMessageDialog(null, "Ocurrio un Error");
                           
             
                          
                          
                      
                 }else JOptionPane.showMessageDialog(null, "Telefono Incorrecto");
              }else JOptionPane.showMessageDialog(null, "Correo Invalido");
         }
         
         ///*LLenar Lugares Cliente Juridico y  NAtrual*/
        if(e.getSource() == adminView.jComboBoxRegistroCLienteNaturalEstado){
            
             adminView.jComboBoxRegistroCLienteNaturalMunicipio.removeAllItems();
            adminView.jComboBoxRegistroCLienteNaturalParroquia.removeAllItems();
            int estado=0;
            for(int i=0;i<estados.size();i++)
            {
                if(estados.get(i).equals( adminView.jComboBoxRegistroCLienteNaturalEstado.getSelectedItem()))
                {
                    estado=Integer.parseInt(estados.get(i-1));
                    break;
                }
            }
            municipios = Lugar.ConsultarMunicipios(estado);

            int i=1;

            while(i<municipios.size())
            { 
               adminView.jComboBoxRegistroCLienteNaturalMunicipio.addItem(municipios.get(i));
                i=i+2;
            }
         }
        
        if(e.getSource() == adminView.jComboBoxRegistroCLienteNaturalMunicipio){
            adminView.jComboBoxRegistroCLienteNaturalParroquia.removeAllItems();
            int parroquia=0;
            for(int i=0;i<municipios.size();i++)
            {
                if(municipios.get(i).equals(adminView.jComboBoxRegistroCLienteNaturalMunicipio.getSelectedItem()))
                {
                    parroquia=Integer.parseInt(municipios.get(i-1));
                    break;
                }
            }
            parroquias = Lugar.ConsultarParroquias(parroquia);

            int i=1;

            while(i<parroquias.size())
            {
                adminView.jComboBoxRegistroCLienteNaturalParroquia.addItem(parroquias.get(i));
                i=i+2;
            }
        }
        //Direccon Fiscal
        if(e.getSource() == adminView.jComboBoxRegistroCLienteJuridicoEstadoDireccionFiscal){
            
             adminView.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFiscal.removeAllItems();
            adminView.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFiscal.removeAllItems();
            int estado=0;
            for(int i=0;i<estadosJuridicoFiscal.size();i++)
            {
                if(estadosJuridicoFiscal.get(i).equals( adminView.jComboBoxRegistroCLienteJuridicoEstadoDireccionFiscal.getSelectedItem()))
                {
                    estado=Integer.parseInt(estadosJuridicoFiscal.get(i-1));
                    break;
                }
            }
            municipiosJuridicoFiscal = Lugar.ConsultarMunicipios(estado);

            int i=1;

            while(i<municipiosJuridicoFiscal.size())
            { 
               adminView.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFiscal.addItem(municipiosJuridicoFiscal.get(i));
                i=i+2;
            }
         }
        
        if(e.getSource() == adminView.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFiscal){
            adminView.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFiscal.removeAllItems();
            int parroquia=0;
            for(int i=0;i<municipiosJuridicoFiscal.size();i++)
            {
                if(municipiosJuridicoFiscal.get(i).equals(adminView.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFiscal.getSelectedItem()))
                {
                    parroquia=Integer.parseInt(municipiosJuridicoFiscal.get(i-1));
                    break;
                }
            }
            parroquiasJuridicoFiscal = Lugar.ConsultarParroquias(parroquia);

            int i=1;

            while(i<parroquiasJuridicoFiscal.size())
            {
                adminView.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFiscal.addItem(parroquiasJuridicoFiscal.get(i));
                i=i+2;
            }
        }
        //Direccion Fisica
        if(e.getSource() == adminView.jComboBoxRegistroCLienteJuridicoEstadoDireccionFisica){
            
             adminView.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFisica.removeAllItems();
            adminView.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFisica.removeAllItems();
            int estado=0;
            for(int i=0;i<estadosJuridicoFisica.size();i++)
            {
                if(estadosJuridicoFisica.get(i).equals( adminView.jComboBoxRegistroCLienteJuridicoEstadoDireccionFisica.getSelectedItem()))
                {
                    estado=Integer.parseInt(estadosJuridicoFisica.get(i-1));
                    break;
                }
            }
            municipiosJuridicoFisica = Lugar.ConsultarMunicipios(estado);

            int i=1;

            while(i<municipiosJuridicoFisica.size())
            { 
               adminView.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFisica.addItem(municipiosJuridicoFisica.get(i));
                i=i+2;
            }
         }
        
        if(e.getSource() == adminView.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFisica){
            adminView.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFisica.removeAllItems();
            int parroquia=0;
            for(int i=0;i<municipiosJuridicoFisica.size();i++)
            {
                if(municipiosJuridicoFisica.get(i).equals(adminView.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFisica.getSelectedItem()))
                {
                    parroquia=Integer.parseInt(municipiosJuridicoFisica.get(i-1));
                    break;
                }
            }
            parroquiasJuridicoFisica = Lugar.ConsultarParroquias(parroquia);

            int i=1;

            while(i<parroquiasJuridicoFisica.size())
            {
                adminView.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFisica.addItem(parroquiasJuridicoFisica.get(i));
                i=i+2;
            }
        }
        
         
         
         //PERSONA CONTACO
         if(e.getSource() == adminView.btnAdminClientesJuridicoPersonaContactoAgisnar1){
             String cedula=   adminView.textRegistroCLienteJuridicoPersonaContactoCedula1.getText().toUpperCase();;
          String nombre= adminView.textRegistroCLienteJuridicoPersonaContactoNombre1.getText().toUpperCase();
          String apellido=    adminView.textRegistroCLienteJuridicoPersonaContactoApellido1.getText();
           String telefono=   adminView.textRegistroCLienteJuridicoPersonaContacoTelefono1.getText();
           if(ExpresionesRegulares.validarTelefono(telefono)){
                      
                              int filaActualizar = adminView.tableAdminPersonaContactoJuridicosBuscarClientsJuridicos.getSelectedRow();
                            int numFilas =  adminView.tableAdminPersonaContactoJuridicosBuscarClientsJuridicos.getSelectedRowCount();
                            if(filaActualizar>= 0 && numFilas ==1){
                                    
                                   int rta= modelPermisoDAO.insertPersonaContacto(cedula, nombre
                                           ,apellido,
                                           (String) adminView.tableAdminPersonaContactoJuridicosBuscarClientsJuridicos.getValueAt(filaActualizar, 0),
                                   
                                           /*Telefono*/
                                          "Oficina Central",telefono );
                                   if(rta >0){ JOptionPane.showMessageDialog(null, "Registro Exitoso");
                                   }else JOptionPane.showMessageDialog(null, "Ocurrio un Error");
                            }else{
                                JOptionPane.showMessageDialog(null, "Por favor seleccionar un Empleado");
                            }
             
                          
                          
                     
                 }else JOptionPane.showMessageDialog(null, "Telefono Incorrecto");
         }
         if(e.getSource() == adminView.btnAdminClientesJuridicoPErsonaContactoEliminar2){
           int filaInicioBeneficio= adminView.tableAdminPersonaContactoJuridicosBuscarClientsPersonaCOntacto.getSelectedRow();
             int numFilas =  adminView.tableAdminPersonaContactoJuridicosBuscarClientsPersonaCOntacto.getSelectedRowCount();
             ArrayList<String> listaNombre = new ArrayList();
             String nombreBeneficio="";
             if( filaInicioBeneficio  >=0   ){
                 for (int i = 0; i < numFilas ; i++) {
                      nombreBeneficio= String.valueOf(adminView.tableAdminPersonaContactoJuridicosBuscarClientsPersonaCOntacto.getValueAt(i+filaInicioBeneficio, 0));
                      listaNombre .add(nombreBeneficio);
                 }
                 for (int i = 0; i < listaNombre .size() ; i++) {
                     int confirmacionUsuario = JOptionPane.showConfirmDialog(null, "Desea eliminar: "+listaNombre.get(i)+" ?");
                     if(confirmacionUsuario==0){
                         modelPermisoDAO.deletePErsonaContaco(listaNombre.get(i));
                         JOptionPane.showMessageDialog(null, "Gestion Exitosa");
                     }
                 }
                 
             }else JOptionPane.showMessageDialog(null, "Por favor seleccionar almenos un Contacto");
         }
         if(e.getSource() == adminView.btnAdminClientesJuridicosPersonaContacoActualizar2){
              int filaActualizar = adminView.tableAdminPersonaContactoJuridicosBuscarClientsPersonaCOntacto.getSelectedRow();
             int numFilas =  adminView.tableAdminPersonaContactoJuridicosBuscarClientsPersonaCOntacto.getSelectedRowCount();
             if(filaActualizar>= 0 && numFilas ==1){
                  codigo_permiso = Integer.parseInt((String) adminView.tableAdminPersonaContactoJuridicosBuscarClientsPersonaCOntacto.getValueAt(filaActualizar, 0));
                    
                   modelPermisoDAO.setUpdatePersonaContacto(codigo_permiso,
                           adminView.textRegistroCLienteJuridicoPersonaContactoNombre1, 
                           adminView.textRegistroCLienteJuridicoPersonaContactoApellido1, 
                           adminView.textRegistroCLienteJuridicoPersonaContactoCedula1, 
                           adminView.textRegistroCLienteJuridicoPersonaContacoTelefono1);
                   
                    
                         adminView.textRegistroCLienteJuridicoPersonaContactoNombre1.setEditable(false);
                         adminView.textRegistroCLienteJuridicoPersonaContactoApellido1.setEditable(false);
                         adminView.textRegistroCLienteJuridicoPersonaContactoCedula1.setEditable(false);
                         adminView.textAdminClientesJuridiosPErsonaContactoBuscarPErsona2.setEditable(false);
                        adminView.textAdminClientesJuridiosPErsonaContactoBuscarEmpleado1.setEditable(false);
                         
                         
                         
                    
                    adminView.btnAdminClientesJuridicosPersonaContacoActualizar2.setEnabled(false);
                    adminView.btnAdminClientesJuridicoPErsonaContactoEliminar2.setEnabled(false);
                    adminView.btnAdminClientesJuridicoPersonaContactoAgisnar1.setEnabled(false);
                  
                    
                    adminView.btnAdminCLientesJuridicosPErsonaContactoActualizarOK2.setEnabled(true);
            
             }else{
                 JOptionPane.showMessageDialog(null, "Por favor seleccionar a un Contacto");
             }
         }
         if(e.getSource() == adminView.btnAdminCLientesJuridicosPErsonaContactoActualizarOK2){
             String telefono=   adminView.textRegistroCLienteJuridicoPersonaContacoTelefono1.getText();
           if(ExpresionesRegulares.validarTelefono(telefono)){
                      
                          
                                    
                                   int rta= modelPermisoDAO.actualizarNPersonaContaco(
                                          
                                   
                                           /*Telefono*/
                                          telefono,codigo_permiso);
                                   if(rta >0){ JOptionPane.showMessageDialog(null, "Actualizacion Exitoso");
                                     adminView.textRegistroCLienteJuridicoPersonaContactoNombre1.setEditable(true);
                                        adminView.textRegistroCLienteJuridicoPersonaContactoApellido1.setEditable(true);
                                        adminView.textRegistroCLienteJuridicoPersonaContactoCedula1.setEditable(true);
                                        adminView.textAdminClientesJuridiosPErsonaContactoBuscarPErsona2.setEditable(true);
                                       adminView.textAdminClientesJuridiosPErsonaContactoBuscarEmpleado1.setEditable(true);




                                   adminView.btnAdminClientesJuridicosPersonaContacoActualizar2.setEnabled(true);
                                   adminView.btnAdminClientesJuridicoPErsonaContactoEliminar2.setEnabled(true);
                                   adminView.btnAdminClientesJuridicoPersonaContactoAgisnar1.setEnabled(true);


                                   adminView.btnAdminCLientesJuridicosPErsonaContactoActualizarOK2.setEnabled(false);
                                   }else JOptionPane.showMessageDialog(null, "Ocurrio un Error");
                            }else JOptionPane.showMessageDialog(null, "Telefono Incorrecto");
    
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
       
       //EMPLEADOS - HORARIOS
       if(e.getSource() == adminView.textAdminEmpleadosHorariosBuscarDia){
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
        
       /* //Vacaiones
        if(e.getSource() == adminView.textAdminEmpleadosDiasVacaciones){
           char c = e.getKeyChar();
           if((c<'0'|| c>'9')){e.consume();} //NUMEROS
           
       }*/
       
       //Juridicos y Clientes
        if(e.getSource() == adminView.textRegistroCLienteJuridicoDenominacionComercial ||
              e.getSource() ==  adminView. textRegistroCLienteJuridicoPreguntaSecreta ||
                e.getSource() == adminView.textRegistroCLienteJuridicoRazonSocial ||
                e.getSource() == adminView. textRegistroCLienteJuridicoRespuestaSecreta ||
                e.getSource() == adminView.textRegistroCLienteJuridicoUsuario ||
               /*Persona COntacto Juridico*/
                e.getSource() == adminView.textRegistroCLienteJuridicoPersonaContactoApellido1 ||
                e.getSource() == adminView.textRegistroCLienteJuridicoPersonaContactoNombre1||
                /*Naturales*/
                e.getSource() == adminView.textRegistroCLienteNaturalApellido ||
                e.getSource() == adminView.textRegistroCLienteNaturalNombre ||
                e.getSource() == adminView.textRegistroCLienteNaturalPreguntaSecreta ||
                e.getSource() == adminView.textRegistroCLienteNaturalRespuestaSecreta ||
               e.getSource() == adminView.textRegistroCLienteNaturalSegundoApellido ||
                e.getSource() == adminView.textRegistroCLienteNaturalSegundoNombre ||
                e.getSource() == adminView.textRegistroCLienteNaturalUser 
                ){
             char c = e.getKeyChar();    
           if((c<'a'|| c>'z')&&((c<'A'|| c>'Z')&& (c != (char)KeyEvent.VK_SPACE)&& (c != '¿')&& (c != '?'))){e.consume();}       
       
        }
        if(e.getSource() ==  adminView.textRegistroCLienteJuridicoRif 
                || e.getSource () == adminView.textRegistroCLienteJuridicoPersonaContactoCedula1
                || e.getSource () == adminView.textRegistroCLienteNaturalCedula 
                || e.getSource() == adminView.textRegistroCLienteNaturalRif)
                
        {char c = e.getKeyChar();    
           if((c<'0'|| c>'9')&& ((c != (char)KeyEvent.VK_SPACE)&& (c != 'J')&& (c != 'V') && (c != 'E'))){e.consume(); }      
       }
        if(e.getSource() == adminView.textRegistroCLienteJuridicoCapitalDisponible){
           char c = e.getKeyChar();
           if((c<'0'|| c>'9') && (c != '.') && (c != ',')){e.consume();} //NUMEROS
           
       }
    }

 
    public void keyPressed(KeyEvent e) {
      
    }

  
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
       if(e.getSource() == adminView.textAdminEmpleadosBeneficiosBuscarEmpleado){
           listarEmpleadoPorCedula(adminView.tableAdminEmpleadosHorariosBuscarEmpleados1,(String)adminView.textAdminEmpleadosBeneficiosBuscarEmpleado.getText());
       }
       
       //EMPLEADOS -HORARIOS
       if(e.getSource() == adminView.textAdminEmpleadosHorariosBuscarDia){
         
          String fechaInicio = (adminView.textAdminEmpleadosHorariosBuscarDia.getText());
          buscarHorario(adminView.tableAdminEmpleadosHorarios,fechaInicio);
       }
       if(e.getSource() == adminView.textAdminEmpleadosHorariosBuscarEmpleado){
           listarEmpleadoPorCedula(adminView.tableAdminEmpleadosHorariosBuscarEmpleados,(String)adminView.textAdminEmpleadosHorariosBuscarEmpleado.getText());
       }
       //Sistema de Control de Entradas
       if(e.getSource() == adminView.textAdminEmpleadosHorariosBuscarEmpleado1){
           listarEmpleadoPorCedula(adminView.tableAdminEmpleadosHorariosBuscarEmpleados2,(String)adminView.textAdminEmpleadosHorariosBuscarEmpleado1.getText());
       }
       if(e.getSource() == adminView.textAdminEmpleadosHorariosBuscarDia1){
           listarEmpleadoEmpCheck(adminView.tableAdminEmpleadosHorarios1,adminView.textAdminEmpleadosHorariosBuscarDia1.getText());
       }
       
       //Empleados
       if(e.getSource() == adminView.textAdminEmpleadosBuscarTiendaNOmbre ){
           String nombreTienda= adminView.textAdminEmpleadosBuscarTiendaNOmbre.getText();
           buscarTienda (adminView.TableAdminEmpleadosBuscarTiendas,nombreTienda);
       }
       if(e.getSource() == adminView.textAdminEmpleadosBuscarCedula2){
           String  cedulaEmpleado = adminView.textAdminEmpleadosBuscarCedula2.getText();
           listarEmpleadoPorCedula(adminView.TableAdminEmpleadosBuscar1,cedulaEmpleado);
       }
       //Empleados/*
       if(e.getSource() == adminView.textAdminEmpleadosBuscarNombreRol){
           String nombreListarEmpleadoRol = adminView.textAdminEmpleadosBuscarNombreRol.getText();
            buscarRol(adminView.jTableAdminEmpleadosBuscarRol,nombreListarEmpleadoRol);
       }
       if(e.getSource() == adminView.textAdminEmpleadosBuscarNombrePermiso){
           String nombreListarPermiso = adminView.textAdminEmpleadosBuscarNombrePermiso.getText();
           buscarPermiso(adminView.jTableAdminEmpleadosBuscarPermisos,nombreListarPermiso );
       }
       
      /* if(e.getSource() == adminView.textAdminEmpleadosBuscarNombreBeneficio){
           String nombreListarBeneficio = adminView.textAdminEmpleadosBuscarNombreBeneficio.getText();
           buscarBeneficio(adminView.jTableAdminEmpleadosBuscarBeneficio,nombreListarBeneficio);
       }
       if(e.getSource() == adminView.btnAdminEmpleadosListarHorario){
       }*/
      //Vacaciones
      if(e.getSource() == adminView.textAdminVacacionesEmpleadosBuscarTiendaNombre){
          String cedula = adminView.textAdminVacacionesEmpleadosBuscarTiendaNombre.getText();
          listarEmpleadoVacacionesEmpleados( adminView.tableAdminVacacionesuscarTienda,cedula);
      }
         if(e.getSource() == adminView.textAdminEmpleadosHorariosBuscarEmpleado2){
          listarEmpleadoPorCedula(adminView.tableAdminEmpleadosHorariosBuscarEmpleados3,(String)adminView.textAdminEmpleadosHorariosBuscarEmpleado2.getText());
      }
        
        //Clientes
         
         if(e.getSource() == adminView.textAdminClientesJuridicosBuscarTiendas){
             listarTienda2(adminView.tableAdminJuridicosTiendas1,adminView.textAdminClientesJuridicosBuscarTiendas.getText());
         }
         if(e.getSource() == adminView.textAdminClientesNaturalesBuscarTienda){
             listarTienda2(adminView.tableAdminNaturalesTiendas,adminView.textAdminClientesNaturalesBuscarTienda.getText());
         }
       if(e.getSource() == adminView.textAdminClientesJuridicosBuscarClintes){
           listarClientesJuridico(adminView.tableAdminJuridicosBuscarClientsJuridicos,adminView.textAdminClientesJuridicosBuscarClintes.getText());
       }
       if(e.getSource() == adminView.textAdminClientesJuridiosPErsonaContactoBuscarEmpleado1){
           listarClientesJuridico(adminView.tableAdminPersonaContactoJuridicosBuscarClientsJuridicos,adminView.textAdminClientesJuridiosPErsonaContactoBuscarEmpleado1.getText());
       }
      
       if(e.getSource() == adminView.textAdminClientesNaturalesBuscarClientes){
           listarClientesNatural(adminView.tableAdminNaturalesBuscarCleintesNaturales,adminView.textAdminClientesNaturalesBuscarClientes.getText());
       }
       //Persona COntaco
       if(e.getSource() == adminView.textAdminClientesJuridiosPErsonaContactoBuscarPErsona2){
           listarPersonaContaco(adminView.tableAdminPersonaContactoJuridicosBuscarClientsPersonaCOntacto 
                   ,adminView.textAdminClientesJuridiosPErsonaContactoBuscarPErsona2.getText());
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
         modelTabla.addColumn("Dia");
         modelTabla.addColumn("Hora Inicial");
         modelTabla.addColumn("Hora Final");
        if(!fechaInicio .isEmpty()){
            
        
        Object[] columna= new Object[4];
        int numeroRegistro = modelPermisoDAO.listEmpleadoHorarioXFechaInicio(fechaInicio).size();
        
        for (int i = 0; i < numeroRegistro; i++) {
           columna[0]= modelPermisoDAO.listEmpleadoHorarioXFechaInicio(fechaInicio).get(i).getCodigoHorario();
           columna[1]=  modelPermisoDAO.listEmpleadoHorarioXFechaInicio(fechaInicio).get(i).getDiaHorario();
          columna[2]=  modelPermisoDAO.listEmpleadoHorarioXFechaInicio(fechaInicio).get(i).getHorarioInicial();
          columna[3]= modelPermisoDAO.listEmpleadoHorarioXFechaInicio(fechaInicio).get(i).getHorarioFinal();
          modelTabla.addRow(columna);
        }
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
    
    public void buscarTienda(JTable tablaTienda,String nombreTienda){
        DefaultTableModel modelTabla= new DefaultTableModel();
        tablaTienda.setModel(modelTabla);
        modelTabla.addColumn("Codigo Departamento");
         modelTabla.addColumn("Nombre Departamento");
         modelTabla.addColumn("Descripcion Departamento");
         modelTabla.addColumn("Nombre Tienda");
        // modelTabla.addColumn("Lugar");
         
         Object[] columna= new Object[4];
        int numeroRegistro = modelPermisoDAO.listEmpleadoTiendaXNOmbre(nombreTienda).size();
        
        for (int i = 0; i < numeroRegistro; i++) {
           columna[0]= modelPermisoDAO.listEmpleadoTiendaXNOmbre(nombreTienda).get(i).getCodigo();
           columna[1]=  modelPermisoDAO.listEmpleadoTiendaXNOmbre(nombreTienda).get(i).getNombreDepartamento();
          columna[2]=  modelPermisoDAO.listEmpleadoTiendaXNOmbre(nombreTienda).get(i).getDescripcion();
          columna[3]= modelPermisoDAO.listEmpleadoTiendaXNOmbre(nombreTienda).get(i).getNombreTeinda();
          //columna[4]=  Lugar.lugarFK(modelPermisoDAO.listEmpleadoTiendaXNOmbre(nombreTienda).get(i).getTie_lugar());
          
          modelTabla.addRow(columna);
        }
    }
    public void listarEmpleadoPorCedula (JTable tablaEmpleados,String nombreEmpleado){
    DefaultTableModel modelTabla= new DefaultTableModel();
        tablaEmpleados.setModel(modelTabla);
         modelTabla.addColumn("Cedula");
         modelTabla.addColumn("Nombre");
         modelTabla.addColumn("Apellido");
         modelTabla.addColumn("Salario");
         modelTabla.addColumn("Fecha Nacimiento");
         modelTabla.addColumn("Fecha Ingreso");
         modelTabla.addColumn("Departamento Actual");
         
         Object[] columna= new Object[7];
        int numeroRegistro = modelPermisoDAO.ListarEmpleados(nombreEmpleado).size();
        
        for (int i = 0; i < numeroRegistro; i++) {
           columna[0]= modelPermisoDAO.ListarEmpleados(nombreEmpleado).get(i).getCedulaEmpleado();
           columna[1]=  modelPermisoDAO.ListarEmpleados(nombreEmpleado).get(i).getPrimerNombreEmpleado();
          columna[2]=  modelPermisoDAO.ListarEmpleados(nombreEmpleado).get(i).getPrimerApellidoEmpleado();
          columna[3]= modelPermisoDAO.ListarEmpleados(nombreEmpleado).get(i).getSalarioEMpleado();
          columna[4]= modelPermisoDAO.ListarEmpleados(nombreEmpleado).get(i).getFechaNacimientoEMpleado();
          columna[5]= modelPermisoDAO.ListarEmpleados(nombreEmpleado).get(i).getFechaIngreso();
           columna[6]= modelPermisoDAO.ListarEmpleados(nombreEmpleado).get(i).getTienda();
          
          modelTabla.addRow(columna);
        }
    }
  public void listarEmpleadoVacacionesEmpleados(JTable tablaEmpleados ,String cedula){
        DefaultTableModel modelTabla= new DefaultTableModel();
        tablaEmpleados.setModel(modelTabla);
         modelTabla.addColumn("Cedula");
         modelTabla.addColumn("Nombre");
         modelTabla.addColumn("Apellido");
         modelTabla.addColumn("Fecha Inicial");
         modelTabla.addColumn("Fecha Final");
         
         
         
         
         Object[] columna= new Object[5];
        int numeroRegistro = modelPermisoDAO.listVacacionesXCedula(cedula).size();
        
        for (int i = 0; i < numeroRegistro; i++) {
           columna[0]= modelPermisoDAO.listVacacionesXCedula(cedula).get(i).getCedulaEmpleado();
           columna[1]=  modelPermisoDAO.listVacacionesXCedula(cedula).get(i).getPrimerNombreEmpleado();
            columna[2]=  modelPermisoDAO.listVacacionesXCedula(cedula).get(i).getPrimerApellidoEmpleado();
          columna[3]=  modelPermisoDAO.listVacacionesXCedula(cedula).get(i).getFechaVacacionInicial();
          columna[4]= modelPermisoDAO.listVacacionesXCedula(cedula).get(i).getFechaVacacionFinal();
         
          
          modelTabla.addRow(columna);
        }
  } 
  
  public void listarEmpleadoEmpCheck(JTable tablaEmpleados ,String cedula){
        DefaultTableModel modelTabla= new DefaultTableModel();
        tablaEmpleados.setModel(modelTabla);
         modelTabla.addColumn("Codigo");
         modelTabla.addColumn("Cedula");
         modelTabla.addColumn("Nombre y Apellido");
         modelTabla.addColumn("Hora de Entrada");
         modelTabla.addColumn("Hora Salida");
         
         
         
         
         Object[] columna= new Object[5];
        int numeroRegistro = modelPermisoDAO.listEmpleadoCheck(cedula).size();
        
        for (int i = 0; i < numeroRegistro; i++) {
           columna[0]= modelPermisoDAO.listEmpleadoCheck(cedula).get(i).getChekcod();
           columna[1]=  modelPermisoDAO.listEmpleadoCheck(cedula).get(i).getEmp_ci();
            columna[2]=  modelPermisoDAO.listEmpleadoCheck(cedula).get(i).getNombre_apellido();
          columna[3]=  modelPermisoDAO.listEmpleadoCheck(cedula).get(i).getChe_horaentrada();
          columna[4]= modelPermisoDAO.listEmpleadoCheck(cedula).get(i).getChe_horasalida();
         
          
          modelTabla.addRow(columna);
        }
  }    
  
    public void listarTienda2(JTable tabla ,String nombre){
        DefaultTableModel modelTabla= new DefaultTableModel();
        tabla.setModel(modelTabla);
         modelTabla.addColumn("Codigo");
         modelTabla.addColumn("NombreTienda");
        
         
         
         
         
         Object[] columna= new Object[2];
        int numeroRegistro = modelPermisoDAO.listTiendasXNOmbre(nombre).size();
        
        for (int i = 0; i < numeroRegistro; i++) {
           columna[0]= modelPermisoDAO.listTiendasXNOmbre(nombre).get(i).getTie_codigo();
           columna[1]=  modelPermisoDAO.listTiendasXNOmbre(nombre).get(i).getTie_nombre();
            
          
          modelTabla.addRow(columna);
        }
  } 
    public void listarClientesJuridico(JTable tabla ,String rif){
        DefaultTableModel modelTabla= new DefaultTableModel();
        tabla.setModel(modelTabla);
         modelTabla.addColumn("Codigo");
         modelTabla.addColumn("RIF");
         modelTabla.addColumn("Denominacion Comercial y Razon Social");
        modelTabla.addColumn("Pagina web");
        modelTabla.addColumn("Capital Disponible");
         
         
         
         
         Object[] columna= new Object[5];
        int numeroRegistro = modelPermisoDAO.listJuridicoXRIF(rif).size();
        
        for (int i = 0; i < numeroRegistro; i++) {
           columna[0]= modelPermisoDAO.listJuridicoXRIF(rif).get(i).getCli_codigo();
           columna[1]=  modelPermisoDAO.listJuridicoXRIF(rif).get(i).getJur_rif();
            columna[2]= modelPermisoDAO.listJuridicoXRIF(rif).get(i).getDenominacion_razon();
           columna[3]=  modelPermisoDAO.listJuridicoXRIF(rif).get(i).getPagina();
           columna[4]= modelPermisoDAO.listJuridicoXRIF(rif).get(i).getJur_capitaldisponible();
          
          
          modelTabla.addRow(columna);
        }
  } 
     public void listarClientesNatural(JTable tabla ,String cedula){
        DefaultTableModel modelTabla= new DefaultTableModel();
        tabla.setModel(modelTabla);
         modelTabla.addColumn("Codigo");
         modelTabla.addColumn("Cedula");
         modelTabla.addColumn("RIF");
        modelTabla.addColumn("NOmbre y Apellido");

         
         
         
         
         Object[] columna= new Object[4];
        int numeroRegistro = modelPermisoDAO.listNaturalXCedula(cedula).size();
        
        for (int i = 0; i < numeroRegistro; i++) {
           columna[0]= modelPermisoDAO.listNaturalXCedula(cedula).get(i).getCli_codigo();
           columna[1]=  modelPermisoDAO.listNaturalXCedula(cedula).get(i).getNat_cedula();
            columna[2]= modelPermisoDAO.listNaturalXCedula(cedula).get(i).getNat_rif();
           columna[3]=  modelPermisoDAO.listNaturalXCedula(cedula).get(i).getNombre_apelldio();
           
          
          
          modelTabla.addRow(columna);
        }
  } 
    public void listarPersonaContaco(JTable tabla ,String cedula){
        DefaultTableModel modelTabla= new DefaultTableModel();
        tabla.setModel(modelTabla);
         modelTabla.addColumn("Cedula");
         modelTabla.addColumn("NOmbre");
         modelTabla.addColumn("Apellido");
        modelTabla.addColumn("Telefono");

         
         
         
         
         Object[] columna= new Object[4];
        int numeroRegistro = modelPermisoDAO.listPersonaContactoXCedula(cedula).size();
        
        for (int i = 0; i < numeroRegistro; i++) {
           columna[0]= modelPermisoDAO.listPersonaContactoXCedula(cedula).get(i).getCdeula();
           columna[1]=  modelPermisoDAO.listPersonaContactoXCedula(cedula).get(i).getNombre();
            columna[2]= modelPermisoDAO.listPersonaContactoXCedula(cedula).get(i).getApellido();
           columna[3]=  modelPermisoDAO.listPersonaContactoXCedula(cedula).get(i).getTelefono();
           
          
          
          modelTabla.addRow(columna);
        }
  } 
    
}
