package src.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement { 
	private CameraLink cameraLink;
	private ObservableList<Acteur> acteurs;
	private ObservableList<Arme> armes;
	private int height;
	private int width;
	private IntegerProperty nbMortsProperty;

	public Environnement(int width , int height) {
		this.acteurs = FXCollections.observableArrayList();
		this.armes = FXCollections.observableArrayList();
		this.nbMortsProperty = new SimpleIntegerProperty(0);
		this.height=height;
		this.width=width;
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

	public void ajouterActeur(Acteur a) {
		acteurs.add(a);
	}
	public void ajouterArm(Arme a) {
		armes.add(a);
	}
	public ObservableList<Acteur> getActeurs() {
		return acteurs;
	}
	public ObservableList<Arme> getArmes() {
		return armes;
	}
	public CameraLink getCameraLink() {
		return cameraLink;
	}
	public Acteur getActeur(String id) {
		for (Acteur a : this.acteurs) {
			if (a.getId().equals(id)) {
				return a;
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

		return (-1 <= x && x < this.getHeight());

	}

	public boolean estDansleTerrainY(int y) {

		return (-1 <= y && y < this.getWidth());

	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void init() {
			this.ajouterActeur(new Archers(this));
			this.ajouterActeur(new Loup(this));
			this.ajouterActeur(new Gobelin(this));
			this.ajouterArm(new Epee(this));
			this.ajouterArm(new Arc(this));
			//this.cameraLink=new CameraLink(0, 0);
		
	}
}
