package com.deusto.SPQ1718.DSPQ1718P1_7;

public class OperacionTarjeta implements ITarjeta{

	public int conectarProv(int cod) {
		// TODO Auto-generated method stub
		if(cod == 1) return 0;
		else return 1;
	}

	public int mandarDatos(int num, int clave, int pag) {
		// TODO Auto-generated method stub
		if(num == 1  && clave ==1234){
			
			if(pag<1000){
				return 0;
			}
			else return 3;
		}
		else return 2;
		
	}

	public String respuesta(int c) {
		// TODO Auto-generated method stub
		if(c == 1)  return "Conexión fallida";
		else if(c == 2) return "Datos fallidos";
		else if(c == 3) return "Fondos insuficientes";
		else return "Operación realizada";
	}

	public boolean exitoPago(int c) {
		// TODO Auto-generated method stub
		if (c ==0) return true;
		else return false;
	}
	
	/*public boolean Conectar(ITarjeta t,int z){
		return t.conectarProv(z);
	}
	
	public void Pagar(ITarjeta t, int num, int clave){
		t.mandarDatos(num, clave);
	}
	
	public boolean Confirmacion(ITarjeta t){
		return t.exitoPago();
	}
	
	public String Mensaje(ITarjeta t){
		return t.respuesta();
	}*/

}
