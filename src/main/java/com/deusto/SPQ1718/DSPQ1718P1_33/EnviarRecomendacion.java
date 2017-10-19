package com.deusto.SPQ1718.DSPQ1718P1_33;

public class EnviarRecomendacion {
	//se envian recomendaciones de productos segun las compras
	private String aviso;
	private String recomendacion;
	private String arrayProductos[];

	
	public void avisoRecomendacion(){
			
		setAviso("Tenemos una serie de recomendaciones especiales SOLO PARA TI!");
		System.out.println("Tenemos una serie de recomendaciones especiales SOLO PARA TI!");
	}
		
	public void productoRecomendado(){
		arrayProductos = new String[10];
		setRecomendacion("Creemos que los siguientes productos te pueden interesar: " + arrayProductos);
		System.out.println("Creemos que los siguientes productos te pueden interesar: " + arrayProductos);
	}

	public String getAviso() {
		return aviso;
	}

	public void setAviso(String aviso) {
		this.aviso = aviso;
	}

	public String getRecomendacion() {
		return recomendacion;
	}

	public void setRecomendacion(String recomendacion) {
		this.recomendacion = recomendacion;
	}

}
