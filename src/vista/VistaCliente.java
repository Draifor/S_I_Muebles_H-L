package vista;

import javax.swing.*;
import utilidades.Color;
import vista.componentes.*;

public class VistaCliente extends JPanel {

	private NavMenu navegacion;
	
	public VistaCliente() {

		this.navegacion = new NavMenu();
		
		this.add(this.navegacion);
	}

}
