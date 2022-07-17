package controlador;

import vista.producto.DialogProducto;
import modelo.vo.ProductoVo;
import utilidades.*;

public class DialogProductoControl {
	private static DialogProducto ventana = VentanaPrincipalControl.getProductoDialog();
	
	public static void mostrar(String titulo, Operacion onClick) {
		DialogProductoControl.ventana.setTitulo(titulo);
		DialogProductoControl.ventana.setOnClickBoton1(onClick);
		DialogProductoControl.ventana.setVisible(true);
	}

	public static void ocultar() {
		DialogProductoControl.ventana.setVisible(false);
	}

	public static ProductoVo getDatosProducto() {
		ProductoVo producto = null;
		String precioInput = DialogProductoControl.ventana.getPrecioInput().trim();
		String idDiseñoInput = DialogProductoControl.ventana.getIdDiseñoInput().trim();

		if (MetodosAuxiliares.esNumeroDouble(precioInput) && MetodosAuxiliares.esNumeroInt(idDiseñoInput)) {
			String referencia = DialogProductoControl.ventana.getReferenciaInput().trim();
			String nombre = DialogProductoControl.ventana.getNombreInput().trim();
			String tipo = DialogProductoControl.ventana.getTipoInput().trim();
			double precio = Double.parseDouble(precioInput);
			int cantidad = DialogProductoControl.ventana.getCantidadInput();
			int idDiseño = Integer.parseInt(DialogProductoControl.ventana.getIdDiseñoInput());

			if (MetodosAuxiliares.esNumeroInt(DialogProductoControl.ventana.getCodigoInput())) {
				int id = Integer.parseInt(DialogProductoControl.ventana.getCodigoInput());
				producto = new ProductoVo(id, referencia, nombre, tipo, precio, cantidad, idDiseño);
			} else {
				producto = new ProductoVo(referencia, nombre, tipo, precio, cantidad, idDiseño);
			}
			if (!DialogProductoControl.validarCampos(producto)) {
				VentanaPrincipalControl.dialogoAlerta("¡Debe diligenciar todos los campos!", "Campos vacíos");
				producto = null;
			}
			
		} else {
			VentanaPrincipalControl.dialogoAlerta("¡Debe ingresar un valor válido para precio e idDiseño!", "Advertencia");
		}

		return producto;
	}
	
	public static void setDatosProducto(ProductoVo producto) {
		DialogProductoControl.ventana
				.setCodigoInput(MetodosAuxiliares.formatearNumero((Object) (producto.getId() + "")).toString());
		DialogProductoControl.ventana.setReferenciaInput(producto.getReferencia());
		DialogProductoControl.ventana.setNombreInput(producto.getNombre());
		DialogProductoControl.ventana.setTipoInput(producto.getTipo());
		DialogProductoControl.ventana.setPrecioInput(producto.getPrecio() + "");
		DialogProductoControl.ventana.setCantidadInput(producto.getCantidad());
		DialogProductoControl.ventana.setIdDiseñoInput(producto.getIdDiseño() + "");
	}

	public static void limpiarDatos() {
		DialogProductoControl.ventana.setCodigoInput("");
		DialogProductoControl.ventana.setReferenciaInput("");
		DialogProductoControl.ventana.setNombreInput("");
		DialogProductoControl.ventana.setTipoInput("");
		DialogProductoControl.ventana.setPrecioInput("");
		DialogProductoControl.ventana.setCantidadInput(0);
		DialogProductoControl.ventana.setIdDiseñoInput("");
	}

	public static boolean validarCampos(ProductoVo producto) {
		boolean camposValidos = false;

		if (producto != null) {
			String referencia = producto.getReferencia();
			String nombre = producto.getNombre();
			String tipo = producto.getTipo();
			double precio = producto.getPrecio();
			int cantidad = producto.getCantidad();
			int idDiseño = producto.getIdDiseño();

			if (!referencia.equals("") && !nombre.equals("") && !tipo.equals("") && precio > 0 && cantidad > 0 && idDiseño > 0) {
				camposValidos = true;
			}
		}
		return camposValidos;
	}

	public static void mostrarCodigoPorDefecto() {
		DialogProductoControl.ventana.codigoPorDefecto();
	}

	public static void cambiarTextoPrimerBoton(String textoBoton) {
		DialogProductoControl.ventana.setTextoBoton1(textoBoton);
	}

	public static void cambiarTextoSegundoBoton(String textoBoton) {
		DialogProductoControl.ventana.setTextoBoton2(textoBoton);
	}

	public static void cambiarOnClickSegundoBoton(Operacion onClick) {
		DialogProductoControl.ventana.setOnClickBoton2(onClick);
	}

	public static void activarCampos() {
		DialogProductoControl.ventana.activarCampos();
	}

	public static void desactivarCampos() {
		DialogProductoControl.ventana.desactivarCampos();
	}

	public static void ocultarSegundoBoton() {
		DialogProductoControl.ventana.ocultarBoton2();
	}

	public static void mostrarSegundoBoton() {
		DialogProductoControl.ventana.mostrarBoton2();
	}

}
