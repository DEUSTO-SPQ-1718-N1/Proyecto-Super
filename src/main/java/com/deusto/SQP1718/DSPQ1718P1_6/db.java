package com.deusto.SQP1718.DSPQ1718P1_6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.deusto.SPQ1718.Proyecto_Super.Base;

public class db {
		Connection conn;
		  public db() throws SQLException {
		    // -------------------------------------------
		    // URL format is
		    // jdbc:derby:<local directory to save data>
		    // -------------------------------------------
			String s = System.getProperty("user.dir");
		    String dbUrl = "jdbc:derby:"+s+"\\src\\main\\sql\\base;create=true";
		    conn = DriverManager.getConnection(dbUrl);
		  }
		public int insert(String fecha, int cliente, String empleado,int experiencia, String comentario){
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement("SELECT * FROM empleado WHERE nombre = ?");
				stmt.setString(1, empleado);
				ResultSet rs = stmt.executeQuery();
				int em = rs.getInt("id");
				stmt = conn.prepareStatement("insert into experiencia(fecha , cliente, empleado, experiencia, comentario) values (?,?,?,?,?)");
				stmt.setString(1, fecha);
				stmt.setInt(2, cliente);
				stmt.setInt(3, em);
				stmt.setInt(4,experiencia);
				stmt.setString(5, comentario);
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//Devuelve un tres si existe un error en la alguna sentecia SQL a causa de un parámetro mal pasado
				return 3;
			}
			return 0;
				
			}

}
