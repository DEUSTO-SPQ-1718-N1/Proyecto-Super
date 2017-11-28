package com.deusto.SQP1718.DSPQ1718P1_8;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.deusto.SPQ1718.DSPQ1718P1_1.AccesoBD_13;
import com.deusto.SPQ1718.DSPQ1718P1_8.ConexionBaseDatos;

public class ConexionBaseDatosTest {
	static ConexionBaseDatos db;
	Connection conn;
	PreparedStatement stmt;
	@BeforeClass
	public static void con(){
			try {
			db =  new ConexionBaseDatos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ConexionBaseDatosTest () throws SQLException{
		String env= "base"; /**< El nombre de la variable del entorno que contiene la direccion de la base de datos */
		String value = System.getenv(env); /**< La busqueda asociada a esa variable de entorno */
		String dbUrl = "jdbc:derby:"+value+"\\sql2\\base;create=true";
	    conn = DriverManager.getConnection(dbUrl);
	}
	@Test
	public void testgetMedia() {
		int id=1;
		int media=0;
		int numeroFilas=0;
		int totalPuntuaciones=0;
		
		
		try {
			//Primero buscamos en la tabla empleado el id que corresponde al nombre que nos han pasado
			stmt = conn.prepareStatement("SELECT * FROM experiencia WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			 while (rs.next()) {
				 numeroFilas++;
				 totalPuntuaciones = totalPuntuaciones + rs.getInt("experiencia");
			 }
			//Cuando ya tenemos todos los datos listos los insertamos en la bd
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Devuelve un tres si existe un error en la alguna sentecia SQL a causa de un parámetro mal pasado
			
		}
		media=totalPuntuaciones/numeroFilas;
		assertEquals(media, db.getMedia(1), 0.01);
		
	}

}
