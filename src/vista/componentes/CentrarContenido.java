package vista.componentes;

import java.awt.*;
import javax.swing.JPanel;

public class CentrarContenido extends JPanel {

	public CentrarContenido(JPanel contenidoACentrar, Color color) {

		this.setBackground(color);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.add(contenidoACentrar);
	}

}
