package utilidades;

public class ColumnasClientes {

	public static final int CODIGO = 0;
	public static final int NOMBRE = 1;
	public static final int APELLIDO = 2;
	public static final int IDENTIFICACION = 3;
	public static final int CELULAR = 4;
	public static final int DIRECCION = 5;

	public static final int[] TIPO_NUMERO = { 0, 4 };
	public static final int[] TIPO_TEXTO = { 1, 2, 3, 5 };

	public static final String[] TITULOS_COLUMNAS = { "CODIGO", "NOMBRE", "APELLIDO", "IDENTIFICACION", "CELULAR",
			"DIRECCION" };

	public static int filaSeleccionada;
}
