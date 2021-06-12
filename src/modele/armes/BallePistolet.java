package src.modele.armes;

import src.modele.Environnement;
import src.modele.acteur.Acteur;
import src.modele.acteur.Archers;
import src.modele.acteur.Gobelin;
import src.modele.acteur.Link;
import src.modele.acteur.Loup;

public class BallePistolet extends Arme {

	public BallePistolet(Environnement env) {
		super("Bullet", 356, 536, 4, 6, env);

	}

	public void tirer(Link m) {
	//Pour déterminer dans quelle direction on va tirer, on utilise le int qu'on a set dans les meéthodes se déplacer
		if (this.env.getDirection() == 1) {
			this.setX(this.getX() + 16);
			if (this.getX() > 900) {
				this.setX(m.getX());
				this.setY(m.getY());
				this.env.setLinkTire(false);
			}
		}
		if (this.env.getDirection() == 2) {
			this.setY(this.getY() + 16);
			if (this.getY() > 600) {
				this.setY(m.getY());
				this.env.setLinkTire(false);
			}
		}
		if (this.env.getDirection() == 3) {
			this.setX(this.getX() - 16);
			if (this.getX() < 100) {
				this.setX(m.getX());
				this.env.setLinkTire(false);

			}
		}
		if (this.env.getDirection() == 4) {
			this.setY(this.getY() - 16);
			if (this.getY() < 100) {
				this.setY(m.getY());
				this.env.setLinkTire(false);
			}
		}
		for (Acteur ennemie : this.env.getActeurs()) {
			if ((ennemie instanceof Loup || ennemie instanceof Gobelin || ennemie instanceof Archers)
					&& this.getX() / 16 == ennemie.getX() / 16 && this.getY() / 16 == ennemie.getY() / 16) {
				if (ennemie.getPtv() >= 0) { // exception
					ennemie.decrementerPv(this.getTirer());
				}

			} else {
				System.out.println("Pas d'ennemi a proximite");
			}

		}
	}

}
