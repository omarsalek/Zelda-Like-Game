package src.modele.acteur;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import src.application.vue.VueMap;
//import src.application.vue.VueTerrain;
import src.modele.Arc;
import src.modele.Arme;
import src.modele.Dragon;
import src.modele.Environnement;
import src.modele.Epee;
import src.modele.Feu;
import src.modele.Map;
import src.modele.Map2;
import src.modele.Pistolet;
import src.modele.Terrain;

public class Link extends Acteur {
	public Link(Environnement env) {
		super("Link", "poignard", 4, 50, 356, 303, env);

	}

	public void DeplacerLinkRight(Map2 t) {
		// DEPLACER DANS ACTEUR ET NE PAS RECEVOIR LA MAP EN PARAMÈTRE

		if (VueMap.collisions(t.lireFichier()[this.getY() / 16 ][(this.getX() / 16 + 1)])
				|| this.collisionEntreLinkEtEnnemis(t) == true) {
			this.setX(this.getX() - 16);
		} else {
			this.setX(this.getX() + 16);
			System.out.println("x" + getX());
			System.out.println("y" + getY());
		}
	}

	public void DeplacerLinkLeft(Map2 t) {

		if (VueMap.collisions(t.lireFichier()[this.getY() / 16 ][(this.getX() / 16 )])
				|| this.collisionEntreLinkEtEnnemis(t) == true) {
			this.setX(this.getX() + 16);

		} else {

			this.setX(this.getX() - 16);
		}
		System.out.println("x" + getX());
		System.out.println("y" + getY());

	}

	public void DeplacerLinkUP(Map2 t) {
		if (VueMap.collisions(t.lireFichier()[this.getY() / 16][(this.getX() / 16)])
				|| this.collisionEntreLinkEtEnnemis(t) == true) {
			this.setY(this.getY() + 16);
		} else {
			this.setY(this.getY() - 16);
			System.out.println("x" + getX());
			System.out.println("y" + getY());
		}

	}

	public void DeplacerLinkDown(Map2 t) {

		if (VueMap.collisions(t.lireFichier()[this.getY() / 16 +1][(this.getX() / 16)])
				|| this.collisionEntreLinkEtEnnemis(t) == true) {
			// position dans le terrain
			this.setY(this.getY() - 16);
		} else {
			this.setY(this.getY() + 16);
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
	public Boolean prendrepistolet() {
		System.out.println("Link essayes de prendre le pistolet");
		System.out.println("link pointsATT avant  : " + this.getPointsATT());
		for (Arme m : this.env.getArmes()) {
			if ((m instanceof Pistolet) && (m.getX() / 16 == this.getX() / 16 && m.getY() / 16 == this.getY() / 16)) {
				this.setPointsATT(m.getPointsAttrme());
				this.env.getArmes().remove(m);
				
				this.env.getArmes().add(null);
				System.out.println("link pointsATT apres : " + this.getPointsATT());
				return true;
			} else {
				return false;
			}
		}
		return null;
	}

//	private ArrayList<Arme>trouverArme() {
//		ArrayList<Arme> Listearmetrouves = new ArrayList<Arme>();
//	
//		for (Arme m : this.env.getArmes()) {
//		if(m instanceof Arc || m instanceof Feu ) {
//			Listearmetrouves.add(m) ;
//			
//			
//		}
//				return  Listearmetrouves;
//			
//
//		}
//
//		return null;
//
//	}
	private Arme TrouverArc() {
        for (Arme m : this.env.getArmes()) {
            if (m instanceof Arc) {

                return m;
            }
        }
		return null;
	}

	private Arme TrouverFeu() {
        for (Arme m : this.env.getArmes()) {
            if (m instanceof Feu) {

                return m;
            }

        }
		return null;
	}
	public boolean collisionEntreLinkEtEnnemis(Map2 t) {
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
					this.env.getArmes().remove(this.TrouverArc());
					this.env.getArmes().add(null);
				}
			}
			if (m instanceof DragoN) {
				System.out.println("Link attaque dragon");
				m.decrementerPv(this.getPointsATT());
				this.decrementerPv(m.getPointsATT());
				System.out.println("point de vie dragon:" + m.getPtv());
				if (m.getPtv() == 0) {
					this.env.getArmes().remove(this.TrouverFeu());
					this.env.getArmes().add(null);
				
			
			}
				
			}
			if (m.getPtv() == 0) {
				System.out.println("ennemi mort");
				this.env.getActeurs().remove(m);

				// this.env.getArmes().remove(this.TrouverArme());
				this.env.nbMortsProperty().setValue(this.env.nbMortsProperty().getValue() + 1);
				this.env.nbpieceProperty().setValue(this.env.nbpieceProperty().getValue() + 1);
				if (this.env.getnbMorts() == 4) {
					JOptionPane.showMessageDialog(null, "F�licitation vous avez gagn�");
				}

			}
			
		
		
		if (this.getPtv() <= 0) {
			JOptionPane.showMessageDialog(null, "Link mort");
		}
		}

	}

	private ArrayList<Acteur> TrouverEnnemi() {
		ArrayList<Acteur> ListeDesActeursTrouves = new ArrayList<Acteur>();
		for (Acteur m : this.env.getActeurs()) {

			if (m instanceof Gobelin || m instanceof Loup || m instanceof Archers|| m instanceof DragoN) {

				if ((this.getY() - 5 <= m.getY() && m.getY() <= this.getY() + 5)
						|| (this.getX() - 5 <= m.getX() && m.getX() <= this.getX() + 5)) {
					ListeDesActeursTrouves.add(m);
				}

			}
		}

		return ListeDesActeursTrouves;

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
