/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Etiquetas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/*import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
*/
/**
 *
 * @author Pelusa
 */
public class ControladorReporte {
    
    public static void abrirReporte(String reporten)
    {
        Connection conecion=null;
         if (conecion!=null)
             return;
         String url="jdbc:postgresql://localhost:5432/marketvenezuela";
         try {
            Class.forName("org.postgresql.Driver");
            conecion=DriverManager.getConnection(url, "postgres", "1234");
            if(conecion!=null){
              /*  JasperReport reporte = (JasperReport)JRLoader.loadObjectFromFile("src\\Vista\\"+reporten+".jasper");
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null,coneccionSQL());
                JasperViewer jv=new JasperViewer(jasperPrint,false);
                jv.setVisible(true);*/
                   
                //JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Leonardo\\Documents\\UCAB\\Base de Datos I\\Hipodromo\\Hipodromo\\src\\");
            }
        } catch (Exception e) {
             System.err.println(e.getMessage());
        }
    }
    
    public static Connection coneccionSQL ()
    {
        java.sql.Connection connection = null;
        Statement s = null;
        
        String url = "jdbc:postgresql://localhost:"+Etiquetas.puerto+"/"+Etiquetas.nombrebd+"";
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url, "postgres", Etiquetas.contraseña);
            
            s = connection.createStatement();
            
            
            return s.getConnection();
            
        }catch(Exception e){
            System.err.println("Error de Conexion");
        }
        return null;
    }
    
}
