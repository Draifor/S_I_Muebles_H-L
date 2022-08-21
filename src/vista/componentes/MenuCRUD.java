package vista.componentes;

import javax.swing.*;
import java.awt.FlowLayout;

import utilidades.*;

public class MenuCRUD extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String[] MENU_LABELS = { " Buscar ", "Agregar", "Modificar", " Eliminar " };
	private final String[] RUTA_IMAGENES = { "/utilidades/img/look.png", "/utilidades/img/add.png",
			"/utilidades/img/edit.png", "/utilidades/img/del.png" };
	private final int LENGTH = MENU_LABELS.length;

	private ItemCRUD[] menuCRUD;

	public MenuCRUD(Operacion[] funcionesOnClick) {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setHgap(120);

		setBackground(Color.AZUL_30.getColor());

		this.menuCRUD = new ItemCRUD[LENGTH];

		for (int i = 0; i < LENGTH; i++) {
			menuCRUD[i] = new ItemCRUD(MENU_LABELS[i], RUTA_IMAGENES[i], funcionesOnClick[i]);
			add(menuCRUD[i]);
		}
	}

	public void desactivarModificar() {
		this.menuCRUD[2].deshabilitarItem();
	}
	
	public void desactivarEliminar() {
		this.menuCRUD[3].deshabilitarItem();
	}

}
