package com.deusto.SPQ1718.DSPQ1718P1_10;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.deusto.SPQ1718.Proyecto_Super.App;

public class EdicionManual extends JFrame {
	
	private JButton botonV;
	private JTextField lblTit1, lblTit2, lblTit3, lblTit4, lblTit5;
	private JTextPane lblText1, lblText2, lblText3, lblText4, lblText5;
	private JPanel contentPane;
	private String tit1, tit2, tit3, tit4, tit5;
	private String text1, text2, text3, text4, text5;
	AccesoBD_10 conn;
	
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
	//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblManules = new JLabel("MANUALES");
		lblManules.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblManules.setForeground(Color.BLUE);
		lblManules.setBounds(311, 24, 171, 25);
		contentPane.add(lblManules);
		
		tit1 = conn.getTitulo(1);
		lblTit1 = new JTextField();
		lblTit1.setText(tit1);
		lblTit1.setBounds(12, 94, 262, 27);
		contentPane.add(lblTit1);
		conn.actualizarTitulo(1,tit1);
				
		text1 = conn.getTexto(1);
		lblText1 = new JTextPane();
		lblText1.setText(text1);
		lblText1.setBounds(255, 94, 438, 78);
		contentPane.add(lblText1);
		conn.actualizarTexto(1,text1);
				
		tit2 = conn.getTitulo(2);
		lblTit2 = new JTextField();
		lblTit2.setText(tit2);
		lblTit2.setBounds(12, 169, 262, 27);
		contentPane.add(lblTit2);
		conn.actualizarTitulo(2,tit2);
		
		text2 = conn.getTexto(2);
		lblText2 = new JTextPane();
		lblText2.setText(text2);
		lblText2.setBounds(255, 169, 438, 51);
		contentPane.add(lblText2);
		conn.actualizarTexto(2,text2);
		
		tit3 = conn.getTitulo(3);
		lblTit3 = new JTextField();
		lblTit3.setText(tit3);
		lblTit3.setBounds(12, 224, 262, 27);
		contentPane.add(lblTit3);
		conn.actualizarTitulo(3,tit3);
		
		text3 = conn.getTexto(3);
		lblText3 = new JTextPane();
		lblText3.setText(text3);
		lblText3.setBounds(255, 222, 438, 63);
		contentPane.add(lblText3);
		conn.actualizarTexto(3,text3);
		
		tit4 = conn.getTitulo(4);
		lblTit4 = new JTextField();
		lblTit4.setText(tit4);
		lblTit4.setBounds(12, 294, 262, 27);
		contentPane.add(lblTit4);
		conn.actualizarTitulo(4,tit4);
		
		text4 = conn.getTexto(4);
		lblText4 = new JTextPane();
		lblText4.setText(text4);
		lblText4.setBounds(255, 283, 438, 63);
		contentPane.add(lblText4);
		conn.actualizarTexto(4,text4);
		
		tit5 = conn.getTitulo(5);
		lblTit5 = new JTextField();
		lblTit5.setText("tit5");
		lblTit5.setBounds(12, 359, 262, 27);
		contentPane.add(lblTit5);
		conn.actualizarTitulo(5,tit5);
		
		text5 = conn.getTexto(5);
		lblText5 = new JTextPane();
		lblText5.setText(text5);
		lblText5.setBounds(255, 344, 438, 59);
		contentPane.add(lblText5);
		conn.actualizarTexto(5,text5);
		
		botonV = new JButton(" V O L V E R ");        
		botonV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {					
				App frame = new App();
				frame.setVisible(true);
				setVisible(false);
			}
		});		     
		botonV.setBounds(332, 427, 135, 25);
		contentPane.add(botonV);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(35, 130, 67, 26);
		contentPane.add(btnEdit);
		
		JButton button = new JButton("Edit");
		button.setBounds(35, 194, 67, 26);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Edit");
		button_1.setBounds(35, 259, 67, 26);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Edit");
		button_2.setBounds(35, 320, 67, 26);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Edit");
		button_3.setBounds(35, 389, 67, 26);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Edit");
		button_4.setBounds(705, 130, 67, 26);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("Edit");
		button_5.setBounds(705, 194, 67, 26);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("Edit");
		button_6.setBounds(705, 259, 67, 26);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("Edit");
		button_7.setBounds(705, 320, 67, 26);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("Edit");
		button_8.setBounds(705, 377, 67, 26);
		contentPane.add(button_8);
		
	}
	
	public EdicionManual() {
		
		construyeVentana();  
		
	}
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EdicionManual frame1 = new EdicionManual();
					frame1.setVisible(true);
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
