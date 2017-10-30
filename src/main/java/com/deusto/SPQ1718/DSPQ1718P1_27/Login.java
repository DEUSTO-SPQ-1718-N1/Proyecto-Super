package com.deusto.SPQ1718.DSPQ1718P1_27;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.deusto.SPQ1718.Proyecto_Super.App;

public class Login extends JFrame implements ActionListener{
//Esta clase generará la pantalla de LogIn para acceder a la aplicacion
//El usuario tendrá que introducir su usuario y password
	
	private static final long serialVersionUID = 1L;
	//Inicializamos los componentes y parametros
	private JLabel Lusuario, Lcontra;
	private JTextField Tusuario, Tcontra;
	private JPanel panelInferior, panelSuperior, panelCentral;
	private JButton botonL;
    private String nombreUser, nombrePass;
    private String nickname, clave; 
 
    
    /*
     * La ventana está diseñada con el BorderLayout.
     * Cada metodo se encarga de construir el diseño de un panel diferente del BorderLayout.
     */
	
        
    public void construyePanelInferior(){
        panelInferior = new JPanel();
        botonL=new JButton("        L O G  I N        ");        
        botonL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {					
				App frame = new App();
				frame.setVisible(true);
				setVisible(false);
			}
		});
        
        panelInferior.setBackground(Color.blue);
        panelInferior.add(botonL);

    }
    public void construyePanelSuperior(){
	    panelSuperior = new JPanel();

	    panelSuperior.setBackground(Color.blue);
		} 
	    
    public void construyePanelCentral(){
        panelCentral = new JPanel();
        //Se crea el label y la caja de texto donde se colocará el usuario
        JLabel Lusuario = new JLabel("Usuario");
        Lusuario.setBounds(10, 50, 150, 30);
        Lusuario.setFont(new Font("Serif", Font.BOLD, 25));
        add(Lusuario);
         
        JTextField Tusuario = new JTextField();
        Tusuario.setBounds(100, 50, 150, 30);
        add(Tusuario);
               
        panelCentral.setLayout(new GridLayout(3,1));
        panelCentral.setBackground(Color.blue);
        panelCentral.add(Lusuario);
        panelCentral.add(Tusuario);
        
        //Se crea el label y la caja de contraseña
        JLabel Lcontra = new JLabel("Contraseña");
        Lcontra.setBounds(10, 100, 150, 30);
        Lcontra.setFont(new Font("Serif", Font.BOLD, 25));
        add(Lcontra);
         
        JPasswordField Tcontra = new JPasswordField();
        Tcontra.setBounds(100, 100, 150, 30);
        add(Tcontra);

    }
	
   /*
    * Construimos el diseño de la ventana y sus propiedades
    */
    public void construyeVentana(){   
       setLayout(new BorderLayout());
       setTitle("Proyecto Super");                  
       setSize(800,500); 
       setLocationRelativeTo(null);
       setResizable(false);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       setVisible(true);
       setBackground(Color.blue);
       add(panelSuperior,BorderLayout.NORTH);
       add(panelInferior,BorderLayout.SOUTH);
       add(panelCentral,BorderLayout.CENTER);
    }

    /*
     * El constructor inicializa los metodos de construcion de la ventana y recibe los 
     * parametros necesarios
     */
	public Login(String nickname, String clave) {
		
		construyePanelSuperior();
		construyePanelInferior();
        construyePanelCentral();
        construyeVentana();  
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login log = new Login("nickname", "clave");
		
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
