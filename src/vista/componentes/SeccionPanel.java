package vista.componentes;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import utilidades.Color;

public class SeccionPanel extends JPanel {

	private Texto lblSeccion;

	public SeccionPanel(String seccion) {

		this.setBackground(Color.AZUL_30.getColor());
		this.setBorder(BorderFactory.createLineBorder(Color.VERDE_100.getColor(), 2));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setPreferredSize(new Dimension(200, 90));

		this.lblSeccion = new Texto(seccion, 0, 20);
		this.addMouseListener(new MouseListener() {

			public void mouseEntered(MouseEvent evt) {
				seccionTxtMouseEntered(evt);
			}

			public void mouseExited(MouseEvent evt) {
				seccionTxtMouseExited(evt);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		this.setLayout(new BorderLayout(0, 0));
		this.add(this.lblSeccion);
	}

	private void seccionTxtMouseEntered(MouseEvent evt) {
		this.setBackground(Color.AZUL_40.getColor());
	}

	private void seccionTxtMouseExited(MouseEvent evt) {
		this.setBackground(Color.AZUL_30.getColor());
	}

}
