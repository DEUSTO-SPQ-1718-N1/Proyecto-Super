package com.deusto.SPQ1718.DSPQ1718P1_7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.BeforeClass;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Clase de prueba de los métodos de la clase AccesoDB_Test
 * @author ALUMNO
 *
 */
public class AccesoDB_35Test {
	
	static AccesoBD_35 b;
	/**
	 * @brief Primero se hace una conexión única a la BD para todas la pruebas
	 */
	@BeforeClass
	public static void con(){
		Connection conn;
		String env= "base";
		String value = System.getenv(env);
		String dbUrl = "jdbc:derby:"+value+"\\sql2\\base;create=true";
		try {
			conn = DriverManager.getConnection(dbUrl);
			b = new AccesoBD_35 (conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @brief Con este método se hace la prueba del caso exitoso en una compra y de la generación correcta de la tabla nombre-cantidad 
	 * @see com.deusto.SPQ1718.DSPQ1718P1_7.AccesoBD_35.getCompras()
	 * @see	com.deusto.SPQ1718.DSPQ1718P1_7.AccesoBD_35.comprarProducto(int,int,int,String,int)
	 */
	@Test
	public void TestCompra(){
		ArrayList<ArrayList<String>> tabla;
		/**
		 * Lo que se hace es obtener el número de compras que ha tenido un producto
		 * hacer una compra de ese producto
		 * volver a sacar el número de compras de un producto
		 * confirmar que ese ha aumentado en uno
		 * finalmente confirmar que comprarProducto(int,int,int,String,int) devuelve un 0 que confirma que todo ha ido bien
		 */
		tabla = b.getCompras();
		int num = Integer.valueOf(tabla.get(1).get(0));
		int res = b.comprarProducto(1, 1, 1, "2017-10-10", 1);
		tabla = b.getCompras();
		int num2 = Integer.valueOf(tabla.get(1).get(0));
		int result = num2 - num;
		b.b.aumentarAlmacen(1, 1);
		System.out.println(result);
		assertTrue(result==1);
		assertEquals(res,0);
		
	}
	/**
	 * @brief En esta prueba se fuerza el fallo de localización de producto y se confirma que en efecto este ocurre
	 */
	@Test
	public void TestCompraFalloProducto(){
		int res = b.comprarProducto(555, 1, 1, "2017-10-10", 1);
		assertEquals(res,1);
		
	}
	/**
	 * @brief En esta prueba se fuerza un fallo de cantidad yse confirma que en efecto este salte
	 */
	@Test
	public void TestCompraCantidad(){
		int res = b.comprarProducto(1, 1, 1, "2017-10-10", 555);
		assertEquals(res,2);
		
	}
	/**
	 * @brief En esta prueba se confirma que en efecto se esta obteniendo correctamemte el precio de un producto buscado
	 */
	@Test
	public void TestCompraPrecio(){
		float uno = b.precioProducto(1);
		float dos = b.b.getPrecioP(1);
		assertTrue(uno==dos);
	}
	
	

}
