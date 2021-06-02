package src.modele;

import src.modele.acteur.Link;

public class Arc extends Arme {
	public Arc(Environnement env) {
		super("Arc", 100, 310, 4, 6, env);

	}

	public void TirerDepuisArc(Link L) {
		// mouvement=mouvement+16;
		this.setX(this.getX() + 16);
		if (this.getX() > 500) {
			this.setX(100);
		}
//		System.out.println("fleche" + this.getX());
//		System.out.println("link" + L.getX());
		if (this.getX()/16 == L.getX()/16 && this.getY()/16 ==L.getY()/16) {
			L.decrementerPv(this.getTirer());
		}
	}




}
