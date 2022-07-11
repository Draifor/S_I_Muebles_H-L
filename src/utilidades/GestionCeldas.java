package utilidades;

import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class GestionCeldas extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;
	private String tipo;
	private static DecimalFormatSymbols simbolos;
	private static DecimalFormat formato;

//	public GestionCeldas() {
//		this.tipo = "texto";
//	}

	public GestionCeldas(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocused,
			int row, int column) {

		if (this.tipo == "numero" && !((String) value).equals("")) {
			simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator(',');
			simbolos.setGroupingSeparator('.');
			formato = new DecimalFormat("0000", simbolos);
			value = formato.format(Double.parseDouble((String) value));
			super.getTableCellRendererComponent(table, value, isSelected, isFocused, row, column);
		}
		
		
		/*
		 * Este metodo controla toda la tabla, podemos obtener el valor que contiene
		 * definir que celda está seleccionada, la fila y columna al tener el foco en
		 * ella.
		 * 
		 * cada evento sobre la tabla invocará este metodo
		 */

		// definimos colores por defecto
		java.awt.Color colorFondo = null;
		java.awt.Color colorFondoPorDefecto = Color.GRIS_50.getColor();
		java.awt.Color colorFondoSeleccion = Color.GRIS_70.getColor();

		/*
		 * Si la celda del evento es la seleccionada se asigna el fondo por defecto para
		 * la selección
		 */
		if (isSelected) {
			this.setBackground(colorFondoPorDefecto);
		} else {
			// Para las que no est�n seleccionadas se pinta el fondo de las celdas de blanco
			this.setBackground(Color.WHITE.getColor());
		}

		/*
		 * Se definen los tipos de datos que contendr�n las celdas basado en la
		 * instancia que se hace en la ventana de la tabla al momento de construirla
		 */
		// si es tipo texto define el color de fondo del texto y de la celda as� como la
		// alineaci�n
		if (isFocused) {
			colorFondo = colorFondoSeleccion;
		} else {
			colorFondo = colorFondoPorDefecto;
		}
		this.setHorizontalAlignment(column == 0 ? JLabel.CENTER : JLabel.LEFT);
		this.setText((String) value);
		// this.setForeground( (selected)? new Color(255,255,255) :new Color(0,0,0) );
		// this.setForeground( (selected)? new Color(255,255,255) :new Color(32,117,32)
		// );
		this.setBackground((isSelected) ? colorFondo : Color.WHITE.getColor());
		this.setFont(new Font("Times New Roman", 0, 16));
		// this.setFont(bold);

		return this;

	}
}
