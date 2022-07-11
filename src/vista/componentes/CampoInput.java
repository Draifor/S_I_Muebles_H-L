package vista.componentes;

import java.awt.*;
import javax.swing.*;

import utilidades.Color;

public class CampoInput extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField campoInput;

	public CampoInput(String tipo) {
		
		setLayout(new BorderLayout(0, 0));

		this.campoInput = tipo.toLowerCase().equals("contraseña") ? new JPasswordField() : new JTextField();

		this.campoInput.setFont(new Font("Times New Roman", 0, 14));
		this.campoInput.setBorder(BorderFactory.createLineBorder(Color.VERDE_50.getColor(), 2));
		
		add(this.campoInput);
	}
	
	public String getTextInput() {
		return this.campoInput.getText();
	}
}
