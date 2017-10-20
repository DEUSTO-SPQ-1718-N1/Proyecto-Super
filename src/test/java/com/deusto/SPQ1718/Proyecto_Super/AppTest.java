package com.deusto.SPQ1718.Proyecto_Super;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

import org.junit.*;
public class AppTest{
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(AppTest.class);
	}
	
	@Test
	public void testMetodo(){
		int numero = 2;
		int suma = 1+1;
		assertTrue(numero==suma);
	}
	@Test
	public void testMetodo2(){
		int numero = 4;
		int suma = 1+3;
		assertTrue(numero==suma);
	}
}

