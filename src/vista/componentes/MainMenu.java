package vista.componentes;

import java.awt.*;
import javax.swing.*;
import utilidades.Color;
import controlador.*;

public class MainMenu extends JPanel {

	private String[] MENU_ITEMS = { "CLIENTES", "DISEÑOS", "MATERIALES", "PRODUCTOS", "ORDEN DE COMPRA", "VENTAS" };
	private Operacion[] FUNCIONES_ON_CLICK = { () -> VentanaPrincipalControl.mostrarVistaCliente(),
			() -> VentanaPrincipalControl.mostrarVistaDiseño(), () -> VentanaPrincipalControl.mostrarVistaMaterial(),
			() -> VentanaPrincipalControl.mostrarVistaProducto(), () -> VentanaPrincipalControl.mostrarVistaOrdenCompra(),
			() -> VentanaPrincipalControl.mostrarVistaVenta() };
	private int length = MENU_ITEMS.length;

	private JPanel contenedorMenu;
	private SeccionPanel[] menu;

	public MainMenu() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(30);

		this.setBackground(Color.AZUL_50.getColor());
		this.setBorder(BorderFactory.createLineBorder(Color.AZUL_100.getColor(), 1));

		this.contenedorMenu = new JPanel();
//		this.contenedorMenu.setBackground(Color.AZUL_50.getColor());
		this.contenedorMenu.setOpaque(false);
		this.contenedorMenu.setLayout(new GridLayout(3, 2, 180, 70));

		this.menu = new SeccionPanel[length];
		for (int i = 0; i < length; i++) {
			this.contenedorMenu.add(new SeccionPanel(MENU_ITEMS[i], FUNCIONES_ON_CLICK[i]));
		}

		this.add(this.contenedorMenu);
	}

}
