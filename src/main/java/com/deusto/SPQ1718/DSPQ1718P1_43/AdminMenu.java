package com.deusto.SPQ1718.DSPQ1718P1_43;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.deusto.SPQ1718.DSPQ1718P1_1.Interfaz_14;
import com.deusto.SPQ1718.DSPQ1718P1_10.ConsultaManual;
import com.deusto.SPQ1718.DSPQ1718P1_10.EdicionManual;
import com.deusto.SPQ1718.DSPQ1718P1_19.InterfazUsuario;
import com.deusto.SPQ1718.DSPQ1718P1_33.EnviarRecomendacion;
import com.deusto.SPQ1718.DSPQ1718P1_9.IEstadisticas;
import com.deusto.SPQ1718.P1_39.Usuario;
import com.deusto.SPQ1718.Proyecto_Super.Inicio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Clase sobre el panel del menu del administrador o empleado
public class AdminMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static AdminMenu frame;

	public AdminMenu() {
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
		button_6.setBounds(47, 245, 292, 50);
		contentPane.add(button_6);
		
		JButton button_5 = new JButton("Manuales de usuario");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Inicio.frame2.setVisible(false);
				ConsultaManual frame = new ConsultaManual();
				frame.setVisible(true);
				dispose();
			}
		});
		button_5.setBounds(47, 367, 186, 50);
		contentPane.add(button_5);
				
		JButton button_1 = new JButton("Historial de actividad resumido");
		button_1.setText("Historial de actividad resumido");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfazUsuario frame = new InterfazUsuario();
				frame.setVisible(true);
				dispose();
			}				
		});
		button_1.setBounds(461, 245, 267, 50);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Editar Manuales");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EdicionManual frame1 = new EdicionManual();
				frame1.setVisible(true);
				dispose();
			}
		});
		button_2.setBounds(317, 367, 153, 50);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Estadísticas y tendencias");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IEstadisticas frest1 = new IEstadisticas();
				frest1.setVisible(true);
				dispose();
			}
		});
		button_3.setText("<html><p>Estadísticas y</p><p>tendencias</p></html>");
		button_3.setBounds(558, 367, 170, 50);
		contentPane.add(button_3);
		
		JLabel lblpic = new JLabel("");
		lblpic.setBounds(200, 0, 371, 175);
		String image= "Img";
		String val = System.getenv(image);
		String url = val+"\\logo.png";
		lblpic.setIcon(new ImageIcon(url));
		contentPane.add(lblpic);
	}
}