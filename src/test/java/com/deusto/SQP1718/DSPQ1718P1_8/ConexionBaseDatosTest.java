package com.deusto.SQP1718.DSPQ1718P1_8;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.deusto.SPQ1718.DSPQ1718P1_1.AccesoBD_13;
import com.deusto.SPQ1718.DSPQ1718P1_8.ConexionBaseDatos;

public class ConexionBaseDatosTest {
	static ConexionBaseDatos db;
	
	@BeforeClass
	public static void con(){
		Connection conn;
		String env= "base";
		String value = System.getenv(env);
		String dbUrl = "jdbc:derby:"+value+"\\sql2\\base;create=true";
			try {
			conn = DriverManager.getConnection(dbUrl);
			db =  new ConexionBaseDatos(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 	Prueba del cálculo correcto de medias
	 */
	@Test
	public void testgetMedia() {
		int m = db.getMedia(1);
		int num  =db.getNumExp(1);
		int s= db.getSumaExp(1);
		
		int m2=s/num;
		assertEquals(m2,m);
			
	}
	/**
	 * Prueba de la extracción correcta de comentarios
	 */
	@Test
	public void testgetComentarios(){
		ArrayList<String> a = db.getComentarios(1);
		String c = a.get(1);
		assertEquals("Bien",c);
	}

}
