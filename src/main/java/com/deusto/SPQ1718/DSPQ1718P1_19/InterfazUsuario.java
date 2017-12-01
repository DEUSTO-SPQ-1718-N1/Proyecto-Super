package com.deusto.SPQ1718.DSPQ1718P1_19;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Toolkit;
import java.text.DecimalFormat;

import javax.swing.JTextField;
import javax.swing.JLabel;

import com.deusto.SPQ1718.DSPQ1718P1_43.AdminMenu;
import com.deusto.SPQ1718.DSPQ1718P1_43.UserMenu;
import com.deusto.SPQ1718.Proyecto_Super.App;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazUsuario extends JFrame{
	//Pequeño main para visualizar esta sola clase antes de hacer el merge
/*	public static void main( String[] args )
    {
        InterfazUsuario interfaz= new InterfazUsuario();
        interfaz.setVisible(true);
    }
*/    
	private JPanel panel;
	//Tabla que muestre la fecha de la compra y la puntacion
	private JTable table;
	//La puntuacion media de las experiencias
	double media=0.0;
	private JTextField textField;
	private JLabel lblPuntuacionMedia;
	public InterfazUsuario() {
		//Icono de la cabecera de la pantalla
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ALUMNO\\Desktop\\nabavka.jpg"));
		this.setTitle("Interfaz usuario");
		this.setSize(800,500);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.BLUE);
		panel.setBounds(10, 11, 664, 440);
		getContentPane().add(panel);
		//Hacemos un array de string con los nombres de las columnas
		String[] nombreColumnas = {"Fecha de compra", "Puntuación de la experiencia de compra"};
		//Un array multidimensional con la fehca de la compra y las puntiaciones
		Object[][] data= { {"17-09-2017",new Integer(2)}, {"12-10-2017",new Integer(7)}, {"23-10-2017",new Integer(3)}, {"19-03-2016",new Integer(10)},
				{"02-05-2017",new Integer(5)}, {"29-11-2016",new Integer(6)}, {"18-04-2017",new Integer(9)}, {"05-06-2017",new Integer(7)},
				{"02-02-2015",new Integer(2)}, {"13-09-2017",new Integer(4)}, {"31-12-2014",new Integer(7)}, {"06-08-2017",new Integer(10)},
				{"23-11-2017",new Integer(3)}, {"12-12-2017",new Integer(6)}, {"14-02-2017",new Integer(8)}, {"23-05-2016",new Integer(9)},
				{"30-10-2014",new Integer(7)}, {"16-07-2017",new Integer(5)}, {"27-09-2014",new Integer(3)}, {"16-10-2015",new Integer(7)},
				{"19-08-2017",new Integer(8)},{"24-04-2017",new Integer(4)}, {"26-08-2017",new Integer(6)},{"11-11-2017",new Integer(8)},
				{"22-11-2017",new Integer(4)}, {"30-12-2014",new Integer(1)}};
		panel.setLayout(null);
		table= new JTable(data, nombreColumnas);
		table.setForeground(Color.BLACK);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(100, 5, 350, 427);
		//Añadimos la tabla al scroll pra que se visualize
		panel.add(scrollpane);
		
		JButton buttonV = new JButton("V O L V E R");
		buttonV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminMenu frame = new AdminMenu();
				frame.setVisible(true);
				dispose();
			}
		});
		buttonV.setBounds(480, 367, 165, 50);
		panel.add(buttonV);
		
		textField = new JTextField();
		textField.setBounds(522, 224, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		double sumatoria1=0.0;
        int totalRow= table.getRowCount();
        totalRow-=1;
        //REcorremos la segunda columna de la tabla y sumamos las puntuaciones
        for(int i=0;i<=(totalRow);i++)
        {
             double sumatoria= Double.parseDouble(String.valueOf(table.getValueAt(i,1)));
             sumatoria1+=sumatoria;
             System.out.println(""+sumatoria1);
               
		}
        //Formato de dos decimales
        DecimalFormat df = new DecimalFormat("#.00");
        //Calcula la media dividiendo el total de las puntaciones entre el total de numero filas
        media= sumatoria1/ table.getRowCount();
        String cadena="";
        textField.setText(cadena.valueOf(df.format(media)));
        
        lblPuntuacionMedia = new JLabel("Puntuacion media");
        lblPuntuacionMedia.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
        lblPuntuacionMedia.setForeground(Color.WHITE);
        lblPuntuacionMedia.setBounds(496, 180, 141, 20);
        panel.add(lblPuntuacionMedia);
	}
}
