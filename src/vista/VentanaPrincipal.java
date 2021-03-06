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

	public VentanaPrincipal() {
		iniciarComponentes();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1150, 730);
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

	public void dialogoAlerta(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, new Texto(mensaje, 0, 18), titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public int dialogoConfirmacion(String mensaje, String titulo) {
		int opcionElegida = JOptionPane.showConfirmDialog(this, new Texto(mensaje, 0, 15), titulo,
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		return opcionElegida;
	}

	public String dialogoInput(String mensaje, String titulo) {
		String usuarioInput = JOptionPane.showInputDialog(this, new Texto(mensaje, 0, 15), titulo,
				JOptionPane.PLAIN_MESSAGE);
		return usuarioInput;
	}
}
