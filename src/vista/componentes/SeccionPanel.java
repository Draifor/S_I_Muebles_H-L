package vista.componentes;

import controlador.Operacion; 
import utilidades.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SeccionPanel extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;
	private Texto lblSeccion;
	private Operacion onClick;

	public SeccionPanel(String seccion, Operacion onClick) {

		setBackground(Color.AZUL_30.getColor());
		setBorder(BorderFactory.createLineBorder(Color.VERDE_100.getColor(), 2));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setPreferredSize(new Dimension(200, 90));
		setLayout(new BorderLayout(0, 0));
		addMouseListener(this);

		this.lblSeccion = new Texto(seccion, 0, 20);
		this.onClick = onClick;

		add(this.lblSeccion);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		onClick.onMouseClicked();
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
		this.setBackground(Color.AZUL_40.getColor());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(Color.AZUL_30.getColor());
	}
	
}
