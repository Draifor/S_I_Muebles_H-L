package vista.diseño;

import java.awt.BorderLayout;
import javax.swing.*;

import controlador.VistaDiseñoControl;
import utilidades.Operacion;
import vista.componentes.*;

public class VistaDiseño extends JPanel {

	private static final long serialVersionUID = 1L;
	private final Operacion[] FUNCIONES_ON_CLICK = {
			() -> VistaDiseñoControl.buscarDiseño(),
			() -> VistaDiseñoControl.mostrarAgregarDiseño(),
			() -> VistaDiseñoControl.validarDiseñoModificar(),
			() -> VistaDiseñoControl.validarDiseñoEliminar()
	};
	private ContenedorVista contenedorVista;
	private Tabla tabla;

	public VistaDiseño() {

		setLayout(new BorderLayout(0, 0));
		setOpaque(false);

		this.construirTabla();

		this.contenedorVista = new ContenedorVista("DISEÑOS", this.tabla, FUNCIONES_ON_CLICK);

		this.add(this.contenedorVista, BorderLayout.CENTER);
	}

	public void construirTabla() {

		String[] titulos = VistaDiseñoControl.obtenerTitulosColumnas();
		String[][] datos = VistaDiseñoControl.obtenerDiseños();

		this.tabla = new Tabla(titulos, datos);

		VistaDiseñoControl.construirTabla(this.tabla.getTabla());
	}

	public void actualizarTabla() {
		String[] titulos = VistaDiseñoControl.obtenerTitulosColumnas();
		String[][] datos = VistaDiseñoControl.obtenerDiseños();

		this.tabla.actualizarTabla(titulos, datos);
		VistaDiseñoControl.construirTabla(this.tabla.getTabla());
	}

	public JTable getTabla() {
		return this.tabla.getTabla();
	}
}
