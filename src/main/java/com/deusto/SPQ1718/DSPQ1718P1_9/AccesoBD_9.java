package com.deusto.SPQ1718.DSPQ1718P1_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;


//Clase
public class AccesoBD_9 {
	private final static Logger log = Logger.getLogger("com.deusto.SPQ1718.DSPQ1718P1.HU1");
	Connection conn;
	/*
	 * Método de conexión con la base de datos a la dirección especificada
	 */
	
	/*public static void main(String[] args) throws SQLException {
		AccesoBD_13 a = new AccesoBD_13();
		a.aumentarAlmacen(13,5);
	}*/
	public AccesoBD_9() throws SQLException{
		//BasicConfigurator.configure();
		String env= "base";
		String value = System.getenv(env);
		String dbUrl = "jdbc:derby:"+value+"\\sql\\base;create=true";
	    conn = DriverManager.getConnection(dbUrl);
	}
	/*
	 * Zona de extraccion de datos de un producto por medio de selects
	 */
	public Float getPrecioP(int p){
		 float pr = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT precio FROM producto  WHERE id = "+p);
			while (rs.next()){
				 pr = rs.getFloat("precio");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Error en la Select de PrecioP");
			e.printStackTrace();
		}
		return pr;
	}
	
	public String getNombreP(int p){
		 String n="";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT nombre FROM producto WHERE id = "+p);
			while (rs.next()){
				 n = rs.getString("nombre");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Error en la Select de NombreP");
			e.printStackTrace();
		}
		return n;
	}
	
	public String getProductoMasVendido() throws SQLException{
		/*Que producto se ha vendido más*/
		String n="";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ( SELECT producto, COUNT(producto) cont FROM compra GROUP BY producto ) as calc1 WHERE (SELECT MAX(cont) m FROM ( SELECT COUNT(producto) cont FROM compra GROUP BY producto ) AS cacl) = cont");
			while (rs.next()){
				 n = rs.getString("nombre");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Error en la Select de NombreP");
			e.printStackTrace();
		}
		return n;
	}
	
/*	public ResultSet getProductoMasVendido() throws SQLException{
		/*Que producto se ha vendido más*/
/*		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ( SELECT producto, COUNT(producto) cont FROM compra GROUP BY producto ) as calc1 WHERE (SELECT MAX(cont) m FROM ( SELECT COUNT(producto) cont FROM compra GROUP BY producto ) AS cacl) = cont");
		return rs;
	}
*/	
	public ResultSet getEmpleadoMasVentas() throws SQLException{
		/*Que producto se ha vendido más*/
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ( SELECT empleado, COUNT(empleado) cont FROM compra GROUP BY empleado ) as calc1 WHERE (SELECT MAX(cont) m FROM ( SELECT COUNT(empleado) cont FROM compra GROUP BY empleado ) AS cacl) = cont");
		return rs;
	}
}