package utilidades;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class GestionCeldas extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;
	
	public GestionCeldas() {
		
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
		
		/*
		 * Este metodo controla toda la tabla, podemos obtener el valor que contiene
		 * definir que celda está seleccionada, la fila y columna al tener el foco en ella.
		 * 
		 * cada evento sobre la tabla invocará este metodo
		 */
		
		//definimos colores por defecto
        java.awt.Color colorFondo = null;
        java.awt.Color colorFondoPorDefecto = Color.GRIS_50.getColor();
        java.awt.Color colorFondoSeleccion = Color.GRIS_30.getColor();
    	
        /*
         * Si la celda del evento es la seleccionada se asigna el fondo por defecto para la selección
         */
        if (selected) {                
            this.setBackground(colorFondoPorDefecto );   
        }
        else
        {
        	//Para las que no est�n seleccionadas se pinta el fondo de las celdas de blanco
            this.setBackground(Color.WHITE.getColor());
        }
                
        /*
         * Se definen los tipos de datos que contendr�n las celdas basado en la instancia que
         * se hace en la ventana de la tabla al momento de construirla
         */
        	//si es tipo texto define el color de fondo del texto y de la celda as� como la alineaci�n
            if (focused) {
    			colorFondo=colorFondoSeleccion;
    		}else{
    			colorFondo= colorFondoPorDefecto;
    		}
            this.setHorizontalAlignment( JLabel.LEFT );
            this.setText( (String) value );
            //this.setForeground( (selected)? new Color(255,255,255) :new Color(0,0,0) );   
            //this.setForeground( (selected)? new Color(255,255,255) :new Color(32,117,32) );
            this.setBackground( (selected)? colorFondo : Color.WHITE.getColor());	
            this.setFont(new Font("Times New Roman", 1, 12));   
            //this.setFont(bold);
            return this;
		
	}
}
