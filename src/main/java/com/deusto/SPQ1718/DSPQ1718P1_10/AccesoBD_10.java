package com.deusto.SPQ1718.DSPQ1718P1_10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

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
	public int actualizarTitulo(int t, String titulo){
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT titulo FROM manual WHERE id = "+ t);
			/*El código de retorno 1 indica que no se ha encontrado el manual con id p*/
			if(rs.next()==false){ log.warn("Titulo no encontrado"); return 1;}
			stmt.executeUpdate("update manual set titulo ="+titulo+" WHERE id ="+t);
		} 
		catch (SQLException e) {
			e.printStackTrace();
			//Devuelve un tres si existe un error en la alguna sentecia SQL a causa de un parámetro mal pasado
			log.error("Error en la Select actualizar Manual");
			return 3;
		}
		return 0;
	}
	
	public int actualizarTexto(int t, String texto){
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT texto FROM manual WHERE id = "+ t);
			/*El código de retorno 1 indica que no se ha encontrado el manual con id p*/
			if(rs.next()==false){ log.warn("Texto no encontrado"); return 1;}
			stmt.executeUpdate("update manual set texto ="+texto+" WHERE id ="+t);
		} 
		catch (SQLException e) {
			e.printStackTrace();
			//Devuelve un tres si existe un error en la alguna sentecia SQL a causa de un parámetro mal pasado
			log.error("Error en la Select actualizar Manual");
			return 3;
		}
		return 0;
	}
}
