/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Leonardo
 */
public class ConexionBaseDeDatos {
    
    /**
     * Establece la conexion con la Base de Datos
     * @param puerto
     * @param nombrebd
     * @param contraseña
     * @return Connection Esta es la Conexion con la base de datos
     */
    public static Connection coneccionSQL(String puerto, String nombrebd, String contraseña)
    {
            try
            {
                    String cadena;
                    cadena="jdbc:postgresql://localhost:"+puerto+"/"+nombrebd;
                    Class.forName("org.postgresql.Driver");
                    Connection con = DriverManager.getConnection(cadena, "postgres", contraseña);
                    return con;
            }
            catch(Exception e)
            {
                   System.out.println(e.getMessage());
            }
            return null;
    }
}
