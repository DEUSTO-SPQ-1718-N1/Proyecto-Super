package com.deusto.SQP1718.DSPQ1718P1_6;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class dbTest {
	Connection conn;
	PreparedStatement stmt;
	

	@Test
	public void test() throws SQLException {
		
		String s = System.getProperty("user.dir");
	    String dbUrl = "jdbc:derby:"+s+"\\src\\main\\sql\\base;create=true";
	    conn = DriverManager.getConnection(dbUrl);
	    this.loadComentarios();
		
		
	}

	public int numeroFilas() {
		// TODO Auto-generated method stub
		
		return 0;
	}

	public String[] loadComentarios() throws SQLException {
		// TODO Auto-generated method stub
		try {
			String comentarioTexto="Bien Hecho";
			String comentarioBD="";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM experiencia WHERE fecha = '19.10.2017'");
			while(rs.next()){
				comentarioBD=rs.getString("comentario");
			}
			
			assertEquals(comentarioTexto, comentarioBD);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public void insert(String fecha, int cliente, String empleado,
			int experiencia, String comentario) {
		// TODO Auto-generated method stub
		
		
		
	}

}
