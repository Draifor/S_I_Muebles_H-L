package utilidades;

import java.text.*;

public class MetodosAuxiliares {

	private static DecimalFormatSymbols simbolos;
	private static DecimalFormat formato;

	public static Object formatearNumero(Object value) {

		simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator(',');
		simbolos.setGroupingSeparator('.');
		formato = new DecimalFormat("0000", simbolos);

		value = formato.format(Double.parseDouble((String) value));

		return value;
	};

	public static Object formatearNumeroSimple(Object value) {

		simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator(',');
		simbolos.setGroupingSeparator('.');
		formato = new DecimalFormat("0", simbolos);

		value = formato.format(Double.parseDouble((String) value));

		return value;
	};

	public static Object formatearPrecio(Object value) {

		simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator(',');
		simbolos.setGroupingSeparator('.');
		formato = new DecimalFormat("$###,##0", simbolos);

		value = formato.format(Double.parseDouble((String) value));

		return value;
	};

	public static boolean esNumeroInt(String cadena) {

		boolean resultado;

		try {
			Integer.parseInt(cadena);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}

	public static boolean esNumeroDouble(String cadena) {

		boolean resultado;

		try {
			Double.parseDouble(cadena);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}

	public static String formatearId(int id) {
		String idFormateado = id > 999 ? id + "" : id > 99 ? "0" + id : id > 9 ? "00" + id : "000" + id;
		return idFormateado;
	}
}
