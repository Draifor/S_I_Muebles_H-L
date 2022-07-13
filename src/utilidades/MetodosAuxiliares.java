package utilidades;

import java.text.*;

public class MetodosAuxiliares {

	public static Object formatearNumero(Object value) {

		DecimalFormatSymbols simbolos;
		DecimalFormat formato;
		
		simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator(',');
		simbolos.setGroupingSeparator('.');
		formato = new DecimalFormat("0000", simbolos);
		
		value = formato.format(Double.parseDouble((String) value));
		
		return value;
	};

	public static boolean esNumero(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
}
