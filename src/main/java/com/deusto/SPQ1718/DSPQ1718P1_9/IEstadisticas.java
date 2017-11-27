package com.deusto.SPQ1718.DSPQ1718P1_9;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.deusto.SPQ1718.DSPQ1718P1_1.Interfaz_14;
import com.deusto.SPQ1718.DSPQ1718P1_27.Login2;
import com.deusto.SPQ1718.DSPQ1718P1_43.AdminMenu;
import com.deusto.SPQ1718.Proyecto_Super.App;
import com.deusto.SPQ1718.Proyecto_Super.Inicio;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

//Clase
public class IEstadisticas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static IEstadisticas frame;
	private JTextField textField;
	
    private String codProd;
    private int getPrecioP;
    
	public IEstadisticas() {
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

		
		JButton button_6 = new JButton("Aceptar");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codProd =  textField.getText();
				int result = Integer.parseInt(codProd);

				AccesoBD_9 codProd1 = null;
				try {
					codProd1 = new AccesoBD_9();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String ResProd = codProd1.getNombreP(result);
				Float ResProd2 = codProd1.getPrecioP(result);

				IEstadisticaProducto ipe = new IEstadisticaProducto(result, ResProd, ResProd2);
				ipe.setVisible(true);
				dispose();
			}
		});
		button_6.setBounds(101, 345, 245, 50);
		contentPane.add(button_6);
		
		JButton button_2 = new JButton("Volver");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminMenu frame2 = new AdminMenu();
				frame2.setVisible(true);
				//Inicio1.frest1.setVisible(false);				
				dispose();
			}
		});
		button_2.setBounds(446, 345, 245, 50);
		contentPane.add(button_2);
		
		


		
		JLabel lblCdigoDelProducto = new JLabel("Codigo del Producto");
		lblCdigoDelProducto.setBounds(101, 114, 245, 50);
		contentPane.add(lblCdigoDelProducto);
		
		textField = new JTextField();
		textField.setBounds(101, 187, 245, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("Estadisticas Generales");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AccesoBD_9 codProd2 = null;
				AccesoBD_9 codEmp = null;
				try {
					codProd2 = new AccesoBD_9();
					codEmp = new AccesoBD_9();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String Res1 = null;
				String ResEmp = null;
				try {
					Res1 = codProd2.getProductoMasVendido();
					//ResEmp = codProd2.getEmpleadoMasVentas();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				System.out.println(Res1);
				System.out.println(ResEmp);
				
				//PRUEBA
				int resultP = 1;
				int resultE = 1;

				AccesoBD_9 codProd3 = null;
				AccesoBD_9 codProd4 = null;
				try {
					codProd3 = new AccesoBD_9();
					codProd4 = new AccesoBD_9();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String ResProd = codProd3.getNombreP(resultP);
				Float ResProd2 = codProd3.getPrecioP(resultP);
				String ResE_Nom = codProd3.getNombreE(resultE);
				String ResE_Ape = codProd3.getApellidoE(resultE);
				
				IEstadisticaGeneral ieg = null;
				try {
					ieg = new IEstadisticaGeneral(resultP, ResProd, ResProd2, resultE, ResE_Nom, ResE_Ape);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ieg.setVisible(true);
				dispose();
			}
		});
		button.setBounds(446, 114, 245, 117);
		contentPane.add(button);
	}

	public String getCodProd() {
		return codProd;
	}

	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}
}