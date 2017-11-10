package com.deusto.SPQ1718.DSPQ1718P1_1;

import java.sql.SQLException;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;


public class AccesoBD_13PerfTest {
	
@Rule public ContiPerfRule i = new ContiPerfRule();

	static AccesoBD_13 b;
	@BeforeClass
	public static void con(){
			try {
			b = new AccesoBD_13 ();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20)
	@Required(max = 1200, average = 410)
	public void prueba1() throws InterruptedException{
		b.getNombreP(1);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20)
	@Required(max = 1200, average = 410)
	public void prueba2() throws InterruptedException{
		b.getCantidadP(1);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20)
	@Required(max = 1200, average = 410)
	public void prueba3() throws InterruptedException{
		b.getPuntosP(1);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20)
	@Required(max = 1200, average = 410)
	public void prueba4() throws InterruptedException{
		b.getPrecioP(1);
	}

}
