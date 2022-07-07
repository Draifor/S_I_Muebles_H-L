package vista.componentes;

import javax.swing.*;
import java.awt.*;
import utilidades.Color;

public class PaginaActual extends JPanel {

	private Texto paginaActualTxt;
	
	public PaginaActual(String paginaActual) {
		
        this.setBackground(Color.GRIS_50.getColor());
        this.setPreferredSize(new Dimension(0, 33));

        this.paginaActualTxt = new Texto(paginaActual, 1, 24);
        
        this.add(this.paginaActualTxt);
	}

}
