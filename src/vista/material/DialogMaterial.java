package vista.material;

import java.awt.*;
import javax.swing.*;

import controlador.DialogMaterialControl;
import utilidades.Color;
import utilidades.Operacion;
import vista.componentes.*;
import vista.componentes.Label;

public class DialogMaterial extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel contenedor;
	private JPanel contenedorPrincipal;
	private Texto titulo;
	private Label referencia;
	private CampoInput referenciaInput;
	private Label nombre;
	private CampoInput nombreInput;
	private Label costo;
	private CampoInput costoInput;
	private Label cantidad;
	private Spinner cantidadInput;
	private Boton boton1;
	private Boton boton2;
	private Boton cancelar;
	
	public DialogMaterial(JFrame ventanaPadre) {

		super(ventanaPadre, true);

		iniciarComponentes();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(650, 450);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	private void iniciarComponentes() {
		getContentPane().setLayout(new BorderLayout(0, 0));

		this.titulo = new Texto("", 1, 24);
		this.titulo.setBounds(35, 11, 396, 35);

		this.referencia = new Label("Referencia:");
		this.referencia.setBounds(36, 78, 115, 29);

		this.referenciaInput = new CampoInput("texto");
		this.referenciaInput.setBounds(183, 78, 233, 29);
		this.referenciaInput.desactivarCampo();

		this.nombre = new Label("Nombre:");
		this.nombre.setBounds(36, 133, 115, 29);

		this.nombreInput = new CampoInput("texto");
		this.nombreInput.setBounds(183, 133, 233, 29);

		this.costo = new Label("Costo: $");
		this.costo.setBounds(36, 188, 115, 29);

		this.costoInput = new CampoInput("texto");
		this.costoInput.setBounds(183, 188, 233, 29);

		this.cantidad = new Label("Cantidad:");
		this.cantidad.setBounds(36, 243, 115, 29);

		this.cantidadInput = new Spinner();
		this.cantidadInput.setBounds(183, 243, 83, 29);

		this.boton1 = new Boton("Botón 1", () -> setTitle(""));
		this.boton1.setBounds(45, 300, 105, 27);

		this.boton2 = new Boton("Botón 2", () -> setTitle(""));
		this.boton2.setBounds(178, 300, 105, 27);

		this.cancelar = new Boton("Cancelar", () -> DialogMaterialControl.ocultar());
		this.cancelar.setBounds(311, 300, 105, 27);

		this.contenedorPrincipal = new JPanel();
		this.contenedorPrincipal.setBackground(Color.AZUL_30.getColor());
		this.contenedorPrincipal.setBorder(BorderFactory.createLineBorder(Color.AZUL_100.getColor(), 2));
		this.contenedorPrincipal.setPreferredSize(new Dimension(450, 360));
		this.contenedorPrincipal.setLayout(null);
		this.contenedorPrincipal.add(this.titulo);
		this.contenedorPrincipal.add(this.referencia);
		this.contenedorPrincipal.add(this.referenciaInput);
		this.contenedorPrincipal.add(this.nombre);
		this.contenedorPrincipal.add(this.nombreInput);
		this.contenedorPrincipal.add(this.costo);
		this.contenedorPrincipal.add(this.costoInput);
		this.contenedorPrincipal.add(this.cantidad);
		this.contenedorPrincipal.add(this.cantidadInput);
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

	public String getCostoInput() {
		return this.costoInput.getTextInput();
	}

	public void setCostoInput(String costoInput) {
		this.costoInput.setTextInput(costoInput);
		;
	}

	public int getCantidadInput() {
		return this.cantidadInput.getValor();
	}

	public void setCantidadInput(int cantidadInput) {
		this.cantidadInput.setValue(cantidadInput);
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
		this.boton1.setBounds(96, 300, 105, 27);
		this.cancelar.setBounds(258, 300, 105, 27);
	}

	public void mostrarBoton2() {
		this.boton1.setBounds(45, 300, 105, 27);
		this.boton2.setBounds(178, 300, 105, 27);
		this.boton2.setVisible(true);
		this.cancelar.setBounds(311, 300, 105, 27);
	}

	public void desactivarCampos() {
		this.nombreInput.desactivarCampo();
		this.costoInput.desactivarCampo();
		this.cantidadInput.setEnabled(false);
	}

	public void activarCampos() {
		this.nombreInput.activarCampo();
		this.costoInput.activarCampo();
		this.cantidadInput.setEnabled(true);
	}

	public void codigoPorDefecto() {
		this.referenciaInput.setTextInput("Generado automáticamente");
		this.referenciaInput.modificarFuente(new Font("Times New Roman", 2, 15));
	}
}
