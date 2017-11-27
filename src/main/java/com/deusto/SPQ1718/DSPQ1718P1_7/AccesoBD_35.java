package com.deusto.SPQ1718.DSPQ1718P1_7;

import java.awt.List;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.deusto.SPQ1718.DSPQ1718P1_1.AccesoBD_13;

public class AccesoBD_35 {
	Connection conn;
	AccesoBD_13 b;
	/*public static void main(String[] args) throws SQLException {
		AccesoBD_35 a = new AccesoBD_35();
		ArrayList<ArrayList<String>> tabla = a.getCompras();
		//System.out.println(tabla.size());
		//System.out.println(tabla.get(0).size());
		//System.out.println(tabla.get(1).size());
		for(int i=0; i<5; i++){
			System.out.print(tabla.get(0).get(i));
			System.out.println(tabla.get(1).get(i));
			
		}
		
	}*/
	public AccesoBD_35() throws SQLException{
		String env= "base";
		String value = System.getenv(env);
		String dbUrl = "jdbc:derby:"+value+"\\sql\\base;create=true";
	    conn = DriverManager.getConnection(dbUrl);
	    b = new AccesoBD_13(conn);
	}
	
	public int comprarProducto(int p, int em, int c, String f, int cant){
		PreparedStatement stmt;
		try {
			//Se disminuye el almacen del producto p en uno 
			int a = b.disminuirAlmacen(p, cant);
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
	
	public ArrayList<ArrayList<String>> getCompras(){
		
		ArrayList<String> nombres = new ArrayList<String>();
		ArrayList<Integer> cods = new ArrayList<Integer>();
		ArrayList<String> cantidad = new ArrayList<String>();
		ArrayList<ArrayList<String>> tabla = new ArrayList<ArrayList<String>>();
		
		try {
			Statement stmt = conn.createStatement();
		
			
			
			ResultSet rs2 = stmt.executeQuery("SELECT producto, COUNT(id) cont FROM compra GROUP BY producto");
			while (rs2.next()){
				cods.add(rs2.getInt("producto"));
				cantidad.add(String.valueOf(rs2.getInt("cont")));
				
			 }
			for(int i=0; i<cods.size(); i++){
				ResultSet rs = stmt.executeQuery("SELECT nombre FROM producto where id ="+cods.get(i));
				while (rs.next()){
					nombres.add(rs.getString("nombre"));
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tabla.add(nombres);
		tabla.add(cantidad);
		return tabla;
		
	}

}
