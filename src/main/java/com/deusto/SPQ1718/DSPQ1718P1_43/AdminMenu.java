package com.deusto.SPQ1718.DSPQ1718P1_43;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.deusto.SPQ1718.DSPQ1718P1_19.InterfazUsuario;
import com.deusto.SPQ1718.DSPQ1718P1_32.EnviarOferta;
import com.deusto.SPQ1718.DSPQ1718P1_33.EnviarRecomendacion;
import com.deusto.SPQ1718.P1_39.Usuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
				EnviarOferta  of = new EnviarOferta();
				String aviso= of.aviso();
				String oferta = of.oferta(); 
				of.lanzarVentanaOfertas(aviso, oferta);
				frame.setVisible(false);				
			}
		});
		button_6.setBounds(47, 245, 153, 50);
		contentPane.add(button_6);
		
		JButton button_5 = new JButton("Manual de usuario");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnviarRecomendacion  re = new EnviarRecomendacion();
				String aviso= re.avisoRecomendacion();
				String recomendacion = re.productoRecomendado();
				re.lanzarVentanaRecomendaciones(aviso, recomendacion); 
				frame.setVisible(false);
			}
		});
		button_5.setBounds(280, 245, 234, 50);
		contentPane.add(button_5);
				
		JButton button_1 = new JButton("......");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Usuario("Jessica", "Sanchez", "Perez", 1454, "src/main/java/com/deusto/SPQ1718/P1_37/img1.jpg", "Nesquick", "Pan baguette", "Tarta de manzana", "Balon de futbol", "Lavadora Siemens", 5, 1, 7, 3, 35, "12/09/2017", "12/09/2017", "12/09/2017", "04/09/2017", "04/09/2017");
				frame.setVisible(false);
			}
		});
		button_1.setBounds(575, 245, 153, 50);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Informes");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        InterfazUsuario interfaz= new InterfazUsuario();
		        interfaz.setVisible(true);
				frame.setVisible(false);
			}
		});
		button_2.setBounds(47, 367, 153, 50);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Estadísticas y tendencias");
		button_3.setBounds(575, 367, 153, 50);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Presentación de resultados actualizados");
		button_4.setBounds(280, 367, 234, 50);
		contentPane.add(button_4);
		
		JLabel lblpic = new JLabel("");
		lblpic.setBounds(200, 0, 371, 175);
		lblpic.setIcon(new ImageIcon("src/main/java/com/deusto/SPQ1718/Proyecto_Super/logo.png"));
		contentPane.add(lblpic);
	}
}