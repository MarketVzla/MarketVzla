/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.LoginVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Modelo.ExpresionesRegulares;
import Modelo.Lugar;
import Modelo.RegistroModel;
import Vista.RegistroCliente;

/**
 *
 * @author migue
 */
public class RegistroClienteController implements ActionListener/*,KeyListener*/{
private RegistroCliente user;
private LoginVista login;
private static boolean value;
private static int cod_nuevo_user ;

    public  RegistroClienteController(RegistroCliente user, LoginVista login){
        this.user=user;
        this.login=login;
      llenarComboBox();
    }
    
    public void llenarComboBox(){
           Lugar.getLugarTipo("estado", user.jComboBoxRegistroCLienteJuridicoEstadoDireccionFisica);
         Lugar.getLugarTipo("estado", user.jComboBoxRegistroCLienteJuridicoEstadoDireccionFiscal);
         Lugar.getLugarTipo("estado", user.jComboBoxRegistroCLienteNaturalEstado);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      
        
        if(e.getSource() == user.jtbtnRegistroCLienteVolver){
            user.setVisible(false);
            login.MustraLogin();
        }
        
       
        //Registar Cliente Juridico
        if(e.getSource() == user.jbtnRegistroCLienteJuridico ){
            
           
            
            if(ExpresionesRegulares.validarNombre(user.textRegistroCLienteJuridicoDenominacionComercial.getText())){
                if(ExpresionesRegulares.validarNombre(user.textRegistroCLienteJuridicoRazonSocial.getText())){
                   
                    if(ExpresionesRegulares.validarNombre(user.textRegistroCLienteJuridicoRif.getText())){
                        if(ExpresionesRegulares.validarTelefono(user.textRegistroCLienteJuridicoTelefono.getText())){
                            if(ExpresionesRegulares.validarWeb(user.textRegistroCLienteJuridicoWeb.getText())){
                               if(ExpresionesRegulares.validarCorreo(user.textRegistroCLienteJuridicoEmail.getText())){
                                 
                                   try{
                                        double capital =Double.parseDouble(user.textRegistroCLienteJuridicoCapitalDisponible.getText());
                                 if(ExpresionesRegulares.validarNombre(user.textRegistroCLienteJuridicoPreguntaSecreta.getText())){
                                   if(ExpresionesRegulares.validarNombre(user.textRegistroCLienteJuridicoRespuestaSecreta.getText())){
                                  
                                                            if(!user.textRegistroCLienteJuridicoUsuario.getText().isEmpty()){
                                                               if(!user.textRegistroCLienteJuridicoPass.getText().isEmpty()){
                                                                   
                                                                        
                                                                           String nombreParroquiaJuridico,nombreParroquiaJuridicoFiscal;
                                                                       nombreParroquiaJuridico=(String) user.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFisica.getItemAt(user.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFisica.getSelectedIndex());
                                                                        Lugar parroquiaLugarJuridico = Lugar.getLugarNombre(nombreParroquiaJuridico);
                                                                       
                                                                        nombreParroquiaJuridicoFiscal = (String) user.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFiscal.getItemAt(user.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFiscal.getSelectedIndex());
                                                                        Lugar parroquiaLugarJuridicoFiscal = Lugar.getLugarNombre(nombreParroquiaJuridicoFiscal );
                                                                        
                                                                        if(!nombreParroquiaJuridico.isEmpty()&& !nombreParroquiaJuridicoFiscal .isEmpty()){
                                                                        System.out.println("Cliente Juridico Entro");
                                                                        
                                                                      if(RegistroModel.insertJuridico((String)user.textRegistroCLienteJuridicoEmail.getText().toUpperCase(),
                                                                              0,(String) user.textRegistroCLienteJuridicoRif.getText().toUpperCase(), 
                                                                                (String)user.textRegistroCLienteJuridicoDenominacionComercial.getText().toUpperCase(), 
                                                                                (String)user.textRegistroCLienteJuridicoRazonSocial.getText().toUpperCase(), 
                                                                                (String)user.textRegistroCLienteJuridicoWeb.getText().toUpperCase(), 
                                                                                (String)user.textRegistroCLienteJuridicoCapitalDisponible.getText().toUpperCase(), 
                                                                                Integer.parseInt(parroquiaLugarJuridico.getCodigo()), 
                                                                               Integer.parseInt(parroquiaLugarJuridicoFiscal.getCodigo()),
                                                                              
                                                                               //ROL_PER
                                                                               (String)user.textRegistroCLienteJuridicoUsuario.getText().toUpperCase(), 
                                                                                (String)user.textRegistroCLienteJuridicoPass.getText().toUpperCase(), 
                                                                                (String)user.textRegistroCLienteJuridicoPreguntaSecreta.getText().toUpperCase(),
                                                                                (String)user.textRegistroCLienteJuridicoRespuestaSecreta.getText().toUpperCase())){
                                                                                    JOptionPane.showMessageDialog(null, 
                                                                                            "Bienvenido: "+(String)user.textRegistroCLienteJuridicoUsuario.getText().toUpperCase());
                                                                                    user.setVisible(false);
                                                                                    login.MustraLogin();
                                                                                } user.lblErrorRegistoClienteJuridicoCapitalUsuarioRepetido.setVisible(true);
                                                                         
                                                                                
                                                                       
                                                                               
                                                                        }   
                                                                }else{ user.lblErrorRegistoClienteJuridicoCapitalDisponilbe2.setVisible(true);    }
                                                            }else{  user.lblErrorRegistoClienteJuridicoCapitalUsuarioRepetido.setVisible(true); }
                                    
                                   }else{ user.lblErrorRegistoClienteJuridicoRespuestaSecreta.setVisible(true);}
                                 }else{user.lblErrorRegistoClienteJuridicoPreguntaSecreta.setVisible(true); }
                                 }catch(NumberFormatException nfe){user.lblErrorRegistoClienteJuridicoCapitalDisponilbe.setVisible(true);}
                               }else{user.lblErrorRegistoClienteJuridicoEmail.setVisible(true);}
                            }else{ user.lblErrorRegistoClienteJuridicoWeb.setVisible(true); }
                        }else{ user.lblErrorRegistoClienteJuridicoTelefono.setVisible(true); }
                    }else{ user.lblErrorRegistoClienteJuridicoRif.setVisible(true);}
                }else{ user.lblErrorRegistoClienteJuridicoRazonSocial.setVisible(true);}
            }else{  user.lblErrorRegistoClienteJuridicoDenominacionComercial.setVisible(true);}
        }
        
        //Registarar Cliente Natural
        if(e.getSource() == user.jbtnRegistroCLienteNatural){
            if(ExpresionesRegulares.validarNombre(user.textRegistroCLienteNaturalNombre.getText())){
                if(ExpresionesRegulares.validarNombre(user.textRegistroCLienteNaturalSegundoNombre.getText())){
                    if(ExpresionesRegulares.validarNombre(user.textRegistroCLienteNaturalApellido.getText())){
                        if(ExpresionesRegulares.validarNombre(user.textRegistroCLienteNaturalSegundoApellido.getText())){
                            if(ExpresionesRegulares.validarTelefono(user.textRegistroCLienteNaturalTelefono.getText())){
                               // if(ExpresionesRegulares.validarNombre(user.textRegistroCLienteNaturalCedula.getText())){
                                   // if(ExpresionesRegulares.validarNombre(user.textRegistroCLienteNaturalRif.getText())){
                                        if(ExpresionesRegulares.validarCorreo(user.textRegistroCLienteNaturalEmail.getText())){
                                            if(ExpresionesRegulares.validarNombre(user.textRegistroCLienteNaturalPreguntaSecreta.getText())){
                                                if(ExpresionesRegulares.validarNombre(user.textRegistroCLienteNaturalRespuestaSecreta.getText())){
                                                    if(!user.textRegistroCLienteNaturalUser.getText().isEmpty()){
                                                        if(!user.textRegistroCLienteNaturalPass.getText().isEmpty()){
                                                          /* if((user.jdateRegistroCLienteNaturalFechaNacimiento.getDate() != null) && (
                                                                   ExpresionesRegulares.verificarFecha(user.jdateRegistroCLienteNaturalFechaNacimiento))){
                                                                    SimpleDateFormat dateFotmat = new SimpleDateFormat("yyyy-MM-dd");
                                                                   String fecha = dateFotmat.format(user.jdateRegistroCLienteNaturalFechaNacimiento.getDate());
                                                                  System.out.println("Entro ");*/
                                                                    //System.out.println("F echa elegida: "+fecha);
                                                                
                                                                    String nombreMunicipioNatural =(String) user.jComboBoxRegistroCLienteNaturalMunicipio.getItemAt(user.jComboBoxRegistroCLienteNaturalMunicipio.getSelectedIndex());
                                                                    Lugar parroquiaNatural = Lugar.getLugarNombre(nombreMunicipioNatural);
                                                                    
                                                                    
                                                                 if(  RegistroModel.insertNatural((String)user.textRegistroCLienteNaturalEmail.getText().toUpperCase(),
                                                                         0,(String) user.textRegistroCLienteNaturalCedula.getText().toUpperCase(),
                                                                        (String)user.textRegistroCLienteNaturalRif.getText().toUpperCase(), 
                                                                        (String)user.textRegistroCLienteNaturalNombre.getText().toUpperCase(), 
                                                                        (String)user.textRegistroCLienteNaturalSegundoNombre.getText().toUpperCase(), 
                                                                        (String)user.textRegistroCLienteNaturalApellido.getText().toUpperCase(), 
                                                                        (String)user.textRegistroCLienteNaturalSegundoApellido.getText().toUpperCase(), 
                                                                       0, 
                                                                        Integer.parseInt(parroquiaNatural.getCodigo()),
                                                                        // Rol PER
                                                                        
                                                                       (String)user.textRegistroCLienteNaturalUser.getText().toUpperCase(),
                                                                       (String)user.textRegistroCLienteNaturalPass.getText().toUpperCase(),
                                                                       (String)user.textRegistroCLienteNaturalPreguntaSecreta.getText().toUpperCase(),
                                                                      (String) user.textRegistroCLienteNaturalRespuestaSecreta.getText().toUpperCase())){
                                                                        JOptionPane.showMessageDialog(null, "Bienvenido: "+(String)user.textRegistroCLienteJuridicoUsuario.getText().toUpperCase());
                                                                                    user.setVisible(false);
                                                                                    login.MustraLogin();
                                                                 }else {System.out.println("Usuario Repetido");}
                                                           
                                                           //}else{user.lblErrorRegistoClienteNaturalEmail3.setVisible(true);}
                                                        }else{user.lblErrorRegistoClienteNaturalEmail2.setVisible(true);}
                                                    }else{user.lblErrorRegistoClienteNaturalEmail1.setVisible(true);}
                                                }else{user.lblErrorRegistoClienteNaturalRespuestaSecreta.setVisible(true);}
                                            }else{user.lblErrorRegistoClienteNaturalPreguntaSecreta.setVisible(true);}
                                        }else{user.lblErrorRegistoClienteNaturalEmail.setVisible(true);  }
                                  //  }else{user.lblErrorRegistoClienteJuridicoRif.setVisible(true);}
                               // }else{ user.lblErrorRegistoClienteNaturalCedula.setVisible(true); }
                            }else{ user.lblErrorRegistoClienteNaturalTelefono.setVisible(true);}
                        }else{ user.lblErrorRegistoClienteNaturalSegundoApellido.setVisible(true); }
                    }else{ user.lblErrorRegistoClienteNaturalApellido.setVisible(true);}      
                }else{user.lblErrorRegistoClienteNaturalSegundoNOmbre.setVisible(true);}
            }else{user.lblErrorRegistoClienteNaturalPrimerNombre.setVisible(true);}
        }
       //Esto es para los combobox de Cliente Juridico
       //Direccion Fisica Juridico Municipio
        
       
       
       
       
       if(e.getSource() == user.jComboBoxRegistroCLienteJuridicoEstadoDireccionFisica){
            /*System.out.println("HOla desde combo box: "+(String) user.jComboBoxRegistroCLienteJuridicoEstadoDireccionFisica.getItemAt
                    (user.jComboBoxRegistroCLienteJuridicoEstadoDireccionFisica.getSelectedIndex()));
            */
            
            
            String nombreEstadoJuridico=(String) user.jComboBoxRegistroCLienteJuridicoEstadoDireccionFisica.getItemAt(user.jComboBoxRegistroCLienteJuridicoEstadoDireccionFisica.getSelectedIndex());
            Lugar estadolugarJuridico = Lugar.getLugarNombre(nombreEstadoJuridico);
          
            user.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFisica.removeAllItems();
            user.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFisica.removeAllItems();
            Lugar.getLugarFK(estadolugarJuridico .getCodigo(), user.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFisica);
            
            
            
        }
        
        if(e.getSource() == user.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFisica){
        String nombreMunicipio=(String) user.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFisica.getItemAt(user.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFisica.getSelectedIndex());
            Lugar municipioLugar = Lugar.getLugarNombre(nombreMunicipio);
            user.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFisica.removeAllItems();
            Lugar.getLugarFK(municipioLugar.getCodigo() , user.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFisica);
        }
        
        
        //Direccion Fiscal Juridico Municipio
        
        if(e.getSource() == user.jComboBoxRegistroCLienteJuridicoEstadoDireccionFiscal){
            String nombreEstadoJuridicoFiscal = (String) user.jComboBoxRegistroCLienteJuridicoEstadoDireccionFiscal.getItemAt(user.jComboBoxRegistroCLienteJuridicoEstadoDireccionFiscal.getSelectedIndex());
            Lugar EstadoJuridicoFiscal = Lugar.getLugarNombre(nombreEstadoJuridicoFiscal) ;
            user.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFiscal.removeAllItems();
            user.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFiscal.removeAllItems();
            Lugar.getLugarFK(EstadoJuridicoFiscal.getCodigo(), user.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFiscal);
        }
        
        if(e.getSource() == user.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFiscal){
            String nombreMunicipioJuridicoFiscal = (String) user.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFiscal.getItemAt(user.jComboBoxRegistroCLienteJuridicoMunicipioDireccionFiscal.getSelectedIndex());
            Lugar municipioJuridicoFiscal = Lugar.getLugarNombre(nombreMunicipioJuridicoFiscal);
            user.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFiscal.removeAllItems();
            Lugar.getLugarFK(municipioJuridicoFiscal.getCodigo(), user.jComboBoxRegistroCLienteJuridicoParroquiaDireccionFiscal);
        }
        
        //8635921
        //Direccion fisica Natural
        if(e.getSource() == user.jComboBoxRegistroCLienteNaturalEstado){
            String  nombreEstadoNatural = (String)user.jComboBoxRegistroCLienteNaturalEstado.getItemAt(user.jComboBoxRegistroCLienteNaturalEstado.getSelectedIndex());
            Lugar Estadonatural = Lugar.getLugarNombre(nombreEstadoNatural);
            user.jComboBoxRegistroCLienteNaturalMunicipio.removeAllItems();
            user.jComboBoxRegistroCLienteNaturalParroquia.removeAllItems();
            Lugar.getLugarFK(Estadonatural.getCodigo(), user.jComboBoxRegistroCLienteNaturalMunicipio);
        }
        
        if(e.getSource() == user.jComboBoxRegistroCLienteNaturalMunicipio){
            String  nombreEstadoNatural = (String) user.jComboBoxRegistroCLienteNaturalMunicipio.getItemAt(user.jComboBoxRegistroCLienteNaturalMunicipio.getSelectedIndex());
            Lugar municipioNatural = Lugar.getLugarNombre(nombreEstadoNatural);
            user.jComboBoxRegistroCLienteNaturalParroquia.removeAllItems();
            Lugar.getLugarFK(municipioNatural.getCodigo(), user.jComboBoxRegistroCLienteNaturalParroquia);
        }
    }

    /**
     * @return the value
     */
    public static boolean isValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public static void setValue(boolean value1) {
        value = value1;
    }

    /**
     * @return the cod_nuevo_user
     */
    public static int getCod_nuevo_user() {
        return cod_nuevo_user;
    }

    /**
     * @param cod_nuevo_user the cod_nuevo_user to set
     */
    public static void setCod_nuevo_user(int cod_nuevo_user2) {
        cod_nuevo_user = cod_nuevo_user2;
    }

   /* @Override
    public void keyTyped(KeyEvent ke) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
         //To change body of generated methods, choose Tools | Templates.
    }*/
    
}
