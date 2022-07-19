package vista.venta;

import javax.swing.*;
import java.awt.BorderLayout;

import controlador.VistaVentaControl;
import utilidades.Operacion;
import vista.componentes.*;

public class VistaVenta extends JPanel {

	private static final long serialVersionUID = 1L;

		private final Operacion[] FUNCIONES_ON_CLICK = {
				() -> VistaVentaControl.buscarVenta(),
				() -> VistaVentaControl.mostrarAgregarVenta(),
				() -> VistaVentaControl.validarModificarVenta(),
				() -> VistaVentaControl.validarEliminarVenta()
		};
		private ContenedorVista contenedorVista;
		private Tabla tabla;

		public VistaVenta() {
			setLayout(new BorderLayout(0, 0));
			setOpaque(false);

			this.construirTabla();

			this.contenedorVista = new ContenedorVista("VENTAS", this.tabla, FUNCIONES_ON_CLICK);
			this.contenedorVista.desactivarModificar();
			this.contenedorVista.desactivarEliminar();
			
			this.add(this.contenedorVista, BorderLayout.CENTER);
		}

		public void construirTabla() {

			String[] titulos = VistaVentaControl.obtenerTitulosColumnas();
			String[][] datos = VistaVentaControl.obtenerVentas();

			this.tabla = new Tabla(titulos, datos);

			VistaVentaControl.construirTabla(this.tabla.getTabla());
		}
		
		public void actualizarTabla() {
			String[] titulos = VistaVentaControl.obtenerTitulosColumnas();
			String[][] datos = VistaVentaControl.obtenerVentas();

			this.tabla.actualizarTabla(titulos, datos);
			VistaVentaControl.construirTabla(this.tabla.getTabla());
		}
		
		public JTable getTabla() {
			return this.tabla.getTabla();
		}
	}
