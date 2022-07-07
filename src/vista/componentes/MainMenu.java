package vista.componentes;

import java.awt.GridLayout;
import javax.swing.*;
import utilidades.Color;
import java.awt.FlowLayout;

public class MainMenu extends JPanel {

	private String[] MENU_ITEMS = {"CLIENTES", "DISEÑOS", "MATERIALES", "PRODUCTOS", "ORDEN DE COMPRA", "VENTAS"};
	private int length = MENU_ITEMS.length;
	
	private JPanel contenedorMenu;
	private SeccionPanel[] menu;
	
	public MainMenu() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(30);

		this.setBackground(Color.AZUL_50.getColor());
		
		this.contenedorMenu = new JPanel();
//		this.contenedorMenu.setBackground(Color.AZUL_50.getColor());
		this.contenedorMenu.setOpaque(false);
        this.contenedorMenu.setLayout(new GridLayout(3, 2, 180, 70));
        
        this.menu = new SeccionPanel[length]; 
        for (int i = 0; i < length; i++) {
        	this.menu[i] = new SeccionPanel(MENU_ITEMS[i]);
        	this.contenedorMenu.add(menu[i]);
        }
        
        this.add(this.contenedorMenu);
	}

}
