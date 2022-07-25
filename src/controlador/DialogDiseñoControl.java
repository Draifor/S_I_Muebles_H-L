package controlador;

import vista.diseño.DialogDiseño;
import modelo.vo.DiseñoVo;
import utilidades.*;

public class DialogDiseñoControl {
	private static DialogDiseño ventana = VentanaPrincipalControl.getDiseñoDialog();

	public static void mostrar(String titulo, Operacion onClick) {
		DialogDiseñoControl.ventana.setTitulo(titulo);
		DialogDiseñoControl.ventana.setOnClickBoton1(onClick);
		DialogDiseñoControl.ventana.setVisible(true);
	}

	public static void ocultar() {
		DialogDiseñoControl.ventana.setVisible(false);
	}

	public static DiseñoVo getDatosDiseño() {
		String referencia = DialogDiseñoControl.ventana.getReferenciaInput();
		String nombre = DialogDiseñoControl.ventana.getNombreInput().trim();
		String tipo = DialogDiseñoControl.ventana.getTipoInput().trim();
		String urlImagen = DialogDiseñoControl.ventana.getImagenInput().trim();

		DiseñoVo diseño;

		if (!referencia.equals("Generado automáticamente")) {
			diseño = new DiseñoVo(referencia, nombre, tipo, urlImagen);
		} else {
			diseño = new DiseñoVo( nombre, tipo, urlImagen);
		}

		if (!DialogDiseñoControl.validarCampos(diseño)) {
			VentanaPrincipalControl.dialogoAlerta("¡Debe diligenciar todos los campos!", "Campos vacíos");
			diseño = null;
		}
		return diseño;
	}

	public static void setDatosDiseño(DiseñoVo diseño) {
		DialogDiseñoControl.ventana.setReferenciaInput(diseño.getReferencia());
		DialogDiseñoControl.ventana.setNombreInput(diseño.getNombre());
		DialogDiseñoControl.ventana.setTipoInput(diseño.getTipo());
		DialogDiseñoControl.ventana.setImagenInput(diseño.getUrlImagen());
	}

	public static boolean validarCampos(DiseñoVo diseño) {
		String nombre = diseño.getNombre();
		String tipo = diseño.getTipo();
		String urlImagen = diseño.getUrlImagen();

		if (!nombre.equals("") && !tipo.equals("") && !urlImagen.equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public static void limpiarDatos() {
		DialogDiseñoControl.ventana.setReferenciaInput("");
		DialogDiseñoControl.ventana.setNombreInput("");
		DialogDiseñoControl.ventana.setTipoInput("");
		DialogDiseñoControl.ventana.setImagenInput("");
	}

	public static void mostrarCodigoPorDefecto() {
		DialogDiseñoControl.ventana.codigoPorDefecto();
	}

	public static void cambiarTextoPrimerBoton(String textoBoton) {
		DialogDiseñoControl.ventana.setTextoBoton1(textoBoton);
	}

	public static void cambiarTextoSegundoBoton(String textoBoton) {
		DialogDiseñoControl.ventana.setTextoBoton2(textoBoton);
	}

	public static void cambiarOnClickSegundoBoton(Operacion onClick) {
		DialogDiseñoControl.ventana.setOnClickBoton2(onClick);
	}

	public static void activarCampos() {
		DialogDiseñoControl.ventana.activarCampos();
	}

	public static void desactivarCampos() {
		DialogDiseñoControl.ventana.desactivarCampos();
	}

	public static void ocultarSegundoBoton() {
		DialogDiseñoControl.ventana.ocultarBoton2();
	}

	public static void mostrarSegundoBoton() {
		DialogDiseñoControl.ventana.mostrarBoton2();
	}
}
