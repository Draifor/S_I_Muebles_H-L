package controlador;

import vista.material.DialogMaterial;
import modelo.vo.MaterialVo;
import utilidades.*;

public class DialogMaterialControl {
	private static DialogMaterial ventana = VentanaPrincipalControl.getMaterialDialog();

	public static void mostrar(String titulo, Operacion onClick) {
		DialogMaterialControl.ventana.setTitulo(titulo);
		DialogMaterialControl.ventana.setOnClickBoton1(onClick);
		DialogMaterialControl.ventana.setVisible(true);
	}

	public static void ocultar() {
		DialogMaterialControl.ventana.setVisible(false);
	}

	public static MaterialVo getDatosMaterial() {
		MaterialVo material = null;
		String costoInput = DialogMaterialControl.ventana.getCostoInput().trim();

		if (MetodosAuxiliares.esNumeroDouble(costoInput)) {
			String referencia = DialogMaterialControl.ventana.getReferenciaInput().trim();
			String nombre = DialogMaterialControl.ventana.getNombreInput().trim();
			double costo = Double.parseDouble(costoInput);
			int cantidad = DialogMaterialControl.ventana.getCantidadInput();

			if (MetodosAuxiliares.esNumeroInt(DialogMaterialControl.ventana.getCodigoInput())) {
				int id = Integer.parseInt(DialogMaterialControl.ventana.getCodigoInput());
				material = new MaterialVo(id, referencia, nombre, costo, cantidad);
			} else {
				material = new MaterialVo(referencia, nombre, costo, cantidad);
			}
			if (!DialogMaterialControl.validarCampos(material)) {
				VentanaPrincipalControl.dialogoAlerta("¡Debe diligenciar todos los campos!", "Campos vacíos");
				material = null;
			}
			
		} else {
			VentanaPrincipalControl.dialogoAlerta("¡Debe ingresar un valor válido para el costo!", "Advertencia");
		}

		return material;
	}

	public static void setDatosMaterial(MaterialVo material) {
		DialogMaterialControl.ventana
				.setCodigoInput(MetodosAuxiliares.formatearNumero((Object) (material.getId() + "")).toString());
		DialogMaterialControl.ventana.setReferenciaInput(material.getReferencia());
		DialogMaterialControl.ventana.setNombreInput(material.getNombre());
		DialogMaterialControl.ventana.setCostoInput(material.getCosto() + "");
		DialogMaterialControl.ventana.setCantidadInput(material.getCantidad());
	}

	public static void limpiarDatos() {
		DialogMaterialControl.ventana.setCodigoInput("");
		DialogMaterialControl.ventana.setReferenciaInput("");
		DialogMaterialControl.ventana.setNombreInput("");
		DialogMaterialControl.ventana.setCostoInput("");
		DialogMaterialControl.ventana.setCantidadInput(0);
	}

	public static boolean validarCampos(MaterialVo material) {
		boolean camposValidos = false;

		if (material != null) {
			String referencia = material.getReferencia();
			String nombre = material.getNombre();
			double costo = material.getCosto();
			int cantidad = material.getCantidad();

			System.out.println(referencia + " - " + nombre + " - " + costo + " - " + cantidad);
			if (!referencia.equals("") && !nombre.equals("") && costo > 0 && cantidad > 0) {
				camposValidos = true;
			}
		}
		return camposValidos;
	}

	public static void mostrarCodigoPorDefecto() {
		DialogMaterialControl.ventana.codigoPorDefecto();
	}

	public static void cambiarTextoPrimerBoton(String textoBoton) {
		DialogMaterialControl.ventana.setTextoBoton1(textoBoton);
	}

	public static void cambiarTextoSegundoBoton(String textoBoton) {
		DialogMaterialControl.ventana.setTextoBoton2(textoBoton);
	}

	public static void cambiarOnClickSegundoBoton(Operacion onClick) {
		DialogMaterialControl.ventana.setOnClickBoton2(onClick);
	}

	public static void activarCampos() {
		DialogMaterialControl.ventana.activarCampos();
	}

	public static void desactivarCampos() {
		DialogMaterialControl.ventana.desactivarCampos();
	}

	public static void ocultarSegundoBoton() {
		DialogMaterialControl.ventana.ocultarBoton2();
	}

	public static void mostrarSegundoBoton() {
		DialogMaterialControl.ventana.mostrarBoton2();
	}
}
