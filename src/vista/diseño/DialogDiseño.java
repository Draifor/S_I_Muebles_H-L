package vista.diseño;

import java.awt.*;
import javax.swing.*;

import controlador.DialogDiseñoControl;
import utilidades.Color;
import utilidades.Operacion;
import vista.componentes.*;
import vista.componentes.Label;

public class DialogDiseño extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel contenedor;
	private JPanel contenedorPrincipal;
	private Texto titulo;
	private Label codigo;
	private CampoInput codigoInput;
	private Label referencia;
	private CampoInput referenciaInput;
	private Label nombre;
	private CampoInput nombreInput;
	private Label tipo;
	private CampoInput tipoInput;
	private Label imagen;
	private CampoInput imagenInput;
	private Boton boton1;
	private Boton boton2;
	private Boton cancelar;

	public DialogDiseño(JFrame ventanaPadre) {

		super(ventanaPadre, true);

		iniciarComponentes();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(650, 500);
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

		this.referencia = new Label("Referencia:");
		this.referencia.setBounds(36, 133, 115, 29);

		this.referenciaInput = new CampoInput("texto");
		this.referenciaInput.setBounds(183, 133, 233, 29);

		this.nombre = new Label("Nombre:");
		this.nombre.setBounds(36, 188, 115, 29);

		this.nombreInput = new CampoInput("texto");
		this.nombreInput.setBounds(183, 188, 233, 29);

		this.tipo = new Label("Tipo:");
		this.tipo.setBounds(36, 243, 115, 29);

		this.tipoInput = new CampoInput("texto");
		this.tipoInput.setBounds(183, 243, 233, 29);

		this.imagen = new Label("Imagen:");
		this.imagen.setBounds(36, 298, 115, 29);

		this.imagenInput = new CampoInput("texto");
		this.imagenInput.setBounds(183, 298, 233, 29);

		this.boton1 = new Boton("Botón 1", () -> setTitle(""));
		this.boton1.setBounds(45, 355, 105, 27);

		this.boton2 = new Boton("Botón 2", () -> setTitle(""));
		this.boton2.setBounds(178, 355, 105, 27);

		this.cancelar = new Boton("Cancelar", () -> DialogDiseñoControl.ocultar());
		this.cancelar.setBounds(311, 355, 105, 27);

		this.contenedorPrincipal = new JPanel();
		this.contenedorPrincipal.setBackground(Color.AZUL_30.getColor());
		this.contenedorPrincipal.setBorder(BorderFactory.createLineBorder(Color.AZUL_100.getColor(), 2));
		this.contenedorPrincipal.setPreferredSize(new Dimension(450, 410));
		this.contenedorPrincipal.setLayout(null);
		this.contenedorPrincipal.add(this.titulo);
		this.contenedorPrincipal.add(this.codigo);
		this.contenedorPrincipal.add(this.codigoInput);
		this.contenedorPrincipal.add(this.referencia);
		this.contenedorPrincipal.add(this.referenciaInput);
		this.contenedorPrincipal.add(this.nombre);
		this.contenedorPrincipal.add(this.nombreInput);
		this.contenedorPrincipal.add(this.tipo);
		this.contenedorPrincipal.add(this.tipoInput);
		this.contenedorPrincipal.add(this.imagen);
		this.contenedorPrincipal.add(this.imagenInput);
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

	public String getReferenciaInput() {
		return this.referenciaInput.getTextInput();
	}

	public void setReferenciaInput(String ReferenciaInput) {
		this.referenciaInput.setTextInput(ReferenciaInput);
	}
	
	public String getNombreInput() {
		return this.nombreInput.getTextInput();
	}
	
	public void setNombreInput(String nombreInput) {
		this.nombreInput.setTextInput(nombreInput);
		;
	}

	public String getTipoInput() {
		return this.tipoInput.getTextInput();
	}

	public void setTipoInput(String tipoInput) {
		this.tipoInput.setTextInput(tipoInput);
		;
	}

	public String getImagenInput() {
		return this.imagenInput.getTextInput();
	}

	public void setImagenInput(String ImagenInput) {
		this.imagenInput.setTextInput(ImagenInput);
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
		this.boton1.setBounds(96, 355, 105, 27);
		this.cancelar.setBounds(258, 355, 105, 27);
	}

	public void mostrarBoton2() {
		this.boton1.setBounds(45, 355, 105, 27);
		this.boton2.setBounds(178, 355, 105, 27);
		this.boton2.setVisible(true);
		this.cancelar.setBounds(311, 355, 105, 27);
	}

	public void desactivarCampos() {
		this.referenciaInput.desactivarCampo();
		this.nombreInput.desactivarCampo();
		this.tipoInput.desactivarCampo();
		this.imagenInput.desactivarCampo();
	}

	public void activarCampos() {
		this.referenciaInput.activarCampo();
		this.nombreInput.activarCampo();
		this.tipoInput.activarCampo();
		this.imagenInput.activarCampo();
	}

	public void codigoPorDefecto() {
		this.codigoInput.setTextInput("Generado automáticamente");
		this.codigoInput.modificarFuente(new Font("Times New Roman", 2, 15));
	}
}
