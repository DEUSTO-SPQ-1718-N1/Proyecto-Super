package com.deusto.SPQ1718.DSPQ1718P1_7;
/**
 * Intefaz creada de acuerdo a la estructuráque tendrá la API del servicio externo de pago con tarjeta
 * @author ALUMNO
 *
 */
public interface ITarjeta {
	
	int conectarProv(int cod);
	int mandarDatos(int num, int clave, int pag);
	String respuesta(int c);
	boolean exitoPago(int c);
	

}
