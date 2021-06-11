package src.modele.items;

import src.modele.Environnement;

public class Potion extends Items{
	
	public Potion(Environnement env) {
		super("Potion de Vie",198,595);
		
	}

	@Override
	public String toString() {
		return "Potion [getId()=" + getId() + ", getNom()=" + getNom() + ", getX()=" + getX() + ", getY()=" + getY()
				+ ", getxProperty()=" + getxProperty() + ", getyProperty()=" + getyProperty() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
