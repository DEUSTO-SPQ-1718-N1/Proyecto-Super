package com.deusto.SQP1718.DSPQ1718P1_6;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.deusto.SPQ1718.Proyecto_Super.Base;

public class db {
		Connection conn;
		PreparedStatement stmt;
		public String comentario;
		public int numeroFilas=0;
		public String lista[]; 
			
		  public db() throws SQLException {
		    // -------------------------------------------
		    // URL format is
		    // jdbc:derby:<local directory to save data>
		    // -------------------------------------------
			String s = System.getProperty("user.dir");
		    String dbUrl = "jdbc:derby:"+s+"\\src\\main\\sql\\base;create=true";
		    conn = DriverManager.getConnection(dbUrl);
		  }
		  //Metodo para insertar una nueva fila en la tabla experiencia con sus respectivos campos
		public int insert(String fecha, int cliente, String empleado,int experiencia, String comentario){
			
			try {
				//Primero buscamos en la tabla empleado el id que corresponde al nombre que nos han pasado
				stmt = conn.prepareStatement("SELECT * FROM empleado WHERE nombre = ?");
				stmt.setString(1, empleado);
				ResultSet rs = stmt.executeQuery();
				int em = rs.getInt("id");
				//Cuando ya tenemos todos los datos listos los insertamos en la bd
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
		//hace un load de los comentarios para verificar que se guardan
		public String[] loadComentarios(){
			
			//inicializamos la lista vacia de arrays de Strings
			lista= new String[numeroFilas];
			 try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM experiencia");
				//mediante el iterador, recorremos la tabla experiencia y seleccioanmos el campo comentario
				int indice=0;
				while(rs.next()){
					comentario=rs.getString("comentario");
					lista[indice]=comentario;
					indice++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return lista;
		}
		//metodo para calcular cuantas filas hay en la tabla experiencia
		public int numeroFilas() throws SQLException{
			Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT * FROM experiencia");
			 while (rs.next()) {
			    	numeroFilas++;
			    }
			return numeroFilas;
		}

}
