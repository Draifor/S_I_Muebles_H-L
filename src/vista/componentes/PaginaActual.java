package vista.componentes;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import utilidades.Color;

public class PaginaActual extends JPanel {

	private static final long serialVersionUID = 1L;
	private static Texto paginaActualTxt;
	
	public PaginaActual(String paginaActual) {
		
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(2);
		
        setBackground(Color.GRIS_50.getColor());
        setPreferredSize(new Dimension(0, 35));
        setBorder(new MatteBorder(2, 0, 2, 0, Color.AZUL_100.getColor()));

        PaginaActual.paginaActualTxt = new Texto(paginaActual, 1, 24);
        
        add(PaginaActual.paginaActualTxt);
	}

	public static void setPaginaActual(String paginaActual) {
		 PaginaActual.paginaActualTxt.setText(paginaActual);
	}
}
