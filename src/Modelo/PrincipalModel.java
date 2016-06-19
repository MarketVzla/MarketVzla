/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author migue
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class PrincipalModel {
    private static Connection con;
	private static String nombreDriver,user,password,url,nombrebd;
	private static Statement stm;
	private static String q="";

    /**
     * @return the con
     */
    public static Connection getCon() {
        return con;
    }

    /**
     * @param aCon the con to set
     */
    public static void setCon(Connection aCon) {
        con = aCon;
    }

    /**
     * @return the nombreDriver
     */
    public static String getNombreDriver() {
        return nombreDriver;
    }

    /**
     * @param aNombreDriver the nombreDriver to set
     */
    public static void setNombreDriver(String aNombreDriver) {
        nombreDriver = aNombreDriver;
    }

    /**
     * @return the user
     */
    public static String getUser() {
        return user;
    }

    /**
     * @param aUser the user to set
     */
    public static void setUser(String aUser) {
        user = aUser;
    }

    /**
     * @return the password
     */
    public static String getPassword() {
        return password;
    }

    /**
     * @param aPassword the password to set
     */
    public static void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * @return the url
     */
    public static String getUrl() {
        return url;
    }

    /**
     * @param aUrl the url to set
     */
    public static void setUrl(String aUrl) {
        url = aUrl;
    }

    /**
     * @return the nombrebd
     */
    public static String getNombrebd() {
        return nombrebd;
    }

    /**
     * @param aNombrebd the nombrebd to set
     */
    public static void setNombrebd(String aNombrebd) {
        nombrebd = aNombrebd;
    }

    /**
     * @return the instruccion
     */
    public static Statement getStm() {
        return stm;
    }

    /**
     * @param aInstruccion the instruccion to set
     */
    public static void setStm(Statement aStm) {
        stm = aStm;
    }

    /**
     * @return the q
     */
    public static String getQ() {
        return q;
    }

    /**
     * @param aQ the q to set
     */
    public static void setQ(String aQ) {
        q = aQ;
    }
	
	public PrincipalModel (){
		user="none";
		password="none";
	}
	
	public static void InicirarPrincipalModel (String usuario,String pass,String nombrebd,String host){

		try {
			PrincipalModel.setNombreDriver("org.postgresql.Driver");
			PrincipalModel.setUser(usuario);
			PrincipalModel.setPassword(pass);	
                        PrincipalModel.setNombrebd(nombrebd);
			PrincipalModel.setUrl("jdbc:postgresql://"+host+"/"+nombrebd);
			
			Class.forName(getNombreDriver());// Especifica a la clase que el Nombre del Driver es "nombreDriver"
			
			PrincipalModel.setCon(DriverManager.getConnection(getUrl(), getUser(), getPassword()));
			PrincipalModel.setStm(getCon().createStatement());
			PrincipalModel.setQ("s");
                        System.out.println("Conectado a: "+nombrebd);
			
		} catch (Exception  ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, ex.getMessage());
			
			PrincipalModel.setQ("n");
		}
	}



    
}
