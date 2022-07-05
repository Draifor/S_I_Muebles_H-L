package vista.componentes;

import java.awt.Dimension;

import javax.swing.JPanel;
import controlador.*;
import utilidades.Color;

public class Aside extends JPanel {

//	private String RUTA_IMAGEN = "C:\\Users\\Alfredo Parra\\Documents\\eclipse-workspace\\S_I_Muebles_H-L\\src\\vista\\img\\flork.jpg";
	private String RUTA_IMAGEN = "C:\\Users\\USER\\Documents\\eclipse-workspace\\S_I_Muebles_H_L\\src\\vista\\img\\flork.jpg";
	private Imagen imgPerfil;
	private Texto lblUsuario;
	private Texto lblCargo;
	private Boton btnCerrarSesion;
	private Operacion onClick;
	
	public Aside() {

		this.setBackground(Color.AZUL_70.getColor());
		this.setLayout(null);
		this.setPreferredSize(new Dimension(400, 400));
		
		this.imgPerfil = new Imagen(RUTA_IMAGEN);
		this.imgPerfil.setBounds(21, 11, 130, 150);
		
		this.lblUsuario = new Texto("PEPITO PÉREZ", 1, 18);
		this.lblUsuario.setBounds(9, 176, 151, 29);
		
		this.lblCargo = new Texto("CARGO", 1, 18); 
		this.lblCargo.setBounds(32, 207, 105, 29);
		
        this.onClick = () -> PrincipalControl.cerrarSesion();
        this.btnCerrarSesion = new Boton("Cerrar Sesión", this.onClick);
        this.btnCerrarSesion.setBounds(32, 239, 105, 27);
        
        this.add(this.imgPerfil);
        this.add(this.lblUsuario);
        this.add(this.lblCargo);
        this.add(this.btnCerrarSesion);
	}

}
