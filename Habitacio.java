package cancolapi_app;

import java.util.ArrayList;

public class Habitacio {
	private ArrayList<Boolean> portes;
	private Objecte objecte;
	private ArrayList<Enemic> enemics;
	
	public Habitacio(ArrayList<Boolean> portes, Objecte objecte, ArrayList<Enemic> enemics) {
		this.portes = portes;
		this.objecte = objecte;
		this.enemics = enemics;
	}
	
	public ArrayList<Boolean> getPortes() {
		return portes;
	}

	public void setPortes(ArrayList<Boolean> portes) {
		this.portes = portes;
	}

	public Objecte getObjecte() {
		return objecte;
	}

	public void setObjecte (Objecte objecte) {
		this.objecte = objecte;
	}

	public ArrayList<Enemic> getEnemics() {
		return enemics;
	}

	public void setEnemics(ArrayList<Enemic> enemics) {
		this.enemics = enemics;
	}
	
	public boolean teObjecte() {
		return objecte != null;
	}
}

