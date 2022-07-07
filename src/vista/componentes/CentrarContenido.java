package vista.componentes;

import java.awt.*;
import javax.swing.*;

public class CentrarContenido extends JPanel {

	public CentrarContenido(JPanel contenidoACentrar, Color color) {

		this.setBackground(color);

		add(contenidoACentrar);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	}

}
