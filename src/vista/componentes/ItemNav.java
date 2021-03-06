package vista.componentes;

import utilidades.Color;
import utilidades.Operacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class ItemNav extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private Texto itemTxt;
	private Operacion onClick;

	public ItemNav(String name, Operacion onClick) {

		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(2);

		setBackground(Color.AZUL_30.getColor());
		setBorder(new MatteBorder(0, 0, 0, 2, Color.AZUL_100.getColor()));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(this);

		this.onClick = onClick;
		this.itemTxt = new Texto(name, 0, 16);

		itemTxt.setForeground(Color.AZUL_100.getColor());

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
		this.setBackground(Color.AZUL_30.getColor());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(Color.GRIS_50.getColor());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(Color.AZUL_30.getColor());
	}

}
