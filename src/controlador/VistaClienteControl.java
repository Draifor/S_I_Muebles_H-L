package controlador;

import java.util.List;
import javax.swing.JTable;

import modelo.dao.ClienteDao;
import modelo.vo.ClienteVo;
import utilidades.*;

public class VistaClienteControl implements VistaControl {

	private static ClienteDao clienteDao = new ClienteDao();

	public static ClienteDao getClienteDao() {
		return VistaClienteControl.clienteDao;
	}

	public static String[][] obtenerClientes() {

		List<ClienteVo> clientes = VistaClienteControl.clienteDao.obtenerClientes();
		String[][] matrizClientes = new String[clientes.size()][ClientesColumnas.TITULOS_COLUMNAS.length];

		for (int i = 0; i < matrizClientes.length; i++) {
			matrizClientes[i][ClientesColumnas.CODIGO] = ((ClienteVo) clientes.get(i)).getIdCliente() + "";
			matrizClientes[i][ClientesColumnas.NOMBRE] = ((ClienteVo) clientes.get(i)).getNombre() + "";
			matrizClientes[i][ClientesColumnas.APELLIDO] = ((ClienteVo) clientes.get(i)).getApellido() + "";
			matrizClientes[i][ClientesColumnas.IDENTIFICACION] = ((ClienteVo) clientes.get(i)).getIdentificacion() + "";
			matrizClientes[i][ClientesColumnas.CELULAR] = ((ClienteVo) clientes.get(i)).getCelular() + "";
			matrizClientes[i][ClientesColumnas.DIRECCION] = ((ClienteVo) clientes.get(i)).getDireccion() + "";
		}

		return matrizClientes;
	}

	public static String[] obtenerTitulosColumnas() {
		return ClientesColumnas.TITULOS_COLUMNAS;
	}

	public static void construirTabla(JTable tabla) {
		// se recorre y asignan las celdas que almacenan datos de tipo texto
		for (int i = 0; i < ClientesColumnas.TIPO_TEXTO.length; i++) {
			tabla.getColumnModel().getColumn(ClientesColumnas.TIPO_TEXTO[i]).setCellRenderer(new GestionCeldas("texto"));
		}

		// Se recorre para asignar datos de tipo numero
		for (int i = 0; i < ClientesColumnas.TIPO_NUMERO.length; i++) {
			tabla.getColumnModel().getColumn(ClientesColumnas.TIPO_NUMERO[i])
					.setCellRenderer(new GestionCeldas("numero"));
		}

		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.setRowHeight(25);// tama�o de las celdas
		tabla.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tama�o de largo para cada columna y su contenido
		tabla.getColumnModel().getColumn(ClientesColumnas.CODIGO).setPreferredWidth(115);
		tabla.getColumnModel().getColumn(ClientesColumnas.NOMBRE).setPreferredWidth(230);
		tabla.getColumnModel().getColumn(ClientesColumnas.APELLIDO).setPreferredWidth(230);
		tabla.getColumnModel().getColumn(ClientesColumnas.IDENTIFICACION).setPreferredWidth(150);
		tabla.getColumnModel().getColumn(ClientesColumnas.CELULAR).setPreferredWidth(150);
		tabla.getColumnModel().getColumn(ClientesColumnas.DIRECCION).setPreferredWidth(280);
	}
}
