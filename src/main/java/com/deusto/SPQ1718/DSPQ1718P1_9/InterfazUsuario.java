package com.deusto.SPQ1718.DSPQ1718P1_9;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.deusto.SPQ1718.DSPQ1718P1_1.Interfaz_14;
import com.deusto.SPQ1718.Proyecto_Super.Inicio;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Clase
public class InterfazUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static InterfazUsuario frame;

	public InterfazUsuario() {
		setTitle("Menu del Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 800, 500);
		setSize(800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(new Color (135,206,250));
		setLocationRelativeTo(null);
	    setResizable(false);

		
		JButton button_6 = new JButton("Registrar productos");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interfaz_14 m = new Interfaz_14();
				m.setVisible(true);
				dispose();
			}
		});
		button_6.setBounds(47, 245, 153, 50);
		contentPane.add(button_6);
		
		JButton button_5 = new JButton("Manual de usuario");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Inicio.frame2.setVisible(false);
			}
		});
		button_5.setBounds(295, 245, 186, 50);
		contentPane.add(button_5);
				
		JButton button_1 = new JButton("Historial de actividad resumido");
		button_1.setText("<html><p>Historial de</p><p>actividad resumido</p></html>");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfazUsuario frame3 = new InterfazUsuario();
				frame3.setVisible(true);
				
				//new InterfazUsuario();
				Inicio.frame2.setVisible(false);	
			}				
		});
		button_1.setBounds(575, 245, 153, 50);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Informes");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Inicio.frame2.setVisible(false);
			}
		});
		button_2.setBounds(47, 367, 153, 50);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Estadísticas y tendencias");
		button_3.setText("<html><p>Estadísticas y</p><p>tendencias</p></html>");
		button_3.setBounds(575, 367, 153, 50);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Presentación de resultados actualizados");
		button_4.setBounds(295, 367, 186, 50);
		button_4.setText("<html><p>Presentación de</p><p>resultados actualizados</p></html>");
		contentPane.add(button_4);
		
		JLabel lblpic = new JLabel("");
		lblpic.setBounds(200, 0, 371, 175);
		String image= "Img";
		String val = System.getenv(image);
		String url = val+"\\logo.png";
		lblpic.setIcon(new ImageIcon(url));
		contentPane.add(lblpic);
	}
}