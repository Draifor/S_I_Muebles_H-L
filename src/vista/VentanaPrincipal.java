package vista;

import java.awt.*;
import javax.swing.*;
import utilidades.Color;
import vista.componentes.*;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private String TITULO = "SISTEMA DE INVENTARIOS MUEBLES H&L";
	private JPanel contenedor;
	private JScrollPane contenidoPrincipal;
	private Header encabezado;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		iniciarComponentes();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100, 727);
		setMinimumSize(new Dimension(860, 630));
		setLocationRelativeTo(null);
		setTitle(this.TITULO);
	}

	private void iniciarComponentes() {

		this.contenedor = new JPanel();
		this.contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contenedor);

		this.encabezado = new Header();

		this.contenidoPrincipal = new JScrollPane();
		this.contenidoPrincipal.getViewport().setBackground(Color.AZUL_30.getColor());
		this.contenidoPrincipal.setBorder(null);

		add(this.encabezado, BorderLayout.NORTH);
		add(this.contenidoPrincipal, BorderLayout.CENTER);
	}

	public void setContenidoPrincipal(JPanel nuevoContenido, String nombrePaginaActual) {
		this.contenidoPrincipal.setViewportView(nuevoContenido);
		PaginaActual.setPaginaActual(nombrePaginaActual);
	}
}
