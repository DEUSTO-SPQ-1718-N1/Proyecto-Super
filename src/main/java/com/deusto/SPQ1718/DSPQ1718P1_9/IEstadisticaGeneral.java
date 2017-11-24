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

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

//Clase
public class IEstadisticaGeneral extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static IEstadisticaGeneral frame;
	
	public IEstadisticaGeneral(int res, String resP, Float resP2) throws SQLException {
		setTitle("Estadisticas generales");
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
		lblCdigoDelProducto.setBounds(43, 202, 135, 50);
		contentPane.add(lblCdigoDelProducto);
		
		JLabel label = new JLabel(resP);
		label.setBounds(208, 202, 135, 50);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Precio del Producto");
		label_1.setBounds(43, 263, 135, 50);
		contentPane.add(label_1);
		String resP2b = ""+resP2;
		JLabel label_2 = new JLabel(resP2b);
		label_2.setBounds(208, 263, 135, 50);
		contentPane.add(label_2);
		
		JLabel lblProductoMasVendido = new JLabel("Producto mas vendido");
		lblProductoMasVendido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProductoMasVendido.setBounds(43, 95, 300, 38);
		contentPane.add(lblProductoMasVendido);
		
		JLabel lblCodigoDelProducto = new JLabel("Codigo del Producto");
		lblCodigoDelProducto.setBounds(43, 144, 135, 50);
		contentPane.add(lblCodigoDelProducto);
		String resb = ""+res;	
		JLabel label_3 = new JLabel(resb);
		label_3.setBounds(208, 141, 135, 50);
		contentPane.add(label_3);
		
		JLabel lblEmpleadoConMas_1 = new JLabel("Empleado con mas ventas");
		lblEmpleadoConMas_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpleadoConMas_1.setBounds(448, 95, 300, 38);
		contentPane.add(lblEmpleadoConMas_1);
		
		JLabel lblNombreDelEmpleado = new JLabel("Nombre del Empleado");
		lblNombreDelEmpleado.setBounds(448, 202, 135, 50);
		contentPane.add(lblNombreDelEmpleado);
		
		AccesoBD_9 cod1 = new AccesoBD_9();
		String result;
		ResultSet ResProd = cod1.getEmpleadoMasVentas();
		
		//Float ResProd2 = codProd2.getPrecioP(result);
			
		
		JLabel label_5 = new JLabel("null");
		label_5.setBounds(593, 144, 135, 50);
		contentPane.add(label_5);
		
		JLabel lblUsuarioDelEmpleado = new JLabel("Usuario del Empleado");
		lblUsuarioDelEmpleado.setBounds(448, 144, 135, 50);
		contentPane.add(lblUsuarioDelEmpleado);
		
		JLabel label_6 = new JLabel("null");
		label_6.setBounds(593, 202, 135, 50);
		contentPane.add(label_6);
	}
}