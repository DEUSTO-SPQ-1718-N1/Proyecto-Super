package com.deusto.SPQ1718.P1_37;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import com.deusto.SPQ1718.DSPQ1718P1_43.UserMenu;
import com.deusto.SPQ1718.Proyecto_Super.App;
/*
 * Clase que crea una ventana en la que se muestra al usuario cuántos puntos tiene
 */
public class InterfazUsuario extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	//Inicializamos los componentes y parametros
	private JLabel foto, usuario, labelpuntos, puntos, UltimaCompra0, UltimaCompra, Espacio;
	private JPanel panelIzquierdo, panelDerecho, panelInferior, panelCentral, panelSuperior;
	private JButton botonV;
    private String nombreUser, ape1User, ape2User, imagen;
    private int puntosAcum;
    private String np1, np2, np3, np4, np5; 
    private int pp1, pp2, pp3, pp4, pp5;
    private String fp1, fp2, fp3, fp4, fp5;
    
    /*
     * La ventana está diseñada con el BorderLayout.
     * Cada metodo se encarga de construir el diseño de un panel diferente del BorderLayout.
     */
	public void construyePanelIzquierdo(){
		panelIzquierdo = new JPanel();	        
        foto = new JLabel("");
	    System.out.println(imagen);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagen).
        getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        foto.setIcon(imageIcon);	

        Espacio = new JLabel(" ");
        Espacio.setFont(new Font("Serif", Font.CENTER_BASELINE, 30));
        UltimaCompra0 = new JLabel("     Ultima compra: ");
        UltimaCompra0.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
        UltimaCompra = new JLabel("     12/09/2017");
        UltimaCompra.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));

        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo,BoxLayout.Y_AXIS));
        panelIzquierdo.setBackground(Color.white);
        panelIzquierdo.add(foto);
        panelIzquierdo.add(Espacio);
        panelIzquierdo.add(UltimaCompra0);
		panelIzquierdo.add(UltimaCompra);
	}

/*
    public void construyePanelDerecho(){
        panelDerecho = new JPanel();
        
        panelDerecho.setLayout(new BoxLayout(panelDerecho,BoxLayout.Y_AXIS));
        panelDerecho.setBackground(Color.white);
    }
*/
	    
	public void construyePanelSuperior(){
	    panelSuperior = new JPanel();
	    
		usuario = new JLabel(nombreUser + " " + ape1User + " " + ape2User + " ");
	    usuario.setFont(new Font("Serif", Font.BOLD, 30));
        usuario.setForeground(Color.white);        
	    
	    panelSuperior.setLayout(new FlowLayout());
	    panelSuperior.setBackground(Color.blue);
	    panelSuperior.add(usuario);
	} 
	    
    public void construyePanelInferior(){
        panelInferior = new JPanel();
        botonV=new JButton("        V O L V E R        ");        
        botonV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {					
				UserMenu frame = new UserMenu();
				frame.setVisible(true);				
				dispose();
			}
		});
        
        //panelInferior.setLayout(new FlowLayout());
        panelInferior.setBackground(Color.blue);
        panelInferior.add(botonV);
    }
	    
    public void construyePanelCentral(){
        panelCentral = new JPanel();
        
        labelpuntos = new JLabel("Puntos acumulados: ", SwingConstants.CENTER);
        labelpuntos.setFont(new Font("Serif", Font.BOLD, 25));
                
        puntos = new JLabel(Integer.toString(puntosAcum), SwingConstants.CENTER);
        puntos.setFont(new Font("Serif", Font.BOLD, 60));
        
        String[] columnNames1 = {"Producto", "Entrada puntos", "Fecha"};
        Object[][] data1 = {
			{np1, "  + " + pp1, fp1},
			{np2, "  + " + pp2, fp2},
			{np3, "  + " + pp3, fp3},
			{np4, "  + " + pp4, fp4},
			{np5, "  + " + pp5, fp5}
		};
       /* 
        Object[][] data1 = {
    			{"Nesquick", "5", "12/09/2017"},
    			{"Pan baguette", "1", "12/09/2017"},
    			{"Tarta de manzana", "7", "12/09/2017"},
    			{"Balon de futbol", "3", "04/09/2017"},
    			{"Lavadora Siemens", "35", "04/09/2017"}
    	};        
        */
        JTable tabla1 = new JTable(data1, columnNames1);
	    tabla1.setRowHeight(30);
        tabla1.setForeground(new Color (0,102,0));        
	    tabla1.setRowHeight(30);  

        String[] columnNames2 = {"Producto", "Salida puntos", "Fecha"};
		Object[][] data2 = {
				{"  TV Samsung 40", "  - 1600", "  12/09/2017"},
				{"  Arroz integral", "  - 50", "  27/06/2017"},
				{"  Coca Cola", "  - 120", "  27/06/2017"},
				{"  Zumo Naranja", "  - 100", "  27/06/2017"},
				{"  Leche Pascual", "  - 180", "  27/06/2017"}
			};
        JTable tabla2 = new JTable(data2, columnNames2);
        tabla2.setForeground(Color.red);        
	    tabla2.setRowHeight(30);
        
        panelCentral.setLayout(new GridLayout(2,2));
        panelCentral.setBackground(Color.white);
        panelCentral.add(labelpuntos);
        panelCentral.add(puntos);
        panelCentral.add(tabla1);
        panelCentral.add(tabla2);
    }
	
   /*
    * Construimos el diseño de la ventana y sus propiedades
    */
    public void construyeVentana(){   
       setLayout(new BorderLayout());
       setTitle("Mi perfil");                  
       setSize(800,500); 
       setLocationRelativeTo(null);
       setResizable(false);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       setVisible(true);
       
       add(panelIzquierdo,BorderLayout.WEST);
       //add(panelDerecho,BorderLayout.EAST);
       add(panelInferior,BorderLayout.SOUTH);
       add(panelSuperior,BorderLayout.NORTH);
       add(panelCentral,BorderLayout.CENTER);
    }

    /*
     * El constructor inicializa los metodos de construcion de la ventana y recibe los 
     * parametros necesarios
     */
	public InterfazUsuario(String nombre, String apellido1, String apellido2, int puntos, String img, String np1, String np2, String np3, String np4, String np5, int pp1, int pp2, int pp3, int pp4, int pp5, String fp1, String fp2, String fp3, String fp4, String fp5) {
        this.nombreUser = nombre;
        this.ape1User = apellido1;
        this.ape2User = apellido2;
        this.puntosAcum = puntos;
        this.imagen = img;
        this.np1=np1;
        this.np2=np2;
        this.np3=np3;
        this.np4=np4;
        this.np5=np5; 
        this.pp1=pp1;
        this.pp2=pp2;
        this.pp3=pp3;
        this.pp4=pp4;
        this.pp5=pp5;
        this.fp1=fp1;
        this.fp2=fp2;
        this.fp3=fp3;
        this.fp4=fp4;
        this.fp5=fp5;
       
		construyePanelInferior();
        construyePanelSuperior();
        construyePanelIzquierdo();
        construyePanelCentral();
        construyeVentana();  
	}

	public void actionPerformed(ActionEvent arg0) {
		
	}   
}