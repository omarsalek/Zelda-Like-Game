package src.modele;

import java.util.ArrayList;

import javax.swing.JOptionPane; 

import src.application.vue.VueTerrain;

public class Link extends Acteur {

	public Link(Environnement env) {
		super("Link", "poignard", 4, 50, 356, 303, env);
	}

	public void DeplacerLinkRight(Terrain T) {
		if (VueTerrain.collisionsTuiles(T.getCarte()[this.getY() / 16][(this.getX() / 16 + 2)])) {
			this.setX(this.getX() - 16);
		} else {
			this.setX(this.getX() + 16);
			System.out.println("x" + getX());
			System.out.println("y" + getY());
		}
	}

	public void DeplacerLinkLeft(Terrain T) {

		if (VueTerrain.collisionsTuiles(T.getCarte()[this.getY() / 16][(this.getX() / 16)])) {
			this.setX(this.getX() + 16);

		} else {

			this.setX(this.getX() - 16);
		}
		System.out.println("x" + getX());
		System.out.println("y" + getY());

	}

	public void DeplacerLinkUP(Terrain t) {
		if (VueTerrain.collisionsTuiles(t.getCarte()[this.getY() / 16][(this.getX() / 16)])) {
			this.setY(this.getY() + 16);
		} else {
			this.setY(this.getY() - 16);
			System.out.println("x" + getX());
			System.out.println("y" + getY());
		}

	}

	public void DeplacerLinkDown(Terrain t) {

		if (VueTerrain.collisionsTuiles(t.getCarte()[this.getY() / 16 + 1][(this.getX() / 16)])) {
			// position dans le terrain
			this.setY(this.getY() - 16);
		} else {
			this.setY(this.getY() + 16);
			System.out.println("x" + getX());
			System.out.println("y" + getY());

		}
	}

	@Override
	public void prendreArme() {
		System.out.println("Link essayes de prendre l'arme");
		System.out.println("link pt avant " + this.getPointsATT());
		Arme m = this.TrouverArme();
		if (m instanceof Epee) {

			this.setPointsATT(m.getPointsAttrme());
			this.env.getArmes().remove(m);

		}

		System.out.println("link pt apres " + this.getPointsATT());
	}

	private Arme TrouverArme() {
		for (Arme m : this.env.getArmes()) {
			if (m instanceof Epee || m instanceof Arc) {
				if ((this.getY() - 5 <= m.getY() && m.getY() <= this.getY() + 5)
						|| (this.getX() - 5 <= m.getX() && m.getX() <= this.getX() + 5)) {
					return m;
				}

			}
		}

		return null;

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
				
			}
			if (m.getPtv() == 0) {
				System.out.println("ennemi mort");
				this.env.getActeurs().remove(m);
				this.env.getArmes().remove(this.TrouverArme());
				this.env.nbMortsProperty().setValue(this.env.nbMortsProperty().getValue() + 1);

			}

		}
	if(this.getPtv()<=0)
	{
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
	public void seDeplace() {

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
