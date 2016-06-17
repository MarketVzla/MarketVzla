/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Etiquetas;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static org.apache.xalan.lib.ExsltDatetime.date;

/**
 *
 * @author Pelusa
 */
public class ControladorReporte {
    
    
    public static void GenerarReportePeriodoDeTiempo(String reporten, Date fechainicio, Date fechafin)
    { 
        Connection conecion=null;
         if (conecion!=null)
             return;
         String url="jdbc:postgresql://localhost:5432/marketvenezuela";
         try {
            Class.forName("org.postgresql.Driver");
            conecion=DriverManager.getConnection(url, "postgres", "1234");
            if(conecion!=null){
                JasperReport reporte = (JasperReport)JRLoader.loadObjectFromFile("src\\Vista\\"+reporten+".jasper");
                Map<String,Object> parameters = new HashMap<String,Object>();
                parameters.put("fechainicio",fechainicio);
                parameters.put("fechafin",fechafin);
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parameters,coneccionSQL());
                JasperViewer jv=new JasperViewer(jasperPrint,false);
                jv.setVisible(true);
                   
                //JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Leonardo\\Documents\\UCAB\\Base de Datos I\\Hipodromo\\Hipodromo\\src\\");
            }
        } catch (Exception e) {
             System.err.println(e.getMessage());
        }
    }
    
        public static void GenerarFactura(String codigo, Double monto, String identificador)
    {
        Connection conecion=null;
         if (conecion!=null)
             return;
         String url="jdbc:postgresql://localhost:5432/marketvenezuela";
         try {
            Class.forName("org.postgresql.Driver");
            conecion=DriverManager.getConnection(url, "postgres", "1234");
            if(conecion!=null){
                JasperReport reporte = (JasperReport)JRLoader.loadObjectFromFile("src\\Vista\\Factura.jasper");
                Map<String,Object> parameters = new HashMap<String,Object>();
                parameters.put("codigoCompra",Integer.parseInt(codigo));
                Double subtotal= monto-(monto*0.12);
                parameters.put("subtotal",subtotal);
                parameters.put("total",monto);
                parameters.put("identificador",identificador);
                /*parameters.put("codigoCliente",1);
                parameters.put("identificador","01-00004321");*/
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parameters,coneccionSQL());
                JasperViewer jv=new JasperViewer(jasperPrint,false);
                jv.setVisible(true);
                   
                //JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Leonardo\\Documents\\UCAB\\Base de Datos I\\Hipodromo\\Hipodromo\\src\\");
            }
        } catch (Exception e) {
             System.err.println(e.getMessage());
        }
    }
    
    public static void GenerarDiarioMarket(String codigo)
    {
        Connection conecion=null;
         if (conecion!=null)
             return;
         String url="jdbc:postgresql://localhost:5432/marketvenezuela";
         try {
            Class.forName("org.postgresql.Driver");
            conecion=DriverManager.getConnection(url, "postgres", "1234");
            if(conecion!=null){
                JasperReport reporte = (JasperReport)JRLoader.loadObjectFromFile("src\\Vista\\DiarioMarket.jasper");
                Map<String,Object> parameters = new HashMap<String,Object>();
                parameters.put("codigo",Integer.parseInt(codigo));
                /*parameters.put("codigoCliente",1);
                parameters.put("identificador","01-00004321");*/
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parameters,coneccionSQL());
                JasperViewer jv=new JasperViewer(jasperPrint,false);
                jv.setVisible(true);
                   
                //JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Leonardo\\Documents\\UCAB\\Base de Datos I\\Hipodromo\\Hipodromo\\src\\");
            }
        } catch (Exception e) {
             System.err.println(e.getMessage());
        }
    }
    
    public static void GenerarCarnet(String codigo, String identificador)
    {
        Connection conecion=null;
         if (conecion!=null)
             return;
         String url="jdbc:postgresql://localhost:5432/marketvenezuela";
         try {
            Class.forName("org.postgresql.Driver");
            conecion=DriverManager.getConnection(url, "postgres", "1234");
            if(conecion!=null){
                JasperReport reporte = (JasperReport)JRLoader.loadObjectFromFile("src\\Vista\\Carnet.jasper");
                Map<String,Object> parameters = new HashMap<String,Object>();
                parameters.put("codigoCliente",Integer.parseInt(codigo));
                parameters.put("identificador",identificador);
                /*parameters.put("codigoCliente",1);
                parameters.put("identificador","01-00004321");*/
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parameters,coneccionSQL());
                JasperViewer jv=new JasperViewer(jasperPrint,false);
                jv.setVisible(true);
                   
                //JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Leonardo\\Documents\\UCAB\\Base de Datos I\\Hipodromo\\Hipodromo\\src\\");
            }
        } catch (Exception e) {
             System.err.println(e.getMessage());
        }
    }
    
    public static void GenerarCarnetJuridico(String codigo, String identificador)
    {
        Connection conecion=null;
         if (conecion!=null)
             return;
         String url="jdbc:postgresql://localhost:5432/marketvenezuela";
         try {
            Class.forName("org.postgresql.Driver");
            conecion=DriverManager.getConnection(url, "postgres", "1234");
            if(conecion!=null){
                JasperReport reporte = (JasperReport)JRLoader.loadObjectFromFile("src\\Vista\\CarnetJuridico.jasper");
                Map<String,Object> parameters = new HashMap<String,Object>();
                parameters.put("codigo",Integer.parseInt(codigo));
                parameters.put("identificador",identificador);
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parameters,coneccionSQL());
                JasperViewer jv=new JasperViewer(jasperPrint,false);
                jv.setVisible(true);
                   
                //JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\Leonardo\\Documents\\UCAB\\Base de Datos I\\Hipodromo\\Hipodromo\\src\\");
            }
        } catch (Exception e) {
             System.err.println(e.getMessage());
        }
    }
    
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
                JasperReport reporte = (JasperReport)JRLoader.loadObjectFromFile("src\\Vista\\"+reporten+".jasper");
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null,coneccionSQL());
                JasperViewer jv=new JasperViewer(jasperPrint,false);
                jv.setVisible(true);
                   
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
