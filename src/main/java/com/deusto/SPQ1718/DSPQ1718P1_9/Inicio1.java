package com.deusto.SPQ1718.DSPQ1718P1_9;

import java.sql.SQLException;

public class Inicio1 {

	public Inicio1() {
	}

	public static void main(String[] args) throws SQLException {
		//AccesoBD_9 Prueba0 = new AccesoBD_9();
		//String ResProd = Prueba0.getNombreP(1);	
		//System.out.println(ResProd);

		IEstadisticas frest1 = new IEstadisticas();
		frest1.setVisible(true);		
	}
}