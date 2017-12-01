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

import org.apache.log4j.Logger;

import com.deusto.SPQ1718.DSPQ1718P1_1.AccesoBD_13;

/**
 * Clase que se usa para realizar toda la gestión de compras en la base de datos
 * @author ALUMNO
 *
 */
public class AccesoBD_35 {
	private final static Logger log = Logger.getLogger("com.deusto.SPQ1718.DSPQ1718P1.HU1");
	Connection conn;/**< atributo que permite la conexión a la BD */
	AccesoBD_13 b;/**< Uso de consultas de acceso necesarias que ya han sido creadas en sprints anteriores @see com.deusto.SPQ1718.DSPQ1718P1_1.AccesoBD_13 */
	/**
	 * @brief Constructor de la clase que hará las consultas necesarias para lainterfaz de compras
	 * @throws SQLException
	 */
	public AccesoBD_35() throws SQLException{
		int var; ///< Brief description after the member
		String env= "base";/**< nombre de la variable de entorno que dice donde esta la base de datos*/
		String value = System.getenv(env);/**< búsqueda de la variable */
		String dbUrl = "jdbc:derby:"+value+"\\sql\\base;create=true"; /**< ruta de la base de datos*/
	    conn = DriverManager.getConnection(dbUrl);/**< Establecimiento de conexión*/
	    b = new AccesoBD_13(conn);
	}
	/**
	 * @brief Método contructor para llmar esta clase en caso de que se necesite en otro sitio donde ya se ha instanciado el atributo de conexión a la BD
	 * 
	 * @param conn paso de la conexión a la BD 
	 * @throws SQLException
	 */
	public AccesoBD_35(Connection conn) throws SQLException{
		this.conn = conn;
	    b = new AccesoBD_13(this.conn);
	}
	/**
	 * @brief Método que realiza todas las acciones necesarias para registrar una compra en la apliación
	 * 
	 * @param p id del producto a comprar
	 * @param em id del empleado que registra la compra
	 * @param c id del cliente que ha comprado el artículo
	 * @param f fecha de compra
	 * @param cant cantidad comprada 
	 * @return devuelve un 0 si todo es correcto, 1 o 2 si hay error con el almacen y 3 si hay un error en la consulta SQL
	 */
	public int comprarProducto(int p, int em, int c, String f, int cant){
		
		PreparedStatement stmt;
		try {
			int a = b.disminuirAlmacen(p, cant);/**<se disminuye el almacen en la cantidad solicitada*/
			/**Si hay errores en el método de almacen se devuelve el error*/
			if(a == 1){ return 1;/**< 1 es que no se encontro el producto con clave p*/}
			else if(a== 2){ return 2;/**< 2 es que el alamacen quedaría negativo si se hace la compra*/}
			/**Si todo es correcto se continua con el registro de la compra*/
			stmt = conn.prepareStatement("insert into compra(fecha , cliente, empleado, producto) values (?,?,?,?)"); /**< Esta consulta registra la compra en la BD*/
			stmt.setString(1, f);
			stmt.setInt(2, c);
			stmt.setInt(3, em);
			stmt.setInt(4, p);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error SQL en método comprarProducto");
			//Devuelve un tres si existe un error en la alguna sentecia SQL a causa de un parámetro mal pasado
			return 3;
		}
		return 0;
	}
	/**
	 * @brief Método que devuelve una tabla con el nombre del producto y la cantidad que se ha vendido de este
	 * @return ArrayList<ArrayList<String>> que contiene los datos de la tabla
	 */
	public ArrayList<ArrayList<String>> getCompras(){
		
		ArrayList<String> nombres = new ArrayList<String>();/**< En esta lista se guardarán los nombres de los productos*/
		ArrayList<Integer> cods = new ArrayList<Integer>();/**< Esta lista se usa dentro del método para l abúsqueda de los nombres de los productos*/
		ArrayList<String> cantidad = new ArrayList<String>();/**< Esta lista guardará las cantidades vendidas de cada producto*/
		ArrayList<ArrayList<String>> tabla = new ArrayList<ArrayList<String>>();/**< Esta es la tabla o lista de lista que recoge la relación nombres-cantidades vendidas de productos */
		
		try {
			Statement stmt = conn.createStatement();
		
			
			
			ResultSet rs2 = stmt.executeQuery("SELECT producto, COUNT(id) cont FROM compra GROUP BY producto");/**< Consulta que sirve para obtener los id de productos con su número de ventas*/
			while (rs2.next()){
				/**
				 * Se alimentan las listas de códigos y cantidades
				 * */
				cods.add(rs2.getInt("producto"));
				cantidad.add(String.valueOf(rs2.getInt("cont")));
				
			 }
			for(int i=0; i<cods.size(); i++){
				ResultSet rs = stmt.executeQuery("SELECT nombre FROM producto where id ="+cods.get(i));/**< Usando la lista de códigos de busca el nombre del producto y se alimenta la lista de nombres*/
				while (rs.next()){
					nombres.add(rs.getString("nombre"));
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error SQL en getCompras");
		}
		/**
		 * Se monta la tabla con las listas alimentadas
		 */
		tabla.add(nombres);
		tabla.add(cantidad);
		return tabla;
		
	}
	/**
	 * @brief Método que permite obtener desde esta clase el precio de un prodcuto segun su id utilizando un método creado previamente para esto en la clase AccesoBD_13
	 * @param p id del producto del cual se quiere buscar el precio
	 * @return Float que representa el precio del producto
	 */
	public Float precioProducto(int p){
		return b.getPrecioP(p);
	}

}
