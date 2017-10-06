/**
 * 
 */
package com.deusto.SPQ1718.Proyecto_Super;

/**
 * @author ALUMNO
 *
 */
public class VerPuntos {

	/**
	 * 
	 */
	int Puntos;
	int numUser;
		
	public VerPuntos(int Puntos, int numUser) {
		this.Puntos = Puntos;
		this.numUser = numUser;
	}
	
	public int getPuntos() {
		return Puntos;
	}

	public void setPuntos(int puntos) {
		Puntos = puntos;
	}

	public int getNumUser() {
		return numUser;
	}

	public void setNumUser(int numUser) {
		this.numUser = numUser;
	}
}
