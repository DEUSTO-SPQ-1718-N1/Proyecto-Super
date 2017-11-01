package com.deusto.SPQ1718.DSPQ1718P1_27;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.deusto.SPQ1718.Proyecto_Super.Base;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.Font;

//Esta clase generará la pantalla de LogIn para acceder a la aplicacion
//El usuario tendrá que introducir su usuario y password  
public class Login2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static Login2 frame;
	private JPasswordField passwordField;
	private JTextField txtUsuario;
	private JButton btnCrear, btnAcceder;

	public Login2() {
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
				//Llamar a las pantallas Usuario/Empleado
				setVisible(false);
			}
		});
		btnAcceder.setBounds(297, 309, 153, 44);
		contentPane.add(btnAcceder);
		
		btnCrear = new JButton("CREAR CUENTA");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Llamar a LlamarCrearCuenta
				CrearCuenta frame2 = new CrearCuenta();
				frame2.setVisible(true);
				setVisible(false);
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
