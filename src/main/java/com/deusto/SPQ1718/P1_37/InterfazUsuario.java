package com.deusto.SPQ1718.P1_37;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class InterfazUsuario extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
		//variables y comtenedores
	    private JLabel foto, usuario, labelpuntos, puntos;
	    private JPanel panelIzquierdo, panelDerecho, panelInferior, panelCentral, panelSuperior;
	    private JButton botonIn1, botonIn2;

	    public void construyePanelIzquierdo(){
	        panelIzquierdo = new JPanel();
	        
	        foto = new JLabel("");
	        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/main/java/com/deusto/SPQ1718/P1_37/img1.jpg").
	        getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
	        foto.setIcon(imageIcon);	
			
	        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo,BoxLayout.Y_AXIS));
	        //panelIzquierdo.setBackground(Color.red);
	        panelIzquierdo.add(foto);	        
	    }

	    public void construyePanelDerecho(){
	        panelDerecho = new JPanel();

	        panelDerecho.setLayout(new BoxLayout(panelDerecho,BoxLayout.Y_AXIS));
	        //panelDerecho.setBackground(Color.blue);
	    }

/*	    public void construyePanelSuperior(){
	        panelSuperior = new JPanel();
	        panelSuperior.setLayout(new FlowLayout());
	        panelSuperior.setBackground(Color.green);
	       // panelSuperior.add(usuario);
	    }
	    
	    */
	    
	    public void construyePanelInferior(){
	        panelInferior = new JPanel();
	        botonIn1=new JButton("Aceptar");
	        botonIn2=new JButton("Cancelar");
	        
	        panelInferior.setLayout(new FlowLayout());
	        panelInferior.setBackground(Color.yellow);
	        panelInferior.add(botonIn1);
	        panelInferior.add(botonIn2);
	    }
	    
	    public void construyePanelCentral(){
	        panelCentral = new JPanel();
	        
	        labelpuntos = new JLabel("Puntos acumulados: ", SwingConstants.CENTER);
	        labelpuntos.setFont(new Font("Serif", Font.BOLD, 20));
	        
	        puntos = new JLabel("1000", SwingConstants.CENTER);
	        puntos.setFont(new Font("Serif", Font.BOLD, 40));
	        
	        String[] columnNames1 = {"Producto", "Entrada puntos"};
			Object[][] data1 = {
				{"Nesquick", "5"},
				{"Nesquick", "5"},
				{"Nesquick", "5"},
				{"Nesquick", "5"},
				{"Nesquick", "5"}
			};
	        JTable tabla1 = new JTable(data1, columnNames1);
	        
	        String[] columnNames2 = {"Producto", "Salida puntos"};
			Object[][] data2 = {
					{"Nesquick", "5"},
					{"Nesquick", "5"},
					{"Nesquick", "5"},
					{"Nesquick", "5"},
					{"Nesquick", "5"}
				};
	        JTable tabla2 = new JTable(data2, columnNames2);
	        
			tabla1.setFillsViewportHeight(true);
			tabla2.setFillsViewportHeight(true);
	        
	        panelCentral.setLayout(new GridLayout(2,2));
	        //panelCentral.setBackground(Color.white);
	        panelCentral.add(labelpuntos);
	        panelCentral.add(puntos);
	        panelCentral.add(tabla1);
	        panelCentral.add(tabla2);
	    }
	    
	    public void construyeVentana(){
		   usuario = new JLabel("NOMBRE1 APELLDIO1 APELLIDO2");
	       usuario.setFont(new Font("Serif", Font.BOLD, 30));    
	        
	       setLayout(new BorderLayout());
	       setTitle("Mi perfil");                  
	       setSize(700,500); 
	       setLocationRelativeTo(null);
	       setResizable(false);
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	       setVisible(true);
	        
	       //agregamos los paneles al frame principal
	       add(usuario,BorderLayout.NORTH);
	       add(panelIzquierdo,BorderLayout.WEST);
	       add(panelDerecho,BorderLayout.EAST);
	       add(panelInferior,BorderLayout.SOUTH);
	       add(panelCentral,BorderLayout.CENTER);
	    }

	    public InterfazUsuario(){
	        construyePanelInferior();
	        construyePanelIzquierdo();
	        construyePanelDerecho();
	        construyePanelCentral();
	        construyeVentana();
	    }

		public void actionPerformed(ActionEvent arg0) {

		}


	
	
	
	/*
	private static final long serialVersionUID = 1027418826058059247L;
	private JLabel texto;           // etiqueta o texto no editable
    private JTextField caja;        // caja de texto, para insertar datos
    private JButton boton;          // boton con una determinada accion

    
    
    public InterfazUsuario() {
        super();                    // usamos el contructor de la clase padre JFrame
        setTitle("Esta Es Una Ventana");                  
        setSize(700,500); 
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true); 
        
        /////////
        
		JLabel Foto = new JLabel("");
		Foto.setBounds(0, 0, 500, 192);
		Foto.setIcon(new ImageIcon("src/Resources/sweeper.png"));
		getContentPane().add(Foto);
		
		JPanel Panel0 = new JPanel();
		
		getContentPane().setLayout(null);
		Panel0.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setBackground(Color.YELLOW);
		
		JPanel panel1 = new JPanel();
		Panel0.add(panel1, BorderLayout.CENTER);
		panel1.setLayout(new GridLayout(3, 3, 0, 0));
		
		JPanel panel2 = new JPanel();
		Panel0.add(panel2, BorderLayout.NORTH);
		
		//
		JLabel etiquetaSu;
        etiquetaSu = new JLabel("Demostracion por INFORUX ");
        Font aux=etiquetaSu.getFont();
        etiquetaSu.setFont(new Font(aux.getFontName(), aux.getStyle(), 20));
        frame.setLayout(new BorderLayout());

        //agregamos los paneles al frame principal
        frame.add(etiquetaSu,BorderLayout.NORTH)
		
		//
		
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(84, 225, 89, 34);
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Cambria", Font.BOLD, 18));
		getContentPane().add(lblNombre);
		
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setBounds(84, 282, 89, 34);
		lblNivel.setForeground(Color.BLACK);
		lblNivel.setFont(new Font("Cambria", Font.BOLD, 18));
		getContentPane().add(lblNivel);
		
		       
        
        
        ///////
        
        
     // creamos los componentes
        texto = new JLabel();
        add(texto);
        
        caja = new JTextField();
        add(caja);
        
        boton = new JButton();
        add(boton);
        
        setLayout(new BorderLayout(5,10));
        
        // configuramos los componentes
        texto.setText("Nombre Apellido1 Apellido2");    // colocamos un texto a la etiqueta
        texto.setBounds(50, 50, 100, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        caja.setBounds(150, 50, 100, 25);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
        boton.setText("Mostrar Mensaje");   // colocamos un texto al boton
        boton.setBounds(50, 100, 200, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        boton.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase

        //--
        JFrame frame;
        JPanel contentPane;
    	JTextField textField;
    	JPasswordField passwordField;
    	JButton btnNewButton;
    	String usuario="";
    	String contrasenya="";
        
        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.getContentPane();
        this.setLayout(new GridLayout(0, 2, 0, 0));
               		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		this.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		this.getContentPane().add(textField);
	//	textField.setColumns(2);
		
		
		JLabel lblNewLabel = new JLabel("ContraseÃ±a");
		this.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		this.getContentPane().add(passwordField);
	
	
        
        
        
    }
*/
       
/*        ImageIcon ii = new ImageIcon("C:/icon.jpg");
        JLabel lable = new JLabel(ii);
        JScrollPane jsp = new JScrollPane(lable);
        frame.getContentPane().add(jsp);
        frame. setSize(1000, 700);
        JButton button = new JButton();
        button.setSize(new Dimension(50, 50));
        button.setLocation(500, 350);
       frame.getContentPane().add(button);
        
    
    public void actionPerformed(ActionEvent e) {
        String nombre = caja.getText();                                 // obtenemos el contenido de la caja de texto
        JOptionPane.showMessageDialog(this, "ADIOS " + nombre + ".");    // mostramos un mensaje (frame, mensaje)
    }
  */  
    
}
