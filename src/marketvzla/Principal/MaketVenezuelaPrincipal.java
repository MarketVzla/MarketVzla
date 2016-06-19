package marketvzla.Principal;




import Controlador.LoginController;
import Modelo.Lugar;
import Modelo.PrincipalModel;
import Vista.LoginVista;

/**
 *
 * @author migue
 */
public class MaketVenezuelaPrincipal {
    
    private static LoginController loginController;
    private static LoginVista loginVista;
    public static void main(String[] args) {
        
        
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
            PrincipalModel.InicirarPrincipalModel("postgres","1234","marketvenezuela","localhost:5432");
           Lugar.llenarLugares();
            
            loginVista = new LoginVista();
            loginController = new LoginController(loginVista);
            loginVista.setLoginController(loginController);
            loginVista.MustraLogin();
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
