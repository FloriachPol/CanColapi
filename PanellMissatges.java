package cancolapi_app;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanellMissatges extends JPanel {

	private JLabel contenidorMissatge;
	
	public PanellMissatges() {
		super();
        this.setLayout(new FlowLayout());
        contenidorMissatge = new JLabel();
        this.add(contenidorMissatge);
	}
	
	public void setMissatge(String missatge) {
		
		contenidorMissatge.setText(missatge);
	}
}
