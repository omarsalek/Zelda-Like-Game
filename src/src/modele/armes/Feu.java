package src.modele.armes;

import javax.swing.JOptionPane;

import src.modele.Environnement;
import src.modele.acteur.Link;

public class Feu extends Arme{

	public Feu( Environnement env) {
		super("feu", 730, 264, 4, 8, env);
	}
	public void TirerDepuisdragon(Link m) {
		int val = (int) (1+ Math.random()*(200));
		this.setY(this.getY() + val);
		if (this.getY() > 500) {
			this.setY(264);
		}
		if (this.getX()/16 == m.getX()/16 && this.getY()/16 ==m.getY()/16) {
			m.decrementerPv(this.getTirer());
		}
		if (m.getPtv() <= 0) {
			JOptionPane.showMessageDialog(null, "Game Over");
		}
	}

}