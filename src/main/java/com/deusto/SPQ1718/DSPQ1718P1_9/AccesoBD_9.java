package com.deusto.SPQ1718.DSPQ1718P1_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

/** @brief Clase de acceso a la BD.
 * 
 *   Contiene los metodos con las sentencias sql.
 */
public class AccesoBD_9 {
	private final static Logger log = Logger.getLogger("com.deusto.SPQ1718.DSPQ1718P1.HU9");
	Connection conn;
	
	/**
	 * Método de conexión con la base de datos a la dirección especificada
	 */
	public AccesoBD_9() throws SQLException{
		//BasicConfigurator.configure();
		String env= "base";
		String value = System.getenv(env);
		String dbUrl = "jdbc:derby:"+value+"\\sql\\base;create=true";
	    conn = DriverManager.getConnection(dbUrl);
	}
	
	/**
	 * Zona de extraccion de datos de un producto por medio de selects
	 * 
	 */
	
	/**	@brief Get precio del producto pasado como parametro
	 * 
	 *  @param p		id producto
	 *  @return pr 		precio del prooducto       
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
			log.error("Error en la Select de PrecioP");
			e.printStackTrace();
		}
		return pr;
	}
	
	/**	@brief Get nombre del producto pasado como parametro
	 * 
	 *  @param p		id producto
	 *  @return n 		nombre del producto       
	 */
	public String getNombreP(int p){
		 String n="";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT nombre FROM producto WHERE id = "+p);
			while (rs.next()){
				 n = rs.getString("nombre");
			 }
		} catch (SQLException e) {
			log.error("Error en la Select de NombreP");
			e.printStackTrace();
		}
		return n;
	}
	
	/**	@brief Get nombre del empleado pasado como parametro
	 * 
	 *  @param emp		id empleado
	 *  @return n 		nombre del empleado       
	 */
	public String getNombreE(int emp){
		 String n="";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT nombre FROM empleado WHERE id = "+ emp);
			while (rs.next()){
				 n = rs.getString("nombre");
			 }
		} catch (SQLException e) {
			log.error("Error en la Select de NombreP");
			e.printStackTrace();
		}
		return n;
	}
	
	/**	@brief Get apellido del empleado pasado como parametro
	 * 
	 *  @param ape		id empleado
	 *  @return n 		apellido del empleado       
	 */
	public String getApellidoE(int ape){
		 String n="";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT apellido FROM empleado WHERE id = "+ ape);
			while (rs.next()){
				 n = rs.getString("apellido");
			 }
		} catch (SQLException e) {
			log.error("Error en la Select de NombreP");
			e.printStackTrace();
		}
		return n;
	}
	
	/**	@brief Get id del producto mas vendido
	 * 
	 *  Que producto se ha vendido más
	 * 
	 *  @return n 		id del producto mas vendido       
	 */
	public int getProductoMasVendido() throws SQLException{
		int n = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT producto FROM ( SELECT producto, COUNT(producto) cont FROM compra GROUP BY producto ) as calc1 WHERE (SELECT MAX(cont) m FROM ( SELECT COUNT(producto) cont FROM compra GROUP BY producto ) AS cacl) = cont");
			while (rs.next()){
				n = rs.getInt("producto");
				System.out.println("BD_prod: " + n);
			 }
		} catch (SQLException e) {
			log.error("Error en la Select de NombreP");
			e.printStackTrace();
		}
		return n;
	}
	
	/**	@brief Get id del empleado con mas ventas
	 * 
	 *  Que empleado tiene mas ventas
	 * 
	 *  @return n 		id del empleado con mas ventas       
	 */
	public int getEmpleadoMasVentas() throws SQLException{
		int n = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ( SELECT empleado, COUNT(empleado) cont FROM compra GROUP BY empleado ) as calc1 WHERE (SELECT MAX(cont) m FROM ( SELECT COUNT(empleado) cont FROM compra GROUP BY empleado ) AS cacl) = cont");
			while (rs.next()){
				n = rs.getInt("empleado");
				System.out.println("BD_emple: " + n);
			}
		} catch (SQLException e) {
			log.error("Error en la Select de NombreP");
			e.printStackTrace();
		}
		return n;
	}
}