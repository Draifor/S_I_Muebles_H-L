package vista.producto;

import java.awt.BorderLayout;
import javax.swing.*;

import controlador.VistaProductoControl;
import utilidades.Operacion;
import vista.componentes.*;

public class VistaProducto extends JPanel {

	private static final long serialVersionUID = 1L;
	private final Operacion[] FUNCIONES_ON_CLICK = {
			() -> VistaProductoControl.buscarProducto(),
			() -> VistaProductoControl.mostrarAgregarProducto(),
			() -> VistaProductoControl.validarModificarProducto(),
			() -> VistaProductoControl.validarEliminarProducto()
	};
	private ContenedorVista contenedorVista;
	private Tabla tabla;
	
	public VistaProducto() {
		setLayout(new BorderLayout(0, 0));
		setOpaque(false);

		this.construirTabla();

		this.contenedorVista = new ContenedorVista("PRODUCTOS", this.tabla, FUNCIONES_ON_CLICK);

		this.add(this.contenedorVista, BorderLayout.CENTER);
	}

	public void construirTabla() {

		String[] titulos = VistaProductoControl.obtenerTitulosColumnas();
		String[][] datos = VistaProductoControl.obtenerProductos();

		this.tabla = new Tabla(titulos, datos);

		VistaProductoControl.construirTabla(this.tabla.getTabla());
	}
	
	public void actualizarTabla() {
		String[] titulos = VistaProductoControl.obtenerTitulosColumnas();
		String[][] datos = VistaProductoControl.obtenerProductos();

		this.tabla.actualizarTabla(titulos, datos);
		VistaProductoControl.construirTabla(this.tabla.getTabla());
	}
	
	public JTable getTabla() {
		return this.tabla.getTabla();
	}
}
