package vista.componentes;

import javax.swing.*;

public class Imagen extends JLabel {

	public Imagen(String source) {
		this.setIcon(new ImageIcon(source));
	}

}
