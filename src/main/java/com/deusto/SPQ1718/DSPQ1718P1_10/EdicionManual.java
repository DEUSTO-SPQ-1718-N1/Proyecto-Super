package com.deusto.SPQ1718.DSPQ1718P1_10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.deusto.SPQ1718.Proyecto_Super.App;

public class EdicionManual extends JFrame {
	
	//Inicializamos los componentes y parametros
	//private JLabel ;
	private JPanel panelInferior,panelCentral;
	private JButton botonV;
	private JLabel labelTitulo;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EdicionManual frame = new EdicionManual();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void construyeVentana(){   
	       getContentPane().setLayout(new BorderLayout());
	       setTitle("Consulta de Manual");                  
	       setSize(800,500); 
	       setLocationRelativeTo(null);
	       setResizable(false);
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	       setVisible(true);
	       
	       add(panelInferior,BorderLayout.SOUTH);
	       add(panelCentral,BorderLayout.CENTER);
	
	}
	
	public void construyePanelCentral(){
		panelCentral = new JPanel();
	        
        labelTitulo = new JLabel(" ", SwingConstants.CENTER);
	        
        panelCentral.setBackground(Color.white);
        panelCentral.add(labelTitulo);
	}

	public void construyePanelInferior(){
	    panelInferior = new JPanel();
	    botonV = new JButton("        V O L V E R        ");        
	    botonV.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {					
					App frame = new App();
					frame.setVisible(true);
					setVisible(false);
				}
			});
	     
	    panelInferior.setBackground(Color.blue);
	    panelInferior.add(botonV);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public EdicionManual() {
		
		construyePanelInferior();
        construyeVentana();  
	}
	
	

}
