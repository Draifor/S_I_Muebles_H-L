package vista.componentes;

import javax.swing.*;

public class Imagen extends JLabel {

	private static final long serialVersionUID = 1L;

	public Imagen(String source) {
		setIcon(new ImageIcon(getClass().getResource(source)));
		setHorizontalAlignment(SwingConstants.CENTER);
	}

}
