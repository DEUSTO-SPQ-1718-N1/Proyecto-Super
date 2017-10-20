package com.deusto.SPQ1718.DSPQ1718P1_32;

<<<<<<< HEAD
public class EnviarOferta {
	
	public void Aviso(){
		//envia notificacion de que hay una nueva oferta
		//se carga la ofera
		
		System.out.println("Hay una oferta disponible!");
	}
	
	public void Oferta(){
		
		String producto ="";
		int precio = 0;
		
		System.out.println ("El producto" + producto + " está de oferta! Consiguelo por SOLO" + precio + " euros!!");
	}

=======
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class EnviarOferta {
//Se muestra una oferta para el cliente
	private String aviso;
	private String oferta;
	public EnviarOferta(){
		 
	}
	/*public static void main(String []args){
		  
		 EnviarOferta  of = new EnviarOferta();
		 String aviso= of.aviso();
		 String oferta = of.oferta();
		 
		 of.lanzarVentana(aviso, oferta); 
		 
		}
*/
	public void lanzarVentana(String aviso, String oferta){
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
	     jtextarea2.setText(oferta);
	     
	     jtextarea1.setFont(new Font("Serif", Font.BOLD, 20));
	     jtextarea2.setFont(new Font("Serif", Font.BOLD, 15));
	     
	}

	public String aviso(){
		
		System.out.println("Hay una oferta disponible!");
		String aviso=("Hay una oferta disponible!");
		
		return aviso;
	}
	
	public String oferta(){
		String product="leche";
		int precio = 10;
	
		
		String oferta = ("El producto " + product + " esta de OFERTA. Tiene un descuento de " + precio +" %");
		System.out.println("El producto " + product + " esta de OFERTA. Tiene un descuento de " + precio +" %");
	return oferta;
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
>>>>>>> DSPQ1718P1-32
}