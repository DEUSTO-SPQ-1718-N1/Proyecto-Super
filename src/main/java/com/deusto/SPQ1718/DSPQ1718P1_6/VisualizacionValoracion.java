package com.deusto.SPQ1718.DSPQ1718P1_6;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import com.deusto.SPQ1718.DSPQ1718P1_43.UserMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizacionValoracion extends JFrame{
	public db basedatos;
	private JTable table;
	public int numeroFilas=0;
	public static VisualizacionValoracion visu;
	public static void main(String[] args) throws SQLException{
		visu= new VisualizacionValoracion();
		visu.setVisible(true);
	}
	public VisualizacionValoracion() throws SQLException {
		
		basedatos= new db();
		this.setTitle("Visualizacion comentarios");
		this.setSize(600, 437);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 398);
		getContentPane().add(panel);
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setBounds(10, 33, 564, 288);
		panel.add(table);
		 //Creamos un modelo de tabla nuevo
		DefaultTableModel datos = new DefaultTableModel();
		datos.addColumn("Comentario");
		numeroFilas=basedatos.numeroFilas();
		String comentarios[] = basedatos.loadComentarios();
		datos.addRow(comentarios);
		table.setModel(datos);
		table.add(scrollPane);
		
		JButton btnNewButton = new JButton("V O L V E R");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserMenu frame = new UserMenu();
				frame.setVisible(true);	
				dispose();
			}
		});
		btnNewButton.setBounds(209, 344, 131, 43);
		panel.add(btnNewButton);
		
		
	}
}
