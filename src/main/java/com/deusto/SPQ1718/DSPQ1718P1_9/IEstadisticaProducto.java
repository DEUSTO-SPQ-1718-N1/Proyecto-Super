package com.deusto.SPQ1718.DSPQ1718P1_9;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.deusto.SPQ1718.DSPQ1718P1_1.Interfaz_14;
import com.deusto.SPQ1718.Proyecto_Super.Inicio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

//Clase
public class IEstadisticaProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static IEstadisticaProducto frame;
	
	String nomP="null";
	Float priceP=null;

	public IEstadisticaProducto(String nombreP, Float precioP) {
		setTitle("Estadisticas del producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 800, 500);
		setSize(800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(new Color (135,206,250));
		setLocationRelativeTo(null);
	    setResizable(false);
		
		JButton button_2 = new JButton("Volver");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IEstadisticas ie = new IEstadisticas();
				ie.setVisible(true);
				dispose();
			}
		});
		button_2.setBounds(287, 377, 153, 50);
		contentPane.add(button_2);
		
		JLabel lblCdigoDelProducto = new JLabel("Nombre del Producto");
		lblCdigoDelProducto.setBounds(43, 98, 135, 50);
		contentPane.add(lblCdigoDelProducto);
		
		nomP = nombreP;
		JLabel label = new JLabel(nomP);
		label.setBounds(208, 98, 135, 50);
		contentPane.add(label);
		
		JLabel lblPrecioDelProducto = new JLabel("Precio del Producto");
		lblPrecioDelProducto.setBounds(43, 180, 135, 50);
		contentPane.add(lblPrecioDelProducto);
		
		priceP = precioP;
		String str = String.valueOf(priceP);
		JLabel label_2 = new JLabel(str);
		label_2.setBounds(208, 180, 135, 50);
		contentPane.add(label_2);
		
		JLabel lblNewLabel = new JLabel("IMG");
		lblNewLabel.setBounds(432, 63, 296, 234);
		contentPane.add(lblNewLabel);
		String image= "Img";
		String val = System.getenv(image);
		String url = val+"\\logo.png";
	}
}