package src.modele.acteur;

import java.util.ArrayList;

import javax.swing.JOptionPane;


import src.application.vue.VueTerrain;
import src.modele.acteur.Dragon;
import src.modele.armes.Arc;
import src.modele.armes.Arme;
import src.modele.armes.Epee;
import src.modele.armes.Feu;
import src.modele.armes.Pistolet;
import src.modele.items.Items;
import src.modele.items.Potion;
import src.modele.Environnement;
import src.modele.Terrain;
import src.modele.Terrain;

public class Link extends Acteur {
private Items i;
	public Link(Environnement env) {
		super("Link", "poignard", 4, 48, 356, 536, env);

	}

	public void boirePotion() {
		for (Items i : this.env.getItems()) {
			System.out.println("potion"+i);
			if((i instanceof Potion )&& (i.getX() / 16 == this.getX() / 16 && i.getY() / 16 == this.getY() / 16)) {
				this.setPTV(50);
				this.env.getItems().remove(i);
				this.env.getItems().add(null);
			}
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



	@Override
	public void attaque() {
		System.out.println("link attaque");
		for (Acteur m : this.TrouverEnnemi()) {
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
				if (m.getPtv() <= 0) {
					this.env.getArmes().remove(this.env.trouverArc());
					//this.env.getArmes().add(null);
				}
			}
			if (m instanceof Dragon) {
				System.out.println("Link attaque dragon");
				m.decrementerPv(this.getPointsATT());
				System.out.println("link"+this.getPtv());
				this.decrementerPv(m.getPointsATT());
				System.out.println("point de vie dragon:" + m.getPtv());
				if (m.getPtv() <= 0) {
					this.env.getArmes().remove(this.env.trouverFeu());
					this.env.getArmes().add(null);
					System.out.println(this.env.trouverFeu());
			}
				
			}
			if (m.getPtv() <= 0) {
				System.out.println("ennemi mort");
				this.env.getActeurs().remove(m);
				//this.env.getActeurs().add(null);
				this.env.nbMortsProperty().setValue(this.env.nbMortsProperty().getValue() + 1);
				this.env.nbpieceProperty().setValue(this.env.nbpieceProperty().getValue() + 1);
				if (this.env.getnbMorts() == 4) {
					JOptionPane.showMessageDialog(null, "Felicitation vous avez gagne");
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

			if (m instanceof Gobelin || m instanceof Loup || m instanceof Archers|| m instanceof Dragon ) {

				if ((this.getY() - 5 <= m.getY() && m.getY() <= this.getY() + 5)
						&& (this.getX() - 5 <= m.getX() && m.getX() <= this.getX() + 5)) {
					ListeDesActeursTrouves.add(m);
				}

			}
		}

		return ListeDesActeursTrouves;

	}
	public boolean acheterPistolet() {
		if (this.scannerAlentours()==1) {
		if (this.env.getnbpi�cedor()>=1) {
			this.env.discussionProperty().setValue("je prends Ce pistolet Merci");
			this.env.nbpieceProperty().setValue(this.env.nbpieceProperty().getValue() - 1);
			for (Arme m : this.env.getArmes()) {
				if (m instanceof Epee) {
					m.setX(this.getX());
					m.setY(this.getY());
				}
			}
			this.prendreArme();
			return true;

		}
		if (this.env.getnbpi�cedor()<1) {
			this.env.discussionProperty().setValue("Link n'a pas assez d'argents !!!");
		}
		}
		return false;
	}
	public int scannerAlentours() {
        for (Acteur m : this.env.getActeurs()) {
		 if (m instanceof Vendeur) {
	            if (m.getX() / 16 == this.getX() / 16 && m.getY() / 16 == this.getY() / 16) {
	                return 1;
	            }
	        }
	        if(m instanceof Princesse) {
	        	System.out.println(m);
	            if (m.getX() / 16 == this.getX() / 16 && m.getY() / 16 == this.getY() / 16) {
	                return 2;
	            }
	        }
	    }
	    return 0;
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