package vista;

import java.awt.BorderLayout;
import javax.swing.*;

import controlador.Operacion;
import controlador.VentanaPrincipalControl;
import utilidades.Color;
import vista.componentes.*;

public class VistaCliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private ContenedorVista contenedorVista;
	private Tabla tabla;
	private Operacion[] FUNCIONES_CRUD = { () -> VentanaPrincipalControl.mostrarVistaCliente(),
			() -> VentanaPrincipalControl.mostrarVistaDiseño(), () -> VentanaPrincipalControl.mostrarVistaMaterial(),
			() -> VentanaPrincipalControl.mostrarVistaProducto() };

	public VistaCliente() {

		this.setLayout(new BorderLayout(0, 0));
		this.setOpaque(false);
		

		this.tabla = new Tabla();

		this.contenedorVista = new ContenedorVista("CLIENTES", this.tabla);

		this.add(this.contenedorVista, BorderLayout.CENTER);
	}

}
