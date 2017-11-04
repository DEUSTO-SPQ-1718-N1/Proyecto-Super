package com.deusto.SPQ1718.DSPQ1718P1_27;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.deusto.SPQ1718.Proyecto_Super.Base;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JRadioButton;

public class CrearCuenta extends JFrame {
	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
	static Login2 frame;
	private JPasswordField passwordField;
	private ButtonGroup group;
	private JRadioButton rdbtnCliente, rdbtnEmpleado;
	private JTextField txtUsuario, txtNombre, txtApellido;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCuenta frame2 = new CrearCuenta();
					frame2.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CrearCuenta() {
		final JFrame frame2 = new JFrame();
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
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Llamar a las pantallas Usuario/Empleado
				setVisible(false);
				
				  Base metodosbd = new Base();
			        
				/**  int exito =  metodosbd.Guardar(txtNombre.getText(), txtApellido.getText(), 
				               txtUsuario.getText(), passwordField.getPassword(), 
				               group.getSelection());
				 
				  if(exito>0){

				    JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente", 
				                                  "Éxito en la operación", JOptionPane.INFORMATION_MESSAGE);

				  }else{

				    JOptionPane.showMessageDialog(null, "Los datos no se pudieron guardar\n"
				                                 + "Inténtelo nuevamente", "Error en la operación", JOptionPane.ERROR_MESSAGE); 
				  
				  }**/
			}
		});
		btnAceptar.setBounds(297, 415, 97, 25);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//Volver a la pantalla de LogIn
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
		
		JRadioButton rdbtnCliente = new JRadioButton("CLIENTE");
		rdbtnCliente.setForeground(Color.GRAY);
		rdbtnCliente.setBounds(297, 383, 127, 25);
		contentPane.add(rdbtnCliente);
		
		JRadioButton rdbtnEmpleado = new JRadioButton("EMPLEADO");
		rdbtnEmpleado.setForeground(Color.GRAY);
		rdbtnEmpleado.setBounds(430, 383, 127, 25);
		contentPane.add(rdbtnEmpleado);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnCliente);
		group.add(rdbtnEmpleado);
		
		JLabel label = new JLabel("Perfil");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(200, 386, 80, 16);
		contentPane.add(label);
	}
}
