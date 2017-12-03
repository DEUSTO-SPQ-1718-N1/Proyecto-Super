package com.deusto.SPQ1718.DSPQ1718P1_7;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

import com.deusto.SPQ1718.DSPQ1718P1_43.AdminMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_34 extends JFrame{
	
	private JTable table;
	AccesoBD_35 b;
	ArrayList<ArrayList<String>> tabla;
	public static void main(String[] args){
		Interfaz_34 i = new Interfaz_34();
		i.setVisible(true);
	}
	public Interfaz_34() {
		setSize(600, 400);
		setLocationRelativeTo(null);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			b = new AccesoBD_35();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Estado de Compras de Productos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(66, 11, 330, 23);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminMenu a = new AdminMenu();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(172, 227, 89, 23);
		btnNewButton.setBackground(new Color(240, 240, 240));
		panel.add(btnNewButton);
		String col[] = {"Producto", "Compras"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 45, 291, 163);
		panel.add(scrollPane);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tabla = b.getCompras();
		for(int i=0; i<tabla.get(0).size(); i++){
			String objs[] = new String[2]; 
			objs[0]= tabla.get(0).get(i);
			System.out.println(tabla.get(0).get(i));
			objs[1]= tabla.get(1).get(i);
			System.out.println(tabla.get(1).get(i));
			tableModel.addRow(objs);
		}
		
		
	}
}
