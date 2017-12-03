package com.deusto.SPQ1718.DSPQ1718P1_27;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.*;

public class LoginTest {
		 
	/*Connection conn;
	
	@BeforeClass
    public static void setUpClass() throws Exception {
        // Code executed before the first test method 
		 Base app = new Base();
		 app.connectionToDerby();
		 app.normalDbUsage();
    }
 
	/* @Before
    public void setUp() throws Exception {
        // Code executed before each test    
    }*/
 
  /*  @Test
    public void testValidacion() {
        // Code that tests one thing
    	String nick =  "cli1";
		String clave = "cli1";;
		
		Statement stmt;
					
			try {
			
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM cliente WHERE nick = '"+nick+"'");

			while (rs.next()) {					    	
			    	if(rs.getString("nick").equals(nick))
			    	{
			    		System.out.println(rs.getString("nick"));
			    		System.out.println("Usuario correcto");
			    		
			    		ResultSet rs1 = stmt.executeQuery("SELECT * FROM cliente WHERE nick = '"+nick+"' AND clave = '"+clave+"'");
			    		while (rs1.next()){
				    		
			    			if(rs1.getString("clave").equals(clave))
					    	{

								System.out.println(rs1.getString("clave"));
								System.out.println("Login Cliente correcto");break;
								
						 	}else {
					    		
					    		System.out.println("Contraseña incorrecta");break;
					    		
					    	}
			    		}
			    	}else{
			    		
			    		ResultSet rs2 = stmt.executeQuery("SELECT * FROM empleado WHERE nick = '"+nick+"'");
			    		while (rs2.next()){
			    			if(rs.getString("nick").equals(nick))
					    	{
			    				System.out.println(rs2.getString("nick"));
			    				
			    				ResultSet rs4 = stmt.executeQuery("SELECT * FROM cliente WHERE nick = '"+nick+"' AND clave = '"+clave+"'");
					    		while (rs4.next()){
						    		
					    			if(rs4.getString("clave").equals(clave))
							    	{
						    			
										System.out.println(rs4.getString("clave"));										
										System.out.println("Login Empleado correcto");break;
											
							    	}else {
							    		
							    		System.out.println("Contraseña incorrecta");break;
							    		
							    	}
					    		}
					    	}else{
					    		System.out.println("Contraseña incorrecto");break;
					    	}
			    		
			    		}
			    		System.out.println("Usuario incorrecto");break;
			    	}
			 }

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
 
    @Test
    public void testCrearCuentaCliente() {
        // Code that tests another thing
    	String nombre = "juncal"; 
		String apellido = "fer"; 
		String usuario= "jcli"; 
		String clave = "jcli";
	
		System.out.println(nombre + " " + apellido + " " + usuario  + " " + clave);
		
		/**Guardar los campos en la BD**/
	/*	try {			
				System.out.println("Llamando a tabla cliente");
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("insert into cliente(nombre , apellido, nick, clave) values ('"+nombre+"', '"+apellido+"', '"+usuario+"', '"+clave+")");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
 
    
    @Test
    public void testCrearCuentaEmpleado() {
        // Code that tests something else
    	String nombre = "aitor"; 
		String apellido = "del"; 
		String usuario= "aemp"; 
		String clave = "aemp";
	
		System.out.println(nombre + " " + apellido + " " + usuario  + " " + clave);
		
		/**Guardar los campos en la BD**/
	/*	try {			
				System.out.println("Llamando a tabla empleado");
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("insert into empleado(nombre , apellido, nick, clave) values ('"+nombre+"', '"+apellido+"', '"+usuario+"', '"+clave+")");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    /*
    @After
    public void tearDown() throws Exception {
        // Code executed after each test   
    }
 
    @AfterClass
    public static void tearDownClass() throws Exception {
        // Code executed after the last test method 
    }*/

}
