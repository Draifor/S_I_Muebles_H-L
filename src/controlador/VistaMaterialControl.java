package controlador;

import java.util.List;
import javax.swing.JTable;

import vista.material.VistaMaterial;
import modelo.dao.MaterialDao;
import modelo.vo.MaterialVo;
import utilidades.*;

public class VistaMaterialControl {
	private static MaterialDao materialDao = new MaterialDao();
	private static VistaMaterial vista = new VistaMaterial();

	public static void agregarMaterial() {
		MaterialVo nuevoMaterial = DialogMaterialControl.getDatosMaterial();

		if (nuevoMaterial != null) {
			int resultadoOperacion = VistaMaterialControl.materialDao.agregar(nuevoMaterial);

			if (resultadoOperacion > 0) {
				VistaMaterialControl.actualizarVista();
				DialogMaterialControl.ocultar();
				VentanaPrincipalControl.dialogoAlerta("Material guardado con éxito", "Operación Exitosa");
			} else {
				VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se registró el material",
						"Operación Fallida");
			}
		}
	}

	public static void modificarMaterial() {
		MaterialVo materialActualizado = DialogMaterialControl.getDatosMaterial();

		if (materialActualizado != null) {
			int resultadoOperacion = VistaMaterialControl.materialDao.modificar(materialActualizado);

			if (resultadoOperacion > 0) {
				VistaMaterialControl.actualizarVista();
				DialogMaterialControl.ocultar();
				VentanaPrincipalControl.dialogoAlerta("El material se modificó con éxito", "Operación Exitosa");
			} else {
				VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se modificó el material",
						"Operación Fallida");
			}
		}
	}

	public static void eliminarMaterial() {
		int opcionElegida = VentanaPrincipalControl
				.dialogoConfirmacion("Esta operación es irreversible ¿Desea continuar?", "ADVERTENCIA");

		if (opcionElegida == 0) {
			MaterialVo materialPorEliminar = DialogMaterialControl.getDatosMaterial();

			int resultadoOperacion = VistaMaterialControl.materialDao.eliminar(materialPorEliminar.getId());

			if (resultadoOperacion > 0) {
				VistaMaterialControl.actualizarVista();
				DialogMaterialControl.ocultar();
				VentanaPrincipalControl.dialogoAlerta("Material eliminado con exito", "Operación Exitosa");
			} else {
				VentanaPrincipalControl.dialogoAlerta("Ocurrió un error, no se eliminó el material",
						"Operación Fallida");
			}
		}
	}

	public static String[][] obtenerMateriales() {

		List<MaterialVo> materiales = VistaMaterialControl.materialDao.obtenerRegistros();
		String[][] matrizMateriales = new String[materiales.size()][ColumnasMateriales.TITULOS_COLUMNAS.length];

		for (int i = 0; i < matrizMateriales.length; i++) {
			matrizMateriales[i][ColumnasMateriales.CODIGO] = ((MaterialVo) materiales.get(i)).getId() + "";
			matrizMateriales[i][ColumnasMateriales.REFERENCIA] = ((MaterialVo) materiales.get(i)).getReferencia();
			matrizMateriales[i][ColumnasMateriales.NOMBRE] = ((MaterialVo) materiales.get(i)).getNombre();
			matrizMateriales[i][ColumnasMateriales.COSTO] = ((MaterialVo) materiales.get(i)).getCosto() + "";
			matrizMateriales[i][ColumnasMateriales.CANTIDAD] = ((MaterialVo) materiales.get(i)).getCantidad() + "";
		}

		return matrizMateriales;
	}

	public static String[] obtenerTitulosColumnas() {
		return ColumnasMateriales.TITULOS_COLUMNAS;
	}

	public static void construirTabla(JTable tabla) {
		// Se crea la columna tipo numero
		tabla.getColumnModel().getColumn(ColumnasMateriales.CODIGO).setCellRenderer(new GestionCeldas("numero"));

		// Se crean las columnas tipo texto
		for (int i = 0; i < ColumnasMateriales.TIPO_TEXTO.length; i++) {
			tabla.getColumnModel().getColumn(ColumnasMateriales.TIPO_TEXTO[i])
					.setCellRenderer(new GestionCeldas("texto"));
		}

		// Se crea la columna tipo precio
		tabla.getColumnModel().getColumn(ColumnasMateriales.COSTO).setCellRenderer(new GestionCeldas("precio"));

		// Se crea la columna tipo numero simple
		tabla.getColumnModel().getColumn(ColumnasMateriales.CANTIDAD)
				.setCellRenderer(new GestionCeldas("numero_simple"));

		// Se define el tamaño de las filas y columnas
		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.setRowHeight(25);
		tabla.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tama�o de largo para cada columna y su contenido
		tabla.getColumnModel().getColumn(ColumnasMateriales.CODIGO).setPreferredWidth(84);
		tabla.getColumnModel().getColumn(ColumnasMateriales.REFERENCIA).setPreferredWidth(130);
		tabla.getColumnModel().getColumn(ColumnasMateriales.NOMBRE).setPreferredWidth(420);
		tabla.getColumnModel().getColumn(ColumnasMateriales.COSTO).setPreferredWidth(170);
		tabla.getColumnModel().getColumn(ColumnasMateriales.CANTIDAD).setPreferredWidth(150);
	}

	public static void actualizarVista() {
		VistaMaterialControl.vista.actualizarTabla();
	}

	public static MaterialVo obtenerRegistroSeleccionado(JTable tabla) {
		MaterialVo material = null;
		int filaSeleccionada = tabla.getSelectedRow();

		try {
		if (filaSeleccionada != -1) {
			int id = Integer.parseInt(tabla.getValueAt(filaSeleccionada, ColumnasMateriales.CODIGO).toString());
			String referencia = (String) tabla.getValueAt(filaSeleccionada, ColumnasMateriales.REFERENCIA);
			String nombre = (String) tabla.getValueAt(filaSeleccionada, ColumnasMateriales.NOMBRE);
			double costo = Double.parseDouble(tabla.getValueAt(filaSeleccionada, ColumnasMateriales.COSTO).toString());
			int cantidad = Integer.parseInt(tabla.getValueAt(filaSeleccionada, ColumnasMateriales.CANTIDAD).toString());

			material = new MaterialVo(id, referencia, nombre, costo, cantidad);
		}
		} catch(Exception e) {}
		return material;
	}

	public static void buscarMaterial() {
		try {
		String usuarioInput = VentanaPrincipalControl.dialogoInput("Referencia a buscar", "Buscar Material").trim();

		if (usuarioInput.length() > 0) {
			MaterialVo material = VistaMaterialControl.materialDao.buscar(usuarioInput);
			if (material != null) {
				DialogMaterialControl.setDatosMaterial(material);
				DialogMaterialControl.desactivarCampos();
				DialogMaterialControl.mostrarSegundoBoton();
				DialogMaterialControl.cambiarTextoPrimerBoton("Modificar");
				DialogMaterialControl.cambiarTextoSegundoBoton("Eliminar");
				DialogMaterialControl.cambiarOnClickSegundoBoton(() -> VistaMaterialControl.eliminarMaterial());
				DialogMaterialControl.mostrar("Material",
						() -> VistaMaterialControl.mostrarModificarMaterial(material));
			} else {
				VentanaPrincipalControl.dialogoAlerta("No se encontró el material", "Resultado");
			}

		} else {
			VentanaPrincipalControl.dialogoAlerta("Debe ingresar una referencia", "Atención");
			VistaMaterialControl.buscarMaterial();
		}
		} catch (Exception e) {}
	}

	public static void mostrarAgregarMaterial() {
		DialogMaterialControl.limpiarDatos();
		DialogMaterialControl.activarCampos();
		DialogMaterialControl.mostrarCodigoPorDefecto();
		DialogMaterialControl.cambiarTextoPrimerBoton("Agregar");
		DialogMaterialControl.ocultarSegundoBoton();
		DialogMaterialControl.mostrar("Agregar Material", () -> VistaMaterialControl.agregarMaterial());
	}

	public static void validarModificarMaterial() {
		MaterialVo material = VistaMaterialControl.obtenerRegistroSeleccionado(VistaMaterialControl.vista.getTabla());

		if (material != null) {
			VistaMaterialControl.mostrarModificarMaterial(material);
		} else {
			VentanaPrincipalControl.dialogoAlerta("Selecciona el material a modificar", "Modificar Material");
		}
	}

	public static void validarEliminarMaterial() {
		MaterialVo material = VistaMaterialControl.obtenerRegistroSeleccionado(VistaMaterialControl.vista.getTabla());

		if (material != null) {
			VistaMaterialControl.mostrarEliminarMaterial(material);
		} else {
			VentanaPrincipalControl.dialogoAlerta("Selecciona el material a eliminar", "Eliminar Material");
		}
	}

	public static void mostrarModificarMaterial(MaterialVo material) {
		DialogMaterialControl.setDatosMaterial(material);
		DialogMaterialControl.activarCampos();
		DialogMaterialControl.cambiarTextoPrimerBoton("Modificar");
		DialogMaterialControl.ocultarSegundoBoton();
		DialogMaterialControl.mostrar("Modificar Material", () -> VistaMaterialControl.modificarMaterial());
	}

	public static void mostrarEliminarMaterial(MaterialVo material) {
		DialogMaterialControl.setDatosMaterial(material);
		DialogMaterialControl.desactivarCampos();
		DialogMaterialControl.cambiarTextoPrimerBoton("Eliminar");
		DialogMaterialControl.ocultarSegundoBoton();
		DialogMaterialControl.mostrar("Eliminar Material", () -> VistaMaterialControl.eliminarMaterial());
	}

	public static VistaMaterial getVista() {
		return VistaMaterialControl.vista;
	}
}
