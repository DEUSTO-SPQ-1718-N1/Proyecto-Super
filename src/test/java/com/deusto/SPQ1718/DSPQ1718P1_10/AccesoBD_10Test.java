package com.deusto.SPQ1718.DSPQ1718P1_10;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;
/** 
*@brief En esta clase test se van a probar los metodos de la clase AccesoBD_10
*/
public class AccesoBD_10Test {

	static AccesoBD_10 b;
	@BeforeClass
	public static void con(){
		try {
			b = new AccesoBD_10();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** 
	*@brief En esta clase se va a probar que el titulo se actualiza
	*@var int m id del manual
	*@var String t titulo del manual m una vez actualizado
	*@var String modif String introducido como titulo
	* Se actualiza el titulo de m introduciendo un String
	* 
	*/
	@Test
	public void testTit() {
		
		int m = 1;
		b.actualizarTitulo(m, "Tit comprobando actualizacion");
		String t = b.getTitulo(m);
		String modif = "Tit comprobando actualizacion";
		assertEquals(t,modif);	
		
	}
	
	/** 
	*@brief En esta clase se va a probar que el texto se actualiza
	*@var int m id del manual
	*@var String t texto del manual m una vez actualizado
	*@var String modif String introducido como texto
	* Se actualiza el texto de m introduciendo un String
	* 
	*/
	@Test
	public void testText() {
		
		int m = 1;
		b.actualizarTexto(m, "Text comprobando actualizacion");
		String t = b.getTexto(m);
		String modif = "Text comprobando actualizacion";
		assertEquals(t,modif);	
		
	}
	
	/** 
	*@brief En esta clase se va a probar que el titulo no es vacio
	*@var int m id del manual
	*@var String tit titulo del manual m
	*/
	@Test
	public void testTit2() {
		
		int m = 1;
		String tit = b.getTitulo(m);
        assertNotNull(tit);
	}
	
	/** 
	*@brief En esta clase se comprueba si el texto es vacio
	*@var int m id del manual
	*@var String text texto del manual m
	*En este caso da failure porque no es vacio
	*/
	@Test
	public void testText2() {
		
		int m = 1;
		String text = b.getTexto(m);
        assertNull(text);
	}
	
}
