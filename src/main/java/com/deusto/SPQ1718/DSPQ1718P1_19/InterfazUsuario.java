package com.deusto.SPQ1718.DSPQ1718P1_19;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.ArrayList;




public class InterfazUsuario extends JFrame{
	
	public static void main( String[] args )
    {
        InterfazUsuario interfaz= new InterfazUsuario();
        interfaz.setVisible(true);
    }
	private JPanel panel;
	private JTable table;
	double media=0.0;
	public InterfazUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ALUMNO\\Desktop\\nabavka.jpg"));
		this.setTitle("Interfaz usuario");
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.BLUE);
		panel.setBounds(10, 11, 664, 440);
		getContentPane().add(panel);
		
		String[] nombreColumnas = {"Fecha de compra", "Puntuación de la experiencia de compra"};
		Object[][] data= { {"17-09-2017",new Integer(2)}, {"12-10-2017",new Integer(7)}, {"23-10-2017",new Integer(3)}, {"19-03-2016",new Integer(10)},
				{"02-05-2017",new Integer(5)}, {"29-11-2016",new Integer(6)}, {"18-04-2017",new Integer(9)}, {"05-06-2017",new Integer(7)},
				{"02-02-2015",new Integer(2)}, {"13-09-2017",new Integer(4)}, {"31-12-2014",new Integer(7)}, {"06-08-2017",new Integer(10)},
				{"23-11-2017",new Integer(3)}, {"12-12-2017",new Integer(6)}, {"14-02-2017",new Integer(8)}, {"23-05-2016",new Integer(9)},
				{"30-10-2014",new Integer(7)}, {"16-07-2017",new Integer(5)}, {"27-09-2014",new Integer(3)}, {"16-10-2015",new Integer(7)},
				{"19-08-2017",new Integer(8)},{"24-04-2017",new Integer(4)}, {"26-08-2017",new Integer(6)},{"11-11-2017",new Integer(8)},
				{"22-11-2017",new Integer(4)}, {"30-12-2014",new Integer(1)}};
		table= new JTable(data, nombreColumnas);
		table.setForeground(Color.BLACK);
		JScrollPane scrollpane = new JScrollPane(table);
		panel.add(scrollpane);
		
		double sumatoria1=0.0;
        int totalRow= table.getRowCount();
        totalRow-=1;
        for(int i=0;i<=(totalRow);i++)
        {
             double sumatoria= Double.parseDouble(String.valueOf(table.getValueAt(i,1)));
             sumatoria1+=sumatoria;
             System.out.println(""+sumatoria1);
               
		}
        DecimalFormat df = new DecimalFormat("#.00");
        media= sumatoria1/ table.getRowCount();
        System.out.println(df.format(media));
        
		
		
		
	}
}
