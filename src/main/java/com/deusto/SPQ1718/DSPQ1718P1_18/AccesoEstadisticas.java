package com.deusto.SPQ1718.DSPQ1718P1_18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoEstadisticas {

	Connection conn;
	/*Contexión a la BD*/
	public AccesoEstadisticas() throws SQLException {
		String s = System.getProperty("user.dir");
	    String dbUrl = "jdbc:derby:"+s+"\\src\\main\\sql\\base;create=true";
	    conn = DriverManager.getConnection(dbUrl);
	  }
	
	public ResultSet getResumenProducto(int p) throws SQLException{
		/*Cuanto se ha comprado de un producto segun su id*/
		 Statement stmt = conn.createStatement();
		 ResultSet rs = stmt.executeQuery("SELECT * FROM producto WHERE id="+p);
		return rs;
	}
	
	public ResultSet getProductoMasVendido() throws SQLException{
		/*Que producto se ha vendido más*/
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ( SELECT producto, COUNT(producto) cont FROM compra GROUP BY producto ) as calc1 WHERE (SELECT MAX(cont) m FROM ( SELECT COUNT(producto) cont FROM compra GROUP BY producto ) AS cacl) = cont");
		return rs;
	}
	
	public ResultSet getEmpleadoMasVentas() throws SQLException{
		/*Que producto se ha vendido más*/
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ( SELECT empleado, COUNT(empleado) cont FROM compra GROUP BY empleado ) as calc1 WHERE (SELECT MAX(cont) m FROM ( SELECT COUNT(empleado) cont FROM compra GROUP BY empleado ) AS cacl) = cont");
		return rs;
	}
	
	public ResultSet getExperiencia(int c, int e) throws SQLException{
		
		Statement stmt = conn.createStatement();
		 ResultSet rs = stmt.executeQuery("SELECT * FROM experiencia WHERE cliente="+c+" AND empleado ="+e );
		return rs;
		
	}
	
	
	
	

}
