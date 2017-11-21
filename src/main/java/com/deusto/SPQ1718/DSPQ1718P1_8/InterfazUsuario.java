package com.deusto.SPQ1718.DSPQ1718P1_8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.deusto.SPQ1718.DSPQ1718P1_43.UserMenu;
import com.deusto.SPQ1718.DSPQ1718P1_6.VisualizacionValoracion;
import com.deusto.SPQ1718.DSPQ1718P1_6.db;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class InterfazUsuario extends JFrame{
	public ConexionBaseDatos basedatos;
	private static InterfazUsuario inter;
	private JTable table;
	private ArrayList<String> comentarios;
	private JTextField textField;
	/*
	public static void main(String[] args) throws SQLException{
		inter= new InterfazUsuario();
		inter.setVisible(true);
	
	}*/
	public  InterfazUsuario() throws SQLException{
		basedatos= new ConexionBaseDatos();
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
		int id=1;
		DefaultTableModel datos = new DefaultTableModel();
		datos.addColumn("Comentario");	
		comentarios = basedatos.getComentarios(id);
		Object [] row = new Object[comentarios.size()];
		for(int i=0;i< comentarios.size();i++)
		{
			row[i]=comentarios.get(i);
			//System.out.println(comentarios.get(i));
		}
		datos.addRow(row);
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
		
		JLabel lblPuntuacionMedia = new JLabel("Puntuacion Media");
		lblPuntuacionMedia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPuntuacionMedia.setBounds(350, 355, 112, 17);
		panel.add(lblPuntuacionMedia);
		
		textField = new JTextField();
		textField.setBounds(472, 355, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		textField.setText(Integer.toString(basedatos.getMedia(1)));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
