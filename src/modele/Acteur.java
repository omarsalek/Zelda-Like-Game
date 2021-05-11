package src.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;

public abstract class Acteur {

	private String nom;
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	private String arme;
	private int pointsATT;
	private int pointsVIE;
	private String id;
	public static int compteur = 0;

	public Acteur(String nom, String arme, int ptA, int ptv, int x, int y) {
		this.nom = nom;
		this.xProperty = new SimpleIntegerProperty(x);
		this.yProperty = new SimpleIntegerProperty(y);
		this.arme = arme;
		this.pointsATT = ptA;
		this.pointsVIE = ptv;
		this.id = "A" + compteur;
		compteur++;
	}
	

	public final int getX() {
		return xProperty.getValue();
	}

	public final void setX(int n) {
		xProperty.setValue(n);
	}

	public final IntegerProperty xProperty() {
		return this.xProperty;
	}

	public final int getY() {
		return yProperty.getValue();
	}

	public final void setY(int n) {
		yProperty.setValue(n);
	}

	public final IntegerProperty yProperty() {
		return this.yProperty;
	}

	public String getId() {
		return id;
	}

	public int getPtv() {
		return pointsVIE;
	}

	public void setPTV(int ptv) {
		this.pointsVIE = ptv;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setArme(String arme) {
		this.arme = arme;
	}

	public void setPointsATT(int pointsATT) {
		this.pointsATT = pointsATT;
	}

	public String getArme() {
		return arme;
	}

	public int getPointsATT() {
		return pointsATT;
	}

	public boolean estVivant() {
		if (this.pointsVIE > 0)
			return false;
		else
			return true;
	}

	public abstract void attaque();

	public abstract void seFaitAttaquer();

	public abstract void seDeplace();

	@Override
	public String toString() {
		return "Acteur [nom=" + nom + ", xProperty=" + xProperty + ", yProperty=" + yProperty + ", arme=" + arme
				+ ", pointsATT=" + pointsATT + ", pointsVIE=" + pointsVIE + ", id=" + id + "]";
	}
}