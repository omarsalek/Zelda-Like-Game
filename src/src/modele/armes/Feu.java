package src.modele.armes;

import src.modele.Environnement;
import src.modele.acteur.Link;

public class Feu extends Arme{

	public Feu( Environnement env) {
		super("feu", 730, 264, 4, 8, env);
		// TODO Auto-generated constructor stub
	}
	public void TirerDepuisdragon(Link m) {
		this.setY(this.getY() + 16);
		if (this.getY() > 500) {
			this.setY(264);
		}
		if (this.getX()/16 == m.getX()/16 && this.getY()/16 ==m.getY()/16) {
			m.decrementerPv(this.getTirer());
		}
	}

}