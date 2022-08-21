package vista.componentes;

import javax.swing.*;

public class ComboBox extends JComboBox<Object> {

	private static final long serialVersionUID = 1L;
	private ComboBoxModel<Object> model;

	public ComboBox() {
		this.model = new DefaultComboBoxModel<Object>();
		setModel(model);
	}

	public void agregarElementos(String[][] elementos) {
		for (String[] elemento: elementos) {
			((DefaultComboBoxModel<Object>) model).addElement(elemento);
		}
	}
	
	public void activarCampo() {
		setEditable(true);
	}
	
	public void desactivarCampo() {
		setEditable(false);
	}
}
