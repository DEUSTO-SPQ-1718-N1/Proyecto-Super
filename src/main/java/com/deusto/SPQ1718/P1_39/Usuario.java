package com.deusto.SPQ1718.P1_39;

import com.deusto.SPQ1718.P1_37.InterfazUsuario;

/*
 * Clase que recibe y gestiona los atributos necesarios que tiene que enviar a la clase 
 * InterfazUsuario para crear la ventana y mostrar su contenido
 */
public class Usuario {

	private String nombre, apellido1,apellido2, img;
    private int puntos;

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
    public Usuario(String nombre, String apellido1, String apellido2, int puntos, String img) {
    	this.nombre = nombre;
    	this.apellido1 = apellido1;
    	this.apellido2 = apellido2;
	    this.puntos = puntos;
	    this.img = img;
	    
	  	new InterfazUsuario(nombre, apellido1, apellido2, puntos, img);
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