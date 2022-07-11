package vista.componentes;

import javax.swing.*;

public class Imagen extends JLabel {

	public Imagen(String source) {
		setIcon(new ImageIcon(getClass().getResource(source)));
		setHorizontalAlignment(SwingConstants.CENTER);
	}

}
