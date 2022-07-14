package vista.componentes;

import java.awt.FlowLayout;
import javax.swing.JPanel;

import controlador.*;
import utilidades.*;

public class NavMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	private String[] OPCIONES_MENU = { "Inicio", "Clientes", "Diseños", "Materiales", "Productos", "Ventas",
			"Orden de Compra" };
	private Operacion[] FUNCIONES_ON_CLICK = { 
			() -> VentanaPrincipalControl.mostrarVistaMenu(),
			() -> VentanaPrincipalControl.mostrarVistaCliente(),
			() -> VentanaPrincipalControl.mostrarVistaDiseño(),
			() -> VentanaPrincipalControl.mostrarVistaMaterial(),
			() -> VentanaPrincipalControl.mostrarVistaProducto(),
			() -> VentanaPrincipalControl.mostrarVistaOrdenCompra(),
			() -> VentanaPrincipalControl.mostrarVistaVenta()
	};
	private int length = OPCIONES_MENU.length;

	private SesionUsuario sesionUsuario;

	public NavMenu() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setHgap(30);
		flowLayout.setVgap(3);

		setBackground(Color.AZUL_30.getColor());

		for (int i = 0; i < length; i++) {
			add(new ItemNav(OPCIONES_MENU[i], FUNCIONES_ON_CLICK[i]));
		}

		this.sesionUsuario = new SesionUsuario();
		add(this.sesionUsuario);

	}

}
