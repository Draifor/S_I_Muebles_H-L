package vista.componentes;

import java.awt.*;
import javax.swing.*;

public class ContenedorVista extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contenedorHeader;
	private PaginaActual paginaActual;
	private NavMenu navegacion;

	public ContenedorVista(String paginaActual, JPanel contenidoVista) {

		setLayout(new BorderLayout(0, 0));

		this.paginaActual = new PaginaActual(paginaActual);
		this.navegacion = new NavMenu();
		
		this.contenedorHeader = new JPanel();
		this.contenedorHeader.setLayout(new BorderLayout(0, 0));
		this.contenedorHeader.add(this.paginaActual, BorderLayout.NORTH);
		this.contenedorHeader.add(this.navegacion, BorderLayout.SOUTH);
		
		this.add(this.contenedorHeader, BorderLayout.NORTH);

		this.add(new JLabel("              "), BorderLayout.WEST);
		this.add(contenidoVista, BorderLayout.CENTER);		
		this.add(new JLabel("              "), BorderLayout.EAST);

	}

}
