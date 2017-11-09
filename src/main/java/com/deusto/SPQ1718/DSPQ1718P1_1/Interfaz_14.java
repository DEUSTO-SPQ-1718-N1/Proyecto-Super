package com.deusto.SPQ1718.DSPQ1718P1_1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_14 extends JFrame {
	private JTextField textField;
	public Interfaz_14() {
		
		this.setSize(600, 400);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JLabel lblSeleccionaUnaOpcin = new JLabel("Selecciona una opción");
		lblSeleccionaUnaOpcin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblSeleccionaUnaOpcin);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		JButton btnNewButton_1 = new JButton("Observar un producto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c = textField.getText();
				int cl = Integer.parseInt(c);
				Interfaz_Obs o = new Interfaz_Obs(cl);
				o.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(51, 63, 161, 39);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Insertar un producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interfaz_Ins in = new Interfaz_Ins();
				in.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(262, 63, 161, 39);
		panel_1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(90, 113, 66, 20);
		panel_1.add(textField);
		textField.setColumns(10);
	}
	
	

}
