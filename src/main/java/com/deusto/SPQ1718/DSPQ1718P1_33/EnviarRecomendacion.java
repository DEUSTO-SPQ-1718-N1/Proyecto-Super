package com.deusto.SPQ1718.DSPQ1718P1_33;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class EnviarRecomendacion {
	//se envian recomendaciones de productos a los clientes
	private String aviso;
	private String recomendacion;
	private String arrayProductos[];
	public EnviarRecomendacion(){
		 
	}
	 
	public void lanzarVentana(String aviso, String recomendacion){
		 String titulo = "Recomendaciones";
		 JFrame ventanaM = new JFrame(titulo);
		 JTextArea jtextarea1 = new JTextArea();
		 JTextArea jtextarea2 = new JTextArea();
		 
		  
	     ventanaM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//finaliza el programa cuando se da click en la X
	     ventanaM.setVisible(true);//configurando visualización de la ventana        
	     
	     ventanaM.setSize(800,500); 
	     ventanaM.setLocationRelativeTo(null);
	     ventanaM.setResizable(false);

	     
	     ventanaM.setLayout(new GridLayout(2,1));
	     ventanaM.add(jtextarea1);
	     ventanaM.add(jtextarea2);
	     
	     jtextarea1.setText(aviso);
	     jtextarea2.setText(recomendacion);
	     
	     jtextarea1.setFont(new Font("Serif", Font.BOLD, 20));
	     jtextarea2.setFont(new Font("Serif", Font.BOLD, 15));
	     
	}
	
	public String avisoRecomendacion(){
		String aviso = ("Tenemos una serie de recomendaciones especiales SOLO PARA TI!");
		System.out.println("Tenemos una serie de recomendaciones especiales SOLO PARA TI!");
		return aviso;
	}
		
	public String productoRecomendado(){
		arrayProductos = new String[4];
		arrayProductos[0]= "leche";
		arrayProductos[1]= "dodot";
		arrayProductos[2]= "cerveza";
		arrayProductos[3]= "papel higienico";
		
		String recomendacion = ("Creemos que los siguientes productos te pueden interesar: " );
		String productos = "";
		for (int i = 0; i<4; i++){
			System.out.println( arrayProductos[i]);
			String producto = arrayProductos[i];
			productos = productos+" "+producto;
		}
		System.out.println("Creemos que los siguientes productos te pueden interesar: " );

		String recProductos = recomendacion + productos;
		return recProductos;
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
	 
	
	public static void main(String []args){
	  
	 EnviarRecomendacion  re = new EnviarRecomendacion();
	 String aviso= re.avisoRecomendacion();
	 String recomendacion = re.productoRecomendado();
	 
	 re.lanzarVentana(aviso, recomendacion); 
	 
	}
	   
}
