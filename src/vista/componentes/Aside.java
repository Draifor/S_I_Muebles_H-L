package vista.componentes;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import controlador.*;
import utilidades.Color;

public class Aside extends JPanel {

	private static final long serialVersionUID = 1L;
	private String RUTA_IMAGEN = "/utilidades/img/flork.jpg";
	private Imagen imgPerfil;
	private Texto lblUsuario;
	private Texto lblCargo;
	private Boton btnCerrarSesion;
	private Operacion onClick;

	public Aside() {

		setBackground(Color.AZUL_70.getColor());
		setLayout(null);
		setPreferredSize(new Dimension(200, 290));
		setBorder(new MatteBorder(0, 1, 1, 1, Color.AZUL_100.getColor()));

		this.imgPerfil = new Imagen(RUTA_IMAGEN);
		this.imgPerfil.setBounds(35, 11, 130, 150);

		this.lblUsuario = new Texto("PEPITO PÉREZ", 1, 18);
		this.lblUsuario.setBounds(25, 172, 150, 29);

		this.lblCargo = new Texto("CARGO", 1, 18);
		this.lblCargo.setBounds(47, 207, 105, 29);

		this.onClick = () -> VentanaPrincipalControl.cerrarSesion();
		this.btnCerrarSesion = new Boton("Cerrar Sesión", this.onClick);
		this.btnCerrarSesion.setBounds(47, 245, 105, 27);

		add(this.imgPerfil);
		add(this.lblUsuario);
		add(this.lblCargo);
		add(this.btnCerrarSesion);
	}

}
