package cancolapi_app;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class PanellHabitacio extends JPanel {
	private Image imatgeActual;
	private int ample;
	private int alcada;
	
	public PanellHabitacio(int ample, int alcada) {
		//amb super executem el constructor de la classe pare
		super();	
		//quan inicii per primera vegada indiquem que ho faci amb la imatge que li indiquem (habitacio 1)
		this.imatgeActual = new ImageIcon(getClass().getResource("./imatges/habitacio1.jpg")).getImage();
		//indiquem mides del panell
		this.ample = ample;
		this.alcada = alcada;
		//apliquem les mides que li hem indicat
		this.setMinimumSize(new Dimension(ample, alcada));
		//deixem el layout en null per que el volem buit per tractar-ho nosaltres
		this.setLayout(null);
	}
	//sobrescribim mètode de la classe pare (jpanel)
	@Override
	//paintcomponent es crida sol, no permet cridar-ho directament i s'encarrega de pinater els elements gràfics.
	public void paintComponent(Graphics g) {
		//pintem en el component gràfic la imatge de la habitació amb les mides que li donem
		g.drawImage(imatgeActual, 0, 0, ample, alcada, null);
		//g.drawImage(imatgeActual, 100, 100, ample-200, alcada-200, null);	
	}
	//establim la imatge que volem que es mostri i forcem la crida del paincomponent amb el metode repaint
	public void setHabitacioActual(int numHabitacio) {
		this.imatgeActual = new ImageIcon(getClass().getResource("./imatges/habitacio" + numHabitacio + ".jpg")).getImage();
		this.repaint();
	}
}
