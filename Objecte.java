package cancolapi_app;

public class Objecte {
	private String Nom;
	
	Objecte(String nom) {
		this.Nom = nom;
	}
	
	public String getNom() {
		return Nom;
	}
	
	public Objecte clone() {
		Objecte clon = new Objecte(this.getNom());
		return clon;
	}
}
