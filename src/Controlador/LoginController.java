/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.LoginModel;
import Modelo.PermisoDAO;
import Vista.AdminVista;
import Vista.LoginVista;
import Vista.RegistroCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author migue
 */
public class LoginController implements ActionListener{
    
  
   
    private LoginVista vistaLogin;
    

    public LoginController(LoginVista vistaLogin) {
        
        
       
        this.vistaLogin = vistaLogin;
        LoginModel.Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vistaLogin.jbtnLogin) {
           
           
           if(!vistaLogin.textLoginUsuario.getText().isEmpty())
           {
               String nick=(String)vistaLogin.textLoginUsuario.getText(),
                       pass=(String)vistaLogin.textLoginPassword.getText();
             
              int value= LoginModel.validarLog(nick, pass);
                  
              //RolPermiso.mostrarSession();
               
             if(value == 1){
               AdminVista vistaAdmin = new AdminVista();
               PermisoDAO modelPermiso = new PermisoDAO();
               AdminController controllerAdmin = new  AdminController (vistaAdmin,vistaLogin ,modelPermiso);
                vistaAdmin .setController(controllerAdmin);
               vistaAdmin .getVistaAdmin();
                
                vistaLogin.setVisible(false);
             }
           } 
                
        }
        
        if  (e.getSource() == vistaLogin.jbtnRegistrar){
            //Solo NAtural o Juridico
            
            RegistroCliente nuevoRegistro = new RegistroCliente ();
            RegistroClienteController nuevoRegistroController = new 
                    RegistroClienteController(nuevoRegistro, vistaLogin);
            nuevoRegistro.setRegistroClienteController(nuevoRegistroController);
            nuevoRegistro.MustraRegisroCliente();
            vistaLogin.setVisible(false);
        }
        if(e.getSource() == vistaLogin.jbtnRecuperarPass){
            
        }
        if(e.getSource() == vistaLogin.jbtnSalir){
            LoginModel.SalirLogin();
                vistaLogin.dispose();
		System.exit(0);

        }
    }
    
   
}
