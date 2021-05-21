package src.modele;

import java.util.ArrayList;

public class Environnement {
	private ArrayList<Acteur> acteurs;

	public Environnement() {
		super();
		this.acteurs = new ArrayList<>();

	}

	public void ajouter(Acteur a) {
		acteurs.add(a);
	}

	public ArrayList<Acteur> getActeurs() {
		return acteurs;
	}

	public Acteur getActeur(String id) {
		for (Acteur a : this.acteurs) {
			if (a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}

	public boolean estDansleTerrainX(int x) {

		return (-1 <= x && x < 960);

	}

	public boolean estDansleTerrainY(int y) {

		return ( -1<=y && y < 639);

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			this.ajouter(new Gobelin(this));
		}

	}

}
