package com.deusto.SPQ1718.DSPQ1718P1_27;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.deusto.SPQ1718.Proyecto_Super.App;

public class Login extends JFrame implements ActionListener{
//Esta clase llama a la pantalla de LogIn
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//Login log = new Login("nickname", "clave");
		Login2 frame = new Login2();
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
