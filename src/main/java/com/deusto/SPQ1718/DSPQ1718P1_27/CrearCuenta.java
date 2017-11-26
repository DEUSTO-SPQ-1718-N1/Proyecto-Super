package com.deusto.SPQ1718.DSPQ1718P1_27;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JRadioButton;

import org.apache.log4j.Logger;

/**
 *En esta pantalla el usuario tendrá que introducir sus datos para crear una nueva cuenta 
 *Los campos introducidos se guardarán en la BD en la tabla correspondiente según indique su perfil (empleado/cliente)
 **/
public class CrearCuenta extends JFrame {
	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
	static Login2 frame;
	private JPasswordField passwordField;
	private ButtonGroup group;
	private JRadioButton rdbtnCliente, rdbtnEmpleado;
	private JTextField txtUsuario, txtNombre, txtApellido;
	private JPanel contentPane;
	Connection conn;
	int result = 0;
	private final static Logger log = Logger.getLogger("com.deusto.SPQ1718.DSPQ1718P1.HU5");

	/**
	 * Create the frame.
	 */
	public CrearCuenta() {
		String env= "base";
		String value = System.getenv(env);
		String dbUrl = "jdbc:derby:"+value+"\\sql\\base;create=true";
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
		String image= "Img";
		String val = System.getenv(image);
		String url = val+"\\logo.png";
		lblpic.setIcon(new ImageIcon(url));
		contentPane.add(lblpic);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(297, 346, 260, 28);
		contentPane.add(passwordField);
		
		JFormattedTextField frmtdtxtfldUsuario = new JFormattedTextField();
		frmtdtxtfldUsuario.setText("usuario");
		frmtdtxtfldUsuario.setBounds(440, 223, -186, 22);
		contentPane.add(frmtdtxtfldUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setText("");
		txtUsuario.setBounds(297, 305, 260, 28);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setText("");
		txtNombre.setBounds(297, 223, 260, 28);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setText("");
		txtApellido.setBounds(297, 264, 260, 28);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(200, 310, 56, 16);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(200, 351, 80, 16);
		contentPane.add(lblPassword);
			
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(200, 228, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setBounds(200, 269, 56, 16);
		contentPane.add(lblApellido);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*Limpiar formulario
				txtNombre.setText(null);
				txtApellido.setText(null);
				txtUsuario.setText(null);
				passwordField.setText(null);
				group.isSelected(null);*/
				
			/**Volver a la pantalla de LogIn	**/
				Login2 frame = new Login2();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnCancelar.setBounds(460, 415, 97, 25);
		contentPane.add(btnCancelar);
		
		JLabel lblIntroduzcaLosSiguientes = new JLabel("INTRODUZCA LOS SIGUIENTES DATOS");
		lblIntroduzcaLosSiguientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblIntroduzcaLosSiguientes.setForeground(Color.WHITE);
		lblIntroduzcaLosSiguientes.setBounds(234, 194, 282, 16);
		contentPane.add(lblIntroduzcaLosSiguientes);
		
		final JRadioButton rdbtnCliente = new JRadioButton("CLIENTE");
		rdbtnCliente.setForeground(Color.GRAY);
		rdbtnCliente.setBounds(297, 383, 127, 25);
		contentPane.add(rdbtnCliente);
		rdbtnCliente.setActionCommand("Cliente");
		
		final JRadioButton rdbtnEmpleado = new JRadioButton("EMPLEADO");
		rdbtnEmpleado.setForeground(Color.GRAY);
		rdbtnEmpleado.setBounds(430, 383, 127, 25);
		contentPane.add(rdbtnEmpleado);
		rdbtnEmpleado.setActionCommand("Empleado");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnCliente);
		group.add(rdbtnEmpleado);
		
		rdbtnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnCliente.isSelected()){
					result = 1;
					System.out.println("Cliente");
					System.out.println(result);
				}
			}		
		});
		
		rdbtnEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnEmpleado.isSelected()){
					result = 2;
					System.out.println("Empleado");
					System.out.println(result);
				}
			}		
		});
		
		System.out.println(result);	
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText(); 
				String apellido = txtApellido.getText(); 
				String usuario= txtUsuario.getText(); 
				char[] pass = passwordField.getPassword();
				String clave = new String(pass);
				//String type = group.getSelection().getActionCommand();
				System.out.println(nombre + " " + apellido + " " + usuario  + " " + clave);
				
				/**Guardar los campos en la BD**/
			  try {
					if(result==1){
						System.out.println("Llamando a tabla cliente");
						Statement stmt = conn.createStatement();
						stmt.executeUpdate("insert into cliente(nombre , apellido, nick, clave) values ('"+nombre+"', '"+apellido+"', '"+usuario+"', '"+clave+"')");
						//System.out.println("insert into cliente(nombre , apellido, nick, clave) values ('"+nombre+"', '"+apellido+"', '"+usuario+"', '"+clave+")");
					}else if (result==2){
						System.out.println("Llamando a tabla empleado");
						Statement stmt = conn.createStatement();
						stmt.executeUpdate("insert into empleado(nombre , apellido, nick, clave) values ('"+nombre+"', '"+apellido+"', '"+usuario+"', '"+clave+"')");
					}else{
						System.out.println("ERROR: No se ha seleccionado el perfil ni de cliente ni de empleado");
						log.warn("No se ha elegido opción perfil");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					log.error("SQL incorrecto Clase Crear Cuenta");
				}
				  
				 	  
				//Volver a la pantalla de LogIn
					Login2 frame = new Login2();
					frame.setVisible(true);
					setVisible(false);
			}
		});
		btnAceptar.setBounds(297, 415, 97, 25);
		contentPane.add(btnAceptar);	
		
		JLabel label = new JLabel("Perfil");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(200, 386, 80, 16);
		contentPane.add(label);
	}
}