package controlador;

import vista.cliente.DialogCliente;
import modelo.vo.ClienteVo;
import utilidades.*;

public class DialogClienteControl {

	private static DialogCliente ventana = VentanaPrincipalControl.getClienteDialog();

	public static void mostrar(String titulo, Operacion onClick) {
		DialogClienteControl.ventana.setTitulo(titulo);
		DialogClienteControl.ventana.setOnClickBoton1(onClick);
		DialogClienteControl.ventana.setVisible(true);
	}

	public static void ocultar() {
		DialogClienteControl.ventana.setVisible(false);
	}

	public static ClienteVo getDatosCliente() {
		ClienteVo cliente = null;

		String identificacion = DialogClienteControl.ventana.getIdentificacionInput().trim();

		if (MetodosAuxiliares.esNumeroDouble(identificacion)) {
			String celular = DialogClienteControl.ventana.getCelularInput().trim();

			if (MetodosAuxiliares.esNumeroInt(celular)) {
				String codigo = DialogClienteControl.ventana.getCodigoInput();
				String nombre = DialogClienteControl.ventana.getNombreInput().trim();
				String apellido = DialogClienteControl.ventana.getApellidoInput().trim();
				String direccion = DialogClienteControl.ventana.getDireccionInput().trim();
				if (!codigo.equals("Generado automáticamente")) {
					cliente = new ClienteVo(codigo, nombre, apellido, identificacion, celular, direccion);
				} else {
					cliente = new ClienteVo(nombre, apellido, identificacion, celular, direccion);
				}
			} else {
				VentanaPrincipalControl.dialogoAlerta(
						"¡Debe escribir el número de celular sin caracteres especiales ni espacios!", "Advertencia");
			}
		} else {

			VentanaPrincipalControl.dialogoAlerta("¡El número de identificacion no es válido!", "Advertencia");
		}
		return cliente;
	}

	public static void setDatosCliente(ClienteVo cliente) {
		DialogClienteControl.ventana.setCodigoInput(cliente.getCodigo());
		DialogClienteControl.ventana.setNombreInput(cliente.getNombre());
		DialogClienteControl.ventana.setApellidoInput(cliente.getApellido());
		DialogClienteControl.ventana.setIdentificacionInput(cliente.getIdentificacion() + "");
		DialogClienteControl.ventana.setCelularInput(cliente.getCelular());
		DialogClienteControl.ventana.setDireccionInput(cliente.getDireccion());
	}

	public static void limpiarDatos() {
		DialogClienteControl.ventana.setCodigoInput("");
		DialogClienteControl.ventana.setNombreInput("");
		DialogClienteControl.ventana.setApellidoInput("");
		DialogClienteControl.ventana.setIdentificacionInput("");
		DialogClienteControl.ventana.setCelularInput("");
		DialogClienteControl.ventana.setDireccionInput("");
	}

	public static void mostrarCodigoPorDefecto() {
		DialogClienteControl.ventana.codigoPorDefecto();
	}

	public static void cambiarTextoPrimerBoton(String textoBoton) {
		DialogClienteControl.ventana.setTextoBoton1(textoBoton);
	}

	public static void cambiarTextoSegundoBoton(String textoBoton) {
		DialogClienteControl.ventana.setTextoBoton2(textoBoton);
	}

	public static void cambiarOnClickSegundoBoton(Operacion onClick) {
		DialogClienteControl.ventana.setOnClickBoton2(onClick);
	}

	public static void activarCampos() {
		DialogClienteControl.ventana.activarCampos();
	}

	public static void desactivarCampos() {
		DialogClienteControl.ventana.desactivarCampos();
	}

	public static void ocultarSegundoBoton() {
		DialogClienteControl.ventana.ocultarBoton2();
	}

	public static void mostrarSegundoBoton() {
		DialogClienteControl.ventana.mostrarBoton2();
	}
}
