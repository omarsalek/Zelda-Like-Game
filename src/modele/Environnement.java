package src.modele;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Environnement {
	private ArrayList<Acteur> acteurs;
	private IntegerProperty nbMortsProperty;	

	public Environnement() {
		super();
		this.acteurs = new ArrayList<>();
		this.nbMortsProperty = new SimpleIntegerProperty(0);

	}
	public final int getnbMorts() {
		return this.nbMortsProperty.getValue();
	}
	public final IntegerProperty nbMortsProperty() {
		return this.nbMortsProperty;
	}
	public final void setnbMortsProperty(int estmort) {
		this.nbMortsProperty.setValue(estmort);
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
