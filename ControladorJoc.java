package cancolapi_app;

import java.util.ArrayList;

public class ControladorJoc {
	public final static int DALT = 0;
	public final static int ESQUERRA = 2;
	public final static int ABAIX = 1;
	public final static int DRETA = 3;
	
	private ArrayList<Habitacio> habitacions;
	private Personatge personatge;
	
	public ControladorJoc() {
		habitacions = inicialitzarHabitacions();
		personatge = new Personatge();
	}
	
	public int mourePersonatge(int direccio) {
		//index habitació l'utilitzem per l'index de l'arrai que va de 0 a 8 (el -1 calcular l'index a l'array a partir del numero d'habitacio que va de 1 al 9
		int indexHabitacioActual = personatge.getHabitacioActual() - 1;
		int nombreNovaHabitacio = personatge.getHabitacioActual();
		//segons la direccio que ens passen cridem la funció que mira si 
		//hi ha porta i en cas de que que hi hagi calculem el nou numero d'habitació i el personatge es mou
		if (habitacioActualTePorta(indexHabitacioActual, direccio)) {
			nombreNovaHabitacio = calcularNombreNovaHabitacio(indexHabitacioActual, direccio);
			personatge.setHabitacioActual(nombreNovaHabitacio);
		}
		
		return nombreNovaHabitacio;
	}
	//aquesta funció comprova segons la direcció i l'index d'habitació si es pot fer el moviment si hi ha una porta que ho permeti
	private boolean habitacioActualTePorta(int indexHabitacioActual, int direccio) {
		boolean tePorta = false;
		
		if (habitacions.get(indexHabitacioActual).getPortes().get(direccio)) {
			tePorta = true;
		}
		
		return tePorta;
	}
	//segons l'index de la habitació i la direcció es calcula la habitació a la que s'ha de moure el personatge
	private int calcularNombreNovaHabitacio(int indexHabitacioActual, int direccio) {
		int indexNovaHabitacio = indexHabitacioActual;
		//comprovacions
		//Mirarem a cada case (cada habitacio) les direccions a les que podria anar el jugador.
		switch (indexHabitacioActual) {
		//habitació 1:
			case 0:
				if (direccio == ControladorJoc.ABAIX) {
					//indexnovahabitacio es refereix en aquest casa  la habitació 4. ens referim a la posició 3 en l'array de les habitacions.
					indexNovaHabitacio = 3;
				}
				else if (direccio == ControladorJoc.DRETA) {
					indexNovaHabitacio = 1;
				}
				break;
			//habitació 2	
			case 1:
				if (direccio == ControladorJoc.ABAIX) {
					indexNovaHabitacio = 4;
				}
				else if (direccio == ControladorJoc.DRETA) {
					indexNovaHabitacio = 2;
				}
				else if (direccio == ControladorJoc.ESQUERRA) {
					indexNovaHabitacio = 0;
				}
				break;
				//habitació 3
			case 2:
				if (direccio == ControladorJoc.ABAIX) {
					//indexnovahabitacio es refereix en aquest casa  la habitació 4. ens referim a la posició 3 en l'array de les habitacions.
					indexNovaHabitacio = 5;
				}
				else if (direccio == ControladorJoc.ESQUERRA) {
					indexNovaHabitacio = 1;
				}
				break;
				//habitació 4
			case 3:
				if (direccio == ControladorJoc.ABAIX) {
					indexNovaHabitacio = 6;
				}
				else if (direccio == ControladorJoc.DRETA) {
					indexNovaHabitacio = 4;
				}
				else if (direccio == ControladorJoc.DALT) {
					indexNovaHabitacio = 0;
				}
				break;
				//habitació 5
			case 4:
				if (direccio == ControladorJoc.ABAIX) {
					indexNovaHabitacio = 7;
				}
				else if (direccio == ControladorJoc.DRETA) {
					indexNovaHabitacio = 5;
				}
				else if (direccio == ControladorJoc.ESQUERRA) {
					indexNovaHabitacio = 3;
				}
				else if (direccio == ControladorJoc.DALT) {
					indexNovaHabitacio = 1;
				}
				break;
				//habitació 6
			case 5:
				if (direccio == ControladorJoc.ABAIX) {
					indexNovaHabitacio = 8;
				}
				else if (direccio == ControladorJoc.ESQUERRA) {
					indexNovaHabitacio = 4;
				}
				else if (direccio == ControladorJoc.DALT) {
					indexNovaHabitacio = 2;
				}
				break;
				//habitació 7
			case 6:
				if (direccio == ControladorJoc.DALT) {
					indexNovaHabitacio = 3;
				}
				else if (direccio == ControladorJoc.DRETA) {
					indexNovaHabitacio = 7;
				}
				break;
				//habitació 8
			case 7:
				if (direccio == ControladorJoc.ESQUERRA) {
					indexNovaHabitacio = 6;
				}
				else if (direccio == ControladorJoc.DRETA) {
					indexNovaHabitacio = 8;
				}
				else if (direccio == ControladorJoc.DALT) {
					indexNovaHabitacio = 4;
				}
				break;
				//habitació 9
			case 8:
				if (direccio == ControladorJoc.ESQUERRA) {
					indexNovaHabitacio = 7;
				}
				else if (direccio == ControladorJoc.DALT) {
					indexNovaHabitacio = 5;
				}
				break;
		
		}
		
		return indexNovaHabitacio + 1;
	}
	
	private ArrayList<Habitacio> inicialitzarHabitacions() {
		ArrayList<Habitacio> habitacionsInicials = new ArrayList<Habitacio>();
		Habitacio habitacio;
		ArrayList<Boolean> portes;
		ArrayList<Objecte> objectes;
		ArrayList<Enemic> enemics;
		
		// Habitació 1. Cantonada a dalt a l'esquerra 
		portes = inicialitzarPortesHabitacio(false, true, false, true);
		enemics = new ArrayList<Enemic>();
		habitacio = new Habitacio(portes, null, enemics);
		habitacionsInicials.add(habitacio);
		
		// Habitació 2. A dalt centre
		portes = inicialitzarPortesHabitacio(false, true, true, true);
		//creem l'objecte objecte
		Objecte os = new Objecte("Os");
		enemics = new ArrayList<Enemic>();
		habitacio = new Habitacio(portes, os, enemics);
		habitacionsInicials.add(habitacio);
		
		// Habitació 3. A dalt a la dreta
		portes = inicialitzarPortesHabitacio(false, true, true, false);
		Objecte clau = new Objecte("Clau");		
		enemics = new ArrayList<Enemic>();
		Enemic fantasma = new Enemic("fantasma");
		enemics.add(fantasma);
		//un cop afegim l'objecte a la llista li passem les llistes plenes a habitació.
		habitacio = new Habitacio(portes, clau, enemics);
		habitacionsInicials.add(habitacio);
		
		// Habitació 4. Centre a l'esquerra
		portes = inicialitzarPortesHabitacio(true, true, false, true);
		enemics = new ArrayList<Enemic>();
		habitacio = new Habitacio(portes, null, enemics);
		habitacionsInicials.add(habitacio);
		
		// Habitació 5. Centre centre
		portes = inicialitzarPortesHabitacio(true, true, true, true);		
		enemics = new ArrayList<Enemic>();
		habitacio = new Habitacio(portes, null, enemics);
		habitacionsInicials.add(habitacio);
		
		// Habitació 6. Centre a la dreta
		portes = inicialitzarPortesHabitacio(true, true, true, false);
		enemics = new ArrayList<Enemic>();
		habitacio = new Habitacio(portes, null, enemics);
		habitacionsInicials.add(habitacio);
		
		// Habitació 7. Cantonada baix esquerra
		portes = inicialitzarPortesHabitacio(true, false, false, false);
		Objecte ouija = new Objecte("Ouija");
		enemics = new ArrayList<Enemic>();
		habitacio = new Habitacio(portes, ouija, enemics);
		habitacionsInicials.add(habitacio);
		
		// Habitació 8. Abaix centre
		portes = inicialitzarPortesHabitacio(true, true, false, false);
		enemics = new ArrayList<Enemic>();
		habitacio = new Habitacio(portes, null, enemics);
		habitacionsInicials.add(habitacio);
		
		// Habitació 9. Cantonada baix dreta
		portes = inicialitzarPortesHabitacio(true,false , false, false);
		Objecte escala = new Objecte("Escala");
		enemics = new ArrayList<Enemic>();
		Enemic gos = new Enemic("gos");
		enemics.add(gos);
		habitacio = new Habitacio(portes, escala, enemics);
		habitacionsInicials.add(habitacio);
		
		
		return habitacionsInicials;
	}
	//inicialitzem array de booleans que representen les portes d'una habitació, com hi ha 4 costats per habitació l'array tindrà 4 elements, cada element
	//ens indica si hi ha porta o no segons la direcció
	private ArrayList<Boolean> inicialitzarPortesHabitacio(boolean existeixPortaDalt, boolean existeixPortaAbaix, boolean existeixPortaEsquerra, boolean existeixPortaDreta) {
		ArrayList<Boolean> portes = new ArrayList<Boolean>();
		
		if (existeixPortaDalt) {
			portes.add(true);
		}
		else {
			portes.add(false);
		}
		
		if (existeixPortaAbaix) {
			portes.add(true);
		}
		else {
			portes.add(false);
		}
		
		if (existeixPortaEsquerra) {
			portes.add(true);
		}
		else {
			portes.add(false);
		}
		
		if (existeixPortaDreta) {
			portes.add(true);
		}
		else {
			portes.add(false);
		}
		
		return portes;
	}
	
	public Habitacio getHabitacioActual() {
		int numeroHabitacioActual = personatge.getHabitacioActual();
		return habitacions.get(numeroHabitacioActual - 1);
	}
	
	public String personatgeAgafaObjectes() {
		String missatge = "";
//		identifiquem l'habitacio, agafem l'objecte i fem copia d'aquest per pasarla a l'array d'objectes del personatge
		Objecte objecte = null;
		
		if (getHabitacioActual().getObjecte() != null) {
			objecte = getHabitacioActual().getObjecte().clone();
		}
		
		//comprovem si la habitació té objecte (per segon cop por si aka)
		if (objecte != null) {
			personatge.afegirObjecte(objecte);
			getHabitacioActual().setObjecte(null);	
			missatge = "Objecte agafat: " + objecte.getNom();
		}
		
		return missatge;
	}

	public ArrayList<Habitacio> getHabitacions() {
		return habitacions;
	}

	public void setHabitacions(ArrayList<Habitacio> habitacions) {
		this.habitacions = habitacions;
	}

	public Personatge getPersonatge() {
		return personatge;
	}

	public void setPersonatge(Personatge personatge) {
		this.personatge = personatge;
	}

}
