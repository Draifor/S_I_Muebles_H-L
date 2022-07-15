package vista.cliente;

import java.awt.BorderLayout;
import javax.swing.*;

import controlador.*;
import utilidades.Operacion;
import vista.componentes.*;

public class VistaCliente extends JPanel {

	private static final long serialVersionUID = 1L;

	private final Operacion[] FUNCIONES_ON_CLICK = {
			() -> VistaClienteControl.buscarCliente(),
			() -> VistaClienteControl.mostrarAgregarCliente(),
			() -> VistaClienteControl.validarClienteModificar(),
			() -> VistaClienteControl.validarClienteEliminar()
	};
	private ContenedorVista contenedorVista;
	private Tabla tabla;

	public VistaCliente() {

		setLayout(new BorderLayout(0, 0));
		setOpaque(false);

		this.construirTabla();

		this.contenedorVista = new ContenedorVista("CLIENTES", this.tabla, FUNCIONES_ON_CLICK);

		this.add(this.contenedorVista, BorderLayout.CENTER);
	}

	public void construirTabla() {

		String[] titulos = VistaClienteControl.obtenerTitulosColumnas();
		String[][] datos = VistaClienteControl.obtenerClientes();

		this.tabla = new Tabla(titulos, datos);

		VistaClienteControl.construirTabla(this.tabla.getTabla());
	}

	public void actualizarTabla() {
		String[] titulos = VistaClienteControl.obtenerTitulosColumnas();
		String[][] datos = VistaClienteControl.obtenerClientes();

		this.tabla.actualizarTabla(titulos, datos);
		VistaClienteControl.construirTabla(this.tabla.getTabla());
	}

	public JTable getTabla() {
		return this.tabla.getTabla();
	}
}
