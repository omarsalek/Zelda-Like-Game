package src.modele.items;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Item {
	
	private String nom;
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	private String id;
	public static int compteur = 0;
	
	public Item(String nom, int x, int y) {
		this.nom = nom;
		this.xProperty = new SimpleIntegerProperty(x);
		this.yProperty = new SimpleIntegerProperty(y);
		this.id = "I" + compteur;
		compteur++;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public final int getX() {
		return xProperty.getValue();
	}
	
	public final int getY() {
		return yProperty.getValue();
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
	
}
