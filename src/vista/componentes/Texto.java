package vista.componentes;

import utilidades.Color;
import javax.swing.*;
import java.awt.*;

public class Texto extends JLabel {

	private static final long serialVersionUID = 1L;

	public Texto(String label, int fontStyle, int size) {
		this.setFont(new Font("Times New Roman", fontStyle, size));
		this.setForeground(Color.BLACK.getColor());
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setText(label);
	}

}
