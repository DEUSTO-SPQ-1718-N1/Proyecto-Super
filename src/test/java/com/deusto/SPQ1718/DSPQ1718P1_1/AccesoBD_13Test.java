package com.deusto.SPQ1718.DSPQ1718P1_1;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccesoBD_13Test {
	static AccesoBD_13 b;
	@BeforeClass
	public static void con(){
		try {
			b = new AccesoBD_13 ();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	     
	@Test
	public void test1() {
		
		int c = b.getCantidadP(1);
		b.aumentarAlmacen(1, 1);
		b.disminuirAlmacen(1, 1);
		int c2 = b.getCantidadP(1);
		
		assertTrue(c==c2);
		
	}
	
	@Test
	public void test2(){
		float p = b.getPrecioP(1);
		float p1 = Float.parseFloat("2.5");
		b.actualizarPrecio(1, p1);
		float p2 = b.getPrecioP(1);
		b.actualizarPrecio(1, p);
		
		assertTrue(p1==p2);
	}
	
	@Test
	public void test3(){
		int p = b.getPuntosP(1);
		b.actualizarPuntos(1, 10);
		int p1 = b.getPuntosP(1);
		b.actualizarPuntos(1, p);
		assertTrue(p1==10);
	}
	
	@Test
	public void test4(){
		String s = b.getNombreP(1);
		String s2= "azucar";
		assertTrue(s.equals(s2));
	}

}
