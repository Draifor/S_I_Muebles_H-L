package vista;

import java.awt.BorderLayout;
import javax.swing.*;
import utilidades.Color;
import vista.componentes.*;

public class VistaMenu extends JPanel {

	private PaginaActual paginaActual;
	private Aside aside;
	private MainMenu menuPricipal;
//	private CentrarContenido contenedorCentrar;

	public VistaMenu() {
		
		this.setLayout(new BorderLayout(0, 0));
		
		this.paginaActual = new PaginaActual("INVENTARIOS");
		
		this.aside = new Aside();
//		this.contenedorCentrar = new CentrarContenido(this.aside, Color.AZUL_70.getColor());
		
		this.menuPricipal = new MainMenu();
		
		this.add(this.paginaActual, BorderLayout.NORTH);
//		this.add(this.contenedorCentrar, BorderLayout.WEST);
		this.add(this.aside, BorderLayout.WEST);
		this.add(this.menuPricipal, BorderLayout.CENTER);
	}

}
