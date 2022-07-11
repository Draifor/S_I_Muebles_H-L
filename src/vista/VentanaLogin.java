package vista;

import java.awt.*;
import javax.swing.*;
import vista.componentes.*;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private String TITULO = "LOGIN - SISTEMA DE INVENTARIOS MUEBLES H&L";
	private JPanel contenedor;
	private MainLogin contenidoPrincipal;
	private Header encabezado;
	private Footer piePagina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
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
	public VentanaLogin() {
		iniciarComponentes();
		setMinimumSize(new Dimension(650, 530));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(860, 570);
		setLocationRelativeTo(null);
		setTitle(this.TITULO);

	}

	private void iniciarComponentes() {

		this.encabezado = new Header();
		this.contenidoPrincipal = new MainLogin();
		this.piePagina = new Footer();

		this.contenedor = new JPanel();
		this.contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contenedor);
		
		this.contenedor.add(this.encabezado, BorderLayout.NORTH);
		this.contenedor.add(this.contenidoPrincipal, BorderLayout.CENTER);
		this.contenedor.add(this.piePagina, BorderLayout.SOUTH);
	}

}
