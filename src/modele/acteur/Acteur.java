package src.modele.acteur;

import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
//import javafx.scene.image.Image;
import src.modele.Environnement;

public abstract class Acteur {

	private String nom;
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	private String arme;
	private int pointsATT;
	// private int pointsVIE;
	private IntegerProperty pointsVIE;
	private String id;
	protected Environnement env;
	public static int compteur = 0;

	public Acteur(String nom, String arme, int ptA, int ptv, int x, int y, Environnement env) {
		this.nom = nom;
		this.env = env;
		this.xProperty = new SimpleIntegerProperty(x);
		this.yProperty = new SimpleIntegerProperty(y);
		this.arme = arme;
		this.pointsATT = ptA;
		// this.pointsVIE = ptv;
		this.pointsVIE = new SimpleIntegerProperty(ptv);
		this.id = "A" + compteur;
		compteur++;
	}

	public final int getX() {
		return xProperty.getValue();
	}

	public final void setX(int x) {
		if (this.env.estDansleTerrainX(x)) {
			xProperty.setValue(x);
		}
	}

	public final IntegerProperty xProperty() {
		return this.xProperty;
	}

	public final int getY() {
		return yProperty.getValue();
	}

	public final void setY(int y) {
		if (this.env.estDansleTerrainY(y)) {
			yProperty.setValue(y);
		}
	}

	public final IntegerProperty yProperty() {
		return this.yProperty;
	}

	public String getId() {
		return id;
	}

//	public int getPtv() {
//	return pointsVIE;
//}
//
//public void setPTV(int ptv) {
//	this.pointsVIE=ptv;
//}
	public int getPtv() {
		return pointsVIE.getValue();
	}

	public void setPTV(int ptv) {
		this.pointsVIE.setValue(ptv);
	}

	public final IntegerProperty pointsVIE() {
		return this.pointsVIE;
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

//	public boolean estVivant() {
//		return this.pointsVIE > 0;
//			
//	}

//	public void decrementerPv(int n) {
//		this.pointsVIE-=n;	
//	}

//	
//	public void incrementerPv(int n) {
//		this.pointsVIE+=n;	
//	}
	public void decrementerPv(int n) {
		this.pointsVIE.setValue(this.pointsVIE.getValue() - n);
	}

	public abstract boolean attaque();

	public abstract void seFaitAttaquer();

	public abstract void seDeplace();

	@Override
	public String toString() {
		return "Acteur [nom=" + nom + ", xProperty=" + xProperty + ", yProperty=" + yProperty + ", arme=" + arme
				+ ", pointsATT=" + pointsATT + ", pointsVIE=" + pointsVIE + ", id=" + id + "]";
	}
}