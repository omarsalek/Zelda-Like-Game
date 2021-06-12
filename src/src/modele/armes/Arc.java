package src.modele.armes;

import javax.swing.JOptionPane;

import src.modele.Environnement;
import src.modele.acteur.Link;

public class Arc extends Arme {
	public Arc(Environnement env) {
		super("Arc", 100, 310, 4, 6, env);

	}
	public void TirerDepuisArc(Link m) {
		this.setX(this.getX() + 16);
		if (this.getX() > 400) {
			this.setX(100);
		}
		if (this.getX()/16 == m.getX()/16 && this.getY()/16 ==m.getY()/16) {
			m.decrementerPv(this.getTirer());
		}
		if (m.getPtv()<=0) {
			JOptionPane.showMessageDialog(null, "Game Over");
			
		}
	}



}