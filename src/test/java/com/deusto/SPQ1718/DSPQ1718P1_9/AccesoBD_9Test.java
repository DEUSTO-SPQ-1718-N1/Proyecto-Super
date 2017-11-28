package com.deusto.SPQ1718.DSPQ1718P1_9;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.BeforeClass;
import org.junit.Test;
import com.deusto.SPQ1718.DSPQ1718P1_9.AccesoBD_9;

public class AccesoBD_9Test {

	static AccesoBD_9 b;
	
	@BeforeClass
	public static void con(){
		try {
			b = new AccesoBD_9 ();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1(){
		float precioEsperado = (float) 2.5;
		float precio = b.getPrecioP(1);
		
		assertEquals(0, precioEsperado, precio);
	}
	
	@Test
	public void test2(){
		String nombreEsperado = "Jose";
		String nombre = b.getNombreE(1);
		
		String apellidoEsperado = "Dominguez";
		String apellido = b.getApellidoE(1);
		
		String Esperado = nombreEsperado + " " + apellidoEsperado;
		String Actual = nombre + " " + apellido;
		
		assertTrue(Esperado.equals(Actual));	
	}
	
	@Test
	public void test3() throws SQLException{
		int s = b.getProductoMasVendido();
		int s2= 2;
		assertTrue(s==s2);
	}
	
	@Test
	public void test4() throws SQLException{
		int s = b.getEmpleadoMasVentas();
		int s2= 1;
		assertTrue(s==s2);
	}
}