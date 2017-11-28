package com.deusto.SPQ1718.DSPQ1718P1_7;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * @brief Esta clase de prueba confirma el correcto uso de los pagos con tarjeta metiante el uso de clases mock
 * @author ALUMNO
 *
 */
public class MockitoCompraTest {
	/**
	 * @brief En este test se confirma que cuando se llama al método comprar tarjeta se llama correctamente a los métodos de lainterfaz de tarjeta y se devuelve un 0 que confirma el éxito de la operación
	 */
	@Test
	public void testCompraExitosa() {
		int p = 1;
		int z=0;
		OperacionTarjeta o = mock(OperacionTarjeta.class);
		CompraTarjeta c = new CompraTarjeta(o);
		when(o.conectarProv(p)).thenReturn(0);
		when(o.mandarDatos(z, z, z)).thenReturn(0);
		int res = c.realizarCompra(z, z, z, p);
		verify(o, times(1)).conectarProv(p);
		verify(o, atLeastOnce()).mandarDatos(z, z, z);
		assertEquals(0,res);
	    
	}
	/**
	 * @brief en esta clase se fuerza un fallo en la conexión conel proveedor, por tanto, se confirma que las llamadas y respuestas son correctas
	 */
	@Test
	public void testConexionFallida() {
		int p = 1;
		int z=0;
		OperacionTarjeta o = mock(OperacionTarjeta.class);
		CompraTarjeta c = new CompraTarjeta(o);
		when(o.conectarProv(p)).thenReturn(1);
		when(o.mandarDatos(z, z, z)).thenReturn(0);
		int res = c.realizarCompra(z, z, z, p);
		verify(o, times(2)).conectarProv(p);/**< Se debe llamar dos veces a este método*/
		verify(o, times(0)).mandarDatos(z, z, z);/**<No debe haber llamadasa este método porque no se debería tocar ese código*/
		assertEquals(1,res);/**<El estado debería ser 1 que demuestra el fallo de conexión*/
	    
	}
	/**
	 * @brief Se fuerza un fallo en los datos enviados y se confirma que los estados sean correctos
	 */
	@Test
	public void testDatosFallidos() {
		int p = 1;
		int z=0;
		OperacionTarjeta o = mock(OperacionTarjeta.class);
		CompraTarjeta c = new CompraTarjeta(o);
		when(o.conectarProv(p)).thenReturn(0);
		when(o.mandarDatos(z, z, z)).thenReturn(2);
		int res = c.realizarCompra(z, z, z, p);
		verify(o, times(1)).conectarProv(p);/**< Solo se llama unavez ya que la conexión es correcta y no devuelve estado 1 */
		verify(o, times(2)).mandarDatos(z, z, z);/**< Al hacer la llmada a este método hay error estado 2 por tanto se devuelve y por esto se debe llamar dos veces a la funcionalidad */
		assertEquals(2,res);/**<retorno de estado 2 de fallo de datos */
	}
	/**
	 * @brief Se testea que cuando se llama al método de confirmarCompra(int) con un Estado 0 duevelva una respuesta válida
	 */
	@Test
	public void testRespuestaCom(){
		int z = 0;
		OperacionTarjeta o = mock(OperacionTarjeta.class);
		CompraTarjeta c = new CompraTarjeta(o);
		when(o.exitoPago(z)).thenReturn(true);
		boolean res = c.confirmarCompra(z);
		verify(o, times(1)).exitoPago(z);
		assertTrue(res);
		
	}
	/**
	 * @brief Se testea que cuando se llama al método de confirmarCompra(int) con un Estado !=0 duevelva una respuesta válida
	 */
	@Test
	public void testRespuestaComFalla(){
		int z = 0;
		OperacionTarjeta o = mock(OperacionTarjeta.class);
		CompraTarjeta c = new CompraTarjeta(o);
		when(o.exitoPago(z)).thenReturn(false);
		boolean res = c.confirmarCompra(z);
		verify(o, times(1)).exitoPago(z);
		assertFalse(res);
		
		
	}
	

}
