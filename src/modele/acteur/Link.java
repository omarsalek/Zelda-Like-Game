package src.modele.acteur;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import src.application.vue.VueMap;
//import src.application.vue.VueTerrain;
import src.modele.Arc;
import src.modele.Arme;
import src.modele.Environnement;
import src.modele.Epee;
import src.modele.Map;
import src.modele.Map2;
import src.modele.Terrain;

public class Link extends Acteur {
	public Link(Environnement env) {
		super("Link", "poignard", 4, 50, 356, 303, env);

	}

	public void DeplacerLinkRight(Map t) {

		if (VueMap.collisions(t.lireFichier()[this.getY() / 16 ][(this.getX() / 16 + 1)])
				|| this.collisionEntreLinkEtEnnemis(t) == true) {
			this.setX(this.getX() - 1);
		} else {
			this.setX(this.getX() + 1);
			System.out.println("x" + getX());
			System.out.println("y" + getY());
		}
	}

	public void DeplacerLinkLeft(Map t) {

		if (VueMap.collisions(t.lireFichier()[this.getY() / 16 ][(this.getX() / 16 )])
				|| this.collisionEntreLinkEtEnnemis(t) == true) {
			this.setX(this.getX() + 1);

		} else {

			this.setX(this.getX() - 1);
		}
		System.out.println("x" + getX());
		System.out.println("y" + getY());

	}

	public void DeplacerLinkUP(Map t) {
		if (VueMap.collisions(t.lireFichier()[this.getY() / 16][(this.getX() / 16)])
				|| this.collisionEntreLinkEtEnnemis(t) == true) {
			this.setY(this.getY() + 1);
		} else {
			this.setY(this.getY() - 1);
			System.out.println("x" + getX());
			System.out.println("y" + getY());
		}

	}

	public void DeplacerLinkDown(Map t) {

		if (VueMap.collisions(t.lireFichier()[this.getY() / 16 +1][(this.getX() / 16)])
				|| this.collisionEntreLinkEtEnnemis(t) == true) {
			// position dans le terrain
			this.setY(this.getY() - 1);
		} else {
			this.setY(this.getY() + 1);
			System.out.println("x" + getX());
			System.out.println("y" + getY());

		}
	}

	public Boolean prendreArme() {
		System.out.println("Link essayes de prendre l'arme");
		System.out.println("link pointsATT avant  : " + this.getPointsATT());
		for (Arme m : this.env.getArmes()) {
			if ((m instanceof Epee) && (m.getX() / 16 == this.getX() / 16 && m.getY() / 16 == this.getY() / 16)) {
				this.setPointsATT(m.getPointsAttrme());
				this.env.getArmes().remove(m);
				//this.env.getActeurs().remove(this);
				System.out.println("link pointsATT apres : " + this.getPointsATT());
				return true;
			} else {
				return false;
			}
		}
		return null;
	}

	private Arme trouverArme() {
		for (Arme m : this.env.getArmes()) {
			if (m instanceof Arc) {
				return m;
			}

		}

		return null;

	}

	public boolean collisionEntreLinkEtEnnemis(Map t) {
		for (Acteur m : this.env.getActeurs()) {
			if (m instanceof Gobelin || m instanceof Loup || m instanceof Archers) {
				if (m.getX() / 16 == this.getX() / 16 && m.getY() / 16 == this.getY() / 16) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void attaque() {
		System.out.println("link attaque");
		for (Acteur m : this.TrouverEnnemi()) {
			System.out.println("en" + m);
			if (m instanceof Gobelin) {
				System.out.println("Link attaque gobelin");
				m.decrementerPv(this.getPointsATT());
				this.decrementerPv(m.getPointsATT());
				System.out.println("point de vie Gobelin :" + m.getPtv());
			}
			if (m instanceof Loup) {
				System.out.println("Link attaque loup");
				m.decrementerPv(this.getPointsATT());
				this.decrementerPv(m.getPointsATT());
				System.out.println("point de vie loup :" + m.getPtv());
			}
			if (m instanceof Archers) {
				System.out.println("Link attaque Archer");
				m.decrementerPv(this.getPointsATT());
				this.decrementerPv(m.getPointsATT());
				System.out.println("point de vie Archer :" + m.getPtv());
				if (m.getPtv() == 0) {
					this.env.getArmes().remove(this.trouverArme());
					this.env.getArmes().add(null);
				}

			}
			if (m.getPtv() == 0) {
				System.out.println("ennemi mort");
				this.env.getActeurs().remove(m);

				// this.env.getArmes().remove(this.TrouverArme());
				this.env.nbMortsProperty().setValue(this.env.nbMortsProperty().getValue() + 1);
				if (this.env.getnbMorts() == 4) {
					JOptionPane.showMessageDialog(null, "Félicitation vous avez gagné");
				}

			}

		}
		if (this.getPtv() <= 0) {
			JOptionPane.showMessageDialog(null, "Link mort");
		}

	}

	private ArrayList<Acteur> TrouverEnnemi() {
		ArrayList<Acteur> ListeDesActeursTrouvés = new ArrayList<Acteur>();
		for (Acteur m : this.env.getActeurs()) {

			if (m instanceof Gobelin || m instanceof Loup || m instanceof Archers) {

				if ((this.getY() - 5 <= m.getY() && m.getY() <= this.getY() + 5)
						|| (this.getX() - 5 <= m.getX() && m.getX() <= this.getX() + 5)) {
					ListeDesActeursTrouvés.add(m);
				}

			}
		}

		return ListeDesActeursTrouvés;

	}


	@Override
	public void seFaitAttaquer() {
		// this.getPtv() = this.getPTV() - ennemis.getPointsATT;
	}

	@Override
	public String toString() {
		return "Link [" + super.toString() + "]";
	}

}
