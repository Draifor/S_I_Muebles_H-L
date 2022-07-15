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
		String nombre = DialogDiseñoControl.ventana.getNombreInput();
		String tipo = DialogDiseñoControl.ventana.getTipoInput();
		String urlImagen = DialogDiseñoControl.ventana.getImagenInput();

		DiseñoVo diseño;

		if (MetodosAuxiliares.esNumero(DialogDiseñoControl.ventana.getCodigoInput())) {
			int idDiseño = Integer.parseInt(DialogDiseñoControl.ventana.getCodigoInput());
			diseño = new DiseñoVo(idDiseño, referencia, nombre, tipo, urlImagen);
		} else {
			diseño = new DiseñoVo(referencia, nombre, tipo, urlImagen);
		}

		return diseño;
	}

	public static void setDatosDiseño(DiseñoVo diseño) {
		DialogDiseñoControl.ventana
				.setCodigoInput(MetodosAuxiliares.formatearNumero((Object) (diseño.getIdDiseño() + "")).toString());
		DialogDiseñoControl.ventana.setReferenciaInput(diseño.getReferencia());
		DialogDiseñoControl.ventana.setNombreInput(diseño.getNombre());
		DialogDiseñoControl.ventana.setTipoInput(diseño.getTipo());
		DialogDiseñoControl.ventana.setImagenInput(diseño.getUrlImagen());
	}

	public static void limpiarDatos() {
		DialogDiseñoControl.ventana.setCodigoInput("");
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
