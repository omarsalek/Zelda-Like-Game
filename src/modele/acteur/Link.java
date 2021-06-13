package src.modele.acteur;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import src.modele.armes.Arme;
import src.modele.armes.Epee;
import src.modele.items.Item;
import src.modele.items.Potion;
import src.modele.Environnement;

public class Link extends Acteur {

	private boolean linkAchete = false;
	
	public Link(Environnement env) {
		super("Link", "poignard, Aucune munition", 4, 50, 83, 47, env);
	}

	public boolean getLinkAchete() {
		return linkAchete;
	}

	public void setLinkAchete(boolean val) {
		this.linkAchete = val;
	}
	
	
	public boolean boirePotion() {
		for (Item i : this.env.getItems()) {
			if ((i instanceof Potion) && ((this.getY() - 32 <= i.getY() && i.getY() <= this.getY() + 32)
					|| (this.getX() - 32 <= i.getX() && i.getX() <= this.getX() + 32))) {
				this.setPTV(50);
				this.env.getItems().remove(i);
				this.env.getItems().add(null);
				return true;
			}
		}
		return false;
	}

	public Boolean prendreEpee() {
		System.out.println("Link essayes de prendre l'epee");
		System.out.println("link pointsATT avant  : " + this.getPointsATT());
		for (Arme m : this.env.getArmes()) {
			if ((m instanceof Epee) && ((this.getY() - 16 <= m.getY() && m.getY() <= this.getY() + 16)
					|| (this.getX() - 16 <= m.getX() && m.getX() <= this.getX() + 16))) {
				this.setPointsATT(m.getPointsAttrme());
				this.env.getArmes().remove(m);
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
		for (Acteur m : this.scanEnnemis()) {
			try {
				if (m instanceof Gobelin || m instanceof Loup || m instanceof Archers || m instanceof Dragon) {
					System.out.println("Link attaque " + m.getId());
					m.decrementerPv(this.getPointsATT());
					this.decrementerPv(m.getPointsATT());
					System.out.println("Points de vie de Link : " + this.getPtv());
					System.out.println("Points de vie de " + m.getNom() +" : "+ + m.getPtv());
				}
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, "Approchez vous d'un ennemi pour l'attaquer");
			}
			if(this.getPtv()<=0) {
				JOptionPane.showMessageDialog(null, "Link est mort !");
			}
		}
	}

	private ArrayList<Acteur> scanEnnemis() {
		ArrayList<Acteur> ListeDesActeursTrouves = new ArrayList<Acteur>();
		for (Acteur m : this.env.getActeurs()) {
			if (m instanceof Gobelin || m instanceof Loup || m instanceof Archers || m instanceof Dragon) {
				if ((this.getY() - 32 <= m.getY() && m.getY() <= this.getY() + 32)
						&& (this.getX() - 32 <= m.getX() && m.getX() <= this.getX() + 32)) {
					ListeDesActeursTrouves.add(m);
				}
			}
		}
		return ListeDesActeursTrouves;
	}

	public boolean acheterPistolet() {
		if (this.scanInteraction() == 1) {
			try {
				if (this.env.getnbpiecedor() >= 3) {
					this.env.discussionProperty().setValue("Merci !");
					this.env.nbpieceProperty().setValue(this.env.nbpieceProperty().getValue() - 4);
					return true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Pas assez de pièces d'or !");
			}
		}
		if (this.env.getnbpiecedor() < 3) {
			this.env.discussionProperty().setValue("Link n'a pas assez de PC");
		}
		return false;
	}

	public int scanInteraction() {
		for (Acteur m : this.env.getActeurs()) {
			if (m instanceof Vendeur) {
				if (m.getX() / 16 == this.getX() / 16 && m.getY() / 16 == this.getY() / 16) {
					return 1;
				}
			}
			if (m instanceof Princesse) {
				System.out.println(m);
				if (m.getX() / 16 == this.getX() / 16 && m.getY() / 16 == this.getY() / 16) {
					return 2;
				}
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Link [" + super.toString() + "]";
	}

}