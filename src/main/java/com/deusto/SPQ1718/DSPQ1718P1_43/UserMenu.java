package com.deusto.SPQ1718.DSPQ1718P1_43;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.deusto.SPQ1718.DSPQ1718P1_1.Interfaz_14;
import com.deusto.SPQ1718.DSPQ1718P1_32.EnviarOferta;
import com.deusto.SPQ1718.DSPQ1718P1_33.EnviarRecomendacion;
import com.deusto.SPQ1718.DSPQ1718P1_6.ValoracionPostCompra;
import com.deusto.SPQ1718.DSPQ1718P1_6.VisualizacionValoracion;
import com.deusto.SPQ1718.DSPQ1718P1_8.InterfazUsuario;
import com.deusto.SPQ1718.P1_39.Usuario;
import com.deusto.SPQ1718.Proyecto_Super.Inicio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

//Clase sobre el panel del menu del usuario o cliente

public class UserMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static UserMenu frame;

	public UserMenu() {
		setTitle("Menu del Cliente");
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
		
		JButton button_6 = new JButton("Promociones");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnviarOferta  of = new EnviarOferta();
				String aviso= of.aviso();
				String oferta = of.oferta(); 
				of.lanzarVentanaOfertas(aviso, oferta);	
				dispose();
			}
		});
		button_6.setBounds(71, 367, 187, 50);
		contentPane.add(button_6);
		
		JButton button_5 = new JButton("Recomendaciones personalizadas");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnviarRecomendacion  re = new EnviarRecomendacion();
				String aviso= re.avisoRecomendacion();
				String recomendacion = re.productoRecomendado();
				re.lanzarVentanaRecomendaciones(aviso, recomendacion); 
				dispose();
			}
		});
		button_5.setBounds(71, 245, 286, 50);
		contentPane.add(button_5);
				
		JButton button_1 = new JButton("Puntos acumulados");
		String image2= "Img";
		String val = System.getenv(image2);
		final String url3 = val+"\\img1.jpg";
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Usuario("Veronica", "Sanchez", "Perez", 1454, url3, "Nesquick", "Pan baguette", "Tarta de manzana", "Balon de futbol", "Lavadora Siemens", 5, 1, 7, 3, 35, "12/09/2017", "12/09/2017", "12/09/2017", "04/09/2017", "04/09/2017");
				dispose();
			}
		});
		button_1.setBounds(442, 245, 286, 50);
		contentPane.add(button_1);
		
		JButton button_3 = new JButton("Valorar una Compra");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				ValoracionPostCompra v2 = null;
				v2 = new ValoracionPostCompra(1);
				v2.setVisible(true);
				dispose();
			}
		});
		button_3.setBounds(313, 367, 165, 50);
		contentPane.add(button_3);
		
		JLabel lblpic = new JLabel("");
		lblpic.setBounds(200, 0, 371, 175);
		String image= "Img";
		String val2 = System.getenv(image);
		String url = val2+"\\logo.png";
		lblpic.setIcon(new ImageIcon(url));
		contentPane.add(lblpic);
		
		JButton button = new JButton("Ver valoraciones de Compras");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazUsuario u = null;
				VisualizacionValoracion v1 = null;
				try {
					u = new InterfazUsuario();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				u.setVisible(true);
				dispose();
			}
		});
		button.setBounds(524, 367, 204, 50);
		contentPane.add(button);
	}
}