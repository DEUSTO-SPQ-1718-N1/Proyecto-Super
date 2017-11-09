package com.deusto.SQP1718.DSPQ1718P1_6;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VisualizacionValoracion extends JFrame{
	public db basedatos;
	private JTable table;
	public int numeroFilas=0;
	public static VisualizacionValoracion visu;
	public static void main(String[] args) throws SQLException{
		visu= new VisualizacionValoracion();
		visu.setVisible(true);
	}
	public VisualizacionValoracion() throws SQLException{
		
		try {
			basedatos= new db();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setTitle("Visualizacion comentarios");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 351);
		getContentPane().add(panel);
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		
		
		table = new JTable();
		table.setBounds(10, 33, 564, 288);
		panel.add(table);
		 
		DefaultTableModel datos = new DefaultTableModel();
		datos.addColumn("Comentario");
		numeroFilas=basedatos.numeroFilas();
		System.out.println(numeroFilas);
		String comentarios[] = basedatos.loadComentarios();
		datos.addRow(comentarios);
		table.setModel(datos);
		table.add(scrollPane);
		
		
	}
}
