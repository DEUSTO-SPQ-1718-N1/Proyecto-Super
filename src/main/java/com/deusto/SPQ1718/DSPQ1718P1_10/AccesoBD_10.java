package com.deusto.SPQ1718.DSPQ1718P1_10;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/** 
*@brief Esta clase contiene los metodos de consulta a la BD mediante sentencias spl.
*/
public class AccesoBD_10 {
	
	private final static Logger log = Logger.getLogger("com.deusto.SPQ1718.DSPQ1718P1.HU10");
	Connection conn;

	public AccesoBD_10() throws SQLException{
		// TODO Auto-generated constructor stub
			String env= "base";
			String value = System.getenv(env);
			String dbUrl = "jdbc:derby:"+value+"\\sql\\base;create=true";
		    conn = DriverManager.getConnection(dbUrl);
	}
	
	/** 
	*@brief Este metodo get hace una selec del titulo
	*@param t id del manual del que se quiere obtener el titulo
	*/
	public String getTitulo(int t){
		String tit = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT titulo FROM manual  WHERE id = "+t);
			while (rs.next()){
				 tit = rs.getString("titulo");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Error en la Select de Titulo");
			e.printStackTrace();
		}
		return tit;
	}
	
	/** 
	*@brief Este metodo get hace una selec del texto
	*@param t id del manual del que se quiere obtener el texto
	*/
	public String getTexto(int t){
		String tex = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT texto FROM manual  WHERE id = "+t);
			while (rs.next()){
				tex = rs.getString("texto");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("Error en la Select de Texto");
			e.printStackTrace();
		}
		return tex;
	}
	
	/** 
	*@brief Este metodo hace una selec del titulo que se quiere visualizar y luego un udpate para añadir los cambios
	*@param t id del manual del que se quiere obtener el titulo para su posterior edición
	*@param titulo contendrá el nuevo titulo que se escribirá en la BD
	*/
	public int actualizarTitulo(int t, String titulo){
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT titulo FROM manual WHERE id = "+t);
			/*El código de retorno 1 indica que no se ha encontrado el manual con id t*/
			if(rs.next()==false){ log.warn("Manual no encontrado"); return 1;}
			stmt.executeUpdate("update manual set titulo ='"+titulo+"' WHERE id ="+t);//Registrar un producto
		} 
		catch (SQLException e) {
			e.printStackTrace();
			//Devuelve un tres si existe un error en la alguna sentecia SQL a causa de un parámetro mal pasado
			log.error("Error en la Select actualizar Titulo");
			return 3;
		}
		return 0;
	}
	
	/** 
	*@brief Este metodo hace una selec del texto que se quiere visualizar y luego un udpate para añadir los cambios
	*@param t id del manual del que se quiere obtener el texto para su posterior edición
	*@param texto contendrá el nuevo texto que se escribirá en la BD
	*/
	public int actualizarTexto(int t, String texto){
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT texto FROM manual WHERE id = "+t);
			/*El código de retorno 1 indica que no se ha encontrado el manual con id t*/
			if(rs.next()==false){ log.warn("Manual no encontrado"); return 1;}
			stmt.executeUpdate("update manual set texto ='"+texto+"' WHERE id ="+t);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			//Devuelve un tres si existe un error en la alguna sentecia SQL a causa de un parámetro mal pasado
			log.error("Error en la Select actualizar Texto");
			return 3;
		}
		return 0;
	}
}
