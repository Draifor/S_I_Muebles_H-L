package vista;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.Border;

import utilidades.Color;
import vista.componentes.*;

public class VistaCliente extends JPanel {

	private NavMenu navegacion;
	private JPanel tabla;
	
	public VistaCliente() {

		this.setLayout(new BorderLayout(0, 0));
		
		this.navegacion = new NavMenu();
		this.tabla = new JPanel();
		
		this.add(this.navegacion, BorderLayout.NORTH);
		this.add(this.tabla, BorderLayout.CENTER);
	}

}
