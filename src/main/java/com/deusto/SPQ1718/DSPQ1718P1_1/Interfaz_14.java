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
			}
		});
		btnNewButton_1.setBounds(51, 63, 139, 39);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Insertar un producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c = textField.getText();
				int cl = Integer.parseInt(c);
				
			}
		});
		btnNewButton.setBounds(233, 63, 139, 39);
		panel_1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(90, 113, 66, 20);
		panel_1.add(textField);
		textField.setColumns(10);
	}
	
	

}
