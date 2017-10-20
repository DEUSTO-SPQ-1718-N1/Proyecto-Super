package com.deusto.SPQ1718.P1_39;

import com.deusto.SPQ1718.P1_37.InterfazUsuario;

/*
 * Clase que recibe y gestiona los atributos necesarios que tiene que enviar a la clase 
 * InterfazUsuario para crear la ventana y mostrar su contenido
 */
public class Usuario {

	private String nombre, apellido1,apellido2, img;
    private int puntos;
    
    private String np1, np2, np3, np4, np5; 
    private int pp1, pp2, pp3, pp4, pp5;
    private String fp1, fp2, fp3, fp4, fp5;

    /*
     * Constructor 1: constructor sin parametros
     * en principio no se usa
     */
    public Usuario() {
        nombre = "Usuario";       
        apellido1 = "";
        apellido2 = "";
        puntos = 0;
    }
 
    /*
     * Constructor 2: constructor con parametros
     * Este método llama a InterfazUsuario para crear el Jframe y le pasa los atributos del usuario
     */
    public Usuario(String nombre, String apellido1, String apellido2, int puntos, String img, String np1, String np2, String np3, String np4, String np5, int pp1, int pp2, int pp3, int pp4, int pp5, String fp1, String fp2, String fp3, String fp4, String fp5) {
    	this.nombre = nombre;
    	this.apellido1 = apellido1;
    	this.apellido2 = apellido2;
	    this.puntos = puntos;
	    this.img = img;	  	
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
        
	  	new InterfazUsuario(nombre, apellido1, apellido2, puntos, img, np1, np2, np3, np4, np5, pp1, pp2, pp3, pp4, pp5, fp1, fp2, fp3, fp4, fp5);

	}
 
    /*
     * Getters y setters
     */
	public String getNombre() {
		return nombre;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}