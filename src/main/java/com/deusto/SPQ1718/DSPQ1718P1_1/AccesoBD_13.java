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
	/*
	 * Método para registrar la compra de un producto con código p, en una fecha f, hecha por el empleado em
	 * al cliente em
	 */
	public int comprarProducto(int p, int em, int c, String f){
		PreparedStatement stmt;
		try {
			//Se disminuye el almacen del producto p en uno 
			int a = disminuirAlmacen(p, 1);
			//Si hay errores en el método de almacen se devuelve el error
			if(a == 1){ return 1;}
			else if(a== 2){ return 2;}
			//Si todo es correcto se continua con el registro de la compra
			stmt = conn.prepareStatement("insert into compra(fecha , cliente, empleado, producto) values (?,?,?,?)");
			stmt.setString(1, f);
			stmt.setInt(2, c);
			stmt.setInt(3, em);
			stmt.setInt(4, p);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Devuelve un tres si existe un error en la alguna sentecia SQL a causa de un parámetro mal pasado
			return 3;
		}
		return 0;
	}
	/*
	 * Inserta un poducto a la base de datos con nombre n, precio p y con una cantidad
	 * en almacen de c, el statement se hace de tipo prepeared, con el objetivo de evitar
	 * inyección SQL en la inserción de Strings
	 */
	public int insertarProducto(String n, float p, int ca){
		PreparedStatement stmt;
		try {
			
			stmt = conn.prepareStatement("insert into producto(nombre , precio, cantidad) values (?,?,?)");
			stmt.setString(1, n);
			stmt.setFloat(2, p);
			stmt.setInt(2, ca);
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
