package com.deusto.SPQ1718.DSPQ1718P1_7;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;

public class Interfaz_34 extends JFrame{
	private JTable table;
	public Interfaz_34() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Estado de Compras de Productos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(66, 11, 330, 23);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(172, 227, 89, 23);
		btnNewButton.setBackground(new Color(240, 240, 240));
		panel.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(371, 200, -313, -146);
		panel.add(table);
	}
}
