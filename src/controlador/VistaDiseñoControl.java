package controlador;

import java.util.List;
import javax.swing.JTable;

import vista.diseño.VistaDiseño;
import modelo.dao.DiseñoDao;
import modelo.vo.DiseñoVo;
import utilidades.*;

public class VistaDiseñoControl {
	private static DiseñoDao diseñoDao = new DiseñoDao();
	private static VistaDiseño vistaDiseño = new VistaDiseño();

	public static void agregarDiseño() {
		DiseñoVo nuevoDiseño = DialogDiseñoControl.getDatosDiseño();
		int resultadoOperacion = VistaDiseñoControl.diseñoDao.agregar(nuevoDiseño);

		if (resultadoOperacion > 0) {
			VistaDiseñoControl.actualizarVista();
			DialogDiseñoControl.ocultar();
			VentanaPrincipalControl.dialogoAlerta("Diseño guardado con éxito", "Operación Exitosa");
		} else {
			VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se registró el diseño", "Operación Fallida");
		}
	}

	public static void modificarDiseño() {
		DiseñoVo diseñoActualizado = DialogDiseñoControl.getDatosDiseño();
		int resultadoOperacion = VistaDiseñoControl.diseñoDao.modificar(diseñoActualizado);

		if (resultadoOperacion > 0) {
			VistaDiseñoControl.actualizarVista();
			DialogDiseñoControl.ocultar();
			VentanaPrincipalControl.dialogoAlerta("El cliente se modificó con éxito", "Operación Exitosa");
		} else {
			VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se modificó el usuario", "Operación Fallida");
		}
	}

	public static void eliminarDiseño() {
		int opcionElegida = VentanaPrincipalControl
				.dialogoConfirmacion("Esta operación es irreversible ¿Desea continuar?", "ADVERTENCIA");

		if (opcionElegida == 0) {
			DiseñoVo diseñoPorEliminar = DialogDiseñoControl.getDatosDiseño();

			int resultadoOperacion = VistaDiseñoControl.diseñoDao.eliminar(diseñoPorEliminar.getIdDiseño());

			if (resultadoOperacion > 0) {
				VistaDiseñoControl.actualizarVista();
				DialogDiseñoControl.ocultar();
				VentanaPrincipalControl.dialogoAlerta("Cliente eliminado con exito", "Operación Exitosa");
			} else {
				VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se eliminó el usuario",
						"Operación Fallida");
			}
		}

	}

	public static String[][] obtenerDiseños() {

		List<DiseñoVo> diseños = VistaDiseñoControl.diseñoDao.obtenerDiseños();
		String[][] matrizDiseños = new String[diseños.size()][DiseñosColumnas.TITULOS_COLUMNAS.length];

		for (int i = 0; i < matrizDiseños.length; i++) {
			matrizDiseños[i][DiseñosColumnas.CODIGO] = ((DiseñoVo) diseños.get(i)).getIdDiseño() + "";
			matrizDiseños[i][DiseñosColumnas.REFERENCIA] = ((DiseñoVo) diseños.get(i)).getReferencia();
			matrizDiseños[i][DiseñosColumnas.NOMBRE] = ((DiseñoVo) diseños.get(i)).getNombre();
			matrizDiseños[i][DiseñosColumnas.TIPO] = ((DiseñoVo) diseños.get(i)).getTipo();
			matrizDiseños[i][DiseñosColumnas.URL_IMAGEN] = ((DiseñoVo) diseños.get(i)).getUrlImagen();
		}

		return matrizDiseños;
	}

	public static String[] obtenerTitulosColumnas() {
		return DiseñosColumnas.TITULOS_COLUMNAS;
	}

	public static void construirTabla(JTable tabla) {
		// Se crean las columnas tipo texto
		for (int i = 0; i < DiseñosColumnas.TIPO_TEXTO.length; i++) {
			tabla.getColumnModel().getColumn(DiseñosColumnas.TIPO_TEXTO[i])
					.setCellRenderer(new GestionCeldas("texto"));
		}

		// Se crean las columnas numericas
		for (int i = 0; i < DiseñosColumnas.TIPO_NUMERO.length; i++) {
			tabla.getColumnModel().getColumn(DiseñosColumnas.TIPO_NUMERO[i])
					.setCellRenderer(new GestionCeldas("numero"));
		}

		// Se define el tamaño de las filas y columnas
		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.setRowHeight(25);
		tabla.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tama�o de largo para cada columna y su contenido
		tabla.getColumnModel().getColumn(DiseñosColumnas.CODIGO).setPreferredWidth(84);
		tabla.getColumnModel().getColumn(DiseñosColumnas.REFERENCIA).setPreferredWidth(130);
		tabla.getColumnModel().getColumn(DiseñosColumnas.NOMBRE).setPreferredWidth(420);
		tabla.getColumnModel().getColumn(DiseñosColumnas.TIPO).setPreferredWidth(170);
		tabla.getColumnModel().getColumn(DiseñosColumnas.URL_IMAGEN).setPreferredWidth(150);
	}

	public static void actualizarVista() {
		VistaDiseñoControl.vistaDiseño.actualizarTabla();
	}

	public static DiseñoVo obtenerRegistroSeleccionado(JTable tabla) {
		DiseñoVo diseño = null;
		int filaSeleccionada = tabla.getSelectedRow();

		if (filaSeleccionada != -1) {
			int idDiseño = Integer.parseInt(tabla.getValueAt(filaSeleccionada, DiseñosColumnas.CODIGO).toString());
			String referencia = (String) tabla.getValueAt(filaSeleccionada, DiseñosColumnas.REFERENCIA);
			String nombre = (String) tabla.getValueAt(filaSeleccionada, DiseñosColumnas.NOMBRE);
			String tipo = (String) tabla.getValueAt(filaSeleccionada, DiseñosColumnas.TIPO);
			String urlImagen = (String) tabla.getValueAt(filaSeleccionada, DiseñosColumnas.URL_IMAGEN);

			diseño = new DiseñoVo(idDiseño, referencia, nombre, tipo, urlImagen);
		}
		return diseño;
	}

	public static void buscarDiseño() {
		String usuarioInput = VentanaPrincipalControl.dialogoInput("Referencia a buscar",
				"Buscar Diseño");
		
			if (usuarioInput.length() > 0) {
				DiseñoVo diseño = VistaDiseñoControl.diseñoDao.buscar(usuarioInput);
				if (diseño != null) {
					DialogDiseñoControl.setDatosDiseño(diseño);
					DialogDiseñoControl.desactivarCampos();
					DialogDiseñoControl.mostrarSegundoBoton();
					DialogDiseñoControl.cambiarTextoPrimerBoton("Modificar");
					DialogDiseñoControl.cambiarTextoSegundoBoton("Eliminar");
					DialogDiseñoControl.cambiarOnClickSegundoBoton(() -> VistaDiseñoControl.eliminarDiseño());
					DialogDiseñoControl.mostrar("Diseño", () -> VistaDiseñoControl.mostrarDiseñoModificar(diseño));
				} else {
					VentanaPrincipalControl.dialogoAlerta("No se encontró el diseño", "Resultado");
				}

			} else {
				VentanaPrincipalControl.dialogoAlerta("Debe ingresar una referencia", "Atención");
				VistaDiseñoControl.buscarDiseño();
			}
	}

	public static void mostrarAgregarDiseño() {
		DialogDiseñoControl.limpiarDatos();
		DialogDiseñoControl.activarCampos();
		DialogDiseñoControl.mostrarCodigoPorDefecto();
		DialogDiseñoControl.cambiarTextoPrimerBoton("Agregar");
		DialogDiseñoControl.ocultarSegundoBoton();
		DialogDiseñoControl.mostrar("Agregar Diseño", () -> VistaDiseñoControl.agregarDiseño());
	}

	public static void validarDiseñoModificar() {
		DiseñoVo diseño = VistaDiseñoControl.obtenerRegistroSeleccionado(VistaDiseñoControl.vistaDiseño.getTabla());

		if (diseño != null) {
			VistaDiseñoControl.mostrarDiseñoModificar(diseño);
		} else {
			VentanaPrincipalControl.dialogoAlerta("Selecciona el diseño a modificar", "Modificar Diseño");
		}
	}

	public static void validarDiseñoEliminar() {
		DiseñoVo diseño = VistaDiseñoControl.obtenerRegistroSeleccionado(VistaDiseñoControl.vistaDiseño.getTabla());

		if (diseño != null) {
			VistaDiseñoControl.mostrarDiseñoEliminar(diseño);
		} else {
			VentanaPrincipalControl.dialogoAlerta("Selecciona el diseño a eliminar", "Eliminar Diseño");
		}
	}

	public static void mostrarDiseñoModificar(DiseñoVo diseño) {
		DialogDiseñoControl.setDatosDiseño(diseño);
		DialogDiseñoControl.activarCampos();
		DialogDiseñoControl.cambiarTextoPrimerBoton("Modificar");
		DialogDiseñoControl.ocultarSegundoBoton();
		DialogDiseñoControl.mostrar("Modificar Diseño", () -> VistaDiseñoControl.modificarDiseño());
	}

	public static void mostrarDiseñoEliminar(DiseñoVo diseño) {
		DialogDiseñoControl.setDatosDiseño(diseño);
		DialogDiseñoControl.desactivarCampos();
		DialogDiseñoControl.cambiarTextoPrimerBoton("Eliminar");
		DialogDiseñoControl.ocultarSegundoBoton();
		DialogDiseñoControl.mostrar("Eliminar Diseño", () -> VistaDiseñoControl.eliminarDiseño());
	}

	public static VistaDiseño getVistaDiseño() {
		return VistaDiseñoControl.vistaDiseño;
	}
}
