package com.deusto.SPQ1718.DSPQ1718P1_7;

/**
 * Clase que se utiliza para gestionar los pagos con tarjeta
 * Como aún no se tiene acceso al servicio, se usan instancias simuladas con los mismos métodos que tendrá la interfaz del servicio
 * @author ALUMNO
 *
 */

public class CompraTarjeta {
	
	OperacionTarjeta o;/**< Para los pagos con tarjeta se debe utilizar una instancia de lainterfaz de servicio externo que nos permite acceder a las funcionalidades de pago con tarjeta*/
	/**
	 * @brief Contructor de la clase
	 * @param o Instancia de la interfaz de pago con tarjeta para llamar a la funcionalidad de los métodos del servicio de pago digital
	 */
	public CompraTarjeta(OperacionTarjeta o){
		this.o = o;
	}
	/**
	 * @brief Método que se encarga de realizar lasoperaciones necesarias para ejecutar una compra con tarjeta
	 * @param u int id del usuario
	 * @param cant int cantidad comprada
	 * @param clave int clave de la tarjeta
	 * @param con int clave de conexión con el proveedor del servicio
	 * @return devuelve 1 si ha existido un problema con la conexión al prov, 2 o 3 si hay problemas con el envio de Datos y 0 si todo ha ido bien
	 */
	public int realizarCompra(int u, int cant, int clave, int con){
		
		if(o.conectarProv(con)!= 0){
			return o.conectarProv(con);/**< devuelve 1*/
			/*Hacer log de conexion con proveedor fallida*/
		}
		else{
			if(o.mandarDatos(u, clave, cant)!=0){
				return o.mandarDatos(u, clave, cant);/**< deuvleve 3 si no hay fondos y 2 si hay error con usuario y claves*/
			}
			return 0;
		}
		
	}
	/**
	 * @brief Método que devuelve la confirmación de como resulto la operación con tarjeta realizada
	 * @param c int que vendrá del método realizarCompra(int,int,int,int)
	 * @return booleano true si todo fue bien o false si hubo un error
	 */
	public boolean confirmarCompra(int c){
		return o.exitoPago(c);
	}
	/**
	 * @brief Método que devuelve el estado es texto de la operación con tarjeta realizada
	 * @param  c int que vendrá del método realizarCompra(int,int,int,int)
	 * @return String que define en un texto cual fue el estado de la operación realizada
	 */
	public String verEstado(int c){
		return o.respuesta(c);
	}

}
