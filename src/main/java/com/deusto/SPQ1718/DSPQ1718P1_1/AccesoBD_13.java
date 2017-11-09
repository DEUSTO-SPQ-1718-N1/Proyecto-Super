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
	
	/*public static void main(String[] args) throws SQLException {
		AccesoBD_13 a = new AccesoBD_13();
		a.aumentarAlmacen(1,5);
	}*/
	public AccesoBD_13() throws SQLException{
		String env= "base";
		String value = System.getenv(env);
		String dbUrl = "jdbc:derby:"+value+"\\sql\\base;create=true";
	    conn = DriverManager.getConnection(dbUrl);
	}
	
	public int getPuntosP(int p){
		 int c = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT puntos FROM producto  WHERE id = "+p);
			while (rs.next()){
				 c = rs.getInt("puntos");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	
	public int getCantidadP(int p){
		 int c = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT cantidad FROM producto  WHERE id = "+p);
			while (rs.next()){
				 c = rs.getInt("cantidad");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public Float getPrecioP(int p){
		 float pr = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT precio FROM producto  WHERE id = "+p);
			while (rs.next()){
				 pr = rs.getFloat("precio");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pr;
	}
	
	public String getNombreP(int p){
		 String n="";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT nombre FROM producto WHERE id = "+p);
			while (rs.next()){
				 n = rs.getString("nombre");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	/*
	 * Donde p es igual a la clave del producto a actualizar y c la cantidad que se va 
	 * disminuir del almacen sobre ese producto
	 */
	public int aumentarAlmacen(int p, int c){
		 Statement stmt;
		 int nuevac = 0;
		 try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT cantidad FROM producto WHERE id = "+p);
			/*El código de retorno 1 indica que no se ha encontrado el porducto con id p*/
			if(rs.next()==false){ return 1;}
			nuevac = rs.getInt("cantidad");
			 System.out.println(nuevac);
			 nuevac = nuevac + c;
			 System.out.println(nuevac);
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
		 int nuevac = 0;
		try {
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT cantidad FROM producto WHERE id = "+p);
			/*El código de retorno 1 indica que no se ha encontrado el porducto con id p*/
			if(rs.next()==false){ return 1;}
			/*El código de retorno 2 indica que de actualizarse la cantidad en almacen sería negativa, por tanto la operación no se puede hacer*/
			nuevac = rs.getInt("cantidad") - c;
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
	public int insertarProducto(String n, float p, int ca, int pu){
		PreparedStatement stmt;
		try {
			
			stmt = conn.prepareStatement("insert into producto(nombre , precio, cantidad, puntos) values (?,?,?,?)");
			stmt.setString(1, n);
			stmt.setFloat(2, p);
			stmt.setInt(3, ca);
			stmt.setInt(4, pu);
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
