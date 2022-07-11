package prueba;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class PruebaBorder extends JPanel {

	/**
	 * Create the panel.
	 */
	public PruebaBorder() {
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(15);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_1.add(lblNewLabel_1);

	}

}
