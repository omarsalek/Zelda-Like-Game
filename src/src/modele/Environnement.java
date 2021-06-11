package src.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import src.modele.acteur.Acteur;
import src.modele.acteur.Archers;
import src.modele.acteur.Dragon;
import src.modele.acteur.Gobelin;
import src.modele.acteur.Loup;
import src.modele.acteur.Princesse;
import src.modele.armes.Arc;
import src.modele.armes.Arme;
import src.modele.armes.Epee;
import src.modele.armes.Feu;
import src.modele.armes.Pistolet;
import src.modele.items.Items;
import src.modele.items.Potion;

public class Environnement {
	private ObservableList<Acteur> acteurs;
	private ObservableList<Arme> armes;
	private ObservableList<Terrain> maps;
	private ObservableList<Items> items;
	private int height;
	private int width;
	private IntegerProperty nbMortsProperty;
	private IntegerProperty piecedor;
	private Terrain map;
	private StringProperty DiscussionProperty;

	public Environnement(int width, int height, Terrain map) {
		this.acteurs = FXCollections.observableArrayList();
		this.armes = FXCollections.observableArrayList();
		this.maps = FXCollections.observableArrayList();
		this.items = FXCollections.observableArrayList();
		this.nbMortsProperty = new SimpleIntegerProperty(0);
		this.DiscussionProperty = new SimpleStringProperty("");
		this.piecedor = new SimpleIntegerProperty(0);
		this.height = height;
		this.width = width;
		this.map = map;
	}

	public Terrain getMap() {
		return map;
	}

	public void setMap(Terrain map) {
		this.map = map;
	}

	public final String getDiscussion() {
		return this.DiscussionProperty.getValue();
	}

	public final StringProperty discussionProperty() {
		return this.DiscussionProperty;
	}

	public final void setDiscussionProperty(String text) {
		this.DiscussionProperty.setValue(text);
	}

	public final int getnbMorts() {
		return this.nbMortsProperty.getValue();
	}

	public final int getnbpiècedor() {
		return this.piecedor.getValue();
	}

	public final void setnbpiece(int estmort) {
		this.piecedor.setValue(estmort);
	}

	public final IntegerProperty nbpieceProperty() {
		return this.piecedor;
	}

	public final IntegerProperty nbMortsProperty() {
		return this.nbMortsProperty;
	}

	public final void setnbMortsProperty(int estmort) {
		this.nbMortsProperty.setValue(estmort);
	}

	public void ajouterActeur(Acteur a) {
		acteurs.add(a);
	}

	public void ajouterArme(Arme a) {
		armes.add(a);
	}

	public void ajouterItem(Items i) {
		items.add(i);
	}

	public ObservableList<Items> getItems() {
		return items;
	}

	public ObservableList<Acteur> getActeurs() {
		return acteurs;
	}

	public ObservableList<Terrain> getterrains() {
		return this.maps;
	}

	public void ajouterTerrain(Terrain t) {
		maps.add(t);
	}

	public ObservableList<Arme> getArmes() {
		return armes;
	}

	public Acteur getActeur(String id) {
		for (Acteur a : this.acteurs) {
			if (a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}

	public Items getItem(String id) {
		for (Items i : this.items) {
			if (i.getId().equals(id)) {
				return i;
			}
		}
		return null;
	}

	public Arme getArm(String id) {
		for (Arme a : this.armes) {
			if (a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}

	public boolean estDansleTerrainX(int x) {

		return (-1 <= x && x < this.width);

	}

	public boolean estDansleTerrainY(int y) {

		return (-1 <= y && y < this.height);

	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public boolean ArcherEstMort() {
		for (Acteur m : this.getActeurs()) {
			if (m instanceof Archers) {
				if (m != null) {
					return false;
				}

			}
		}
		return true;
	}

	public boolean DragonEstMort() {
		for (Acteur m : this.getActeurs()) {
			if (m instanceof Dragon) {
				if (m != null) {
					return false;
				}

			}
		}
		return true;
	}

	public boolean SeDeplacerTousLesActeurs() {
		for (Acteur a : this.acteurs) {
			if (a instanceof Gobelin || a instanceof Loup) {
				if (Math.random() < 0.5) {
					// int val = -1 + (int) (Math.random() * (8));
					a.setX(a.getX() - 1);
					return false;

				} else {
					// int val2 = -1 + (int) (Math.random() * (8));
					a.setX(a.getX() + 1);
				}
			}
		}
		return true;
	}

	public Arc trouverArc() {
		for (Arme m : this.getArmes()) {
			if (m instanceof Arc) {
				return (Arc) m;
			}
		}
		return null;
	}

	public Feu trouverFeu() {
		for (Arme m : this.getArmes()) {
			if (m instanceof Feu) {
				return (Feu) m;
			}

		}
		return null;
	}


	public static boolean reussitProba(double pourcent){
		double x= Math.random();
		double pp=pourcent/100;
		return (x<=pp);
	}
	public void ajouterdesennemies() {
		if (this.getActeurs().size() <= 4&& reussitProba(50)) {
			int val = (int) (1 + (Math.random() * (8)));
			this.ajouterActeur(new Gobelin(this, 500 - val * 16, 416 + val * 16));

		}
	}
	public void supprimerTouslesActeurs() {
			for (int i=0 ; i<=this.getActeurs().size();i++) {
				this.getActeurs().remove(i);
			}
	}

	public void init() {
		this.ajouterItem(new Potion(this));
		this.ajouterActeur(new Archers(this, 100, 319));
		this.ajouterActeur(new Loup(this));
		this.ajouterActeur(new Gobelin(this, 532, 416));
		this.ajouterArme(new Epee(this));
		this.ajouterArme(new Arc(this));


	}

	
	public void CreerBoss() {
		this.ajouterArme(new Feu(this));
		this.ajouterActeur(new Dragon(this));
        this.ajouterActeur(new Princesse(this));

	}


}