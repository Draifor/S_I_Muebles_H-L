package vista.cliente;

import java.awt.*;
import javax.swing.*;

import controlador.DialogClienteControl;
import vista.componentes.*;
import vista.componentes.Label;
import utilidades.Color;
import utilidades.Operacion;

public class DialogCliente extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel contenedor;
	private JPanel contenedorPrincipal;
	private Texto titulo;
	private Label codigo;
	private CampoInput codigoInput;
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
	private Boton boton1;
	private Boton boton2;
	private Boton cancelar;

	public DialogCliente(JFrame ventanaPadre) {

		super(ventanaPadre, true);

		iniciarComponentes();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(650, 560);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void iniciarComponentes() {
		getContentPane().setLayout(new BorderLayout(0, 0));

		this.titulo = new Texto("", 1, 24);
		this.titulo.setBounds(2, 11, 396, 35);

		this.codigo = new Label("Código:");
		this.codigo.setBounds(36, 78, 115, 29);

		this.codigoInput = new CampoInput("texto");
		this.codigoInput.setBounds(183, 78, 233, 29);
		this.codigoInput.desactivarCampo();

		this.nombre = new Label("Nombre:");
		this.nombre.setBounds(36, 133, 115, 29);

		this.nombreInput = new CampoInput("texto");
		this.nombreInput.setBounds(183, 133, 233, 29);

		this.apellido = new Label("Apellido:");
		this.apellido.setBounds(36, 188, 115, 29);

		this.apellidoInput = new CampoInput("texto");
		this.apellidoInput.setBounds(183, 188, 233, 29);

		this.identificacion = new Label("Identificación:");
		this.identificacion.setBounds(36, 243, 115, 29);

		this.identificacionInput = new CampoInput("texto");
		this.identificacionInput.setBounds(183, 243, 233, 29);

		this.celular = new Label("Celular:");
		this.celular.setBounds(36, 298, 115, 29);

		this.celularInput = new CampoInput("texto");
		this.celularInput.setBounds(183, 298, 233, 29);

		this.direccion = new Label("Dirección:");
		this.direccion.setBounds(36, 353, 115, 29);

		this.direccionInput = new CampoInput("texto");
		this.direccionInput.setBounds(183, 353, 233, 29);

		this.boton1 = new Boton("Botón 1", () -> setTitle(""));
		this.boton1.setBounds(45, 405, 105, 27);

		this.boton2 = new Boton("Botón 2", () -> setTitle(""));
		this.boton2.setBounds(178, 405, 105, 27);

		this.cancelar = new Boton("Cancelar", () -> DialogClienteControl.ocultar());
		this.cancelar.setBounds(311, 405, 105, 27);

		this.contenedorPrincipal = new JPanel();
		this.contenedorPrincipal.setBackground(Color.AZUL_30.getColor());
		this.contenedorPrincipal.setBorder(BorderFactory.createLineBorder(Color.AZUL_100.getColor(), 2));
		this.contenedorPrincipal.setPreferredSize(new Dimension(450, 460));
		this.contenedorPrincipal.setLayout(null);
		this.contenedorPrincipal.add(this.titulo);
		this.contenedorPrincipal.add(this.codigo);
		this.contenedorPrincipal.add(this.codigoInput);
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
		this.contenedorPrincipal.add(this.boton1);
		this.contenedorPrincipal.add(this.boton2);
		this.contenedorPrincipal.add(this.cancelar);

		this.contenedor = new JPanel();
		this.contenedor.setBackground(Color.AZUL_50.getColor());
		this.contenedor.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
		this.contenedor.add(this.contenedorPrincipal);

		getContentPane().add(this.contenedor);
	}

	public void mensajeDialogo(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, new Texto(mensaje, 0, 18), titulo, JOptionPane.PLAIN_MESSAGE);
	}

	public String getCodigoInput() {
		return this.codigoInput.getTextInput();
	}

	public void setCodigoInput(String codigo) {
		this.codigoInput.setTextInput(codigo);
	}

	public String getNombreInput() {
		return this.nombreInput.getTextInput();
	}

	public void setNombreInput(String nombreInput) {
		this.nombreInput.setTextInput(nombreInput);
	}

	public String getApellidoInput() {
		return this.apellidoInput.getTextInput();
	}

	public void setApellidoInput(String apellidoInput) {
		this.apellidoInput.setTextInput(apellidoInput);
		;
	}

	public String getIdentificacionInput() {
		return this.identificacionInput.getTextInput();
	}

	public void setIdentificacionInput(String identificacionInput) {
		this.identificacionInput.setTextInput(identificacionInput);
		;
	}

	public String getCelularInput() {
		return this.celularInput.getTextInput();
	}

	public void setCelularInput(String celularInput) {
		this.celularInput.setTextInput(celularInput);
		;
	}

	public String getDireccionInput() {
		return this.direccionInput.getTextInput();
	}

	public void setDireccionInput(String direccionInput) {
		this.direccionInput.setTextInput(direccionInput);
		;
	}

	public void setTitulo(String nombreVentana) {
		setTitle(nombreVentana);
		this.titulo.setText(nombreVentana);
	}

	public void setTextoBoton1(String textoBoton) {
		this.boton1.setTextoBoton(textoBoton);
	}

	public void setOnClickBoton1(Operacion onClick) {
		this.boton1.setOnClick(onClick);
	}

	public void setTextoBoton2(String textoBoton) {
		this.boton2.setTextoBoton(textoBoton);
	}

	public void setOnClickBoton2(Operacion onClick) {
		this.boton2.setOnClick(onClick);
	}

	public void ocultarBoton2() {
		this.boton2.setVisible(false);
		this.boton1.setBounds(96, 405, 105, 27);
		this.cancelar.setBounds(258, 405, 105, 27);
	}

	public void mostrarBoton2() {
		this.boton1.setBounds(45, 405, 105, 27);
		this.boton2.setBounds(178, 405, 105, 27);
		this.boton2.setVisible(true);
		this.cancelar.setBounds(311, 405, 105, 27);
	}

	public void desactivarCampos() {
		this.nombreInput.desactivarCampo();
		this.apellidoInput.desactivarCampo();
		this.identificacionInput.desactivarCampo();
		this.celularInput.desactivarCampo();
		this.direccionInput.desactivarCampo();
	}

	public void activarCampos() {
		this.nombreInput.activarCampo();
		this.apellidoInput.activarCampo();
		this.identificacionInput.activarCampo();
		this.celularInput.activarCampo();
		this.direccionInput.activarCampo();
	}

	public void codigoPorDefecto() {
		this.codigoInput.setTextInput("Generado automáticamente");
		this.codigoInput.modificarFuente(new Font("Times New Roman", 2, 15));
	}
}
