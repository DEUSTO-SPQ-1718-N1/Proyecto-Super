package com.deusto.SPQ1718.DSPQ1718P1_9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

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
import java.awt.Font;

//Clase
public class IEstadisticaProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static IEstadisticaProducto frame;
	
	String nomP="null";
	Float priceP=null;

	public IEstadisticaProducto(int idP, String nombreP, Float precioP) {
		setTitle("Estadisticas del producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 800, 500);
		setSize(800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(Color.white);
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
		
		JLabel lblCdigoDelProducto = new JLabel("Nombre del Producto:");
		lblCdigoDelProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCdigoDelProducto.setBounds(43, 138, 135, 50);
		contentPane.add(lblCdigoDelProducto);
		
		nomP = nombreP;
		JLabel label = new JLabel(nomP);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(229, 138, 135, 50);
		contentPane.add(label);
		
		JLabel lblPrecioDelProducto = new JLabel("Precio del Producto:");
		lblPrecioDelProducto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecioDelProducto.setBounds(43, 215, 135, 50);
		contentPane.add(lblPrecioDelProducto);
		
		priceP = precioP;
		String str = String.valueOf(priceP);
		JLabel label_2 = new JLabel(str);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(229, 215, 135, 50);
		contentPane.add(label_2);
			
		int idMod4 = idP % 4;
		System.out.println("mod4: " + idMod4);
		
		JLabel lblpic = new JLabel("");
		lblpic.setBounds(423, 76, 295, 230);
		String image1 = "Img";
		String val = System.getenv(image1);
		String url;
		
		switch (idMod4) {
	        case 1: //url = val + "\\r1.png";
	        		url = "src/main/java/com/deusto/SPQ1718/DSPQ1718P1_9/r1.png";	
	                break;
	        case 2: //url = val + "\\r2.png";
	        		url = "src/main/java/com/deusto/SPQ1718/DSPQ1718P1_9/r2.png";	
	        		break;
	        case 3: //url = val + "\\r3.png";
	        		url = "src/main/java/com/deusto/SPQ1718/DSPQ1718P1_9/r3.png";	
	        		break;
	        case 0: //url = val + "\\r4.png";
	        		url = "src/main/java/com/deusto/SPQ1718/DSPQ1718P1_9/r4.png";	
	        		break;
	        default:url = "Error de grafico";
	                break;
	    }
		
			
		lblpic.setIcon(new ImageIcon(url));
		contentPane.add(lblpic);
	}
}