package com.deusto.SQP1718.DSPQ1718P1_6;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.deusto.SPQ1718.Proyecto_Super.App;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class ValoracionPostCompra extends JFrame{
	private JTextField fechaTextField;
	private JTextField empleadoTextField;
	private JTextField experienciaTextField;
	private JTextField comentarioTextField;
	public String fecha;
	public String empleado;
	public int cliente;
	public int experiencia;
	public String comentario;
	public db basedatos;
	
	
	public static void main(String[] args) {
	
	}
	public ValoracionPostCompra(int id){
		this.cliente=id;
		try {
			basedatos= new db();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFechaDeLa = new JLabel("Fecha de la compra yyyy-mm-dd");
		lblFechaDeLa.setBounds(10, 11, 161, 26);
		panel.add(lblFechaDeLa);
		
		JLabel lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setBounds(201, 17, 46, 14);
		panel.add(lblEmpleado);
		
		JLabel lblPuntuacion = new JLabel("Puntuacion");
		lblPuntuacion.setBounds(307, 11, 58, 26);
		panel.add(lblPuntuacion);
		
		fechaTextField = new JTextField();
		fechaTextField.setBounds(40, 48, 86, 20);
		panel.add(fechaTextField);
		fechaTextField.setColumns(10);
		
		empleadoTextField = new JTextField();
		empleadoTextField.setBounds(186, 48, 86, 20);
		panel.add(empleadoTextField);
		empleadoTextField.setColumns(10);
		
		experienciaTextField = new JTextField();
		experienciaTextField.setBounds(310, 48, 86, 20);
		panel.add(experienciaTextField);
		experienciaTextField.setColumns(10);
		
		JLabel lblComentarioACerca = new JLabel("Comentario a cerca de la experiencia de compra");
		lblComentarioACerca.setBounds(30, 90, 237, 26);
		panel.add(lblComentarioACerca);
		
		comentarioTextField = new JTextField();
		comentarioTextField.setBounds(30, 127, 323, 76);
		panel.add(comentarioTextField);
		comentarioTextField.setColumns(10);
		
		JButton aceptarJButton = new JButton("Aceptar");
		aceptarJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fecha=fechaTextField.getText();
				empleado=empleadoTextField.getText();
				experiencia=Integer.parseInt(experienciaTextField.getText());
				comentario=comentarioTextField.getText();
				basedatos.insert(fecha, cliente, empleado,experiencia, comentario);
			
				
				
			}
		});
		aceptarJButton.setBounds(94, 228, 89, 23);
		panel.add(aceptarJButton);
		
		JButton cancelarJButton = new JButton("Cancelar");
		cancelarJButton.setBounds(224, 228, 89, 23);
		panel.add(cancelarJButton);
		
	}
}
