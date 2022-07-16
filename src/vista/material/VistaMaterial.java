package vista.material;

import java.awt.BorderLayout;
import javax.swing.*;

import controlador.VistaMaterialControl;
import utilidades.Operacion;
import vista.componentes.*;

public class VistaMaterial extends JPanel {

	private static final long serialVersionUID = 1L;
	private final Operacion[] FUNCIONES_ON_CLICK = {
			() -> VistaMaterialControl.buscarMaterial(),
			() -> VistaMaterialControl.mostrarAgregarMaterial(),
			() -> VistaMaterialControl.validarModificarMaterial(),
			() -> VistaMaterialControl.validarEliminarMaterial()
	};
	private ContenedorVista contenedorVista;
	private Tabla tabla;
	
	public VistaMaterial() {
		setLayout(new BorderLayout(0, 0));
		setOpaque(false);

		this.construirTabla();

		this.contenedorVista = new ContenedorVista("MATERIALES", this.tabla, FUNCIONES_ON_CLICK);

		this.add(this.contenedorVista, BorderLayout.CENTER);
	}

	public void construirTabla() {

		String[] titulos = VistaMaterialControl.obtenerTitulosColumnas();
		String[][] datos = VistaMaterialControl.obtenerMateriales();

		this.tabla = new Tabla(titulos, datos);

		VistaMaterialControl.construirTabla(this.tabla.getTabla());
	}
	
	public void actualizarTabla() {
		String[] titulos = VistaMaterialControl.obtenerTitulosColumnas();
		String[][] datos = VistaMaterialControl.obtenerMateriales();

		this.tabla.actualizarTabla(titulos, datos);
		VistaMaterialControl.construirTabla(this.tabla.getTabla());
	}
	
	public JTable getTabla() {
		return this.tabla.getTabla();
	}
}
