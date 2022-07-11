package vista.componentes;

import javax.swing.*;
import java.awt.FlowLayout;

import controlador.*;
import utilidades.Color;
import utilidades.Operacion;

public class MenuCRUD extends JPanel {

	private static final long serialVersionUID = 1L;
	private String[] MENU_LABELS = { " Buscar ", "Agregar", "Modificar", " Eliminar " };
	private String[] RUTA_IMAGENES = {"/utilidades/img/look.png", "/utilidades/img/add.png", "/utilidades/img/edit.png", "/utilidades/img/del.png"};
	private Operacion[] FUNCIONES_ON_CLICK = { () -> VentanaPrincipalControl.mostrarVistaCliente(),
			() -> VentanaAgregarClienteControl.mostrar(), () -> VentanaPrincipalControl.mostrarVistaMaterial(),
			() -> VentanaPrincipalControl.mostrarVistaProducto() };
	private int length = MENU_LABELS.length;
	
	private ItemCRUD[] menuCRUD;

	public MenuCRUD() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setHgap(120);
		
//		setOpaque(false);
		setBackground(Color.AZUL_30.getColor());

		this.menuCRUD = new ItemCRUD[length];
		
		for (int i = 0; i < length; i++) {
			menuCRUD[i] = new ItemCRUD(MENU_LABELS[i], RUTA_IMAGENES[i],FUNCIONES_ON_CLICK[i]);
			add(menuCRUD[i]);
		}
	}

}
