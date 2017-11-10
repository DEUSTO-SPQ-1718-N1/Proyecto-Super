package com.deusto.SPQ1718.DSPQ1718P1_27;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.deusto.SPQ1718.Proyecto_Super.Base;
//import com.deusto.SPQ1718.DSPQ1718P1_43.UserMenu;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 *El usuario tendrá que introducir su usuario y password  
 *Se hará la comprobación con la BD de la información introducida
 *Si el usuario es cliente se mostrará una pantalla de menu para cleintes, 
 *Si el usuario es empleado se mostrará una pantalla de menu para empleados
 *También se dará la opción de crear una nueva cuenta a los nuevos usuarios
 **/
public class Login2 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	Connection conn;
	private JPanel contentPane;
	static Login2 frame;
	private JPasswordField passwordField;
	private JTextField txtUsuario;
	private JButton btnCrear, btnAcceder, btnExit;

	public Login2() {
		String s = System.getProperty("user.dir");
	    String dbUrl = "jdbc:derby:"+s+"\\src\\main\\sql\\base;create=true";
	    try {
			conn = DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    setTitle("SuperMarket");
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
 
		
		JLabel lblpic = new JLabel("");
		lblpic.setBounds(200, 0, 371, 175);
		lblpic.setIcon(new ImageIcon("src/main/java/com/deusto/SPQ1718/Proyecto_Super/logo.png"));
		contentPane.add(lblpic);
			
		passwordField = new JPasswordField();
		passwordField.setBounds(297, 268, 153, 28);
		contentPane.add(passwordField);
		
		JFormattedTextField frmtdtxtfldUsuario = new JFormattedTextField();
		frmtdtxtfldUsuario.setText("usuario");
		frmtdtxtfldUsuario.setBounds(440, 223, -186, 22);
		contentPane.add(frmtdtxtfldUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setText("");
		txtUsuario.setBounds(297, 217, 153, 28);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnAcceder = new JButton("INICIAR SESION");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**Llamar a las pantallas Usuario/Empleado**/
				
				setVisible(false);
				
				String nick =  txtUsuario.getText();
				char[] pass = passwordField.getPassword();
				String clave = new String(pass);
				
				Statement stmt;
							
					try {
						
					stmt = conn.createStatement();
					//String nickC ="";
					ResultSet rs = stmt.executeQuery("SELECT * FROM cliente WHERE nick = '"+nick+"'");
					System.out.println("Escribo yo: " + nick);
					while (rs.next()) {					    	
					    	if(rs.getString("nick").equals(nick))
					    	{
					    		//nickC = rs.getString("nick");
					    		System.out.println(rs.getString("nick"));
					    		//System.out.println("Usuario correcto");
					    		
					    		ResultSet rs1 = stmt.executeQuery("SELECT * FROM cliente WHERE nick = '"+nick+"' AND clave = '"+clave+"'");
					    		while (rs1.next()){
						    		
					    			if(rs1.getString("clave").equals(clave))
							    	{
						    			//nickC = rs.getString("nick");
										System.out.println(rs1.getString("clave"));
										//System.out.println("Contraseña correcta");break;
										//UserMenu frame = new UserMenu();
										//frame.setVisible(true);
										setVisible(false);
										System.out.println("Login Cliente correcto");break;
										
										
							    	}else {
							    		
							    		System.out.println("Contraseña incorrecta");break;
							    		
							    	}
					    		}
					    	}else{
					    		
					    		ResultSet rs2 = stmt.executeQuery("SELECT * FROM empleado WHERE nick = '"+nick+"'");
					    		while (rs2.next()){
					    			if(rs.getString("nick").equals(nick))
							    	{
					    				System.out.println(rs2.getString("nick"));
					    				
					    				ResultSet rs4 = stmt.executeQuery("SELECT * FROM cliente WHERE nick = '"+nick+"' AND clave = '"+clave+"'");
							    		while (rs4.next()){
								    		
							    			if(rs4.getString("clave").equals(clave))
									    	{
								    			
												System.out.println(rs4.getString("clave"));
												//System.out.println("Contraseña correcta");break;
												//AdminMenu frame2 = new AdminMenu();
												//frame2.setVisible(true);
												setVisible(false);
												
												System.out.println("Login Empleado correcto");break;
													
									    	}else {
									    		
									    		System.out.println("Contraseña incorrecta");break;
									    		
									    	}
							    		}
							    	}else{
							    		System.out.println("Contraseña incorrecto");break;
							    	}
					    		
					    		}
					    		System.out.println("Usuario incorrecto");break;
					    	}
					 }
	
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			
				
				
			});
		btnAcceder.setBounds(297, 309, 153, 44);
		contentPane.add(btnAcceder);
		
		btnCrear = new JButton("CREAR CUENTA");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**Llamar a LlamarCrearCuenta**/
				/*CrearCuenta frame2 = new CrearCuenta();
				frame2.setVisible(true);
				setVisible(false);*/
			}
		});
		btnCrear.setBounds(297, 374, 153, 28);
		contentPane.add(btnCrear);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(297, 199, 56, 16);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(297, 247, 80, 16);
		contentPane.add(lblPassword);
		
		
	}
}
