package com.deusto.SPQ1718.DSPQ1718P1_7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.deusto.SPQ1718.DSPQ1718P1_1.AccesoBD_13;

public class AccesoBD_35 {
	Connection conn;
	AccesoBD_13 b;
	public AccesoBD_35() throws SQLException{
		String env= "base";
		String value = System.getenv(env);
		String dbUrl = "jdbc:derby:"+value+"\\sql\\base;create=true";
	    conn = DriverManager.getConnection(dbUrl);
	    b = new AccesoBD_13(conn);
	}
	
	public int comprarProducto(int p, int em, int c, String f){
		PreparedStatement stmt;
		try {
			//Se disminuye el almacen del producto p en uno 
			int a = b.disminuirAlmacen(p, 1);
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

}
