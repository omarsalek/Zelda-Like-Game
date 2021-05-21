package src.modele;

import javax.swing.JOptionPane;

import src.application.vue.VueTerrain;

public class Link extends Acteur {
//    private Terrain terrain ;
	public Link(Environnement env) {
		super("Link", "poignard", 4, 20, 415,303, env);
	}

	public void DeplacerLinkRight(Terrain T) {
		if (VueTerrain.pasbouger(T.getCarte()[this.getY() / 16][(this.getX() / 16 + 2)])) {
			System.out.println(T.getCarte()[getY() / 16][(getX() / 16)]); // afficher la position dans le tgerrain
			this.setX(this.getX() - 16);
		} else {
			this.setX(this.getX() + 16);
			System.out.println("x" + getX());
			System.out.println("y" + getY());

		}
	}
//		if (this.env.estDansleTerrain(this.getX(), this.getY())) {
//			this.setX(this.getX() + 16);
//
//		} else {
//			this.setX(this.getX() - 16);
//
//		}
//		System.out.println("x" + this.getX());
//		System.out.println("y" + this.getY());
//
//	}

	public void DeplacerLinkLeft(Terrain T) {

//		if (this.env.estDansleTerrain(this.getX(), this.getY())){
//			this.setX(this.getX()-1);
//			System.out.println("x"+this.getX());
//			System.out.println("y"+this.getY());
//		}
//		else {
//			this.setX(this.getX()+1);
//
//		}
		if (VueTerrain.pasbouger(T.getCarte()[this.getY() / 16][(this.getX() / 16)])) {
			System.out.println(T.getCarte()[getY() / 16][(getX() / 16)]); // afficher la position dans le tgerrain
			this.setX(this.getX() + 16);
		} else {
			this.setX(this.getX() - 16);
			System.out.println("x" + getX());
			System.out.println("y" + getY());

		}
	}

	public void DeplacerLinkUP(Terrain t) {
		if (VueTerrain.pasbouger(t.getCarte()[this.getY() / 16][(this.getX() / 16)])) {
			System.out.println(t.getCarte()[getY() / 16][(getX() / 16)]); // afficher la position dans le tgerrain
			this.setY(this.getY() + 16);
		} else {
			this.setY(this.getY() - 16);
			System.out.println("x" + getX());
			System.out.println("y" + getY());
		}
//	this.setY(this.getY()-16);
//		if (this.env.estDansleTerrain(this.getX(), this.getY())) {
//			this.setY(this.getY() - 1);
//		} else {
//			this.setY(this.getY() + 1);
//
//		}
//		System.out.println("x" + getX());
//		System.out.println("y" + getY());

//		if (this.env.estDansleTerrain(-this.getX(), this.getY())){
//			this.setY(this.getY()+16);
//			System.out.println("x"+this.getX());
//			System.out.println("y"+this.getY());
//		}
//		else {
//			this.setY(this.getY()-16);
//
//		}
//		int nposY = this.getY() - 16;
//		this.setY(nposY);
//		System.out.println("x"+this.getX());
//		System.out.println("y"+this.getY());

	}

	public void DeplacerLinkDown(Terrain t) {

		if (VueTerrain.pasbouger(t.getCarte()[this.getY() / 16 +1][(this.getX() / 16)])) {
			System.out.println(t.getCarte()[getY() / 16][(getX() / 16)]); // afficher la position dans le tgerrain
			this.setY(this.getY() - 16);
		} else {
			this.setY(this.getY() + 16);
			System.out.println("x" + getX());
			System.out.println("y" + getY());

		}

//		if (this.env.estDansleTerrain(this.getX(), this.getY())) {
//			this.setY(this.getY() + 16);
//		} else {
//			this.setY(this.getY() - 16);
//
//		}
//		int nposY = this.getY() + 16;
//		this.setY(nposY);
		System.out.println("x" + this.getX());
		System.out.println("y" + this.getY());
	}

	@Override
	public boolean attaque() {

		boolean mort = false;
		Acteur m = this.TrouverEnnemi();

		if (m != null) {
			System.out.println("Link attaque un Gobelin");
			m.decrementerPv(this.getPointsATT());
			this.decrementerPv(m.getPointsATT());

			System.out.println("Points de vie de Link est : " + this.getPtv());
			if (m.getPtv() == 0) {
				System.out.println("Gobelin mort");
				this.env.getActeurs().remove(m);
				mort = true;
			}
			if (this.getPtv() == 0) {
				JOptionPane.showMessageDialog(null, "Link mort");

			}

		} else {
			System.out.println("il n'ya pas de gobelin à coté ");
		}

		return mort;
	}

	private Acteur TrouverEnnemi() {

		// on regarde s'il y a un Gobelin a moins de 4 pixels de lui.
		for (Acteur m : this.env.getActeurs()) {
			if (m instanceof Gobelin) {
				if ((this.getY() - 6 <= m.getY() && m.getY() <= this.getY() + 6)
						|| (this.getX() - 6 <= m.getX() && m.getX() <= this.getX() + 6)) {
					return m;
				}
			}
		}
		return null;
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
