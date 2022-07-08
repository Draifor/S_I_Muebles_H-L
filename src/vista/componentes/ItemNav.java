package vista.componentes;

import utilidades.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controlador.Operacion;

public class ItemNav extends JPanel implements MouseListener {

	private Texto itemTxt;
	private Operacion onClick;

	public ItemNav(String name, Operacion onClick) {

		this.setBackground(Color.AZUL_30.getColor());
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setLayout(new BorderLayout(0, 0));
		this.addMouseListener(this);

		this.onClick = onClick;
		this.itemTxt = new Texto(name, 0, 15);

		itemTxt.setForeground(Color.WHITE.getColor());

		this.add(itemTxt);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.onClick.onMouseClicked();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(Color.VERDE_100.getColor());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(Color.VERDE_50.getColor());
	}

}
