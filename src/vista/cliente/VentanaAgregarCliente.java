package vista.cliente;

import utilidades.Color;
import utilidades.Operacion;
import vista.componentes.Boton;
import vista.componentes.CampoInput;
import vista.componentes.Label;
import vista.componentes.Texto;

import javax.swing.*;
import java.awt.*;
import controlador.*;

public class VentanaAgregarCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private static final String TITULO = "Agregar Cliente";
	private static final Operacion ON_CLICK = () -> VentanaAgregarClienteControl.agregarCliente();

	private JPanel contenedor;
	private JPanel contenedorPrincipal;
	private Texto titulo;
	private Label nombre;
	private CampoInput nombreInput;
	private Label apellido;
	private CampoInput apellidoInput;
	private Label identificacion;
	private CampoInput identificacionInput;
	private Label celular;
	private CampoInput celularInput;
	private Label direccion;
	private CampoInput direccionInput;
	private Boton btnAgregar;

	public VentanaAgregarCliente() {

		iniciarComponentes();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(600, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(VentanaAgregarCliente.TITULO);

	}

	private void iniciarComponentes() {
		getContentPane().setLayout(new BorderLayout(0, 0));

		this.titulo = new Texto(VentanaAgregarCliente.TITULO, 1, 24);
		this.titulo.setBounds(2, 11, 396, 35);

		this.nombre = new Label("Nombre:");
		this.nombre.setBounds(36, 78, 115, 29);

		this.nombreInput = new CampoInput("texto");
		this.nombreInput.setBounds(183, 78, 183, 29);
		
		this.apellido = new Label("Apellido:");
		this.apellido.setBounds(36, 133, 115, 29);
		
		this.apellidoInput = new CampoInput("texto");
		this.apellidoInput.setBounds(183, 133, 183, 29);

		this.identificacion = new Label("Identificación:");
		this.identificacion.setBounds(36, 188, 115, 29);

		this.identificacionInput = new CampoInput("texto");
		this.identificacionInput.setBounds(183, 188, 183, 29);

		this.celular = new Label("Celular:");
		this.celular.setBounds(36, 243, 115, 29);

		this.celularInput = new CampoInput("texto");
		this.celularInput.setBounds(183, 243, 183, 29);

		this.direccion = new Label("Dirección:");
		this.direccion.setBounds(36, 298, 115, 29);

		this.direccionInput = new CampoInput("texto");
		this.direccionInput.setBounds(183, 298, 183, 29);

		this.btnAgregar = new Boton("Ingresar", VentanaAgregarCliente.ON_CLICK);
		this.btnAgregar.setBounds(156, 351, 105, 27);

		this.contenedorPrincipal = new JPanel();
		this.contenedorPrincipal.setBackground(Color.AZUL_30.getColor());
		this.contenedorPrincipal.setBorder(BorderFactory.createLineBorder(Color.AZUL_100.getColor(), 2));
		this.contenedorPrincipal.setPreferredSize(new Dimension(400, 400));
		this.contenedorPrincipal.setLayout(null);
		this.contenedorPrincipal.add(this.titulo);
		this.contenedorPrincipal.add(this.nombre);
		this.contenedorPrincipal.add(this.nombreInput);
		this.contenedorPrincipal.add(this.apellido);
		this.contenedorPrincipal.add(this.apellidoInput);
		this.contenedorPrincipal.add(this.identificacion);
		this.contenedorPrincipal.add(this.identificacionInput);
		this.contenedorPrincipal.add(this.celular);
		this.contenedorPrincipal.add(this.celularInput);
		this.contenedorPrincipal.add(this.direccion);
		this.contenedorPrincipal.add(this.direccionInput);
		this.contenedorPrincipal.add(this.btnAgregar);

		this.contenedor = new JPanel();
		this.contenedor.setBackground(Color.AZUL_50.getColor());
		this.contenedor.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
		this.contenedor.add(this.contenedorPrincipal);

		getContentPane().add(this.contenedor);

	}

	public String getNombreInput() {
		return this.nombreInput.getTextInput();
	}
	
	public String getApellidoInput() {
		return this.apellidoInput.getTextInput();
	}

	public String getIdentificacionInput() {
		return this.identificacionInput.getTextInput();
	}

	public String getCelularInput() {
		return this.celularInput.getTextInput();
	}

	public String getDireccionInput() {
		return this.direccionInput.getTextInput();
	}

}
