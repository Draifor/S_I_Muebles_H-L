package vista;

import java.awt.BorderLayout;
import javax.swing.*;
import vista.componentes.*;

public class VistaMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	private PaginaActual paginaActual;
	private Aside aside;
	private MainMenu menuPricipal;

	public VistaMenu() {
		
		this.setLayout(new BorderLayout(0, 0));

		this.paginaActual = new PaginaActual("INVENTARIOS");
		this.aside = new Aside();
		this.menuPricipal = new MainMenu();

		this.add(this.paginaActual, BorderLayout.NORTH);
		this.add(this.aside, BorderLayout.WEST);
		this.add(this.menuPricipal, BorderLayout.CENTER);
	}

}
