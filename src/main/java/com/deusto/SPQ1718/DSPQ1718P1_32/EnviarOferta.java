package com.deusto.SPQ1718.DSPQ1718P1_32;


public class EnviarOferta {

	private String aviso;
	private String oferta;

	public void aviso(){
		
		System.out.println("Hay una oferta disponible!");
		setAviso("Hay una oferta disponible!");
	}
	
	public void oferta(){
		String product="";
		int precio =0;
		
		setOferta("El producto " + product + " esta de OFERTA. Consiguelos por SOLO " + precio +" euros");
		System.out.println("El producto " + product + " esta de OFERTA. Consiguelos por SOLO " + precio +" euros");
	}

	public String getAviso() {
		return aviso;
	}

	public void setAviso(String aviso) {
		this.aviso = aviso;
	}

	public String getOferta() {
		return oferta;
	}

	public void setOferta(String oferta) {
		this.oferta = oferta;
	}
}