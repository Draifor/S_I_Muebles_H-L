package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import vista.componentes.*;

public class VentanaPrincipal extends JFrame {

	private String TITULO = "SISTEMA DE INVENTARIOS MUEBLES H&L";
	private JPanel contenedor;
	private Header encabezado;
	private ContenedorPrincipal contenedorPrincipal;

	/**
	 * Launch the application.
	 */
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
		setMinimumSize(new Dimension(650, 530));
		setSize(860, 570);
		setLocationRelativeTo(null);
		setTitle(this.TITULO);
	}

	private void iniciarComponentes() {

		this.encabezado = new Header();
		this.contenedorPrincipal = new ContenedorPrincipal();

		this.contenedor = new JPanel();
		this.contenedor.setLayout(new BorderLayout(0, 0));
		this.setContentPane(contenedor);
		this.contenedor.add(this.encabezado, BorderLayout.NORTH);
		this.contenedor.add(this.contenedorPrincipal, BorderLayout.CENTER);
	}

}

