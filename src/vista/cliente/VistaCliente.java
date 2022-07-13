package vista.cliente;

import java.awt.BorderLayout;
import javax.swing.*;

import controlador.*;
import vista.componentes.*;

public class VistaCliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private ContenedorVista contenedorVista;
	private Tabla tabla;
	public VistaCliente() {

		setLayout(new BorderLayout(0, 0));
		setOpaque(false);

		this.construirTabla();

		this.contenedorVista = new ContenedorVista("CLIENTES", this.tabla);

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
	
	public String obtenerClienteSeleccionado() {
		String resultadoOperacion = VistaClienteControl.obtenerClienteSeleccionado(this.tabla.getTabla());
		
		if (resultadoOperacion.equals("error")) {
			this.mostrarAlerta("Selecciona el cliente a modificar", "Modificar Cliente");
			return "error";
		} else {
			return "mostrar";
		}
	}
	
	public void mostrarAlerta(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, new Texto("Selecciona el cliente a modificar", 0,18), "Modificar Cliente", JOptionPane.PLAIN_MESSAGE);
	}
}
