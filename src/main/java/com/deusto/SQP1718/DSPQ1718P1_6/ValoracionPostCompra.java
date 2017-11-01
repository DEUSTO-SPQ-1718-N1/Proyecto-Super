package com.deusto.SQP1718.DSPQ1718P1_6;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.deusto.SPQ1718.Proyecto_Super.App;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ValoracionPostCompra extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public static void main(String[] args) {
	
	}
	public ValoracionPostCompra(){
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFechaDeLa = new JLabel("Fecha de la compra");
		lblFechaDeLa.setBounds(30, 11, 93, 26);
		panel.add(lblFechaDeLa);
		
		JLabel lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setBounds(176, 17, 46, 14);
		panel.add(lblEmpleado);
		
		JLabel lblPuntuacion = new JLabel("Puntuacion");
		lblPuntuacion.setBounds(273, 11, 58, 26);
		panel.add(lblPuntuacion);
		
		textField = new JTextField();
		textField.setBounds(40, 48, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 48, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(273, 48, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblComentarioACerca = new JLabel("Comentario a cerca de la experiencia de compra");
		lblComentarioACerca.setBounds(30, 90, 237, 26);
		panel.add(lblComentarioACerca);
		
		textField_3 = new JTextField();
		textField_3.setBounds(30, 127, 323, 76);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton aceptarJButton = new JButton("Aceptar");
		aceptarJButton.setBounds(94, 228, 89, 23);
		panel.add(aceptarJButton);
		
		JButton cancelarJButton = new JButton("Cancelar");
		cancelarJButton.setBounds(224, 228, 89, 23);
		panel.add(cancelarJButton);
		
	}
}
