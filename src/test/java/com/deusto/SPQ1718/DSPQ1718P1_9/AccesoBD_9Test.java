package com.deusto.SPQ1718.DSPQ1718P1_9;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.BeforeClass;
import org.junit.Test;
import com.deusto.SPQ1718.DSPQ1718P1_9.AccesoBD_9;

public class AccesoBD_9Test {

	static AccesoBD_9 b;
	
	/**
	 * metodo necesario para conectar con la BD y hacer las pruebas.
	 */
	@BeforeClass
	public static void con(){
		try {
			b = new AccesoBD_9 ();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @brief Test 1: getPrecio()
	 *
	 * Comprobar si el metodo getPrecio() funciona correctamente
	 * 
	 * @var precioEsperado		ponemos el valor que tiene actualmente en la BD
	 * @var precio				devuelve el precio de la BD
	 */
	@Test
	public void test1(){
		float precioEsperado = (float) 2.5;
		float precio = b.getPrecioP(1);
		
		assertEquals(0, precioEsperado, precio);
	}
	
	/**
	 * @brief Test 2: getNombre() y getApellido()
	 *
	 * Comprobar si los metodos getNombre() y getApellido() funcionan correctamente
	 * 
	 * @var nombreEsperado		ponemos el valor que tiene actualmente en la BD
	 * @var nombre				devuelve el nombre de la BD
	 * @var apellidoEsperado	ponemos el valor que tiene actualmente en la BD
	 * @var apellido			devuelve el apellido de la BD
	 * @var Esperado			une el nombre y apellido que hemos puesto previamente
	 * @var Actual				une el nombre y apellido de la BD
	 */
	@Test
	public void test2(){
		String nombreEsperado = "Jose";
		String nombre = b.getNombreE(1);
		assertTrue(nombreEsperado.equals(nombre));
		
		String apellidoEsperado = "Dominguez";
		String apellido = b.getApellidoE(1);
		assertTrue(apellidoEsperado.equals(apellido));
		
		String Esperado = nombreEsperado + " " + apellidoEsperado;
		String Actual = nombre + " " + apellido;
		assertTrue(Esperado.equals(Actual));	
	}
	
	/**
	 * @brief Test 3: getProductoMasVendido()
	 *
	 * Comprobar si el metodo getProductoMasVendido() funciona correctamente
	 * 
	 * @var s				devuelve de la BD el id del producto mas vendido
	 * @var s2				ponemos el valor que tiene actualmente en la BD
	 */
	@Test
	public void test3() throws SQLException{
		int s = b.getProductoMasVendido();
		int s2= 1;
		assertTrue(s==s2);
	}
	
	/**
	 * @brief Test 4: getEmpleadoMasVentas()
	 *
	 * Comprobar si el metodo getEmpleadoMasVentas() funciona correctamente
	 * 
	 * @var s				devuelve de la BD el id del empleado con mas ventas
	 * @var s2				ponemos el valor que tiene actualmente en la BD
	 */
	@Test
	public void test4() throws SQLException{
		int s = b.getEmpleadoMasVentas();
		int s2= 1;
		assertTrue(s==s2);
	}
}