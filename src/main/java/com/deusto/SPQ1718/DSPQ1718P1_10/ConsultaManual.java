package com.deusto.SPQ1718.DSPQ1718P1_10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import com.deusto.SPQ1718.Proyecto_Super.App;

public class ConsultaManual extends JFrame implements ActionListener{
	
	public ConsultaManual() {
		
		construyePanelInferior();
        construyeVentana();  
	}
	
	//Inicializamos los componentes y parametros
	//private JLabel ;
	private JPanel panelInferior;
	private JButton botonV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaManual frame = new ConsultaManual();
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
	
}
