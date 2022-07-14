package vista.componentes;

import java.awt.FlowLayout;
import javax.swing.JPanel;

import controlador.*;
import utilidades.Operacion;

public class SesionUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private Texto lblUsuario;
	private Boton btnCerrarSesion;
	private Operacion onClick;

	public SesionUsuario() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setHgap(20);
		flowLayout.setVgap(0);

		setOpaque(false);

		this.lblUsuario = new Texto("PEPITO PÉREZ", 1, 18);

		this.onClick = () -> VentanaPrincipalControl.cerrarSesion();
		this.btnCerrarSesion = new Boton("Cerrar Sesión", this.onClick);

		add(this.lblUsuario);
		add(this.btnCerrarSesion);
	}

}
