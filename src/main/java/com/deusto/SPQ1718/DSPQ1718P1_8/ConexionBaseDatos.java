/** @package com.deusto.SPQ1718.DSPQ1718P1_8
*/

package com.deusto.SPQ1718.DSPQ1718P1_8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*! \ class ConexionBaseDatos "paquete/"
 *  \ Esta clase será la encargada de conectar con la base de datos para recibir información, así luego pasarsela 
 *  a la interfaz de usuario correspondiente y evitar que esta soporte información de negocio.
 *  
 */

public class ConexionBaseDatos {
	Connection conn; /**< Objeto de tipo connection para la creación de la llamada a la base de datos */
	/*
	public static void main(String[] args) throws SQLException {
		ArrayList<String> e;
		ConexionBaseDatos a = new ConexionBaseDatos();
		e= a.getComentarios(1);
		for (int i=0;i<e.size();i++){
			System.out.println(e.get(i));
		}
	}*/
	public ConexionBaseDatos() throws SQLException{
		String env= "base"; /**< El nombre de la variable del entorno que contiene la direccion de la base de datos */
		String value = System.getenv(env); /**< La busqueda asociada a esa variable de entorno */
		String dbUrl = "jdbc:derby:"+value+"\\sql\\base;create=true";
	    conn = DriverManager.getConnection(dbUrl);
	}
	/**
	 * @param int que representa el id que tiene el cliente del que se desea consultar las opiniones
	 * @return lista de comentarios que haya realizado el usuario con id id
	 */
	public ArrayList<String> getComentarios(int id){
		ArrayList<String> comentarios= new ArrayList<String>();
		try {
			Statement stmt = conn.createStatement();/**< Esta variable permite utilizar la conexión de BD creada en el constructor para crear un statement SQL */
			ResultSet rs = stmt.executeQuery("SELECT * FROM experiencia  WHERE cliente = "+id);
			while (rs.next()){
				 comentarios.add(rs.getString("comentario"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return comentarios;
	}
	/**
	 * @param int que representa el id que tiene el cliente del que se desea consultar las opiniones
	 * @return La división entre la suma de todas las puntuaciones redcogidas por un usuario y la cantidad de las mismas, calculando la media
	 * aritmética
	 */
    public int getMedia(int id){
    	ArrayList<Integer> puntos= new ArrayList<Integer>();
    	int suma=0;
    	int coef =0;
    	try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM experiencia  WHERE cliente = "+id);
			while (rs.next()){
				suma = suma + rs.getInt("experiencia");
				coef++;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}  	
    	return suma/coef;
    	    }
}
