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
import java.awt.Font;

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
	public dbTest basedatos;
	public static ValoracionPostCompra clase;
	
	
	
	public ValoracionPostCompra(int id){
		this.cliente=id;
		basedatos= new dbTest();
		this.setTitle("Valoracion post compra");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 574, 351);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFechaDeLa = new JLabel("Fecha de la compra yyyy-mm-dd");
		lblFechaDeLa.setBounds(10, 11, 182, 26);
		panel.add(lblFechaDeLa);
		
		JLabel lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setBounds(245, 14, 74, 20);
		panel.add(lblEmpleado);
		
		JLabel lblPuntuacion = new JLabel("Puntuacion");
		lblPuntuacion.setBounds(412, 11, 89, 26);
		panel.add(lblPuntuacion);
		
		fechaTextField = new JTextField();
		fechaTextField.setBounds(40, 48, 86, 20);
		panel.add(fechaTextField);
		fechaTextField.setColumns(10);
		
		empleadoTextField = new JTextField();
		empleadoTextField.setBounds(245, 42, 86, 20);
		panel.add(empleadoTextField);
		empleadoTextField.setColumns(10);
		
		experienciaTextField = new JTextField();
		experienciaTextField.setBounds(415, 48, 86, 20);
		panel.add(experienciaTextField);
		experienciaTextField.setColumns(10);
		
		JLabel lblComentarioACerca = new JLabel("Comentario a cerca de la experiencia de compra");
		lblComentarioACerca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblComentarioACerca.setBounds(40, 109, 327, 39);
		panel.add(lblComentarioACerca);
		
		comentarioTextField = new JTextField();
		comentarioTextField.setBounds(40, 170, 461, 93);
		panel.add(comentarioTextField);
		comentarioTextField.setColumns(10);
		//En caso de presonar Aceptar, todos los datos introducidos seran guardados en la bd
		JButton aceptarJButton = new JButton("Aceptar");
		aceptarJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Se recogen todos los campos del Jframe
				fecha=fechaTextField.getText();
				empleado=empleadoTextField.getText();
				experiencia=Integer.parseInt(experienciaTextField.getText());
				comentario=comentarioTextField.getText();
				//Se llama al metodo insertar de la bd y le pasamos los campos para que los guarde 
				basedatos.insert(fecha, cliente, empleado,experiencia, comentario);
			
						
			}
		});
		aceptarJButton.setBounds(183, 297, 89, 23);
		panel.add(aceptarJButton);
		//en caso de presionar el boton cancelar, pondremos todos los jtextfields a null
		JButton cancelarJButton = new JButton("Cancelar");
		cancelarJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fechaTextField.setText(null);
				empleadoTextField.setText(null);
				experienciaTextField.setText(null);
				comentarioTextField.setText(null);
			}
		});
		cancelarJButton.setBounds(378, 297, 89, 23);
		panel.add(cancelarJButton);
		
	}
}
