package vista.componentes;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

import utilidades.Color;
import utilidades.Operacion;
import controlador.*;

public class MainMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	private String[] MENU_ITEMS = { "CLIENTES", "DISEÑOS", "MATERIALES", "PRODUCTOS", "ORDEN DE COMPRA", "VENTAS" };
	private Operacion[] FUNCIONES_ON_CLICK = {
			() -> VentanaPrincipalControl.mostrarVistaCliente(),
			() -> VentanaPrincipalControl.mostrarVistaDiseño(),
			() -> VentanaPrincipalControl.mostrarVistaMaterial(),
			() -> VentanaPrincipalControl.mostrarVistaProducto(),
			() -> VentanaPrincipalControl.mostrarVistaOrdenCompra(),
			() -> VentanaPrincipalControl.mostrarVistaVenta() 
	};
	private int length = MENU_ITEMS.length;

	private JPanel contenedorMenu;

	public MainMenu() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(30);

		this.setBackground(Color.AZUL_50.getColor());
		setBorder(new MatteBorder(0, 1, 1, 1, Color.AZUL_100.getColor()));

		this.contenedorMenu = new JPanel();
		this.contenedorMenu.setOpaque(false);
		this.contenedorMenu.setLayout(new GridLayout(3, 2, 180, 70));

		for (int i = 0; i < length; i++) {
			this.contenedorMenu.add(new SeccionPanel(MENU_ITEMS[i], FUNCIONES_ON_CLICK[i]));
		}

		this.add(this.contenedorMenu);
	}

}
