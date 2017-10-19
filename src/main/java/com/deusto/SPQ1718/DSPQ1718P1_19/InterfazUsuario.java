package com.deusto.SPQ1718.DSPQ1718P1_19;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class InterfazUsuario extends JFrame{
	public static void main( String[] args )
    {
        InterfazUsuario interfaz= new InterfazUsuario();
        interfaz.setVisible(true);
    }
	private JPanel panel;
	private JTable table;
	public InterfazUsuario() {
		this.setTitle("Interfaz usuario");
		this.setSize(700, 500);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 664, 440);
		getContentPane().add(panel);
		
		String[] nombreColumnas = {"Fecha de compra", "Puntuación de la experiencia de compra"};
		Object[][] data= { {"17-09-2017",new Integer(2)}, {"12-10-2017",new Integer(7)}};
		table= new JTable(data, nombreColumnas);
		JScrollPane scrollpane = new JScrollPane(table);
		//getContentPane().add(scrollpane, BorderLayout.CENTER);
		panel.add(scrollpane);
		
		
	}
}
