package vista;

import java.awt.BorderLayout;
import javax.swing.*;
import utilidades.Color;
import vista.componentes.*;

public class VistaMenu extends JPanel {

	private Aside aside;
	private MainMenu menuPricipal;

	public VistaMenu() {
		
		this.setLayout(new BorderLayout(0, 0));
		
		this.aside = new Aside();
		this.menuPricipal = new MainMenu();
		
		this.add(this.aside, BorderLayout.WEST);
		this.add(this.menuPricipal, BorderLayout.CENTER);
	}

}
