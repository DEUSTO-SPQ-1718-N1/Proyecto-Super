package com.deusto.SPQ1718.DSPQ1718P1_32;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.deusto.SPQ1718.Proyecto_Super.App;

public class EnviarOferta {
//Se muestra una oferta para el cliente
	private String aviso;
	private String oferta;

	/*public static void main(String []args){
		  
		 EnviarOferta  of = new EnviarOferta();
		 String aviso= of.aviso();
		 String oferta = of.oferta();
		 
		 of.lanzarVentana(aviso, oferta); 
		 
		}
*/
	public void lanzarVentanaOfertas(String aviso, String oferta){
		 String titulo = "Ofertas";
		 final JFrame ventanaO = new JFrame(titulo);
		 JTextArea jtextarea1 = new JTextArea();
		 JTextArea jtextarea2 = new JTextArea();
		 
		  
	     ventanaO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//finaliza el programa cuando se da click en la X
	     ventanaO.setVisible(true);//configurando visualización de la ventana        
	     
	     ventanaO.setSize(800,500); 
	     ventanaO.setLocationRelativeTo(null);
	     ventanaO.setResizable(false);

	     ventanaO.setLayout(new GridLayout(3,1));
	     ventanaO.add(jtextarea1);
	     ventanaO.add(jtextarea2);
	     
	     jtextarea1.setText(aviso);
	     jtextarea2.setText(oferta);	     
	     jtextarea1.setFont(new Font("Serif", Font.BOLD, 20));
	     jtextarea2.setFont(new Font("Serif", Font.BOLD, 15));	  
	     
		JButton buttonV = new JButton("V O L V E R");
		buttonV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				App frame = new App();
				frame.setVisible(true);
				ventanaO.setVisible(false);
			}
		});
		buttonV.setBounds(480, 367, 165, 50);
		ventanaO.add(buttonV);
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
}