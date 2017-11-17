package com.deusto.SPQ1718.DSPQ1718P1_1;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.apache.log4j.Logger;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class Interfaz_Ins extends JFrame {
	private final static Logger log = Logger.getLogger("com.deusto.SPQ1718.DSPQ1718P1.HU1");
	private JTextField txtC;
	private JTextField txtPr;
	private JTextField txtN;
	private JTextField txtPu;
	AccesoBD_13 b;
	public Interfaz_Ins() {
		
		this.setSize(600, 400);
		//this.setLocationRelativeTo(null);
		//getContentPane().setLayout(null);
		
		try {
			b = new AccesoBD_13();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Nombre");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(51, 51, 105, 28);
		panel.add(label);
		
		JLabel label_2 = new JLabel("Cantidad");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(263, 51, 105, 28);
		panel.add(label_2);
		
		JLabel label_4 = new JLabel("Precio");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(51, 131, 105, 28);
		panel.add(label_4);
		
		txtC = new JTextField();
		txtC.setText("");
		txtC.setColumns(10);
		txtC.setBounds(273, 90, 86, 20);
		panel.add(txtC);
		
		JLabel label_5 = new JLabel("Puntos");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(263, 131, 105, 28);
		panel.add(label_5);
		
		txtPr = new JTextField();
		txtPr.setText("");
		txtPr.setColumns(10);
		txtPr.setBounds(61, 168, 86, 20);
		panel.add(txtPr);
		
		JLabel lblNuevoProducto = new JLabel("Nuevo producto");
		lblNuevoProducto.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNuevoProducto.setBounds(112, 11, 198, 28);
		panel.add(lblNuevoProducto);
		
		txtN = new JTextField();
		txtN.setText("");
		txtN.setColumns(10);
		txtN.setBounds(61, 90, 86, 20);
		panel.add(txtN);
		
		txtPu = new JTextField();
		txtPu.setText("");
		txtPu.setColumns(10);
		txtPu.setBounds(273, 168, 86, 20);
		panel.add(txtPu);
		
		JButton btnSubir = new JButton("Subir");
		btnSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String n = txtN.getText();
					Float p = Float.valueOf(txtPr.getText());
					int ca = Integer.valueOf(txtC.getText());
					int pun = Integer.valueOf(txtPu.getText());
					b.insertarProducto(n, p, ca, pun);
				}
				catch(Exception e1){
					log.error("Un campo del insert no ha sido correctamente puesto Interfaz_Ins");
				}
				
				Interfaz_14 i = new Interfaz_14();
				i.setVisible(true);
				dispose();
			}
		});
		btnSubir.setBounds(166, 200, 89, 23);
		panel.add(btnSubir);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interfaz_14 i = new Interfaz_14();
				i.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(166, 236, 89, 23);
		panel.add(btnVolver);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
