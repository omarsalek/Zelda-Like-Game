package src.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Arme {

	private String nom;
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	private IntegerProperty VitesseArme;
	private IntegerProperty pointsAttArme;
	private String id;
	protected Environnement env;
	public static int compteur = 0;
	public Arme(String nom, int xProperty, int yProperty, int vitesseArme,
			int pointsAttArme, Environnement env) {
		this.nom = nom;
		this.xProperty = new SimpleIntegerProperty(xProperty);
		this.yProperty = new SimpleIntegerProperty(yProperty);
		this.VitesseArme = new SimpleIntegerProperty(vitesseArme);
		this.pointsAttArme = new SimpleIntegerProperty(pointsAttArme);
		this.env = env;
		this.id = "A" + compteur;
		compteur++;
	}
	
	public String getId() {
		return id;
	}

	public final int getX() {
		return xProperty.getValue();
	}
	public final int getTirer() {
		return pointsAttArme.getValue();
	}
	public final int getY() {
		return yProperty.getValue();
	}
	public final void setY(int y) {
		if (this.env.estDansleTerrainY(y)) {
			yProperty.setValue(y);
		}
	}
	public final void setX(int x) {
		if (this.env.estDansleTerrainX(x)) {
			xProperty.setValue(x);
		}
	}
	public IntegerProperty getxProperty() {
		return xProperty;
	}
	public void setxProperty(IntegerProperty xProperty) {
		this.xProperty = xProperty;
	}
	public IntegerProperty getyProperty() {
		return yProperty;
	}
	public void setyProperty(IntegerProperty yProperty) {
		this.yProperty = yProperty;
	}
	public IntegerProperty getVitesseArme() {
		return VitesseArme;
	}
	public void setVitesseArme(IntegerProperty vitesseArme) {
		VitesseArme = vitesseArme;
	}
	public int getPointsAttrme() {
		return this.pointsAttArme.getValue();
	}
	public IntegerProperty getPointsAttArmeProperty() {
		return pointsAttArme;
	}
	public void setPointsAttArme(IntegerProperty pointsAttArme) {
		this.pointsAttArme = pointsAttArme;
	}



}
