package com.deusto.SPQ1718.DSPQ1718P1_10;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.deusto.SPQ1718.Proyecto_Super.App;
import com.deusto.SPQ1718.DSPQ1718P1_10.AccesoBD_10;
import com.deusto.SPQ1718.DSPQ1718P1_27.Login2;

public class ConsultaManual extends JFrame implements ActionListener{
	
	private JButton botonV;
	private JLabel lblTit1, lblTit2, lblTit3, lblTit4, lblTit5;
	private JTextPane lblText1, lblText2, lblText3, lblText4, lblText5;
	private JPanel contentPane;
	private String tit1, tit2, tit3, tit4, tit5;
	private String text1, text2, text3, text4, text5;
	AccesoBD_10 con;
	/**
	 * Create the frame.
	 */
	
	public void construyeVentana(){   
			
		setTitle("Consulta de Manual");                  
	    setSize(800,500); 
	    setLocationRelativeTo(null);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    setVisible(true);
	
	    contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblManules = new JLabel("MANUALES");
		lblManules.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblManules.setForeground(Color.BLUE);
		lblManules.setBounds(311, 24, 205, 25);
		contentPane.add(lblManules);
        
		tit1 = con.getTitulo(1);
		lblTit1 = new JLabel();
		lblTit1.setText(tit1);
		lblTit1.setBounds(51, 94, 262, 27);
		contentPane.add(lblTit1);
				
		text1 = con.getTexto(1);
		lblText1 = new JTextPane();
		lblText1.setText(text1);
		lblText1.setBounds(311, 94, 438, 78);
		contentPane.add(lblText1);
				
		tit2 = con.getTitulo(2);
		lblTit2 = new JLabel();
		lblTit2.setText(tit2);
		lblTit2.setBounds(51, 169, 262, 27);
		contentPane.add(lblTit2);
		
		text2 = con.getTexto(2);
		lblText2 = new JTextPane();
		lblText2.setText(text2);
		lblText2.setBounds(311, 169, 438, 51);
		contentPane.add(lblText2);
		
		tit3 = con.getTitulo(3);
		lblTit3 = new JLabel();
		lblTit3.setText(tit3);
		lblTit3.setBounds(51, 224, 262, 27);
		contentPane.add(lblTit3);
		
		text3 = con.getTexto(3);
		lblText3 = new JTextPane();
		lblText3.setText(text3);
		lblText3.setBounds(311, 222, 438, 63);
		contentPane.add(lblText3);
		
		tit4 = con.getTitulo(4);
		lblTit4 = new JLabel();
		lblTit4.setText(tit4);
		lblTit4.setBounds(51, 283, 262, 27);
		contentPane.add(lblTit4);
		
		text4 = con.getTexto(4);
		lblText4 = new JTextPane();
		lblText4.setText(text4);
		lblText4.setBounds(311, 283, 438, 63);
		contentPane.add(lblText4);
		
		tit5 = con.getTitulo(5);
		lblTit5 = new JLabel();
		lblTit5.setText(tit5);
		lblTit5.setBounds(51, 349, 262, 27);
		contentPane.add(lblTit5);
		
		text5 = con.getTexto(5);
		lblText5 = new JTextPane();
		lblText5.setText(text5);
		lblText5.setBounds(311, 344, 438, 59);
		contentPane.add(lblText5);

		botonV = new JButton(" V O L V E R ");        
		botonV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {					
				App frame = new App();
				frame.setVisible(true);
				setVisible(false);
			}
		});		     
		botonV.setBounds(325, 427, 135, 25);
		contentPane.add(botonV);
		
		
	}
	
	public ConsultaManual(){
		
		try {
			con = new AccesoBD_10();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		construyeVentana();  
		
	}
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaManual frame = new ConsultaManual();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}		 
		});
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}
