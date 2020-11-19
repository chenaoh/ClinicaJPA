package com.chenao.aplicacion;

import javax.swing.JOptionPane;

import clases.GestionMascotas;
import clases.GestionPersonas;
import clases.GestionProductos;

public class Principal {

	public static void main(String[] args) {
		
		String menu="MENU DE OPCIONES\n\n";
		menu+="1. Getionar Personas\n";
		menu+="2. Gestionar Mascotas\n";
		menu+="3. Gestionar Productos\n";
		menu+="4. Salir\n\n";
		
		int opc=0;
		
		while(opc!=4) {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opc) {
			case 1: new GestionPersonas(); break;				
			case 2: new GestionMascotas(); break;
			case 3: new GestionProductos(); break;
			}
		}
	}
	
	public void iniciar() {
		String mensaje=JOptionPane.showInputDialog("Ingrese algo");
		System.out.println(mensaje);
	}
}


