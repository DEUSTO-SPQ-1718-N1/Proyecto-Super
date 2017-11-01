package com.deusto.SPQ1718.DSPQ1718P1_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBD_13 {
	
	Connection conn;
	/*
	 * Método de conexión con la base de datos a la dirección especificada
	 */
	public AccesoBD_13() throws SQLException{
		String env= "base";
		String value = System.getenv(env);
		String dbUrl = "jdbc:derby:"+value+"\\sql\\base;create=true";
	    conn = DriverManager.getConnection(dbUrl);
	}
	/*
	 * Donde p es igual a la clave del producto a actualizar y c la cantidad que se va 
	 * disminuir del almacen sobre ese producto
	 */
	public int aumentarAlmacen(int p, int c){
		 Statement stmt;
		 try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT cantidad FROM producto WHERE id = "+p);
			/*El código de retorno 1 indica que no se ha encontrado el porducto con id p*/
			if(rs.next()==false){ return 1;}
			int nuevac = rs.getInt("cantidad") + c;
			stmt.executeUpdate("update producto set cantidad ="+nuevac+" WHERE id ="+p);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Devuelve un tres si existe un error en la alguna sentecia SQL a causa de un parámetro mal pasado
			return 3;
		}
		return 0;
	}
	/*
	 * Misma nomenclatura que el método anterior pero en este caso se disminuye la
	 * cantidad del almacen en c del producto p
	 */
	public int disminuirAlmacen(int p, int c){
		 Statement stmt;
		try {
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT cantidad FROM producto WHERE id = "+p);
			/*El código de retorno 1 indica que no se ha encontrado el porducto con id p*/
			if(rs.next()==false){ return 1;}
			/*El código de retorno 2 indica que de actualizarse la cantidad en almacen sería negativa, por tanto la operación no se puede hacer*/
			int nuevac = rs.getInt("cantidad") - c;
			if(nuevac<0){return 2;}
			stmt.executeUpdate("update producto set cantidad ="+nuevac+" WHERE id ="+p);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				//Devuelve un tres si existe un error en la alguna sentecia SQL a causa de un parámetro mal pasado
				return 3;
			}
		return 0;
	}
	/*
	 * Este método se utilza para actualizar el precio que tiene un producto con id p
	 * a un nuevo precio c
	 */
	public int actualizarPrecio(int p, float c){
		 Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT precio FROM producto WHERE id = "+p);
			/*El código de retorno 1 indica que no se ha encontrado el porducto con id p*/
			if(rs.next()==false){ return 1;}
			stmt.executeUpdate("update producto set precio ="+c+" WHERE id ="+p);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Devuelve un tres si existe un error en la alguna sentecia SQL a causa de un parámetro mal pasado	
			return 3;
		}
		return 0;
	}
	/*
	 * Este método se utiliza para actualizar la cantidad de puntos que concede el 
	 * producto con id p a una nueva cantidad c
	 */
	public int actualizarPuntos(int p, int c){
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT puntos FROM producto WHERE id = "+p);
			/*El código de retorno 1 indica que no se ha encontrado el porducto con id p*/
			if(rs.next()==false){ return 1;}
			stmt.executeUpdate("update producto set puntos ="+c+" WHERE id ="+p);
		} 
		catch (SQLException e) {
			e.printStackTrace();
			//Devuelve un tres si existe un error en la alguna sentecia SQL a causa de un parámetro mal pasado
			return 3;
		}
		return 0;
	}
	
	public int comprarProducto(int c){
		Statement stmt;
		try {
			stmt = conn.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Devuelve un tres si existe un error en la alguna sentecia SQL a causa de un parámetro mal pasado
			return 3;
		}
		return 0;
	}
	
	public int insertarProducto(String n, float p){
		PreparedStatement stmt;
		try {
			
			stmt = conn.prepareStatement("insert into producto(nombre , precio) values (?,?)");
			stmt.setString(1, n);
			stmt.setFloat(2, p);
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
