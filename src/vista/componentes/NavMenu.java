package vista.componentes;

import javax.swing.JPanel;
import controlador.*;
import utilidades.Color;

public class NavMenu extends JPanel {

	private String[] OPCIONES_MENU = { "Inicio", "Clientes", "Diseños", "Materiales", "Productos", "Ventas",
			"Orden de Compra" };
	private Operacion[] FUNCIONES_ON_CLICK = { () -> VistaMenuControl.mostrarVistaMenu(),
			() -> VistaMenuControl.mostrarVistaCliente(), () -> VistaMenuControl.mostrarVistaDiseño(),
			() -> VistaMenuControl.mostrarVistaMaterial(), () -> VistaMenuControl.mostrarVistaProducto(),
			() -> VistaMenuControl.mostrarVistaOrdenCompra(), () -> VistaMenuControl.mostrarVistaVenta() };
	private int length = OPCIONES_MENU.length;

	private ItemNav[] menu;

	public NavMenu() {

		this.setBackground(Color.AZUL_30.getColor());

		this.menu = new ItemNav[length];
		for (int i = 0; i < length; i++) {
			this.add(new ItemNav(OPCIONES_MENU[i], FUNCIONES_ON_CLICK[i]));
		}
	}

}
