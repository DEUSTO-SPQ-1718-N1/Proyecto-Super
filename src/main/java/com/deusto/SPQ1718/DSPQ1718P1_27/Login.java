package com.deusto.SPQ1718.DSPQ1718P1_27;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;

public class Login extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
/**Esta clase llama a la pantalla de LogIn
 * 
 * @param args
 * @throws SQLException
 */
	public static void main(String[] args) throws SQLException {
		Login2 frame = new Login2();
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {	
	}
}