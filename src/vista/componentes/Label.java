package vista.componentes;

import utilidades.Color;
import javax.swing.*;
import java.awt.*;

public class Label extends JPanel {

	private static final long serialVersionUID = 1L;
	private Texto label;

	public Label(String label) {
		this.setBackground(Color.AZUL_50.getColor());
		this.setBorder(BorderFactory.createLineBorder(Color.VERDE_100.getColor(), 2));
		this.setPreferredSize(new Dimension(105, 29));
		this.setLayout(new BorderLayout(0, 0));

		this.label = new Texto(label, 0, 18);
		this.add(this.label);
	}

}
