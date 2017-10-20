package com.deusto.SPQ1718.DSPQ1718P1_38;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*Esta clase crear las consultas necesarias para obtener la informacón que 
 * requiere la ventana de usuario y hacer conexión con la base de datos
 */
public class AccesoPuntosCliente {
	Connection conn;
	/*Contexión a la BD*/
	public AccesoPuntosCliente() throws SQLException {
		String s = System.getProperty("user.dir");
	    String dbUrl = "jdbc:derby:"+s+"\\src\\main\\sql\\base;create=true";
	    conn = DriverManager.getConnection(dbUrl);
	  }
	
	public ResultSet getPuntos(int c) throws SQLException{
		 Statement stmt = conn.createStatement();
		 ResultSet rs = stmt.executeQuery("SELECT * FROM cliente WHERE id="+c);
		return rs;
	}
	
	public ResultSet getUltimaCompra() throws SQLException{
		 Statement stmt = conn.createStatement();
		 ResultSet rs = stmt.executeQuery("SELECT * FROM compra WHERE cliente = 1 AND (SELECT MAX(fecha) FROM compra) = fecha");
		return rs;
	}

}
