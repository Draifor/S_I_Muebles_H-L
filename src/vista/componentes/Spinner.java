package vista.componentes;

import java.awt.Font;

import javax.swing.*;
import javax.swing.border.LineBorder;

import utilidades.Color;

public class Spinner extends JSpinner {

	private static final long serialVersionUID = 1L;
	private SpinnerNumberModel numberModel;
	
	public Spinner() {
		setBorder(new LineBorder(Color.VERDE_50.getColor(), 2));
		setFont(new Font("Times New Roman", Font.PLAIN, 16));
		numberModel = new SpinnerNumberModel(0, 0, null, 1);
//		setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		setModel(numberModel);
	}
	
	public int getValor() {
		return (int) getValue();
	}
}
