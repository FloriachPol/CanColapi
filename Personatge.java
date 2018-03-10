package cancolapi_app;

import java.util.ArrayList;

public class Personatge {
	private ArrayList<Objecte> objectes;
	private int Vides;
	private int HabitacioActual;
	
	public Personatge() {
		objectes = new ArrayList<Objecte>();
		Vides = 3;
		HabitacioActual = 1;
	}
	
	public void afegirObjecte(Objecte objecte) {
		objectes.add(objecte);
	}

	public ArrayList<Objecte> getObjectes() {
		return objectes;
	}

	public void setObjectes(ArrayList<Objecte> objectes) {
		this.objectes = objectes;
	}

	public int getVides() {
		return Vides;
	}

	public void setVides(int vides) {
		Vides = vides;
	}

	public int getHabitacioActual() {
		return HabitacioActual;
	}

	public void setHabitacioActual(int habitacioActual) {
		HabitacioActual = habitacioActual;
	}

}
