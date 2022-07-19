package vista.componentes;

import java.awt.*;
import javax.swing.*;

import utilidades.Operacion;

public class ContenedorVista extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contenedorHeader;
	private JPanel contenedorPrincipal;
	private PaginaActual paginaActual;
	private NavMenu navegacion;
	private MenuCRUD menuCRUD;

	public ContenedorVista(String paginaActual, JPanel contenidoVista, Operacion[] funcionesOnClick) {

		setLayout(new BorderLayout(0, 0));
		setOpaque(false);

		this.paginaActual = new PaginaActual(paginaActual);
		this.navegacion = new NavMenu();

		this.contenedorHeader = new JPanel();
		this.contenedorHeader.setLayout(new BorderLayout(0, 0));
		this.contenedorHeader.add(this.navegacion, BorderLayout.NORTH);
		this.contenedorHeader.add(this.paginaActual, BorderLayout.SOUTH);

		this.menuCRUD = new MenuCRUD(funcionesOnClick);

		this.contenedorPrincipal = new JPanel();
		this.contenedorPrincipal.setLayout(new BorderLayout(0, 0));
		this.contenedorPrincipal.setOpaque(false);
		this.contenedorPrincipal.add(this.menuCRUD, BorderLayout.NORTH);
		this.contenedorPrincipal.add(new JLabel("              "), BorderLayout.WEST);
		this.contenedorPrincipal.add(contenidoVista, BorderLayout.CENTER);
		this.contenedorPrincipal.add(new JLabel("              "), BorderLayout.EAST);

		add(this.contenedorHeader, BorderLayout.NORTH);
		add(this.contenedorPrincipal, BorderLayout.CENTER);
	}

	public void desactivarModificar() {
		this.menuCRUD.desactivarModificar();
	}
	
	public void desactivarEliminar() {
		this.menuCRUD.desactivarEliminar();
	}
}
