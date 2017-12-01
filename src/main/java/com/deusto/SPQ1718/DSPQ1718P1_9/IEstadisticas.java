package com.deusto.SPQ1718.DSPQ1718P1_9;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.deusto.SPQ1718.DSPQ1718P1_43.AdminMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JTextField;

import org.apache.log4j.Logger;

/** @brief Permite elegir que tipo de estadisticas quieres ver. 
 * Te redirige IEstadisticaGeneral o a IEstadisticaProducto. */
public class IEstadisticas extends JFrame {
	private final static Logger log = Logger.getLogger("com.deusto.SPQ1718.DSPQ1718P1.HU9");
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static IEstadisticas frame;
	private JTextField textField;
    private String codProd;
    
	public IEstadisticas() {
		setTitle("Menu del Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				if(codProd.equals("")){log.error("No se ha escrito el num de producto"); }
				int result = Integer.parseInt(codProd);
				AccesoBD_9 codProd1 = null;
				try {
					codProd1 = new AccesoBD_9();
				} catch (SQLException e1) {
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
				
				AccesoBD_9 codProd3 = null;
				AccesoBD_9 codEmp3 = null;
				try {
					codProd3 = new AccesoBD_9();
					codEmp3 = new AccesoBD_9();
				} catch (SQLException e1) {
					e1.printStackTrace();
					log.error("Error de acceso a BD");
				}
				int ResProd = 0;
				int ResEmp = 0;
				
				try {
					ResProd = codProd3.getProductoMasVendido();
					System.out.println("IEstadisticas de Producto: " + ResProd);
					ResEmp = codEmp3.getEmpleadoMasVentas();
					System.out.println("IEstadisticas de Empleado: " + ResEmp);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					log.warn("Algo ha fallado, revisar");
					log.error("Metodo de consulta ha fallado");
				}

				AccesoBD_9 codProd4 = null;
				AccesoBD_9 codEmp4 = null;
				try {
					codProd4 = new AccesoBD_9();
					codEmp4 = new AccesoBD_9();
				} catch (SQLException e1) {
					e1.printStackTrace();
					log.error("Error de acceso a BD");
				}
				String ResProd1 = codProd4.getNombreP(ResProd);
				Float ResProd2 = codProd4.getPrecioP(ResProd);
				String ResE_Nom = codEmp4.getNombreE(ResEmp);
				String ResE_Ape = codEmp4.getApellidoE(ResEmp);
				
				IEstadisticaGeneral ieg = null;
				try {
					ieg = new IEstadisticaGeneral(ResProd, ResProd1, ResProd2, ResEmp, ResE_Nom, ResE_Ape);
				} catch (SQLException e) {
					e.printStackTrace();
					log.warn("Algo ha fallado, revisar");
				}
				ieg.setVisible(true);
				dispose();
			}
		});
		button.setBounds(446, 114, 245, 117);
		contentPane.add(button);
	}

	/**
	 * Getter de codProd.
	 *
	 * @return codProd
	 */
	public String getCodProd() {
		return codProd;
	}

	/**
	 * Setter de codProd.
	 *
	 * @return codProd actualizado
	 */
	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}
}