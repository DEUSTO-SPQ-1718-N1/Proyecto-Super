package com.deusto.SPQ1718.Proyecto_Super;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.deusto.SPQ1718.DSPQ1718P1_19.InterfazUsuario;
import com.deusto.SPQ1718.DSPQ1718P1_32.EnviarOferta;
import com.deusto.SPQ1718.DSPQ1718P1_33.EnviarRecomendacion;
import com.deusto.SPQ1718.DSPQ1718P1_43.AdminMenu;
import com.deusto.SPQ1718.DSPQ1718P1_43.UserMenu;
import com.deusto.SPQ1718.P1_39.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	public static UserMenu frame;
	public static AdminMenu frame2;
	public static InterfazUsuario frame3;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UserMenu();
					frame.setVisible(true);
					frame2 = new AdminMenu();
					frame2.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}