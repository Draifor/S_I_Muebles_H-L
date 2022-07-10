package vista.componentes;

import javax.swing.*;
import java.awt.*;
import utilidades.Color;

public class PaginaActual extends JPanel {

	private static Texto paginaActualTxt;
	
	public PaginaActual(String paginaActual) {
		
        this.setBackground(Color.GRIS_50.getColor());
        this.setPreferredSize(new Dimension(0, 35));

        PaginaActual.paginaActualTxt = new Texto(paginaActual, 1, 24);
        
        this.add(PaginaActual.paginaActualTxt);
	}

	public static void setPaginaActual(String paginaActual) {
		 PaginaActual.paginaActualTxt.setText(paginaActual);
	}
}
