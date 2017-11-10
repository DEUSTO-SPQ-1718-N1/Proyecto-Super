package com.deusto.SPQ1718.DSPQ1718P1_1;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class Interfaz_Obs extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	String n;
	Float p;
	int c;
	int pun;
	int cl;
	AccesoBD_13 b;
	/*public static void main(String[] args) {
		Interfaz_Obs pru = new Interfaz_Obs(1);
		pru.setVisible(true);
	}*/
	public Interfaz_Obs(int clave) {
		cl = clave;
		this.setSize(600, 400);
		//this.setLocationRelativeTo(null);
		//getContentPane().setLayout(null);
		
		try {
			b = new AccesoBD_13();
			n = b.getNombreP(cl);
			c = b.getCantidadP(cl);
			p = b.getPrecioP(cl);
			pun = b.getPuntosP(cl);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 40, 105, 28);
		panel.add(lblNewLabel);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidad.setBounds(10, 88, 105, 28);
		panel.add(lblCantidad);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(10, 138, 105, 28);
		panel.add(lblPrecio);
		
		textField = new JTextField();
		textField.setBounds(10, 165, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		String s1 = Float.toString(p);
		textField.setText(s1);
		
		JLabel lblPuntos = new JLabel("Puntos");
		lblPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPuntos.setBounds(10, 189, 105, 28);
		panel.add(lblPuntos);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 228, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		String s = Integer.toString(pun);
		textField_1.setText(s);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cant = Integer.valueOf(textField_2.getText());
				b.aumentarAlmacen(cl, cant);
				Interfaz_14 i = new Interfaz_14();
				i.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(257, 95, 58, 37);
		panel.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(325, 107, 46, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cant = Integer.valueOf(textField_2.getText());
				b.disminuirAlmacen(cl, cant);
				Interfaz_14 i = new Interfaz_14();
				i.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(381, 95, 58, 37);
		panel.add(button);
		
		JLabel lblAlmacen = new JLabel("Almacen");
		lblAlmacen.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlmacen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlmacen.setBounds(298, 62, 105, 28);
		panel.add(lblAlmacen);
		
		JButton btnNewButton_1 = new JButton("Actualizar Precio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float precio = Float.valueOf(textField.getText());
				b.actualizarPrecio(cl, precio);
				Interfaz_14 i = new Interfaz_14();
				i.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(197, 177, 153, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Actualizar Puntos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int puntos = Integer.valueOf(textField_1.getText());
				b.actualizarPuntos(cl, puntos);
				Interfaz_14 i = new Interfaz_14();
				i.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(197, 240, 153, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Volver");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//b.comprarProducto(p, em, clave, f);
				Interfaz_14 i = new Interfaz_14();
				i.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(401, 207, 130, 23);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("Gestión producto");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setBounds(173, 11, 198, 28);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel(n);
		lblNewLabel_1.setBounds(20, 74, 76, 14);
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel(c+" productos");
		label.setBounds(20, 123, 76, 14);
		panel.add(label);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
}
