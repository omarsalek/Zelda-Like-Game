package src.modele.armes;

import src.modele.Environnement;
import src.modele.acteur.Link;

public class Pistolet extends Arme  {
	public Pistolet(Environnement env) {
		super("pistolet", 400, 520, 8, 4, env);
		
	}
	
	public void TirerDepuispistolet(Link m) {
		this.setX(this.getX() + 1);
		if (this.getX() > 600) {
			this.setX(100);
		}
		if (this.getX()/16 == m.getX()/16 && this.getY()/16 ==m.getY()/16) {
			m.decrementerPv(this.getTirer());
		}
	}
}