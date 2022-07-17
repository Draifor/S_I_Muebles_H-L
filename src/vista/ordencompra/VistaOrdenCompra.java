package vista.ordencompra;

import javax.swing.*;
import java.awt.BorderLayout;

import controlador.VistaOrdenCompraControl;
import utilidades.Operacion;
import vista.componentes.*;

public class VistaOrdenCompra extends JPanel {

	private static final long serialVersionUID = 1L;
	private final Operacion[] FUNCIONES_ON_CLICK = {
			() -> VistaOrdenCompraControl.buscarOrdenCompra(),
			() -> VistaOrdenCompraControl.mostrarAgregarOrdenCompra(),
			() -> VistaOrdenCompraControl.validarModificarOrdenCompra(),
			() -> VistaOrdenCompraControl.validarEliminarOrdenCompra()
	};
	private ContenedorVista contenedorVista;
	private Tabla tabla;

	public VistaOrdenCompra() {
		setLayout(new BorderLayout(0, 0));
		setOpaque(false);

		this.construirTabla();

		this.contenedorVista = new ContenedorVista("PRODUCTOS", this.tabla, FUNCIONES_ON_CLICK);

		this.add(this.contenedorVista, BorderLayout.CENTER);
	}

	public void construirTabla() {

		String[] titulos = VistaOrdenCompraControl.obtenerTitulosColumnas();
		String[][] datos = VistaOrdenCompraControl.obtenerOrdenCompras();

		this.tabla = new Tabla(titulos, datos);

		VistaOrdenCompraControl.construirTabla(this.tabla.getTabla());
	}
	
	public void actualizarTabla() {
		String[] titulos = VistaOrdenCompraControl.obtenerTitulosColumnas();
		String[][] datos = VistaOrdenCompraControl.obtenerOrdenCompras();

		this.tabla.actualizarTabla(titulos, datos);
		VistaOrdenCompraControl.construirTabla(this.tabla.getTabla());
	}
	
	public JTable getTabla() {
		return this.tabla.getTabla();
	}
}
