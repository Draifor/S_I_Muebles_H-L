package vista.componentes;

import utilidades.Color;
import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {

	private String COPYRIGTH_TXT = "Todos los derechos reservados ASD - ASEORÍA, SERVICIO Y DISEÑO ©";
	private Texto copyright;

	public Footer() {
		this.setBackground(Color.AZUL_100.getColor());
		this.setBorder(BorderFactory.createLineBorder(Color.VERDE_100.getColor(), 2));

		this.copyright = new Texto(COPYRIGTH_TXT, 1, 16);

		this.add(this.copyright);
	}

}
