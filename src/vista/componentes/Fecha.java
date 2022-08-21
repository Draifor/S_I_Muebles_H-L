package vista.componentes;

import java.util.*;
import javax.swing.*;
import java.awt.BorderLayout;

public class Fecha extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	private String dia;
	private String mes;
	private String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", " ;Septiembre",
			"Octubre", "Noviembre", "Diciemrbre" };
	private String año;
	private String horas;
	private int horaActual;
	private int horaPm;
	private String minutos;
	private int minutoActual;
	private String segundos;
	private int segundoActual;
	private String ampm;
	private Calendar calendario;
	private Date fechaHoraActual;

	private JPanel contenedor;
	private Texto lblFecha;
	private Texto lblHora;
	private Thread reloj;

	public Fecha() {
		this.setLayout(new BorderLayout(0, 0));
		this.setOpaque(false);

		this.reloj = new Thread(this);
		this.reloj.start();

		this.lblFecha = new Texto("DIA MES AÑO", 1, 18);
		this.lblFecha.setHorizontalAlignment(SwingConstants.CENTER);

		this.lblHora = new Texto("HH:MM:SS AM", 1, 18);
		this.lblHora.setHorizontalAlignment(SwingConstants.CENTER);

		this.contenedor = new JPanel();
		this.contenedor.setLayout(new BorderLayout(0, 0));
		this.contenedor.setOpaque(false);
		this.contenedor.add(this.lblFecha, BorderLayout.NORTH);
		this.contenedor.add(this.lblHora, BorderLayout.CENTER);

		this.add(new JLabel(" "), BorderLayout.NORTH);
		this.add(this.contenedor, BorderLayout.CENTER);
		this.add(new JLabel(" "), BorderLayout.SOUTH);

	}

	@Override
	public void run() {
		while (true) {
			this.calcularHora();
			this.lblFecha.setText(this.dia + " " + this.mes + " " + this.año);
			this.lblHora.setText(this.horas + ":" + this.minutos + ":" + this.segundos + " " + this.ampm);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	private void calcularHora() {
		this.calendario = new GregorianCalendar();
		this.fechaHoraActual = new Date();

		this.calendario.setTime(fechaHoraActual);
		this.dia = String.valueOf(calendario.get(Calendar.DAY_OF_MONTH));
		this.mes = meses[calendario.get(Calendar.MONTH)];
		this.año = String.valueOf(calendario.get(Calendar.YEAR));
		this.ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
		this.horaActual = calendario.get(Calendar.HOUR_OF_DAY);

		if (this.ampm.equals("PM")) {
			this.horaPm = horaActual == 12 ? 12 : horaActual - 12;
			this.horas = horaPm < 10 ? "0" + horaPm : "" + horaPm;
		} else {
			this.horas = horaActual < 10 ? "0" + horaActual : "" + horaActual;
		}

		this.minutoActual = calendario.get(Calendar.MINUTE);
		this.minutos = minutoActual < 10 ? "0" + minutoActual : "" + minutoActual;

		this.segundoActual = calendario.get(Calendar.SECOND);
		this.segundos = segundoActual < 10 ? "0" + segundoActual : "" + segundoActual;
	}
}
