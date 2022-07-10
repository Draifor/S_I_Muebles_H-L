package vista;

import java.awt.BorderLayout;
import javax.swing.*;
import vista.componentes.*;

public class VistaCliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private ContenedorVista contenedorVista;
	private Tabla tabla;
	
	public VistaCliente() {

		this.setLayout(new BorderLayout(0, 0));
		
		this.tabla = new Tabla();
		
		this.contenedorVista = new ContenedorVista("CLIENTES", this.tabla);
		
		this.add(this.contenedorVista, BorderLayout.CENTER);
	}

}
