package com.deusto.SPQ1718.DSPQ1718P1_7;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class InterfazCompra extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	AccesoBD_35 b;
	InterfazCompra i;
	CompraTarjeta t;
	OperacionTarjeta o;
	private JTextField textField_4;
	private JTextField textField_5;
	public static void main(String[] args){
		InterfazCompra i = new InterfazCompra();
		i.setVisible(true);
	}
	public InterfazCompra() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			b = new AccesoBD_35();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnComprar = new JButton("COMPRAR EF");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fecha =textField.getText();
				int producto = Integer.valueOf(textField_2.getText());
				int empleado = Integer.valueOf(textField_3.getText());
				int cantidad = Integer.valueOf(textField_1.getText());
				int cliente = Integer.valueOf(textField_4.getText());
			
				b.comprarProducto(producto, empleado, cliente, fecha, cantidad);
				
			}
		});
		btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnComprar.setBounds(40, 215, 130, 35);
		panel.add(btnComprar);
		
		JLabel lblCompraDeProducto = new JLabel("Compra de Producto");
		lblCompraDeProducto.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCompraDeProducto.setBounds(86, 11, 254, 35);
		panel.add(lblCompraDeProducto);
		
		textField = new JTextField();
		textField.setBounds(32, 83, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(302, 140, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(302, 83, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(32, 140, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnComprarTar = new JButton("COMPRAR TAR");
		btnComprarTar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o = new OperacionTarjeta();
				t = new CompraTarjeta(o);
				
				int clave = Integer.valueOf(textField_5.getText());
				int cliente = Integer.valueOf(textField_4.getText());
				int producto = Integer.valueOf(textField_2.getText());
				int cantidad = Integer.valueOf(textField_1.getText());
				int importe = cantidad * Math.round(b.precioProducto(producto));
				
				int comp = t.realizarCompra(cliente, importe, clave, 1);
				boolean confirma = t.confirmarCompra(comp);
				String estado = t.verEstado(comp);
				System.out.println(estado);
				
				if(confirma == true){
					
					String fecha =textField.getText();
					int empleado = Integer.valueOf(textField_3.getText());
				
					b.comprarProducto(producto, empleado, cliente, fecha, cantidad);
					
				}
				
				
			}
		});
		btnComprarTar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnComprarTar.setBounds(232, 201, 142, 35);
		panel.add(btnComprarTar);
		
		JLabel lblFechaDdmmaaaa = new JLabel("Fecha dd-mm-aaaa");
		lblFechaDdmmaaaa.setBounds(35, 58, 122, 14);
		panel.add(lblFechaDdmmaaaa);
		
		JLabel lblNewLabel = new JLabel("Código producto");
		lblNewLabel.setBounds(32, 115, 111, 14);
		panel.add(lblNewLabel);
		
		JLabel lblCdigoEmpleado = new JLabel("Código empleado");
		lblCdigoEmpleado.setBounds(305, 58, 83, 14);
		panel.add(lblCdigoEmpleado);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(302, 115, 86, 14);
		panel.add(lblCantidad);
		
		textField_4 = new JTextField();
		textField_4.setBounds(170, 140, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Código Cliente");
		lblNewLabel_1.setBounds(170, 115, 86, 14);
		panel.add(lblNewLabel_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(264, 262, 86, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(294, 247, 46, 14);
		panel.add(lblClave);
	}
}
