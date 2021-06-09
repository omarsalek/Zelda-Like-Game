package src.modele;

import src.modele.acteur.Link;

public class Feu extends Arme{

	public Feu( Environnement env) {
		super("feu", 222, 411, 4, 8, env);
		// TODO Auto-generated constructor stub
	}
	public void TirerDepuisdragon(Link m) {
		this.setX(this.getX() + 16);
		if (this.getX() > 500) {
			this.setX(100);
		}
		if (this.getX()/16 == m.getX()/16 && this.getY()/16 ==m.getY()/16) {
			m.decrementerPv(this.getTirer());
		}
	}

}
