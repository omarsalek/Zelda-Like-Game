package src.modele.armes;

import javax.swing.JOptionPane;

import src.modele.Environnement;
import src.modele.acteur.Acteur;
import src.modele.acteur.Archers;
import src.modele.acteur.Dragon;
import src.modele.acteur.Gobelin;
import src.modele.acteur.Link;
import src.modele.acteur.Loup;

public class BulletPisolet extends Arme {

	public BulletPisolet(Environnement env) {
		super("Bullet", 356, 536, 4, 9, env);

	}

	public void TirerDepuisPistolet(Link m) {

		if (this.env.getDetecterPoSTirage() == 1) {
			this.setX(this.getX() + 16);// droit
			if (this.getX() > 900) {
				this.setX(m.getX());
				this.setY(m.getY());
				this.env.setTirerDepuisLink(false);

			}
		}
		if (this.env.getDetecterPoSTirage() == 2) {
			this.setY(this.getY() + 16); // bas
			if (this.getY() > 600) {
				this.setY(m.getY());
				this.env.setTirerDepuisLink(false);
			}
		}
		if (this.env.getDetecterPoSTirage() == 3) {// gauche
			this.setX(this.getX() - 16);
			if (this.getX() < 100) {
				this.setX(m.getX());
				this.env.setTirerDepuisLink(false);

			}
		}
		if (this.env.getDetecterPoSTirage() == 4) {// haut
			this.setY(this.getY() - 16);
			if (this.getY() < 100) {
				this.setY(m.getY());
				this.env.setTirerDepuisLink(false);
			}
		}
		for (Acteur ennemie : this.env.getActeurs()) {
			if ((ennemie instanceof Loup || ennemie instanceof Gobelin || ennemie instanceof Archers)
					&& this.getX() / 16 == ennemie.getX() / 16 && this.getY() / 16 == ennemie.getY() / 16) {
				if (ennemie.getPtv() >= 0) {// exception
					ennemie.decrementerPv(this.getTirer());
				}

			} else {
				System.out.println("pas Ennemie a coté");

			}

		}
	}

}
