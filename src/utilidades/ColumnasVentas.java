package utilidades;

public class ColumnasVentas {

	public static final int FACTURA_ID = 0;
	public static final int COD_CLIENTE = 1;
	public static final int LISTA_PRODUCTOS = 2;
	public static final int PRECIO = 3;
	public static final int FECHA = 4;
	public static final int ORDEN_COMPRA_ID = 5;

	public static final int[] TIPO_NUMERO = { 1, 5 };
	public static final int[] TIPO_TEXTO = { 2, 4, };

	public static final String[] TITULOS_COLUMNAS = { "FACTURA ID", "COD CLIENTE", "LISTA PRODUCTOS", "PRECIO", "FECHA",
			"ORDEN COMPRA ID" };

	public static int filaSeleccionada;
}
